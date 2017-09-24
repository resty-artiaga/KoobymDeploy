package com.koobym.dao.impl;

import org.hibernate.Session;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.TimeDao;
import com.koobym.model.Time;

@Repository
public class TimeDaoImpl extends BaseDaoImpl<Time, Long> implements TimeDao {

	public TimeDaoImpl() {
		super(Time.class);
	}

	
}
