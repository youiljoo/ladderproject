package com.mycompany.teamproject.admin.goods.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.goods.vo.GoodsVO;
import com.mycompany.teamproject.goods.vo.ImageFileVO;


public interface AdminGoodsDAO {
	
	public List<Map<String, Object>> AllGoodsList(SearchCriteriaVO scri) throws Exception; // ��ǰ ���(����¡, �˻� ��� �߰�)	 
	public int AllGoodsListCnt(SearchCriteriaVO scri) throws Exception;
	public GoodsVO GoodsDetail(int productNum) throws DataAccessException; // ��ǰ ��
	public List selectGoodsImageFileList(int productNum)throws DataAccessException; // ��ǰ �̹��� �����ֱ�
	public int insertNewGoods(Map newGoodsMap)throws DataAccessException; // ��ǰ ���
	public void insertGoodsImageFile(List fileList)throws DataAccessException; // ��ǰ �̹��� �߰�
	public void updateGoodsInfo(Map proMap) throws DataAccessException; // ��ǰ ����
	public void updateGoodsImage(List<ImageFileVO> imageFileList) throws DataAccessException;
	public void deleteGoodsImage(int productNum) throws DataAccessException;
	public void deleteGoodsImage(List fileList) throws DataAccessException;
	public void deleteGoods(int productNum)throws DataAccessException;								// ��ǰ ����
	
	//��ǰ �������� �� �ı�
	public List<Map<String, Object>> reviewList(SearchCriteriaVO scri) throws Exception; // �ı� ���(����¡, �˻� ��� �߰�)	 
	public int reviewListCnt(SearchCriteriaVO scri) throws Exception;
	public GoodsVO selectReview(int re_num) throws DataAccessException;					// �ı� �󼼺��� 
	public void updateReview(GoodsVO vo)throws Exception;							// �ı� �亯
	public void deleteReview(int re_num)throws DataAccessException;						// �ı� ����
	
}
