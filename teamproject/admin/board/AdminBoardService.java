package com.mycompany.teamproject.admin.board.service;

import java.util.List;
import java.util.Map;

import com.mycompany.teamproject.admin.board.vo.AdminBoardVO;
import com.mycompany.teamproject.board.vo.BoardVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;

public interface AdminBoardService {
	// 회원 공지사항
	public List<Map<String,Object>>noticeList(SearchCriteriaVO scri) throws Exception; // 회원 공지사항 글 목록 (페이징, 검색 기능 추가)
	public int noticeListCnt(SearchCriteriaVO scri) throws Exception;
	public BoardVO viewNotice(int n_no) throws Exception; // 게시글 상세보기
	public void ncreate(BoardVO vo)throws Exception; // 글 쓰기
	public void updateNotice(BoardVO boardVO)throws Exception; // 게시글 수정
	public void deleteNotice(int n_no)throws Exception; // 게시글 삭제
	
	// 관리자 공지사항
	public List<Map<String,Object>>adminList(SearchCriteriaVO scri) throws Exception; // 글 목록 (페이징, 검색 기능 추가)
	public int adminListCnt(SearchCriteriaVO scri) throws Exception;
	public void adcreate(AdminBoardVO adVO)throws Exception; // 글 쓰기
	public AdminBoardVO viewadNotice(int a_main_NO) throws Exception; // 게시글 상세보기
	public void updateadNotice(AdminBoardVO adVO)throws Exception; // 게시글 수정
	public void deleteadNotice(int a_main_NO)throws Exception; // 게시글 삭제
	
	// 상담문의
	public List<Map<String,Object>>consultingList(SearchCriteriaVO scri) throws Exception; // 글 목록 (페이징, 검색 기능 추가)
	public int consultingListCnt(SearchCriteriaVO scri) throws Exception; 
	public BoardVO viewConsulting(int c_no) throws Exception; // 게시글 상세보기
	public void receiveConsulting(int c_no)throws Exception; // 게시글 접수 및 답변
	public void creplycreate(BoardVO vo)throws Exception;
	public void deleteConsulting(int c_no)throws Exception; // 게시글 삭제
	
	//Q&A
	public List<Map<String,Object>>qnaList(SearchCriteriaVO scri) throws Exception; // 글 목록(페이징, 검색 기능 추가)
	public int qnaListCnt(SearchCriteriaVO scri) throws Exception;
	public BoardVO viewQNA(int q_no) throws Exception; // 게시글 상세보기
	public void receiveQNA(int q_no)throws Exception; // 게시글 접수 및 답변
	public void qreplycreate(BoardVO vo)throws Exception;
	public void deleteQNA(int q_no)throws Exception; // 게시글 삭제
	
	//AS
	public List<Map<String,Object>>asList(SearchCriteriaVO scri) throws Exception; // 글 목록(페이징, 검색 기능 추가)
	public int asListCnt(SearchCriteriaVO scri) throws Exception;
	public Map viewAS(int as_no) throws Exception; // 게시글 상세보기
	public void receiveAS(int as_no)throws Exception; // 게시글 접수 및 답변
	public void asreplycreate(BoardVO vo)throws Exception;
	public void deleteAS(int as_no)throws Exception; // 게시글 삭제
}
