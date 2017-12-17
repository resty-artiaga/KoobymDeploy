package com.koobym.dao.impl;

import java.math.BigInteger;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.AuctionHeaderDao;
import com.koobym.model.RentalHeader;
import com.koobym.model.AuctionHeader;

@Repository
public class AuctionHeaderDaoImpl extends BaseDaoImpl<AuctionHeader, Long> implements AuctionHeaderDao {

	public AuctionHeaderDaoImpl() {
		super(AuctionHeader.class);
	}

}
