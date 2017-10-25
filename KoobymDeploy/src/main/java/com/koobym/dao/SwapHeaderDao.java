package com.koobym.dao;

import java.util.List;

import com.koobym.model.SwapHeader;

public interface SwapHeaderDao extends BaseDao<SwapHeader, Long> {
	public List<SwapHeader> getListSwapHeaderByBookOwnerId(long bookOwnerId);
	public List<SwapHeader> getToDeliverById(int userId);
	public List<SwapHeader> getToReceiveByIdRenter(int userId);
	public SwapHeader setApprovedExam(long swapHeaderId, String status);
	public SwapHeader swapRequested(SwapHeader swapHeader);
	public List<SwapHeader> getRequestedSwaps(long userId);
	public List<SwapHeader> getToApproveSwaps(long userId);
	public List<SwapHeader> getCompleteById(int userId);
	public List<SwapHeader> getApprovedSwaps(long userId);
	public List<SwapHeader> getRejectedByIdOwner(int userId);
	public List<SwapHeader> getRejectedByIdRenter(int userId);
	public List<SwapHeader> getCompleteAllById(int userId);
}
