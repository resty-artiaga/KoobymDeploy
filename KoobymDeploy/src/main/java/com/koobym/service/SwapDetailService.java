package com.koobym.service;

import java.util.List;


import com.koobym.model.BookOwner;
import com.koobym.model.SwapDetail;

public interface SwapDetailService extends BaseService<SwapDetail, Long> {
	
	public List<SwapDetail> getSwapById(int userId);
	public List<SwapDetail> getMySwapBookById(int userId);
	public List<SwapDetail> getSwapPriceById(int userId, float price);
	
}
