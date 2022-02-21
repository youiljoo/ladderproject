package com.mycompany.teamproject.admin.board.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.teamproject.admin.board.service.AdminBoardService;
import com.mycompany.teamproject.admin.board.vo.AdminBoardVO;
import com.mycompany.teamproject.board.vo.BoardVO;
import com.mycompany.teamproject.board.vo.PagingVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.member.vo.MemberVO;


@Controller("adminBoardController")
public class AdminBoardControllerImpl implements AdminBoardController {
	@Inject
	private AdminBoardService service;
	@Autowired
	private BoardVO vo;
	private MemberVO memberVO;
	private AdminBoardVO adVO;
			
			//관리자 게시판 메인페이지
	
			@RequestMapping(value="/admin_board_main.do" ,method = RequestMethod.GET)
			public ModelAndView board_main(HttpServletRequest request, HttpServletResponse response) throws Exception {
				String viewName = (String)request.getAttribute("viewName");
				ModelAndView mav = new ModelAndView();
				mav.setViewName(viewName);
				return mav;
			}
			
			
			
			// 회원 공지사항
	
			// 1. 글 목록(검색기능, 페이징 추가)            
	
			@Override
			@RequestMapping(value="/admin_board_notice.do",method=RequestMethod.GET)
			public ModelAndView noticeList(SearchCriteriaVO scri,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 
			int noticeListCnt = service.noticeListCnt(scri);
        	         
      
			PagingVO paging = new PagingVO();
			paging.setCri(scri);
			paging.setTotalCount(noticeListCnt);    
        	        
        
			//String viewName=(String)request.getAttribute("viewName");
			List<Map<String, Object>> list = service.noticeList(scri);
			ModelAndView mav=new ModelAndView("admin_board_notice");
			mav.addObject("noticeList", scri);
			mav.addObject("list", list);   
			mav.addObject("paging", paging);
                
			return mav;	 
			
			}
	
	
			// 2. 글쓰기

			@Override
			@RequestMapping(value="/admin_board_notice_write.do",method=RequestMethod.GET)
			public String nwrite(HttpServletRequest request,HttpServletResponse response) throws Exception{
				
				return "admin_board_notice_write";
			}
		
			@Override
			@RequestMapping(value="/admin_board_notice_write.do",method=RequestMethod.POST)
			public String nwritecreate(BoardVO vo,HttpServletRequest request,HttpServletResponse response)throws Exception{
				
				HttpSession session=request.getSession();
				MemberVO memberVO = (MemberVO)session.getAttribute("memberInfo");
				String user_id = memberVO.getUser_id();
				vo.setUser_id(user_id); 
				service.ncreate(vo);
				return "redirect:admin_board_notice.do";
			}
	
			// 3. 상세페이지
	
	
			@Override
			@RequestMapping(value="/admin_board_notice_detail.do",method= {RequestMethod.GET,RequestMethod.POST})
			public ModelAndView viewNotice(@RequestParam("n_no") int n_no,HttpServletRequest request,HttpServletResponse response)throws Exception{
				vo = service.viewNotice(n_no);
				ModelAndView mav=new ModelAndView();
				System.out.println(vo.getN_no());			
				mav.addObject("list", vo);
				mav.setViewName("admin_board_notice_detail");
				return mav;
			}
			
	
			// 4. 글수정
			
			@Override
			@RequestMapping(value="/admin_board_notice_update.do",method= {RequestMethod.GET,RequestMethod.POST})
			public ModelAndView nupdate(@RequestParam("n_no") int n_no,HttpServletRequest request,HttpServletResponse response)throws Exception{
				vo = service.viewNotice(n_no);
				ModelAndView mav=new ModelAndView();
				System.out.println(vo.getN_no());
				System.out.println("controller : " + vo.getN_name());
				mav.addObject("list", vo);
				mav.setViewName("admin_board_notice_update");
				return mav;
			}
			
