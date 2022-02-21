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
	
	// 공지사항
	@Override  // 게시글 목록 (검색기능, 페이징 추가)
	public List<Map<String, Object>> noticeList(SearchCriteriaVO scri) throws Exception{
		return sqlSession.selectList("mapper.board.noticeList",scri);
	}
	@Override
	public int noticeListCnt(SearchCriteriaVO scri) throws Exception {
		return sqlSession.selectOne("mapper.board.noticeListCnt");
	}
	@Override  // 게시글 상세보기
	public BoardVO selectNotice(int n_no) throws DataAccessException {
		
		return sqlSession.selectOne("mapper.board.selectNotice",n_no);
		
	}
		
		
	// 상담문의 게시판
	
	@Override  // 게시글 목록 (검색기능, 페이징 추가)
	public List<Map<String, Object>> consultingList(SearchCriteriaVO scri) throws Exception{
		return sqlSession.selectList("mapper.board.consultingList",scri);
	}
		
	@Override
	public int consultingListCnt(SearchCriteriaVO scri) throws Exception {
		return sqlSession.selectOne("mapper.board.consultingListCnt");
	}
	
	@Override  // 게시글 작성
	public void create(BoardVO vo)throws DataAccessException {
			
		sqlSession.insert("mapper.board.create",vo);		
	}
	
	@Override  // 게시글 상세보기
	public BoardVO selectConsulting(int c_no) throws DataAccessException {
		
		return sqlSession.selectOne("mapper.board.selectConsulting", c_no);
		
	}	
	@Override  // 게시글 수정
	public void updateConsulting(BoardVO boardVO)throws Exception{
		System.out.println("수정 DAO 완료");
		sqlSession.update("mapper.board.updateConsulting",boardVO);
	
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
	
	@Override  //게시글 작성
	public void create2(BoardVO vo)throws DataAccessException {
		sqlSession.insert("mapper.board.create2",vo);
	}
	
	@Override  //게시글 상세보기
	public BoardVO selectQNA(int q_no) throws DataAccessException {
		
		return sqlSession.selectOne("mapper.board.selectQNA", q_no);
		
	}	
	@Override  // 게시글 수정
	public void updateQNA(BoardVO boardVO)throws Exception{
		System.out.println("수정 DAO 완료");
		sqlSession.update("mapper.board.updateQNA",boardVO);
	
	}
	
	@Override  //게시글 삭제
	public void deleteQNA(int q_no)throws DataAccessException{
		sqlSession.delete("mapper.board.deleteQNA", q_no);
	}
	
	
	// A/S 게시판

	@Override  // 게시글 목록(검색기능, 페이징 추가)
	public List<Map<String, Object>> asList(SearchCriteriaVO scri) throws Exception{
		return sqlSession.selectList("mapper.board.asList",scri);
	}
			
	@Override
	public int asListCnt(SearchCriteriaVO scri) throws Exception {
		return sqlSession.selectOne("mapper.board.asListCnt");
	}
	
	@Override  // 게시글 작성
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
		System.out.println("이미지 파일 번호:"+imageFileNO);
		for(ImageVO imageVO:imageFileList) {
			imageVO.setImageFileNO(++imageFileNO);
			imageVO.setAs_no(as_no);
		}
		sqlSession.insert("mapper.board.insertNewImage",imageFileList);
		System.out.println("이미지 파일 리스트:"+imageFileList);
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
	
	
	@Override  // 게시글 상세보기
	public BoardVO selectAS(int as_no) throws DataAccessException {
		
		return sqlSession.selectOne("mapper.board.selectAS", as_no);
		
	}	
	
	@Override  // 게시글 수정
	public void updateAS(Map asMap)throws Exception{
		System.out.println("수정 DAO 완료");
		sqlSession.update("mapper.board.updateAS",asMap);
	
	}
	
	@Override  //게시글 삭제
	public void deleteAS(int as_no)throws DataAccessException{
		sqlSession.delete("mapper.board.deleteAS", as_no);
	}

	


}
