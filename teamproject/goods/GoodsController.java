package com.mycompany.teamproject.goods.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.teamproject.board.vo.CriteriaVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.goods.vo.GoodsVO;
 
public interface GoodsController  {
	public ModelAndView goodsDetail(@RequestParam("productNum") String productNum,SearchCriteriaVO scri,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView viewReview(@RequestParam("productNum")String productNum,@RequestParam("re_num") int re_num,HttpServletRequest request,HttpServletResponse response)throws Exception;
	
	// 상품 검색
	public ModelAndView searchlist(@RequestParam("searchWord") String searchWord, CriteriaVO cri, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
