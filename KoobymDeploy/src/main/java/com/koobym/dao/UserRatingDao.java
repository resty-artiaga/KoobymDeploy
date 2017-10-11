package com.koobym.dao;

import java.util.List;


import java.util.Set;

import com.koobym.model.BookOwnerRating;
import com.koobym.model.UserRating;
import com.koobym.model.UserRental;

public interface UserRatingDao extends BaseDao<UserRating, Long> {
	public List<UserRating> userRatingOfUser(long userId);
}
