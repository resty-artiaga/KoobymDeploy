package com.koobym.dao.impl;

import java.math.BigInteger;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.hql.internal.ast.tree.RestrictableStatement;
import org.springframework.stereotype.Repository;

import com.koobym.dao.AuctionHeaderDao;
import com.koobym.model.RentalHeader;
import com.koobym.model.SwapHeader;
import com.koobym.model.AuctionDetail;
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
	
	public List<AuctionHeader> getWinById(long userId){
		List<AuctionHeader> flag = new ArrayList<AuctionHeader>();
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(AuctionHeader.class);
		criteria = criteria.createAlias("user", "user");
		criteria = criteria.add(Restrictions.eq("user.userId", userId));
		criteria = criteria.add(Restrictions.eq("status", "win"));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<AuctionHeader>) criteria.list();
		
		return flag;
	}

	public List<AuctionHeader> getToReceiveById(int userId) {

		List<AuctionHeader> flag = new ArrayList<AuctionHeader>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(AuctionHeader.class);
		criteria = criteria.createAlias("auctionDetail", "auctionDetail");
		criteria = criteria.createAlias("auctionDetail.bookOwner", "bookOwner");
		criteria = criteria.createAlias("auctionDetail.bookOwner.user", "user");
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.add(Restrictions.eq("status", "stop"));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<AuctionHeader>) criteria.list();
		return flag;

	}
	
	public List<AuctionHeader> getToDeliverById(int userId) {

		List<AuctionHeader> flag = new ArrayList<AuctionHeader>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(AuctionHeader.class);
		criteria = criteria.createAlias("auctionDetail", "auctionDetail");
		criteria = criteria.createAlias("auctionDetail.bookOwner", "bookOwner");
		criteria = criteria.createAlias("auctionDetail.bookOwner.user", "user");
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.add(Restrictions.eq("status", "stop"));
		criteria = criteria.addOrder(Order.desc("dateDelivered")); 
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<AuctionHeader>) criteria.list();
		return flag;

	}
	
	 public AuctionHeader setApprovedExam(long auctionHeaderId, String status, String date) {
	 AuctionHeader auctionHeader = new AuctionHeader();
	 AuctionDetail auctionDetail = new AuctionDetail();
	
	 Session session = getSessionFactory().getCurrentSession();
	
	 String squery = "";
	
	 if (status.equals("win")) {
		 squery = "update auction_header set status = :status where auctionHeaderId = :auctionHeaderId";
	 } else if (status.equals("lose")) {
		 squery = "update auction_header set status = :status where auctionHeaderId = :auctionHeaderId";
	 }else if(status.equals("own")) {
		 squery = "update auction_header set status = :status where auctionHeaderId = :auctionHeaderId";
	}
	
	 SQLQuery query = session.createSQLQuery(squery);
	 query.setString("status", status);
	 query.setLong("auctionHeaderId", auctionHeaderId);
	 query.executeUpdate();
	
	 auctionHeader = get(auctionHeaderId);
	 
	 auctionDetail = auctionHeader.getAuctionDetail();
	 
	 Session sessionStat = getSessionFactory().getCurrentSession();
	 
	 if(status.equals("win")){
		 auctionDetail.setStatus("Not Available");
		 auctionDetail.getBookOwner().setBookStat("Not Available");
		 auctionHeader.setAuctionDetail(auctionDetail);
	 }
	 
	 sessionStat.update(auctionHeader);
	 
	
	 return auctionHeader;
	 }
}
