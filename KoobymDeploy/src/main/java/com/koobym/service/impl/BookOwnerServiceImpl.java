package com.koobym.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.dao.BookDao;
import com.koobym.dao.BookOwnerDao;
import com.koobym.dao.RentalHeaderDao;
import com.koobym.dao.SwapHeaderDao;
import com.koobym.dao.UserDao;
import com.koobym.dto.BookActivityObject;
import com.koobym.dto.Transaction;
import com.koobym.model.BookOwner;
import com.koobym.model.RentalHeader;
import com.koobym.model.SwapHeader;
import com.koobym.service.BookOwnerRatingService;
import com.koobym.service.BookOwnerService;

@Service
@Transactional
public class BookOwnerServiceImpl extends BaseServiceImpl<BookOwner, Long> implements BookOwnerService {

	private BookOwnerDao bookOwnerDao;
	private BookDao bookDao;
	private UserDao userDao;
	private RentalHeaderDao rentalHeaderDao;
	private SwapHeaderDao swapHeaderDao;

	@Autowired
	private BookOwnerRatingService bookOwnerRatingService;

	@Autowired
	public BookOwnerServiceImpl(BookOwnerDao bookOwnerDao, RentalHeaderDao rentalHeaderDao, SwapHeaderDao swapHeaderDao,
			BookDao bookDao, UserDao userDao) {
		super(bookOwnerDao);
		this.bookOwnerDao = bookOwnerDao;
		this.rentalHeaderDao = rentalHeaderDao;
		this.swapHeaderDao = swapHeaderDao;
		this.bookDao = bookDao;
		this.userDao = userDao;
	}

	public List<BookOwner> allDistinct() {
		return bookOwnerDao.allDistinct();
	}

	@Override
	public BookOwner setBookOwner(long bookOwnerId, long userId) {
		return bookOwnerDao.setBookOwner(bookOwnerId, userId);
	}

	@Override
	public List<BookOwner> getMyBooksById(int userId) {
		List<BookOwner> flag = bookOwnerDao.getMyBooksById(userId);
		for (BookOwner bo : flag) {
			bo.setRate(bookOwnerRatingService.averageRatingOfBookOwner(bo.getBook_ownerId()));
		}
		return flag;
	}

	@Override
	public BookOwner increment(long bookOwnerId) {
		return bookOwnerDao.increment(bookOwnerId);
	}

	@Override
	public List<BookOwner> getStatusById() {
		return bookOwnerDao.getStatusById();
	}

	@Override
	public List<Transaction> bookTransactions(long bookOwnerId) {
		List<Transaction> transactions = new ArrayList<Transaction>();

		List<RentalHeader> rentalHeaders = rentalHeaderDao.getListRentalByBookOwnerId(bookOwnerId);
		Transaction trans;
		for (RentalHeader rh : rentalHeaders) {
			trans = new Transaction();
			trans.setTransactionId(rh.getRentalHeaderId());
			trans.setTransactionStatus(rh.getStatus());
			trans.setTransactionType("rent");
			trans.setUser(rh.getUserId());
			transactions.add(trans);
		}

		List<SwapHeader> swapHeaders = swapHeaderDao.getListSwapHeaderByBookOwnerId(bookOwnerId);
		for (SwapHeader sh : swapHeaders) {
			trans = new Transaction();
			trans.setTransactionId(sh.getSwapHeaderId());
			trans.setTransactionStatus(sh.getStatus());
			trans.setTransactionType("swap");
			trans.setUser(sh.getUser());
			transactions.add(trans);
		}

		return transactions;
	}

	public List<BookOwner> getSuggestedBooks(int userId) {
		List<BookOwner> flags = bookOwnerDao.suggestedBooks(userId);
		for (BookOwner flag : flags) {
			flag.setBook(bookDao.get(flag.getBook().getBookId()));
			flag.setUser(userDao.get(flag.getUser().getUserId()));
		}
		return flags;
	}

	public Set<BookActivityObject> getUserOwnBookActivities(int userId) {
		List<RentalHeader> rentalHeaders = rentalHeaderDao.getOngoingByOwner(userId);
		List<SwapHeader> swapHeaders = swapHeaderDao.getOngoingSwaps(userId);

		Set<BookActivityObject> bookActivityObjects = new TreeSet<BookActivityObject>();
		BookActivityObject baj;
		for (RentalHeader rentalHeader : rentalHeaders) {
			baj = new BookActivityObject();
			baj.setUser(rentalHeader.getUserId());
			baj.setBookOwner(rentalHeader.getRentalDetail().getBookOwner());
			baj.setBookActivityId(rentalHeader.getRentalHeaderId());
			baj.setBookStatus("rent");
			baj.setStatus(rentalHeader.getStatus());
			baj.setDateRequest(rentalHeader.getRentalTimeStamp());

			bookActivityObjects.add(baj);
		}

		for (SwapHeader swapHeader : swapHeaders) {
			baj = new BookActivityObject();
			baj.setUser(swapHeader.getUser());
			baj.setBookOwner(swapHeader.getSwapDetail().getBookOwner());
			baj.setBookStatus("swap");
			baj.setStatus(swapHeader.getStatus());
			baj.setBookActivityId(swapHeader.getSwapHeaderId());
			baj.setDateRequest(swapHeader.getDateTimeStamp());

			bookActivityObjects.add(baj);
		}

		return bookActivityObjects;
	}

	public Set<BookActivityObject> getUserRequestsBookActivities(int userId) {
		List<RentalHeader> rentalHeaders = rentalHeaderDao.getOngoingRequestsByUser(userId);
		List<SwapHeader> swapHeaders = swapHeaderDao.getOngoingSwapRequestsByUser(userId);

		Set<BookActivityObject> bookActivityObjects = new TreeSet<BookActivityObject>();
		BookActivityObject baj;
		for (RentalHeader rentalHeader : rentalHeaders) {
			baj = new BookActivityObject();
			baj.setUser(rentalHeader.getUserId());
			baj.setBookOwner(rentalHeader.getRentalDetail().getBookOwner());
			baj.setBookActivityId(rentalHeader.getRentalHeaderId());
			baj.setBookStatus("rent");
			baj.setStatus(rentalHeader.getStatus());
			baj.setDateRequest(rentalHeader.getRentalTimeStamp());

			bookActivityObjects.add(baj);
		}

		for (SwapHeader swapHeader : swapHeaders) {
			baj = new BookActivityObject();
			baj.setUser(swapHeader.getUser());
			baj.setBookOwner(swapHeader.getSwapDetail().getBookOwner());
			baj.setBookStatus("swap");
			baj.setStatus(swapHeader.getStatus());
			baj.setBookActivityId(swapHeader.getSwapHeaderId());
			baj.setDateRequest(swapHeader.getDateTimeStamp());

			bookActivityObjects.add(baj);
		}

		return bookActivityObjects;
	}
}
