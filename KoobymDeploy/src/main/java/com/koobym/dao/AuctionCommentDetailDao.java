package com.koobym.dao;

import java.util.List;


import com.koobym.model.AuctionCommentDetail;

public interface AuctionCommentDetailDao extends BaseDao<AuctionCommentDetail, Long> {
	public List<AuctionCommentDetail> getAuctionCommentDetailOfAuctionDetail(long auctionDetailId);
}
