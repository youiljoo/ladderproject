package com.mycompany.teamproject.member.controller;


import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.mycompany.teamproject.cart.service.CartService;
import com.mycompany.teamproject.member.naver.LoginController;
import com.mycompany.teamproject.member.service.MemberService;
import com.mycompany.teamproject.member.vo.MemberVO;
import com.mycompany.teamproject.order.vo.OrderVO;




@Controller("memberController")
public class MemberControllerImpl implements MemberController{
	private final Logger logger = LoggerFactory.getLogger(MemberController.class.getName());
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO;
	@Autowired
	private OrderVO orderVO;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private CartService cartService;
	@Autowired
	private LoginController loginController;
	
	// 로그인
	@Override
	@RequestMapping(value="/login2.do" ,method = RequestMethod.GET)
	public ModelAndView login(@RequestParam Map<String, String> loginMap,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		 memberVO=memberService.login(loginMap);
		if(memberVO!= null && memberVO.getUser_id()!=null){
			HttpSession session=request.getSession();
			session=request.getSession();
			session.setAttribute("isLogOn", true);
			session.setAttribute("memberInfo",memberVO);
			
			// 비회원 장바구니 회원장바구니로 이동
						Cookie cookie = WebUtils.getCookie(request, "cartCookie");

						if (cookie != null) {
							String ckValue = cookie.getValue();
							logger.info("비회원장바구니 삭제");
			//쿠키에 담긴 정보에 회원NO 입력
							memberVO.setCart_ckid(ckValue);
	 						cartService.cartUpdate(memberVO); 
			//쿠키삭제
							cookie.setPath("/");
							cookie.setMaxAge(0);
							response.addCookie(cookie);
						}
			String action=(String)session.getAttribute("action");
			if(action!=null && action.equals("/order/orderEachGoods.do")){
				mav.setViewName("forward:"+action);
			}else{
				mav.setViewName("redirect:/main.do");	
			}
			
			
			
		}else{
			String message="아이디나  비밀번호가 틀립니다. 다시 로그인해주세요";
			mav.addObject("message", message);
			mav.setViewName("loginform");
		}
		return mav;
	}
	
	// 로그아웃
	@Override
	@RequestMapping(value="/logout.do" ,method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession();
		session.setAttribute("isLogOn", false);
		session.removeAttribute("memberInfo");
			//카카오 로그아웃 
		        String access_Token = (String)session.getAttribute("access_Token");

		        if(access_Token != null && !"".equals(access_Token)){
		            loginController.kakaoLogout(access_Token);
		            session.removeAttribute("access_Token"); 
		            session.removeAttribute("userId");
		        }else{ 
		        	session.invalidate();
		            System.out.println("access_Token is null"); 
		        }

		mav.setViewName("redirect:/main.do");
		return mav;
	}
	
