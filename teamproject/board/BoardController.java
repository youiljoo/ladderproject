package com.mycompany.teamproject.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.teamproject.board.vo.BoardVO;

import com.mycompany.teamproject.board.vo.SearchCriteriaVO;

public interface BoardController {
	
	// ��������
	public ModelAndView noticeList(SearchCriteriaVO scri,HttpServletRequest request,HttpServletResponse response)throws Exception; //�� ��� (����¡,�˻� ��� �߰�)
	public ModelAndView viewNotice(@RequestParam("n_no") int n_no,HttpServletRequest request,HttpServletResponse response)throws Exception; // �Խñ� �󼼺���
	// ��㹮�� �Խ���
	public ModelAndView consultingList(SearchCriteriaVO scri,HttpServletRequest request,HttpServletResponse response)throws Exception; //�� ��� (����¡,�˻� ��� �߰�)	
	public String getcreate(HttpServletRequest request,HttpServletResponse response) throws Exception; // �� ���	
	public String postcreate(BoardVO vo,HttpServletRequest request,HttpServletResponse response)throws Exception;	
	public ModelAndView viewConsulting(@RequestParam("c_no") int c_no,HttpServletRequest request,HttpServletResponse response)throws Exception; // �Խñ� �󼼺���	
	public ModelAndView update(@RequestParam("c_no") int c_no,HttpServletRequest request,HttpServletResponse response)throws Exception; //�Խñ� ����	
	public String update_action(@ModelAttribute("boardVO")BoardVO boardVO,HttpServletRequest request,RedirectAttributes redirect,Model model)throws Exception;	
	public String delete(@ModelAttribute("boardVO")BoardVO boardVO,@RequestParam("c_no")int c_no,RedirectAttributes redirect,Model model)throws Exception; //�Խñ� ����
	
	// Q&A �Խ���
	public String qnaList(SearchCriteriaVO scri,Model model,HttpServletRequest request,HttpServletResponse response)throws Exception; //�� ��� (����¡, �˻� ��� �߰�)
	public String getcreate2(HttpServletRequest request,HttpServletResponse response) throws Exception; // �� ���
	public String postcreate2(BoardVO vo,HttpServletRequest request,HttpServletResponse response)throws Exception;
	public ModelAndView viewQNA(@RequestParam("q_no") int q_no,HttpServletRequest request,HttpServletResponse response)throws Exception; // �Խñ� �󼼺���
	public ModelAndView update2(@RequestParam("q_no") int q_no,HttpServletRequest request,HttpServletResponse response)throws Exception; //�Խñ� ����	
	public String update_action2(@ModelAttribute("boardVO")BoardVO boardVO,HttpServletRequest request,RedirectAttributes redirect,Model model)throws Exception;	
	public String delete2(@ModelAttribute("boardVO")BoardVO boardVO,@RequestParam("q_no")int q_no,RedirectAttributes redirect,Model model)throws Exception; //�Խñ� ����
	
	
	
	// A/S �Խ���
	public String asList(SearchCriteriaVO scri,Model model,HttpServletRequest request,HttpServletResponse response)throws Exception; //�� ���(����¡, �˻� ��� �߰�)
	public String getcreate3(HttpServletRequest request,HttpServletResponse response) throws Exception; // �� ���
	public ResponseEntity postcreate3(MultipartHttpServletRequest multipartRequest,HttpServletResponse response)throws Exception;
	public ModelAndView viewAS(@RequestParam("as_no") int as_no,HttpServletRequest request,HttpServletResponse response)throws Exception; // �Խñ� �󼼺���
	public ModelAndView update3(@RequestParam("as_no") int as_no,HttpServletRequest request,HttpServletResponse response)throws Exception;  //�Խñ� ����
	public ResponseEntity update_action3(MultipartHttpServletRequest multipartRequest,HttpServletResponse response)throws Exception;
	public String delete3(@ModelAttribute("boardVO")BoardVO boardVO,@RequestParam("as_no")int as_no,RedirectAttributes redirect,Model model)throws Exception; //�Խñ� ����
	
	

	
}
