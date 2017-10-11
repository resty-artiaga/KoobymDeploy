package com.koobym.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;


import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.SwapCommentDetailDao;
import com.koobym.model.SwapCommentDetail;

@Repository
public class SwapCommentDetailDaoImpl extends BaseDaoImpl<SwapCommentDetail, Long> implements SwapCommentDetailDao {

	public SwapCommentDetailDaoImpl() {
		super(SwapCommentDetail.class);
	}
	
	
	public List<SwapCommentDetail> getSwapCommentDetailOfSwapDetail(long swapDetailId){
		List<SwapCommentDetail> flag = null;
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(SwapCommentDetail.class);
		criteria = criteria.add(Restrictions.eq("swapDetail.swapDetailId", swapDetailId));
		flag = (List<SwapCommentDetail>) criteria.list();
		
		return flag;
	}
	
}
