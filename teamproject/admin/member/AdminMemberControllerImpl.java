package com.mycompany.teamproject.admin.member.controller;

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

import com.mycompany.teamproject.admin.member.service.AdminMemberService;
import com.mycompany.teamproject.board.vo.PagingVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.member.vo.MemberVO;

@Controller("adminMemberController")
public class AdminMemberControllerImpl implements AdminMemberController {
	@Autowired
	private AdminMemberService adminMemberService;
	@Autowired
	private MemberVO memberVO;
	
	// ������ ȸ�� ����Ʈ
	@Override
	@RequestMapping(value="/admin_member.do" ,method = RequestMethod.GET)
	public ModelAndView adminmember(SearchCriteriaVO scri, HttpServletRequest request, HttpServletResponse response) throws Exception {
		int adminListCnt = adminMemberService.adminListCnt(scri);
		
		PagingVO paging = new PagingVO();
		paging.setCri(scri);
		paging.setTotalCount(adminListCnt);
		
		List<Map<String, Object>> list = adminMemberService.adminSelect(scri);
		ModelAndView mav = new ModelAndView("admin_member");
		mav.addObject("memberList", scri);
		mav.addObject("admin", list);
		mav.addObject("paging", paging);
		return mav;
	}
	
	// ������ ȸ������ ��������
	@Override
	@RequestMapping(value="/admin_member_de.do" ,method = RequestMethod.GET)
	public ModelAndView adminmemberde(@RequestParam("user_id") String user_id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		memberVO = adminMemberService.memberDetails(user_id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("Details", memberVO);
		mav.setViewName("admin_member_de");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/admindelete.do" ,method = RequestMethod.GET)
	public ModelAndView adminDelete(@RequestParam("user_id") String user_id, HttpServletRequest request, HttpServletResponse respon) throws Exception {
		String message = null;
		adminMemberService.adminDelete(user_id);
		ModelAndView mav = new ModelAndView();
		List<MemberVO> member = adminMemberService.selectMember(memberVO);
		message = "<script>";
		message += "alert('Ż�� �Ϸ�Ǿ����ϴ�.')";
		message += "</script>";
		mav.addObject("message", message);
		mav.addObject("admin", member);
		mav.setViewName("admin_member");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/adminUpdate.do" ,method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView adminUpdate(MemberVO memberVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String message = null;
		adminMemberService.adminUpdate(memberVO);
		ModelAndView mav = new ModelAndView();
		List<MemberVO> member = adminMemberService.selectMember(memberVO);
		message = "<script>";
		message += "alert('�����Ǿ����ϴ�.')";
		message += "</script>";
		mav.addObject("message_2", message);
		mav.addObject("admin", member);
		mav.setViewName("admin_member");
		return mav;
	}
}
