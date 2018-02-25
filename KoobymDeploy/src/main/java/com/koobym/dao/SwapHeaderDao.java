package com.koobym.dao;

import java.util.List;

import com.koobym.model.SwapHeader;

public interface SwapHeaderDao extends BaseDao<SwapHeader, Long> {

	public void rejectAllOtherRequests(SwapHeader swapHeader);

	public List<SwapHeader> getOngoingSwapRequestsByUser(long userId);

	public List<SwapHeader> getListSwapHeaderByBookOwnerId(long bookOwnerId);

	public List<SwapHeader> getToDeliverById(int userId);

	public List<SwapHeader> getToReceiveByIdRenter(int userId);

	public SwapHeader setApprovedExam(String status, long swapHeaderId, String date);

	public SwapHeader swapRequested(SwapHeader swapHeader);

	public List<SwapHeader> getRequestedSwaps(long userId);

	public List<SwapHeader> getToApproveSwaps(long userId);

	public List<SwapHeader> getCompleteById(int userId);

	public List<SwapHeader> getApprovedSwaps(long userId);

	public List<SwapHeader> getRejectedByIdOwner(int userId);

	public List<SwapHeader> getRejectedByIdRenter(int userId);

	public List<SwapHeader> getCompleteAllById(int userId);

	public List<SwapHeader> getOngoingSwaps(long userId);
	
	public SwapHeader swapOwner(long userId);

	public SwapHeader setDelivered(long swapHeaderId);

	public SwapHeader setComplete(long swapHeaderId);
	
	public List<SwapHeader> history(long userId);
}
