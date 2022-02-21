package com.mycompany.teamproject.admin.member.dao;

import java.util.List;
import java.util.Map;

import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.member.vo.MemberVO;

public interface AdminMemberDAO {
	
	// 관리자 회원 리스트
	public List<Map<String, Object>> adminSelect(SearchCriteriaVO scri) throws Exception;
	public int adminListCnt(SearchCriteriaVO scri) throws Exception;
	public List<MemberVO> selectMember(MemberVO memberVO) throws Exception;
	
	// 관리자 회원정보 상세페이지
	public MemberVO memberDetails(String user_id) throws Exception;
	
	// 관리자 강제탈퇴
	public void adminDelete(String user_id) throws Exception;
	
	// 관리자 회원정보 수정
	public void adminUpdate(MemberVO memberVO) throws Exception;
}
