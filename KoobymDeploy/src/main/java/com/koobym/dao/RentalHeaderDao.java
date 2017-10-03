package com.koobym.dao;

import java.util.List;

import java.util.Set;

import com.koobym.model.RentalHeader;
import com.koobym.model.UserRental;

public interface RentalHeaderDao extends BaseDao<RentalHeader, Long> {
	public List<RentalHeader> getListRentalById(int userId);
}
