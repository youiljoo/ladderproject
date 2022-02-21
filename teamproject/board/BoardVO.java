package com.mycompany.teamproject.board.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("boardVO")
public class BoardVO {
	//공지사항
	private int n_no;      //번호
	private String n_type; //구분
	private String n_name; //내용
	private String n_content; //상세내용
	private Date n_regdate; //작성일
	
	
	//공지사항 게터세터
	public int getN_no() {
		return n_no;
	}
	public void setN_no(int n_no) {
		this.n_no = n_no;
	}
	public String getN_type() {
		return n_type;
	}
	public void setN_type(String n_type) {
		this.n_type = n_type;
	}
	public String getN_name() {
		return n_name;
	}
	public void setN_name(String n_name) {
		this.n_name = n_name;
	}
	public String getN_content() {
		return n_content;
	}
	public void setN_content(String n_content) {
		this.n_content = n_content;
	}
	public Date getN_regdate() {
		return n_regdate;
	}
	public void setN_regdate(Date n_regdate) {
		this.n_regdate = n_regdate;
	}
	
	
	//상담문의
	private int c_no;
	private String c_type;
	private String user_id;
	private String user_phone;
	private String user_email;
	private String c_name;
	private String c_content;
	private Date c_regdate;
	private String c_state;
	private String c_reply;
	
	//Q&A
	private int q_no;
	private String q_type;
	private String q_name;
	private String q_content;
	private String q_secret;
	private Date q_regdate;
	private String q_state;
	private String q_reply;
	private String user_pw;
	
	


	//AS
	private int as_no;
	private String as_type;
	private String as_name;
	private String as_content;
	private String as_file;
	private Date as_regdate;
	private String as_state;
	

	private String as_reply;
 	
	//상담문의 게터 세터
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public String getC_type() {
		return c_type;
	}
	public void setC_type(String c_type) {
		this.c_type=c_type;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id=user_id;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone=user_phone;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email=user_email;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name=c_name;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content=c_content;
	}
	public Date getC_regdate() {
		return c_regdate;
	}
	public void setC_regdate(Date c_regdate) {
		this.c_regdate=c_regdate;
	}
	public String getC_state() {
		return c_state;
	}
	public void setC_state(String c_state) {
		this.c_state=c_state;
	}
	public String getC_reply() {
		return c_reply;
	}
	public void setC_reply(String c_reply) {
		this.c_reply = c_reply;
	}
	
	//Q&A 게터 세터
	
	public int getQ_no() {
		return q_no;
	}
	public void setQ_no(int q_no) {
		this.q_no = q_no;
	}
	public String getQ_type() {
		return q_type;
	}
	public void setQ_type(String q_type) {
		this.q_type = q_type;
	}
	public String getQ_name() {
		return q_name;
	}
	public void setQ_name(String q_name) {
		this.q_name = q_name;
	}
	public String getQ_content() {
		return q_content;
	}
	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}
	public String getQ_secret() {
		return q_secret;
	}
	public void setQ_secret(String q_secret) {
		this.q_secret = q_secret;
	}
	public Date getQ_regdate() {
		return q_regdate;
	}
	public void setQ_regdate(Date q_regdate) {
		this.q_regdate = q_regdate;
	}
	public String getQ_state() {
		return q_state;
	}
	public void setQ_state(String q_state) {
		this.q_state = q_state;
	}
	public String getQ_reply() {
		return q_reply;
	}
	public void setQ_reply(String q_reply) {
		this.q_reply = q_reply;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	
	//AS 게터 세터
	public int getAs_no() {
		return as_no;
	}
	public void setAs_no(int as_no) {
		this.as_no = as_no;
	}
	public String getAs_type() {
		return as_type;
	}
	public void setAs_type(String as_type) {
		this.as_type = as_type;
	}
	public String getAs_name() {
		return as_name;
	}
	public void setAs_name(String as_name) {
		this.as_name = as_name;
	}
	public String getAs_content() {
		return as_content;
	}
	public void setAs_content(String as_content) {
		this.as_content = as_content;
	}
	public String getAs_file() {
		return as_file;
	}
	public void setAs_file(String as_file) {
		this.as_file = as_file;
	}
	public Date getAs_regdate() {
		return as_regdate;
	}
	public void setAs_regdate(Date as_regdate) {
		this.as_regdate = as_regdate;
	}
	public String getAs_state() {
		return as_state;
	}
	public void setAs_state(String as_state) {
		this.as_state = as_state;
	}
	public String getAs_reply() {
		return as_reply;
	}
	public void setAs_reply(String as_reply) {
		this.as_reply = as_reply;
	}
	
	//페이징 처리
	
}
	


