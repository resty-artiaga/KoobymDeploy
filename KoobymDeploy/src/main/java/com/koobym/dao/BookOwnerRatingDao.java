package com.koobym.dao;

import java.util.List;

import com.koobym.model.Book;
import com.koobym.model.BookOwnerRating;

public interface BookOwnerRatingDao extends BaseDao<BookOwnerRating, Long> {
	public List<BookOwnerRating> averageRatingOfBookOwner(long bookOwnerId);
}
