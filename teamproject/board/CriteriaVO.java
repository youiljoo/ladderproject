package com.mycompany.teamproject.board.vo;

public class CriteriaVO {
	
	 // Ư�� ������ ��ȸ�� ���� Ŭ����
    private int page; // ���� ������ ��ȣ
    private int perPageNum; // �������� ������ �Խñ��� ����
    private String user_id;
    private String category;
    
    // ����
    private String sortType;
				

	
	
	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getPageStart() {
        // Ư�� �������� ������ ���ϴ� ����, ���� �������� �Խñ� ���� ��ȣ
        // 0 ~ 10 , 10 ~ 20 �̷�������
        return (this.page -1) * perPageNum;
    }
 
    public CriteriaVO() {
        // �⺻ ������ : ���� �Խ��ǿ� ���Խ� �ʿ��� �⺻��
        this.page = 1;
        this.perPageNum = 10;
    }
 
    // ���� ������ ��ȣ page : getter, setter
    public int getPage() {
        return page;
    }
 
    public void setPage(int page) {
        if(page <= 0) {
            this.page = 1;
            
        } else {
            this.page = page;
        }    
    }
 
    
    // �������� ������ �Խñ��� ���� perPageNum : getter, setter
    public int getPerPageNum() {
        return perPageNum;
    }
 
    public void setPerPageNum(int perPageNum) {
        int cnt = this.perPageNum;
        
        if(perPageNum != cnt) {
            this.perPageNum = cnt;    
        } else {
            this.perPageNum = perPageNum;
        }
        
    }
    
    @Override
    public String toString() {
        return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
    }



}
