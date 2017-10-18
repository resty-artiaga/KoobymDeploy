package com.koobym.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.model.BookOwner;
import com.koobym.model.SwapHeader;
import com.koobym.service.SwapHeaderService;
import com.koobym.dao.LocationDao;
import com.koobym.dao.SwapHeaderDao;

@Service
@Transactional
public class SwapHeaderServiceImpl extends BaseServiceImpl<SwapHeader, Long> implements SwapHeaderService {

	private SwapHeaderDao swapHeaderDao;
	private LocationDao locationDao;

	@Autowired
	public SwapHeaderServiceImpl(SwapHeaderDao swapHeaderDao, LocationDao locationDao) {
		super(swapHeaderDao);
		this.swapHeaderDao = swapHeaderDao;
		this.locationDao = locationDao;
	}

	@Override
	public List<SwapHeader> getToDeliverById(int userId) {
		return swapHeaderDao.getToDeliverById(userId);
	}

	@Override
	public List<SwapHeader> getToReceiveByIdRenter(int userId) {
		return swapHeaderDao.getToReceiveByIdRenter(userId);
	}

	@Override
	public SwapHeader setApprovedExam(long swapHeaderId, String status) {
		return swapHeaderDao.setApprovedExam(swapHeaderId, status);
	}

	@Override
	public SwapHeader swapRequested(SwapHeader swapHeader) {
		locationDao.save(swapHeader.getLocation());
		return swapHeaderDao.swapRequested(swapHeader);
	}
	
	@Override
	public List<SwapHeader> getApprovedSwaps(long userId){
		return swapHeaderDao.getApprovedSwaps(userId);
	}

	@Override
	public List<SwapHeader> getRequestedSwaps(long userId) {
		return swapHeaderDao.getRequestedSwaps(userId);
	}
	
	@Override
	public List<SwapHeader> getToApproveSwaps(long userId){
		return swapHeaderDao.getToApproveSwaps(userId);
	}
	
	@Override
	public List<SwapHeader> getCompleteById(int userId){
		return swapHeaderDao.getCompleteById(userId);
	}

}
