package com.mycompany.teamproject.goods.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.teamproject.board.vo.BoardVO;
import com.mycompany.teamproject.board.vo.CriteriaVO;
import com.mycompany.teamproject.board.vo.ImageVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.goods.dao.GoodsDAO;
import com.mycompany.teamproject.goods.vo.GoodsVO;
import com.mycompany.teamproject.goods.vo.ImageFileVO;


@Service("goodsService")
@Transactional(propagation=Propagation.REQUIRED)
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	private GoodsDAO goodsDAO;

	public Map<String,List<GoodsVO>> listGoods() throws Exception {
		Map<String,List<GoodsVO>> goodsMap=new HashMap<String,List<GoodsVO>>();
		List<GoodsVO> goodsList=goodsDAO.selectGoodsList("logitech");
		goodsMap.put("popular_item",goodsList);
		
		List<GoodsVO> goodsList2 = goodsDAO.selectGoodsList2();
		goodsMap.put("new_item",goodsList2);
		
		return goodsMap;
	}
		public Map goodsDetail(String _productNum) throws Exception {
			Map goodsMap=new HashMap();
			GoodsVO goodsVO = goodsDAO.selectGoodsDetail(_productNum);
			goodsMap.put("goodsVO", goodsVO);
			List<ImageFileVO> imageList =goodsDAO.selectGoodsDetailImage(_productNum);
			goodsMap.put("imageList", imageList);
			return goodsMap;
		}
		
		// 상품 상세페이지 내 후기
			
		@Override   //리뷰 목록 (페이징, 검색 기능 추가)
		public List<Map<String, Object>> reviewList(SearchCriteriaVO scri) throws Exception{
			List<Map<String, Object>> reviewList=goodsDAO.reviewList(scri);
			return reviewList;
		}
		
		@Override
		public int reviewListCnt(SearchCriteriaVO scri) throws Exception{
	     
			return goodsDAO.reviewListCnt(scri);
	    }
	
		@Override // 후기 상세보기
		public Map viewReview(int re_num) throws Exception {
			Map reMap=new HashMap();
			GoodsVO goodsVO=goodsDAO.selectReview(re_num);
			List<ImageVO> imageFileList=goodsDAO.selectImageFileList(re_num);
			reMap.put("re", goodsVO);
			reMap.put("imageFileList", imageFileList);
			return reMap;
			
		}
		
		// 마우스, 모니터, 키보드, 헤드셋, 스피커
		@Override
		public List<GoodsVO> productList(String category) throws Exception {
			return goodsDAO.productList(category);
		}
		
		@Override
		public List<GoodsVO> productsortList(CriteriaVO cri) throws Exception {			
			return goodsDAO.productsortList(cri);
		}
		
		// 페이징
		@Override
		public int productListCnt(CriteriaVO cri) throws Exception {
			return goodsDAO.productListCnt(cri);
		}
		
		// 상품 검색
		@Override
		public List<GoodsVO> searchGoods(String searchWord) throws Exception{
			return goodsDAO.selectGoodsBySearchWord(searchWord);
		}
	}

