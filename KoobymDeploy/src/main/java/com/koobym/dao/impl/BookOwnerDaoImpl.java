package com.koobym.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.BookOwnerDao;
import com.koobym.dao.UserDao;
import com.koobym.model.BookOwner;
import com.koobym.model.RentalHeader;
import com.koobym.model.User;

@Repository
public class BookOwnerDaoImpl extends BaseDaoImpl<BookOwner, Long> implements BookOwnerDao {

	public BookOwnerDaoImpl() {
		super(BookOwner.class);
	}
	
	public BookOwner setBookOwner(long bookOwnerId, long userId) {
		BookOwner bookOwner = new BookOwner();
		
		Session session= getSessionFactory().getCurrentSession();
		String squery = "update book_owner set userId = :userId where book_ownerId = :bookOwnerId";
		
		SQLQuery query = session.createSQLQuery(squery);
		query.setLong("userId", userId);
		query.setLong("bookOwnerId", bookOwnerId);
		query.executeUpdate();
		
		bookOwner = get(bookOwnerId);
		
		
		return bookOwner;
	}
	
	public BookOwner increment(long bookOwnerId){
		BookOwner bookOwner = get(bookOwnerId);
		System.out.println(bookOwner.getNoRenters());
		bookOwner.setNoRenters(bookOwner.getNoRenters() + 1);
		System.out.println(bookOwner.getNoRenters());
		update(bookOwner);
		return bookOwner;
	}
	
	
	public List<BookOwner> getMyBooksById(int userId) {
		List<BookOwner> flag = new ArrayList<BookOwner>();
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(BookOwner.class);
		criteria = criteria.createAlias("user", "user");
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<BookOwner>) criteria.list();
		return flag;
	}
	
	public List<BookOwner> getStatusById() {
		List<BookOwner> flag = new ArrayList<BookOwner>();
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(BookOwner.class);
		criteria = criteria.createAlias("user", "user");
		criteria = criteria.add(Restrictions.or(Restrictions.eq("status", "Rent"),Restrictions.eq("status", "Swap")));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<BookOwner>) criteria.list();
		return flag;
	}

}
