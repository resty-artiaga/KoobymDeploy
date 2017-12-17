package com.koobym.dao.impl;

import org.hibernate.Session;



import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.AuctionCommentDao;
import com.koobym.model.AuctionComment;

@Repository
public class AuctionCommentDAoImpl extends BaseDaoImpl<AuctionComment, Long> implements AuctionCommentDao {

	public AuctionCommentDAoImpl() {
		super(AuctionComment.class);
	}

	
}