			@Override
			@RequestMapping(value="/admin_board_notice_update_action.do")
			public String nupdate_action(@ModelAttribute("boardVO")BoardVO boardVO,HttpServletRequest request,RedirectAttributes redirect,Model model)throws Exception {
				try {
					service.updateNotice(boardVO);
					redirect.addFlashAttribute("redirect", boardVO.getN_no());
					redirect.addFlashAttribute("msg", "수정이 완료되었습니다.");				
					System.out.println("수정 완료");
				}catch(Exception e){
					redirect.addFlashAttribute("msg", "오류가 발생되었습니다");
					System.out.println("수정 실패");
				}
				return "redirect:/admin_board_notice.do";
			}
				
			
			// 5. 글삭제
			@Override
			@RequestMapping(value="/admin_board_notice_delete.do",method=RequestMethod.GET)
			public String ndelete(@ModelAttribute("boardVO")BoardVO boardVO,@RequestParam("n_no")int n_no,RedirectAttributes redirect,Model model)throws Exception {
				try {
					service.deleteNotice(n_no);
					redirect.addFlashAttribute("msg", "삭제가 완료되었습니다.");
					
				}catch(Exception e) {
					redirect.addFlashAttribute("msg", "오류가 발생되었습니다.");
				}
				return "redirect:/admin_board_notice.do";
			}
			
			
			
			
	
			// 관리자 게시판
			
			// 관리자 메인화면(운영실적+공지사항)
			@Override
			@RequestMapping(value="/admin_main.do" ,method = RequestMethod.GET)
			// (공지사항-리스트)
			public ModelAndView admin_main(SearchCriteriaVO scri,HttpServletRequest request,HttpServletResponse response) throws Exception {
				 
		        int adminListCnt = service.adminListCnt(scri);
		        	         
		      
		        PagingVO paging = new PagingVO();
		        paging.setCri(scri);
		        paging.setTotalCount(adminListCnt);    
		        	        
		        
		        //String viewName=(String)request.getAttribute("viewName");
		        List<Map<String, Object>> list = service.adminList(scri);
		        ModelAndView mav=new ModelAndView("admin_main");
		        mav.addObject("adminList", scri);
		        mav.addObject("list", list);    
		        mav.addObject("paging", paging);
		                
		        return mav;	    			
			}
			
			// (공지사항-글쓰기)
			
			@Override
			@RequestMapping(value="/admin_main_notice_add.do",method=RequestMethod.GET)
			public String adwrite(HttpServletRequest request,HttpServletResponse response) throws Exception{
				
				return "admin_main_notice_add";
			}
		
			@Override
			@RequestMapping(value="/admin_main_notice_add.do",method=RequestMethod.POST)
			public String adwritecreate(AdminBoardVO adVO,HttpServletRequest request,HttpServletResponse response)throws Exception{
				
				HttpSession session=request.getSession();
				MemberVO memberVO = (MemberVO)session.getAttribute("memberInfo");
				String user_id = memberVO.getUser_id();
				adVO.setUser_id(user_id); 
				service.adcreate(adVO);
				return "redirect:admin_main.do";
			}
			
			// (공지사항-상세보기)
			@Override
			@RequestMapping(value="/admin_main_notice.do",method= {RequestMethod.GET,RequestMethod.POST})
			public ModelAndView admin_main_notice(@RequestParam("a_main_NO") int a_main_NO,HttpServletRequest request,HttpServletResponse response)throws Exception{
				adVO = service.viewadNotice(a_main_NO);
				ModelAndView mav=new ModelAndView();
				System.out.println(adVO.getA_main_NO());			
				mav.addObject("list", adVO);
				mav.setViewName("admin_main_notice");
				return mav;
			}
			
			// (공지사항-게시글 수정)
			
			@Override
			@RequestMapping(value="/admin_main_notice_update.do",method= {RequestMethod.GET,RequestMethod.POST})
			public ModelAndView adupdate(@RequestParam("a_main_NO") int a_main_NO,HttpServletRequest request,HttpServletResponse response)throws Exception{
				adVO = service.viewadNotice(a_main_NO);
				ModelAndView mav=new ModelAndView();
				System.out.println(adVO.getA_main_NO());
				System.out.println("controller : " + adVO.getA_main_title());
				mav.addObject("list", adVO);
				mav.setViewName("admin_main_notice_update");
				return mav;
			}
			
