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

	public List<AuctionComment> getMaximumBid(int auctionDetailId) {

		List<AuctionComment> flag = new ArrayList<AuctionComment>();
		try {
			Session session = getSessionFactory().getCurrentSession();
			String squery = "SELECT MAX(auction_comment.auctionComment) as bid, auction_comment.userId as user "
					+ "FROM auction_comment " + "where auction_comment.auctionCommentId in " + "("
					+ "select auctionCommentId from koobym.auction_comment_detail "
					+ "where auction_comment_detail.auctionDetailId = :auctionDetailId" + ")"
					+ "group by auction_comment.userId order by bid desc;";
			SQLQuery query = session.createSQLQuery(squery);
			query.setInteger("auctionDetailId", auctionDetailId);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			List<Object> results = query.list();
			AuctionComment ac;
			Map<String, Object> row;
			for(Object auction: results){
				row  = (Map<String, Object>) auction;
				ac = new AuctionComment();
				ac.setAuctionComment((double) row.get("bid"));
				ac.setUser(new User());
				ac.getUser().setUserId((int) row.get("user"));
				flag.add(ac);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
