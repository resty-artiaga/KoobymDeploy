package com.koobym.service;

import java.util.List;


import com.koobym.model.AuctionDetail;
import com.koobym.model.RentalDetail;

public interface AuctionDetailService extends BaseService<AuctionDetail, Long> {
	public AuctionDetail setBookOwnerAsAuction(AuctionDetail auctionDetail);
	
	public List<AuctionDetail> getAuctionById(int userId);
	public List<AuctionDetail> getAuctionEndDate();
	public AuctionDetail getAuctionDetail(long bookOwnerId);
}
