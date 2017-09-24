package com.koobym.dao.impl;

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

}
