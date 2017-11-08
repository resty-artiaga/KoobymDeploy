package com.koobym.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.RentalHeaderDao;
import com.koobym.model.RentalHeader;

@Repository
public class RentalHeaderDaoImpl extends BaseDaoImpl<RentalHeader, Long> implements RentalHeaderDao {

	public RentalHeaderDaoImpl() {
		super(RentalHeader.class);
	}

	public List<RentalHeader> getListRentalById(int userId) {
		List<RentalHeader> flag = new ArrayList<RentalHeader>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		criteria = criteria.createAlias("user", "user");
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();
		return flag;
	}

	public List<RentalHeader> getListRentalByBookOwnerId(long bookOwnerId) {
		List<RentalHeader> flag = new ArrayList<RentalHeader>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		criteria = criteria.createAlias("rentalDetail", "rentalDetail");
		criteria = criteria.createAlias("rentalDetail.bookOwner", "bookOwner");
		criteria = criteria.add(Restrictions.eq("bookOwner.book_ownerId", bookOwnerId));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();
		return flag;
	}

	public long numberOfCompletedRentsByBookOwnerId(long bookOwnerId) {
		String query = "select count(rentalHeaderId) from rental_header join rental_detail on rental_header.rentalDetailId where rental_detail.bookOwnerId = :bookOwnerId and rental_header.status='COMPLETE'";

		SQLQuery sqlQuery = getSessionFactory().getCurrentSession().createSQLQuery(query);
		sqlQuery.setLong("bookOwnerId", bookOwnerId);
		Object obj = sqlQuery.uniqueResult();
		BigInteger bigIntVal = (BigInteger) obj;

		return bigIntVal.longValue();
	}

	public List<RentalHeader> getToDeliverById(int userId) {

		List<RentalHeader> flag = new ArrayList<RentalHeader>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		criteria = criteria.createAlias("rentalDetail", "rentalDetail");
		criteria = criteria.createAlias("rentalDetail.bookOwner", "bookOwner");
		criteria = criteria.createAlias("rentalDetail.bookOwner.user", "user");
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.add(Restrictions.eq("status", "Approved"));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();
		return flag;

	}

	public List<RentalHeader> getToReceiveByIdRenter(int userId) {

		List<RentalHeader> flag = new ArrayList<RentalHeader>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		criteria = criteria.createAlias("user", "user");
		criteria = criteria.add(Restrictions.eq("status", "Approved"));
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();
		return flag;

	}

	public List<RentalHeader> getToReturnByIdRenter(int userId) {

		List<RentalHeader> flag = new ArrayList<RentalHeader>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		criteria = criteria.createAlias("user", "user");
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.add(Restrictions.eq("status", "Received"));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();
		return flag;

	}

	public List<RentalHeader> getToReturnByIdOwner(int userId) {

		List<RentalHeader> flag = new ArrayList<RentalHeader>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		criteria = criteria.createAlias("rentalDetail", "rentalDetail");
		criteria = criteria.createAlias("rentalDetail.bookOwner", "bookOwner");
		criteria = criteria.createAlias("rentalDetail.bookOwner.user", "user");
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.add(Restrictions.eq("status", "Received"));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();
		return flag;

	}

	public List<RentalHeader> getMyRequestsById(int userId) {

		List<RentalHeader> flag = new ArrayList<RentalHeader>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		/* criteria = criteria.createAlias("user", "user"); */
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.add(Restrictions.eq("status", "Confirmation"));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();
		return flag;

	}

	public List<RentalHeader> getToReceiveByIdOwner(int userId) {

		List<RentalHeader> flag = new ArrayList<RentalHeader>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		criteria = criteria.createAlias("rentalDetail", "rentalDetail");
		criteria = criteria.createAlias("rentalDetail.bookOwner", "bookOwner");
		criteria = criteria.createAlias("rentalDetail.bookOwner.user", "user");
		criteria = criteria.add(Restrictions.eq("status", "Received"));
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();

		return flag;

	}

	public List<RentalHeader> getRequestReceivedById(int userId) {

		List<RentalHeader> flag = new ArrayList<RentalHeader>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		criteria = criteria.createAlias("rentalDetail", "rentalDetail");
		criteria = criteria.createAlias("rentalDetail.bookOwner", "bookOwner");
		criteria = criteria.createAlias("rentalDetail.bookOwner.user", "user");
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.add(Restrictions.eq("status", "Confirmation"));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();
		return flag;
	}

	public RentalHeader setApprovedExam(long rentalHeaderId, String status, String dateApproved) {
		RentalHeader rentalHeader = new RentalHeader();

		Session session = getSessionFactory().getCurrentSession();

		String squery = "";

		if (status.equals("Approved")) {
			squery = "update rental_header set status = :status, dateApproved = :dateApproved where rentalHeaderId = :rentalHeaderId";
		} else if (status.equals("Confirm")) {
			squery = "update rental_header set status = :status, dateConfirmed = :dateApproved where rentalHeaderId = :rentalHeaderId";
		}

		SQLQuery query = session.createSQLQuery(squery);
		query.setString("status", status);
		query.setString("dateApproved", dateApproved);
		query.setLong("rentalHeaderId", rentalHeaderId);
		query.executeUpdate();

		rentalHeader = get(rentalHeaderId);

		return rentalHeader;
	}

	public RentalHeader setMeetUp(long rentalHeaderId, long meetUpId) {
		RentalHeader rentalHeader = new RentalHeader();

		Session session = getSessionFactory().getCurrentSession();
		String squery = "update rental_header set meet_upId = :meetUpId where rentalHeaderId = :rentalHeaderId";

		SQLQuery query = session.createSQLQuery(squery);
		query.setLong("rentalHeaderId", rentalHeaderId);
		query.setLong("meet_upId", meetUpId);
		query.executeUpdate();

		rentalHeader = get(rentalHeaderId);

		return rentalHeader;
	}

