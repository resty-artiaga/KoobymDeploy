package com.koobym.service;

import java.util.List;

import com.koobym.model.UserRating;
import com.koobym.model.UserRental;

public interface UserRatingService extends BaseService<UserRating, Long> {
	public Double averageRatingOfUser(long userId);
	public List<UserRating> userRatingsOfUser(long userId);
}
