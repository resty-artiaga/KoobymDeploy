package com.koobym.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.SwapHeaderDao;
import com.koobym.model.SwapHeader;

@Repository
public class SwapHeaderDaoImpl extends BaseDaoImpl<SwapHeader, Long> implements SwapHeaderDao {

	public SwapHeaderDaoImpl() {
		super(SwapHeader.class);
	}

	public List<SwapHeader> getToDeliverById(int userId) {

		List<SwapHeader> flag = new ArrayList<SwapHeader>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(SwapHeader.class);
		criteria = criteria.createAlias("swapDetail", "swapDetail");
		criteria = criteria.createAlias("swapDetail.bookOwner", "bookOwner");
		criteria = criteria.createAlias("swapDetail.bookOwner.user", "user");
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.add(Restrictions.eq("status", "Approved"));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<SwapHeader>) criteria.list();
		return flag;

	}

	public List<SwapHeader> getListSwapHeaderByBookOwnerId(long bookOwnerId) {
		List<SwapHeader> flag = new ArrayList<SwapHeader>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(SwapHeader.class);
		criteria = criteria.createAlias("swapDetail", "swapDetail");
		criteria = criteria.createAlias("swapDetail.bookOwner", "bookOwner");
		criteria = criteria.add(Restrictions.eq("bookOwner.book_ownerId", bookOwnerId));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<SwapHeader>) criteria.list();
		return flag;
	}

	public List<SwapHeader> getCompleteById(int userId) {

		List<SwapHeader> flag = new ArrayList<SwapHeader>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(SwapHeader.class);
		criteria = criteria.createAlias("requestedSwapDetail", "requestedSwapDetail");
		criteria = criteria.createAlias("requestedSwapDetail.bookOwner", "bookOwnerRequested");
		criteria = criteria.createAlias("requestedSwapDetail.bookOwner.user", "userRequested");
		criteria = criteria.add(Restrictions.or(Restrictions.eq("userRequested.userId", new Long(userId)),
				Restrictions.eq("user.userId", new Long(userId))));
		criteria = criteria.add(Restrictions.eq("status", "Complete"));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<SwapHeader>) criteria.list();
		return flag;

	}

	public List<SwapHeader> getToReceiveByIdRenter(int userId) {

		List<SwapHeader> flag = new ArrayList<SwapHeader>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(SwapHeader.class);
		criteria = criteria.createAlias("requestedSwapDetail", "requestedSwapDetail");
		criteria = criteria.createAlias("requestedSwapDetail.bookOwner", "bookOwner");
		criteria = criteria.createAlias("requestedSwapDetail.bookOwner.user", "user");
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.add(Restrictions.eq("status", "Approved"));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<SwapHeader>) criteria.list();
		return flag;

	}

	public List<SwapHeader> getRejectedByIdRenter(int userId) {

		List<SwapHeader> flag = new ArrayList<SwapHeader>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(SwapHeader.class);
		criteria = criteria.createAlias("requestedSwapDetail", "requestedSwapDetail");
		criteria = criteria.createAlias("requestedSwapDetail.bookOwner", "bookOwner");
		criteria = criteria.createAlias("requestedSwapDetail.bookOwner.user", "user");
		criteria = criteria.add(Restrictions.eq("user.userId", new Long(userId)));
		criteria = criteria.add(Restrictions.eq("status", "Rejected"));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<SwapHeader>) criteria.list();
		return flag;

	}

	public List<SwapHeader> getRejectedByIdOwner(int userId) {

		List<SwapHeader> flag = new ArrayList<SwapHeader>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(SwapHeader.class);
		criteria = criteria.createAlias("swapDetail", "swapDetail");
		criteria = criteria.createAlias("swapDetail.bookOwner", "bookOwnerSwap");
		criteria = criteria.createAlias("swapDetail.bookOwner.user", "userSwap");
		criteria = criteria.createAlias("requestedSwapDetail", "requestedSwapDetail");
		criteria = criteria.createAlias("requestedSwapDetail.bookOwner", "bookOwnerRequest");
		criteria = criteria.createAlias("requestedSwapDetail.bookOwner.user", "userRequest");
		criteria = criteria.add(Restrictions.or(Restrictions.eq("userSwap.userId", new Long(userId)),
				Restrictions.eq("userRequest.userId", new Long(userId)),
				Restrictions.eq("user.userId", new Long(userId))));
		criteria = criteria.add(Restrictions.eq("status", "Rejected"));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<SwapHeader>) criteria.list();
		return flag;

	}

	public List<SwapHeader> getCompleteAllById(int userId) {

		List<SwapHeader> flag = new ArrayList<SwapHeader>();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(SwapHeader.class);
		criteria = criteria.createAlias("swapDetail", "swapDetail");
		criteria = criteria.createAlias("swapDetail.bookOwner", "bookOwnerSwap");
		criteria = criteria.createAlias("swapDetail.bookOwner.user", "userSwap");
		criteria = criteria.createAlias("requestedSwapDetail", "requestedSwapDetail");
		criteria = criteria.createAlias("requestedSwapDetail.bookOwner", "bookOwnerRequest");
		criteria = criteria.createAlias("requestedSwapDetail.bookOwner.user", "userRequest");
		criteria = criteria.add(Restrictions.or(Restrictions.eq("userSwap.userId", new Long(userId)),
				Restrictions.eq("userRequest.userId", new Long(userId)),
				Restrictions.eq("user.userId", new Long(userId))));
		criteria = criteria.add(Restrictions.eq("status", "Completed"));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<SwapHeader>) criteria.list();
		return flag;

	}

	public SwapHeader swapRequested(SwapHeader swapHeader) {

		String squery = "insert into swap_header (userId, swap_detailId, locationId, userDayTimeId, dateSwap, status) "
				+ "values(?,?,?,?,?,?)";

		Session session = getSessionFactory().getCurrentSession();

		SQLQuery query = session.createSQLQuery(squery);
		query.setLong(0, swapHeader.getUser().getUserId());
		query.setLong(1, swapHeader.getSwapDetail().getSwapDetailId());
		query.setLong(2, swapHeader.getLocation().getLocationId());
		query.setLong(3, swapHeader.getUserDayTime().getUserDayTimeId());
		query.setString(4, swapHeader.getDateTimeStamp());
		query.setString(5, swapHeader.getStatus());

		query.executeUpdate();

		BigInteger lastId = (BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult();
		System.out.println("last Id" + lastId.longValue());

		swapHeader = retrieveSwapHeader(lastId.longValue());

		return swapHeader;
	}

	public SwapHeader retrieveSwapHeader(long swapheaderId) {
		SwapHeader flag = new SwapHeader();

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(SwapHeader.class);
		criteria = criteria.add(Restrictions.eq("swapHeaderId", new Long(swapheaderId)));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (SwapHeader) criteria.uniqueResult();
		return flag;
	}

	public SwapHeader setApprovedExam(String status, long swapHeaderId, String date) {
		SwapHeader swapHeader = new SwapHeader();

		Session session = getSessionFactory().getCurrentSession();
		String squery = "";

		if (status.equals("Approved")) {
			squery = "update swap_header set status = :status , dateApproved = :date where swapHeaderId = :swapHeaderId";
		} else if (status.equals("Confirm")) {
			squery = "update swap_header set status = :status , dateConfirmed = :date where swapHeaderId = :swapHeaderId";
		} else if (status.equals("Rejected")) {
			squery = "update swap_header set status = :status , dateRejected = :date where swapHeaderId = :swapHeaderId";
		}

		SQLQuery query = session.createSQLQuery(squery);
		query.setString("status", status);
		query.setString("date", date);
		query.setLong("swapHeaderId", swapHeaderId);
		query.executeUpdate();

		swapHeader = get(swapHeaderId);

		return swapHeader;
	}

	@Override
	public List<SwapHeader> getRequestedSwaps(long userId) {
		List<SwapHeader> flag = null;
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(SwapHeader.class);
		criteria = criteria.createAlias("swapDetail.bookOwner", "bookOwner");
		criteria = criteria.createAlias("bookOwner.user", "user");
		criteria = criteria.add(Restrictions.eq("user.userId", userId));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<SwapHeader>) criteria.list();
		return flag;
	}

	public List<SwapHeader> getToApproveSwaps(long userId) {
		List<SwapHeader> flag = null;
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(SwapHeader.class);
		criteria = criteria.createAlias("requestedSwapDetail", "requestedSwapDetail");
		criteria = criteria.createAlias("requestedSwapDetail.bookOwner", "bookOwner");
		criteria = criteria.createAlias("requestedSwapDetail.bookOwner.user", "user");
		criteria = criteria.add(Restrictions.eq("user.userId", userId));
		criteria = criteria.add(Restrictions.eq("status", "APPROVED_BY_REQUESTOR"));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<SwapHeader>) criteria.list();
		return flag;
	}

	public List<SwapHeader> getApprovedSwaps(long userId) {
		List<SwapHeader> flag = null;
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(SwapHeader.class);
		criteria = criteria.createAlias("swapDetail", "swapDetail");
		criteria = criteria.createAlias("swapDetail.bookOwner", "bookOwner");
		criteria = criteria.createAlias("swapDetail.bookOwner.user", "user");
		criteria = criteria.add(Restrictions.eq("user.userId", userId));
		criteria = criteria.add(Restrictions.eq("status", "APPROVED_BY_REQUESTOR"));
		criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		flag = (List<SwapHeader>) criteria.list();
		return flag;
	}
}
