package com.mycompany.teamproject.admin.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.teamproject.admin.board.vo.AdminBoardVO;
import com.mycompany.teamproject.board.vo.BoardVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;

public interface AdminBoardController {
	// 회원 전용 공지사항
	public ModelAndView noticeList(SearchCriteriaVO scri,HttpServletRequest request,HttpServletResponse response) throws Exception; //게시글 목록 
	public ModelAndView viewNotice(@RequestParam("n_no") int n_no,HttpServletRequest request,HttpServletResponse response)throws Exception; // 게시글 상세보기
	public String nwrite(HttpServletRequest request,HttpServletResponse response) throws Exception;											// 게시글 작성
	public String nwritecreate(BoardVO vo,HttpServletRequest request,HttpServletResponse response)throws Exception;
	public ModelAndView nupdate(@RequestParam("n_no") int n_no,HttpServletRequest request,HttpServletResponse response)throws Exception; //게시글 수정
	public String nupdate_action(@ModelAttribute("boardVO")BoardVO boardVO,HttpServletRequest request,RedirectAttributes redirect,Model model)throws Exception;
	public String ndelete(@ModelAttribute("boardVO")BoardVO boardVO,@RequestParam("n_no")int n_no,RedirectAttributes redirect,Model model)throws Exception; //게시글 삭제
	
	// 관리자 전용 공지사항
	public ModelAndView admin_main(SearchCriteriaVO scri,HttpServletRequest request,HttpServletResponse response) throws Exception; //게시글 목록
	public String adwrite(HttpServletRequest request,HttpServletResponse response) throws Exception;								// 게시글 작성
	public String adwritecreate(AdminBoardVO adVO,HttpServletRequest request,HttpServletResponse response)throws Exception;
	public ModelAndView admin_main_notice(@RequestParam("a_main_NO") int a_main_NO,HttpServletRequest request,HttpServletResponse response)throws Exception; // 게시글 상세보기
	public ModelAndView adupdate(@RequestParam("a_main_NO") int a_main_NO,HttpServletRequest request,HttpServletResponse response)throws Exception; //게시글 수정
	public String adupdate_action(@ModelAttribute("adVO")AdminBoardVO adVO,HttpServletRequest request,RedirectAttributes redirect,Model model)throws Exception;
	public String addelete(@ModelAttribute("adVO")AdminBoardVO adVO,@RequestParam("a_main_NO")int a_main_NO,RedirectAttributes redirect,Model model)throws Exception; //게시글 삭제
	
	//상담문의
	
	public ModelAndView consultingList(SearchCriteriaVO scri,HttpServletRequest request,HttpServletResponse response) throws Exception; //게시글 목록
	public ModelAndView viewConsulting(@RequestParam("c_no") int c_no,HttpServletRequest request,HttpServletResponse response)throws Exception; // 게시글 상세보기
	public String creceive(@ModelAttribute("boardVO")BoardVO boardVO,@RequestParam("c_no")int c_no,RedirectAttributes redirect,Model model)throws Exception; // 게시글 접수 및 답변
	public ModelAndView creceive_write(@RequestParam("c_no") int c_no,HttpServletRequest request,HttpServletResponse response)throws Exception;
	public String creceive_write_action(BoardVO vo,HttpServletRequest request,HttpServletResponse response)throws Exception;
	public String delete(@ModelAttribute("boardVO")BoardVO boardVO,@RequestParam("c_no")int c_no,RedirectAttributes redirect,Model model)throws Exception; //게시글 삭제
	
	//Q&A
	public String qnaList(SearchCriteriaVO scri, Model model,HttpServletRequest request,HttpServletResponse response) throws Exception; //게시글 목록
	public ModelAndView viewQNA(@RequestParam("q_no") int q_no,HttpServletRequest request,HttpServletResponse response)throws Exception; // 게시글 상세보기
	public String qreceive(@ModelAttribute("boardVO")BoardVO boardVO,@RequestParam("q_no")int q_no,RedirectAttributes redirect,Model model)throws Exception; // 게시글 접수 및 답변
	public ModelAndView qreceive_write(@RequestParam("q_no") int q_no,HttpServletRequest request,HttpServletResponse response)throws Exception;
	public String qreceive_write_action(BoardVO vo,HttpServletRequest request,HttpServletResponse response)throws Exception;  
	public String delete2(@ModelAttribute("boardVO")BoardVO boardVO,@RequestParam("q_no")int q_no,RedirectAttributes redirect,Model model)throws Exception; //게시글 삭제
	
	//AS
	public String asList(SearchCriteriaVO scri, Model model,HttpServletRequest request,HttpServletResponse response) throws Exception; // 게시글 목록
	public ModelAndView viewAS(@RequestParam("as_no") int as_no,HttpServletRequest request,HttpServletResponse response)throws Exception; // 게시글 상세보기
	public String asreceive(@ModelAttribute("boardVO")BoardVO boardVO,@RequestParam("as_no")int as_no,RedirectAttributes redirect,Model model)throws Exception; // 게시글 접수 및 답변
	public ModelAndView asreceive_write(@RequestParam("as_no") int q_no,HttpServletRequest request,HttpServletResponse response)throws Exception;
	public String asreceive_write_action(BoardVO vo,HttpServletRequest request,HttpServletResponse response)throws Exception; 
	public String delete3(@ModelAttribute("boardVO")BoardVO boardVO,@RequestParam("as_no")int as_no,RedirectAttributes redirect,Model model)throws Exception;
	
}
