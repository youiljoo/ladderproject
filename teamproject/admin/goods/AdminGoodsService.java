package com.mycompany.teamproject.admin.goods.service;

import java.util.List;
import java.util.Map;

import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.goods.vo.GoodsVO;
import com.mycompany.teamproject.goods.vo.ImageFileVO;

public interface AdminGoodsService {
	 
	// 상품 관리
	public List<Map<String,Object>>AllGoodsList(SearchCriteriaVO scri) throws Exception; // 상품 목록 (페이징, 검색 기능 추가)
	public int AllGoodsListCnt(SearchCriteriaVO scri) throws Exception;
	public Map GoodsDetail(int productNum) throws Exception; //상품상세
	public int addNewGoods(Map newGoodsMap) throws Exception; //상품 등록
	public void modifyGoodsInfo(Map proMap) throws Exception; // 상품 수정
	public void modifyGoodsImage(List<ImageFileVO> imageFileList) throws Exception;
	public void removeGoodsImage(int productNum) throws Exception;
	public void addNewGoodsImage(List imageFileList) throws Exception;
	public void deleteGoods(int productNum)throws Exception; // 상품 삭제
	
	// 상품 상세페이지 내 후기
		public List<Map<String,Object>>reviewList(SearchCriteriaVO scri) throws Exception; // 리뷰 목록 (페이징, 검색 기능 추가)
		public int reviewListCnt(SearchCriteriaVO scri) throws Exception;
		public GoodsVO Reviewdetail(int re_num) throws Exception; // 후기 상세보기
		public void updateReview(GoodsVO vo)throws Exception; //후기 답변하기
		public void deleteReview(int re_num)throws Exception; // 후기 삭제
		
		
}
