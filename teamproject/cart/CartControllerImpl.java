package com.mycompany.teamproject.cart.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.mycompany.teamproject.cart.service.CartService;
import com.mycompany.teamproject.cart.vo.CartVO;
import com.mycompany.teamproject.member.vo.MemberVO;

@Controller("cartController")
public class CartControllerImpl implements CartController{
	@Autowired
	private CartService cartService;
	@Autowired
	private CartVO cartVO;
	@Autowired 
	private MemberVO memberVO; 
	
	@ResponseBody
	@RequestMapping(value="/cart.do" ,method = RequestMethod.GET)
	public ModelAndView myCartMain(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		String viewName=(String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		HttpSession session=request.getSession();
		Cookie cookie = WebUtils.getCookie(request, "cartCookie");
		
		//비회원시 쿠키value인 ckid 사용
	    if (cookie != null && session.getAttribute("memberInfo")== null) { 
	      String cartCookie = cookie.getValue(); 
	      cartVO.setCart_ckid(cartCookie); 
	      cartVO.setUser_id(cartCookie);
	      cartVO.setCart_mem_no(0);
	      Map<String ,List> cartMap=cartService.myCartList(cartVO); 
	      session.setAttribute("cartMap", cartMap);
	   
	    } else if (cookie == null && session.getAttribute("memberInfo") != null) {
	    //회원시 mem_no이용
	    	MemberVO memberVO = (MemberVO) session.getAttribute("memberInfo");
	    	cartVO.setCart_mem_no(memberVO.getMember_id());
	    	String user_id=memberVO.getUser_id();
			cartVO.setUser_id(user_id);  
	    	Map<String ,List> cartMap=cartService.myCartList(cartVO);
	    	session.setAttribute("cartMap", cartMap);
	    } 
		return mav;
	}


	  @RequestMapping(value = {"/addGoodsInCart.do"}, method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	  public @ResponseBody String addGoodsInCart(@RequestParam("productNum") int productNum, @RequestParam("cartproductAmt") int cartproductAmt,  HttpServletRequest request,
				HttpServletResponse response, HttpSession session, CartVO cartVO) throws Exception {
	    Cookie cookie = WebUtils.getCookie(request, "cartCookie"); 
	    
	    //비회원장바구니 첫 클릭시 쿠키생성
	    if (cookie == null && session.getAttribute("memberInfo") == null) {
	      String ckid = RandomStringUtils.random(6, true, true);
	      Cookie cartCookie = new Cookie("cartCookie", ckid);
	      cartCookie.setPath("/"); 
	      cartCookie.setMaxAge(60 * 60 * 24 * 1);
	      response.addCookie(cartCookie);
	      cartVO.setUser_id(ckid);
	      cartVO.setCart_ckid(ckid);
	      cartVO.setProductNum(productNum);
		  cartVO.setCartproductAmt(cartproductAmt);
	      this.cartService.addGoodsInCart(cartVO);
	       
	     //비회원 장바구니 쿠키생성 후 상품추가
	    } else if (cookie != null && session.getAttribute("memberInfo") == null) {
	     
	      String ckValue = cookie.getValue();
	      cartVO.setUser_id(ckValue);
	      cartVO.setCart_ckid(ckValue);
	      cartVO.setProductNum(productNum);
		  cartVO.setCartproductAmt(cartproductAmt);
	      //장바구니 중복제한
	      if(cartService.findCartGoods(cartVO) == true) {
	    	  return "already_existed";
	      }
	      //쿠키 시간 재설정해주기
	      cookie.setPath("/");
	      cookie.setMaxAge(60 * 60 * 24 * 1);
	      response.addCookie(cookie);
	      
	      cartService.addGoodsInCart(cartVO);
	      
	     //회원 장바구니 상품추가
	    } else if(session.getAttribute("memberInfo") != null){
	      MemberVO memberVO = (MemberVO) session.getAttribute("memberInfo");
	      memberVO=(MemberVO)session.getAttribute("memberInfo");
	      cartVO.setUser_id(memberVO.getUser_id());
	      cartVO.setMember_id(memberVO.getMember_id());
	      cartVO.setCart_mem_no(memberVO.getMember_id());
	      cartVO.setProductNum(productNum);
	      cartVO.setCartproductAmt(cartproductAmt);
	      if(cartService.findCartGoods(cartVO) == true) {
	    	  return "already_existed";
	      }
	      cartService.addGoodsInCart(cartVO);
	    } 
	    return "add_success"; 
	  }



	/*
	@RequestMapping(value="/addGoodsInCart.do" ,method = RequestMethod.POST,produces = "application/text; charset=utf8")
	public  @ResponseBody int addGoodsInCart(@RequestParam("productNum") int productNum, @RequestParam("cartproductAmt") int cartproductAmt,
			                    HttpServletRequest request, HttpServletResponse response)  throws Exception{
	    Cookie cookie = WebUtils.getCookie(request, "cartCookie");
		HttpSession session=request.getSession();
	    //비회원장바구니 첫 클릭시 쿠키생성
	   
		if (cookie == null && session.getAttribute("memberInfo") == null) {
	      String ckid = RandomStringUtils.random(6, true, true);
	      Cookie cartCookie = new Cookie("cartCookie", ckid);
	      cartCookie.setPath("/");
	      cartCookie.setMaxAge(60 * 60 * 24 * 1);
	      response.addCookie(cartCookie);
	      cartVO.setuser_id(ckid);
	      cartVO.setCart_ckid(ckid);
		  cartVO.setproductNum(productNum);
		  cartVO.setcartproductAmt(cartproductAmt);
		  cartService.addGoodsInCart(cartVO);
	    } 
	   
	    else if (cookie != null && session.getAttribute("memberInfo") == null) {
	    	
	        String ckValue = cookie.getValue();
	        cartVO.setCart_ckid(ckValue); 
	        cartVO.setuser_id(ckValue);
			cartVO.setproductNum(productNum);
			cartVO.setcartproductAmt(cartproductAmt); 
	        //장바구니 중복제한
	        if(cartService.findCartGoods(cartVO) != false) {
	      	  return 2;
	        }
	        //쿠키 시간 재설정해주기
	        cookie.setPath("/"); 
	        cookie.setMaxAge(60 * 60 * 24 * 1);
	        response.addCookie(cookie);  
	        cartService.addGoodsInCart(cartVO);
	    }	  //회원 장바구니 상품추가
	   
	    else if(session.getAttribute("memberInfo") != null)  {
    	memberVO=(MemberVO)session.getAttribute("memberInfo");
		String user_id=memberVO.getUser_id();
		int member_id=memberVO.getMember_id();
		 
		cartVO.setMember_id(member_id); 
		cartVO.setuser_id(user_id);
		cartVO.setCart_mem_no(member_id);  
		cartVO.setproductNum(productNum);
		cartVO.setcartproductAmt(cartproductAmt);
		boolean isAreadyExisted=cartService.findCartGoods(cartVO); 
		System.out.println("isAreadyExisted:"+isAreadyExisted);
		if(isAreadyExisted==true){
			return 5;
		}else{
			cartService.addGoodsInCart(cartVO);
			return 6; 

		}
    } 
    return 1;
  }

	     */ 
/*
		memberVO=(MemberVO)session.getAttribute("memberInfo");
		String user_id=memberVO.getUser_id();
		
		cartVO.setuser_id(user_id);
		cartVO.setproductNum(productNum);
		cartVO.setcartproductAmt(cartproductAmt);
		boolean isAreadyExisted=cartService.findCartGoods(cartVO); 
		System.out.println("isAreadyExisted:"+isAreadyExisted);
		if(isAreadyExisted==true){
			return "already_existed";
		}else{
			cartService.addGoodsInCart(cartVO);
			return "add_success";
		}
	}*/
	@RequestMapping(value="/modifyCartQty.do" ,method = RequestMethod.POST)
	public @ResponseBody String  modifyCartQty(@RequestParam("productNum") int productNum,
			                                   @RequestParam("cartproductAmt") int cartproductAmt,
			                                    HttpServletRequest request, HttpServletResponse response)  throws Exception{
		HttpSession session=request.getSession();
		Cookie cookie = WebUtils.getCookie(request, "cartCookie"); 
		
		//비회원시 쿠키value인 ckid 사용
	    if (cookie != null && session.getAttribute("memberInfo")== null) { 
	    	 String cartCookie = cookie.getValue(); 
		      cartVO.setCart_ckid(cartCookie); 
		      cartVO.setProductNum(productNum);
		      cartVO.setCartproductAmt(cartproductAmt);
		      boolean result=cartService.modifyCartQty(cartVO); 
				if(result!=true) { 
					return "modify_failed";
		    }
		   
		    } else if (cookie == null && session.getAttribute("memberInfo") != null) {
		    //회원시 mem_no이용
		    	memberVO=(MemberVO)session.getAttribute("memberInfo");
				String user_id=memberVO.getUser_id();
				cartVO.setProductNum(productNum);
				cartVO.setUser_id(user_id);
				cartVO.setCartproductAmt(cartproductAmt);
				boolean result=cartService.modifyCartQty(cartVO); 
				if(result!=true) { 
					return "modify_failed";
		    }		
			}
	    return "modify_success";
	}
	
	@RequestMapping(value="/removeCartGoods.do" ,method = RequestMethod.POST)
	public ModelAndView removeCartGoods(@RequestParam("cid") int cid,
			                          HttpServletRequest request, HttpServletResponse response)  throws Exception{
		ModelAndView mav=new ModelAndView();
		cartService.removeCartGoods(cid);
		mav.setViewName("redirect:/cart.do");
		return mav;
	}
	
	@RequestMapping(value="/removeAllCartGoods.do" ,method = RequestMethod.POST)
	public ModelAndView removeAllCartGoods(@RequestParam("user_id") String user_id,
			                          HttpServletRequest request, HttpServletResponse response)  throws Exception{
		ModelAndView mav=new ModelAndView();
		Cookie cookie = WebUtils.getCookie(request, "cartCookie");
		HttpSession session=request.getSession();
		//비회원 장바구니 비우기
		if (cookie != null && session.getAttribute("memberInfo")== null) {
			cartVO.setUser_id(user_id);
			cartService.removeAllCartGoods(cartVO);
		}
		//회원 장바구니 비우기 
		else if (cookie == null && session.getAttribute("memberInfo") != null) {
		    	MemberVO memberVO = (MemberVO) session.getAttribute("memberInfo");
		    	cartVO.setCart_mem_no(memberVO.getMember_id());
		    	cartService.removeAllCartGoods(cartVO);
		}
		mav.setViewName("redirect:/cart.do");
		return mav;
	}



 


}