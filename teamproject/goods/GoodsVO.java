package com.mycompany.teamproject.goods.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("vo")
public class GoodsVO {
	private int productNum;
	private String productName;
	private int productPrice;
	private String    category;
	private String subcategory;
	private String productImage;
	private String    productStock;
	private String    company;
	private Date    productDate;
	private String    fileSize;
	private String originFileName;
	private int productStar;
	private String productAmt;
	private String productInfo;
	private String imageNum;
	
	// 상품 후기
	
	
	private int re_num;
	private int re_star;
	private Date re_regdate;
	private String re_content;
	private int memorderseqnum;
	private String user_id;
	private String re_reply;
	
	
	public String getRe_reply() {
		return re_reply;
	}
	public void setRe_reply(String re_reply) {
		this.re_reply = re_reply;
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
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductStock() {
		return productStock;
	}
	public void setProductStock(String productStock) {
		this.productStock = productStock;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Date getProductDate() {
		return productDate;
	}
	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getOriginFileName() {
		return originFileName;
	}
	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}
	public int getProductStar() {
		return productStar;
	}
	public void setProductStar(int productStar) {
		this.productStar = productStar;
	}
	public int getRe_num() {
		return re_num;
	}
	public void setRe_num(int re_num) {
		this.re_num = re_num;
	}
	public int getRe_star() {
		return re_star;
	}
	public void setRe_star(int re_star) {
		this.re_star = re_star;
	}
	public Date getRe_regdate() {
		return re_regdate;
	}
	public void setRe_regdate(Date re_regdate) {
		this.re_regdate = re_regdate;
	}
	public String getRe_content() {
		return re_content;
	}
	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	public int getMemorderseqnum() {
		return memorderseqnum;
	}
	public void setMemorderseqnum(int memorderseqnum) {
		this.memorderseqnum = memorderseqnum;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getProductAmt() {
		return productAmt;
	}
	public void setProductAmt(String productAmt) {
		this.productAmt = productAmt;
	}
	public String getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	public String getImageNum() {
		return imageNum;
	}
	public void setImageNum(String imageNum) {
		this.imageNum = imageNum;
	}
	
	

}
