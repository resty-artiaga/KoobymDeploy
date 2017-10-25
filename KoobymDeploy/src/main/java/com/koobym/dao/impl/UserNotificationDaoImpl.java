package com.koobym.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.UserNotificationDao;
import com.koobym.model.UserNotification;

@Repository
public class UserNotificationDaoImpl extends BaseDaoImpl<UserNotification, Long> implements UserNotificationDao {

	public UserNotificationDaoImpl() {
		super(UserNotification.class);
	}

	@Override
	public List<UserNotification> getUserNotificationsForUser(long userId) {
		List<UserNotification> flag = new ArrayList<UserNotification>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(UserNotification.class);
		criteria = criteria.add(Restrictions.eq("user.userId", userId));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<UserNotification>) criteria.list();
		return flag;
	}

	@Override
	public void notificationIsRead(long userNotificationId) {
		UserNotification userNotif = get(userNotificationId);
		userNotif.setRead(true);
		update(userNotif);
	}

}
