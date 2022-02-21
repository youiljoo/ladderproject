package com.mycompany.teamproject.admin.goods.controller;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.teamproject.admin.goods.service.AdminGoodsService;
import com.mycompany.teamproject.board.vo.PagingVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.common.base.BaseController;
import com.mycompany.teamproject.goods.vo.GoodsVO;
import com.mycompany.teamproject.goods.vo.ImageFileVO;
import com.mycompany.teamproject.member.vo.MemberVO;



@Controller("AdminGoodsController")
public class AdminGoodsControllerImpl extends BaseController implements AdminGoodsController {
		private static final String CURR_IMAGE_REPO_PATH="C:\\ladder\\image";
		@Autowired
		private AdminGoodsService service;
		
		@Autowired
		private GoodsVO vo;
	
		
		// 상품 관리
		
		// 1. 리스트
		
		@Override
		@RequestMapping(value="/admin_prod.do" ,method = RequestMethod.GET)
		public ModelAndView AllGoods(SearchCriteriaVO scri,HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			
			
			// 상품 리스트 (검색, 페이징 추가)
			
		        int AllGoodsListCnt = service.AllGoodsListCnt(scri);
		         
		      
		        PagingVO paging = new PagingVO();
		        paging.setCri(scri);
		        paging.setTotalCount(AllGoodsListCnt);    
		        	        
		        
		        //String viewName=(String)request.getAttribute("viewName");
		        List<Map<String, Object>> list = service.AllGoodsList(scri);
		        ModelAndView mav=new ModelAndView("admin_prod");
		     
		        mav.addObject("list", list);   
		        mav.addObject("paging", paging);
			
			
			return mav;
		}
		// 2. 상품 상세
		
		@Override
		@RequestMapping(value="/admin_prod_de.do",method={RequestMethod.GET,RequestMethod.POST})
		public ModelAndView GoodsDetail(@RequestParam("productNum") int productNum,HttpServletRequest request,HttpServletResponse response)throws Exception{
		
			Map proMap=service.GoodsDetail(productNum);
			ModelAndView mav=new ModelAndView();
			mav.setViewName("admin_prod_de");
			mav.addObject("proMap", proMap);
			return mav;
		}
		
		// 3. 상품 등록
		@Override
		@RequestMapping(value="/admin_prod_add.do", method=RequestMethod.GET)
		public String add_newGoods(HttpServletRequest request,HttpServletResponse response) throws Exception{					
			return "admin_prod_add";
		}
		
