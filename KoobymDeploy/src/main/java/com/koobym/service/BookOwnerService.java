package com.koobym.service;

import java.util.List;

import com.koobym.model.BookOwner;

public interface BookOwnerService extends BaseService<BookOwner, Long> {

	public BookOwner setBookOwner(long bookOwnerId, long userId);
	public List<BookOwner> getMyBooksById(int userId);
	public BookOwner increment(long bookOwnerId);
}
