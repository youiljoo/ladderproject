package com.mycompany.teamproject.board.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PagingVO {

	private int totalCount; // �Խ��� ��ü ������ ����
    private int displayPageNum = 10; // �Խ��� ȭ�鿡�� �ѹ��� ������ ������ ��ȣ�� ����
    
    private int startPage; // ȭ���� ���� ��ȣ
    private int endPage;  // ȭ���� �� ��ȣ
    private boolean prev; // ����¡ ���� ��ư Ȱ��ȭ ����
    private boolean next; // ����¡ ���� ��ư Ȱ��ȭ ����
    
    private CriteriaVO cri;
 
    
    public int getTotalCount() {
        return totalCount;
    }
 
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        
        pagingData();
    }
    
    private void pagingData() {
        
        endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
        // endPage = (���� ������ ��ȣ / ȭ�鿡 ������ ������ ��ȣ�� ����) * ȭ�鿡 ������ ������ ��ȣ�� ����
        startPage = (endPage - displayPageNum) + 1;
        // startPage = (�� ������ ��ȣ - ȭ�鿡 ������ ������ ��ȣ�� ����) + 1
        
        int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));    
        if(endPage > tempEndPage) {
            endPage = tempEndPage;
        }
        // ������ ������ ��ȣ = �� �Խñ� �� / �� �������� ������ �Խñ��ǰ���
        
        prev = startPage == 1 ? false : true;    
        // ���� ��ư ���� ���� = ���� ������ ��ȣ�� 1�� ������ false, �ƴϸ� true
        next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
        // ���� ��ư ���� ���� = �� ������ ��ȣ * �� �������� ������ �Խñ��� ������ �� �Խñ��� ������
        // ũ�ų� ������ false, �ƴϸ� true
    }
 
    public int getDisplayPageNum() {
        return displayPageNum;
    }
 
    public void setDisplayPageNum(int displayPageNum) {
        this.displayPageNum = displayPageNum;
    }
 
    public int getStartPage() {
        return startPage;
    }
 
    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }
 
    public int getEndPage() {
        return endPage;
    }
 
    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }
 
    public boolean isPrev() {
        return prev;
    }
 
    public void setPrev(boolean prev) {
        this.prev = prev;
    }
 
    public boolean isNext() {
        return next;
    }
 
    public void setNext(boolean next) {
        this.next = next;
    }
 
    public CriteriaVO getCri() {
        return cri;
    }
 
    public void setCri(CriteriaVO cri) {
        this.cri = cri;
    }
    
    
    @Override
    public String toString() {
        return "Paging [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
                + prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
    } 
    
    
    //�˻�
    
    public String makeSearch(int page)
	{
	  
	 UriComponents uriComponents =
	            UriComponentsBuilder.newInstance()
	            .queryParam("page", page)
	            .queryParam("perPageNum", cri.getPerPageNum())
	            .queryParam("searchType", ((SearchCriteriaVO)cri).getSearchType())
	            .queryParam("keyword", encoding(((SearchCriteriaVO)cri).getKeyword()))
	            .build(); 
	    return uriComponents.toUriString();  
	}

	private String encoding(String keyword) {
		if(keyword == null || keyword.trim().length() == 0) { 
			return "";
		}
		 
		try {
			return URLEncoder.encode(keyword, "UTF-8");
		} catch(UnsupportedEncodingException e) { 
			return ""; 
		}
	}
	public String makeQuery(int page) {
		UriComponents uriComponents =
		UriComponentsBuilder.newInstance()
						    .queryParam("page", page)
							.queryParam("perPageNum", cri.getPerPageNum())
							.build();
		   
		return uriComponents.toUriString();
	}
}
