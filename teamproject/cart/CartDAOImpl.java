package com.mycompany.teamproject.cart.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.teamproject.cart.vo.CartVO;
import com.mycompany.teamproject.goods.vo.GoodsVO;
import com.mycompany.teamproject.member.vo.MemberVO;

@Repository("cartDAO")
public class CartDAOImpl  implements  CartDAO{
	@Autowired
	private SqlSession sqlSession;
	
	public List<CartVO> selectCartList(CartVO cartVO) throws DataAccessException {
		List<CartVO> cartList =(List)sqlSession.selectList("mapper.cart.selectCartList",cartVO);
		return cartList;
	}

	public List<GoodsVO> selectGoodsList(List<CartVO> cartList) throws DataAccessException {
		
		List<GoodsVO> myGoodsList;
		myGoodsList = sqlSession.selectList("mapper.cart.selectGoodsList",cartList);
		return myGoodsList;
	}
	public boolean selectCountInCart(CartVO cartVO) throws DataAccessException {
		String  result =sqlSession.selectOne("mapper.cart.selectCountInCart",cartVO);
		return Boolean.parseBoolean(result);
	}

	public void insertGoodsInCart(CartVO cartVO) throws DataAccessException{ 
		int cid=selectMaxCartId();
		cartVO.setCid(cid);
		sqlSession.insert("mapper.cart.insertGoodsInCart",cartVO);
	}
	 
	public void updateCartGoodsQty(CartVO cartVO) throws DataAccessException{
		sqlSession.insert("mapper.cart.updateCartGoodsQty",cartVO);
	}
	
	public void deleteCartGoods(int cid) throws DataAccessException{
		sqlSession.delete("mapper.cart.deleteCartGoods",cid);
	}
	
	@Override
	public void deleteAllCartGoods(CartVO cartVO) throws DataAccessException{
		sqlSession.delete("mapper.cart.deleteAllCartGoods",cartVO);
	}
	
	
	private int selectMaxCartId() throws DataAccessException{
		int cid =sqlSession.selectOne("mapper.cart.selectMaxCartId");
		return cid;
	}

	@Override
	public void cartUpdate(MemberVO memberVO) {
		sqlSession.update("mapper.cart.cartUpdate",memberVO);
		
	}

}
