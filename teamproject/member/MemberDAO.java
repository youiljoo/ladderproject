package com.mycompany.teamproject.member.dao;


import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.member.vo.MemberVO;
import com.mycompany.teamproject.order.vo.OrderVO;

public interface MemberDAO {
	// �α���
	public MemberVO login(Map loginMap) throws DataAccessException;
	
	// ȸ������
	public void insertNewMember(MemberVO memberVO) throws Exception;
	
	// ���̵�, �г���, �̸��� �ߺ�Ȯ��
	public String selectOverlappedID(String id) throws DataAccessException;
	public String selectOverlappedNickname(String nickname) throws DataAccessException;
	public String selectOverlappedEmail(String email) throws DataAccessException;
	
	// ���̵� ã��
	public MemberVO selectIdPhone(MemberVO memberVO) throws Exception;
	public MemberVO selectIdEmail(MemberVO memberVO) throws Exception;
	
	// ��й�ȣ ã��
	public MemberVO selectPwPhone(MemberVO memberVO) throws Exception;
	public MemberVO selectPwEmail(MemberVO memberVO) throws Exception;
	
	// ��й�ȣ ����
	public void updatePw(MemberVO memberVO) throws Exception;
	
	// ȸ�� Ż��
	public void deleteId(MemberVO memberVO) throws Exception;
	
	// ȸ������ ���� ��й�ȣ üũ
	public void memberedit_pw(MemberVO memberVO) throws Exception;
	
	// ȸ������ ����
	public void memberedit(MemberVO memberVO) throws Exception;
	
	// ȸ��, ��ȸ�� �ֹ���ȸ
	public List<OrderVO> nonMember(OrderVO orderVO) throws Exception;
	public List<OrderVO> nonMemberSelect(OrderVO orderVO) throws Exception;
}
