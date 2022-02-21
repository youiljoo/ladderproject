package com.mycompany.teamproject.admin.goods.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.teamproject.admin.goods.dao.AdminGoodsDAO;
import com.mycompany.teamproject.board.vo.BoardVO;
import com.mycompany.teamproject.board.vo.ImageVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.goods.vo.GoodsVO;
import com.mycompany.teamproject.goods.vo.ImageFileVO;


@Service("AdminGoodsService")
@Transactional(propagation=Propagation.REQUIRED)
public class AdminGoodsServiceImpl implements AdminGoodsService {
	@Autowired
	private AdminGoodsDAO dao;
	private ImageFileVO vo;		
			@Override   //상품 목록 (페이징, 검색 기능 추가)
			public List<Map<String, Object>> AllGoodsList(SearchCriteriaVO scri) throws Exception{
				List<Map<String, Object>> AllGoodsList=dao.AllGoodsList(scri);
				return AllGoodsList;
			}
	
			@Override
			public int AllGoodsListCnt(SearchCriteriaVO scri) throws Exception{
     
				return dao.AllGoodsListCnt(scri);
			}
			
			@Override // 상품 상세
			public Map GoodsDetail(int productNum) throws Exception {
				Map proMap=new HashMap();
				GoodsVO goodsVO=dao.GoodsDetail(productNum);
				List<ImageFileVO> imageFileList=dao.selectGoodsImageFileList(productNum);
				proMap.put("pro", goodsVO);
				proMap.put("imageFileList", imageFileList);
				return proMap;
				
			}
			
			@Override //상품 등록
			public int addNewGoods(Map newGoodsMap) throws Exception{
				int productNum=dao.insertNewGoods(newGoodsMap);
				
				ArrayList<ImageFileVO> imageFileList=(ArrayList)newGoodsMap.get("imageFileList");
				for(ImageFileVO imageFileVO : imageFileList) {
					imageFileVO.setProductNum(productNum);
				
					
				}
				dao.insertGoodsImageFile(imageFileList);
				return productNum;
			}
			@Override // 상품 수정
			public void modifyGoodsInfo(Map proMap) throws Exception{
				dao.updateGoodsInfo(proMap);
				
			}	
			@Override
			public void modifyGoodsImage(List<ImageFileVO> imageFileList) throws Exception{
				dao.updateGoodsImage(imageFileList); 
			}
			@Override
			public void removeGoodsImage(int productNum) throws Exception{
				dao.deleteGoodsImage(productNum);
			}
			
			@Override
			public void addNewGoodsImage(List imageFileList) throws Exception{
				dao.insertGoodsImageFile(imageFileList);
			}
			
			@Override // 상품 삭제
			public void deleteGoods(int productNum) {
				dao.deleteGoods(productNum);
			}
			

			// 상품 상세페이지 내 후기
	
			@Override   //리뷰 목록 (페이징, 검색 기능 추가)
			public List<Map<String, Object>> reviewList(SearchCriteriaVO scri) throws Exception{
				List<Map<String, Object>> reviewList=dao.reviewList(scri);
				return reviewList;
			}
			
			@Override
			public int reviewListCnt(SearchCriteriaVO scri) throws Exception{
		     
				return dao.reviewListCnt(scri);
		    }

			@Override //후기 상세보기
			public GoodsVO Reviewdetail(int re_num) throws Exception {
				System.out.println("상세페이지 완료");
				System.out.println(dao.selectReview(re_num));
				return dao.selectReview(re_num);
				
			}

			

			@Override //후기 등록
			public void updateReview(GoodsVO vo) throws Exception {
				System.out.println("답변 서비스 완료");
				dao.updateReview(vo);
				
			}
			
			@Override // 후기 삭제
			public void deleteReview(int re_num) {
				dao.deleteReview(re_num);
			}
			
			

	
}
