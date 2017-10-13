package com.koobym.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.BookOwnerDao;
import com.koobym.dao.RentalDetailDao;
import com.koobym.dao.UserDao;
import com.koobym.model.BookOwner;
import com.koobym.model.Genre;
import com.koobym.model.RentalDetail;
import com.koobym.model.User;

@Repository
public class RentalDetailDaoImpl extends BaseDaoImpl<RentalDetail, Long> implements RentalDetailDao {

	public RentalDetailDaoImpl() {
		super(RentalDetail.class);
	}

	@Override
	public List<RentalDetail> mostRentedBooks() {
		List<RentalDetail> flag = null;
		Session session = getSessionFactory().getCurrentSession();
		flag = (List<RentalDetail>) session.createCriteria(RentalDetail.class).createAlias("bookOwner", "b").addOrder(Order.desc("b.noRenters")).list();
		return flag;
	}
	
	/*String squery = "SELECT * FROM rental_detail JOIN book_owner ON rental_detail.bookOwnerId = book_owner.book_ownerId ORDER BY book_owner.noRenters DESC";
	SQLQuery query = session.createSQLQuery(squery);
	query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	Map<String, Object> row = null;
	List<Object> data = query.list();
	RentalDetail temp;
	for (Object object : data) {
		row = (Map<String, Object>) object;
		temp = new RentalDetail();
		temp.setRental_detailId((int) row.get("rental_detailId"));
		temp.setCalculatedPrice(new Double((float) row.get("calculatedPrice")));
		temp.setDaysForRent((int) row.get("daysForRent"));
		temp.setBookOwner(new BookOwner());
		temp.getBookOwner().setBook_OwnerId((int) row.get("bookOwnerId"));
		Hibernate.initialize(temp.getBookOwner());
		flag.add(temp);
	}
	return flag;*/

	public List<RentalDetail> suggestedBooksByGenre(int userId) {
		List<RentalDetail> flag = new ArrayList<RentalDetail>();
		Session session = getSessionFactory().getCurrentSession();		
		String squery = "select * from rental_detail  JOIN 	(select book_ownerId from book_owner join (SELECT bookId, count(genre_bookId) FROM genre_book JOIN genre_user ON genre_book.genreId = genre_user.genreId  WHERE genre_user.userId = :userId GROUP BY bookId ORDER BY 2 desc) as suggested_books "
				+ "on book_owner.bookId = suggested_books.bookId) as suggested_user_books ON rental_detail.bookOwnerId = suggested_user_books.book_ownerId "				
				+ "JOIN (select avg(rate.rateNumber) as rate, book_owner_rating.book_ownerId  as boi from rate JOIN book_owner_rating on rate.rateId = book_owner_rating.rateId group by book_owner_rating.book_ownerId) "
				+ "as ratings on ratings.boi = suggested_user_books.book_ownerId order by rate desc";
		SQLQuery query = session.createSQLQuery(squery);
		query.setInteger("userId", userId);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		Map<String, Object> row = null;
		List<Object> data = query.list();
		RentalDetail temp;
		for (Object object : data) {
			row = (Map<String, Object>) object;
			temp = new RentalDetail();
			temp.setRental_detailId((int) row.get("rental_detailId"));
			temp.setCalculatedPrice(new Double((float) row.get("calculatedPrice")));
			temp.setDaysForRent((int) row.get("daysForRent"));
			temp.setBookOwner(new BookOwner());
			temp.getBookOwner().setBook_OwnerId((int) row.get("bookOwnerId"));
			Hibernate.initialize(temp.getBookOwner());
			flag.add(temp);
		}

		return flag;
	}
	
	
	@Override
	public List<RentalDetail> getAllForRentOrderByRate(){
		List<RentalDetail> flag = new ArrayList<RentalDetail>();
		Session session = getSessionFactory().getCurrentSession();		
		String squery = "select * from rental_detail left join (select avg(rate.rateNumber) as rate, book_owner_rating.book_ownerId "
				+ "as boi from rate JOIN book_owner_rating on rate.rateId = book_owner_rating.rateId group by book_owner_rating.book_ownerId) "
				+ "as rates on rental_detail.bookOwnerId = rates.boi order by rates.rate desc;";
		SQLQuery query = session.createSQLQuery(squery);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		Map<String, Object> row = null;
		List<Object> data = query.list();
		RentalDetail temp;
		for (Object object : data) {
			row = (Map<String, Object>) object;
			temp = new RentalDetail();
			temp.setRental_detailId((int) row.get("rental_detailId"));
			temp.setCalculatedPrice(new Double((float) row.get("calculatedPrice")));
			temp.setDaysForRent((int) row.get("daysForRent"));
			temp.setBookOwner(new BookOwner());
			temp.getBookOwner().setBook_OwnerId((int) row.get("bookOwnerId"));
			Hibernate.initialize(temp.getBookOwner());
			flag.add(temp);
		}

		return flag;
	}
	
	public List<RentalDetail> getRentalById(int userId) {
		List<RentalDetail> flag = new ArrayList<RentalDetail>();
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalDetail.class);
		criteria = criteria.createAlias("bookOwner", "bookOwner");
		criteria = criteria.add(Restrictions.eq("bookOwner.user.userId", new Long(userId)));
		flag = (List<RentalDetail>) criteria.list();
		return flag;
	}

//	public List<RentalDetail> getRentalById(int userId) {
//		List<RentalDetail> flag = new ArrayList<RentalDetail>();
//		Session session = getSessionFactory().getCurrentSession();
//		String squery = "select * from rental_detail INNER JOIN book_owner on (select * from book_owner WHERE book_owner.userId = :userId)";
//		SQLQuery query = session.createSQLQuery(squery);
//		query.setInteger("userId", userId);
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
}
