package com.mycompany.teamproject.admin.order.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.order.vo.OrderVO;

public interface AdminOrderController {
	public ModelAndView adminorder(SearchCriteriaVO scri, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView adminorderde(@RequestParam("memordernum") String memordernum, OrderVO orderVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView adminOrderUpdate(OrderVO orderVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
