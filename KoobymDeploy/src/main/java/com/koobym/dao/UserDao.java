package com.koobym.dao;

import com.koobym.model.User;

public interface UserDao extends BaseDao<User, Long> {
	public User register(User user);
	public User login(User user);
	public User checkFbUser(String userFbId);
}
