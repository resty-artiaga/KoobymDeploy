package com.koobym.dao.impl;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.UserDayTimeDao;
import com.koobym.model.UserDayTime;

@Repository
public class UserDayTimeDaoImpl extends BaseDaoImpl<UserDayTime, Long> implements UserDayTimeDao {

	public UserDayTimeDaoImpl() {
		super(UserDayTime.class);
	}

}
