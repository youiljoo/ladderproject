package com.mycompany.teamproject.goods.service;

import java.util.List;
import java.util.Map;

import com.mycompany.teamproject.board.vo.CriteriaVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.goods.vo.GoodsVO;

public interface GoodsService {
	
	public Map<String,List<GoodsVO>> listGoods() throws Exception;
	public Map goodsDetail(String _productNum) throws Exception;
	
	// 상품 상세페이지 내 후기
	public List<Map<String,Object>>reviewList(SearchCriteriaVO scri) throws Exception; // 리뷰 목록 (페이징, 검색 기능 추가)
	public int reviewListCnt(SearchCriteriaVO scri) throws Exception;
	public Map viewReview(int re_num) throws Exception; // 리뷰 상세보기
	
	// 마우스, 모니터, 키보드, 헤드셋, 스피커
	public List<GoodsVO> productList(String category) throws Exception;
	public List<GoodsVO> productsortList(CriteriaVO cri) throws Exception;
	
	// 페이징
	public int productListCnt(CriteriaVO cri) throws Exception;
	
	// 상품 검색
	public List<GoodsVO> searchGoods(String searchWord) throws Exception;
}
