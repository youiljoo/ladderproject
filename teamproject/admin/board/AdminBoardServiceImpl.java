package com.mycompany.teamproject.admin.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mycompany.teamproject.admin.board.dao.AdminBoardDAO;
import com.mycompany.teamproject.admin.board.vo.AdminBoardVO;
import com.mycompany.teamproject.board.vo.BoardVO;
import com.mycompany.teamproject.board.vo.ImageVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;

@Service("adminboardService")
public class AdminBoardServiceImpl implements AdminBoardService{
	@Inject
	private AdminBoardDAO dao;
	    // 회원 공지사항
		@Override   // 게시글 목록 (페이징, 검색 기능 추가)
		public List<Map<String, Object>> noticeList(SearchCriteriaVO scri) throws Exception{
			List<Map<String, Object>> noticeList=dao.noticeList(scri);
			return noticeList;
		}
		
		@Override
		public int noticeListCnt(SearchCriteriaVO scri) throws Exception{
	     
			return dao.noticeListCnt(scri);
	    }
		
		@Override  // 게시글 작성
		public void ncreate(BoardVO vo)throws Exception{
			dao.ncreate(vo);
		}
		
		
		
		
		@Override // 게시글 상세보기
		public BoardVO viewNotice(int n_no) throws Exception {
			System.out.println("상세페이지 완료");
			System.out.println(dao.selectNotice(n_no));
			return dao.selectNotice(n_no);
			
		}
		

		@Override // 게시글 수정
		public void updateNotice(BoardVO boardVO) throws Exception{
			System.out.println("수정 서비스 완료");
			dao.updateNotice(boardVO);
		}
		
		@Override // 게시글 삭제
		public void deleteNotice(int n_no) {
			dao.deleteNotice(n_no);
		}
		
		// 관리자 공지사항
		
		@Override   // 게시글 목록 (페이징, 검색 기능 추가)
		public List<Map<String, Object>> adminList(SearchCriteriaVO scri) throws Exception{
			List<Map<String, Object>> adminList=dao.adminList(scri);
			return adminList;
		}
		@Override
		public int adminListCnt(SearchCriteriaVO scri) throws Exception{
	     
			return dao.adminListCnt(scri);
	    }
		
		@Override  // 게시글 작성
		public void adcreate(AdminBoardVO adVO)throws Exception{
			dao.adcreate(adVO);
		}
		
		@Override // 게시글 상세보기
		public AdminBoardVO viewadNotice(int a_main_NO) throws Exception {
			System.out.println("상세페이지 완료");
			System.out.println(dao.selectadNotice(a_main_NO));
			return dao.selectadNotice(a_main_NO);
			
		}
		
		@Override // 게시글 수정
		public void updateadNotice(AdminBoardVO adVO) throws Exception{
			System.out.println("수정 서비스 완료");
			dao.updateadNotice(adVO);
		}
		
		@Override // 게시글 삭제
		public void deleteadNotice(int a_main_NO) {
			dao.deleteadNotice(a_main_NO);
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
		
		@Override // 게시글 상세보기
		public BoardVO viewConsulting(int c_no) throws Exception {
			System.out.println("상세페이지 완료");
			System.out.println(dao.selectConsulting(c_no));
			return dao.selectConsulting(c_no);
			
		}
		@Override // 게시글 접수 및 답변
		public void receiveConsulting(int c_no) {
			dao.receiveConsulting(c_no);
		}
		
		@Override  
		public void creplycreate(BoardVO vo)throws Exception{
			dao.creplycreate(vo);
			System.out.println("접수 서비스 완료:"+vo.getC_reply());
		}
		
		
		@Override // 게시글 삭제
		public void deleteConsulting(int c_no) {
			dao.deleteConsulting(c_no);
		}
		
		//Q&A
		
		@Override // 게시글 목록(페이징, 검색 기능 추가)
		public List<Map<String, Object>> qnaList(SearchCriteriaVO scri) throws Exception{
	        return dao.qnaList(scri);
		}
		
		@Override
		public int qnaListCnt(SearchCriteriaVO scri) throws Exception{
	        return dao.qnaListCnt(scri);
	    }
		
		@Override // 게시글 상세보기
		public BoardVO viewQNA(int q_no) throws Exception {
			System.out.println("상세페이지 완료");
			System.out.println(dao.selectQNA(q_no));
			return dao.selectQNA(q_no);
			
		}
		@Override // 게시글 접수 및 답변
		public void receiveQNA(int q_no) {
			dao.receiveQNA(q_no);
		}
		@Override  
		public void qreplycreate(BoardVO vo)throws Exception{
			dao.qreplycreate(vo);
			System.out.println("접수 서비스 완료:"+vo.getQ_reply());
		}
		
		@Override // 게시글 삭제
		public void deleteQNA(int q_no) {
			dao.deleteQNA(q_no);
		}
		
		
		
		//AS
		
		@Override // 게시글 목록(페이징, 검색 기능 추가)
		public List<Map<String, Object>> asList(SearchCriteriaVO scri) throws Exception{
	        return dao.asList(scri);
		}
		
		@Override
		public int asListCnt(SearchCriteriaVO scri) throws Exception{
	        return dao.asListCnt(scri);
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
		@Override // 게시글 접수 및 답변
		public void receiveAS(int as_no) {
			dao.receiveAS(as_no);
		}
		@Override  
		public void asreplycreate(BoardVO vo)throws Exception{
			dao.asreplycreate(vo);
			System.out.println("접수 서비스 완료:"+vo.getAs_reply());
		}

		@Override // 게시글 삭제
		public void deleteAS(int as_no) {
			dao.deleteAS(as_no);
		}
		
}		


