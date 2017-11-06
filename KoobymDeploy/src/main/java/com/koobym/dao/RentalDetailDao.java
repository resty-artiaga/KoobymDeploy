package com.koobym.dao;

import java.util.List;
import java.util.Set;

import com.koobym.model.Genre;
import com.koobym.model.RentalDetail;

public interface RentalDetailDao extends BaseDao<RentalDetail, Long> {
	public List<RentalDetail> mostRentedBooks();
	public List<RentalDetail> suggestedBooksByGenre(int userId);
	public List<RentalDetail> getRentalById(int userId);
	public List<RentalDetail> getAllForRentOrderByRate();
	public RentalDetail getRentalDetail(long bookOwnerId);
}
