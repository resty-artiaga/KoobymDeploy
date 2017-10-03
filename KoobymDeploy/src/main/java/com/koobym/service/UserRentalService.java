package com.koobym.service;

import java.util.List;

import com.koobym.model.UserRental;

public interface UserRentalService extends BaseService<UserRental, Long> {
	public List<UserRental> getListRentalById(int userId);
}
