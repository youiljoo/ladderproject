package com.mycompany.teamproject.mypage.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mycompany.teamproject.board.vo.CriteriaVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.goods.vo.GoodsVO;
import com.mycompany.teamproject.order.vo.OrderVO;

public interface MypageDAO {
	
	// 마이페이지 메인
	public List<Map<String, Object>> listMyOrderGoods(CriteriaVO cri) throws Exception;
	public int myMain(CriteriaVO cri) throws Exception;
	
	public List<Map<String, Object>> orderList(SearchCriteriaVO scri) throws Exception;
	public int orderListCnt(SearchCriteriaVO scri) throws Exception;
	
	// A/S 교환,반품 내역
	public List<Map<String, Object>> mypageSelect(SearchCriteriaVO scri) throws Exception;
	public int mypageList(SearchCriteriaVO scri) throws Exception;
	
	public int pro_review(Map asMap)throws DataAccessException;								// 상품 후기
	public void insertNewImage(Map asMap)throws DataAccessException;
	public List selectImageFileList(int re_num)throws DataAccessException;
	
	
	public List<Map<String, Object>> reviewList(CriteriaVO cri) throws Exception; // 후기 목록(페이징 추가)	 
	public int reviewListCnt(CriteriaVO cri) throws Exception;
	public GoodsVO selectReview(int re_num) throws DataAccessException;							// 후기 상세보기
	
	public void deleteReview(int re_num)throws DataAccessException;								// 후기 삭제

	
	// 상댐 내역
	public List<Map<String, Object>> conList(CriteriaVO cri) throws Exception;  
	public int conListCnt(CriteriaVO cri) throws Exception;
	
	// 후기 수정
	public OrderVO review_edit(int re_num) throws Exception;
	public void pro_review_edit(Map map) throws Exception;
	public void updateImage(Map map) throws Exception;
}
