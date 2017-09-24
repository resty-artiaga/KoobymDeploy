package com.koobym.dao.impl;

import org.hibernate.Session;


import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.DayDao;
import com.koobym.model.Day;

@Repository
public class DayDaoImpl extends BaseDaoImpl<Day, Long> implements DayDao {

	public DayDaoImpl() {
		super(Day.class);
	}

	
}
