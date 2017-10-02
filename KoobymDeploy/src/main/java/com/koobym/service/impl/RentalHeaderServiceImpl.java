package com.koobym.service.impl;

import javax.transaction.Transactional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.model.RentalHeader;
import com.koobym.service.RentalHeaderService;
import com.koobym.dao.RentalHeaderDao;
@Service
@Transactional
public class RentalHeaderServiceImpl extends BaseServiceImpl<RentalHeader, Long> implements RentalHeaderService {

	private RentalHeaderDao rentalHeaderDao;

	@Autowired
	public RentalHeaderServiceImpl(RentalHeaderDao rentalHeaderDao) {
		super(rentalHeaderDao);
		this.rentalHeaderDao = rentalHeaderDao;
	}



}
