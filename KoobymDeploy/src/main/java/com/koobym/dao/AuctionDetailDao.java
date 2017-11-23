package com.koobym.dao;

import java.util.List;


import com.koobym.model.AuctionDetail;

public interface AuctionDetailDao extends BaseDao<AuctionDetail, Long> {
	
	public List<AuctionDetail> getAuctionById(int userId);

	public AuctionDetail getAuctionDetail(long bookOwnerId);
}
