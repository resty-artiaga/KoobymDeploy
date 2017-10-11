package com.koobym.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.BookOwnerDao;
import com.koobym.dao.BookOwnerRatingDao;
import com.koobym.dao.BookOwnerReviewDao;
import com.koobym.dao.UserDao;
import com.koobym.model.BookOwner;
import com.koobym.model.BookOwnerRating;
import com.koobym.model.BookOwnerReview;
import com.koobym.model.User;

@Repository
public class BookOwnerReviewDaoImpl extends BaseDaoImpl<BookOwnerReview, Long> implements BookOwnerReviewDao {

	public BookOwnerReviewDaoImpl() {
		super(BookOwnerReview.class);
	}

	@Override
	public List<BookOwnerReview> getReviewsOfBookOwner(long bookOwnerId) {

		List<BookOwnerReview> flag = null;

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(BookOwnerReview.class);
		criteria = criteria.add(Restrictions.eq("bookOwner.book_ownerId", bookOwnerId));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<BookOwnerReview>) criteria.list();

		return flag;
	}
}
