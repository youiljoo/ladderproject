package com.mycompany.teamproject.board.controller;


import java.io.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.teamproject.board.service.BoardService;
import com.mycompany.teamproject.board.vo.BoardVO;
import com.mycompany.teamproject.board.vo.ImageVO;
import com.mycompany.teamproject.board.vo.PagingVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.member.vo.MemberVO;


@Controller

public class BoardControllerImpl implements BoardController{
private static final String BOARD_IMAGE_REPO="C:\\board\\as_image";
		@Inject
		private BoardService service;
		@Autowired
		private BoardVO vo;
		
		// 메인 페이지
		
		@RequestMapping(value = "/board", method = RequestMethod.GET)
		public String home(Locale locale, Model model) {
		
			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
			
			String formattedDate = dateFormat.format(date);
			
			model.addAttribute("serverTime", formattedDate );
			
			return "boardmain";
		}
		
		// 공지사항 게시판
				
		// 1. 글 목록(검색기능, 페이징 추가)            글 등록은 관리자 페이지에서 담당할 것
		
		@Override
		@RequestMapping(value="/board/notice",method=RequestMethod.GET)
		public ModelAndView noticeList(SearchCriteriaVO scri,HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			 
	        int noticeListCnt = service.noticeListCnt(scri);
	        	         
	      
	        PagingVO paging = new PagingVO();
	        paging.setCri(scri);
	        paging.setTotalCount(noticeListCnt);    
	        	        
	        
	        //String viewName=(String)request.getAttribute("viewName");
	        List<Map<String, Object>> list = service.noticeList(scri);
	        ModelAndView mav=new ModelAndView("boardnotice");
	        mav.addObject("noticeList", scri);
	        mav.addObject("list", list);   
	        mav.addObject("paging", paging);
	                
	        return mav;	    			
		}
		
		// 2. 상세 페이지
		@Override
		@RequestMapping(value="/board/notice/detail",method= {RequestMethod.GET,RequestMethod.POST})
		public ModelAndView viewNotice(@RequestParam("n_no") int n_no,HttpServletRequest request,HttpServletResponse response)throws Exception{
			vo = service.viewNotice(n_no);
			ModelAndView mav=new ModelAndView();
			System.out.println(vo.getN_no());
			mav.addObject("list", vo);
			mav.setViewName("boardnoticedetail");
			return mav;
		}
		
		
		
		// 상담문의 게시판
		
		// 1. 글 목록(검색기능, 페이징 추가)
		@Override
		@RequestMapping(value="/board/consulting",method=RequestMethod.GET)
		public ModelAndView consultingList(SearchCriteriaVO scri,HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			 
	        int consultingListCnt = service.consultingListCnt(scri);
	        	         
	      
	        PagingVO paging = new PagingVO();
	        paging.setCri(scri);
	        paging.setTotalCount(consultingListCnt);    
	        	        
	        
	        //String viewName=(String)request.getAttribute("viewName");
	        List<Map<String, Object>> list = service.consultingList(scri);
	        ModelAndView mav=new ModelAndView("boardconsulting");
	        mav.addObject("consultingList", scri);
	        mav.addObject("list", list);    
	        mav.addObject("paging", paging);
	                
	        return mav;	    			
		}
	
		
		// 2. 글쓰기

		@Override
		@RequestMapping(value="/board/consultwriting",method=RequestMethod.GET)
		public String getcreate(HttpServletRequest request,HttpServletResponse response) throws Exception{
			
			return "boardconsultwriting";
		}
	
		@Override
		@RequestMapping(value="/board/consultwriting",method=RequestMethod.POST)
		public String postcreate(BoardVO vo,HttpServletRequest request,HttpServletResponse response)throws Exception{
			
			HttpSession session=request.getSession();
			MemberVO memberVO = (MemberVO)session.getAttribute("memberInfo");
			String user_id = memberVO.getUser_id();
			vo.setUser_id(user_id); 
			service.create(vo);
			return "redirect:consulting";
		}
		
		// 3. 상세페이지
		
