package com.koobym.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.dao.BookOwnerDao;
import com.koobym.dao.BookOwnerReviewDao;
import com.koobym.dao.UserDao;
import com.koobym.model.Author;
import com.koobym.model.BookOwner;
import com.koobym.model.BookOwnerReview;
import com.koobym.model.User;
import com.koobym.service.BookOwnerReviewService;
import com.koobym.service.BookOwnerService;
import com.koobym.service.BookService;
import com.koobym.service.UserService;

@Service
@Transactional
public class BookOwnerReviewServiceImpl extends BaseServiceImpl<BookOwnerReview, Long>
		implements BookOwnerReviewService {

	private BookOwnerReviewDao bookOwnerReviewDao;

	@Autowired
	public BookOwnerReviewServiceImpl(BookOwnerReviewDao bookOwnerReviewDao) {
		super(bookOwnerReviewDao);
		this.bookOwnerReviewDao = bookOwnerReviewDao;
	}

	@Override
	public List<BookOwnerReview> getReviewsOfBookOwner(long bookOwnerId) {
		return bookOwnerReviewDao.getReviewsOfBookOwner(bookOwnerId);
	}

}
