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
	
	//상품 상세페이지 내 후기
	public List<Map<String, Object>> reviewList(SearchCriteriaVO scri) throws Exception; // 후기 목록(페이징, 검색 기능 추가)	 
	public int reviewListCnt(SearchCriteriaVO scri) throws Exception;
	public GoodsVO selectReview(int re_num) throws DataAccessException;							// 후기 상세보기
	public List selectImageFileList(int re_num)throws DataAccessException;
	
	// 마우스, 모니터, 키보드, 헤드셋, 스피커
	public List<GoodsVO> productList(String category) throws Exception;
	public List<GoodsVO> productsortList(CriteriaVO cri) throws Exception;

	// 페이징
	public int productListCnt(CriteriaVO cri) throws Exception;
	
	// 상품 검색
	public List<GoodsVO> selectGoodsBySearchWord(String searchWord) throws DataAccessException;
}
 