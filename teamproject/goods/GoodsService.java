package com.mycompany.teamproject.goods.service;

import java.util.List;
import java.util.Map;

import com.mycompany.teamproject.board.vo.CriteriaVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.goods.vo.GoodsVO;

public interface GoodsService {
	
	public Map<String,List<GoodsVO>> listGoods() throws Exception;
	public Map goodsDetail(String _productNum) throws Exception;
	
	// ��ǰ �������� �� �ı�
	public List<Map<String,Object>>reviewList(SearchCriteriaVO scri) throws Exception; // ���� ��� (����¡, �˻� ��� �߰�)
	public int reviewListCnt(SearchCriteriaVO scri) throws Exception;
	public Map viewReview(int re_num) throws Exception; // ���� �󼼺���
	
	// ���콺, �����, Ű����, ����, ����Ŀ
	public List<GoodsVO> productList(String category) throws Exception;
	public List<GoodsVO> productsortList(CriteriaVO cri) throws Exception;
	
	// ����¡
	public int productListCnt(CriteriaVO cri) throws Exception;
	
	// ��ǰ �˻�
	public List<GoodsVO> searchGoods(String searchWord) throws Exception;
}
