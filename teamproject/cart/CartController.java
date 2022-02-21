package com.mycompany.teamproject.cart.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.teamproject.cart.vo.CartVO;

public interface CartController {
	public ModelAndView myCartMain(HttpServletRequest request, HttpServletResponse response)  throws Exception;
	public @ResponseBody String addGoodsInCart(@RequestParam("productNum") int productNum,@RequestParam("cartproductAmt") int cartproductAmt,HttpServletRequest request, HttpServletResponse response,HttpSession session,CartVO cartVO)  throws Exception;
	public  @ResponseBody String modifyCartQty(@RequestParam("productNum") int productNum,@RequestParam("cartproductAmt") int cartproductAmt,
			                  HttpServletRequest request, HttpServletResponse response)  throws Exception;
	public ModelAndView removeCartGoods(@RequestParam("cid") int cid,HttpServletRequest request, HttpServletResponse response)  throws Exception;
	public ModelAndView removeAllCartGoods(@RequestParam("user_id") String user_id,HttpServletRequest request, HttpServletResponse response)  throws Exception;
	
	

}
 