	// 회원가입
	@RequestMapping(value="/register.do" ,method = RequestMethod.GET)
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/addmember.do" ,method = RequestMethod.GET)
	public ResponseEntity addMember(@ModelAttribute("memberVO") MemberVO memberVO,
			                HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		System.out.println(request.getParameter("user_name"));
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
		    memberService.addMember(memberVO);
		    message  = "<script>";
		    message +=" alert('회원 가입을 마쳤습니다.로그인창으로 이동합니다.');";
		    message += " location.href='"+request.getContextPath()+"/login.do';";
		    message += " </script>";
		    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('작업 중 오류가 발생했습니다.');";
		    message += " location.href='"+request.getContextPath()+"/register.do';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}
	
	// 아이디 중복확인
	@Override
	@RequestMapping(value="/overlapped.do" ,method = RequestMethod.POST)
	public ResponseEntity overlapped(@RequestParam("id") String id,HttpServletRequest request, HttpServletResponse response) throws Exception{
		ResponseEntity resEntity = null;
		String result = memberService.overlapped(id);
		resEntity =new ResponseEntity(result, HttpStatus.OK);
		return resEntity;
	}
	
	// 닉네임 중복확인
	@Override
	@RequestMapping(value="/overlappednickname.do" ,method = RequestMethod.POST)
	public ResponseEntity overlappedNickname(@RequestParam("nickname") String nickname,HttpServletRequest request, HttpServletResponse response) throws Exception{
		ResponseEntity resEntity = null;
		String result = memberService.overlappednickname(nickname);
		resEntity =new ResponseEntity(result, HttpStatus.OK);
		return resEntity;
	}
	
	// 이메일 중복확인
	@Override
	@RequestMapping(value="/overlappedemail.do" ,method = RequestMethod.POST)
	public ResponseEntity overlappedEmail(@RequestParam("email") String email,HttpServletRequest request, HttpServletResponse response) throws Exception{
		ResponseEntity resEntity = null;
		String result = memberService.overlappedemail(email);
		resEntity =new ResponseEntity(result, HttpStatus.OK);
		return resEntity;
	}
	
	// 아이디 찾기
	@RequestMapping(value="/id.do" ,method = RequestMethod.GET)
	public ModelAndView id(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	// 아이디 찾기(이름, 휴대폰 번호)
	@Override
	@RequestMapping(value="/selectId_1.do" ,method = RequestMethod.POST)
	public ModelAndView selectIdPhone(MemberVO memberVO, HttpServletResponse response, HttpServletRequest request) throws Exception {
		MemberVO member = memberService.selectIdPhone(memberVO);
		ModelAndView mav = new ModelAndView();
		String message = null;
		if(member == null) {
			message = "<script>";
			message += "alert('잘못된 정보입니다');";
			message += "</script>";
			mav.addObject("message", message);
			mav.setViewName("id");
		} else {
			mav.addObject("id", member.getUser_id());
			mav.setViewName("findid");
		}
		return mav;
	}
	
	// 아이디 찾기(이름, 이메일)
	@Override
	@RequestMapping(value="/selectId_2.do" ,method = RequestMethod.POST)
	public ModelAndView selectIdEmail(MemberVO memberVO, HttpServletResponse response, HttpServletRequest request) throws Exception {
		MemberVO member = memberService.selectIdEmail(memberVO);
		ModelAndView mav = new ModelAndView();
		String message = null;
		if(member == null) {
			message = "<script>";
			message += "alert('잘못된 정보입니다');";
			message += "</script>";
			mav.addObject("message", message);
			mav.setViewName("id");
		} else {
			mav.addObject("id", member.getUser_id());
			mav.setViewName("findid");
		}
		return mav;
	}
	
	// 비밀번호 찾기
	@RequestMapping(value="/password.do" ,method = RequestMethod.GET)
	public ModelAndView password(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="/changepassword.do" ,method = RequestMethod.GET)
	public ModelAndView changepassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="/newpassword.do" ,method = RequestMethod.GET)
	public ModelAndView newpassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	// 비밀번호 찾기(아이디, 휴대폰 번호)
	@Override
	@RequestMapping(value="/selectPw_1.do" ,method = RequestMethod.POST)
	public ModelAndView selectPwPhone(MemberVO memberVO, HttpServletResponse response, HttpServletRequest request) throws Exception {
		MemberVO member = memberService.selectPwPhone(memberVO);
		ModelAndView mav = new ModelAndView();
		String message = null;
		if(member == null) {
			message = "<script>";
			message += "alert('잘못된 정보입니다');";
			message += "</script>";
			mav.addObject("message", message);
			mav.setViewName("password");
		} else {
			mav.addObject("id", member.getUser_id());
			mav.setViewName("newpassword");
		}
		return mav;
	}
	
	// 비밀번호 찾기(아이디, 이메일)
	@Override
	@RequestMapping(value="/selectPw_2.do" ,method = RequestMethod.POST)
	public ModelAndView selectPwEmail(MemberVO memberVO, HttpServletResponse response, HttpServletRequest request) throws Exception {
		MemberVO member = memberService.selectPwEmail(memberVO);
		ModelAndView mav = new ModelAndView();
		String message = null;
		if(member == null) {
			message = "<script>";
			message += "alert('잘못된 정보입니다');";
			message += "</script>";
			mav.addObject("message", message);
			mav.setViewName("password");
		} else {
			mav.addObject("id", member.getUser_id());
			mav.setViewName("newpassword");
		}
		return mav;
	}
	
	// 비밀번호 찾기 -> 변경
	
	@RequestMapping(value="/change.do" ,method = RequestMethod.GET)
	public void getUpdatePw() throws Exception {
		logger.info("get updatePw");
	}
	
	@RequestMapping(value="/change.do", method = RequestMethod.POST)
	public String postUpdatePw(HttpSession session, MemberVO memeberVO) throws Exception {
		logger.info("post updatePw");
		memberService.updatePw(memeberVO);
		session.invalidate();
		return "changepassword";
	}
	
	// 휴대폰 인증
	@Override
	@RequestMapping(value="/phoneCheck", method = RequestMethod.GET)
	@ResponseBody
	public String sendSMS(@RequestParam("user_phone") String user_phone) {
		int randomNumber = (int)((Math.random() * (9999 - 1000 * 1)) + 1000);
		memberService.certifiedPhoneNumber(user_phone, randomNumber);
		return Integer.toString(randomNumber);
	}
	
	// 이메일 인증
	@Override
	@RequestMapping(value = "/emailCheck", method = RequestMethod.GET)
	@ResponseBody
	public String emailCheck(@RequestParam("user_email") String user_email) throws Exception{
	    int serti = (int)((Math.random()* (99999 - 10000 + 1)) + 10000);
	    
	    String from = "pjc2348@naver.com";//보내는 이 메일주소
	    String to = user_email;
	    String title = "비밀번호 찾기시 필요한 인증번호 입니다.";
	    String content = "[인증번호] "+ serti +" 입니다. <br/> 인증번호 확인란에 기입해주십시오.";
	    String num = "";
	    try {
	    	MimeMessage mail = mailSender.createMimeMessage();
	        MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");
	        
	        mailHelper.setFrom(from);
	        mailHelper.setTo(to);
	        mailHelper.setSubject(title);
	        mailHelper.setText(content, true);       
	        
	        mailSender.send(mail);
	        num = Integer.toString(serti);
	        
	    } catch(Exception e) {
	        num = "error";
	    }
	    return num;
	}
	
	// 회원탈퇴
	@RequestMapping(value="/deleteid.do", method = RequestMethod.GET)
	public void deleteIdGet() throws Exception {
		logger.info("deleteGet");
	}
	
	@RequestMapping(value="/deleteid.do", method = RequestMethod.POST)
	public String deleteIdPost(MemberVO memberVO, HttpSession session, RedirectAttributes re) throws Exception {
		logger.info("deletePost");
		
		MemberVO member = (MemberVO)session.getAttribute("memberInfo");
		
		String user_pw = member.getUser_pw();
		String vo_pw = memberVO.getUser_pw();
		
		if(vo_pw.equals(user_pw)) {
			memberService.deleteId(memberVO);
			re.addFlashAttribute("result", "removeTrue");
			session.invalidate();
			return "redirect:main.do";
		} else {
			re.addFlashAttribute("result", "removeFalse");
			return "redirect:removeid.do";
		}
	}
	
	// 회원정보 수정
	@RequestMapping(value="/memberedit_pw.do" ,method = RequestMethod.GET)
	public void memberedit_pwGet() throws Exception {
		logger.info("membereditGet");
	}
	
	@RequestMapping(value="/memberedit_pw.do", method = RequestMethod.POST)
	public String memberedit_pwPost(MemberVO memberVO, HttpSession session, RedirectAttributes re, Model md) throws Exception {
		logger.info("Check_pw");
		
		MemberVO member = (MemberVO)session.getAttribute("memberInfo");
		
		String user_pw = member.getUser_pw();
		String vo_pw = memberVO.getUser_pw();
		
		if(vo_pw.equals(user_pw)) {
			memberService.memberedit_pw(memberVO);
			md.addAttribute("user_id", member.getUser_id());
			return "memberedit";
		} else {
			re.addFlashAttribute("result", "False");
			return "redirect:edit_pw.do";
		}
	}

		// 회원정보 수정 -> 완료	
		@Override
		@RequestMapping(value="/memberedit.do", method = RequestMethod.POST)
		public String membereditPost(MemberVO memberVO, HttpSession session,  RedirectAttributes re) throws Exception {
			memberService.memberedit(memberVO);
			session.invalidate();
			logger.info("info");
			re.addFlashAttribute("True", "True");
			System.out.println("회원 수정 컨트롤러 완료");
			return "redirect:main.do";
		}
	
		// 비회원 주문조회
		@Override
		@RequestMapping(value="/nonmember.do" ,method = RequestMethod.GET)
		public ModelAndView nonmember(OrderVO orderVO, HttpServletResponse response, HttpServletRequest request) throws Exception {
			String message = null;
			String num = orderVO.getOrder_phone();
			String name = orderVO.getOrder_name();
			List<OrderVO> list = memberService.nonMember(orderVO);
			ModelAndView mav = new ModelAndView();
			if(name == "" || num == "") {
				message = "<script>";
				message += "alert('아이디와 휴대폰 번호를 입력해주세요');";
				message += "</script>";
				mav.addObject("message", message);
				mav.setViewName("login");
			} else if(list.isEmpty()) {
				message = "<script>";
				message += "alert('아이디 또는 휴대폰 번호가 틀립니다');";
				message += "</script>";
				mav.addObject("message", message);
				mav.setViewName("login");
			} else {
				mav.addObject("list", list);
				mav.setViewName("nonmember");
			}
			return mav;
		}
}
	