		@Override
		@RequestMapping(value="/admin_prod_add.do" ,method = RequestMethod.POST)
		public ResponseEntity addNewGoods(@RequestParam("category")String category,MultipartHttpServletRequest multipartRequest, HttpServletResponse response)throws Exception {
			multipartRequest.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=UTF-8");
			String imageFileName=null;
			
			
			Map newGoodsMap = new HashMap();
			Enumeration enu=multipartRequest.getParameterNames();
			while(enu.hasMoreElements()){
				String name=(String)enu.nextElement();
				String value=multipartRequest.getParameter(name);
				newGoodsMap.put(name,value);
				
			}
			
			HttpSession session = multipartRequest.getSession();
			MemberVO memberVO = (MemberVO) session.getAttribute("memberInfo");
			
			String reg_id = memberVO.getUser_id();					
			System.out.println(reg_id);
			
			newGoodsMap.put("category", category);
			System.out.println(category);
			
			
			List<ImageFileVO> imageFileList =upload(multipartRequest);
			System.out.println("imageFileList:"+imageFileList);
			if(imageFileList!= null && imageFileList.size()!=0) {
				for(ImageFileVO imageFileVO : imageFileList) {
					imageFileVO.setReg_id(reg_id);	//등록자 id
					
					
					
				}
				newGoodsMap.put("imageFileList", imageFileList);
			
				System.out.println("이미지 파일 리스트 완료 :"+imageFileList);
				
			}
			
			String message = null;
			ResponseEntity resEntity = null;
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "text/html; charset=utf-8");
			try {
				int productNum = service.addNewGoods(newGoodsMap);
				if(imageFileList!=null && imageFileList.size()!=0) {
					for(ImageFileVO  imageFileVO:imageFileList) {
						imageFileName = imageFileVO.getFileName();
						File srcFile = new File(CURR_IMAGE_REPO_PATH+"\\"+"temp"+"\\"+imageFileName);
						File destDir = new File(CURR_IMAGE_REPO_PATH+"\\"+category+"\\"+productNum);
						FileUtils.moveFileToDirectory(srcFile, destDir,true);
					}
				}
				message= "<script>";
				message += " alert('새상품을 추가했습니다.');";
				message +=" location.href='"+multipartRequest.getContextPath()+"/admin_prod.do';";
				message +=("</script>");
			}catch(Exception e) {
				if(imageFileList!=null && imageFileList.size()!=0) {
					for(ImageFileVO  imageFileVO:imageFileList) {
						imageFileName = imageFileVO.getFileName();
						File srcFile = new File(CURR_IMAGE_REPO_PATH+"\\"+"temp"+"\\"+imageFileName);
						srcFile.delete();
					}
				}
				
				message= "<script>";
				message += " alert('오류가 발생했습니다. 다시 시도해 주세요');";
				message +=" location.href='"+multipartRequest.getContextPath()+"/admin_prod.do';";
				message +=("</script>");
				e.printStackTrace();
			}
			resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
			return resEntity;
		}
		
		// 4. 상품 수정
		@Override
		@RequestMapping(value="/admin_prod_update.do",method= {RequestMethod.GET,RequestMethod.POST})
		public ModelAndView modifyGoodsForm(@RequestParam("productNum")int productNum,HttpServletRequest request,HttpServletResponse response)throws Exception{
			Map proMap=service.GoodsDetail(productNum);
			ModelAndView mav=new ModelAndView();
			mav.setViewName("admin_prod_update");
			mav.addObject("proMap", proMap);
			return mav;
		}
		
		@Override
		@RequestMapping(value="/admin_prod_update_action.do",method= {RequestMethod.POST})
		public ResponseEntity modifyGoodsInfo(@RequestParam("productNum")String productNum,@RequestParam("attribute")String attribute,
				@RequestParam("value")String value,HttpServletRequest request,HttpServletResponse response)throws Exception{
			Map<String,String> proMap=new HashMap<String,String>();
			proMap.put("productNum", productNum);
			proMap.put(attribute, value);
			service.modifyGoodsInfo(proMap);
			
			String message=null;
			ResponseEntity resEntity=null;
			HttpHeaders responseHeaders=new HttpHeaders();
			message="mod_success";
			resEntity=new ResponseEntity(message,responseHeaders,HttpStatus.OK);
			return resEntity;
		}
		
		
		
		
		@Override
		@RequestMapping(value="/admin_prodimage_update_action.do",method= {RequestMethod.POST})
		public void modifyGoodsImageInfo(@RequestParam("category")String category,
		MultipartHttpServletRequest multipartRequest,HttpServletResponse response)throws Exception{
			System.out.println("modifyGoodsImageInfo");
			multipartRequest.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			String imageFileName=null;
			
			Map proMap=new HashMap();
			Enumeration enu=multipartRequest.getParameterNames();
			while(enu.hasMoreElements()) {
				String name=(String)enu.nextElement();
				String value=multipartRequest.getParameter(name);
				proMap.put(name, value);
			}
			HttpSession session=multipartRequest.getSession();
			MemberVO memberVO =(MemberVO)session.getAttribute("memberInfo");
			String reg_id=memberVO.getUser_id();
			
			List<ImageFileVO> imageFileList=null;
			int productNum=0;
			int imageNum=0;
		
			try {
				imageFileList=upload(multipartRequest);
				if(imageFileList!=null && imageFileList.size()!=0) {
					for(ImageFileVO imageFileVO : imageFileList) {
						productNum=Integer.parseInt((String)proMap.get("productNum"));
						imageNum=Integer.parseInt((String)proMap.get("imageNum"));
					
						imageFileVO.setProductNum(productNum);
						imageFileVO.setImageNum(imageNum);
					
						imageFileVO.setReg_id(reg_id);
					}
					service.modifyGoodsImage(imageFileList);
					for(ImageFileVO imageFileVO:imageFileList) {
						imageFileName=imageFileVO.getFileName();
						File srcFile=new File(CURR_IMAGE_REPO_PATH+"\\"+"temp"+"\\"+imageFileName);
						File destDir=new File(CURR_IMAGE_REPO_PATH+"\\"+category+"\\"+productNum);
						FileUtils.moveFileToDirectory(srcFile, destDir, true);
					}
				}
			}catch(Exception e) {
					if(imageFileList!=null && imageFileList.size()!=0) {
						for(ImageFileVO imageFileVO:imageFileList) {
							imageFileName=imageFileVO.getFileName();
							File srcFile=new File(CURR_IMAGE_REPO_PATH+"\\"+"temp"+"\\"+imageFileName);
							srcFile.delete();
						}
					}
					e.printStackTrace();
				}
				
			}
		
		
		@Override
		@RequestMapping(value="/addNewGoodsImage.do" ,method={RequestMethod.POST})
		public void addNewGoodsImage(@RequestParam("category")String category,
				MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
				throws Exception{
			System.out.println("addNewGoodsImage");
			multipartRequest.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			String imageFileName=null;
			
			Map goodsMap = new HashMap();
			Enumeration enu=multipartRequest.getParameterNames();
			while(enu.hasMoreElements()){
				String name=(String)enu.nextElement();
				String value=multipartRequest.getParameter(name);
				goodsMap.put(name,value);
			}
			
			HttpSession session = multipartRequest.getSession();
			MemberVO memberVO = (MemberVO) session.getAttribute("memberInfo");
			String reg_id = memberVO.getUser_id();
			
			List<ImageFileVO> imageFileList=null;
			int productNum=0;
			try {
				imageFileList =upload(multipartRequest);
				if(imageFileList!= null && imageFileList.size()!=0) {
					for(ImageFileVO imageFileVO : imageFileList) {
						productNum = Integer.parseInt((String)goodsMap.get("productNum"));
						imageFileVO.setProductNum(productNum);
						imageFileVO.setReg_id(reg_id);
					}
					
				    service.addNewGoodsImage(imageFileList);
					for(ImageFileVO  imageFileVO:imageFileList) {
						imageFileName = imageFileVO.getFileName();
						File srcFile = new File(CURR_IMAGE_REPO_PATH+"\\"+"temp"+"\\"+imageFileName);
						File destDir = new File(CURR_IMAGE_REPO_PATH+"\\"+category+"\\"+productNum);
						FileUtils.moveFileToDirectory(srcFile, destDir,true);
					}
				}
			}catch(Exception e) {
				if(imageFileList!=null && imageFileList.size()!=0) {
					for(ImageFileVO  imageFileVO:imageFileList) {
						imageFileName = imageFileVO.getFileName();
						File srcFile = new File(CURR_IMAGE_REPO_PATH+"\\"+"temp"+"\\"+imageFileName);
						srcFile.delete();
					}
				}
				e.printStackTrace();
			}
		}

		@Override
		@RequestMapping(value="/removeGoodsImage.do" ,method={RequestMethod.POST})
		public void  removeGoodsImage(@RequestParam("productNum") int productNum, @RequestParam("category")String category,
				                      @RequestParam("imageNum") int imageNum,
				                      @RequestParam("fileName") String fileName,
				                      HttpServletRequest request, HttpServletResponse response)  throws Exception {
			
			service.removeGoodsImage(imageNum);
			try{
				File srcFile = new File(CURR_IMAGE_REPO_PATH+"\\"+category+"\\"+productNum+"\\"+fileName);
				srcFile.delete();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		// 5. 상품 삭제
		
				@Override
				@RequestMapping(value="/admin_prod_delete.do",method=RequestMethod.GET)
				public String goods_delete(@RequestParam("productNum")int productNum,@RequestParam("category")String category,
						RedirectAttributes redirect,Model model)throws Exception {
					try {
						service.deleteGoods(productNum);
						File destDir=new File(CURR_IMAGE_REPO_PATH+"\\"+category+"\\"+productNum);
						FileUtils.deleteDirectory(destDir);
						redirect.addFlashAttribute("msg", "삭제가 완료되었습니다.");
									
					}catch(Exception e) {
						redirect.addFlashAttribute("msg", "오류가 발생되었습니다.");
					}
					return "redirect:/admin_prod.do";
				}
				
		
		@Override
		@RequestMapping(value="/admin_review.do" ,method = RequestMethod.GET)
		public ModelAndView Allreview(SearchCriteriaVO scri,
				                       HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			
			
			// 상품 상세페이지 내 후기(리스트만), 후기 작성은 마이페이지에서
			
		        int reviewListCnt = service.reviewListCnt(scri);
		         
		      
		        PagingVO paging = new PagingVO();
		        paging.setCri(scri);
		        paging.setTotalCount(reviewListCnt);    
		        	        
		        
		        //String viewName=(String)request.getAttribute("viewName");
		        List<Map<String, Object>> list = service.reviewList(scri);
		        ModelAndView mav=new ModelAndView("admin_review");
		   
		        mav.addObject("reviewList", scri);
		        mav.addObject("list", list);   
		        mav.addObject("paging", paging);
			
			
			return mav;
		}
		//후기글 상세보기
		@Override
		@RequestMapping(value="/admin_review_re.do",method= {RequestMethod.GET,RequestMethod.POST})
		public ModelAndView Reviewdetail(@RequestParam("re_num") int re_num, HttpServletRequest request,HttpServletResponse response)throws Exception{
			vo = service.Reviewdetail(re_num);
			ModelAndView mav=new ModelAndView();
			System.out.println(vo.getRe_num());			
			mav.addObject("list", vo);
			mav.setViewName("admin_review_re");
			return mav;
		}
		//후기글 답변하기
		@Override
		@RequestMapping(value="/admin_review_re2.do",method= {RequestMethod.GET,RequestMethod.POST})
		public ModelAndView reviewupdate(@RequestParam("re_num") int re_num,HttpServletRequest request,HttpServletResponse response)throws Exception{
			vo = service.Reviewdetail(re_num);
			ModelAndView mav=new ModelAndView();
			System.out.println(vo.getRe_num());
			System.out.println("controller : " + vo.getUser_id());
			mav.addObject("list", vo);
			mav.setViewName("admin_review_re2");
			return mav;
		}
		
		
		
		@Override
		@RequestMapping(value="/admin_review_action.do")
		public String review_action(GoodsVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
				service.updateReview(vo);				
			return "redirect:/admin_review.do";
		}
		
		
		//후기글 삭제
		@Override
		@RequestMapping(value="/admin_review_delete.do",method=RequestMethod.GET)
		public String reviewdelete(@RequestParam("re_num") int re_num,HttpServletRequest request, HttpServletResponse response) throws Exception {
				service.deleteReview(re_num);
			return "redirect:/admin_review.do";
		}
		
		

	
}


