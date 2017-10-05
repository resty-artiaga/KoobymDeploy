package com.koobym.dao;

import java.util.List;

import java.util.Set;

import com.koobym.model.Genre;
import com.koobym.model.SwapDetail;

public interface SwapDetailDao extends BaseDao<SwapDetail, Long> {
	public List<SwapDetail> getSwapById(int userId);
}
