package com.mycompany.teamproject.member.naver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.mycompany.teamproject.cart.service.CartService;
import com.mycompany.teamproject.member.kakao.KakaoController;
import com.mycompany.teamproject.member.vo.MemberVO;

@Controller
public class LoginController {
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;
	
	@Autowired
	private MemberVO memberVO;
	
	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value = "/login.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String login(Model model, HttpSession session) {
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		String kakaoUrl = KakaoController.getAuthorizationUrl(session);
		System.out.println("네이버:" + naverAuthUrl);
		model.addAttribute("url", naverAuthUrl);
		model.addAttribute("kakao_url", kakaoUrl);
		return "login";
	}
	
	@RequestMapping(value = "/callback", method = {RequestMethod.GET, RequestMethod.POST})
	public String callback(Model model, @RequestParam String code, @RequestParam String state,
			HttpSession session) throws IOException, ParseException {
		System.out.println("여기는 callback");
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);
		
			apiResult = naverLoginBO.getUserProfile(oauthToken);
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(apiResult);
			JSONObject jsonObj = (JSONObject) obj;
			
			JSONObject response_obj = (JSONObject)jsonObj.get("response");
			String nickname = (String)response_obj.get("nickname");			
			System.out.println(nickname);
			session.setAttribute("isLogOn", true);
			session.setAttribute("memberInfo", memberVO);
			
			model.addAttribute("result", apiResult);
			return "main";
	}
	
	@RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) throws IOException {
		System.out.println("여기는 logout");
		session.invalidate();
		
		return "redirect:main.jsp";
	}
	
	@RequestMapping(value="/kakaologin.do", produces = "application/json", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView kakaoLogin(@RequestParam("code") String code, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		JsonNode node = KakaoController.getAccessToken(code);
		JsonNode accessToken = node.get("access_token");
		JsonNode userInfo = KakaoController.getKakaoUserInfo(accessToken);
		System.out.println("pp" + userInfo);
		String user_id = null;
		String name = null;
			
		JsonNode properties = userInfo.path("properties");
		JsonNode kakao_account = userInfo.path("kakao_account");
		int id = userInfo.path("id").asInt();
		user_id = kakao_account.path("email").asText(); 
		name = properties.path("nickname").asText();
		
		memberVO.setUser_id(user_id); 
		memberVO.setUser_email(user_id); 
		memberVO.setNickname(name);  
		memberVO.setMember_id(id);
		
        String access_Token = accessToken.toString();
		
		session.setAttribute("access_Token", access_Token);
		session.setAttribute("isLogOn", true);  
		session.setAttribute("memberInfo", memberVO);
		mav.setViewName("main");
		
		
		// 비회원 장바구니 회원장바구니로 이동
		Cookie cookie = WebUtils.getCookie(request, "cartCookie");

		if (cookie != null) {
			String ckValue = cookie.getValue();
	
			// 쿠키에 담긴 정보를 회원 NO 입력
			memberVO.setCart_ckid(ckValue);
				cartService.cartUpdate(memberVO); 
		//쿠키 삭제
			cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		return mav;
	}
	public void kakaoLogout(String access_Token) {
        String reqURL = "https://kapi.kakao.com/v1/user/logout";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + access_Token);

            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String result = "";
            String line = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println(result);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
	}
}