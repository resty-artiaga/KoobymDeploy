package com.koobym.dao;

import com.koobym.model.BookOwner;

public interface BookOwnerDao extends BaseDao<BookOwner, Long> {

	public BookOwner setBookOwner(long bookOwnerId, long userId);	
}
