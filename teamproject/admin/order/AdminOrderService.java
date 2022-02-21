package com.mycompany.teamproject.admin.order.service;

import java.util.List;
import java.util.Map;

import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.order.vo.OrderVO;

public interface AdminOrderService {
	public List<Map<String, Object>> adminOrder(SearchCriteriaVO scri) throws Exception;
	public int orderListCnt(SearchCriteriaVO scri) throws Exception;
	public List<OrderVO> selectOrder(OrderVO orderVO) throws Exception;
	public OrderVO adminSelectOrder(OrderVO orderVO) throws Exception;
	public void adminOrderUpdate(OrderVO orderVO) throws Exception;
}
