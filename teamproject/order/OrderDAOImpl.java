package com.mycompany.teamproject.order.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.teamproject.order.vo.OrderVO;

@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<OrderVO> listMyOrderGoods(OrderVO orderVO) throws DataAccessException{
		List<OrderVO> orderGoodsList=new ArrayList<OrderVO>();
		orderGoodsList=(ArrayList)sqlSession.selectList("mapper.order.selectMyOrderList",orderVO);
		return orderGoodsList;
	}
	
	public void insertNewOrder(List<OrderVO> myOrderList) throws DataAccessException{
		int memordernum=selectOrderID();
		for(int i=0; i<myOrderList.size();i++){
			OrderVO orderVO =(OrderVO)myOrderList.get(i);
			orderVO.setMemordernum(memordernum);
			sqlSession.insert("mapper.order.insertNewOrder",orderVO);
			System.out.println(orderVO);
		}
		
	}	
	
	public OrderVO findMyOrder(String memordernum) throws DataAccessException{
		OrderVO orderVO=(OrderVO)sqlSession.selectOne("mapper.order.selectMyOrder",memordernum);		
		return orderVO;
	}
	
	public void removeGoodsFromCart(OrderVO orderVO)throws DataAccessException{
		sqlSession.delete("mapper.order.deleteGoodsFromCart",orderVO);
	}
	
	public void removeGoodsFromCart(List<OrderVO> myOrderList)throws DataAccessException{
		for(int i=0; i<myOrderList.size();i++){
			OrderVO orderVO =(OrderVO)myOrderList.get(i);
			sqlSession.delete("mapper.order.deleteGoodsFromCart",orderVO);		
		}
	}	
	private int selectOrderID() throws DataAccessException{
		return sqlSession.selectOne("mapper.order.selectOrderID");
		
	}
}

