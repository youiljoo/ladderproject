package com.mycompany.teamproject.member.dao;


import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.member.vo.MemberVO;
import com.mycompany.teamproject.order.vo.OrderVO;

public interface MemberDAO {
	// 로그인
	public MemberVO login(Map loginMap) throws DataAccessException;
	
	// 회원가입
	public void insertNewMember(MemberVO memberVO) throws Exception;
	
	// 아이디, 닉네임, 이메일 중복확인
	public String selectOverlappedID(String id) throws DataAccessException;
	public String selectOverlappedNickname(String nickname) throws DataAccessException;
	public String selectOverlappedEmail(String email) throws DataAccessException;
	
	// 아이디 찾기
	public MemberVO selectIdPhone(MemberVO memberVO) throws Exception;
	public MemberVO selectIdEmail(MemberVO memberVO) throws Exception;
	
	// 비밀번호 찾기
	public MemberVO selectPwPhone(MemberVO memberVO) throws Exception;
	public MemberVO selectPwEmail(MemberVO memberVO) throws Exception;
	
	// 비밀번호 변경
	public void updatePw(MemberVO memberVO) throws Exception;
	
	// 회원 탈퇴
	public void deleteId(MemberVO memberVO) throws Exception;
	
	// 회원정보 수정 비밀번호 체크
	public void memberedit_pw(MemberVO memberVO) throws Exception;
	
	// 회원정보 수정
	public void memberedit(MemberVO memberVO) throws Exception;
	
	// 회원, 비회원 주문조회
	public List<OrderVO> nonMember(OrderVO orderVO) throws Exception;
	public List<OrderVO> nonMemberSelect(OrderVO orderVO) throws Exception;
}
