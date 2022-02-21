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
	
	// ��������
	@Override   // �Խñ� ��� (����¡, �˻� ��� �߰�)
	public List<Map<String, Object>> noticeList(SearchCriteriaVO scri) throws Exception{
		List<Map<String, Object>> noticeList=dao.noticeList(scri);
		return noticeList;
	}
	
	@Override
	public int noticeListCnt(SearchCriteriaVO scri) throws Exception{
     
		return dao.noticeListCnt(scri);
    }
	
	@Override // �Խñ� �󼼺���
	public BoardVO viewNotice(int n_no) throws Exception {
		System.out.println("�������� �Ϸ�");
		System.out.println(dao.selectNotice(n_no));
		return dao.selectNotice(n_no);
		
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
	
	@Override  // �Խñ� �ۼ�
	public void create(BoardVO vo)throws Exception{
		dao.create(vo);
	}
	
	@Override // �Խñ� �󼼺���
	public BoardVO viewConsulting(int c_no) throws Exception {
		System.out.println("�������� �Ϸ�");
		System.out.println(dao.selectConsulting(c_no));
		return dao.selectConsulting(c_no);
		
	}
	
	@Override // �Խñ� ����
	public void updateConsulting(BoardVO boardVO) throws Exception{
		System.out.println("���� ���� �Ϸ�");
		dao.updateConsulting(boardVO);
	}
	
	@Override // �Խñ� ����
	public void deleteConsulting(int c_no) {
		dao.deleteConsulting(c_no);
	}
	
				
	
	// Q&A �Խ���
	
	@Override // �Խñ� ���(����¡, �˻� ��� �߰�)
	public List<Map<String, Object>> qnaList(SearchCriteriaVO scri) throws Exception{
        return dao.qnaList(scri);
	}
	
	@Override
	public int qnaListCnt(SearchCriteriaVO scri) throws Exception{
        return dao.qnaListCnt(scri);
    }
	
	@Override // �Խñ� �ۼ�
	public void create2(BoardVO vo) {
		dao.create2(vo);
	}
	
	@Override // �Խñ� �󼼺���
	public BoardVO viewQNA(int q_no) throws Exception {
		System.out.println("�������� �Ϸ�");
		System.out.println(dao.selectQNA(q_no));
		return dao.selectQNA(q_no);
		
	}
	
	@Override // �Խñ� ����
	public void updateQNA(BoardVO boardVO) throws Exception{
		System.out.println("���� ���� �Ϸ�");
		dao.updateQNA(boardVO);
	}
	
	@Override // �Խñ� ����
	public void deleteQNA(int q_no) {
		dao.deleteQNA(q_no);
	}
	
	// A/S �Խ���
	
	
	@Override  // �Խñ� ��� (����¡, �˻� ��� �߰�)
	public List<Map<String, Object>> asList(SearchCriteriaVO scri) throws Exception{
        return dao.asList(scri);
	}
	
	@Override
	public int asListCnt(SearchCriteriaVO scri) throws Exception{
        return dao.asListCnt(scri);
    }
	
	@Override // �Խñ� �ۼ�
	public int create3(Map asMap)throws Exception{
		int as_no=dao.create3(asMap);
		asMap.put("as_no", as_no);
		dao.insertNewImage(asMap);
		return as_no;
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
	
	@Override // �Խñ� ����
	public void updateAS(Map asMap) throws Exception{
		System.out.println("���� ���� �Ϸ�");
		dao.updateAS(asMap);
	}
	
	@Override // �Խñ� ����
	public void deleteAS(int as_no) {
		dao.deleteAS(as_no);
	}
	
}
