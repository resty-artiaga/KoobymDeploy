package com.koobym.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.model.BookOwnerRating;
import com.koobym.model.RentalDetail;
import com.koobym.model.UserRating;
import com.koobym.model.UserRental;
import com.koobym.service.UserRatingService;
import com.koobym.service.UserRentalService;
import com.koobym.dao.UserRatingDao;
import com.koobym.dao.UserRentalDao;

@Service
@Transactional
public class UserRatingServiceImpl extends BaseServiceImpl<UserRating, Long> implements UserRatingService {

	private UserRatingDao userRatingDao;

	@Autowired
	public UserRatingServiceImpl(UserRatingDao userRatingDao) {
		super(userRatingDao);
		this.userRatingDao = userRatingDao;
	}

	@Override
	public Double averageRatingOfUser(long userId) {

		List<UserRating> flag = userRatingDao.userRatingOfUser(userId);
		Double average = 0.0;
		if (flag.size() > 0) {
			long total = 0;
			for (UserRating bor : flag) {
				total += bor.getRate().getRateNumber();
			}
			average = (double) (total / flag.size());
		}

		return average;
	}

	@Override
	public List<UserRating> userRatingsOfUser(long userId) {
		return userRatingDao.userRatingOfUser(userId);
	}

}
