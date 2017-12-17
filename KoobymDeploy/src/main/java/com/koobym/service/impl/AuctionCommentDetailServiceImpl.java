package com.koobym.service.impl;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.dao.AuctionCommentDetailDao;
import com.koobym.model.AuctionCommentDetail;
import com.koobym.service.AuctionCommentDetailService;

@Service
@Transactional
public class AuctionCommentDetailServiceImpl extends BaseServiceImpl<AuctionCommentDetail, Long>
		implements AuctionCommentDetailService {

	private AuctionCommentDetailDao auctionCommentDetailDao;

	@Autowired
	public AuctionCommentDetailServiceImpl(AuctionCommentDetailDao auctionCommentDetailDao) {
		super(auctionCommentDetailDao);
		this.auctionCommentDetailDao = auctionCommentDetailDao;
	}

	@Override
	public List<AuctionCommentDetail> getAuctionCommentDetailOfAuctionDetail(long auctionDetailId) {
		return auctionCommentDetailDao.getAuctionCommentDetailOfAuctionDetail(auctionDetailId);
	}

}
