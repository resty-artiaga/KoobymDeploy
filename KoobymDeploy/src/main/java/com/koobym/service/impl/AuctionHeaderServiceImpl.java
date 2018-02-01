package com.koobym.service.impl;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.dao.LocationDao;
import com.koobym.dao.AuctionHeaderDao;
import com.koobym.dao.UserNotificationDao;
import com.koobym.model.AuctionHeader;
import com.koobym.model.SwapHeader;
import com.koobym.model.UserNotification;
import com.koobym.pusher.PusherServer;
import com.koobym.service.AuctionHeaderService;

@Service
@Transactional
public class AuctionHeaderServiceImpl extends BaseServiceImpl<AuctionHeader, Long> implements AuctionHeaderService {

	private AuctionHeaderDao auctionHeaderDao;
	private LocationDao locationDao;
	private UserNotificationDao userNotificationDao;

	@Autowired
	private PusherServer pusherServer;

	@Autowired
	public AuctionHeaderServiceImpl(AuctionHeaderDao auctionHeaderDao, LocationDao locationDao,
			UserNotificationDao userNotificationDao) {
		super(auctionHeaderDao);
		this.auctionHeaderDao = auctionHeaderDao;
		this.locationDao = locationDao;
		this.userNotificationDao = userNotificationDao;
	}

	@Override
	public AuctionHeader addNewAuctionHeader(AuctionHeader auctionHeader) {
		auctionHeaderDao.save(auctionHeader);

		UserNotification userNotif = new UserNotification();
		userNotif.setUser(auctionHeader.getAuctionDetail().getBookOwner().getUser());
		userNotif.setActionId(auctionHeader.getAuctionHeaderId());
		userNotif.setActionName("auction");
		userNotif.setActionStatus("Bid");
		userNotif.setUserPerformer(auctionHeader.getUser());
		userNotif.setBookActionPerformedOn(auctionHeader.getAuctionDetail().getBookOwner());
		userNotificationDao.save(userNotif);

		pusherServer.sendNotification(userNotif);

		return auctionHeader;
	}
	
	@Override
	public AuctionHeader getAuctionHeader(long auctionDetailId, long userId){
		return auctionHeaderDao.getAuctionHeader(auctionDetailId, userId);
	}
	
	@Override
	public AuctionHeader setApprovedExam(long auctionHeaderId, String status, String dateApproved){
		return auctionHeaderDao.setApprovedExam(auctionHeaderId, status, dateApproved);
	}
	
}
