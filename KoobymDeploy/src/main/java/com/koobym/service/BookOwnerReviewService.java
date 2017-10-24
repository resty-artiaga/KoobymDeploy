package com.koobym.service;

import java.util.List;

import com.koobym.model.BookOwner;
import com.koobym.model.BookOwnerRating;
import com.koobym.model.BookOwnerReview;

public interface BookOwnerReviewService extends BaseService<BookOwnerReview, Long> {
	public List<BookOwnerReview> getReviewsOfBookOwner(long bookOwnerId);
	public Double averageRatingOfBookOwner(long bookOwnerId);
}
