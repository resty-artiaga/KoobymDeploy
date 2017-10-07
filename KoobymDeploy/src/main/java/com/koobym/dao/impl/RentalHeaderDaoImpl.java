package com.koobym.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.RentalHeaderDao;
import com.koobym.model.RentalHeader;
import com.koobym.model.UserRental;


@Repository
public class RentalHeaderDaoImpl extends BaseDaoImpl<RentalHeader, Long> implements RentalHeaderDao {

	public RentalHeaderDaoImpl() {
		super(RentalHeader.class);
	}
	
	public List<RentalHeader> getListRentalById(int userId) {
		List<RentalHeader> flag = new ArrayList<RentalHeader>();
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		/*criteria = criteria.createAlias("user", "user");*/
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();
		return flag;
	}
	
	public List<RentalHeader> getToDeliverById(int userId){
		
		List<RentalHeader> flag = new ArrayList<RentalHeader>();
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		/*criteria = criteria.createAlias("user", "user");*/
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.add(Restrictions.eq("status", "To Deliver"));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();
		return flag;
		
	}
	
	public List<RentalHeader> getToReceiveByIdRenter(int userId){
		
		List<RentalHeader> flag = new ArrayList<RentalHeader>();
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		/*criteria = criteria.createAlias("user", "user");*/
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.add(Restrictions.eq("status", "To Receive"));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();
		return flag;
		
	}
	
public List<RentalHeader> getToReturnByIdRenter(int userId){
		
		List<RentalHeader> flag = new ArrayList<RentalHeader>();
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		/*criteria = criteria.createAlias("user", "user");*/
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.add(Restrictions.eq("status", "To Return"));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();
		return flag;
		
	}
	
public List<RentalHeader> getMyRequestsById(int userId){
		
		List<RentalHeader> flag = new ArrayList<RentalHeader>();
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		/*criteria = criteria.createAlias("user", "user");*/
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.add(Restrictions.eq("status", "Confirmation"));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();
		return flag;
		
	}

public List<RentalHeader> getToReceiveByIdOwner(int userId){
	
	List<RentalHeader> flag = new ArrayList<RentalHeader>();
	
	Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
	criteria = criteria.createAlias("rentalDetail", "rentalDetail");
	criteria = criteria.createAlias("rentalDetail.bookOwner", "bookOwner");
	criteria = criteria.createAlias("rentalDetail.bookOwner.user", "user");
	criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
	criteria = criteria.add(Restrictions.eq("status", "To Receive"));
	criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
	flag = (List<RentalHeader>) criteria.list();
	return flag;
	
}

public List<RentalHeader> getRequestReceivedById(int userId){
	
	List<RentalHeader> flag = new ArrayList<RentalHeader>();
	
	Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
	criteria = criteria.createAlias("rentalDetail", "rentalDetail");
	criteria = criteria.createAlias("rentalDetail.bookOwner", "bookOwner");
	criteria = criteria.createAlias("rentalDetail.bookOwner.user", "user");
	criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
	criteria = criteria.add(Restrictions.eq("status", "Confirmation"));
	criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
	flag = (List<RentalHeader>) criteria.list();
	return flag;
	
}

public List<RentalHeader> getCompleteByIdRenter(int userId){
	
	List<RentalHeader> flag = new ArrayList<RentalHeader>();
	
	Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
	/*criteria = criteria.createAlias("user", "user");*/
	criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
	criteria = criteria.add(Restrictions.eq("status", "Complete"));
	criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
	flag = (List<RentalHeader>) criteria.list();
	return flag;
	
}

public List<RentalHeader> getCompleteByIdOwner(int userId){
	
	List<RentalHeader> flag = new ArrayList<RentalHeader>();
	
	Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
	criteria = criteria.createAlias("rentalDetail", "rentalDetail");
	criteria = criteria.createAlias("rentalDetail.bookOwner", "bookOwner");
	criteria = criteria.createAlias("rentalDetail.bookOwner.user", "user");
	criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
	criteria = criteria.add(Restrictions.eq("status", "Complete"));
	criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
	flag = (List<RentalHeader>) criteria.list();
	return flag;
	
}
}
