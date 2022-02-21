package com.mycompany.teamproject.member.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.member.vo.MemberVO;
import com.mycompany.teamproject.order.vo.OrderVO;

@Repository("memberDAO")
public class MemberDAOImpl  implements MemberDAO{
	@Autowired
	private SqlSession sqlSession;	
	static Logger logger = LoggerFactory.getLogger(MemberDAO.class);
	
	// 로그인
	@Override
	public MemberVO login(Map loginMap) throws DataAccessException{
		MemberVO member=(MemberVO)sqlSession.selectOne("mapper.member.login",loginMap);
	   return member;
	}
	
	// 회원가입
	@Override
	public void insertNewMember(MemberVO memberVO) throws DataAccessException{
		sqlSession.insert("mapper.member.insertNewMember",memberVO);
	}
	
	// 아이디, 닉네임, 이메일 중복확인
	@Override
	public String selectOverlappedID(String id) throws DataAccessException {
		String result =  sqlSession.selectOne("mapper.member.selectOverlappedID",id);
		return result;
	}	
	
	@Override
	public String selectOverlappedNickname(String nickname) throws DataAccessException {
		String result =  sqlSession.selectOne("mapper.member.selectOverlappedNickname",nickname);
		return result;
	}	
	
	@Override
	public String selectOverlappedEmail(String email) throws DataAccessException {
		String result =  sqlSession.selectOne("mapper.member.selectOverlappedEmail",email);
		return result;
	}
	
	// 아이디 찾기
	@Override
	public MemberVO selectIdPhone(MemberVO memberVO) throws Exception{
		return sqlSession.selectOne("mapper.member.selectIdPhone", memberVO);
	}
	
	@Override
	public MemberVO selectIdEmail(MemberVO memberVO) throws Exception{
		return sqlSession.selectOne("mapper.member.selectIdEmail", memberVO);
	}
	
	// 비밀번호 찾기
	@Override
	public MemberVO selectPwPhone(MemberVO memberVO) throws Exception{
		return sqlSession.selectOne("mapper.member.selectPwPhone", memberVO);
	}
	
	@Override
	public MemberVO selectPwEmail(MemberVO memberVO) throws Exception{
		return sqlSession.selectOne("mapper.member.selectPwEmail", memberVO);
	}
	
	// 비밀번호 변경
	@Override
	public void updatePw(MemberVO memberVO) throws Exception {
		sqlSession.update("mapper.member.changePw", memberVO);
	}
	
	// 회원 탈퇴
	@Override
	public void deleteId(MemberVO memberVO) throws Exception {
		sqlSession.delete("mapper.member.deleteId",memberVO);
	}
	
	// 회원정보 수정 비밀번호 체크
	@Override
	public void memberedit_pw(MemberVO memberVO) throws Exception {
		sqlSession.selectOne("mapper.member.memberedit_pw",memberVO);
	}
	
	// 회원정보 수정
	@Override
	public void memberedit(MemberVO memberVO) throws Exception {
		sqlSession.update("mapper.member.memberedit", memberVO);
		System.out.println("회원 수정 DAO 완료");
	}
	
	// 회원, 비회원 주문조회
	@Override
	public List<OrderVO> nonMember(OrderVO orderVO) throws Exception {
		return sqlSession.selectList("mapper.order.nonMember", orderVO);
	}
	
	@Override
	public List<OrderVO> nonMemberSelect(OrderVO orderVO) throws Exception {
		return sqlSession.selectOne("mapper.order.nonMemberSelect", orderVO);
	}
}
