package com.koobym.service.impl;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.dao.BookOwnerDao;
import com.koobym.dao.AuctionDetailDao;
import com.koobym.dao.UserDao;
import com.koobym.model.AuctionDetail;
import com.koobym.service.AuctionDetailService;

@Service
@Transactional
public class AuctionDetailServiceImpl extends BaseServiceImpl<AuctionDetail, Long> implements AuctionDetailService {

	private AuctionDetailDao auctionDetailDao;

	@Autowired
	private BookOwnerDao bookOwnerDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	public AuctionDetailServiceImpl(AuctionDetailDao auctionDetailDao) {
		super(auctionDetailDao);
		this.auctionDetailDao= auctionDetailDao;
	}

	@Override
	public List<AuctionDetail> getAuctionById(int userId) {
		return auctionDetailDao.getAuctionById(userId);
	}

	@Override
	public AuctionDetail getAuctionDetail(long bookOwnerId) {
		return auctionDetailDao.getAuctionDetail(bookOwnerId);
	}
}
