
package com.mycompany.teamproject.mypage.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.teamproject.board.vo.CriteriaVO;
import com.mycompany.teamproject.board.vo.PagingVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.goods.service.GoodsService;
import com.mycompany.teamproject.member.vo.MemberVO;
import com.mycompany.teamproject.mypage.service.MypageService;
import com.mycompany.teamproject.mypage.vo.MypageVO;
import com.mycompany.teamproject.mypage.vo.ReviewImageVO;
import com.mycompany.teamproject.order.vo.OrderVO;

@Controller("mypageController")
public class MypageControllerImpl implements MypageController {
	private static final String REVIEW_IMAGE_REPO="C:\\review\\image";
	@Autowired
	private MypageService mypageService;
	@Autowired
	private MemberVO memberVO;
	@Autowired
	private MypageVO mypageVO;
	@Autowired
	private GoodsService goodsService;
	
	// 마이페이지 메인
	@Override
	@RequestMapping(value="/mypage.do" ,method = RequestMethod.GET)
	public ModelAndView mypageMain(CriteriaVO cri, HttpServletRequest request, HttpServletResponse response)  throws Exception {
		HttpSession session = request.getSession();
		memberVO = (MemberVO)session.getAttribute("memberInfo");
		String user_id = memberVO.getUser_id();
		cri.setUser_id(user_id);
		int myMain = mypageService.myMain(cri);
		
		PagingVO paging = new PagingVO();
		paging.setCri(cri);
		paging.setTotalCount(myMain);
		
		List<Map<String, Object>> list = mypageService.listMyOrderGoods(cri);
		ModelAndView mav = new ModelAndView();
		mav.addObject("paging", paging);
		mav.addObject("list", list);
		mav.setViewName("mypage");
		return mav;
	}
	
	@RequestMapping(value="/edit_pw.do" ,method = RequestMethod.GET)
	public ModelAndView mypage_pw(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("user_id", memberVO.getUser_id());
		return mav;
	}
	
