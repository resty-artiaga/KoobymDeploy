package com.koobym.service;

import java.util.List;


import com.koobym.model.BookOwner;
import com.koobym.model.SwapHeader;
import com.koobym.model.AuctionHeader;

public interface AuctionHeaderService extends BaseService<AuctionHeader, Long> {
	
	public AuctionHeader addNewAuctionHeader(AuctionHeader auctionHeader);

}
