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
import com.koobym.model.BookOwnerRating;
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
	
	@Override
	public Double averageRatingOfBookOwner(long bookOwnerId) {
		
		List<BookOwnerReview> flag = bookOwnerReviewDao.averageRatingOfBookOwner(bookOwnerId);
		Double average = 0.0;
		if (flag.size() > 0) {
			long total = 0;
			for (BookOwnerReview bor : flag) {
				total += bor.getRate().getRateNumber();
			}
			average = (double) (total / flag.size());
		}

		return average;
	}

}
