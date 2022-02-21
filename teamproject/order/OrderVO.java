package com.mycompany.teamproject.order.vo;

import org.springframework.stereotype.Component;

@Component("orderVO")
public class OrderVO {
	private int memorderseqnum;
	private int memordernum;
	private String user_id;
	private int productPrice;
	private int productAmt;
	private String totalprice;
	private String memsqname; 
	private String memsqphonenum;
	private String mempayment;
	private String memsqaddr;
	private int productNum;
	private String productName;
	private String pay_order_time;
	private String originFileName;
	private String delivery_message;
	private String order_name;
	private String order_phone;
	private String order_email;
	private String order_state;
	private String category;
	private int re_num;
	private String re_content;
	
	
	public String getRe_content() {
		return re_content;
	}
	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	public int getRe_num() {
		return re_num;
	}
	public void setRe_num(int re_num) {
		this.re_num = re_num;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	public String getOrder_phone() {
		return order_phone;
	}
	public void setOrder_phone(String order_phone) {
		this.order_phone = order_phone;
	}
	public String getOrder_email() {
		return order_email;
	}
	public void setOrder_email(String order_email) {
		this.order_email = order_email;
	}
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public int getMemorderseqnum() {
		return memorderseqnum;
	}
	public void setMemorderseqnum(int memorderseqnum) {
		this.memorderseqnum = memorderseqnum;
	}
	public int getMemordernum() {
		return memordernum;
	}
	public void setMemordernum(int memordernum) {
		this.memordernum = memordernum;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductAmt() {
		return productAmt;
	}
	public void setProductAmt(int productAmt) {
		this.productAmt = productAmt;
	}
	public String getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(String string) {
		this.totalprice = string;
	}
	public String getMemsqname() {
		return memsqname;
	}
	public void setMemsqname(String memsqname) {
		this.memsqname = memsqname;
	}
	public String getMemsqphonenum() {
		return memsqphonenum;
	}
	public void setMemsqphonenum(String memsqphonenum) {
		this.memsqphonenum = memsqphonenum;
	}
	public String getMempayment() {
		return mempayment;
	}
	public void setMempayment(String mempayment) {
		this.mempayment = mempayment;
	}
	public String getMemsqaddr() {
		return memsqaddr;
	}
	public void setMemsqaddr(String memsqaddr) {
		this.memsqaddr = memsqaddr;
	}
	public int getProductNum() {
		return productNum;
	}
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPay_order_time() {
		return pay_order_time;
	}
	public void setPay_order_time(String pay_order_time) {
		this.pay_order_time = pay_order_time;
	}
	public String getOriginFileName() {
		return originFileName;
	}
	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}
	public String getDelivery_message() {
		return delivery_message;
	}
	public void setDelivery_message(String delivery_message) {
		this.delivery_message = delivery_message;
	}
	
	



}
