package com.mycompany.teamproject.admin.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.member.vo.MemberVO;

public interface AdminMemberController {
	// ������ ȸ�� ����Ʈ
	public ModelAndView adminmember(SearchCriteriaVO scri, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// ȸ������ ��������
	public ModelAndView adminmemberde(@RequestParam("user_id") String user_id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// ������ ����Ż��
	public ModelAndView adminDelete(@RequestParam("user_id") String user_id, HttpServletRequest request, HttpServletResponse respon) throws Exception;
	
	// ������ ȸ������
	public ModelAndView adminUpdate(MemberVO memberVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
