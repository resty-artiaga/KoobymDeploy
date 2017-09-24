package com.koobym.dao.impl;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.BookDao;
import com.koobym.dao.UserDao;
import com.koobym.model.Book;
import com.koobym.model.User;

@Repository
public class BookDaoImpl extends BaseDaoImpl<Book, Long> implements BookDao {

	public BookDaoImpl() {
		super(Book.class);
	}

}