		@Override
		@RequestMapping(value="/board/consulting/detail",method= {RequestMethod.GET,RequestMethod.POST})
		public ModelAndView viewConsulting(@RequestParam("c_no") int c_no,HttpServletRequest request,HttpServletResponse response)throws Exception{
			vo = service.viewConsulting(c_no);
			ModelAndView mav=new ModelAndView();
			System.out.println(vo.getC_no());
			mav.addObject("list", vo);
			mav.setViewName("boardconsultingdetail");
			return mav;
		}
		
		// 4. 수정
		
		@Override
		@RequestMapping(value="/board/consulting/update",method= {RequestMethod.GET,RequestMethod.POST})
		public ModelAndView update(@RequestParam("c_no") int c_no,HttpServletRequest request,HttpServletResponse response)throws Exception{
			vo = service.viewConsulting(c_no);
			ModelAndView mav=new ModelAndView();
			System.out.println(vo.getC_no());
			System.out.println("controller : " + vo.getC_name());
			mav.addObject("list", vo);
			mav.setViewName("boardconsultingupdate");
			return mav;
		}
		
		
		
		@Override
		@RequestMapping(value="/board/consulting/update_action")
		public String update_action(@ModelAttribute("boardVO")BoardVO boardVO,HttpServletRequest request,RedirectAttributes redirect,Model model)throws Exception {
			try {
				service.updateConsulting(boardVO);
				redirect.addFlashAttribute("redirect", boardVO.getC_no());
				redirect.addFlashAttribute("msg", "수정이 완료되었습니다.");				
				System.out.println("수정 완료");
			}catch(Exception e){
				redirect.addFlashAttribute("msg", "오류가 발생되었습니다");
				System.out.println("수정 실패");
			}
			return "redirect:/board/consulting";
		}
		
		// 5. 삭제
		@Override
		@RequestMapping(value="/board/consulting/delete",method=RequestMethod.GET)
		public String delete(@ModelAttribute("boardVO")BoardVO boardVO,@RequestParam("c_no")int c_no,RedirectAttributes redirect,Model model)throws Exception {
			try {
				service.deleteConsulting(c_no);
				redirect.addFlashAttribute("msg", "삭제가 완료되었습니다.");
				
			}catch(Exception e) {
				redirect.addFlashAttribute("msg", "오류가 발생되었습니다.");
			}
			return "redirect:/board/consulting";
		}
		
		
									
		// Q&A 게시판
		
		// 1. 게시글 목록(페이징, 검색 기능 추가)
		@Override
		@RequestMapping(value="/board/qna",method=RequestMethod.GET)
		public String qnaList(SearchCriteriaVO scri, Model model,HttpServletRequest request,
				HttpServletResponse response) throws Exception {
					
			
			
			
			
			int qnaListCnt = service.qnaListCnt(scri);
			
	        PagingVO paging = new PagingVO();
	        paging.setCri(scri);
	        paging.setTotalCount(qnaListCnt);  
	        
	        List<Map<String, Object>> list = service.qnaList(scri);
	        
	        model.addAttribute("list", list);    
	        model.addAttribute("paging", paging);    
	                
	        return "boardqna";			
		}
		
		// 2. 게시글 작성
		@Override
		@RequestMapping(value="/board/qnawriting",method=RequestMethod.GET)
		public String getcreate2(HttpServletRequest request,HttpServletResponse response) throws Exception{
			
			return "boardqnawriting";
		}
	
		@Override
		@RequestMapping(value="/board/qnawriting",method=RequestMethod.POST)
		public String postcreate2(BoardVO vo,HttpServletRequest request,HttpServletResponse response)throws Exception{
			HttpSession session=request.getSession();
			MemberVO memberVO = (MemberVO)session.getAttribute("memberInfo");
			String user_id = memberVO.getUser_id();
			vo.setUser_id(user_id); 			
			service.create2(vo);
			return "redirect:qna";
		}
		
		// 3. 상세페이지
		
