package com.koobym.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.dao.UserDao;
import com.koobym.model.User;
import com.koobym.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

	private UserDao userDao;

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		super(userDao);
		this.userDao = userDao;
	}

	@Override
	public User register(User user) {
		User userR = null;
		try {
			userR = userDao.register(user);
		} catch (Exception e) {
			userR = null;
		}
		return userR;
	}

	@Override
	public User login(User user) {
		User userLoggedIn = null;
		try {
			userLoggedIn = userDao.login(user);
		} catch (Exception e) {
			userLoggedIn = null;
		}
		return userLoggedIn;
	}

	@Override
	public User checkFbUser(String userFbId) {
		User userFB = null;
		try {
			System.out.println("in service");
			userFB = userDao.checkFbUser(userFbId);
		} catch (Exception e) {
			userFB = null;
			e.printStackTrace();
		}
		return userFB;
	}

}
