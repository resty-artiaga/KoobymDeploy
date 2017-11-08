package com.koobym.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.dao.BookOwnerDao;
import com.koobym.dao.RentalDetailDao;
import com.koobym.dao.UserDao;
import com.koobym.model.RentalDetail;
import com.koobym.service.RentalDetailService;

@Service
@Transactional
public class RentalDetailServiceImpl extends BaseServiceImpl<RentalDetail, Long> implements RentalDetailService {

	private RentalDetailDao rentalDetailDao;

	@Autowired
	private BookOwnerDao bookOwnerDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	public RentalDetailServiceImpl(RentalDetailDao rentalDetailDao) {
		super(rentalDetailDao);
		this.rentalDetailDao = rentalDetailDao;
	}

	public List<RentalDetail> getSuggestedByGenre(int userId) {
		List<RentalDetail> flag = rentalDetailDao.suggestedBooksByGenre(userId);

		for (RentalDetail rd : flag) {
			rd.setBookOwner(bookOwnerDao.get(rd.getBookOwner().getBook_OwnerId()));
		}

		return flag;
	}

	@Override
	public List<RentalDetail> getMostRented() {
		return rentalDetailDao.mostRentedBooks();
	}

	@Override
	public List<RentalDetail> getRentalById(int userId) {
		return rentalDetailDao.getRentalById(userId);
	}

	@Override
	public List<RentalDetail> getAllForRentOrderByRate() {
		List<RentalDetail> flag = rentalDetailDao.getAllForRentOrderByRate();
		for (RentalDetail rd : flag) {
			rd.setBookOwner(bookOwnerDao.get(rd.getBookOwner().getBook_OwnerId()));
		}

		return flag;
	}

	@Override
	public RentalDetail getRentalDetail(long bookOwnerId) {
		return rentalDetailDao.getRentalDetail(bookOwnerId);
	}

	public RentalDetail setBookOwnerAsRental(RentalDetail rentalDetail) {
		RentalDetail rd = rentalDetailDao.getRentalDetail(rentalDetail.getBookOwner().getBook_OwnerId());
		if (rd != null) {
			rd.setCalculatedPrice(rentalDetail.getCalculatedPrice());
			rd.setDaysForRent(rentalDetail.getDaysForRent());			
			rentalDetailDao.update(rd);
			rentalDetail.setRental_detailId(rd.getRental_detailId());
		} else {
			rentalDetailDao.save(rentalDetail);
		}

		return rentalDetail;

	}

}
