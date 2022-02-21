package com.mycompany.teamproject.member.vo;

import org.springframework.stereotype.Component;

@Component("memberVO")
public class MemberVO {
	private int member_id;
	private String user_id;
	private String user_pw;
	private String user_repw;
	private String user_name;
	private String user_phone;
	private String nickname;
	private String user_email;
	private String authority;
	private String user_date;
	private String user_img;
	private String zipcode;
	private String roadAddress;
	private String jibunAddress;
	private String namujiAddress;
	private String cart_ckid;
	

	public String getZipcode() {
		return zipcode;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	} 
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getRoadAddress() {
		return roadAddress;
	}
	public void setRoadAddress(String roadAddress) {
		this.roadAddress = roadAddress;
	}
	public String getJibunAddress() {
		return jibunAddress;
	}
	public void setJibunAddress(String jibunAddress) {
		this.jibunAddress = jibunAddress;
	}
	public String getNamujiAddress() {
		return namujiAddress;
	}
	public void setNamujiAddress(String namujiAddress) {
		this.namujiAddress = namujiAddress;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id=user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw=user_pw;
	}
	public String getUser_repw() {
		return user_repw;
	}
	public void setUser_repw(String user_repw) {
		this.user_repw = user_repw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name=user_name;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone=user_phone;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname=nickname;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email=user_email;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority=authority;
	}
	public String getUser_date() {
		return user_date;
	}
	public void setUser_date(String user_date) {
		this.user_date=user_date;
	}
	public String getUser_img() {
		return user_img;
	}
	public void setUser_img(String user_img) {
		this.user_img=user_img;
	}

	public String getCart_ckid() {
		return cart_ckid;
	}
	public void setCart_ckid(String cart_ckid) {
		this.cart_ckid = cart_ckid;
	}
}
