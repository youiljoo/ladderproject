package com.mycompany.teamproject.main;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.teamproject.goods.service.GoodsService;
import com.mycompany.teamproject.goods.vo.GoodsVO;


@Controller("mainController")
public class MainController {
	
	@Autowired
	private GoodsService goodsService;

	@RequestMapping(value= "/main.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView();
		String viewName=(String)request.getAttribute("viewName");
		Map<String,List<GoodsVO>> goodsMap=goodsService.listGoods();
		mav.addObject("goodsMap", goodsMap);
		mav.setViewName(viewName);
		return mav;
	}
}