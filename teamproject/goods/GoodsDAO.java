package com.mycompany.teamproject.goods.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mycompany.teamproject.board.vo.BoardVO;
import com.mycompany.teamproject.board.vo.CriteriaVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.goods.vo.GoodsVO;
import com.mycompany.teamproject.goods.vo.ImageFileVO;


public interface GoodsDAO {
	public List<GoodsVO> selectGoodsList(String company ) throws DataAccessException;
	public List<GoodsVO> selectGoodsList2() throws DataAccessException;
	public List<ImageFileVO> selectGoodsDetailImage(String productNum) throws DataAccessException;
	public GoodsVO selectGoodsDetail(String productNum) throws DataAccessException;
	
	//��ǰ �������� �� �ı�
	public List<Map<String, Object>> reviewList(SearchCriteriaVO scri) throws Exception; // �ı� ���(����¡, �˻� ��� �߰�)	 
	public int reviewListCnt(SearchCriteriaVO scri) throws Exception;
	public GoodsVO selectReview(int re_num) throws DataAccessException;							// �ı� �󼼺���
	public List selectImageFileList(int re_num)throws DataAccessException;
	
	// ���콺, �����, Ű����, ����, ����Ŀ
	public List<GoodsVO> productList(String category) throws Exception;
	public List<GoodsVO> productsortList(CriteriaVO cri) throws Exception;

	// ����¡
	public int productListCnt(CriteriaVO cri) throws Exception;
	
	// ��ǰ �˻�
	public List<GoodsVO> selectGoodsBySearchWord(String searchWord) throws DataAccessException;
}
 