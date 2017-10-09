package com.koobym.dao.impl;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.SwapHeaderDao;
import com.koobym.model.RentalHeader;
import com.koobym.model.SwapHeader;
import com.koobym.model.UserRental;


@Repository
public class SwapHeaderDaoImpl extends BaseDaoImpl<SwapHeader, Long> implements SwapHeaderDao {

	public SwapHeaderDaoImpl() {
		super(SwapHeader.class);
	}
	
	
public List<SwapHeader> getToDeliverById(int userId){
		
		List<SwapHeader> flag = new ArrayList<SwapHeader>();
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(SwapHeader.class);
		criteria = criteria.createAlias("swapDetail", "swapDetail");
		criteria = criteria.createAlias("swapDetail.bookOwner", "bookOwner");
		criteria = criteria.createAlias("swapDetail.bookOwner.user", "user");
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.add(Restrictions.eq("status", "Approved"));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<SwapHeader>) criteria.list();
		return flag;
		
	}
	
public List<SwapHeader> getToReceiveByIdRenter(int userId){
	
	List<SwapHeader> flag = new ArrayList<SwapHeader>();
	
	Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(SwapHeader.class);
	criteria = criteria.createAlias("user", "user");
	criteria = criteria.add(Restrictions.eq("status", "Approved"));
	criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
	criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
	flag = (List<SwapHeader>) criteria.list();
	return flag;
	
}
	
	
}