	@RequestMapping(value="/removeid.do" ,method = RequestMethod.GET)
	public ModelAndView mypage_pw_2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("user_id", memberVO.getUser_id());
		return mav;
	}
	
	// 마이페이지 교환, 반품 내역
	@RequestMapping(value="/mypageas.do" ,method = RequestMethod.GET)
	public ModelAndView mypageas(SearchCriteriaVO scri, HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		memberVO = (MemberVO)session.getAttribute("memberInfo");
		String user_id = memberVO.getUser_id();
		scri.setUser_id(user_id);
		
		int mypageList = mypageService.mypageList(scri);
		
		PagingVO paging = new PagingVO();
		paging.setCri(scri);
		paging.setTotalCount(mypageList);
		

		List<Map<String, Object>> list = mypageService.mypageSelect(scri);
		ModelAndView mav = new ModelAndView("mypageas");
		mav.addObject("orderList", mypageList);
		mav.addObject("list", list);
		mav.addObject("paging", paging);
		return mav;
	}
	
	@RequestMapping(value="/orderlist.do" ,method = RequestMethod.GET)
	public ModelAndView orderlist(SearchCriteriaVO scri, HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		memberVO = (MemberVO)session.getAttribute("memberInfo");
		String user_id = memberVO.getUser_id();
		scri.setUser_id(user_id);
		
		int orderList = mypageService.orderListCnt(scri);

		PagingVO paging = new PagingVO();
		paging.setCri(scri);
		paging.setTotalCount(orderList);
		

		List<Map<String, Object>> list = mypageService.orderList(scri);
		ModelAndView mav = new ModelAndView("orderlist");
		mav.addObject("orderList", scri);
		mav.addObject("myOrderList", list);
		mav.addObject("paging", paging);
		return mav;
	}
	
	@RequestMapping(value="/orderpayment.do" ,method = RequestMethod.GET)
	public ModelAndView orderpayment(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	//마이페이지 내 후기 작성
	
		@Override
		@RequestMapping(value="/prodetail_review.do",method=RequestMethod.GET)
		public ModelAndView pro_review(@RequestParam("productnum")String productNum,HttpServletRequest request,HttpServletResponse response) throws Exception{
			HttpSession session=request.getSession();
			memberVO = (MemberVO)session.getAttribute("memberInfo");
			Map goodsMap=goodsService.goodsDetail(productNum);		
			ModelAndView mav=new ModelAndView("orderlist_proreview");
			mav.addObject("goodsMap", goodsMap);
			mav.addObject("user_id", memberVO.getUser_id());
			return mav;
		}
		
		@Override
		@RequestMapping(value="/prodetail_review.do",method=RequestMethod.POST)
		@ResponseBody
		public ResponseEntity pro_review_action(MultipartHttpServletRequest multipartRequest,HttpServletResponse response)throws Exception{
			multipartRequest.setCharacterEncoding("utf-8");
			String imageFileName=null;
			
			Map reMap=new HashMap();
			Enumeration enu=multipartRequest.getParameterNames();
			while(enu.hasMoreElements()) {
				String name=(String)enu.nextElement();
				String value=multipartRequest.getParameter(name);
				reMap.put(name, value);
			}
			// 로그인 시 세션에 저장된 회원 정보에서 작성자 id를 가져와서 Map 에 저장
			HttpSession session=multipartRequest.getSession();
			MemberVO memberVO = (MemberVO)session.getAttribute("memberInfo");
			String user_id = memberVO.getUser_id();
			reMap.put("user_id", user_id);
			System.out.println(user_id);
		
			
			List<String> fileList=upload2(multipartRequest);
			List<ReviewImageVO> imageFileList=new ArrayList<ReviewImageVO>();
			if(fileList != null && fileList.size() != 0) {
				for(String fileName:fileList) {
					ReviewImageVO imageVO = new ReviewImageVO();
					imageVO.setImageFileName(fileName);
					imageFileList.add(imageVO);
				}
				reMap.put("imageFileName", imageFileName);
				reMap.put("imageFileList", imageFileList);
				System.out.println("이미지 파일 저장 완료 imageFileList:"+imageFileList);
			}
			String message;
			ResponseEntity resEnt=null;
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "text/html;charset=utf-8");
			try {
				int re_num = mypageService.pro_review(reMap);
				
				if(imageFileList != null && imageFileList.size() !=0) {
					for(ReviewImageVO imageVO:imageFileList) {
						imageFileName=imageVO.getImageFileName();
						File srcFile=new File(REVIEW_IMAGE_REPO+"\\"+"temp"+"\\"+imageFileName);
						File destDir=new File(REVIEW_IMAGE_REPO+"\\"+re_num);
						//destDir.mkdir();
						FileUtils.moveFileToDirectory(srcFile, destDir, true);
					}
				}
				message="<script>";
				message+="alert('등록이 완료되었습니다.');";
				message+="location.href='"+multipartRequest.getContextPath()+"/mypage_reviewlist.do';";
				message+="</script>";
				resEnt=new ResponseEntity(message,responseHeaders,HttpStatus.CREATED);
			}catch(Exception e) {
				if(imageFileList != null && imageFileList.size() != 0) {
					for(ReviewImageVO imageVO:imageFileList) {
						imageFileName=imageVO.getImageFileName();
						File srcFile = new File(REVIEW_IMAGE_REPO+"\\"+"temp"+"\\"+imageFileName);
						srcFile.delete();
					}
				}
				message="<script>";
				message+="alert('오류가 발생하였습니다. 다시 시도해 주세요');');";
				message+="location.href='"+multipartRequest.getContextPath()+"/prodetail_review.do';";
				message+="</script>";
				resEnt=new ResponseEntity(message,responseHeaders,HttpStatus.CREATED);
				e.printStackTrace();
				
			}
			return resEnt;
		}
		
		//이미지 업로드
			private List<String> upload2(MultipartHttpServletRequest multipartRequest)throws Exception{
					List<String> fileList = new ArrayList<String>();
					Iterator<String> fileNames=multipartRequest.getFileNames();
					while(fileNames.hasNext()) {
						String fileName=fileNames.next();
						MultipartFile mFile=multipartRequest.getFile(fileName);
						String originalFileName=mFile.getOriginalFilename();
						fileList.add(originalFileName);
						File file=new File(REVIEW_IMAGE_REPO+"\\"+"temp"+"\\"+fileName);
						if(mFile.getSize()!=0) {
							if(!file.exists()) {
								if(file.getParentFile().mkdirs()) {
									file.createNewFile();
								}
							}
							
							mFile.transferTo(new File(REVIEW_IMAGE_REPO+"\\"+"temp"+"\\"+originalFileName));
							System.out.println("파일리스트:"+fileList);
						}
					}
					
					return fileList;
				}
			
			// 후기 수정
			@Override
			@RequestMapping(value="/review_detail_edit.do", method=RequestMethod.GET)
			public ModelAndView review_edit_view(@RequestParam("re_num") int re_num,HttpServletRequest request, HttpServletResponse respon) throws Exception {
				ModelAndView mav = new ModelAndView();
				OrderVO order = mypageService.review_edit(re_num);
				mav.addObject("order", order);
				mav.setViewName("review_detail_edit");
				return mav;
			}
			
			@Override
		
			@RequestMapping(value="/review_detail_edit.do", method=RequestMethod.POST)
			public ResponseEntity review_edit(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception {
				multipartRequest.setCharacterEncoding("utf-8");
				String imageFileName = null;
				int re_num = Integer.parseInt(multipartRequest.getParameter("re_num"));
				System.out.println(re_num);
				Map map = new HashMap();
				Enumeration enu = multipartRequest.getParameterNames();
				while(enu.hasMoreElements()) {
					String name = (String)enu.nextElement();
					String value = multipartRequest.getParameter(name);
					map.put(name, value);
				}
				
				HttpSession session = multipartRequest.getSession();
				MemberVO memberVO = (MemberVO)session.getAttribute("memberInfo");
				String user_id = memberVO.getUser_id();
				map.put("user_id", user_id);
				
				List<String> fileList = upload2(multipartRequest);
				List<ReviewImageVO> imageFileList = new ArrayList<ReviewImageVO>();
				if(fileList != null && fileList.size() != 0) {
					for(String fileName:fileList) {
						ReviewImageVO imageVO = new ReviewImageVO();
						imageVO.setImageFileName(fileName);
						imageFileList.add(imageVO);
					}
					map.put("imageFileName", imageFileName);
					map.put("imageFileList", imageFileList);
				}
				String message;
				ResponseEntity resEnt=null;
				HttpHeaders responseHeaders = new HttpHeaders();
				responseHeaders.add("Content-Type", "text/html;charset=utf-8");
				File file = new File(REVIEW_IMAGE_REPO+"\\"+re_num);
				file.delete();
				try {
					mypageService.pro_review_edit(map);
					
					if(imageFileList != null && imageFileList.size() != 0) {
						for(ReviewImageVO imageVO:imageFileList) {
							imageFileName=imageVO.getImageFileName();
							File srcFile=new File(REVIEW_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName);
							File destDir=new File(REVIEW_IMAGE_REPO + "\\" + re_num);
							
							FileUtils.moveFileToDirectory(srcFile, destDir, true);
						}
					}
					message="<script>";
					message+="alert('수정이 완료되었습니다');";
					message+="location.href='" + multipartRequest.getContextPath()+"/mypage_reviewlist.do';";
					message+="</script>";
					resEnt=new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
				} catch(Exception e) {
					if(imageFileList != null && imageFileList.size() != 0) {
						for(ReviewImageVO imageVO:imageFileList) {
							imageFileName=imageVO.getImageFileName();
							File srcFile = new File(REVIEW_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName);
							srcFile.delete();
						}
					}
					message="<script>";
					message+="alert('오류가 발생했습니다. 다시 시도해 주세요');";
					message+="location.href='"+multipartRequest.getContextPath()+"/review_detail_edit.do'";
					message+="</script>";
					resEnt=new ResponseEntity(message,responseHeaders,HttpStatus.CREATED);
					e.printStackTrace();
				}
				return resEnt;
			}
			
			
			// 마이페이지 내가 쓴 후기 목록
			@Override
			@RequestMapping(value="/mypage_reviewlist.do" ,method = RequestMethod.GET)
			public ModelAndView Allreview(CriteriaVO cri,
					                       HttpServletRequest request, HttpServletResponse response) throws Exception {
					
					HttpSession session=request.getSession();
					MemberVO memberVO = (MemberVO)session.getAttribute("memberInfo");
					String user_id = memberVO.getUser_id();
					
					cri.setUser_id(user_id);			
			        int reviewListCnt = mypageService.reviewListCnt(cri);
			         
			      
			        PagingVO paging = new PagingVO();
			        paging.setCri(cri);
			        paging.setTotalCount(reviewListCnt);    
			        	        
			        
			        //String viewName=(String)request.getAttribute("viewName");
			    
			        List<Map<String, Object>> list = mypageService.reviewList(cri);
			        ModelAndView mav=new ModelAndView("reviewlist");
			     
			        mav.addObject("list", list);   
			        mav.addObject("paging", paging);
			        System.out.println("컨트롤러:"+list);
			        System.out.println("컨트롤러:"+user_id);
				
				return mav;
			}
			
			// 내가 쓴 후기 상세페이지
			
			@Override
			@RequestMapping(value="/mypage_review_detail.do",method={RequestMethod.GET,RequestMethod.POST})
			public ModelAndView reviewDetail(@RequestParam("re_num") int re_num,HttpServletRequest request,HttpServletResponse response)throws Exception{
			
				Map reMap=mypageService.reviewDetail(re_num);
				ModelAndView mav=new ModelAndView();
				mav.setViewName("review_detail");
				mav.addObject("reMap", reMap);
				return mav;
			}
			
			// 후기 수정
			
			
			// 삭제
			
			
			@Override
			@RequestMapping(value="/mypage_review_delete.do",method=RequestMethod.GET)
			public String review_delete(@RequestParam("re_num")int re_num,RedirectAttributes redirect,Model model)throws Exception {
				try {
					mypageService.deleteReview(re_num);
					File destDir=new File(REVIEW_IMAGE_REPO+"\\"+re_num);
					FileUtils.deleteDirectory(destDir);
					redirect.addFlashAttribute("msg", "삭제가 완료되었습니다.");
								
				}catch(Exception e) {
					redirect.addFlashAttribute("msg", "오류가 발생되었습니다.");
				}
				return "redirect:/mypage_reviewlist.do";
			}
			
		
		// 마이페이지 내 상담내역
			@Override
			@RequestMapping(value="/mypage_conlist.do" ,method = RequestMethod.GET)
			public ModelAndView myConsulting(CriteriaVO cri, HttpServletRequest request, HttpServletResponse response) throws Exception {
					HttpSession session=request.getSession();
					MemberVO memberVO = (MemberVO)session.getAttribute("memberInfo");
					String user_id = memberVO.getUser_id();
					cri.setUser_id(user_id);			
					
			        int conListCnt = mypageService.conListCnt(cri);
			         
			      
			        PagingVO paging = new PagingVO();
			        paging.setCri(cri);
			        paging.setTotalCount(conListCnt);    
			        	        
			        
			        //String viewName=(String)request.getAttribute("viewName");
			    
			        List<Map<String, Object>> list = mypageService.conList(cri);
			        ModelAndView mav=new ModelAndView("conlist");
			     
			        mav.addObject("list", list);   
			        mav.addObject("paging", paging);
				
				return mav;
			}
	
}
