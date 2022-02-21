package com.mycompany.teamproject.admin.member.dao;

import java.util.List;
import java.util.Map;

import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.member.vo.MemberVO;

public interface AdminMemberDAO {
	
	// ������ ȸ�� ����Ʈ
	public List<Map<String, Object>> adminSelect(SearchCriteriaVO scri) throws Exception;
	public int adminListCnt(SearchCriteriaVO scri) throws Exception;
	public List<MemberVO> selectMember(MemberVO memberVO) throws Exception;
	
	// ������ ȸ������ ��������
	public MemberVO memberDetails(String user_id) throws Exception;
	
	// ������ ����Ż��
	public void adminDelete(String user_id) throws Exception;
	
	// ������ ȸ������ ����
	public void adminUpdate(MemberVO memberVO) throws Exception;
}
