package com.koobym.dao;

import java.util.List;


import java.util.Set;

import com.koobym.model.BookOwner;
import com.koobym.model.SwapHeader;

public interface SwapHeaderDao extends BaseDao<SwapHeader, Long> {
	public List<SwapHeader> getToDeliverById(int userId);
	public List<SwapHeader> getToReceiveByIdRenter(int userId);
	public SwapHeader setApprovedExam(long swapHeaderId, String status);
	public SwapHeader swapRequested(SwapHeader swapHeader);
	public List<SwapHeader> getRequestedSwaps(long userId);
	public List<SwapHeader> getToApproveSwaps(long userId);
	public List<SwapHeader> getCompleteById(int userId);
	public List<SwapHeader> getApprovedSwaps(long userId);
	
}
