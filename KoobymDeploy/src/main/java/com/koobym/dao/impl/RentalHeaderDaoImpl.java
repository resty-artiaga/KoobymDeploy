package com.koobym.dao.impl;

import org.hibernate.Session;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.RentalHeaderDao;
import com.koobym.model.RentalHeader;


@Repository
public class RentalHeaderDaoImpl extends BaseDaoImpl<RentalHeader, Long> implements RentalHeaderDao {

	public RentalHeaderDaoImpl() {
		super(RentalHeader.class);
	}

}