		@Override
		@RequestMapping(value="/board/qna/detail",method= {RequestMethod.GET,RequestMethod.POST})
		public ModelAndView viewQNA(@RequestParam("q_no") int q_no,HttpServletRequest request,HttpServletResponse response)throws Exception{
			vo = service.viewQNA(q_no);
			ModelAndView mav=new ModelAndView();
			System.out.println(vo.getQ_no());
			mav.addObject("list", vo);
			mav.setViewName("boardqnadetail");
			return mav;
		}
		
		// 4. 수정
		
		@Override
		@RequestMapping(value="/board/qna/update",method= {RequestMethod.GET,RequestMethod.POST})
		public ModelAndView update2(@RequestParam("q_no") int q_no,HttpServletRequest request,HttpServletResponse response)throws Exception{
			vo = service.viewQNA(q_no);
			ModelAndView mav=new ModelAndView();
			System.out.println(vo.getQ_no());
			System.out.println("controller : " + vo.getQ_name());
			mav.addObject("list", vo);
			mav.setViewName("boardqnaupdate");
			return mav;
		}
						
		@Override
		@RequestMapping(value="/board/qna/update_action")
		public String update_action2(@ModelAttribute("boardVO")BoardVO boardVO,HttpServletRequest request,RedirectAttributes redirect,Model model)throws Exception {
			try {
				service.updateQNA(boardVO);
				redirect.addFlashAttribute("redirect", boardVO.getQ_no());
				redirect.addFlashAttribute("msg", "수정이 완료되었습니다.");				
				System.out.println("수정 완료");
			}catch(Exception e){
				redirect.addFlashAttribute("msg", "오류가 발생되었습니다");
				System.out.println("수정 실패");
			}
			return "redirect:/board/qna";
		}
		
		// 5. 삭제
		
		@Override
		@RequestMapping(value="/board/qna/delete",method=RequestMethod.GET)
		public String delete2(@ModelAttribute("boardVO")BoardVO boardVO,@RequestParam("q_no")int q_no,RedirectAttributes redirect,Model model)throws Exception {
			try {
				service.deleteQNA(q_no);
				redirect.addFlashAttribute("msg", "삭제가 완료되었습니다.");
				
			}catch(Exception e) {
				redirect.addFlashAttribute("msg", "오류가 발생되었습니다.");
			}
			return "redirect:/board/qna";
		}
		
		
		
		
		
		// AS 게시판
		
		// 1. 게시글 목록(페이징, 검색 기능 추가)
		@Override
		@RequestMapping(value="/board/as",method=RequestMethod.GET)
		public String asList(SearchCriteriaVO scri, Model model,HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			
	        int asListCnt = service.asListCnt(scri);
	        	         
	      
	        PagingVO paging = new PagingVO();
	        paging.setCri(scri);
	        paging.setTotalCount(asListCnt);  
	        
	        List<Map<String, Object>> list = service.asList(scri);
	        
	        model.addAttribute("list", list);    
	        model.addAttribute("paging", paging);    
	                
	        return "boardas";
	    
			
		}
		
