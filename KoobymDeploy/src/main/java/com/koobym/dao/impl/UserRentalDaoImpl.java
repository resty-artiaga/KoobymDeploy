package com.koobym.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;


import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.UserRentalDao;
import com.koobym.model.RentalDetail;
import com.koobym.model.UserRental;


@Repository
public class UserRentalDaoImpl extends BaseDaoImpl<UserRental, Long> implements UserRentalDao {

	public UserRentalDaoImpl() {
		super(UserRental.class);
	}

	public List<UserRental> getListRentalById(int userId) {
		List<UserRental> flag = new ArrayList<UserRental>();
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(UserRental.class);
		criteria = criteria.createAlias("user", "user");
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		flag = (List<UserRental>) criteria.list();
		return flag;
	}
}
