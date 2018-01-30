package com.koobym.service;

import java.util.List;

import com.koobym.model.AuctionComment;

public interface AuctionCommentService extends BaseService<AuctionComment, Long> {

	public List<AuctionComment> getMaximumBid(int auctionDetailId);
}
