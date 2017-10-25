package com.koobym.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.dao.UserNotificationDao;
import com.koobym.model.UserNotification;
import com.koobym.service.UserNotificationService;

@Service
@Transactional
public class UserNotificationServiceImpl extends BaseServiceImpl<UserNotification, Long>
		implements UserNotificationService {

	private UserNotificationDao userNotificationDao;

	@Autowired
	public UserNotificationServiceImpl(UserNotificationDao userNotificationDao) {
		super(userNotificationDao);
		this.userNotificationDao = userNotificationDao;
	}

	@Override
	public List<UserNotification> getUserNotificationsForUser(long userId) {
		return userNotificationDao.getUserNotificationsForUser(userId);
	}

	@Override
	public void notificationIsRead(long userNotificationId) {
		userNotificationDao.notificationIsRead(userNotificationId);
	}

}
