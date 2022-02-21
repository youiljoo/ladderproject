package com.mycompany.teamproject.admin.board.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.teamproject.admin.board.vo.AdminBoardVO;
import com.mycompany.teamproject.board.vo.BoardVO;
import com.mycompany.teamproject.board.vo.ImageVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;


@Repository
public class AdminBoardDAOImpl implements AdminBoardDAO {
		
	@Inject
	private SqlSession sqlSession;
	
		// 회원 공지사항
		@Override  // 게시글 목록 (검색기능, 페이징 추가)
		public List<Map<String, Object>> noticeList(SearchCriteriaVO scri) throws Exception{
			return sqlSession.selectList("mapper.board.noticeList",scri);
		}
		@Override
		public int noticeListCnt(SearchCriteriaVO scri) throws Exception {
			return sqlSession.selectOne("mapper.board.noticeListCnt");
		}
		
		
		@Override  // 게시글 작성
		public void ncreate(BoardVO vo)throws DataAccessException {
				
			sqlSession.insert("mapper.admin_board.ncreate",vo);		
		}
		
		
		@Override  // 게시글 상세보기
		public BoardVO selectNotice(int n_no) throws DataAccessException {
			
			return sqlSession.selectOne("mapper.board.selectNotice",n_no);
			
		}
		@Override  // 게시글 수정
		public void updateNotice(BoardVO boardVO)throws Exception{
			System.out.println("수정 DAO 완료");
			sqlSession.update("mapper.admin_board.updateNotice",boardVO);
		
		}
		@Override  //게시글 삭제
		public void deleteNotice(int n_no)throws DataAccessException{
			sqlSession.delete("mapper.admin_board.deleteNotice", n_no);
		}
		
		// 관리자 공지사항
		
		@Override  // 게시글 목록 (검색기능, 페이징 추가)
		public List<Map<String, Object>> adminList(SearchCriteriaVO scri) throws Exception{
			return sqlSession.selectList("mapper.admin_board.adminList",scri);
		}
		@Override
		public int adminListCnt(SearchCriteriaVO scri) throws Exception {
			return sqlSession.selectOne("mapper.admin_board.adminListCnt");
		}
		
		@Override  // 게시글 작성
		public void adcreate(AdminBoardVO adVO)throws DataAccessException {
				
			sqlSession.insert("mapper.admin_board.adcreate",adVO);		
		}
		
		@Override  // 게시글 상세보기
		public AdminBoardVO selectadNotice(int a_main_NO) throws DataAccessException {
			
			return sqlSession.selectOne("mapper.admin_board.selectadNotice",a_main_NO);
			
		}
		
		@Override  // 게시글 수정
		public void updateadNotice(AdminBoardVO adVO)throws Exception{
			System.out.println("수정 DAO 완료");
			sqlSession.update("mapper.admin_board.updateadNotice",adVO);
		
		}
		
		@Override  //게시글 삭제
		public void deleteadNotice(int a_main_NO)throws DataAccessException{
			sqlSession.delete("mapper.admin_board.deleteadNotice", a_main_NO);
		}
		
		
		//상담문의
		
		@Override  // 게시글 목록 (검색기능, 페이징 추가)
		public List<Map<String, Object>> consultingList(SearchCriteriaVO scri) throws Exception{
			return sqlSession.selectList("mapper.board.consultingList",scri);
		}
			
		@Override
		public int consultingListCnt(SearchCriteriaVO scri) throws Exception {
			return sqlSession.selectOne("mapper.board.consultingListCnt");
		}
		
		@Override  // 게시글 상세보기
		public BoardVO selectConsulting(int c_no) throws DataAccessException {
			
			return sqlSession.selectOne("mapper.board.selectConsulting", c_no);
			
		}
		
		@Override  //게시글 접수 및 답변
		public void receiveConsulting(int c_no)throws DataAccessException{
			sqlSession.update("mapper.admin_board.receiveConsulting", c_no);
		}
		
		@Override  
		public void creplycreate(BoardVO vo)throws DataAccessException {
				
			sqlSession.update("mapper.admin_board.creplycreate",vo);
			System.out.println("접수 DAO 완료:"+vo.getC_reply());
			
			
		}
		
		@Override  //게시글 삭제
		public void deleteConsulting(int c_no)throws DataAccessException{		
			sqlSession.delete("mapper.board.deleteConsulting", c_no);
		}
		
		
		// Q&A 게시판
		
		@Override  // 게시글 목록(검색기능,페이징 추가)
		public List<Map<String, Object>> qnaList(SearchCriteriaVO scri) throws Exception{
			return sqlSession.selectList("mapper.board.qnaList",scri);
		}
		
		@Override
		public int qnaListCnt(SearchCriteriaVO scri) throws Exception {
			return sqlSession.selectOne("mapper.board.qnaListCnt");
		}
		
		@Override  //게시글 상세보기
		public BoardVO selectQNA(int q_no) throws DataAccessException {
			
			return sqlSession.selectOne("mapper.board.selectQNA", q_no);
			
		}
		
		@Override  //게시글 접수 및 답변
		public void receiveQNA(int q_no)throws DataAccessException{
			sqlSession.update("mapper.admin_board.receiveQNA", q_no);
		}
		
		@Override  
		public void qreplycreate(BoardVO vo)throws DataAccessException {
				
			sqlSession.update("mapper.admin_board.qreplycreate",vo);
			System.out.println("접수 DAO 완료:"+vo.getQ_reply());
			
			
		}
		
		
		@Override  //게시글 삭제
		public void deleteQNA(int q_no)throws DataAccessException{
			sqlSession.delete("mapper.board.deleteQNA", q_no);
		}
		
		
		// AS 게시판
		
		@Override  // 게시글 목록(검색기능,페이징 추가)
		public List<Map<String, Object>> asList(SearchCriteriaVO scri) throws Exception{
			return sqlSession.selectList("mapper.board.asList",scri);
		}
		
		@Override
		public int asListCnt(SearchCriteriaVO scri) throws Exception {
			return sqlSession.selectOne("mapper.board.asListCnt");
		}
		
		@Override  // 게시글 상세보기
		public BoardVO selectAS(int as_no) throws DataAccessException {
			
			return sqlSession.selectOne("mapper.board.selectAS", as_no);
			
		}
		@Override
		public List selectImageFileList(int as_no)throws DataAccessException{
			List<ImageVO> imageFileList=null;
			imageFileList=sqlSession.selectList("mapper.board.selectImageFileList",as_no);
			return imageFileList;
		}
		
		@Override  //게시글 접수 및 답변
		public void receiveAS(int as_no)throws DataAccessException{
			sqlSession.update("mapper.admin_board.receiveAS", as_no);
		}
		
		@Override  
		public void asreplycreate(BoardVO vo)throws DataAccessException {
				
			sqlSession.update("mapper.admin_board.asreplycreate",vo);
			System.out.println("접수 DAO 완료:"+vo.getAs_reply());						
		}
		
		@Override  //게시글 삭제
		public void deleteAS(int as_no)throws DataAccessException{
			sqlSession.delete("mapper.board.deleteAS", as_no);
		}
}
