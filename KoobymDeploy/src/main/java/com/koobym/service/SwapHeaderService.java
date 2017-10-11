package com.koobym.service;

import java.util.List;

import com.koobym.model.BookOwner;
import com.koobym.model.SwapHeader;

public interface SwapHeaderService extends BaseService<SwapHeader, Long> {
	public List<SwapHeader> getToDeliverById(int userId);
	public List<SwapHeader> getToReceiveByIdRenter(int userId);
	public SwapHeader setApprovedExam(long swapHeaderId, String status);
	public SwapHeader swapRequested(SwapHeader swapHeader);
	public List<SwapHeader> getRequestedSwaps(long userId);
}
