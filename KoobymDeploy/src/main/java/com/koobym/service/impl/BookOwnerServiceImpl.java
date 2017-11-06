package com.koobym.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.dao.BookOwnerDao;
import com.koobym.dao.RentalHeaderDao;
import com.koobym.dao.SwapHeaderDao;
import com.koobym.dto.Transaction;
import com.koobym.model.BookOwner;
import com.koobym.model.RentalHeader;
import com.koobym.model.SwapHeader;
import com.koobym.service.BookOwnerService;

@Service
@Transactional
public class BookOwnerServiceImpl extends BaseServiceImpl<BookOwner, Long> implements BookOwnerService {

	private BookOwnerDao bookOwnerDao;
	private RentalHeaderDao rentalHeaderDao;
	private SwapHeaderDao swapHeaderDao;

	@Autowired
	public BookOwnerServiceImpl(BookOwnerDao bookOwnerDao, RentalHeaderDao rentalHeaderDao,
			SwapHeaderDao swapHeaderDao) {
		super(bookOwnerDao);
		this.bookOwnerDao = bookOwnerDao;
		this.rentalHeaderDao = rentalHeaderDao;
		this.swapHeaderDao = swapHeaderDao;
	}

	public List<BookOwner> allDistinct(){
		return bookOwnerDao.allDistinct();
	}
	
	@Override
	public BookOwner setBookOwner(long bookOwnerId, long userId) {
		return bookOwnerDao.setBookOwner(bookOwnerId, userId);
	}

	@Override
	public List<BookOwner> getMyBooksById(int userId) {
		return bookOwnerDao.getMyBooksById(userId);
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

}
