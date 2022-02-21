package com.mycompany.teamproject.mypage.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

public class ReviewImageVO {
	private int imageFileNO;
	private String imageFileName;
	private Date regDate;
	private int re_num;
	
	public int getImageFileNO() {
		return imageFileNO;
	}
	
	public void setImageFileNO(int imageFileNO) {
		this.imageFileNO = imageFileNO;
	}
	
	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName=imageFileName;
	}
	
	public Date getRegDate() {
		return regDate;
	}
	
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getRe_num() {
		return re_num;
	}

	public void setRe_num(int re_num) {
		this.re_num = re_num;
	}
}
