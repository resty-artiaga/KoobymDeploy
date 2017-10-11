package com.koobym.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.UserRatingDao;
import com.koobym.dao.UserRentalDao;
import com.koobym.model.BookOwnerRating;
import com.koobym.model.RentalDetail;
import com.koobym.model.UserRating;
import com.koobym.model.UserRental;

@Repository
public class UserRatingDaoImpl extends BaseDaoImpl<UserRating, Long> implements UserRatingDao {

	public UserRatingDaoImpl() {
		super(UserRating.class);
	}

	@Override
	public List<UserRating> userRatingOfUser(long userId) {
		List<UserRating> flag = null;

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(UserRating.class);
		criteria = criteria.add(Restrictions.eq("user.userId", userId));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<UserRating>) criteria.list();

		return flag;
	}

}
