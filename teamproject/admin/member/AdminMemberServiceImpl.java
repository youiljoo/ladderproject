package com.mycompany.teamproject.admin.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.teamproject.admin.member.dao.AdminMemberDAO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.member.vo.MemberVO;

@Service("adminMemberService")
@Transactional(propagation=Propagation.REQUIRED)
public class AdminMemberServiceImpl implements AdminMemberService {
	@Autowired
	private AdminMemberDAO adminMemberDAO;
	
	// ������ ȸ�� ����Ʈ
	@Override
	public List<Map<String, Object>> adminSelect(SearchCriteriaVO scri) throws Exception {
		List<Map<String, Object>> adminSelect = adminMemberDAO.adminSelect(scri);
		return adminSelect;
	}
	
	@Override
	public int adminListCnt(SearchCriteriaVO scri) throws Exception {
		return adminMemberDAO.adminListCnt(scri);
	}
	
	@Override
	public List<MemberVO> selectMember(MemberVO memberVO) throws Exception {
		return adminMemberDAO.selectMember(memberVO);
	}
	
	// ������ ȸ������ ��������
	@Override
	public MemberVO memberDetails(String user_id) throws Exception {
		return adminMemberDAO.memberDetails(user_id);
	}
	
	// ������ ����Ż��
	@Override
	public void adminDelete(String user_id) throws Exception {
		adminMemberDAO.adminDelete(user_id);
	}
	
	// ������ ȸ������ ����
	@Override
	public void adminUpdate(MemberVO memberVO) throws Exception {
		adminMemberDAO.adminUpdate(memberVO);
	}
}
