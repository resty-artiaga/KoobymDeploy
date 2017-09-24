package com.koobym.service.impl;

import javax.transaction.Transactional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.dao.DayDao;
import com.koobym.model.Day;
import com.koobym.service.DayService;

@Service
@Transactional
public class DayServiceImpl extends BaseServiceImpl<Day, Long> implements DayService {

	private DayDao dayDao;

	@Autowired
	public DayServiceImpl(DayDao dayDao) {
		super(dayDao);
		this.dayDao = dayDao;
	}

}
