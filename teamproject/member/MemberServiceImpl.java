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
	
	// �α���
	@Override
	public MemberVO login(Map  loginMap) throws Exception{
		return memberDAO.login(loginMap);
	}

	// ȸ������
	@Override
	public void addMember(MemberVO memberVO) throws Exception {
		memberDAO.insertNewMember(memberVO);
		
	// ���̵�, �г���, �̸��� �ߺ�Ȯ��
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
	
	// ���̵� ã��
	@Override
	public MemberVO selectIdPhone(MemberVO memberVO) throws Exception {
		return memberDAO.selectIdPhone(memberVO);
	}
	
	@Override
	public MemberVO selectIdEmail(MemberVO memberVO) throws Exception {
		return memberDAO.selectIdEmail(memberVO);
	}
	
	// ��й�ȣ ã��
	@Override
	public MemberVO selectPwPhone(MemberVO memberVO) throws Exception {
		return memberDAO.selectPwPhone(memberVO);
	}
	
	@Override
	public MemberVO selectPwEmail(MemberVO memberVO) throws Exception {
		return memberDAO.selectPwEmail(memberVO);
	}
	
	// ��й�ȣ ����
	@Override
	public void updatePw(MemberVO memberVO) throws Exception {
		memberDAO.updatePw(memberVO);
	}
	
	// �޴��� ����
	@Override
	public void certifiedPhoneNumber(String user_phone, int randomNumber) {
		String api_key = "NCSEGUD8DJ1ZVKSN";
		String api_secret = "LMQGCST33EQB3S3TYLBMETOUKOJ1Y8WZ";
		Message coolsms = new Message(api_key, api_secret);
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", user_phone);
		params.put("from", "01089832348");
		params.put("type", "SMS");
		params.put("text", "������ȣ��" + "["+randomNumber+"]" + "�Դϴ�.");
		params.put("app_version", "test app 1.2");
		
		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
	}
	
	// ȸ�� Ż��
	@Override
	public void deleteId(MemberVO memberVO) throws Exception {
		memberDAO.deleteId(memberVO);
	}
	
	// ȸ������ ���� ��й�ȣ üũ
	@Override
	public void memberedit_pw(MemberVO memberVO) throws Exception {
		memberDAO.memberedit_pw(memberVO);
	}
	
	// ȸ������ ����
	@Override
	public void memberedit(MemberVO memberVO) throws Exception {
		memberDAO.memberedit(memberVO);
		System.out.println("ȸ�� ���� ���� �Ϸ�");
	}
	
	// ȸ��, ��ȸ�� �ֹ���ȸ
	@Override
	public List<OrderVO> nonMember(OrderVO orderVO) throws Exception {
		return memberDAO.nonMember(orderVO);
	}
	
	@Override
	public List<OrderVO> nonMemberSelect(OrderVO orderVO) throws Exception {
		return memberDAO.nonMemberSelect(orderVO);
	}
	
}
