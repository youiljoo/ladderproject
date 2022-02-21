package com.mycompany.teamproject.admin.goods.dao;


import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.goods.vo.GoodsVO;
import com.mycompany.teamproject.goods.vo.ImageFileVO;


@Repository("AdminGoodsDAO")
public class AdminGoodsDAOImpl implements AdminGoodsDAO {
	@Autowired
	private SqlSession sqlSession;

		//��ǰ �������� �� �ı�
		@Override  // �ı� ��� (�˻����, ����¡ �߰�)
		public List<Map<String, Object>> AllGoodsList(SearchCriteriaVO scri) throws Exception{
			return sqlSession.selectList("mapper.admin_goods.AllGoodsList",scri);
		}
		@Override
		public int AllGoodsListCnt(SearchCriteriaVO scri) throws Exception {
			return sqlSession.selectOne("mapper.admin_goods.AllGoodsListCnt");
		}
		
		@Override //��ǰ �󼼺���
		public GoodsVO GoodsDetail(int productNum) throws DataAccessException {			
			return sqlSession.selectOne("mapper.admin_goods.selectGoodsDetail",productNum);
		}
		
		@Override
		public List selectGoodsImageFileList(int productNum)throws DataAccessException{
			List<ImageFileVO> imageFileList=null;
			imageFileList=sqlSession.selectList("mapper.admin_goods.selectGoodsImageFileList",productNum);
			return imageFileList;
		}
		
		@Override //��ǰ ���
		public int insertNewGoods(Map newGoodsMap)throws DataAccessException{
			sqlSession.insert("mapper.admin_goods.insertNewGoods",newGoodsMap);
			return Integer.parseInt((String)newGoodsMap.get("productNum"));
		}
		
		@Override
		public void insertGoodsImageFile(List fileList)throws DataAccessException{
			for(int i=0; i < fileList.size();i++) {
				ImageFileVO imageFileVO=(ImageFileVO)fileList.get(i);
				
				
				sqlSession.insert("mapper.admin_goods.insertGoodsImageFile",imageFileVO);	
			}
			
		}
		
		@Override // ��ǰ ����
		public void updateGoodsInfo(Map proMap) throws DataAccessException{
			sqlSession.update("mapper.admin_goods.updateGoodsInfo",proMap);
		}
		
		@Override
		public void updateGoodsImage(List<ImageFileVO> imageFileList) throws DataAccessException {
			
			for(int i=0; i<imageFileList.size();i++){
				ImageFileVO imageFileVO = imageFileList.get(i);
				sqlSession.update("mapper.admin_goods.updateGoodsImage",imageFileVO);	
			}
		}
		@Override
		public void deleteGoodsImage(int imageNum) throws DataAccessException{
			sqlSession.delete("mapper.admin_goods.deleteGoodsImage",imageNum);
		}
		
		@Override
		public void deleteGoodsImage(List fileList) throws DataAccessException{
			int imageNum;
			for(int i=0; i<fileList.size();i++){
				ImageFileVO bean=(ImageFileVO) fileList.get(i);
				imageNum=bean.getImageNum();
				sqlSession.delete("mapper.admin_goods.deleteGoodsImage",imageNum);	
			}
		}
		
		@Override  //��ǰ ����
		public void deleteGoods(int productNum)throws DataAccessException{
			sqlSession.delete("mapper.admin_goods.deleteGoods", productNum);
		}
		
		//��ǰ �������� �� �ı�
		@Override  // �ı� ��� (�˻����, ����¡ �߰�)
		public List<Map<String, Object>> reviewList(SearchCriteriaVO scri) throws Exception{
			return sqlSession.selectList("mapper.admin_goods.reviewList",scri);
		}
		@Override
		public int reviewListCnt(SearchCriteriaVO scri) throws Exception {
			return sqlSession.selectOne("mapper.admin_goods.reviewListCnt");
		}

		@Override //�ı� �󼼺���
		public GoodsVO selectReview(int re_num) throws DataAccessException {			
			return sqlSession.selectOne("mapper.admin_goods.selectReview",re_num);
		}
		
		
		@Override //�ı� �亯
		public void updateReview(GoodsVO vo) throws Exception {
			System.out.println("��� DAO �Ϸ�");
			sqlSession.update("mapper.admin_goods.updateReview",vo);
			
		}	
		@Override  //�ı� ����
		public void deleteReview(int re_num)throws DataAccessException{
			sqlSession.delete("mapper.admin_goods.deleteReview", re_num);
		}
		
		

	
}
