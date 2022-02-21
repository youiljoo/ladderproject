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
	
		// ȸ�� ��������
		@Override  // �Խñ� ��� (�˻����, ����¡ �߰�)
		public List<Map<String, Object>> noticeList(SearchCriteriaVO scri) throws Exception{
			return sqlSession.selectList("mapper.board.noticeList",scri);
		}
		@Override
		public int noticeListCnt(SearchCriteriaVO scri) throws Exception {
			return sqlSession.selectOne("mapper.board.noticeListCnt");
		}
		
		
		@Override  // �Խñ� �ۼ�
		public void ncreate(BoardVO vo)throws DataAccessException {
				
			sqlSession.insert("mapper.admin_board.ncreate",vo);		
		}
		
		
		@Override  // �Խñ� �󼼺���
		public BoardVO selectNotice(int n_no) throws DataAccessException {
			
			return sqlSession.selectOne("mapper.board.selectNotice",n_no);
			
		}
		@Override  // �Խñ� ����
		public void updateNotice(BoardVO boardVO)throws Exception{
			System.out.println("���� DAO �Ϸ�");
			sqlSession.update("mapper.admin_board.updateNotice",boardVO);
		
		}
		@Override  //�Խñ� ����
		public void deleteNotice(int n_no)throws DataAccessException{
			sqlSession.delete("mapper.admin_board.deleteNotice", n_no);
		}
		
		// ������ ��������
		
		@Override  // �Խñ� ��� (�˻����, ����¡ �߰�)
		public List<Map<String, Object>> adminList(SearchCriteriaVO scri) throws Exception{
			return sqlSession.selectList("mapper.admin_board.adminList",scri);
		}
		@Override
		public int adminListCnt(SearchCriteriaVO scri) throws Exception {
			return sqlSession.selectOne("mapper.admin_board.adminListCnt");
		}
		
		@Override  // �Խñ� �ۼ�
		public void adcreate(AdminBoardVO adVO)throws DataAccessException {
				
			sqlSession.insert("mapper.admin_board.adcreate",adVO);		
		}
		
		@Override  // �Խñ� �󼼺���
		public AdminBoardVO selectadNotice(int a_main_NO) throws DataAccessException {
			
			return sqlSession.selectOne("mapper.admin_board.selectadNotice",a_main_NO);
			
		}
		
		@Override  // �Խñ� ����
		public void updateadNotice(AdminBoardVO adVO)throws Exception{
			System.out.println("���� DAO �Ϸ�");
			sqlSession.update("mapper.admin_board.updateadNotice",adVO);
		
		}
		
		@Override  //�Խñ� ����
		public void deleteadNotice(int a_main_NO)throws DataAccessException{
			sqlSession.delete("mapper.admin_board.deleteadNotice", a_main_NO);
		}
		
		
		//��㹮��
		
		@Override  // �Խñ� ��� (�˻����, ����¡ �߰�)
		public List<Map<String, Object>> consultingList(SearchCriteriaVO scri) throws Exception{
			return sqlSession.selectList("mapper.board.consultingList",scri);
		}
			
		@Override
		public int consultingListCnt(SearchCriteriaVO scri) throws Exception {
			return sqlSession.selectOne("mapper.board.consultingListCnt");
		}
		
		@Override  // �Խñ� �󼼺���
		public BoardVO selectConsulting(int c_no) throws DataAccessException {
			
			return sqlSession.selectOne("mapper.board.selectConsulting", c_no);
			
		}
		
		@Override  //�Խñ� ���� �� �亯
		public void receiveConsulting(int c_no)throws DataAccessException{
			sqlSession.update("mapper.admin_board.receiveConsulting", c_no);
		}
		
		@Override  
		public void creplycreate(BoardVO vo)throws DataAccessException {
				
			sqlSession.update("mapper.admin_board.creplycreate",vo);
			System.out.println("���� DAO �Ϸ�:"+vo.getC_reply());
			
			
		}
		
		@Override  //�Խñ� ����
		public void deleteConsulting(int c_no)throws DataAccessException{		
			sqlSession.delete("mapper.board.deleteConsulting", c_no);
		}
		
		
		// Q&A �Խ���
		
		@Override  // �Խñ� ���(�˻����,����¡ �߰�)
		public List<Map<String, Object>> qnaList(SearchCriteriaVO scri) throws Exception{
			return sqlSession.selectList("mapper.board.qnaList",scri);
		}
		
		@Override
		public int qnaListCnt(SearchCriteriaVO scri) throws Exception {
			return sqlSession.selectOne("mapper.board.qnaListCnt");
		}
		
		@Override  //�Խñ� �󼼺���
		public BoardVO selectQNA(int q_no) throws DataAccessException {
			
			return sqlSession.selectOne("mapper.board.selectQNA", q_no);
			
		}
		
		@Override  //�Խñ� ���� �� �亯
		public void receiveQNA(int q_no)throws DataAccessException{
			sqlSession.update("mapper.admin_board.receiveQNA", q_no);
		}
		
		@Override  
		public void qreplycreate(BoardVO vo)throws DataAccessException {
				
			sqlSession.update("mapper.admin_board.qreplycreate",vo);
			System.out.println("���� DAO �Ϸ�:"+vo.getQ_reply());
			
			
		}
		
		
		@Override  //�Խñ� ����
		public void deleteQNA(int q_no)throws DataAccessException{
			sqlSession.delete("mapper.board.deleteQNA", q_no);
		}
		
		
		// AS �Խ���
		
		@Override  // �Խñ� ���(�˻����,����¡ �߰�)
		public List<Map<String, Object>> asList(SearchCriteriaVO scri) throws Exception{
			return sqlSession.selectList("mapper.board.asList",scri);
		}
		
		@Override
		public int asListCnt(SearchCriteriaVO scri) throws Exception {
			return sqlSession.selectOne("mapper.board.asListCnt");
		}
		
		@Override  // �Խñ� �󼼺���
		public BoardVO selectAS(int as_no) throws DataAccessException {
			
			return sqlSession.selectOne("mapper.board.selectAS", as_no);
			
		}
		@Override
		public List selectImageFileList(int as_no)throws DataAccessException{
			List<ImageVO> imageFileList=null;
			imageFileList=sqlSession.selectList("mapper.board.selectImageFileList",as_no);
			return imageFileList;
		}
		
		@Override  //�Խñ� ���� �� �亯
		public void receiveAS(int as_no)throws DataAccessException{
			sqlSession.update("mapper.admin_board.receiveAS", as_no);
		}
		
		@Override  
		public void asreplycreate(BoardVO vo)throws DataAccessException {
				
			sqlSession.update("mapper.admin_board.asreplycreate",vo);
			System.out.println("���� DAO �Ϸ�:"+vo.getAs_reply());						
		}
		
		@Override  //�Խñ� ����
		public void deleteAS(int as_no)throws DataAccessException{
			sqlSession.delete("mapper.board.deleteAS", as_no);
		}
}
