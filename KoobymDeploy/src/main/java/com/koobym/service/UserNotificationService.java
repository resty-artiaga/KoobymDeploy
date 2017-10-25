package com.koobym.service;

import java.util.List;

import com.koobym.model.UserNotification;

public interface UserNotificationService extends BaseService<UserNotification, Long> {
	public List<UserNotification> getUserNotificationsForUser(long userId);
	public void notificationIsRead(long userNotificationId);
}
