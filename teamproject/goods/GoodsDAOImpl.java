package com.mycompany.teamproject.goods.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.teamproject.board.vo.CriteriaVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.goods.vo.GoodsVO;
import com.mycompany.teamproject.goods.vo.ImageFileVO;
import com.mycompany.teamproject.mypage.vo.ReviewImageVO;

@Repository("goodsDAO")
public class GoodsDAOImpl  implements GoodsDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<GoodsVO> selectGoodsList(String company) throws DataAccessException {
		List<GoodsVO> goodsList=(ArrayList)sqlSession.selectList("mapper.goods.selectGoodsList",company);
	   return goodsList;	
     
	}
	
	@Override
	public List<GoodsVO> selectGoodsList2() throws DataAccessException {
		List<GoodsVO> goodsList2=(ArrayList)sqlSession.selectList("mapper.goods.selectGoodsList2");
	   return goodsList2;	
     
	}
	
	@Override
	public GoodsVO selectGoodsDetail(String productNum) throws DataAccessException{
		GoodsVO goodsVO=(GoodsVO)sqlSession.selectOne("mapper.goods.selectGoodsDetail",productNum);
		return goodsVO;
	}
	@Override
	public List<ImageFileVO> selectGoodsDetailImage(String productNum) throws DataAccessException{
		List<ImageFileVO> imageList=(ArrayList)sqlSession.selectList("mapper.goods.selectGoodsDetailImage",productNum);
		return imageList;
	}
	
	
	//��ǰ �������� �� �ı�
	@Override  // �ı� ��� (�˻����, ����¡ �߰�)
	public List<Map<String, Object>> reviewList(SearchCriteriaVO scri) throws Exception{
		return sqlSession.selectList("mapper.goods.reviewList",scri);
	}
	@Override
	public int reviewListCnt(SearchCriteriaVO scri) throws Exception {
		return sqlSession.selectOne("mapper.goods.reviewListCnt");
	}
	
	@Override  // �ı� �󼼺���
	public GoodsVO selectReview(int re_num) throws DataAccessException {
		
		return sqlSession.selectOne("mapper.goods.selectReview", re_num);
		
	}
	@Override
	public List selectImageFileList(int re_num)throws DataAccessException{
		List<ReviewImageVO> imageFileList=null;
		imageFileList=sqlSession.selectList("mapper.goods.selectImageFileList",re_num);
		return imageFileList;
	}
	
	// ���콺, �����, Ű����, ����, ����Ŀ
	@Override
	public List<GoodsVO> productList(String category) throws Exception {
		return sqlSession.selectList("mapper.goods.productList", category);
	}
	
	@Override
	public List<GoodsVO> productsortList(CriteriaVO cri) throws Exception {	
		return sqlSession.selectList("mapper.goods.productsortList", cri);
	}
	
	// ����¡
	@Override
	public int productListCnt(CriteriaVO cri) throws Exception {
		return sqlSession.selectOne("mapper.goods.productListCnt", cri);
	}
	
	// ��ǰ �˻�
	@Override
	public List<GoodsVO> selectGoodsBySearchWord(String searchWord) throws DataAccessException{
		return sqlSession.selectList("mapper.goods.selectGoodsBySearchWord",searchWord);
	}
}