	public RentalHeader checkExist(long userId, long rentalDetailId) {
		RentalHeader rentalHeader = new RentalHeader();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		criteria = criteria.createAlias("user", "user");
		criteria = criteria.createAlias("rentalDetail", "rentalDetail");
		criteria = criteria.add(Restrictions.eq("user.userId", userId));
		criteria = criteria.add(Restrictions.eq("rentalDetail.rental_detailId", rentalDetailId));
		rentalHeader = (RentalHeader) criteria.uniqueResult();

		return rentalHeader;
	}

	public RentalHeader setRentalHeader(RentalHeader rentalHeader) {
		RentalHeader rentalHeaderModel = new RentalHeader();

		Session session = getSessionFactory().getCurrentSession();
		String squery = "insert into rental_header (userId, locationId, rentalTimeStamp, totalPrice, status, rentalDetailId)"
				+ "values(rentalHeader.userId, rentalHeader.locationId, rentalHeader.rentalTimeStamp, rentalHeader.price, rentalHeader.status, rentalHeader.rentalDetailId)";

		SQLQuery query = session.createSQLQuery(squery);
		query.executeUpdate();

		rentalHeader = get(rentalHeader.getRentalHeaderId());

		return rentalHeader;
	}

	public List<RentalHeader> getCompleteByIdRenter(int userId) {

		List<RentalHeader> flag = new ArrayList<RentalHeader>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		criteria = criteria.createAlias("user", "user");
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.add(Restrictions.eq("status", "Complete"));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();
		return flag;

	}

	public List<RentalHeader> getRejectedByIdRenter(int userId) {

		List<RentalHeader> flag = new ArrayList<RentalHeader>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		criteria = criteria.createAlias("user", "user");
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.add(Restrictions.eq("status", "Rejected"));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();
		return flag;

	}

	public List<RentalHeader> getCompleteByIdOwner(int userId) {

		List<RentalHeader> flag = new ArrayList<RentalHeader>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		criteria = criteria.createAlias("rentalDetail", "rentalDetail");
		criteria = criteria.createAlias("rentalDetail.bookOwner", "bookOwner");
		criteria = criteria.createAlias("rentalDetail.bookOwner.user", "user");
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.add(Restrictions.eq("status", "Complete"));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();
		return flag;

	}

	public List<RentalHeader> getRejectedByIdOwner(int userId) {

		List<RentalHeader> flag = new ArrayList<RentalHeader>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		criteria = criteria.createAlias("rentalDetail", "rentalDetail");
		criteria = criteria.createAlias("rentalDetail.bookOwner", "bookOwner");
		criteria = criteria.createAlias("rentalDetail.bookOwner.user", "user");
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.add(Restrictions.eq("status", "Rejected"));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();
		return flag;

	}

	public List<RentalHeader> getCompleteByRentalDetail(long rentalDetailId) {

		List<RentalHeader> flag = new ArrayList<RentalHeader>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		criteria = criteria.createAlias("rentalDetail", "rentalDetail");
		criteria = criteria.add(Restrictions.eq("rentalDetail.rental_detailId", new Long(rentalDetailId)));
		criteria = criteria.add(Restrictions.eq("status", "Complete"));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();
		return flag;

	}

	public List<RentalHeader> getRentalHeader(long bookOwnerId) {

		List<RentalHeader> flag = new ArrayList<RentalHeader>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		criteria = criteria.createAlias("rentalDetail", "rentalDetail");
		criteria = criteria.createAlias("rentalDetail.bookOwner", "bookOwner");
		criteria = criteria.add(Restrictions.eq("bookOwner.book_ownerId", new Long(bookOwnerId)));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();
		return flag;

	}

	public List<RentalHeader> getElapsedRentalDate() {
		List<RentalHeader> flag = new ArrayList<RentalHeader>();
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		criteria = criteria.add(Restrictions.ge("rentalEndDate", new Date()));
		criteria = criteria.add(Restrictions.not(Restrictions.eq("status", "Due")));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();
		return flag;
	}

	public List<RentalHeader> getOngoingByOwner(int userId) {

		List<RentalHeader> flag = new ArrayList<RentalHeader>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		criteria = criteria.createAlias("rentalDetail", "rentalDetail");
		criteria = criteria.createAlias("rentalDetail.bookOwner", "bookOwner");
		criteria = criteria.createAlias("rentalDetail.bookOwner.user", "user");
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.add(Restrictions.not(Restrictions.eq("status", "Rejected")));
		criteria = criteria.add(Restrictions.not(Restrictions.eq("status", "Complete")));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();
		return flag;
	}

	public List<RentalHeader> getOngoingRequestsByUser(int userId) {
		List<RentalHeader> flag = new ArrayList<RentalHeader>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RentalHeader.class);
		criteria = criteria.createAlias("user", "user");
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.add(Restrictions.not(Restrictions.eq("status", "Complete")));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<RentalHeader>) criteria.list();
		return flag;
	}

	public void rejectAllOtherRequests(RentalHeader rentalHeader) {

		String sQuery = "update rental_header set Status = 'Rejected' where "
				+ "rental_header.rentalDetailId = :rentalDetailId and rental_header.rentalHeaderId != :rentalHeaderId";

		SQLQuery query = getSessionFactory().getCurrentSession().createSQLQuery(sQuery);
		query.setLong("rentalDetailId", rentalHeader.getRentalDetail().getRental_detailId());
		query.setLong("rentalHeaderId", rentalHeader.getRentalHeaderId());
		query.executeUpdate();
	}

}
