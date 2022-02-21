package com.mycompany.teamproject.member.service;


import java.util.List;
import java.util.Map;

import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.member.vo.MemberVO;
import com.mycompany.teamproject.order.vo.OrderVO;

public interface MemberService {
	// �α���
	public MemberVO login(Map loginMap) throws Exception;
	
	// ȸ������
	public void addMember(MemberVO memberVO) throws Exception;
	
	// �ߺ�Ȯ��
	public String overlapped(String id) throws Exception;
	public String overlappednickname(String nickname) throws Exception;
	public String overlappedemail(String email) throws Exception;
	
	// ���̵� ã��
	public MemberVO selectIdPhone(MemberVO memberVO) throws Exception;
	public MemberVO selectIdEmail(MemberVO memberVO) throws Exception;
	
	// ��й�ȣ ã��
	public MemberVO selectPwPhone(MemberVO memberVO) throws Exception;
	public MemberVO selectPwEmail(MemberVO memberVO) throws Exception;
	
	// ��й�ȣ ����
	public void updatePw(MemberVO memberVO) throws Exception;
	
	// �޴��� ����
	public void certifiedPhoneNumber(String user_phone, int randomNumber);
	
	// ȸ��Ż��
	public void deleteId(MemberVO memberVO) throws Exception;
	
	// ȸ������ ���� ��к�ȣ üũ
	public void memberedit_pw(MemberVO memberVO) throws Exception;
	
	// ȸ������ ����
	public void memberedit(MemberVO memberVO) throws Exception;
	
	// ȸ��, ��ȸ�� �ֹ���ȸ
	public List<OrderVO> nonMember(OrderVO orderVO) throws Exception;
	public List<OrderVO> nonMemberSelect(OrderVO orderVO) throws Exception;
}
