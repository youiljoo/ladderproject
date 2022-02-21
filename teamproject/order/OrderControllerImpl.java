package com.mycompany.teamproject.order.controller;

import java.util.ArrayList;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.teamproject.goods.vo.GoodsVO;
import com.mycompany.teamproject.member.vo.MemberVO;
import com.mycompany.teamproject.order.service.OrderService;
import com.mycompany.teamproject.order.vo.OrderVO;

@RequestMapping(produces="text/plain; charset=UTF-8") 
@Controller("orderController")
public class OrderControllerImpl implements OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderVO orderVO;
	
	@RequestMapping(value="/orderpayment.do" ,method = RequestMethod.POST)
	public ModelAndView orderpayment(@ModelAttribute("orderVO") OrderVO _orderVO,
			                       HttpServletRequest request, HttpServletResponse response)  throws Exception{
		
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		session=request.getSession();
	
		String action=(String)session.getAttribute("action");
	
		 if(action!=null && action.equals("/orderpayment.do")){
				orderVO=(OrderVO)session.getAttribute("orderInfo"); 
				session.removeAttribute("action");
			 }else {
				 orderVO=_orderVO;
			 }
		String viewName=(String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		List myOrderList=new ArrayList<OrderVO>();
		myOrderList.add(orderVO);
		
		MemberVO memberInfo=(MemberVO)session.getAttribute("memberInfo");
		
		session.setAttribute("myOrderList", myOrderList);
		session.setAttribute("orderer", memberInfo);
		return mav;
	}
	
	@RequestMapping(value="/orderAllCartGoods.do" ,method = RequestMethod.POST)
	public ModelAndView orderAllCartGoods( @RequestParam("cartproductAmt")  String[] cartproductAmt,
			                 HttpServletRequest request, HttpServletResponse response)  throws Exception{
		String viewName=(String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		HttpSession session=request.getSession();
		Map cartMap=(Map)session.getAttribute("cartMap");
		List myOrderList=new ArrayList<OrderVO>();
		
		List<GoodsVO> myGoodsList=(List<GoodsVO>)cartMap.get("myGoodsList"); 
		MemberVO memberVO=(MemberVO)session.getAttribute("memberInfo");
		
		for(int i=0; i<cartproductAmt.length;i++){
			String[] cart_goods=cartproductAmt[i].split(":");
			for(int j = 0; j< myGoodsList.size();j++) {
				GoodsVO goodsVO = myGoodsList.get(j);
				int productNum = goodsVO.getProductNum(); 
				if(productNum==Integer.parseInt(cart_goods[0])) {
					OrderVO _orderVO=new OrderVO();
					String productName=goodsVO.getProductName();
					int productPrice=goodsVO.getProductPrice();
					String originFileName=goodsVO.getOriginFileName();
					String category=goodsVO.getCategory();
					_orderVO.setProductNum(productNum);
					_orderVO.setProductName(productName);
					_orderVO.setProductPrice(productPrice);
					_orderVO.setOriginFileName(originFileName);
					_orderVO.setCategory(category);
					_orderVO.setProductAmt(Integer.parseInt(cart_goods[1]));
					myOrderList.add(_orderVO);
					break;
				}
			} 
		} 
		session.setAttribute("myOrderList", myOrderList);
		session.setAttribute("orderer", memberVO);
		return mav; 
	}	

	@RequestMapping(value="/payToOrderGoods.do" ,method = RequestMethod.POST)
	public ModelAndView payToOrderGoods(@RequestParam Map<String, String> receiverMap,
			                       HttpServletRequest request, HttpServletResponse response)  throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String viewName=(String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		HttpSession session=request.getSession();
		MemberVO memberVO=(MemberVO)session.getAttribute("orderer");
		List<OrderVO> myOrderList=(List<OrderVO>)session.getAttribute("myOrderList"); 
		Boolean isLogOn=(Boolean)session.getAttribute("isLogOn");
		
		if(isLogOn==null || isLogOn==false){
			String user_id1= "비회원" ;
			
			for(int i=0; i<myOrderList.size();i++){
				OrderVO orderVO=(OrderVO)myOrderList.get(i);
				orderVO.setUser_id(user_id1);
				orderVO.setTotalprice(receiverMap.get("totalprice")); 
				orderVO.setOrder_name(receiverMap.get("order_name"));
				orderVO.setOrder_phone(receiverMap.get("order_phone"));
				orderVO.setOrder_email(receiverMap.get("order_email"));
				orderVO.setMemsqname(receiverMap.get("memsqname"));
				orderVO.setMemsqphonenum(receiverMap.get("memsqphonenum"));
				orderVO.setMemsqaddr(receiverMap.get("memsqaddr"));
				orderVO.setDelivery_message(receiverMap.get("delivery_message"));
				orderVO.setMempayment(receiverMap.get("mempayment"));	 
				myOrderList.set(i, orderVO);  
			}
			 orderService.addNewOrder(myOrderList);
		}else{
			String user_id= memberVO.getUser_id(); 
		for(int i=0; i<myOrderList.size();i++){
			OrderVO orderVO=(OrderVO)myOrderList.get(i);
			orderVO.setUser_id(user_id);
			orderVO.setTotalprice(receiverMap.get("totalprice"));
			orderVO.setOrder_name(receiverMap.get("order_name"));
			orderVO.setOrder_phone(receiverMap.get("order_phone"));
			orderVO.setOrder_email(receiverMap.get("order_email"));
			orderVO.setMemsqname(receiverMap.get("memsqname"));
			orderVO.setMemsqphonenum(receiverMap.get("memsqphonenum"));
			orderVO.setMemsqaddr(receiverMap.get("memsqaddr"));
			orderVO.setDelivery_message(receiverMap.get("delivery_message"));
			orderVO.setMempayment(receiverMap.get("mempayment"));	
			myOrderList.set(i, orderVO); 
		}
	    orderService.addNewOrder(myOrderList);
		}
	    
		mav.addObject("myOrderInfo",receiverMap);  
		mav.addObject("myOrderList", myOrderList);
		return mav;
	}

}

