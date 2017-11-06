package com.koobym.service;

import java.util.List;

import com.koobym.dto.Transaction;
import com.koobym.model.BookOwner;

public interface BookOwnerService extends BaseService<BookOwner, Long> {

	public List<BookOwner> allDistinct();

	public BookOwner setBookOwner(long bookOwnerId, long userId);

	public List<BookOwner> getMyBooksById(int userId);

	public BookOwner increment(long bookOwnerId);

	public List<BookOwner> getStatusById();

	public List<Transaction> bookTransactions(long bookOwnerId);
}
