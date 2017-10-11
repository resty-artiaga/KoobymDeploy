package com.koobym.service;

import com.koobym.model.BookOwner;
import com.koobym.model.BookOwnerRating;

public interface BookOwnerRatingService extends BaseService<BookOwnerRating, Long> {
	public Double averageRatingOfBookOwner(long bookOwnerId);
}
