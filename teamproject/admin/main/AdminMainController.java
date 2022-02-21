package com.mycompany.teamproject.admin.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller("adminMainController")
public class AdminMainController {
	
	// ���⿡ �ش��ϴ� �͵� ������ ���� ���� �κп� �����ؼ� ���� ���� ��.
	
	
	
	// �̴� � ����
	@RequestMapping(value="/admin_main_month.do" ,method = RequestMethod.GET)
	public ModelAndView adminmainM(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;

	}
	// ���� � ����
	@RequestMapping(value="/admin_main_year.do" ,method = RequestMethod.GET)
	public ModelAndView adminmainY(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;

	}
	
	
		
	
	
	@RequestMapping(value="/admin_prod_co.do" ,method = RequestMethod.GET)
	public ModelAndView adminprodco(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;

	}
	
	
}
