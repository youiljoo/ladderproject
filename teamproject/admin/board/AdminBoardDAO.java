package com.mycompany.teamproject.admin.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mycompany.teamproject.admin.board.vo.AdminBoardVO;
import com.mycompany.teamproject.board.vo.BoardVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;

public interface AdminBoardDAO {
	// 회원 공지사항
	public List<Map<String, Object>> noticeList(SearchCriteriaVO scri) throws Exception; // 게시글 목록(페이징, 검색 기능 추가)	 
	public int noticeListCnt(SearchCriteriaVO scri) throws Exception;
	public void ncreate(BoardVO vo)throws DataAccessException;							// 게시글 작성
	public BoardVO selectNotice(int n_no) throws DataAccessException;					// 게시글 상세보기
	public void updateNotice(BoardVO boardVO)throws Exception;							// 게시글 수정
	public void deleteNotice(int n_no)throws DataAccessException;						// 게시글 삭제
	
	// 관리자 공지사항
	public List<Map<String, Object>> adminList(SearchCriteriaVO scri) throws Exception; // 게시글 목록(페이징, 검색 기능 추가)
	public int adminListCnt(SearchCriteriaVO scri) throws Exception;
	public void adcreate(AdminBoardVO adVO)throws DataAccessException;					// 게시글 작성
	public AdminBoardVO selectadNotice(int a_main_NO) throws DataAccessException;		// 게시글 상세보기
	public void updateadNotice(AdminBoardVO adVO)throws Exception;						// 게시글 수정
	public void deleteadNotice(int a_main_NO)throws DataAccessException;				// 게시글 삭제
	
	
	
	
	
	// 상담문의
	public List<Map<String, Object>> consultingList(SearchCriteriaVO scri) throws Exception; // 게시글 목록(페이징, 검색 기능 추가)	 
	public int consultingListCnt(SearchCriteriaVO scri) throws Exception;
	public BoardVO selectConsulting(int c_no) throws DataAccessException;					 // 게시글 상세보기
	public void receiveConsulting(int c_no)throws DataAccessException;						// 게시글 접수 및 답변
	public void creplycreate(BoardVO vo)throws DataAccessException;	
	public void deleteConsulting(int c_no)throws DataAccessException;						// 게시글 삭제
	
	// Q&A 게시판	
	public List<Map<String, Object>> qnaList(SearchCriteriaVO scri) throws Exception;		// 게시글 목록(페이징, 검색 기능 추가) 
	public int qnaListCnt(SearchCriteriaVO scri) throws Exception;	
	public BoardVO selectQNA(int q_no) throws DataAccessException;							// 게시글 상세보기
	public void receiveQNA(int q_no)throws DataAccessException;								// 게시글 접수 및 답변
	public void qreplycreate(BoardVO vo)throws DataAccessException;						
	public void deleteQNA(int q_no)throws DataAccessException;								// 게시글 삭제
	
	//AS
	public List<Map<String, Object>> asList(SearchCriteriaVO scri) throws Exception;		// 게시글 목록(페이징, 검색 기능 추가) 
	public int asListCnt(SearchCriteriaVO scri) throws Exception;
	public BoardVO selectAS(int as_no) throws DataAccessException;							// 게시글 상세보기
	public List selectImageFileList(int as_no)throws DataAccessException;
	public void receiveAS(int as_no)throws DataAccessException;								// 게시글 접수 및 답변
	public void asreplycreate(BoardVO vo)throws DataAccessException;
	public void deleteAS(int as_no)throws DataAccessException;								// 게시글 삭제
}
