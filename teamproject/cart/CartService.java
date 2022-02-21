package com.mycompany.teamproject.cart.service;

import java.util.List;
import java.util.Map;

import com.mycompany.teamproject.cart.vo.CartVO;
import com.mycompany.teamproject.member.vo.MemberVO;

public interface CartService {
	public Map<String ,List> myCartList(CartVO cartVO) throws Exception;
	public boolean findCartGoods(CartVO cartVO) throws Exception;
	public void addGoodsInCart(CartVO cartVO) throws Exception;
	public boolean modifyCartQty(CartVO cartVO) throws Exception;
	public void removeCartGoods(int cid) throws Exception;
	public void removeAllCartGoods(CartVO cartVO) throws Exception;
	public void cartUpdate(MemberVO memberVO);

}
