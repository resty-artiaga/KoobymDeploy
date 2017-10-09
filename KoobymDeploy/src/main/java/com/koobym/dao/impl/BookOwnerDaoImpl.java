package com.koobym.dao.impl;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.BookOwnerDao;
import com.koobym.dao.UserDao;
import com.koobym.model.BookOwner;
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

}
