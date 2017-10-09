package com.koobym.service.impl;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.dao.BookOwnerDao;
import com.koobym.dao.UserDao;
import com.koobym.model.Author;
import com.koobym.model.BookOwner;
import com.koobym.model.User;
import com.koobym.service.BookOwnerService;
import com.koobym.service.BookService;
import com.koobym.service.UserService;

@Service
@Transactional
public class BookOwnerServiceImpl extends BaseServiceImpl<BookOwner, Long> implements BookOwnerService {

	private BookOwnerDao bookOwnerDao;

	@Autowired
	public BookOwnerServiceImpl(BookOwnerDao bookOwnerDao) {
		super(bookOwnerDao);
		this.bookOwnerDao = bookOwnerDao;
	}
	

	@Override
	public BookOwner setBookOwner(long bookOwnerId, long userId) {
		return bookOwnerDao.setBookOwner(bookOwnerId, userId);
	}



}
