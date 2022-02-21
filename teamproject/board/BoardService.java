package com.mycompany.teamproject.board.service;

import java.util.List;
import java.util.Map;

import com.mycompany.teamproject.board.vo.BoardVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;

public interface BoardService {
	
	// ��������
	public List<Map<String,Object>>noticeList(SearchCriteriaVO scri) throws Exception; // �� ��� (����¡, �˻� ��� �߰�)
	public int noticeListCnt(SearchCriteriaVO scri) throws Exception;
	public BoardVO viewNotice(int n_no) throws Exception; // �Խñ� �󼼺���
	
	// ��㹮�� �Խ���
	public List<Map<String,Object>>consultingList(SearchCriteriaVO scri) throws Exception; // �� ��� (����¡, �˻� ��� �߰�)
	public int consultingListCnt(SearchCriteriaVO scri) throws Exception; 
	public void create(BoardVO vo)throws Exception; // �� ����
	public BoardVO viewConsulting(int c_no) throws Exception; // �Խñ� �󼼺���
	public void updateConsulting(BoardVO boardVO)throws Exception; // �Խñ� ����
	public void deleteConsulting(int c_no)throws Exception; // �Խñ� ����
	
	// Q&A �Խ���
	public List<Map<String,Object>>qnaList(SearchCriteriaVO scri) throws Exception; // �� ���(����¡, �˻� ��� �߰�)
	public int qnaListCnt(SearchCriteriaVO scri) throws Exception;
	public void create2(BoardVO vo); // �� ����
	public BoardVO viewQNA(int q_no) throws Exception; // �Խñ� �󼼺���
	public void updateQNA(BoardVO boardVO)throws Exception; // �Խñ� ����
	public void deleteQNA(int q_no)throws Exception; // �Խñ� ����
	
	
	

	// A/S �Խ���
	public List<Map<String,Object>>asList(SearchCriteriaVO scri) throws Exception; // �� ���(����¡, �˻� ��� �߰�)
	public int asListCnt(SearchCriteriaVO scri) throws Exception;
	public int create3(Map asMap)throws Exception; // �� ����
	public Map viewAS(int as_no) throws Exception; // �Խñ� �󼼺���
	public void updateAS(Map asMap)throws Exception; // �Խñ� ����
	public void deleteAS(int as_no)throws Exception; // �Խñ� ����
}
