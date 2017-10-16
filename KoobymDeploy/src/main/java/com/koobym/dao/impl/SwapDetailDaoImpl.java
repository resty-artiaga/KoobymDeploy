package com.koobym.dao.impl;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.BookOwnerDao;
import com.koobym.dao.SwapDetailDao;
import com.koobym.dao.UserDao;
import com.koobym.model.SwapDetail;
import com.koobym.model.SwapHeader;
import com.koobym.model.Genre;
import com.koobym.model.RentalDetail;
import com.koobym.model.RentalHeader;
import com.koobym.model.User;

@Repository
public class SwapDetailDaoImpl extends BaseDaoImpl<SwapDetail, Long> implements SwapDetailDao {

	public SwapDetailDaoImpl() {
		super(SwapDetail.class);
	}

	
	/*String squery = "SELECT * FROM rental_detail JOIN book_owner ON rental_detail.bookOwnerId = book_owner.book_ownerId ORDER BY book_owner.noRenters DESC";
	SQLQuery query = session.createSQLQuery(squery);
	query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	Map<String, Object> row = null;
	List<Object> data = query.list();
	RentalDetail temp;
	for (Object object : data) {
		row = (Map<String, Object>) object;
		temp = new RentalDetail();
		temp.setRental_detailId((int) row.get("rental_detailId"));
		temp.setCalculatedPrice(new Double((float) row.get("calculatedPrice")));
		temp.setDaysForRent((int) row.get("daysForRent"));
		temp.setBookOwner(new BookOwner());
		temp.getBookOwner().setBook_OwnerId((int) row.get("bookOwnerId"));
		Hibernate.initialize(temp.getBookOwner());
		flag.add(temp);
	}
	return flag;*/
	
	
	public List<SwapDetail> getSwapById(int userId) {
		List<SwapDetail> flag = new ArrayList<SwapDetail>();
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(SwapDetail.class);
		criteria = criteria.createAlias("bookOwner", "bookOwner");
		criteria = criteria.add(Restrictions.eq("bookOwner.user.userId", new Long(userId)));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<SwapDetail>) criteria.list();
		return flag;
	}
	
	public List<SwapDetail> getSwapPriceById(int userId, float price) {
		List<SwapDetail> flag = new ArrayList<SwapDetail>();
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(SwapDetail.class);
		criteria = criteria.createAlias("bookOwner", "bookOwner");
		criteria = criteria.createAlias("bookOwner.user", "user");
		criteria = criteria.add(Restrictions.and(Restrictions.eq("user.userId", new Long(userId)), Restrictions.between("price", price - 100, price +100)));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<SwapDetail>) criteria.list();
		return flag;
	}
	
	public List<SwapDetail> getAll() {
List<SwapDetail> flag = new ArrayList<SwapDetail>();
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(SwapDetail.class);
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<SwapDetail>) criteria.list();
		return flag;
	}
	public List<SwapDetail> getMySwapBookById(int userId){
		
		List<SwapDetail> flag = new ArrayList<SwapDetail>();
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		criteria = criteria.createAlias("swapDetail", "swapDetail");
		criteria = criteria.createAlias("swapDetail.bookOwner", "bookOwner");
		criteria = criteria.createAlias("swapDetail.bookOwner.user", "user");
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<SwapDetail>) criteria.list();
		return flag;
		
	}

//	public List<RentalDetail> getRentalById(int userId) {
//		List<RentalDetail> flag = new ArrayList<RentalDetail>();
//		Session session = getSessionFactory().getCurrentSession();
//		String squery = "select * from rental_detail INNER JOIN book_owner on (select * from book_owner WHERE book_owner.userId = :userId)";
//		SQLQuery query = session.createSQLQuery(squery);
//		query.setInteger("userId", userId);
//		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
//		Map<String, Object> row = null;
//		List<Object> data = query.list();
//		RentalDetail temp;
//		for (Object object : data) {
//			row = (Map<String, Object>) object;
//			temp = new RentalDetail();
//			temp.setRental_detailId((int) row.get("rental_detailId"));
//			temp.setCalculatedPrice(new Double((float) row.get("calculatedPrice")));
//			temp.setDaysForRent((int) row.get("daysForRent"));
//			temp.setBookOwner(new BookOwner());
//			temp.getBookOwner().setBook_OwnerId((int) row.get("bookOwnerId"));
//			Hibernate.initialize(temp.getBookOwner());
//			flag.add(temp);
//		}
//
//		return flag;
//	}
}
