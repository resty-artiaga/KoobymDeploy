package com.koobym.dao;

import java.util.List;

import com.koobym.model.AuctionComment;

public interface AuctionCommentDao extends BaseDao<AuctionComment, Long> {
	public List<AuctionComment> getMaximumBid(int auctionDetailId);
}
