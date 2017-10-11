package com.koobym.service;

import java.util.List;

import com.koobym.model.SwapCommentDetail;

public interface SwapCommentDetailService extends BaseService<SwapCommentDetail, Long> {
	public List<SwapCommentDetail> getSwapCommentDetailOfSwapDetail(long swapDetailId);
}
