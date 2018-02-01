package com.koobym.dao;

import java.util.List;


import com.koobym.model.AuctionHeader;
import com.koobym.model.RentalHeader;

public interface AuctionHeaderDao extends BaseDao<AuctionHeader, Long> {

	public AuctionHeader setApprovedExam(long auctionHeaderId, String status, String dateApproved);
	public AuctionHeader getAuctionHeader(long auctionDetailId, long userId);
}
