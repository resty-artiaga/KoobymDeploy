package com.koobym.dao;

import java.util.List;

import com.koobym.model.AuctionComment;

public interface AuctionCommentDao extends BaseDao<AuctionComment, Long> {
	public AuctionComment getMaximumBid(int auctionDetailId);
}
