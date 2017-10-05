package com.koobym.service.impl;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.dao.SwapDetailDao;
import com.koobym.model.SwapDetail;
import com.koobym.service.SwapDetailService;

@Service
@Transactional
public class SwapDetailServiceImpl extends BaseServiceImpl<SwapDetail, Long> implements SwapDetailService {

	private SwapDetailDao swapDetailDao;

	@Autowired
	public SwapDetailServiceImpl(SwapDetailDao swapDetailDao) {
		super(swapDetailDao);
		this.swapDetailDao = swapDetailDao;
	}
	
	
	
	@Override
	public List<SwapDetail> getSwapById(int userId){
		return swapDetailDao.getSwapById(userId);
	}

}
