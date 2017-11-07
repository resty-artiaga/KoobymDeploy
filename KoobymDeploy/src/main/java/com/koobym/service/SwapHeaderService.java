package com.koobym.service;

import java.util.List;

import com.koobym.model.BookOwner;
import com.koobym.model.SwapHeader;

public interface SwapHeaderService extends BaseService<SwapHeader, Long> {
	public List<SwapHeader> getToDeliverById(int userId);
	public List<SwapHeader> getToReceiveByIdRenter(int userId);
	public SwapHeader setApprovedExam(long swapHeaderId, String status, String date);
	public SwapHeader swapRequested(SwapHeader swapHeader);
	public List<SwapHeader> getRequestedSwaps(long userId);
	public List<SwapHeader> getToApproveSwaps(long userId);
	public List<SwapHeader> getCompleteById(int userId);
	public List<SwapHeader> getApprovedSwaps(long userId);
	public List<SwapHeader> getRejectedByIdOwner(int userId);
	public List<SwapHeader> getRejectedByIdRenter(int userId);
	public List<SwapHeader> getCompleteAllById(int userId);
	public SwapHeader addNewSwapHeader(SwapHeader swapHeader);
}
