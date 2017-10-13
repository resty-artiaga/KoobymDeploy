package com.koobym.service;

import com.koobym.model.Book;

public interface BookService extends BaseService<Book, Long> {
	public Book addNewBook(Book book);
}
