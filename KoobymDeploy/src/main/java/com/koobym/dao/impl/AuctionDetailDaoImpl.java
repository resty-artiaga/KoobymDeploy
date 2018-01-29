package com.koobym.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.AuctionDetailDao;
import com.koobym.model.BookOwner;
import com.koobym.model.RentalHeader;
import com.koobym.model.AuctionDetail;

@Repository
public class AuctionDetailDaoImpl extends BaseDaoImpl<AuctionDetail, Long> implements AuctionDetailDao {

	public AuctionDetailDaoImpl() {
		super(AuctionDetail.class);
	}

//	@Override
//	public List<AuctionDetail> mostRentedBooks() {
//		List<AuctionDetail> flag = null;
//		Session session = getSessionFactory().getCurrentSession();
//		flag = (List<AuctionDetail>) session.createCriteria(AuctionDetail.class).createAlias("bookOwner", "b")
//				.addOrder(Order.desc("b.noRenters")).list();
//		return flag;
//	}

	/*
	 * String squery =
	 * "SELECT * FROM rental_detail JOIN book_owner ON rental_detail.bookOwnerId = book_owner.book_ownerId ORDER BY book_owner.noRenters DESC"
	 * ; SQLQuery query = session.createSQLQuery(squery);
	 * query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP); Map<String,
	 * Object> row = null; List<Object> data = query.list(); RentalDetail temp;
	 * for (Object object : data) { row = (Map<String, Object>) object; temp =
	 * new RentalDetail(); temp.setRental_detailId((int)
	 * row.get("rental_detailId")); temp.setCalculatedPrice(new Double((float)
	 * row.get("calculatedPrice"))); temp.setDaysForRent((int)
	 * row.get("daysForRent")); temp.setBookOwner(new BookOwner());
	 * temp.getBookOwner().setBook_OwnerId((int) row.get("bookOwnerId"));
	 * Hibernate.initialize(temp.getBookOwner()); flag.add(temp); } return flag;
	 */

//	public List<AuctionDetail> suggestedBooksByGenre(int userId) {
//		List<AuctionDetail> flag = new ArrayList<AuctionDetail>();
//		Session session = getSessionFactory().getCurrentSession();
//		String squery = "select * from rental_detail  JOIN 	(select book_ownerId from book_owner join "
//				+ "(SELECT bookId, count(genre_bookId) " + "FROM genre_book JOIN genre_user "
//				+ "ON genre_book.genreId = genre_user.genreId  " + "WHERE genre_user.userId = :userId "
//				+ "GROUP BY bookId ORDER BY 2 desc) " + "as suggested_books "
//				+ "on book_owner.bookId = suggested_books.bookId) " + "as suggested_user_books "
//				+ "ON rental_detail.bookOwnerId = suggested_user_books.book_ownerId "
//				+ "LEFT JOIN (select avg(rate.rateNumber) as rate, "
//				+ "book_owner_rating.book_ownerId as boi from rate " + "JOIN book_owner_rating "
//				+ "on rate.rateId = book_owner_rating.rateId " + "group by book_owner_rating.book_ownerId) as ratings "
//				+ "on ratings.boi = suggested_user_books.book_ownerId " + "order by rate desc";
//		SQLQuery query = session.createSQLQuery(squery);
//		query.setInteger("userId", userId);
//		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
//		Map<String, Object> row = null;
//		List<Object> data = query.list();
//		AuctionDetail temp;
//		for (Object object : data) {
//			row = (Map<String, Object>) object;
//			temp = new AuctionDetail();
//			temp.setRental_detailId((int) row.get("rental_detailId"));
//			temp.setCalculatedPrice(new Double((float) row.get("calculatedPrice")));
//			temp.setDaysForRent((int) row.get("daysForRent"));
//			temp.setBookOwner(new BookOwner());
//			temp.getBookOwner().setBook_OwnerId((int) row.get("bookOwnerId"));
//			Hibernate.initialize(temp.getBookOwner());
//			flag.add(temp);
//		}
//
//		return flag;
//	}

//	@Override
//	public List<RentalDetail> getAllForRentOrderByRate() {
//		List<RentalDetail> flag = new ArrayList<RentalDetail>();
//		Session session = getSessionFactory().getCurrentSession();
//		String squery = "select * from rental_detail left join (select avg(rate.rateNumber) as rate, "
//				+ "book_owner_rating.book_ownerId "
//				+ "as boi from rate JOIN book_owner_rating on rate.rateId = book_owner_rating.rateId "
//				+ "group by book_owner_rating.book_ownerId) "
//				+ "as rates on rental_detail.bookOwnerId = rates.boi order by rates.rate desc;";
//		SQLQuery query = session.createSQLQuery(squery);
//		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
//		Map<String, Object> row = null;
//		List<Object> data = query.list();
//		RentalDetail temp;
//		for (Object object : data) {
//			row = (Map<String, Object>) object;
//			temp = new RentalDetail();
//			temp.setRental_detailId((int) row.get("rental_detailId"));
//			temp.setCalculatedPrice(new Double((float) row.get("calculatedPrice")));
//			temp.setDaysForRent((int) row.get("daysForRent"));
//			temp.setBookOwner(new BookOwner());
//			temp.getBookOwner().setBook_OwnerId((int) row.get("bookOwnerId"));
//			Hibernate.initialize(temp.getBookOwner());
//			flag.add(temp);
//		}
//
//		return flag;
//	}

