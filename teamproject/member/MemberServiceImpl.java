package com.mycompany.teamproject.member.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.teamproject.member.dao.MemberDAO;
import com.mycompany.teamproject.member.vo.MemberVO;
import com.mycompany.teamproject.order.vo.OrderVO;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Service("memberService")
@Transactional(propagation=Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	// 로그인
	@Override
	public MemberVO login(Map  loginMap) throws Exception{
		return memberDAO.login(loginMap);
	}

	// 회원가입
	@Override
	public void addMember(MemberVO memberVO) throws Exception {
		memberDAO.insertNewMember(memberVO);
		
	// 아이디, 닉네임, 이메일 중복확인
	}
	@Override
	public String overlapped(String id) throws Exception{
		return memberDAO.selectOverlappedID(id);
	}
	
	@Override
	public String overlappednickname(String nickname) throws Exception{
		return memberDAO.selectOverlappedNickname(nickname);
	}
	
	@Override
	public String overlappedemail(String email) throws Exception{
		return memberDAO.selectOverlappedEmail(email);
	}
	
	// 아이디 찾기
	@Override
	public MemberVO selectIdPhone(MemberVO memberVO) throws Exception {
		return memberDAO.selectIdPhone(memberVO);
	}
	
	@Override
	public MemberVO selectIdEmail(MemberVO memberVO) throws Exception {
		return memberDAO.selectIdEmail(memberVO);
	}
	
	// 비밀번호 찾기
	@Override
	public MemberVO selectPwPhone(MemberVO memberVO) throws Exception {
		return memberDAO.selectPwPhone(memberVO);
	}
	
	@Override
	public MemberVO selectPwEmail(MemberVO memberVO) throws Exception {
		return memberDAO.selectPwEmail(memberVO);
	}
	
	// 비밀번호 변경
	@Override
	public void updatePw(MemberVO memberVO) throws Exception {
		memberDAO.updatePw(memberVO);
	}
	
	// 휴대폰 인증
	@Override
	public void certifiedPhoneNumber(String user_phone, int randomNumber) {
		String api_key = "NCSEGUD8DJ1ZVKSN";
		String api_secret = "LMQGCST33EQB3S3TYLBMETOUKOJ1Y8WZ";
		Message coolsms = new Message(api_key, api_secret);
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", user_phone);
		params.put("from", "01089832348");
		params.put("type", "SMS");
		params.put("text", "인증번호는" + "["+randomNumber+"]" + "입니다.");
		params.put("app_version", "test app 1.2");
		
		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
	}
	
	// 회원 탈퇴
	@Override
	public void deleteId(MemberVO memberVO) throws Exception {
		memberDAO.deleteId(memberVO);
	}
	
	// 회원정보 수정 비밀번호 체크
	@Override
	public void memberedit_pw(MemberVO memberVO) throws Exception {
		memberDAO.memberedit_pw(memberVO);
	}
	
	// 회원정보 수정
	@Override
	public void memberedit(MemberVO memberVO) throws Exception {
		memberDAO.memberedit(memberVO);
		System.out.println("회원 수정 서비스 완료");
	}
	
	// 회원, 비회원 주문조회
	@Override
	public List<OrderVO> nonMember(OrderVO orderVO) throws Exception {
		return memberDAO.nonMember(orderVO);
	}
	
	@Override
	public List<OrderVO> nonMemberSelect(OrderVO orderVO) throws Exception {
		return memberDAO.nonMemberSelect(orderVO);
	}
	
}
