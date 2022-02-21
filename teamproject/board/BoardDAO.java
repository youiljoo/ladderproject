package com.mycompany.teamproject.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mycompany.teamproject.board.vo.BoardVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;

public interface BoardDAO {
	
	// ��������
	public List<Map<String, Object>> noticeList(SearchCriteriaVO scri) throws Exception; // �Խñ� ���(����¡, �˻� ��� �߰�)	 
	public int noticeListCnt(SearchCriteriaVO scri) throws Exception; 
	public BoardVO selectNotice(int n_no) throws DataAccessException;					// �Խñ� �󼼺���
	
	
	
	// ��㹮�� �Խ���
	
	public List<Map<String, Object>> consultingList(SearchCriteriaVO scri) throws Exception; // �Խñ� ���(����¡, �˻� ��� �߰�)	 
	public int consultingListCnt(SearchCriteriaVO scri) throws Exception; 
	public void create(BoardVO vo)throws DataAccessException;								// �Խñ� �ۼ�
	public BoardVO selectConsulting(int c_no) throws DataAccessException;					// �Խñ� �󼼺���
	public void updateConsulting(BoardVO boardVO)throws Exception;							// �Խñ� ����
	public void deleteConsulting(int c_no)throws DataAccessException;						// �Խñ� ����
	
	
	// Q&A �Խ���
	
	public List<Map<String, Object>> qnaList(SearchCriteriaVO scri) throws Exception;		// �Խñ� ���(����¡, �˻� ��� �߰�) 
	public int qnaListCnt(SearchCriteriaVO scri) throws Exception;							
	public void create2(BoardVO vo)throws DataAccessException;								// �Խñ� �ۼ�
	public BoardVO selectQNA(int q_no) throws DataAccessException;							// �Խñ� �󼼺���
	public void updateQNA(BoardVO boardVO)throws Exception;									// �Խñ� ����
	public void deleteQNA(int q_no)throws DataAccessException;								// �Խñ� ����
	
	// A&S �Խ���
	
	public List<Map<String, Object>> asList(SearchCriteriaVO scri) throws Exception;		// �Խñ� ���(����¡, �˻� ��� �߰�)	 
	public int asListCnt(SearchCriteriaVO scri) throws Exception;							
	public int create3(Map asMap)throws DataAccessException;								// �Խñ� �ۼ�
	public void insertNewImage(Map asMap)throws DataAccessException;
	public List selectImageFileList(int as_no)throws DataAccessException;	
	public BoardVO selectAS(int as_no) throws DataAccessException;							// �Խñ� �󼼺���
	public void updateAS(Map asMap)throws Exception;										// �Խñ� ����
	public void deleteAS(int as_no)throws DataAccessException;								// �Խñ� ����
	
	


	
}