		// 2. 게시글 작성(다중 이미지 파일 첨부 기능 추가)
		@Override
		@RequestMapping(value="/board/aswriting",method=RequestMethod.GET)
		public String getcreate3(HttpServletRequest request,HttpServletResponse response) throws Exception{
			
			return "boardaswriting";
		}
		@Override
		@RequestMapping(value="/board/aswriting",method=RequestMethod.POST)
		@ResponseBody
		public ResponseEntity postcreate3(MultipartHttpServletRequest multipartRequest,HttpServletResponse response)throws Exception{
			multipartRequest.setCharacterEncoding("utf-8");
			String imageFileName=null;
			
			Map asMap=new HashMap();
			Enumeration enu=multipartRequest.getParameterNames();
			while(enu.hasMoreElements()) {
				String name=(String)enu.nextElement();
				String value=multipartRequest.getParameter(name);
				asMap.put(name, value);
			}
			// 로그인 시 세션에 저장된 회원 정보에서 작성자 id를 가져와서 Map 에 저장
			HttpSession session=multipartRequest.getSession();
			MemberVO memberVO = (MemberVO)session.getAttribute("memberInfo");
			String user_id = memberVO.getUser_id();
			asMap.put("user_id", user_id);
		
			
			List<String> fileList=upload(multipartRequest);
			List<ImageVO> imageFileList=new ArrayList<ImageVO>();
			if(fileList != null && fileList.size() != 0) {
				for(String fileName:fileList) {
					ImageVO imageVO = new ImageVO();
					imageVO.setImageFileName(fileName);
					imageFileList.add(imageVO);
				}
				asMap.put("imageFileName", imageFileName);
				asMap.put("imageFileList", imageFileList);
				System.out.println("이미지 파일 저장 완료 imageFileList:"+imageFileList);
			}
			String message;
			ResponseEntity resEnt=null;
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "text/html;charset=utf-8");
			try {
				int as_no = service.create3(asMap);
				if(imageFileList != null && imageFileList.size() !=0) {
					for(ImageVO imageVO:imageFileList) {
						imageFileName=imageVO.getImageFileName();
						File srcFile=new File(BOARD_IMAGE_REPO+"\\"+"temp"+"\\"+imageFileName);
						File destDir=new File(BOARD_IMAGE_REPO+"\\"+as_no);
						//destDir.mkdir();
						FileUtils.moveFileToDirectory(srcFile, destDir, true);
					}
				}
				message="<script>";
				message+="alert('등록이 완료되었습니다.');";
				message+="location.href='"+multipartRequest.getContextPath()+"/board/as';";
				message+="</script>";
				resEnt=new ResponseEntity(message,responseHeaders,HttpStatus.CREATED);
			}catch(Exception e) {
				if(imageFileList != null && imageFileList.size() != 0) {
					for(ImageVO imageVO:imageFileList) {
						imageFileName=imageVO.getImageFileName();
						File srcFile = new File(BOARD_IMAGE_REPO+"\\"+"temp"+"\\"+imageFileName);
						srcFile.delete();
					}
				}
				message="<script>";
				message+="alert('오류가 발생하였습니다. 다시 시도해 주세요');');";
				message+="location.href='"+multipartRequest.getContextPath()+"/board/aswriting';";
				message+="</script>";
				resEnt=new ResponseEntity(message,responseHeaders,HttpStatus.CREATED);
				e.printStackTrace();
				
			}
			return resEnt;
		}
		
		//이미지 업로드
		private List<String> upload(MultipartHttpServletRequest multipartRequest)throws Exception{
			List<String> fileList = new ArrayList<String>();
			Iterator<String> fileNames=multipartRequest.getFileNames();
			while(fileNames.hasNext()) {
				String fileName=fileNames.next();
				MultipartFile mFile=multipartRequest.getFile(fileName);
				String originalFileName=mFile.getOriginalFilename();
				fileList.add(originalFileName);
				File file=new File(BOARD_IMAGE_REPO+"\\"+"temp"+"\\"+fileName);
				if(mFile.getSize()!=0) {
					if(!file.exists()) {
						if(file.getParentFile().mkdirs()) {
							file.createNewFile();
						}
					}
					
					mFile.transferTo(new File(BOARD_IMAGE_REPO+"\\"+"temp"+"\\"+originalFileName));
					System.out.println("파일리스트:"+fileList);
				}
			}
			
			return fileList;
		}

		// 3. 상세페이지(이미지 표시 기능 추가)
		
		@Override
		@RequestMapping(value="/board/as/detail",method={RequestMethod.GET,RequestMethod.POST})
		public ModelAndView viewAS(@RequestParam("as_no") int as_no,HttpServletRequest request,HttpServletResponse response)throws Exception{
		
			Map asMap=service.viewAS(as_no);
			ModelAndView mav=new ModelAndView();
			mav.setViewName("boardasdetail");
			mav.addObject("asMap", asMap);
			return mav;
		}
		
		// 4. 수정

		@Override
		@RequestMapping(value="/board/as/update",method= {RequestMethod.GET,RequestMethod.POST})
		public ModelAndView update3(@RequestParam("as_no") int as_no,HttpServletRequest request,HttpServletResponse response)throws Exception{
			Map asMap = service.viewAS(as_no);
			ModelAndView mav=new ModelAndView();
			System.out.println(vo.getAs_no());
			System.out.println("controller : " + vo.getAs_name());
			mav.addObject("asMap", asMap);
			mav.setViewName("boardasupdate");
			return mav;
		}
		
		@Override
		@RequestMapping(value="/board/as/update_action")
		@ResponseBody
		public ResponseEntity update_action3(MultipartHttpServletRequest multipartRequest,HttpServletResponse response)throws Exception{
			multipartRequest.setCharacterEncoding("utf-8");
			String imageFileName=null;
			
			Map asMap=new HashMap();
			Enumeration enu=multipartRequest.getParameterNames();
			while(enu.hasMoreElements()) {
				String name=(String)enu.nextElement();
				String value=multipartRequest.getParameter(name);
				asMap.put(name, value);
			}
									
			List<String> fileList=upload(multipartRequest);
			List<ImageVO> imageFileList=new ArrayList<ImageVO>();
			if(fileList != null && fileList.size() != 0) {
				for(String fileName:fileList) {
					ImageVO imageVO = new ImageVO();
					imageVO.setImageFileName(fileName);
					imageFileList.add(imageVO);
				}
				asMap.put("imageFileList", imageFileList);
				System.out.println("이미지 파일 저장 완료 imageFileList:"+imageFileList);
			}
			String as_no=(String)asMap.get("as_no");
			String message;
			ResponseEntity resEnt=null;
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "text/html;charset=utf-8");
			try {
				service.updateAS(asMap);
				if(imageFileList != null && imageFileList.size() !=0) {
					for(ImageVO imageVO:imageFileList) {
						imageFileName=imageVO.getImageFileName();
						File srcFile=new File(BOARD_IMAGE_REPO+"\\"+"temp"+"\\"+imageFileName);
						File destDir=new File(BOARD_IMAGE_REPO+"\\"+as_no);
						//destDir.mkdir();
						FileUtils.moveFileToDirectory(srcFile, destDir, true);
						
						String originalFileName=(String)asMap.get("originalFileName");
						File oldFile=new File(BOARD_IMAGE_REPO+"\\"+"temp"+"\\"+originalFileName);
						oldFile.delete();
					}
				}
				message="<script>";
				message+="alert('수정이 완료되었습니다.');";
				message+="location.href='"+multipartRequest.getContextPath()+"/board/as';";
				message+="</script>";
				resEnt=new ResponseEntity(message,responseHeaders,HttpStatus.CREATED);
			}catch(Exception e) {
				if(imageFileList != null && imageFileList.size() != 0) {
					for(ImageVO imageVO:imageFileList) {
						imageFileName=imageVO.getImageFileName();
						File srcFile = new File(BOARD_IMAGE_REPO+"\\"+"temp"+"\\"+imageFileName);
						srcFile.delete();
					}
				}
				message="<script>";
				message+="alert('오류가 발생하였습니다. 다시 시도해 주세요');');";
				message+="location.href='"+multipartRequest.getContextPath()+"/board/as/detail?as_no="+as_no+"';";
				message+="</script>";
				resEnt=new ResponseEntity(message,responseHeaders,HttpStatus.CREATED);
				e.printStackTrace();
				
			}
			return resEnt;
		}
			
		
				
		// 5. 삭제
		@Override
		@RequestMapping(value="/board/as/delete",method=RequestMethod.GET)
		public String delete3(@ModelAttribute("boardVO")BoardVO boardVO,@RequestParam("as_no")int as_no,RedirectAttributes redirect,Model model)throws Exception {
			try {
				service.deleteAS(as_no);
				File destDir=new File(BOARD_IMAGE_REPO+"\\"+as_no);
				FileUtils.deleteDirectory(destDir);
				redirect.addFlashAttribute("msg", "삭제가 완료되었습니다.");
						
			}catch(Exception e) {
				redirect.addFlashAttribute("msg", "오류가 발생되었습니다.");
			}
			return "redirect:/board/as";
		}

			
		
	
		
		
		
		
	}


