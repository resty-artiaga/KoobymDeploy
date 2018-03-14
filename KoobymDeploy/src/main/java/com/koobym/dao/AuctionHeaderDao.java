package com.koobym.dao;

import java.util.List;

import com.koobym.model.AuctionHeader;
import com.koobym.model.RentalHeader;
import com.koobym.model.SwapHeader;

public interface AuctionHeaderDao extends BaseDao<AuctionHeader, Long> {

	public AuctionHeader setApprovedExam(long auctionHeaderId, String status, String dateApproved);

	public List<AuctionHeader> getAuctionHeader(long auctionDetailId, long userId);

	public List<AuctionHeader> getToDeliverById(int userId);

	public List<AuctionHeader> getToReceiveById(int userId);

	public List<AuctionHeader> getWinById(long userId);

	public AuctionHeader changeOwner(long auctionHeaderId);

	public AuctionHeader deliveredBook(long auctionHeaderId);

	public AuctionHeader receivedBook(long auctionHeaderId, long userRatingId);

	public List<AuctionHeader> history(long userId);

	public List<AuctionHeader> getAllWin();

	public boolean canAuction(long userId);
}
