package com.koobym.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koobym.dao.RentalHeaderDao;
import com.koobym.dao.UserNotificationDao;
import com.koobym.model.RentalHeader;
import com.koobym.model.User;
import com.koobym.model.UserNotification;
import com.koobym.pusher.PusherServer;

@Repository
public class UserNotificationDaoImpl extends BaseDaoImpl<UserNotification, Long> implements UserNotificationDao {

	@Autowired
	private RentalHeaderDao rentalHeaderDao;
	
	@Autowired
	private PusherServer pusherServer;
	
	@Autowired
	private UserNotificationDao userNotificationDao;
	
	public UserNotificationDaoImpl() {
		super(UserNotification.class);
	}

	@Override
	public List<UserNotification> getUserNotificationsForUser(long userId) {
		List<UserNotification> flag = new ArrayList<UserNotification>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(UserNotification.class);
		criteria = criteria.add(Restrictions.eq("user.userId", userId));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria = criteria.addOrder(Order.desc("userNotificationId"));
		flag = (List<UserNotification>) criteria.list();
		return flag;
	}

	@Override
	public void notificationIsRead(long userNotificationId) {
		UserNotification userNotif = get(userNotificationId);
		userNotif.setRead(true);
		update(userNotif);
	}
	
	@Override
	public UserNotification sendEarlyNotif(long rentalHeaderId){
		UserNotification un = new UserNotification();
		RentalHeader rentalHeader = new RentalHeader();
		
		rentalHeader = rentalHeaderDao.get(rentalHeaderId);
		
		un.setActionId(rentalHeader.getRentalHeaderId());
		un.setActionName("rental");
		un.setUser(rentalHeader.getRentalDetail().getBookOwner().getUser());
		un.setActionStatus("EarlyNotif");
		un.setUserPerformer(rentalHeader.getUserId());
		un.setBookActionPerformedOn(rentalHeader.getRentalDetail().getBookOwner());
		un.setExtraMessage("Confirmation");
		
		
		userNotificationDao.save(un);
		pusherServer.sendNotification(un);
		
		return un;
		
	}
	
	@Override
	public UserNotification confirmEarlyNotif(long rentalHeaderId){
		UserNotification un = new UserNotification();
		RentalHeader rentalHeader = new RentalHeader();
		
		rentalHeader = rentalHeaderDao.get(rentalHeaderId);
		
		rentalHeader.getRentalDetail().getBookOwner().setBookStat("Available");
		
		un.setActionId(rentalHeader.getRentalHeaderId());
		un.setActionName("rental");
		un.setUserPerformer(rentalHeader.getRentalDetail().getBookOwner().getUser());
		un.setActionStatus("return-confirmed");
		un.setUser(rentalHeader.getUserId());
		un.setBookActionPerformedOn(rentalHeader.getRentalDetail().getBookOwner());
		un.setExtraMessage("Confirm");
		
		
		
		userNotificationDao.save(un);
		pusherServer.sendNotification(un);
		
		return un;
		
	}
	
	@Override
	public UserNotification rejectEarlyNotif(long rentalHeaderId){
		UserNotification un = new UserNotification();
		RentalHeader rentalHeader = new RentalHeader();
		
		rentalHeader = rentalHeaderDao.get(rentalHeaderId);
		
		rentalHeader.getRentalDetail().getBookOwner().setBookStat("Not Available");
		
		un.setActionId(rentalHeader.getRentalHeaderId());
		un.setActionName("rental");
		un.setUserPerformer(rentalHeader.getRentalDetail().getBookOwner().getUser());
		un.setActionStatus("return-rejected");
		un.setUser(rentalHeader.getUserId());
		un.setBookActionPerformedOn(rentalHeader.getRentalDetail().getBookOwner());
		un.setExtraMessage("Reject");
		
		
		
		userNotificationDao.save(un);
		pusherServer.sendNotification(un);
		
		return un;
		
	}

}
