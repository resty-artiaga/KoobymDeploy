package com.koobym.service;

import java.util.List;

import com.koobym.model.BookOwner;
import com.koobym.model.RentalDetail;

public interface RentalDetailService extends BaseService<RentalDetail, Long> {
	public List<RentalDetail> getSuggestedByGenre(int userId);
	public List<RentalDetail> getMostRented();
	public List<RentalDetail> getRentalById(int userId);
	public List<RentalDetail> getAllForRentOrderByRate();
}