			@Override
			@RequestMapping(value="/admin_main_notice_update_action.do")
			public String adupdate_action(@ModelAttribute("adVO")AdminBoardVO adVO,HttpServletRequest request,RedirectAttributes redirect,Model model)throws Exception {
				try {
					service.updateadNotice(adVO);
					redirect.addFlashAttribute("redirect", adVO.getA_main_NO());
					redirect.addFlashAttribute("msg", "수정이 완료되었습니다.");				
					System.out.println("수정 완료");
				}catch(Exception e){
					redirect.addFlashAttribute("msg", "오류가 발생되었습니다");
					System.out.println("수정 실패");
				}
				return "redirect:/admin_main.do";
			}
			
			// (공지사항-게시글 삭제)
			@Override
			@RequestMapping(value="/admin_main_notice_delete.do",method=RequestMethod.GET)
			public String addelete(@ModelAttribute("adVO")AdminBoardVO adVO,@RequestParam("a_main_NO")int a_main_NO,RedirectAttributes redirect,Model model)throws Exception {
				try {
					service.deleteadNotice(a_main_NO);
					redirect.addFlashAttribute("msg", "삭제가 완료되었습니다.");
					
				}catch(Exception e) {
					redirect.addFlashAttribute("msg", "오류가 발생되었습니다.");
				}
				return "redirect:/admin_main.do";
			}
			
			
			
			
			
			
			
			// 상담문의 게시판 (목록, 상세페이지, 접수, 삭제)
			
			// 1. 글 목록(검색기능, 페이징 추가)
			@Override
			@RequestMapping(value="/admin_board_consulting.do",method=RequestMethod.GET)
			public ModelAndView consultingList(SearchCriteriaVO scri,HttpServletRequest request,
					HttpServletResponse response) throws Exception {
				 
		        int consultingListCnt = service.consultingListCnt(scri);
		        	         
		      
		        PagingVO paging = new PagingVO();
		        paging.setCri(scri);
		        paging.setTotalCount(consultingListCnt);    
		        	        
		        
		        //String viewName=(String)request.getAttribute("viewName");
		        List<Map<String, Object>> list = service.consultingList(scri);
		        ModelAndView mav=new ModelAndView("admin_board_consulting");
		        mav.addObject("consultingList", scri);
		        mav.addObject("list", list);    
		        mav.addObject("paging", paging);
		                
		        return mav;	    			
			}
			// 2. 상세페이지
			@Override
			@RequestMapping(value="/admin_board_consulting_detail.do",method= {RequestMethod.GET,RequestMethod.POST})
			public ModelAndView viewConsulting(@RequestParam("c_no") int c_no,HttpServletRequest request,HttpServletResponse response)throws Exception{
				vo = service.viewConsulting(c_no);
				ModelAndView mav=new ModelAndView();
				System.out.println(vo.getC_no());
				mav.addObject("list", vo);
				mav.setViewName("admin_board_consulting_detail");
				return mav;
			}
			
			// 3. 게시글 접수 및 답변
			
			@Override
			@RequestMapping(value="/admin_board_consulting_receive.do",method=RequestMethod.GET)
			public String creceive(@ModelAttribute("boardVO")BoardVO boardVO,@RequestParam("c_no")int c_no,RedirectAttributes redirect,Model model)throws Exception {
				try {
					service.receiveConsulting(c_no);
					redirect.addFlashAttribute("msg", "접수가 완료되었습니다.");
					
				}catch(Exception e) {
					redirect.addFlashAttribute("msg", "오류가 발생되었습니다.");
				}
				return "redirect:/admin_board_consulting.do";
			}
			
			@Override
			@RequestMapping(value="/admin_board_consulting_receive_write.do",method=RequestMethod.GET)
			public ModelAndView creceive_write(@RequestParam("c_no") int c_no,HttpServletRequest request,HttpServletResponse response)throws Exception{
				vo = service.viewConsulting(c_no);
				ModelAndView mav=new ModelAndView();
				System.out.println(vo.getC_no());
				mav.addObject("list", vo);
				mav.setViewName("admin_board_consulting_receive");
				return mav;
			}
			
			
			@Override
			@RequestMapping(value="/admin_board_consulting_receive_write.do",method=RequestMethod.POST)
			public String creceive_write_action(BoardVO vo,HttpServletRequest request,HttpServletResponse response)throws Exception{
				
				HttpSession session=request.getSession();
				MemberVO memberVO = (MemberVO)session.getAttribute("memberInfo");
				String user_id = memberVO.getUser_id();
				vo.setUser_id(user_id); 
				service.creplycreate(vo);
				System.out.println(vo.getC_reply());
			
				return "redirect:/admin_board_consulting.do";
			}
			
			
			
