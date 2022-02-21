package com.mycompany.teamproject.admin.order.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.teamproject.admin.order.service.AdminOrderService;
import com.mycompany.teamproject.board.vo.PagingVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.order.vo.OrderVO;

@Controller("adminOrderController")
public class AdminOrderControllerImpl implements AdminOrderController {
	@Autowired
	private OrderVO orderVO;
	@Autowired
	private AdminOrderService adminOrderService;
	
	@Override
	@RequestMapping(value="/admin_order.do" ,method = RequestMethod.GET)
	public ModelAndView adminorder(SearchCriteriaVO scri, HttpServletRequest request, HttpServletResponse response) throws Exception {
		int orderListCnt = adminOrderService.orderListCnt(scri);
		
		PagingVO paging = new PagingVO();
		paging.setCri(scri);
		paging.setTotalCount(orderListCnt);
		
		List<Map<String, Object>> list = adminOrderService.adminOrder(scri);
		ModelAndView mav = new ModelAndView("admin_order");
		mav.addObject("orderList", scri);
		mav.addObject("admin", list);
		mav.addObject("paging", paging);
		return mav;

	}
	
	@Override
	@RequestMapping(value="/admin_order_de.do" ,method = RequestMethod.GET)
	public ModelAndView adminorderde(@RequestParam("memordernum") String memordernum, OrderVO orderVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		orderVO = adminOrderService.adminSelectOrder(orderVO);
		mav.addObject("selectOrder", orderVO);
		mav.setViewName("admin_order_de");
		return mav;

	}
	
	@Override
	@RequestMapping(value="/adminOrderUpdate.do" ,method = RequestMethod.GET)
	public ModelAndView adminOrderUpdate(OrderVO orderVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String message = null;
		ModelAndView mav = new ModelAndView();
		adminOrderService.adminOrderUpdate(orderVO);
		List<OrderVO> order = adminOrderService.selectOrder(orderVO);
		message = "<script>";
		message += "alert('수정되었습니다')";
		message += "</script>";
		mav.addObject("admin", order);
		mav.addObject("message", message);
		mav.setViewName("admin_order");
		return mav;
	}
}
