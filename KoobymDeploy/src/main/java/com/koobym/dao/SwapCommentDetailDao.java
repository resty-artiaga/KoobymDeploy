package com.koobym.dao;

import java.util.List;

import com.koobym.model.SwapCommentDetail;

public interface SwapCommentDetailDao extends BaseDao<SwapCommentDetail, Long> {
	public List<SwapCommentDetail> getSwapCommentDetailOfSwapDetail(long swapDetailId);
}
