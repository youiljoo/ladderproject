package com.mycompany.teamproject.goods.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.teamproject.board.vo.CriteriaVO;
import com.mycompany.teamproject.board.vo.PagingVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.goods.service.GoodsService;
import com.mycompany.teamproject.goods.vo.GoodsVO;



@Controller("goodsController")
public class GoodsControllerImpl  implements GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	// 상품
	
	@RequestMapping(value="/monitor.do",method=RequestMethod.GET)
	public ModelAndView Monitor(CriteriaVO cri,HttpServletRequest request, HttpServletResponse response) throws Exception {
		int productListCnt = goodsService.productListCnt(cri);
		
		PagingVO paging = new PagingVO();
		paging.setCri(cri);
		paging.setTotalCount(productListCnt);
		
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		List<GoodsVO> monitor = goodsService.productList("Monitor");
		mav.addObject("productList", monitor);
		mav.addObject("paging", paging);
		return mav;
		
	}
	
	@RequestMapping(value="/mouse.do",method=RequestMethod.GET)
	public ModelAndView Mouse(GoodsVO goodsVO, CriteriaVO cri, HttpServletRequest request, HttpServletResponse response) throws Exception {
		int productListCnt = goodsService.productListCnt(cri);
		
		PagingVO paging = new PagingVO();
		paging.setCri(cri);
		paging.setTotalCount(productListCnt);
		
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		List<GoodsVO> mouse = goodsService.productList("Mouse");
		mav.addObject("productList", mouse);
		mav.addObject("paging", paging);
		return mav;
	}
	
	@RequestMapping(value="/keyboard.do",method=RequestMethod.GET)
	public ModelAndView Keyboard(CriteriaVO cri,HttpServletRequest request, HttpServletResponse response) throws Exception {
		int productListCnt = goodsService.productListCnt(cri);
		
		PagingVO paging = new PagingVO();
		paging.setCri(cri);
		paging.setTotalCount(productListCnt);
		
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		List<GoodsVO> keyboard = goodsService.productList("Keyboard");
		mav.addObject("productList", keyboard);
		mav.addObject("paging", paging);
		return mav;
	}
	
	@RequestMapping(value="/speaker.do",method=RequestMethod.GET)
	public ModelAndView Speaker(CriteriaVO cri, HttpServletRequest request, HttpServletResponse response) throws Exception {
		int productListCnt = goodsService.productListCnt(cri);
		
		PagingVO paging = new PagingVO();
		paging.setCri(cri);
		paging.setTotalCount(productListCnt);
		
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		List<GoodsVO> speaker = goodsService.productList("Speaker");
		mav.addObject("productList", speaker);
		mav.addObject("paging", paging);
		return mav;
	}
	
	@RequestMapping(value="/headset.do",method=RequestMethod.GET)
	public ModelAndView Headset(CriteriaVO cri, HttpServletRequest request, HttpServletResponse response) throws Exception {
		int productListCnt = goodsService.productListCnt(cri);
		
		PagingVO paging = new PagingVO();
		paging.setCri(cri);
		paging.setTotalCount(productListCnt);
		
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		List<GoodsVO> headset = goodsService.productList("Headset");
		mav.addObject("productList", headset);
		mav.addObject("paging", paging);
		return mav;
	}
	
	// 정렬
	
	@RequestMapping(value="/monitor/sort.do",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView MonitorSort(CriteriaVO cri,HttpServletRequest request, HttpServletResponse response) throws Exception {
		int productListCnt = goodsService.productListCnt(cri);
		
		PagingVO paging = new PagingVO();
		paging.setCri(cri);
		paging.setTotalCount(productListCnt);
		
		
	
		String sortType=request.getParameter("sortType");
		
		cri.setCategory("Monitor");
		
		System.out.println(sortType);
		
		
		ModelAndView mav = new ModelAndView();
		
		List<GoodsVO> monitor = goodsService.productsortList(cri);	
		mav.addObject("productList", monitor);
		mav.addObject("paging", paging);
		mav.setViewName("monitor");
		return mav;
	}
	
	@RequestMapping(value="/mouse/sort.do",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView MouseSort(CriteriaVO cri,HttpServletRequest request, HttpServletResponse response) throws Exception {
		int productListCnt = goodsService.productListCnt(cri);
		
		PagingVO paging = new PagingVO();
		paging.setCri(cri);
		paging.setTotalCount(productListCnt);
		
		
	
		String sortType=request.getParameter("sortType");
		
		cri.setCategory("Mouse");
		
		System.out.println(sortType);
		
		
		ModelAndView mav = new ModelAndView();
		
		List<GoodsVO> mouse = goodsService.productsortList(cri);	
		mav.addObject("productList", mouse);
		mav.addObject("paging", paging);
		mav.setViewName("mouse");
		return mav;
	}
	
	@RequestMapping(value="/keyboard/sort.do",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView KeyboardSort(CriteriaVO cri,HttpServletRequest request, HttpServletResponse response) throws Exception {
		int productListCnt = goodsService.productListCnt(cri);
		
		PagingVO paging = new PagingVO();
		paging.setCri(cri);
		paging.setTotalCount(productListCnt);
		
		
	
		String sortType=request.getParameter("sortType");
		
		cri.setCategory("Keyboard");
		
		System.out.println(sortType);
		
		
		ModelAndView mav = new ModelAndView();
		
		List<GoodsVO> keyboard = goodsService.productsortList(cri);	
		mav.addObject("productList", keyboard);
		mav.addObject("paging", paging);
		mav.setViewName("keyboard");
		return mav;
	}
	
	@RequestMapping(value="/speaker/sort.do",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView SpeakerSort(CriteriaVO cri,HttpServletRequest request, HttpServletResponse response) throws Exception {
		int productListCnt = goodsService.productListCnt(cri);
		
		PagingVO paging = new PagingVO();
		paging.setCri(cri);
		paging.setTotalCount(productListCnt);
		
		
	
		String sortType=request.getParameter("sortType");
		
		cri.setCategory("Speaker");
		
		System.out.println(sortType);
		
		
		ModelAndView mav = new ModelAndView();
		
		List<GoodsVO> speaker = goodsService.productsortList(cri);	
		mav.addObject("productList", speaker);
		mav.addObject("paging", paging);
		mav.setViewName("speaker");
		return mav;
	}
	
	@RequestMapping(value="/headset/sort.do",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView HeadsetSort(CriteriaVO cri,HttpServletRequest request, HttpServletResponse response) throws Exception {
		int productListCnt = goodsService.productListCnt(cri);
		
		PagingVO paging = new PagingVO();
		paging.setCri(cri);
		paging.setTotalCount(productListCnt);
		
		
	
		String sortType=request.getParameter("sortType");
		
		cri.setCategory("Headset");
		
		System.out.println(sortType);
		
		
		ModelAndView mav = new ModelAndView();
		
		List<GoodsVO> headset = goodsService.productsortList(cri);	
		mav.addObject("productList", headset);
		mav.addObject("paging", paging);
		mav.setViewName("headset");
		return mav;
	}
	
	
	@RequestMapping(value="/prodetail.do" ,method = RequestMethod.GET)
	public ModelAndView goodsDetail(@RequestParam("productNum") String productNum,SearchCriteriaVO scri,
			                       HttpServletRequest request, HttpServletResponse response) throws Exception {
		//String viewName=(String)request.getAttribute("viewName");
		HttpSession session=request.getSession();
		Map goodsMap=goodsService.goodsDetail(productNum);
		ModelAndView mav=new ModelAndView("prodetail");
		mav.addObject("goodsMap", goodsMap);
		
		
		// 상품 상세페이지 내 후기(리스트만), 후기 작성은 마이페이지에서
		
	        int reviewListCnt = goodsService.reviewListCnt(scri);
	         
	      
	        PagingVO paging = new PagingVO();
	        paging.setCri(scri);
	        paging.setTotalCount(reviewListCnt);    
	        	        
	        
	        //String viewName=(String)request.getAttribute("viewName");
	        List<Map<String, Object>> list = goodsService.reviewList(scri);
	       
	      
	        mav.addObject("list", list);   
	        mav.addObject("paging", paging);
		
		
		return mav;
	}
	
	//  후기 상세페이지(이미지 표시 기능 추가)
	
	@Override
	@RequestMapping(value="/prodetail_review_detail.do",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView viewReview(@RequestParam("productNum")String productNum,@RequestParam("re_num") int re_num,HttpServletRequest request,HttpServletResponse response)throws Exception{
	
		Map reMap=goodsService.viewReview(re_num);
		Map goodsMap=goodsService.goodsDetail(productNum);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("prodetail_review_detail");
		mav.addObject("reMap", reMap);
		mav.addObject("goodsMap", goodsMap);
		return mav;
	}
	
	//상품검색
	@Override
	@RequestMapping(value="/searchlist.do" ,method = RequestMethod.GET)
	public ModelAndView searchlist(@RequestParam("searchWord") String searchWord, CriteriaVO cri, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		List<GoodsVO> goodsList = goodsService.searchGoods(searchWord);
		ModelAndView mav = new ModelAndView();
		mav.addObject("productList", goodsList);
		mav.setViewName(viewName);
		return mav;

	}
	
}
