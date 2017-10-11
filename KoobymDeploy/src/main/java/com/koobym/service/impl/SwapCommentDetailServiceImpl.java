package com.koobym.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.dao.SwapCommentDetailDao;
import com.koobym.model.SwapCommentDetail;
import com.koobym.service.SwapCommentDetailService;

@Service
@Transactional
public class SwapCommentDetailServiceImpl extends BaseServiceImpl<SwapCommentDetail, Long>
		implements SwapCommentDetailService {

	private SwapCommentDetailDao swapCommentDetailDao;

	@Autowired
	public SwapCommentDetailServiceImpl(SwapCommentDetailDao swapCommentDetailDao) {
		super(swapCommentDetailDao);
		this.swapCommentDetailDao = swapCommentDetailDao;
	}

	@Override
	public List<SwapCommentDetail> getSwapCommentDetailOfSwapDetail(long swapDetailId) {
		return swapCommentDetailDao.getSwapCommentDetailOfSwapDetail(swapDetailId);
	}

}
