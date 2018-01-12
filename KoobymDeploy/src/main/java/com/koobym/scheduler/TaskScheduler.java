package com.koobym.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.koobym.dao.AuctionCommentDao;
import com.koobym.dao.AuctionDetailDao;
import com.koobym.dao.AuctionHeaderDao;
import com.koobym.dao.RentalHeaderDao;
import com.koobym.dao.UserNotificationDao;
import com.koobym.model.AuctionComment;
import com.koobym.model.AuctionDetail;
import com.koobym.model.RentalHeader;
import com.koobym.model.UserNotification;
import com.koobym.pusher.PusherServer;

@Component
public class TaskScheduler {

	@Autowired
	private RentalHeaderDao rentalHeaderDao;

	@Autowired
	private AuctionCommentDao auctionCommentDao;
	
	@Autowired
	private AuctionDetailDao auctionDetailDao;
	
	@Autowired
	private UserNotificationDao userNotificationDao;

	@Autowired
	private PusherServer pusherServer;

	@Transactional
	@Scheduled(fixedRate = 1500000)
	public void checkRentalEndDates() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		List<RentalHeader> rentalHeadersWithElapsedEndDates = rentalHeaderDao.getElapsedRentalDate();
		UserNotification un;
		for (RentalHeader rh : rentalHeadersWithElapsedEndDates) {
			rentalHeaderDao.setApprovedExam(rh.getRentalHeaderId(), "Due", format.format(new Date()));
			un = new UserNotification();

			un.setActionId(rh.getRentalHeaderId());
			un.setActionName("rental");
			un.setActionStatus("Due");
			un.setBookActionPerformedOn(rh.getRentalDetail().getBookOwner());
			un.setUser(rh.getUserId());
			un.setUserPerformer(rh.getRentalDetail().getBookOwner().getUser());

			userNotificationDao.save(un);
			pusherServer.sendNotification(un);

			un = new UserNotification();
			un.setActionId(rh.getRentalHeaderId());
			un.setActionName("rental");
			un.setActionStatus("Due");
			un.setBookActionPerformedOn(rh.getRentalDetail().getBookOwner());
			un.setUser(rh.getRentalDetail().getBookOwner().getUser());
			un.setUserPerformer(rh.getUserId());

			userNotificationDao.save(un);
			pusherServer.sendNotification(un);
		}
	}

	@Transactional
	@Scheduled(fixedRate = 1500000)
	public void checkAuctionEndDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		List<AuctionDetail> auctionDetailEndDates = auctionDetailDao.getAuctionEndDate();
		UserNotification un;
		for (AuctionDetail rh : auctionDetailEndDates) {
			un = new UserNotification();

			un.setActionId(rh.getAuctionDetailId());
			un.setActionName("auction");
			un.setActionStatus("Stop");
			un.setBookActionPerformedOn(rh.getBookOwner());
			AuctionComment modelComment = auctionCommentDao.getMaximumBid((int) rh.getAuctionDetailId());
			un.setUserPerformer(modelComment.getUser());
			un.setUser(rh.getBookOwner().getUser());
			
			
			userNotificationDao.save(un);
			pusherServer.sendNotification(un);
		}
	}
	
	@Transactional
	@Scheduled(fixedRate = 1500000)
	public void checkToDeliver() {
		/*SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		List<RentalHeader> rentalHeadersWithElapsedEndDates = rentalHeaderDao.getToDeliverToday();
		UserNotification un;
		for (RentalHeader rh : rentalHeadersWithElapsedEndDates) {
			rentalHeaderDao.setApprovedExam(rh.getRentalHeaderId(), "Due", format.format(new Date()));
			
			un = new UserNotification();

			un.setActionId(rh.getRentalHeaderId());
			un.setActionName("rental");
			un.setActionStatus("To receive");
			un.setBookActionPerformedOn(rh.getRentalDetail().getBookOwner());
			un.setUser(rh.getUserId());
			un.setUserPerformer(rh.getRentalDetail().getBookOwner().getUser());

			userNotificationDao.save(un);
			pusherServer.sendNotification(un);

			un = new UserNotification();
			un.setActionId(rh.getRentalHeaderId());
			un.setActionName("rental");
			un.setActionStatus("To deliver");
			un.setBookActionPerformedOn(rh.getRentalDetail().getBookOwner());
			un.setUser(rh.getRentalDetail().getBookOwner().getUser());
			un.setUserPerformer(rh.getUserId());

			userNotificationDao.save(un);
			pusherServer.sendNotification(un);
		}*/
	}
}
