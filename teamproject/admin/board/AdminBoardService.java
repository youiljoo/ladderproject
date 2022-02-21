package com.mycompany.teamproject.admin.board.service;

import java.util.List;
import java.util.Map;

import com.mycompany.teamproject.admin.board.vo.AdminBoardVO;
import com.mycompany.teamproject.board.vo.BoardVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;

public interface AdminBoardService {
	// ȸ�� ��������
	public List<Map<String,Object>>noticeList(SearchCriteriaVO scri) throws Exception; // ȸ�� �������� �� ��� (����¡, �˻� ��� �߰�)
	public int noticeListCnt(SearchCriteriaVO scri) throws Exception;
	public BoardVO viewNotice(int n_no) throws Exception; // �Խñ� �󼼺���
	public void ncreate(BoardVO vo)throws Exception; // �� ����
	public void updateNotice(BoardVO boardVO)throws Exception; // �Խñ� ����
	public void deleteNotice(int n_no)throws Exception; // �Խñ� ����
	
	// ������ ��������
	public List<Map<String,Object>>adminList(SearchCriteriaVO scri) throws Exception; // �� ��� (����¡, �˻� ��� �߰�)
	public int adminListCnt(SearchCriteriaVO scri) throws Exception;
	public void adcreate(AdminBoardVO adVO)throws Exception; // �� ����
	public AdminBoardVO viewadNotice(int a_main_NO) throws Exception; // �Խñ� �󼼺���
	public void updateadNotice(AdminBoardVO adVO)throws Exception; // �Խñ� ����
	public void deleteadNotice(int a_main_NO)throws Exception; // �Խñ� ����
	
	// ��㹮��
	public List<Map<String,Object>>consultingList(SearchCriteriaVO scri) throws Exception; // �� ��� (����¡, �˻� ��� �߰�)
	public int consultingListCnt(SearchCriteriaVO scri) throws Exception; 
	public BoardVO viewConsulting(int c_no) throws Exception; // �Խñ� �󼼺���
	public void receiveConsulting(int c_no)throws Exception; // �Խñ� ���� �� �亯
	public void creplycreate(BoardVO vo)throws Exception;
	public void deleteConsulting(int c_no)throws Exception; // �Խñ� ����
	
	//Q&A
	public List<Map<String,Object>>qnaList(SearchCriteriaVO scri) throws Exception; // �� ���(����¡, �˻� ��� �߰�)
	public int qnaListCnt(SearchCriteriaVO scri) throws Exception;
	public BoardVO viewQNA(int q_no) throws Exception; // �Խñ� �󼼺���
	public void receiveQNA(int q_no)throws Exception; // �Խñ� ���� �� �亯
	public void qreplycreate(BoardVO vo)throws Exception;
	public void deleteQNA(int q_no)throws Exception; // �Խñ� ����
	
	//AS
	public List<Map<String,Object>>asList(SearchCriteriaVO scri) throws Exception; // �� ���(����¡, �˻� ��� �߰�)
	public int asListCnt(SearchCriteriaVO scri) throws Exception;
	public Map viewAS(int as_no) throws Exception; // �Խñ� �󼼺���
	public void receiveAS(int as_no)throws Exception; // �Խñ� ���� �� �亯
	public void asreplycreate(BoardVO vo)throws Exception;
	public void deleteAS(int as_no)throws Exception; // �Խñ� ����
}
