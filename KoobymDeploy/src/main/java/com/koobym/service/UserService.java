package com.koobym.service;

import com.koobym.model.User;

public interface UserService extends BaseService<User, Long> {

	public User register(User user);
	public User login(User user);
	public User checkFbUser(String userFbId);
}
