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
	    // ȸ�� ��������
		@Override   // �Խñ� ��� (����¡, �˻� ��� �߰�)
		public List<Map<String, Object>> noticeList(SearchCriteriaVO scri) throws Exception{
			List<Map<String, Object>> noticeList=dao.noticeList(scri);
			return noticeList;
		}
		
		@Override
		public int noticeListCnt(SearchCriteriaVO scri) throws Exception{
	     
			return dao.noticeListCnt(scri);
	    }
		
		@Override  // �Խñ� �ۼ�
		public void ncreate(BoardVO vo)throws Exception{
			dao.ncreate(vo);
		}
		
		
		
		
		@Override // �Խñ� �󼼺���
		public BoardVO viewNotice(int n_no) throws Exception {
			System.out.println("�������� �Ϸ�");
			System.out.println(dao.selectNotice(n_no));
			return dao.selectNotice(n_no);
			
		}
		

		@Override // �Խñ� ����
		public void updateNotice(BoardVO boardVO) throws Exception{
			System.out.println("���� ���� �Ϸ�");
			dao.updateNotice(boardVO);
		}
		
		@Override // �Խñ� ����
		public void deleteNotice(int n_no) {
			dao.deleteNotice(n_no);
		}
		
		// ������ ��������
		
		@Override   // �Խñ� ��� (����¡, �˻� ��� �߰�)
		public List<Map<String, Object>> adminList(SearchCriteriaVO scri) throws Exception{
			List<Map<String, Object>> adminList=dao.adminList(scri);
			return adminList;
		}
		@Override
		public int adminListCnt(SearchCriteriaVO scri) throws Exception{
	     
			return dao.adminListCnt(scri);
	    }
		
		@Override  // �Խñ� �ۼ�
		public void adcreate(AdminBoardVO adVO)throws Exception{
			dao.adcreate(adVO);
		}
		
		@Override // �Խñ� �󼼺���
		public AdminBoardVO viewadNotice(int a_main_NO) throws Exception {
			System.out.println("�������� �Ϸ�");
			System.out.println(dao.selectadNotice(a_main_NO));
			return dao.selectadNotice(a_main_NO);
			
		}
		
		@Override // �Խñ� ����
		public void updateadNotice(AdminBoardVO adVO) throws Exception{
			System.out.println("���� ���� �Ϸ�");
			dao.updateadNotice(adVO);
		}
		
		@Override // �Խñ� ����
		public void deleteadNotice(int a_main_NO) {
			dao.deleteadNotice(a_main_NO);
		}
		
		// ��㹮�� �Խ���
		
		@Override   // �Խñ� ��� (����¡, �˻� ��� �߰�)
		public List<Map<String, Object>> consultingList(SearchCriteriaVO scri) throws Exception{
			List<Map<String, Object>> consultingList=dao.consultingList(scri);
			return consultingList;
		}
		
		@Override
		public int consultingListCnt(SearchCriteriaVO scri) throws Exception{
	     
			return dao.consultingListCnt(scri);
	    }
		
		@Override // �Խñ� �󼼺���
		public BoardVO viewConsulting(int c_no) throws Exception {
			System.out.println("�������� �Ϸ�");
			System.out.println(dao.selectConsulting(c_no));
			return dao.selectConsulting(c_no);
			
		}
		@Override // �Խñ� ���� �� �亯
		public void receiveConsulting(int c_no) {
			dao.receiveConsulting(c_no);
		}
		
		@Override  
		public void creplycreate(BoardVO vo)throws Exception{
			dao.creplycreate(vo);
			System.out.println("���� ���� �Ϸ�:"+vo.getC_reply());
		}
		
		
		@Override // �Խñ� ����
		public void deleteConsulting(int c_no) {
			dao.deleteConsulting(c_no);
		}
		
		//Q&A
		
		@Override // �Խñ� ���(����¡, �˻� ��� �߰�)
		public List<Map<String, Object>> qnaList(SearchCriteriaVO scri) throws Exception{
	        return dao.qnaList(scri);
		}
		
		@Override
		public int qnaListCnt(SearchCriteriaVO scri) throws Exception{
	        return dao.qnaListCnt(scri);
	    }
		
		@Override // �Խñ� �󼼺���
		public BoardVO viewQNA(int q_no) throws Exception {
			System.out.println("�������� �Ϸ�");
			System.out.println(dao.selectQNA(q_no));
			return dao.selectQNA(q_no);
			
		}
		@Override // �Խñ� ���� �� �亯
		public void receiveQNA(int q_no) {
			dao.receiveQNA(q_no);
		}
		@Override  
		public void qreplycreate(BoardVO vo)throws Exception{
			dao.qreplycreate(vo);
			System.out.println("���� ���� �Ϸ�:"+vo.getQ_reply());
		}
		
		@Override // �Խñ� ����
		public void deleteQNA(int q_no) {
			dao.deleteQNA(q_no);
		}
		
		
		
		//AS
		
		@Override // �Խñ� ���(����¡, �˻� ��� �߰�)
		public List<Map<String, Object>> asList(SearchCriteriaVO scri) throws Exception{
	        return dao.asList(scri);
		}
		
		@Override
		public int asListCnt(SearchCriteriaVO scri) throws Exception{
	        return dao.asListCnt(scri);
	    }
		@Override // �Խñ� �󼼺���
		public Map viewAS(int as_no) throws Exception {
			Map asMap=new HashMap();
			BoardVO boardVO=dao.selectAS(as_no);
			List<ImageVO> imageFileList=dao.selectImageFileList(as_no);
			asMap.put("as", boardVO);
			asMap.put("imageFileList", imageFileList);
			return asMap;			
		}
		@Override // �Խñ� ���� �� �亯
		public void receiveAS(int as_no) {
			dao.receiveAS(as_no);
		}
		@Override  
		public void asreplycreate(BoardVO vo)throws Exception{
			dao.asreplycreate(vo);
			System.out.println("���� ���� �Ϸ�:"+vo.getAs_reply());
		}

		@Override // �Խñ� ����
		public void deleteAS(int as_no) {
			dao.deleteAS(as_no);
		}
		
}		


