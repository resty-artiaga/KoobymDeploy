package com.koobym.service;

import java.util.List;


import com.koobym.model.AuctionCommentDetail;

public interface AuctionCommentDetailService extends BaseService<AuctionCommentDetail, Long> {
	public List<AuctionCommentDetail> getAuctionCommentDetailOfAuctionDetail(long auctionDetailId);
}
