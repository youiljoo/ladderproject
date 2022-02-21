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
	
	// 관리자 회원 리스트
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
	
	// 관리자 회원정보 상세페이지
	@Override
	public MemberVO memberDetails(String user_id) throws Exception {
		return adminMemberDAO.memberDetails(user_id);
	}
	
	// 관리자 강제탈퇴
	@Override
	public void adminDelete(String user_id) throws Exception {
		adminMemberDAO.adminDelete(user_id);
	}
	
	// 관리자 회원정보 수정
	@Override
	public void adminUpdate(MemberVO memberVO) throws Exception {
		adminMemberDAO.adminUpdate(memberVO);
	}
}
