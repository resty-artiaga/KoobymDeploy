package com.koobym.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.dao.BookOwnerDao;
import com.koobym.dao.BookOwnerRatingDao;
import com.koobym.dao.UserDao;
import com.koobym.model.Author;
import com.koobym.model.BookOwner;
import com.koobym.model.BookOwnerRating;
import com.koobym.model.User;
import com.koobym.service.BookOwnerRatingService;
import com.koobym.service.BookOwnerService;
import com.koobym.service.BookService;
import com.koobym.service.UserService;

@Service
@Transactional
public class BookOwnerRatingServiceImpl extends BaseServiceImpl<BookOwnerRating, Long>
		implements BookOwnerRatingService {

	private BookOwnerRatingDao bookOwnerRatingDao;

	@Autowired
	public BookOwnerRatingServiceImpl(BookOwnerRatingDao bookOwnerRatingDao) {
		super(bookOwnerRatingDao);
		this.bookOwnerRatingDao = bookOwnerRatingDao;
	}

	@Override
	public Double averageRatingOfBookOwner(long bookOwnerId) {
		
		List<BookOwnerRating> flag = bookOwnerRatingDao.averageRatingOfBookOwner(bookOwnerId);
		Double average = 0.0;
		if (flag.size() > 0) {
			long total = 0;
			for (BookOwnerRating bor : flag) {
				total += bor.getRate().getRateNumber();
			}
			average = (double) (total / flag.size());
		}

		return average;
	}

}
