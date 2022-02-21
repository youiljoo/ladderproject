package com.mycompany.teamproject.board.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;

public class ImageVO {
	private int imageFileNO;
	private String imageFileName;
	private Date regDate;
	private int as_no;
	
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
		try {
			if(imageFileName!= null && imageFileName.length()!=0) {
				this.imageFileName = URLEncoder.encode(imageFileName,"UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public Date getRegDate() {
		return regDate;
	}
	
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getAs_NO() {
		return as_no;
	}

	public void setAs_no(int as_no) {
		this.as_no = as_no;
	}
}
