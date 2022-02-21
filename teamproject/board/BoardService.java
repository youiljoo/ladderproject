package com.mycompany.teamproject.board.service;

import java.util.List;
import java.util.Map;

import com.mycompany.teamproject.board.vo.BoardVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;

public interface BoardService {
	
	// 공지사항
	public List<Map<String,Object>>noticeList(SearchCriteriaVO scri) throws Exception; // 글 목록 (페이징, 검색 기능 추가)
	public int noticeListCnt(SearchCriteriaVO scri) throws Exception;
	public BoardVO viewNotice(int n_no) throws Exception; // 게시글 상세보기
	
	// 상담문의 게시판
	public List<Map<String,Object>>consultingList(SearchCriteriaVO scri) throws Exception; // 글 목록 (페이징, 검색 기능 추가)
	public int consultingListCnt(SearchCriteriaVO scri) throws Exception; 
	public void create(BoardVO vo)throws Exception; // 글 쓰기
	public BoardVO viewConsulting(int c_no) throws Exception; // 게시글 상세보기
	public void updateConsulting(BoardVO boardVO)throws Exception; // 게시글 수정
	public void deleteConsulting(int c_no)throws Exception; // 게시글 삭제
	
	// Q&A 게시판
	public List<Map<String,Object>>qnaList(SearchCriteriaVO scri) throws Exception; // 글 목록(페이징, 검색 기능 추가)
	public int qnaListCnt(SearchCriteriaVO scri) throws Exception;
	public void create2(BoardVO vo); // 글 쓰기
	public BoardVO viewQNA(int q_no) throws Exception; // 게시글 상세보기
	public void updateQNA(BoardVO boardVO)throws Exception; // 게시글 수정
	public void deleteQNA(int q_no)throws Exception; // 게시글 삭제
	
	
	

	// A/S 게시판
	public List<Map<String,Object>>asList(SearchCriteriaVO scri) throws Exception; // 글 목록(페이징, 검색 기능 추가)
	public int asListCnt(SearchCriteriaVO scri) throws Exception;
	public int create3(Map asMap)throws Exception; // 글 쓰기
	public Map viewAS(int as_no) throws Exception; // 게시글 상세보기
	public void updateAS(Map asMap)throws Exception; // 게시글 수정
	public void deleteAS(int as_no)throws Exception; // 게시글 삭제
}
