package com.koobym.dao;

import com.koobym.model.UserDayTime;

public interface UserDayTimeDao extends BaseDao<UserDayTime, Long> {
	public void saveOrUpdate(UserDayTime userDayTime);
}
