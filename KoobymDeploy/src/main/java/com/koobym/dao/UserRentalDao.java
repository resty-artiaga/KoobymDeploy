package com.koobym.dao;

import java.util.List;


import java.util.Set;

import com.koobym.model.UserRental;

public interface UserRentalDao extends BaseDao<UserRental, Long> {
	public List<UserRental> getListRentalById(int userId);
}
