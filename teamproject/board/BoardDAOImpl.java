package com.mycompany.teamproject.board.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.teamproject.board.vo.BoardVO;
import com.mycompany.teamproject.board.vo.ImageVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Inject
	private SqlSession sqlSession;
	
	// ��������
	@Override  // �Խñ� ��� (�˻����, ����¡ �߰�)
	public List<Map<String, Object>> noticeList(SearchCriteriaVO scri) throws Exception{
		return sqlSession.selectList("mapper.board.noticeList",scri);
	}
	@Override
	public int noticeListCnt(SearchCriteriaVO scri) throws Exception {
		return sqlSession.selectOne("mapper.board.noticeListCnt");
	}
	@Override  // �Խñ� �󼼺���
	public BoardVO selectNotice(int n_no) throws DataAccessException {
		
		return sqlSession.selectOne("mapper.board.selectNotice",n_no);
		
	}
		
		
	// ��㹮�� �Խ���
	
	@Override  // �Խñ� ��� (�˻����, ����¡ �߰�)
	public List<Map<String, Object>> consultingList(SearchCriteriaVO scri) throws Exception{
		return sqlSession.selectList("mapper.board.consultingList",scri);
	}
		
	@Override
	public int consultingListCnt(SearchCriteriaVO scri) throws Exception {
		return sqlSession.selectOne("mapper.board.consultingListCnt");
	}
	
	@Override  // �Խñ� �ۼ�
	public void create(BoardVO vo)throws DataAccessException {
			
		sqlSession.insert("mapper.board.create",vo);		
	}
	
	@Override  // �Խñ� �󼼺���
	public BoardVO selectConsulting(int c_no) throws DataAccessException {
		
		return sqlSession.selectOne("mapper.board.selectConsulting", c_no);
		
	}	
	@Override  // �Խñ� ����
	public void updateConsulting(BoardVO boardVO)throws Exception{
		System.out.println("���� DAO �Ϸ�");
		sqlSession.update("mapper.board.updateConsulting",boardVO);
	
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
	
	@Override  //�Խñ� �ۼ�
	public void create2(BoardVO vo)throws DataAccessException {
		sqlSession.insert("mapper.board.create2",vo);
	}
	
	@Override  //�Խñ� �󼼺���
	public BoardVO selectQNA(int q_no) throws DataAccessException {
		
		return sqlSession.selectOne("mapper.board.selectQNA", q_no);
		
	}	
	@Override  // �Խñ� ����
	public void updateQNA(BoardVO boardVO)throws Exception{
		System.out.println("���� DAO �Ϸ�");
		sqlSession.update("mapper.board.updateQNA",boardVO);
	
	}
	
	@Override  //�Խñ� ����
	public void deleteQNA(int q_no)throws DataAccessException{
		sqlSession.delete("mapper.board.deleteQNA", q_no);
	}
	
	
	// A/S �Խ���

	@Override  // �Խñ� ���(�˻����, ����¡ �߰�)
	public List<Map<String, Object>> asList(SearchCriteriaVO scri) throws Exception{
		return sqlSession.selectList("mapper.board.asList",scri);
	}
			
	@Override
	public int asListCnt(SearchCriteriaVO scri) throws Exception {
		return sqlSession.selectOne("mapper.board.asListCnt");
	}
	
	@Override  // �Խñ� �ۼ�
	public int create3(Map asMap)throws DataAccessException{
		int as_no=selectNewAs_no();
		asMap.put("as_no", as_no);
		sqlSession.insert("mapper.board.create3",asMap);
		return as_no;
	}
	@Override
	public void insertNewImage(Map asMap)throws DataAccessException{
		List<ImageVO> imageFileList =(ArrayList)asMap.get("imageFileList");
		int as_no=(Integer)asMap.get("as_no");
		int imageFileNO=selectNewImageFileNO();
		System.out.println("�̹��� ���� ��ȣ:"+imageFileNO);
		for(ImageVO imageVO:imageFileList) {
			imageVO.setImageFileNO(++imageFileNO);
			imageVO.setAs_no(as_no);
		}
		sqlSession.insert("mapper.board.insertNewImage",imageFileList);
		System.out.println("�̹��� ���� ����Ʈ:"+imageFileList);
	}
	@Override
	public List selectImageFileList(int as_no)throws DataAccessException{
		List<ImageVO> imageFileList=null;
		imageFileList=sqlSession.selectList("mapper.board.selectImageFileList",as_no);
		return imageFileList;
	}
	private int selectNewAs_no() throws DataAccessException{
		return sqlSession.selectOne("mapper.board.selectNewAs_no");
	}
	private int selectNewImageFileNO() throws DataAccessException{
		return sqlSession.selectOne("mapper.board.selectNewImageFileNO");
	}
	
	
	@Override  // �Խñ� �󼼺���
	public BoardVO selectAS(int as_no) throws DataAccessException {
		
		return sqlSession.selectOne("mapper.board.selectAS", as_no);
		
	}	
	
	@Override  // �Խñ� ����
	public void updateAS(Map asMap)throws Exception{
		System.out.println("���� DAO �Ϸ�");
		sqlSession.update("mapper.board.updateAS",asMap);
	
	}
	
	@Override  //�Խñ� ����
	public void deleteAS(int as_no)throws DataAccessException{
		sqlSession.delete("mapper.board.deleteAS", as_no);
	}

	


}
