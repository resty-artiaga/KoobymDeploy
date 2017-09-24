package com.koobym.dao.impl;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.AuthorDao;
import com.koobym.dao.UserDao;
import com.koobym.model.Author;
import com.koobym.model.User;

@Repository
public class AuthorDaoImpl extends BaseDaoImpl<Author, Long> implements AuthorDao {

	public AuthorDaoImpl() {
		super(Author.class);
	}

}