	public List<AuctionDetail> getAuctionById(int userId) {
		List<AuctionDetail> flag = new ArrayList<AuctionDetail>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(AuctionDetail.class);
		criteria = criteria.createAlias("bookOwner", "bookOwner");
		criteria = criteria.add(Restrictions.eq("bookOwner.user.userId", new Long(userId)));
		flag = (List<AuctionDetail>) criteria.list();
		return flag;
	}

	public List<AuctionDetail> getAuctionEndDate(){
		List<AuctionDetail> flag = new ArrayList<AuctionDetail>();
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(AuctionDetail.class);
//		criteria = criteria.add(Restrictions.ge("endDate", new Date()));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<AuctionDetail>) criteria.list();
		return flag;
	}

	public AuctionDetail getAuctionDetail(long bookOwnerId) {
		AuctionDetail auctionDetail = new AuctionDetail();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(AuctionDetail.class);
		criteria = criteria.createAlias("bookOwner", "bookOwner");
		criteria = criteria.add(Restrictions.eq("bookOwner.book_ownerId", bookOwnerId));
		auctionDetail = (AuctionDetail) criteria.uniqueResult();

		return auctionDetail;
	}
	
	public List<AuctionDetail> getAuctionStartDate(){
		List<AuctionDetail> flag = new ArrayList<AuctionDetail>();
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(AuctionDetail.class);
//		criteria = criteria.add(Restrictions.ge("startDate", new Date()));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<AuctionDetail>) criteria.list();
		return flag;
	}

	public List<AuctionDetail> getAuctionStartTime(){
		List<AuctionDetail> flag = new ArrayList<AuctionDetail>();
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(AuctionDetail.class);
		criteria = criteria.add(Restrictions.ge("startTime", new String()));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<AuctionDetail>) criteria.list();
		return flag;
	}
	
	public List<AuctionDetail> getAuctionEndTime(){
		List<AuctionDetail> flag = new ArrayList<AuctionDetail>();
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(AuctionDetail.class);
		criteria = criteria.add(Restrictions.ge("endTime", new String()));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<AuctionDetail>) criteria.list();
		return flag;
	}
//	public void updateAuctionD(RentalDetail t) {
//		getSessionFactory().getCurrentSession().flush();
//		getSessionFactory().getCurrentSession().update(t);
//	}
	// public List<RentalDetail> getRentalById(int userId) {
	// List<RentalDetail> flag = new ArrayList<RentalDetail>();
	// Session session = getSessionFactory().getCurrentSession();
	// String squery = "select * from rental_detail INNER JOIN book_owner on
	// (select * from book_owner WHERE book_owner.userId = :userId)";
	// SQLQuery query = session.createSQLQuery(squery);
	// query.setInteger("userId", userId);
	// query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	// Map<String, Object> row = null;
	// List<Object> data = query.list();
	// RentalDetail temp;
	// for (Object object : data) {
	// row = (Map<String, Object>) object;
	// temp = new RentalDetail();
	// temp.setRental_detailId((int) row.get("rental_detailId"));
	// temp.setCalculatedPrice(new Double((float) row.get("calculatedPrice")));
	// temp.setDaysForRent((int) row.get("daysForRent"));
	// temp.setBookOwner(new BookOwner());
	// temp.getBookOwner().setBook_OwnerId((int) row.get("bookOwnerId"));
	// Hibernate.initialize(temp.getBookOwner());
	// flag.add(temp);
	// }
	//
	// return flag;
	// }
}
