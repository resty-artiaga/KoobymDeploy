package com.koobym.dao;

import java.util.List;

import com.koobym.model.Book;
import com.koobym.model.BookOwnerRating;
import com.koobym.model.BookOwnerReview;

public interface BookOwnerReviewDao extends BaseDao<BookOwnerReview, Long> {
	public List<BookOwnerReview> getReviewsOfBookOwner(long bookOwnerId);
}
