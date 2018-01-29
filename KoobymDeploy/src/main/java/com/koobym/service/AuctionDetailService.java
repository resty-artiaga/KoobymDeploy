package com.koobym.service;

import java.util.List;


import com.koobym.model.AuctionDetail;
import com.koobym.model.RentalDetail;

public interface AuctionDetailService extends BaseService<AuctionDetail, Long> {
	public AuctionDetail setBookOwnerAsAuction(AuctionDetail auctionDetail);

	public AuctionDetail getAuctionDetail(long bookOwnerId);
	public List<AuctionDetail> getAuctionById(int userId);
	public List<AuctionDetail> getAuctionEndDate();
	public List<AuctionDetail> getAuctionStartDate();
	public List<AuctionDetail> getAuctionStartTime();
	public List<AuctionDetail> getAuctionEndTime();
}
