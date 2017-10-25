package com.koobym.dao;

import java.util.List;

import com.koobym.model.UserNotification;

public interface UserNotificationDao extends BaseDao<UserNotification, Long> {
	public List<UserNotification> getUserNotificationsForUser(long userId);
	public void notificationIsRead(long userNotificationId);
}
