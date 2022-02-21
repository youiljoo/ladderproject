package com.mycompany.teamproject.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mycompany.teamproject.board.dao.BoardDAO;
import com.mycompany.teamproject.board.vo.BoardVO;
import com.mycompany.teamproject.board.vo.ImageVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Inject
	private BoardDAO dao;
	
	// 공지사항
	@Override   // 게시글 목록 (페이징, 검색 기능 추가)
	public List<Map<String, Object>> noticeList(SearchCriteriaVO scri) throws Exception{
		List<Map<String, Object>> noticeList=dao.noticeList(scri);
		return noticeList;
	}
	
	@Override
	public int noticeListCnt(SearchCriteriaVO scri) throws Exception{
     
		return dao.noticeListCnt(scri);
    }
	
	@Override // 게시글 상세보기
	public BoardVO viewNotice(int n_no) throws Exception {
		System.out.println("상세페이지 완료");
		System.out.println(dao.selectNotice(n_no));
		return dao.selectNotice(n_no);
		
	}
	
	// 상담문의 게시판
	
	@Override   // 게시글 목록 (페이징, 검색 기능 추가)
	public List<Map<String, Object>> consultingList(SearchCriteriaVO scri) throws Exception{
		List<Map<String, Object>> consultingList=dao.consultingList(scri);
		return consultingList;
	}
	
	@Override
	public int consultingListCnt(SearchCriteriaVO scri) throws Exception{
     
		return dao.consultingListCnt(scri);
    }
	
	@Override  // 게시글 작성
	public void create(BoardVO vo)throws Exception{
		dao.create(vo);
	}
	
	@Override // 게시글 상세보기
	public BoardVO viewConsulting(int c_no) throws Exception {
		System.out.println("상세페이지 완료");
		System.out.println(dao.selectConsulting(c_no));
		return dao.selectConsulting(c_no);
		
	}
	
	@Override // 게시글 수정
	public void updateConsulting(BoardVO boardVO) throws Exception{
		System.out.println("수정 서비스 완료");
		dao.updateConsulting(boardVO);
	}
	
	@Override // 게시글 삭제
	public void deleteConsulting(int c_no) {
		dao.deleteConsulting(c_no);
	}
	
				
	
	// Q&A 게시판
	
	@Override // 게시글 목록(페이징, 검색 기능 추가)
	public List<Map<String, Object>> qnaList(SearchCriteriaVO scri) throws Exception{
        return dao.qnaList(scri);
	}
	
	@Override
	public int qnaListCnt(SearchCriteriaVO scri) throws Exception{
        return dao.qnaListCnt(scri);
    }
	
	@Override // 게시글 작성
	public void create2(BoardVO vo) {
		dao.create2(vo);
	}
	
	@Override // 게시글 상세보기
	public BoardVO viewQNA(int q_no) throws Exception {
		System.out.println("상세페이지 완료");
		System.out.println(dao.selectQNA(q_no));
		return dao.selectQNA(q_no);
		
	}
	
	@Override // 게시글 수정
	public void updateQNA(BoardVO boardVO) throws Exception{
		System.out.println("수정 서비스 완료");
		dao.updateQNA(boardVO);
	}
	
	@Override // 게시글 삭제
	public void deleteQNA(int q_no) {
		dao.deleteQNA(q_no);
	}
	
	// A/S 게시판
	
	
	@Override  // 게시글 목록 (페이징, 검색 기능 추가)
	public List<Map<String, Object>> asList(SearchCriteriaVO scri) throws Exception{
        return dao.asList(scri);
	}
	
	@Override
	public int asListCnt(SearchCriteriaVO scri) throws Exception{
        return dao.asListCnt(scri);
    }
	
	@Override // 게시글 작성
	public int create3(Map asMap)throws Exception{
		int as_no=dao.create3(asMap);
		asMap.put("as_no", as_no);
		dao.insertNewImage(asMap);
		return as_no;
	}
	
	@Override // 게시글 상세보기
	public Map viewAS(int as_no) throws Exception {
		Map asMap=new HashMap();
		BoardVO boardVO=dao.selectAS(as_no);
		List<ImageVO> imageFileList=dao.selectImageFileList(as_no);
		asMap.put("as", boardVO);
		asMap.put("imageFileList", imageFileList);
		return asMap;
		
	}
	
	@Override // 게시글 수정
	public void updateAS(Map asMap) throws Exception{
		System.out.println("수정 서비스 완료");
		dao.updateAS(asMap);
	}
	
	@Override // 게시글 삭제
	public void deleteAS(int as_no) {
		dao.deleteAS(as_no);
	}
	
}
