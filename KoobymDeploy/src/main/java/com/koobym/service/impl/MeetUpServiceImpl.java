package com.koobym.service.impl;

import javax.transaction.Transactional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.dao.MeetUpDao;
import com.koobym.model.MeetUp;
import com.koobym.service.MeetUpService;

@Service
@Transactional
public class MeetUpServiceImpl extends BaseServiceImpl<MeetUp, Long> implements MeetUpService {

	private MeetUpDao meetUpDao;

	@Autowired
	public MeetUpServiceImpl(MeetUpDao meetUpDao) {
		super(meetUpDao);
		this.meetUpDao = meetUpDao;
	}

}
