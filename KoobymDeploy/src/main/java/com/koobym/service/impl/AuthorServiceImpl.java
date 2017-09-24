package com.koobym.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.dao.AuthorDao;
import com.koobym.dao.UserDao;
import com.koobym.model.Author;
import com.koobym.model.Book;
import com.koobym.model.User;
import com.koobym.service.AuthorService;
import com.koobym.service.BookService;
import com.koobym.service.UserService;

@Service
@Transactional
public class AuthorServiceImpl extends BaseServiceImpl<Author, Long> implements AuthorService {

	private AuthorDao authorDao;

	@Autowired
	public AuthorServiceImpl(AuthorDao authorDao) {
		super(authorDao);
		this.authorDao = authorDao;
	}



}
