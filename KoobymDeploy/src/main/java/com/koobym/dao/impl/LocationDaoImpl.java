package com.koobym.dao.impl;

import org.hibernate.Session;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.LocationDao;
import com.koobym.model.Location;

@Repository
public class LocationDaoImpl extends BaseDaoImpl<Location, Long> implements LocationDao {

	public LocationDaoImpl() {
		super(Location.class);
	}

	
}
