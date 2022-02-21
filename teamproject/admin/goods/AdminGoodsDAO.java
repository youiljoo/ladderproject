package com.mycompany.teamproject.admin.goods.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.goods.vo.GoodsVO;
import com.mycompany.teamproject.goods.vo.ImageFileVO;


public interface AdminGoodsDAO {
	
	public List<Map<String, Object>> AllGoodsList(SearchCriteriaVO scri) throws Exception; // 상품 목록(페이징, 검색 기능 추가)	 
	public int AllGoodsListCnt(SearchCriteriaVO scri) throws Exception;
	public GoodsVO GoodsDetail(int productNum) throws DataAccessException; // 상품 상세
	public List selectGoodsImageFileList(int productNum)throws DataAccessException; // 상품 이미지 보여주기
	public int insertNewGoods(Map newGoodsMap)throws DataAccessException; // 상품 등록
	public void insertGoodsImageFile(List fileList)throws DataAccessException; // 상품 이미지 추가
	public void updateGoodsInfo(Map proMap) throws DataAccessException; // 상품 수정
	public void updateGoodsImage(List<ImageFileVO> imageFileList) throws DataAccessException;
	public void deleteGoodsImage(int productNum) throws DataAccessException;
	public void deleteGoodsImage(List fileList) throws DataAccessException;
	public void deleteGoods(int productNum)throws DataAccessException;								// 상품 삭제
	
	//상품 상세페이지 내 후기
	public List<Map<String, Object>> reviewList(SearchCriteriaVO scri) throws Exception; // 후기 목록(페이징, 검색 기능 추가)	 
	public int reviewListCnt(SearchCriteriaVO scri) throws Exception;
	public GoodsVO selectReview(int re_num) throws DataAccessException;					// 후기 상세보기 
	public void updateReview(GoodsVO vo)throws Exception;							// 후기 답변
	public void deleteReview(int re_num)throws DataAccessException;						// 후기 삭제
	
}
