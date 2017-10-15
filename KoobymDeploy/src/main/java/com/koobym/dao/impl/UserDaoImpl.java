package com.koobym.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.UserDao;
import com.koobym.model.RentalHeader;
import com.koobym.model.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}

	@Override
	public User register(User user) {
		try {
			getSessionFactory().getCurrentSession().save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}


	@Override
	public User login(User user) {
		Session session = getSessionFactory().getCurrentSession();
		User userLoggedIn = (User) session.createCriteria(User.class).add(Restrictions.eq("username", user.getUsername()))
		.add(Restrictions.eq("password", user.getPassword())).uniqueResult();
		return userLoggedIn;
	}


	@Override
	public User checkFbUser(String userFbId) {
		Session session = getSessionFactory().getCurrentSession();
		User userLoggedIn = (User) session.createCriteria(User.class).add(Restrictions.eq("userFbId", userFbId))
		.uniqueResult();
		return userLoggedIn;
	}
	
}
