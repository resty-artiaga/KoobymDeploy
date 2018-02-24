package com.koobym.service;

import java.util.List;


import com.koobym.model.BookOwner;
import com.koobym.model.SwapHeader;
import com.koobym.model.AuctionHeader;

public interface AuctionHeaderService extends BaseService<AuctionHeader, Long> {
	
	public AuctionHeader addNewAuctionHeader(AuctionHeader auctionHeader);
	public AuctionHeader getAuctionHeader(long auctionDetailId, long userId);
	public AuctionHeader setApprovedExam(long auctionHeaderId, String status, String dateApproved);
	public List<AuctionHeader> getToDeliverById(int userId);
	public List<AuctionHeader> getToReceiveById(int userId);
	public List<AuctionHeader> getWinById(long userId);
	public AuctionHeader changeOwner(long auctionHeaderId);
	public AuctionHeader deliveredBook(long auctionHeaderId);
	public AuctionHeader receivedBook(long auctionHeaderId);
}
