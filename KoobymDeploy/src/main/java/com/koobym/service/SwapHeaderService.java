package com.koobym.service;

import java.util.List;

import com.koobym.model.SwapHeader;

public interface SwapHeaderService extends BaseService<SwapHeader, Long> {
	public List<SwapHeader> getToDeliverById(int userId);
}
