package com.koobym.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.dao.BookDao;
import com.koobym.dao.UserDao;
import com.koobym.model.Book;
import com.koobym.model.User;
import com.koobym.service.BookService;
import com.koobym.service.UserService;

@Service
@Transactional
public class BookServiceImpl extends BaseServiceImpl<Book, Long> implements BookService {

	private BookDao bookDao;

	@Autowired
	public BookServiceImpl(BookDao bookDao) {
		super(bookDao);
		this.bookDao = bookDao;
	}

}
