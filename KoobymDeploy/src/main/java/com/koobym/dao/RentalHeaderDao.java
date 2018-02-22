package com.koobym.dao;

import java.util.List;

import com.koobym.model.AuctionHeader;
import com.koobym.model.RentalHeader;

public interface RentalHeaderDao extends BaseDao<RentalHeader, Long> {
	
	public List<RentalHeader> getToDeliverToday();
	
	public List<RentalHeader> getToReceive(long userId);

	public void rejectAllOtherRequests(RentalHeader rentalHeader);

	public List<RentalHeader> getOngoingRequestsByUser(int userId);

	public List<RentalHeader> getOngoingByOwner(int userId);

	public List<RentalHeader> getListRentalByBookOwnerId(long bookOwnerId);

	public List<RentalHeader> getListRentalById(int userId);

	public List<RentalHeader> getToDeliverById(int userId);

	public List<RentalHeader> getToReceiveByIdRenter(int userId);

	public List<RentalHeader> getMyRequestsById(int userId);

	public List<RentalHeader> getRequestReceivedById(int userId);

	public List<RentalHeader> getToReturnByIdRenter(int userId);

	public List<RentalHeader> getCompleteByIdRenter(int userId);

	public List<RentalHeader> getToReceiveByIdOwner(int userId);

	public List<RentalHeader> getCompleteByIdOwner(int userId);

	public List<RentalHeader> getToReturnByIdOwner(int userId);

	public RentalHeader setApprovedExam(long rentalHeaderId, String status, String dateApproved);

	public RentalHeader setRentalHeader(RentalHeader rentalHeader);

	public RentalHeader checkExist(long userId, long rentalDetailId);

	public List<RentalHeader> getRejectedByIdRenter(int userId);

	public List<RentalHeader> getRejectedByIdOwner(int userId);

	public List<RentalHeader> getCompleteByRentalDetail(long rentalDetailId);

	public long numberOfCompletedRentsByBookOwnerId(long bookOwnerId);

	public List<RentalHeader> getRentalHeader(long bookOwnerId);

	public RentalHeader setMeetUp(long rentalHeaderId, long meetUpId);

	public List<RentalHeader> getElapsedRentalDate();
	
	public RentalHeader setReturnMeetUp(long rentalHeaderId, long meetUpId);
	
	public RentalHeader setReturnToReceive(long rentalHeaderId);
	
	public RentalHeader setCompleteRental(long rentalHeaderId);
}
