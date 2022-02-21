package com.mycompany.teamproject.admin.board.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("adboardVO")
public class AdminBoardVO {
	private int a_main_NO;
	private String a_main_title;
	private String a_main_content;
	private Date a_main_writeDate;
	private String user_id;
	
	
	
	
	public int getA_main_NO() {
		return a_main_NO;
	}
	public void setA_main_NO(int a_main_NO) {
		this.a_main_NO = a_main_NO;
	}
	public String getA_main_title() {
		return a_main_title;
	}
	public void setA_main_title(String a_main_title) {
		this.a_main_title = a_main_title;
	}
	public String getA_main_content() {
		return a_main_content;
	}
	public void setA_main_content(String a_main_content) {
		this.a_main_content = a_main_content;
	}
	public Date getA_main_writeDate() {
		return a_main_writeDate;
	}
	public void setA_main_writeDate(Date a_main_writeDate) {
		this.a_main_writeDate = a_main_writeDate;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
}
