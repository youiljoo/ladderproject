package com.mycompany.teamproject.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.member.vo.MemberVO;
import com.mycompany.teamproject.order.vo.OrderVO;

public interface MemberController {
	// �α���, �α׾ƿ�
	public ModelAndView login(@RequestParam Map<String, String> loginMap,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// ȸ�����ԿϷ�
	public ResponseEntity  addMember(@ModelAttribute("member") MemberVO member, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// ���̵�, �г���, �̸��� �ߺ�Ȯ��
	public ResponseEntity  overlapped(@RequestParam("id") String id,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity  overlappedNickname(@RequestParam("nickname") String nickname,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity  overlappedEmail(@RequestParam("email") String email,HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// ���̵� ã��
	public ModelAndView selectIdPhone(MemberVO memberVO, HttpServletResponse response, HttpServletRequest request) throws Exception;
	public ModelAndView selectIdEmail(MemberVO memberVO, HttpServletResponse response, HttpServletRequest request) throws Exception;
	
	// ��й�ȣ ã��, ����
	public ModelAndView selectPwPhone(MemberVO memberVO, HttpServletResponse response, HttpServletRequest request) throws Exception;
	public ModelAndView selectPwEmail(MemberVO memberVO, HttpServletResponse response, HttpServletRequest request) throws Exception;
	
	// �޴��� ����
	public String sendSMS(@RequestParam("user_phone") String user_phone);
	
	// �̸��� ����
	public String emailCheck(@RequestParam("user_email") String user_email) throws Exception;
	
	// ȸ������ ���� -> �Ϸ�
	public String membereditPost(MemberVO memberVO, HttpSession session,  RedirectAttributes re) throws Exception;
	
	// ��ȸ�� �ֹ���ȸ
	public ModelAndView nonmember(OrderVO orderVO, HttpServletResponse response, HttpServletRequest request) throws Exception;
}
