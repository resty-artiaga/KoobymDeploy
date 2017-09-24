package com.koobym.service.impl;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.dao.TimeDao;
import com.koobym.model.Time;
import com.koobym.service.TimeService;

@Service
@Transactional
public class TimeServiceImpl extends BaseServiceImpl<Time, Long> implements TimeService {

	private TimeDao timeDao;

	@Autowired
	public TimeServiceImpl(TimeDao timeDao) {
		super(timeDao);
		this.timeDao = timeDao;
	}

}
