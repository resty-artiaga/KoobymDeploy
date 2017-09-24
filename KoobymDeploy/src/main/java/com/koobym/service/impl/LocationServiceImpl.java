package com.koobym.service.impl;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.dao.LocationDao;
import com.koobym.model.Location;
import com.koobym.service.LocationService;

@Service
@Transactional
public class LocationServiceImpl extends BaseServiceImpl<Location, Long> implements LocationService {

	private LocationDao locationDao;

	@Autowired
	public LocationServiceImpl(LocationDao locationDao) {
		super(locationDao);
		this.locationDao = locationDao;
	}

}
