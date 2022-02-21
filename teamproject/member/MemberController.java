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
	// 로그인, 로그아웃
	public ModelAndView login(@RequestParam Map<String, String> loginMap,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// 회원가입완료
	public ResponseEntity  addMember(@ModelAttribute("member") MemberVO member, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// 아이디, 닉네임, 이메일 중복확인
	public ResponseEntity  overlapped(@RequestParam("id") String id,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity  overlappedNickname(@RequestParam("nickname") String nickname,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity  overlappedEmail(@RequestParam("email") String email,HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	// 아이디 찾기
	public ModelAndView selectIdPhone(MemberVO memberVO, HttpServletResponse response, HttpServletRequest request) throws Exception;
	public ModelAndView selectIdEmail(MemberVO memberVO, HttpServletResponse response, HttpServletRequest request) throws Exception;
	
	// 비밀번호 찾기, 변경
	public ModelAndView selectPwPhone(MemberVO memberVO, HttpServletResponse response, HttpServletRequest request) throws Exception;
	public ModelAndView selectPwEmail(MemberVO memberVO, HttpServletResponse response, HttpServletRequest request) throws Exception;
	
	// 휴대폰 인증
	public String sendSMS(@RequestParam("user_phone") String user_phone);
	
	// 이메일 인증
	public String emailCheck(@RequestParam("user_email") String user_email) throws Exception;
	
	// 회원정보 수정 -> 완료
	public String membereditPost(MemberVO memberVO, HttpSession session,  RedirectAttributes re) throws Exception;
	
	// 비회원 주문조회
	public ModelAndView nonmember(OrderVO orderVO, HttpServletResponse response, HttpServletRequest request) throws Exception;
}
