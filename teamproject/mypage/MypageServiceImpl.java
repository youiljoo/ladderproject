package com.mycompany.teamproject.mypage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.teamproject.board.vo.CriteriaVO;
import com.mycompany.teamproject.board.vo.ImageVO;
import com.mycompany.teamproject.board.vo.SearchCriteriaVO;
import com.mycompany.teamproject.goods.vo.GoodsVO;
import com.mycompany.teamproject.mypage.dao.MypageDAO;
import com.mycompany.teamproject.order.vo.OrderVO;

@Service("mypageService")
@Transactional(propagation=Propagation.REQUIRED)
public class MypageServiceImpl implements MypageService {
	@Autowired
	private MypageDAO mypageDAO; 
	
	// ���������� ����
	@Override
	public List<Map<String, Object>> listMyOrderGoods(CriteriaVO cri) throws Exception {
		return mypageDAO.listMyOrderGoods(cri);
	}
	
	@Override
	public int myMain(CriteriaVO cri) throws Exception {
		return mypageDAO.myMain(cri);
	}
	
	@Override
	public List<Map<String, Object>> orderList(SearchCriteriaVO scri) throws Exception{
		return mypageDAO.orderList(scri);
	}
	
	@Override
	public int orderListCnt(SearchCriteriaVO scri) throws Exception {
		return mypageDAO.orderListCnt(scri);
	}
	
	// A/S ��ȯ,��ǰ ����
	@Override
	public List<Map<String, Object>> mypageSelect(SearchCriteriaVO scri) throws Exception {
		return mypageDAO.mypageSelect(scri);
	}
	
	@Override
	public int mypageList(SearchCriteriaVO scri) throws Exception {
		return mypageDAO.mypageList(scri);
	}
	
	@Override // �Խñ� �ۼ�
	public int pro_review(Map asMap)throws Exception{
		int re_num=mypageDAO.pro_review(asMap);
		asMap.put("re_num", re_num);
		mypageDAO.insertNewImage(asMap);
		return re_num;
	}
	
	
	// ���������� ���� �� �ı� ���
	@Override   
	public List<Map<String, Object>> reviewList(CriteriaVO cri) throws Exception{
		List<Map<String, Object>> reviewList=mypageDAO.reviewList(cri);
		System.out.println("����:"+reviewList);
		return reviewList;
	}
				
	@Override
	public int reviewListCnt(CriteriaVO cri) throws Exception{
			     
	return mypageDAO.reviewListCnt(cri);
	}
	
	@Override // �ı� �󼼺���
	public Map reviewDetail(int re_num) throws Exception {
		Map reMap=new HashMap();
		GoodsVO goodsVO=mypageDAO.selectReview(re_num);
		List<ImageVO> imageFileList=mypageDAO.selectImageFileList(re_num);
		reMap.put("re", goodsVO);
		reMap.put("imageFileList", imageFileList);
		return reMap;
		
	}

	@Override // �ı� ����
	public void deleteReview(int re_num) {
		mypageDAO.deleteReview(re_num);
	}
	
	// ��㳻��
	@Override   
	public List<Map<String, Object>> conList(CriteriaVO cri) throws Exception{
		List<Map<String, Object>> conList=mypageDAO.conList(cri);
		return conList;
	}
				
	@Override
	public int conListCnt(CriteriaVO cri) throws Exception{
		return mypageDAO.conListCnt(cri);
	}
	
	// �ı� ����
	@Override
	public OrderVO review_edit(int re_num) throws Exception {
		return mypageDAO.review_edit(re_num);
	}
	
	@Override
	public void pro_review_edit(Map map) throws Exception {
		mypageDAO.pro_review_edit(map);
		mypageDAO.updateImage(map);
	}
		
}
