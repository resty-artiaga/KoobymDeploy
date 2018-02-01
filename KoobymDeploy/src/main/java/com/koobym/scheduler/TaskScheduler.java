package com.koobym.scheduler;

import java.text.DateFormat;
import java.text.ParseException;
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
import com.koobym.model.AuctionHeader;
import com.koobym.model.RentalHeader;
import com.koobym.model.UserNotification;
import com.koobym.pusher.PusherServer;

@Component
public class TaskScheduler {

	@Autowired
	private RentalHeaderDao rentalHeaderDao;

	@Autowired
	private AuctionHeaderDao auctionHeaderDao;
	
	@Autowired
	private AuctionCommentDao auctionCommentDao;

	@Autowired
	private AuctionDetailDao auctionDetailDao;

	@Autowired
	private UserNotificationDao userNotificationDao;

	@Autowired
	private PusherServer pusherServer;

	@Transactional
	@Scheduled(fixedRate = 60000)
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
	@Scheduled(fixedRate = 60000)
	public void changeAuctionStatus() throws ParseException {


		System.out.println("agi siya nganhi");

		Date date = new Date();
		String stdDateFormat = "hh:mm a";
		DateFormat dateFormat = new SimpleDateFormat(stdDateFormat);
		String formattedData = dateFormat.format(date);
		System.out.println("ang time kay : " + formattedData);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateDate = new Date();
		String formattedDate = formatter.format(dateDate);
		System.out.println("ang date kay : " + formattedDate);

		List<AuctionDetail> auctionDetailStartDates = auctionDetailDao.getAuctionStartDate();
		System.out.println("size niya = " + auctionDetailStartDates.size());

		for (AuctionDetail ad : auctionDetailStartDates) {
			System.out.println("inside loop");

			if(ad.getStartDate().equals(formattedDate)) {
				System.out.println("compare ni Start: " + ad.getStartDate()+", "+formattedDate);	
//				System.out.println("status, parehas silag date, startDate, "+formattedDate);
//				
				if(formattedData.equals(ad.getStartTime())){
					System.out.println("sulod sa Start Time");
					ad.setAuctionStatus("start");
					auctionDetailDao.save(ad);
				}
//				
			}else if(ad.getEndDate().equals(formattedDate)){
				System.out.println("compare ni End: " + ad.getEndDate()+", "+formattedDate);
				
//				System.out.println("status, parehas silag date, endDate, "+formattedDate);	
//				
				if(formattedData.equals(ad.getEndTime())){
					ad.setAuctionStatus("stop");
					System.out.println("sulod sa End Time");
					ad.getBookOwner().setStatus("none");
					auctionDetailDao.save(ad);
				}
//								
			}
			
			

		}
	}

	@Transactional
	@Scheduled(fixedRate = 60000)
	public void sendEndAuctionNotif() {
		System.out.println("nagdagan");

		Date date = new Date();
		String stdDateFormat = "hh:mm a";
		DateFormat dateFormat = new SimpleDateFormat(stdDateFormat);
		String formattedData = dateFormat.format(date);
		System.out.println("notifTime kay : " + formattedData);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateDate = new Date();
		String formattedDate = formatter.format(dateDate);
		System.out.println("notifDate kay : " + formattedDate);

		List<AuctionDetail> auctionDetailEndDates = auctionDetailDao.getAuctionEndDate();
		System.out.println("kuan = " + auctionDetailEndDates.size());
		UserNotification un, unO;

		for (AuctionDetail rh : auctionDetailEndDates) {			
			System.out.println("nisulod siya sa for loop");

			if (formattedDate.equals(rh.getEndDate())) {

				System.out.println("sulod sa end date");

				System.out.println("formatted:" + formattedData + "rh time:" + rh.getEndTime());

				if (formattedData.equals(rh.getEndTime())) {
					System.out.println("sulod sa rh : " + rh.getEndDate());
					List<AuctionComment> modelComments = auctionCommentDao.getMaximumBid((int) rh.getAuctionDetailId());
					System.out.println("after getting maximum bid");

					for (int i = 0; i < modelComments.size(); i++) {
						AuctionHeader ah = new AuctionHeader();
						ah = auctionHeaderDao.getAuctionHeader(rh.getAuctionDetailId(), modelComments.get(i).getUser().getUserId());
						un = new UserNotification();
						un.setActionId(ah.getAuctionHeaderId());
						un.setActionName("auction");
						un.setBookActionPerformedOn(rh.getBookOwner());
						un.setUser(modelComments.get(i).getUser());
						un.setUserPerformer(rh.getBookOwner().getUser());
						String message = String.valueOf(modelComments.get(i).getAuctionComment());
						if (i == 0) {
							un.setActionStatus("win");
							un.setExtraMessage(message);
							
							
							unO = new UserNotification();
							unO.setUser(rh.getBookOwner().getUser());
							unO.setBookActionPerformedOn(rh.getBookOwner());
							unO.setActionId(ah.getAuctionHeaderId());
							unO.setActionName("auction");
							unO.setActionStatus("own");
							unO.setUserPerformer(modelComments.get(i).getUser());
							unO.setExtraMessage(message);
							
							userNotificationDao.save(unO);
							pusherServer.sendNotification(unO);
						} else {
							un.setActionStatus("lose");
							un.setExtraMessage(message);
						}
						userNotificationDao.save(un);
						pusherServer.sendNotification(un);
					}
					
					
				}
			}
		}
	}

	@Transactional
	@Scheduled(fixedRate = 1500000)
	public void checkToDeliver() {
		/*
		 * SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		 * List<RentalHeader> rentalHeadersWithElapsedEndDates =
		 * rentalHeaderDao.getToDeliverToday(); UserNotification un; for
		 * (RentalHeader rh : rentalHeadersWithElapsedEndDates) {
		 * rentalHeaderDao.setApprovedExam(rh.getRentalHeaderId(), "Due",
		 * format.format(new Date()));
		 * 
		 * un = new UserNotification();
		 * 
		 * un.setActionId(rh.getRentalHeaderId()); un.setActionName("rental");
		 * un.setActionStatus("To receive");
		 * un.setBookActionPerformedOn(rh.getRentalDetail().getBookOwner());
		 * un.setUser(rh.getUserId());
		 * un.setUserPerformer(rh.getRentalDetail().getBookOwner().getUser());
		 * 
		 * userNotificationDao.save(un); pusherServer.sendNotification(un);
		 * 
		 * un = new UserNotification(); un.setActionId(rh.getRentalHeaderId());
		 * un.setActionName("rental"); un.setActionStatus("To deliver");
		 * un.setBookActionPerformedOn(rh.getRentalDetail().getBookOwner());
		 * un.setUser(rh.getRentalDetail().getBookOwner().getUser());
		 * un.setUserPerformer(rh.getUserId());
		 * 
		 * userNotificationDao.save(un); pusherServer.sendNotification(un); }
		 */
	}
}
