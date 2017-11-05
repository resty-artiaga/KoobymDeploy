package com.koobym.dao.impl;

import org.hibernate.Session;


import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.MeetUpDao;
import com.koobym.model.MeetUp;

@Repository
public class MeetUpDaoImpl extends BaseDaoImpl<MeetUp, Long> implements MeetUpDao {

	public MeetUpDaoImpl() {
		super(MeetUp.class);
	}

	
}
