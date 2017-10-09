package com.koobym.service.impl;

import java.util.List;


import javax.transaction.Transactional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.model.BookOwner;
import com.koobym.model.SwapHeader;
import com.koobym.service.SwapHeaderService;
import com.koobym.dao.SwapHeaderDao;
@Service
@Transactional
public class SwapHeaderServiceImpl extends BaseServiceImpl<SwapHeader, Long> implements SwapHeaderService {

	private SwapHeaderDao swapHeaderDao;

	@Autowired
	public SwapHeaderServiceImpl(SwapHeaderDao swapHeaderDao) {
		super(swapHeaderDao);
		this.swapHeaderDao = swapHeaderDao;
	}

	@Override
	public List<SwapHeader> getToDeliverById(int userId){
		return swapHeaderDao.getToDeliverById(userId);
	}
	
	@Override
	public List<SwapHeader> getToReceiveByIdRenter(int userId){
		return swapHeaderDao.getToReceiveByIdRenter(userId);
	}

	@Override
	public SwapHeader setApprovedExam(long swapHeaderId, String status) {
		return swapHeaderDao.setApprovedExam(swapHeaderId, status);
	}
	
}
