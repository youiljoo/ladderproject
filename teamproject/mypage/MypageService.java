package com.mycompany.teamproject.mypage.service;

import java.util.List;
import java.util.Map;

import com.mycompany.teamproject.board.vo.CriteriaVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.order.vo.OrderVO;

public interface MypageService {
	// ���������� ����
	public List<Map<String, Object>> listMyOrderGoods(CriteriaVO cri) throws Exception;
	public int myMain(CriteriaVO cri) throws Exception;
	
	public List<Map<String, Object>> orderList(SearchCriteriaVO scri) throws Exception;
	public int orderListCnt(SearchCriteriaVO scri) throws Exception;
	
	// A/S ��ȯ,��ǰ ����
	public List<Map<String, Object>> mypageSelect(SearchCriteriaVO scri) throws Exception;
	public int mypageList(SearchCriteriaVO scri) throws Exception;
	
	public int pro_review(Map asMap)throws Exception; // ��ǰ �ı�
	
	
	public List<Map<String,Object>>reviewList(CriteriaVO cri) throws Exception; // ���� �� ���� ��� (����¡ �߰�)
	public int reviewListCnt(CriteriaVO cri) throws Exception;
	public Map reviewDetail(int re_num) throws Exception; // ���� �󼼺���

	
	public void deleteReview(int re_num)throws Exception; // �ı� ����
	
	public List<Map<String,Object>>conList(CriteriaVO  cri) throws Exception; // ��㳻�� ��� (����¡,�˻� �߰�)
	public int conListCnt(CriteriaVO cri) throws Exception;
	
	// �ı� ����
	public OrderVO review_edit(int re_num) throws Exception;
	public void pro_review_edit(Map map) throws Exception;
}

