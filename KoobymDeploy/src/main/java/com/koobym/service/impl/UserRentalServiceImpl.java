package com.koobym.service.impl;

import javax.transaction.Transactional;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.model.UserRental;
import com.koobym.service.UserRentalService;
import com.koobym.dao.UserRentalDao;
@Service
@Transactional
public class UserRentalServiceImpl extends BaseServiceImpl<UserRental, Long> implements UserRentalService {

	private UserRentalDao userRentalDao;

	@Autowired
	public UserRentalServiceImpl(UserRentalDao userRentalDao) {
		super(userRentalDao);
		this.userRentalDao = userRentalDao;
	}



}
