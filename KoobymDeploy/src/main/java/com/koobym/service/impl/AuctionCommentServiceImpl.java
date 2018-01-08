package com.koobym.service.impl;

import javax.transaction.Transactional;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.dao.AuctionCommentDao;
import com.koobym.model.AuctionComment;
import com.koobym.service.AuctionCommentService;

@Service
@Transactional
public class AuctionCommentServiceImpl extends BaseServiceImpl<AuctionComment, Long> implements AuctionCommentService {

	private AuctionCommentDao auctionCommentDao;

	@Autowired
	public AuctionCommentServiceImpl(AuctionCommentDao auctionCommentDao) {
		super(auctionCommentDao);
		this.auctionCommentDao = auctionCommentDao;
	}
	
	public AuctionComment getMaximumBid(int auctionDetailId){
		return auctionCommentDao.getMaximumBid(auctionDetailId);
	}

}
