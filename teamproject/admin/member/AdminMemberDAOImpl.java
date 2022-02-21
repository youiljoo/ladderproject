package com.mycompany.teamproject.admin.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.member.vo.MemberVO;

@Repository("adminMemberDAO")
public class AdminMemberDAOImpl implements AdminMemberDAO {
	@Autowired
	private SqlSession sqlSession;
	
	// ������ ȸ�� ����Ʈ
	@Override
	public List<Map<String, Object>> adminSelect(SearchCriteriaVO scri) throws Exception {
		return sqlSession.selectList("mapper.admin_member.adminSelect", scri);
	}
	
	@Override
	public int adminListCnt(SearchCriteriaVO scri) throws Exception {
		return sqlSession.selectOne("mapper.admin_member.adminListCnt", scri);
	}
	
	@Override
	public List<MemberVO> selectMember(MemberVO memberVO) throws Exception { 
		List<MemberVO> selectMember = (List)sqlSession.selectList("mapper.admin_member.selectMember", memberVO);
		return selectMember;
	}
	
	// ������ ȸ������ ��������
	@Override
	public MemberVO memberDetails(String user_id) throws Exception {
		return sqlSession.selectOne("mapper.admin_member.memberDetails", user_id);
	}
	
	// ������ ����Ż��
	@Override
	public void adminDelete(String user_id) throws Exception {
		sqlSession.delete("mapper.admin_member.adminDelete", user_id);
	}
	
	// ������ ȸ������ ����
	@Override
	public void adminUpdate(MemberVO memberVO) throws Exception {
		sqlSession.update("mapper.admin_member.adminUpdate", memberVO);
	}
}
