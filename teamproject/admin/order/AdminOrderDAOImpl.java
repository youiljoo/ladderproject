package com.mycompany.teamproject.admin.order.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.order.vo.OrderVO;

@Repository("adminOrderDAO")
public class AdminOrderDAOImpl implements AdminOrderDAO {
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private OrderVO orderVO;
	
	@Override
	public List<Map<String, Object>> adminOrder(SearchCriteriaVO scri) throws Exception {
		 return sqlSession.selectList("mapper.admin_order.adminOrder", scri);
	}
	
	@Override
	public int orderListCnt(SearchCriteriaVO scri) throws Exception {
		return sqlSession.selectOne("mapper.admin_order.orderListCnt", scri);
	}
	
	@Override
	public List<OrderVO> selectOrder(OrderVO orderVO) throws Exception {
		List<OrderVO> selectOrder = (List)sqlSession.selectList("mapper.admin_order.selectOrder", orderVO);
		return selectOrder;
	}
	
	@Override
	public OrderVO adminSelectOrder(OrderVO orderVO) throws Exception {
		return sqlSession.selectOne("mapper.admin_order.adminSelectOrder", orderVO);
	}
	
	@Override
	public void adminOrderUpdate(OrderVO orderVO) throws Exception {
		sqlSession.update("mapper.admin_order.adminOrderUpdate", orderVO);
	}
	
}
