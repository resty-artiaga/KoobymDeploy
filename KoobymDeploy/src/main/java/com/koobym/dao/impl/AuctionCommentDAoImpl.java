package com.koobym.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;



import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.AuctionCommentDao;
import com.koobym.model.AuctionComment;
import com.koobym.model.RentalHeader;
import com.koobym.model.User;

@Repository
public class AuctionCommentDAoImpl extends BaseDaoImpl<AuctionComment, Long> implements AuctionCommentDao {

	public AuctionCommentDAoImpl() {
		super(AuctionComment.class);
	}

	public AuctionComment getMaximumBid(int auctionDetailId){
		AuctionComment flag = new AuctionComment();
		
		Session session = getSessionFactory().getCurrentSession();
		String squery= "SELECT MAX(auction_comment.auctionComment) as bid, auction_comment.userId as user"
				+ "FROM koobym.auction_comment "
				+ "where auction_comment.auctionCommentId in "
				+ "("
				+ "Select auctionCommentId from koobym.auction_comment_detail "
				+ "where auction_comment_detail.auctionDetailId = :auctionDetailId"
				+ ")"
				+ "group by auction_comment.userId;";
		SQLQuery query = session.createSQLQuery(squery);
		query.setInteger("auctionDetailId", auctionDetailId);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		Object obj = query.uniqueResult();
		Map<String, Object> row = (Map<String, Object>) obj;
		flag.setAuctionComment(new Double((double) row.get("bid")));
		flag.setUser((User) row.get("user"));
		return flag;
	}
	
}
