package com.mycompany.teamproject.cart.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.mycompany.teamproject.goods.vo.GoodsVO;

@Component("cartVO")
public class CartVO {
	private int cid;
	private int productNum;
	private int cartproductAmt;
	private String user_id;
	private Date cart_cklimit;
	private String cart_ckid;
	private String cart_option_content;
	private int cart_option_no;
	private int member_id;
	private int cart_mem_no; 
	private GoodsVO goodsVO;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getProductNum() {
		return productNum;
	}
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
	public int getCartproductAmt() {
		return cartproductAmt;
	}
	public void setCartproductAmt(int cartproductAmt) {
		this.cartproductAmt = cartproductAmt;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getCart_cklimit() {
		return cart_cklimit;
	}
	public void setCart_cklimit(Date cart_cklimit) {
		this.cart_cklimit = cart_cklimit;
	}
	public String getCart_ckid() {
		return cart_ckid;
	}
	public void setCart_ckid(String cart_ckid) {
		this.cart_ckid = cart_ckid;
	}
	public String getCart_option_content() {
		return cart_option_content;
	}
	public void setCart_option_content(String cart_option_content) {
		this.cart_option_content = cart_option_content;
	}
	public int getCart_option_no() {
		return cart_option_no;
	}
	public void setCart_option_no(int cart_option_no) {
		this.cart_option_no = cart_option_no;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public int getCart_mem_no() {
		return cart_mem_no;
	}
	public void setCart_mem_no(int cart_mem_no) {
		this.cart_mem_no = cart_mem_no;
	}
	public GoodsVO getGoodsVO() {
		return goodsVO;
	}
	public void setGoodsVO(GoodsVO goodsVO) {
		this.goodsVO = goodsVO;
	}
	 
}