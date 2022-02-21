package com.mycompany.teamproject.admin.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mycompany.teamproject.admin.board.vo.AdminBoardVO;
import com.mycompany.teamproject.board.vo.BoardVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;

public interface AdminBoardDAO {
	// ȸ�� ��������
	public List<Map<String, Object>> noticeList(SearchCriteriaVO scri) throws Exception; // �Խñ� ���(����¡, �˻� ��� �߰�)	 
	public int noticeListCnt(SearchCriteriaVO scri) throws Exception;
	public void ncreate(BoardVO vo)throws DataAccessException;							// �Խñ� �ۼ�
	public BoardVO selectNotice(int n_no) throws DataAccessException;					// �Խñ� �󼼺���
	public void updateNotice(BoardVO boardVO)throws Exception;							// �Խñ� ����
	public void deleteNotice(int n_no)throws DataAccessException;						// �Խñ� ����
	
	// ������ ��������
	public List<Map<String, Object>> adminList(SearchCriteriaVO scri) throws Exception; // �Խñ� ���(����¡, �˻� ��� �߰�)
	public int adminListCnt(SearchCriteriaVO scri) throws Exception;
	public void adcreate(AdminBoardVO adVO)throws DataAccessException;					// �Խñ� �ۼ�
	public AdminBoardVO selectadNotice(int a_main_NO) throws DataAccessException;		// �Խñ� �󼼺���
	public void updateadNotice(AdminBoardVO adVO)throws Exception;						// �Խñ� ����
	public void deleteadNotice(int a_main_NO)throws DataAccessException;				// �Խñ� ����
	
	
	
	
	
	// ��㹮��
	public List<Map<String, Object>> consultingList(SearchCriteriaVO scri) throws Exception; // �Խñ� ���(����¡, �˻� ��� �߰�)	 
	public int consultingListCnt(SearchCriteriaVO scri) throws Exception;
	public BoardVO selectConsulting(int c_no) throws DataAccessException;					 // �Խñ� �󼼺���
	public void receiveConsulting(int c_no)throws DataAccessException;						// �Խñ� ���� �� �亯
	public void creplycreate(BoardVO vo)throws DataAccessException;	
	public void deleteConsulting(int c_no)throws DataAccessException;						// �Խñ� ����
	
	// Q&A �Խ���	
	public List<Map<String, Object>> qnaList(SearchCriteriaVO scri) throws Exception;		// �Խñ� ���(����¡, �˻� ��� �߰�) 
	public int qnaListCnt(SearchCriteriaVO scri) throws Exception;	
	public BoardVO selectQNA(int q_no) throws DataAccessException;							// �Խñ� �󼼺���
	public void receiveQNA(int q_no)throws DataAccessException;								// �Խñ� ���� �� �亯
	public void qreplycreate(BoardVO vo)throws DataAccessException;						
	public void deleteQNA(int q_no)throws DataAccessException;								// �Խñ� ����
	
	//AS
	public List<Map<String, Object>> asList(SearchCriteriaVO scri) throws Exception;		// �Խñ� ���(����¡, �˻� ��� �߰�) 
	public int asListCnt(SearchCriteriaVO scri) throws Exception;
	public BoardVO selectAS(int as_no) throws DataAccessException;							// �Խñ� �󼼺���
	public List selectImageFileList(int as_no)throws DataAccessException;
	public void receiveAS(int as_no)throws DataAccessException;								// �Խñ� ���� �� �亯
	public void asreplycreate(BoardVO vo)throws DataAccessException;
	public void deleteAS(int as_no)throws DataAccessException;								// �Խñ� ����
}
