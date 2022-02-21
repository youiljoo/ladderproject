package com.mycompany.teamproject.board.vo;

public class SearchCriteriaVO extends CriteriaVO{

	private String searchType = "";
	private String keyword = "";
	
	
	// ��ǰ ��ȣ�� �´� �ı� ����Ʈ�� �ҷ����� ���� �ڵ�
	private int productNum;
	private String user_id;
	
	
	 
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getProductNum() {
		return productNum;
	}
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
	
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "SearchCriteria [searchType=" + searchType + ", keyword=" + keyword + "]";
	}
}