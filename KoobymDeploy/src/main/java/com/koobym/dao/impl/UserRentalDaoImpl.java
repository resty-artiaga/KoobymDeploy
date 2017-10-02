package com.koobym.dao.impl;

import org.hibernate.Session;


import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.UserRentalDao;
import com.koobym.model.UserRental;


@Repository
public class UserRentalDaoImpl extends BaseDaoImpl<UserRental, Long> implements UserRentalDao {

	public UserRentalDaoImpl() {
		super(UserRental.class);
	}

}
