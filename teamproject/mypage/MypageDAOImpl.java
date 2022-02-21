package com.mycompany.teamproject.mypage.dao;

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
import com.mycompany.teamproject.mypage.vo.ReviewImageVO;
import com.mycompany.teamproject.order.vo.OrderVO;

@Repository("mypageDAO")
public class MypageDAOImpl implements MypageDAO {
	@Autowired
	private SqlSession sqlSession;
	
	// 마이페이지 메인
	@Override
	public List<Map<String, Object>> listMyOrderGoods(CriteriaVO cri) throws Exception {
		return sqlSession.selectList("mapper.mypage.listMyOrderGoods", cri);
	}
	
	@Override
	public int myMain(CriteriaVO cri) throws Exception {
		return sqlSession.selectOne("mapper.mypage.myMain", cri);
	}
	
	@Override
	public List<Map<String, Object>> orderList(SearchCriteriaVO scri) throws Exception {
		return sqlSession.selectList("mapper.mypage.orderList", scri);
	}
	
	@Override
	public int orderListCnt(SearchCriteriaVO scri) throws Exception {
		return sqlSession.selectOne("mapper.mypage.orderListCnt", scri);
	}

	// A/S 교환,반품 내역
	@Override
	public List<Map<String, Object>> mypageSelect(SearchCriteriaVO scri) throws Exception {
		return sqlSession.selectList("mapper.mypage.mypageSelect", scri);
	}
	@Override
	public int mypageList(SearchCriteriaVO scri) throws Exception {
		return sqlSession.selectOne("mapper.mypage.mypageList", scri);
	}
	
	@Override  // 상품 후기
	public int pro_review(Map asMap)throws DataAccessException{
		int re_num=selectNewRe_num();
		asMap.put("re_num", re_num);
		sqlSession.insert("mapper.mypage.pro_review",asMap);
		return re_num;
	}
	@Override
	public void insertNewImage(Map asMap)throws DataAccessException{
		List<ReviewImageVO> imageFileList =(ArrayList)asMap.get("imageFileList");
		int re_num=(Integer)asMap.get("re_num");
		int imageFileNO=selectNewImageFileNO();
		System.out.println("이미지 파일 번호:"+imageFileNO);
		for(ReviewImageVO imageVO:imageFileList) {
			imageVO.setImageFileNO(++imageFileNO);
			imageVO.setRe_num(re_num);
		}
		sqlSession.insert("mapper.mypage.insertNewImage",imageFileList);
		System.out.println("이미지 파일 리스트:"+imageFileList);
	}
	@Override
	public List selectImageFileList(int re_num)throws DataAccessException{
		List<ReviewImageVO> imageFileList=null;
		imageFileList=sqlSession.selectList("mapper.mypage.selectImageFileList",re_num);
		return imageFileList;
	}
	private int selectNewRe_num() throws DataAccessException{
		return sqlSession.selectOne("mapper.mypage.selectNewRe_num");
	}
	private int selectNewImageFileNO() throws DataAccessException{
		return sqlSession.selectOne("mapper.mypage.selectNewImageFileNO");
	}
	
	
	// 마이페이지 내가 쓴 후기
	
	
	@Override  // 후기 목록 (페이징 추가)
	public List<Map<String, Object>> reviewList(CriteriaVO cri) throws Exception{
		System.out.println("DAO:"+cri);
		return sqlSession.selectList("mapper.mypage.reviewList",cri);
	}
	@Override
	public int reviewListCnt(CriteriaVO cri) throws Exception {
		return sqlSession.selectOne("mapper.mypage.reviewListCnt", cri);
	}
	
	@Override  // 후기 상세보기
	public GoodsVO selectReview(int re_num) throws DataAccessException {
		
		return sqlSession.selectOne("mapper.goods.selectReview", re_num);
		
	}
	
	@Override  //후기 삭제
	public void deleteReview(int re_num)throws DataAccessException{
		sqlSession.delete("mapper.mypage.deleteReview", re_num);
	}

	// 상담내역
	@Override  
	public List<Map<String, Object>> conList(CriteriaVO cri) throws Exception{
		return sqlSession.selectList("mapper.mypage.conList",cri);
	}
	@Override
	public int conListCnt(CriteriaVO cri) throws Exception {
		return sqlSession.selectOne("mapper.mypage.conListCnt", cri);
	}
	
	// 후기 수정
	@Override
	public OrderVO review_edit(int re_num) throws Exception {
		return sqlSession.selectOne("mapper.mypage.review_edit", re_num);
	}
	
	@Override
	public void pro_review_edit(Map map) throws Exception {
		sqlSession.update("mapper.mypage.pro_review_edit", map);
	}
	
	@Override
	public void updateImage(Map map) throws Exception {
		sqlSession.update("mapper.mypage.updateImage", map);
	}
} 
