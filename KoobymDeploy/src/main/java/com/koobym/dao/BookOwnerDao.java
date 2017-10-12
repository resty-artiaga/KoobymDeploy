package com.koobym.dao;

import java.util.List;

import com.koobym.model.BookOwner;

public interface BookOwnerDao extends BaseDao<BookOwner, Long> {

	public BookOwner setBookOwner(long bookOwnerId, long userId);	
	public List<BookOwner> getMyBooksById(int userId);
}
