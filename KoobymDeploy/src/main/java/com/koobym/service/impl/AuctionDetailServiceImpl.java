package com.koobym.service.impl;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.dao.BookOwnerDao;
import com.koobym.dao.AuctionDetailDao;
import com.koobym.dao.UserDao;
import com.koobym.model.AuctionDetail;
import com.koobym.model.RentalDetail;
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
	
	@Override
	public AuctionDetail setBookOwnerAsAuction(AuctionDetail auctionDetail) {
		AuctionDetail ad = auctionDetailDao.getAuctionDetail(auctionDetail.getBookOwner().getBook_OwnerId());
		if (ad != null) {
			ad.setStartingPrice(auctionDetail.getStartingPrice());
			ad.setAuctionDescription(auctionDetail.getAuctionDescription());
			ad.setBookOwner(auctionDetail.getBookOwner());
			ad.setEndDate(auctionDetail.getEndDate());
			ad.setStartDate(auctionDetail.getStartDate());
			ad.setStatus("Available");
			ad.setAuctionStatus("start");
			auctionDetailDao.update(ad);
			auctionDetail.setAuctionDetailId(ad.getAuctionDetailId());
		} else {
			auctionDetailDao.save(auctionDetail);
		}

		return auctionDetail;

	}
	
	public List<AuctionDetail> getAuctionStartTime(){
		return auctionDetailDao.getAuctionStartTime();
	}
	
	public List<AuctionDetail> getAuctionEndDate(){
		return auctionDetailDao.getAuctionEndDate();
	}
	
	public List<AuctionDetail> getAuctionStartDate(){
		return auctionDetailDao.getAuctionStartDate();
	}
	
	public List<AuctionDetail> getAuctionEndTime(){
		return auctionDetailDao.getAuctionEndTime();
	}
	
}
