package com.mycompany.teamproject.admin.order.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.teamproject.admin.order.dao.AdminOrderDAO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.order.vo.OrderVO;


@Service("adminOrderService")
public class AdminOrderServiceImpl implements AdminOrderService {
	@Autowired
	private AdminOrderDAO adminOrderDAO;

	
	@Override
	public List<Map<String, Object>> adminOrder(SearchCriteriaVO scri) throws Exception {
		List<Map<String, Object>> adminOrder = adminOrderDAO.adminOrder(scri);
		return adminOrder;
	}
	
	@Override
	public int orderListCnt(SearchCriteriaVO scri) throws Exception {
		return adminOrderDAO.orderListCnt(scri);
	}
	
	@Override
	public List<OrderVO> selectOrder(OrderVO orderVO) throws Exception {
		return adminOrderDAO.selectOrder(orderVO);
	}
	
	@Override
	public OrderVO adminSelectOrder(OrderVO orderVO) throws Exception {
		return adminOrderDAO.adminSelectOrder(orderVO);
	}
	
	@Override
	public void adminOrderUpdate(OrderVO orderVO) throws Exception {
		adminOrderDAO.adminOrderUpdate(orderVO);
	}
}
