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
	// ȸ�� ���� ��������
	public ModelAndView noticeList(SearchCriteriaVO scri,HttpServletRequest request,HttpServletResponse response) throws Exception; //�Խñ� ��� 
	public ModelAndView viewNotice(@RequestParam("n_no") int n_no,HttpServletRequest request,HttpServletResponse response)throws Exception; // �Խñ� �󼼺���
	public String nwrite(HttpServletRequest request,HttpServletResponse response) throws Exception;											// �Խñ� �ۼ�
	public String nwritecreate(BoardVO vo,HttpServletRequest request,HttpServletResponse response)throws Exception;
	public ModelAndView nupdate(@RequestParam("n_no") int n_no,HttpServletRequest request,HttpServletResponse response)throws Exception; //�Խñ� ����
	public String nupdate_action(@ModelAttribute("boardVO")BoardVO boardVO,HttpServletRequest request,RedirectAttributes redirect,Model model)throws Exception;
	public String ndelete(@ModelAttribute("boardVO")BoardVO boardVO,@RequestParam("n_no")int n_no,RedirectAttributes redirect,Model model)throws Exception; //�Խñ� ����
	
	// ������ ���� ��������
	public ModelAndView admin_main(SearchCriteriaVO scri,HttpServletRequest request,HttpServletResponse response) throws Exception; //�Խñ� ���
	public String adwrite(HttpServletRequest request,HttpServletResponse response) throws Exception;								// �Խñ� �ۼ�
	public String adwritecreate(AdminBoardVO adVO,HttpServletRequest request,HttpServletResponse response)throws Exception;
	public ModelAndView admin_main_notice(@RequestParam("a_main_NO") int a_main_NO,HttpServletRequest request,HttpServletResponse response)throws Exception; // �Խñ� �󼼺���
	public ModelAndView adupdate(@RequestParam("a_main_NO") int a_main_NO,HttpServletRequest request,HttpServletResponse response)throws Exception; //�Խñ� ����
	public String adupdate_action(@ModelAttribute("adVO")AdminBoardVO adVO,HttpServletRequest request,RedirectAttributes redirect,Model model)throws Exception;
	public String addelete(@ModelAttribute("adVO")AdminBoardVO adVO,@RequestParam("a_main_NO")int a_main_NO,RedirectAttributes redirect,Model model)throws Exception; //�Խñ� ����
	
	//��㹮��
	
	public ModelAndView consultingList(SearchCriteriaVO scri,HttpServletRequest request,HttpServletResponse response) throws Exception; //�Խñ� ���
	public ModelAndView viewConsulting(@RequestParam("c_no") int c_no,HttpServletRequest request,HttpServletResponse response)throws Exception; // �Խñ� �󼼺���
	public String creceive(@ModelAttribute("boardVO")BoardVO boardVO,@RequestParam("c_no")int c_no,RedirectAttributes redirect,Model model)throws Exception; // �Խñ� ���� �� �亯
	public ModelAndView creceive_write(@RequestParam("c_no") int c_no,HttpServletRequest request,HttpServletResponse response)throws Exception;
	public String creceive_write_action(BoardVO vo,HttpServletRequest request,HttpServletResponse response)throws Exception;
	public String delete(@ModelAttribute("boardVO")BoardVO boardVO,@RequestParam("c_no")int c_no,RedirectAttributes redirect,Model model)throws Exception; //�Խñ� ����
	
	//Q&A
	public String qnaList(SearchCriteriaVO scri, Model model,HttpServletRequest request,HttpServletResponse response) throws Exception; //�Խñ� ���
	public ModelAndView viewQNA(@RequestParam("q_no") int q_no,HttpServletRequest request,HttpServletResponse response)throws Exception; // �Խñ� �󼼺���
	public String qreceive(@ModelAttribute("boardVO")BoardVO boardVO,@RequestParam("q_no")int q_no,RedirectAttributes redirect,Model model)throws Exception; // �Խñ� ���� �� �亯
	public ModelAndView qreceive_write(@RequestParam("q_no") int q_no,HttpServletRequest request,HttpServletResponse response)throws Exception;
	public String qreceive_write_action(BoardVO vo,HttpServletRequest request,HttpServletResponse response)throws Exception;  
	public String delete2(@ModelAttribute("boardVO")BoardVO boardVO,@RequestParam("q_no")int q_no,RedirectAttributes redirect,Model model)throws Exception; //�Խñ� ����
	
	//AS
	public String asList(SearchCriteriaVO scri, Model model,HttpServletRequest request,HttpServletResponse response) throws Exception; // �Խñ� ���
	public ModelAndView viewAS(@RequestParam("as_no") int as_no,HttpServletRequest request,HttpServletResponse response)throws Exception; // �Խñ� �󼼺���
	public String asreceive(@ModelAttribute("boardVO")BoardVO boardVO,@RequestParam("as_no")int as_no,RedirectAttributes redirect,Model model)throws Exception; // �Խñ� ���� �� �亯
	public ModelAndView asreceive_write(@RequestParam("as_no") int q_no,HttpServletRequest request,HttpServletResponse response)throws Exception;
	public String asreceive_write_action(BoardVO vo,HttpServletRequest request,HttpServletResponse response)throws Exception; 
	public String delete3(@ModelAttribute("boardVO")BoardVO boardVO,@RequestParam("as_no")int as_no,RedirectAttributes redirect,Model model)throws Exception;
	
}
