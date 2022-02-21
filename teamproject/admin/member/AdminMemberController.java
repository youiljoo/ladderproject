package com.mycompany.teamproject.admin.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.member.vo.MemberVO;

public interface AdminMemberController {
	// 관리자 회원 리스트
	public ModelAndView adminmember(SearchCriteriaVO scri, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// 회원정보 상세페이지
	public ModelAndView adminmemberde(@RequestParam("user_id") String user_id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// 관리자 강제탈퇴
	public ModelAndView adminDelete(@RequestParam("user_id") String user_id, HttpServletRequest request, HttpServletResponse respon) throws Exception;
	
	// 관리자 회원수정
	public ModelAndView adminUpdate(MemberVO memberVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