			// 4. 게시글 삭제		
			@Override
			@RequestMapping(value="/admin_board_consulting_delete.do",method=RequestMethod.GET)
			public String delete(@ModelAttribute("boardVO")BoardVO boardVO,@RequestParam("c_no")int c_no,RedirectAttributes redirect,Model model)throws Exception {
				try {
					service.deleteConsulting(c_no);
					redirect.addFlashAttribute("msg", "삭제가 완료되었습니다.");
					System.out.println("삭제 완료");
					
				}catch(Exception e) {
					redirect.addFlashAttribute("msg", "오류가 발생되었습니다.");
					System.out.println("삭제 실패");
				}
				return "redirect:/admin_board_consulting.do";
			}
			
			
			
			
			// Q&A 게시판

			// 1. 게시글 목록(페이징, 검색 기능 추가)
			@Override
			@RequestMapping(value="/admin_board_QNA.do",method=RequestMethod.GET)
			public String qnaList(SearchCriteriaVO scri, Model model,HttpServletRequest request,
					HttpServletResponse response) throws Exception {
			
				int qnaListCnt = service.qnaListCnt(scri);
				
		        PagingVO paging = new PagingVO();
		        paging.setCri(scri);
		        paging.setTotalCount(qnaListCnt);  
		        
		        List<Map<String, Object>> list = service.qnaList(scri);
		        
		        model.addAttribute("list", list);    
		        model.addAttribute("paging", paging);    
		                
		        return "admin_board_QNA";			
			}
			
			// 2. 상세페이지
			
			@Override
			@RequestMapping(value="/admin_board_QNA_detail.do",method= {RequestMethod.GET,RequestMethod.POST})
			public ModelAndView viewQNA(@RequestParam("q_no") int q_no,HttpServletRequest request,HttpServletResponse response)throws Exception{
				vo = service.viewQNA(q_no);
				ModelAndView mav=new ModelAndView();
				System.out.println(vo.getQ_no());
				mav.addObject("list", vo);
				mav.setViewName("admin_board_QNA_detail");
				return mav;
			}
			
			// 3. 게시글 접수 및 답변
			
			@Override
			@RequestMapping(value="/admin_board_QNA_receive.do",method=RequestMethod.GET)
			public String qreceive(@ModelAttribute("boardVO")BoardVO boardVO,@RequestParam("q_no")int q_no,RedirectAttributes redirect,Model model)throws Exception {
				try {
					service.receiveQNA(q_no);
					redirect.addFlashAttribute("msg", "접수가 완료되었습니다.");
								
			   }catch(Exception e) {
					redirect.addFlashAttribute("msg", "오류가 발생되었습니다.");
			   }
				return "redirect:/admin_board_QNA.do";
			  }
			
			
			
		
			@Override
			@RequestMapping(value="/admin_board_QNA_receive_write.do",method=RequestMethod.GET)
			public ModelAndView qreceive_write(@RequestParam("q_no") int q_no,HttpServletRequest request,HttpServletResponse response)throws Exception{
				vo = service.viewQNA(q_no);
				ModelAndView mav=new ModelAndView();
				System.out.println(vo.getQ_no());
				mav.addObject("list", vo);
				mav.setViewName("admin_board_QNA_receive");
				return mav;
			}
			
			
			@Override
			@RequestMapping(value="/admin_board_QNA_receive_write.do",method=RequestMethod.POST)
			public String qreceive_write_action(BoardVO vo,HttpServletRequest request,HttpServletResponse response)throws Exception{
				
				HttpSession session=request.getSession();
				MemberVO memberVO = (MemberVO)session.getAttribute("memberInfo");
				String user_id = memberVO.getUser_id();
				vo.setUser_id(user_id); 
				service.qreplycreate(vo);
				System.out.println(vo.getQ_reply());
			
				return "redirect:/admin_board_QNA.do";
			}
			
			
			
			
			
