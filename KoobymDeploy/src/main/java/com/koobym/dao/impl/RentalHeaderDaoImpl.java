package com.koobym.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.RentalHeaderDao;
import com.koobym.model.BookOwner;
import com.koobym.model.RentalDetail;
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
		criteria = criteria.createAlias("user", "user");
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();
		return flag;
	}
	
	public List<RentalHeader> getToDeliverById(int userId){
		
		List<RentalHeader> flag = new ArrayList<RentalHeader>();
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		criteria = criteria.createAlias("rentalDetail", "rentalDetail");
		criteria = criteria.createAlias("rentalDetail.bookOwner", "bookOwner");
		criteria = criteria.createAlias("rentalDetail.bookOwner.user", "user");
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.add(Restrictions.eq("status", "Approved"));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();
		return flag;
		
	}
	
	
	
	public List<RentalHeader> getToReceiveByIdRenter(int userId){
		
		List<RentalHeader> flag = new ArrayList<RentalHeader>();
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		criteria = criteria.createAlias("user", "user");
		criteria = criteria.add(Restrictions.eq("status", "Approved"));
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();
		return flag;
		
	}
	
public List<RentalHeader> getToReturnByIdRenter(int userId){
		
		List<RentalHeader> flag = new ArrayList<RentalHeader>();
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		criteria = criteria.createAlias("user", "user");
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.add(Restrictions.eq("status", "Received"));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();
		return flag;
		
	}

public List<RentalHeader> getToReturnByIdOwner(int userId){
	
	List<RentalHeader> flag = new ArrayList<RentalHeader>();
	
	Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
	criteria = criteria.createAlias("rentalDetail", "rentalDetail");
	criteria = criteria.createAlias("rentalDetail.bookOwner", "bookOwner");
	criteria = criteria.createAlias("rentalDetail.bookOwner.user", "user");
	criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
	criteria = criteria.add(Restrictions.eq("status", "Received"));
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
	criteria = criteria.add(Restrictions.eq("status", "Received"));
	criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
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

public RentalHeader setApprovedExam(long rentalHeaderId, String status) {
	RentalHeader rentalHeader = new RentalHeader();
	
	Session session= getSessionFactory().getCurrentSession();
	String squery = "update rental_header set status = :status where rentalHeaderId = :rentalHeaderId";
	
	SQLQuery query = session.createSQLQuery(squery);
	query.setString("status", status);
	query.setLong("rentalHeaderId", rentalHeaderId);
	query.executeUpdate();
	
	rentalHeader = get(rentalHeaderId);
	
	
	return rentalHeader;
}

public List<RentalHeader> getCompleteByIdRenter(int userId){
	
	List<RentalHeader> flag = new ArrayList<RentalHeader>();
	
	Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
	criteria = criteria.createAlias("user", "user");
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
