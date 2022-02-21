package com.mycompany.teamproject.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mycompany.teamproject.board.vo.BoardVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;

public interface BoardDAO {
	
	// 공지사항
	public List<Map<String, Object>> noticeList(SearchCriteriaVO scri) throws Exception; // 게시글 목록(페이징, 검색 기능 추가)	 
	public int noticeListCnt(SearchCriteriaVO scri) throws Exception; 
	public BoardVO selectNotice(int n_no) throws DataAccessException;					// 게시글 상세보기
	
	
	
	// 상담문의 게시판
	
	public List<Map<String, Object>> consultingList(SearchCriteriaVO scri) throws Exception; // 게시글 목록(페이징, 검색 기능 추가)	 
	public int consultingListCnt(SearchCriteriaVO scri) throws Exception; 
	public void create(BoardVO vo)throws DataAccessException;								// 게시글 작성
	public BoardVO selectConsulting(int c_no) throws DataAccessException;					// 게시글 상세보기
	public void updateConsulting(BoardVO boardVO)throws Exception;							// 게시글 수정
	public void deleteConsulting(int c_no)throws DataAccessException;						// 게시글 삭제
	
	
	// Q&A 게시판
	
	public List<Map<String, Object>> qnaList(SearchCriteriaVO scri) throws Exception;		// 게시글 목록(페이징, 검색 기능 추가) 
	public int qnaListCnt(SearchCriteriaVO scri) throws Exception;							
	public void create2(BoardVO vo)throws DataAccessException;								// 게시글 작성
	public BoardVO selectQNA(int q_no) throws DataAccessException;							// 게시글 상세보기
	public void updateQNA(BoardVO boardVO)throws Exception;									// 게시글 수정
	public void deleteQNA(int q_no)throws DataAccessException;								// 게시글 삭제
	
	// A&S 게시판
	
	public List<Map<String, Object>> asList(SearchCriteriaVO scri) throws Exception;		// 게시글 목록(페이징, 검색 기능 추가)	 
	public int asListCnt(SearchCriteriaVO scri) throws Exception;							
	public int create3(Map asMap)throws DataAccessException;								// 게시글 작성
	public void insertNewImage(Map asMap)throws DataAccessException;
	public List selectImageFileList(int as_no)throws DataAccessException;	
	public BoardVO selectAS(int as_no) throws DataAccessException;							// 게시글 상세보기
	public void updateAS(Map asMap)throws Exception;										// 게시글 수정
	public void deleteAS(int as_no)throws DataAccessException;								// 게시글 삭제
	
	


	
}
