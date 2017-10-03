package com.koobym.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.RentalHeaderDao;
import com.koobym.model.RentalHeader;
import com.koobym.model.UserRental;


@Repository
public class RentalHeaderDaoImpl extends BaseDaoImpl<RentalHeader, Long> implements RentalHeaderDao {

	public RentalHeaderDaoImpl() {
		super(RentalHeader.class);
	}
	
	public List<RentalHeader> getListRentalById(int userId) {
		List<RentalHeader> flag = new ArrayList<RentalHeader>();
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		/*criteria = criteria.createAlias("user", "user");*/
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();
		return flag;
	}
}
