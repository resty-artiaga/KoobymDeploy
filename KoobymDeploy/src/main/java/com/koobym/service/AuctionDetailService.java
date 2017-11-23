package com.koobym.service;

import java.util.List;


import com.koobym.model.AuctionDetail;

public interface AuctionDetailService extends BaseService<AuctionDetail, Long> {
	
	public List<AuctionDetail> getAuctionById(int userId);

	public AuctionDetail getAuctionDetail(long bookOwnerId);
}