			// 4. 게시글 삭제
			@Override
			@RequestMapping(value="/admin_board_QNA_delete.do",method=RequestMethod.GET)
			public String delete2(@ModelAttribute("boardVO")BoardVO boardVO,@RequestParam("q_no")int q_no,RedirectAttributes redirect,Model model)throws Exception {
				try {
					service.deleteQNA(q_no);
					redirect.addFlashAttribute("msg", "삭제가 완료되었습니다.");
					
				}catch(Exception e) {
					redirect.addFlashAttribute("msg", "오류가 발생되었습니다.");
				}
				return "redirect:/admin_board_QNA.do";
			}
			
			
			
			// A/S 게시판
			
			
			// AS 게시판
			
			// 1. 게시글 목록(페이징, 검색 기능 추가)
			@Override
			@RequestMapping(value="/admin_board_AS.do",method=RequestMethod.GET)
			public String asList(SearchCriteriaVO scri, Model model,HttpServletRequest request,
					HttpServletResponse response) throws Exception {
				
		        int asListCnt = service.asListCnt(scri);
		        	         
		      
		        PagingVO paging = new PagingVO();
		        paging.setCri(scri);
		        paging.setTotalCount(asListCnt);  
		        
		        List<Map<String, Object>> list = service.asList(scri);
		        
		        model.addAttribute("list", list);    
		        model.addAttribute("paging", paging);    
		                
		        return "admin_board_as";		    				
			}
			
			
			// 2. 상세페이지
			
			@Override
			@RequestMapping(value="/admin_board_AS_detail.do",method={RequestMethod.GET,RequestMethod.POST})
			public ModelAndView viewAS(@RequestParam("as_no") int as_no,HttpServletRequest request,HttpServletResponse response)throws Exception{
			
				Map asMap=service.viewAS(as_no);
				ModelAndView mav=new ModelAndView();
				mav.setViewName("admin_board_as_detail");
				mav.addObject("asMap", asMap);
				return mav;
			}
			
			// 3. 게시글 접수 및 답변
			
			@Override
			@RequestMapping(value="/admin_board_AS_receive.do",method=RequestMethod.GET)
			public String asreceive(@ModelAttribute("boardVO")BoardVO boardVO,@RequestParam("as_no")int as_no,RedirectAttributes redirect,Model model)throws Exception {
				try {
					service.receiveAS(as_no);
					redirect.addFlashAttribute("msg", "접수가 완료되었습니다.");
											
				}catch(Exception e) {
					redirect.addFlashAttribute("msg", "오류가 발생되었습니다.");
				}
				return "redirect:/admin_board_AS.do";
					}
						
						
						
					
			@Override
			@RequestMapping(value="/admin_board_AS_receive_write.do",method=RequestMethod.GET)
			public ModelAndView asreceive_write(@RequestParam("as_no") int as_no,HttpServletRequest request,HttpServletResponse response)throws Exception{
				Map asMap=service.viewAS(as_no);
				ModelAndView mav=new ModelAndView();
				mav.setViewName("admin_board_AS_receive");
				mav.addObject("asMap", asMap);
				return mav;
			}
						
						
			@Override
			@RequestMapping(value="/admin_board_AS_receive_write.do",method=RequestMethod.POST)
			public String asreceive_write_action(BoardVO vo,HttpServletRequest request,HttpServletResponse response)throws Exception{
							
				HttpSession session=request.getSession();
				MemberVO memberVO = (MemberVO)session.getAttribute("memberInfo");
				String user_id = memberVO.getUser_id();
				vo.setUser_id(user_id); 
				service.asreplycreate(vo);
				System.out.println(vo.getAs_reply());
						
				return "redirect:/admin_board_AS.do";
			}
						
			
			// 4. 게시글 삭제
			@Override
			@RequestMapping(value="/admin_board_AS_delete.do",method=RequestMethod.GET)
			public String delete3(@ModelAttribute("boardVO")BoardVO boardVO,@RequestParam("as_no")int as_no,RedirectAttributes redirect,Model model)throws Exception {
				try {
					service.deleteAS(as_no);
					redirect.addFlashAttribute("msg", "삭제가 완료되었습니다.");
					
				}catch(Exception e) {
					redirect.addFlashAttribute("msg", "오류가 발생되었습니다.");
				}
				return "redirect:/admin_board_AS.do";
			}
								
						
						
	
}
