package com.mycompany.teamproject.member.service;


import java.util.List;
import java.util.Map;

import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.member.vo.MemberVO;
import com.mycompany.teamproject.order.vo.OrderVO;

public interface MemberService {
	// 로그인
	public MemberVO login(Map loginMap) throws Exception;
	
	// 회원가입
	public void addMember(MemberVO memberVO) throws Exception;
	
	// 중복확인
	public String overlapped(String id) throws Exception;
	public String overlappednickname(String nickname) throws Exception;
	public String overlappedemail(String email) throws Exception;
	
	// 아이디 찾기
	public MemberVO selectIdPhone(MemberVO memberVO) throws Exception;
	public MemberVO selectIdEmail(MemberVO memberVO) throws Exception;
	
	// 비밀번호 찾기
	public MemberVO selectPwPhone(MemberVO memberVO) throws Exception;
	public MemberVO selectPwEmail(MemberVO memberVO) throws Exception;
	
	// 비밀번호 변경
	public void updatePw(MemberVO memberVO) throws Exception;
	
	// 휴대폰 인증
	public void certifiedPhoneNumber(String user_phone, int randomNumber);
	
	// 회원탈퇴
	public void deleteId(MemberVO memberVO) throws Exception;
	
	// 회원정보 수정 비밀빈호 체크
	public void memberedit_pw(MemberVO memberVO) throws Exception;
	
	// 회원정보 수정
	public void memberedit(MemberVO memberVO) throws Exception;
	
	// 회원, 비회원 주문조회
	public List<OrderVO> nonMember(OrderVO orderVO) throws Exception;
	public List<OrderVO> nonMemberSelect(OrderVO orderVO) throws Exception;
}
