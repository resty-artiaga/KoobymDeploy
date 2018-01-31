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
import com.koobym.model.RentalDetail;

@Repository
public class AuctionHeaderDaoImpl extends BaseDaoImpl<AuctionHeader, Long> implements AuctionHeaderDao {

	public AuctionHeaderDaoImpl() {
		super(AuctionHeader.class);
	}

	public AuctionHeader getAuctionHeader(long auctionDetailId, long userId) {
		AuctionHeader auctionHeader = new AuctionHeader();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(AuctionHeader.class);
		criteria = criteria.createAlias("user", "user");
		criteria = criteria.createAlias("auctionDetail", "auctionDetail");
		criteria = criteria.add(Restrictions.eq("user.userId", userId));
		criteria = criteria.add(Restrictions.eq("auctionDetail.auctionDetailId", auctionDetailId));
		auctionHeader = (AuctionHeader) criteria.uniqueResult();

		return auctionHeader;
	}

	// public AuctionHeader setApprovedExam(long userId, String status) {
	// AuctionHeader auctionHeader = new AuctionHeader();
	//
	// Session session = getSessionFactory().getCurrentSession();
	//
	// String squery = "";
	//
	// if (status.equals("win")) {
	// squery = "update auction_header set status = :status where userId =
	// :userId";
	// } else if (status.equals("lose")) {
	// squery = "update auction_header set status = :status where userId =
	// :userId";
	// }
	//
	// SQLQuery query = session.createSQLQuery(squery);
	// query.setString("status", status);
	// query.setLong("userId", userId);
	// query.executeUpdate();
	//
	// auctionHeader = get(rentalHeaderId);
	//
	// return auctionHeader;
	// }
}
