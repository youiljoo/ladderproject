package com.mycompany.teamproject.cart.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mycompany.teamproject.cart.vo.CartVO;
import com.mycompany.teamproject.goods.vo.GoodsVO;
import com.mycompany.teamproject.member.vo.MemberVO;

public interface CartDAO {
	public List<CartVO> selectCartList(CartVO cartVO) throws DataAccessException;
	public List<GoodsVO> selectGoodsList(List<CartVO> cartList) throws DataAccessException;
	public boolean selectCountInCart(CartVO cartVO) throws DataAccessException;
	public void insertGoodsInCart(CartVO cartVO) throws DataAccessException;
	public void updateCartGoodsQty(CartVO cartVO) throws DataAccessException;
	public void deleteCartGoods(int cid) throws DataAccessException;
	public void deleteAllCartGoods(CartVO cartVO) throws DataAccessException;
	public void cartUpdate(MemberVO memberVO);


} 
