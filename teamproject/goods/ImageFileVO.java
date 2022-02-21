package com.mycompany.teamproject.goods.vo;

import java.util.Date;

public class ImageFileVO {
	private int productNum;
	private int imageNum;
	private String fileName;
	private String fileType;
	private String reg_id;
	private Date creDate;
	private String category;
	

	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public Date getCreDate() {
		return creDate;
	}


	public void setCreDate(Date creDate) {
		this.creDate = creDate;
	}


	public ImageFileVO() {
		super();
	}


	public int getProductNum() {
		return productNum;
	}




	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}




	public int getImageNum() {
		return imageNum;
	}




	public void setImageNum(int imageNum) {
		this.imageNum = imageNum;
	}




	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}


	public String getReg_id() {
		return reg_id;
	}

	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}


	public void setProductNum(String productNum2) {
		// TODO Auto-generated method stub
		
	}


	

}
