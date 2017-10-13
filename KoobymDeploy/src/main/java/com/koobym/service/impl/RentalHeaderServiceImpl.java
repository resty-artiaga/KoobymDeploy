package com.koobym.service.impl;

import java.util.List;

import javax.transaction.Transactional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.model.RentalHeader;
import com.koobym.model.UserRental;
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

	@Override
	public List<RentalHeader> getToDeliverById(int userId){
		return rentalHeaderDao.getToDeliverById(userId);
	}

	@Override
	public List<RentalHeader> getListRentalById(int userId) {
		// TODO Auto-generated method stub
		return rentalHeaderDao.getListRentalById(userId);
	}
	
	@Override
	public List<RentalHeader> getToReceiveByIdRenter(int userId) {
		// TODO Auto-generated method stub
		return rentalHeaderDao.getToReceiveByIdRenter(userId);
	}

	@Override
	public List<RentalHeader> getRequestReceivedById(int userId) {
		// TODO Auto-generated method stub
		return rentalHeaderDao.getRequestReceivedById(userId);
	}
	
	@Override
	public List<RentalHeader> getMyRequestsById(int userId) {
		// TODO Auto-generated method stub
		return rentalHeaderDao.getMyRequestsById(userId);
	}
	
	@Override
	public List<RentalHeader> getToReturnByIdRenter(int userId) {
		// TODO Auto-generated method stub
		return rentalHeaderDao.getToReturnByIdRenter(userId);
	}
	
	@Override
	public List<RentalHeader> getToReturnByIdOwner(int userId) {
		// TODO Auto-generated method stub
		return rentalHeaderDao.getToReturnByIdOwner(userId);
	}
	
	@Override
	public List<RentalHeader> getCompleteByIdRenter(int userId) {
		// TODO Auto-generated method stub
		return rentalHeaderDao.getCompleteByIdRenter(userId);
	}
	
	@Override
	public List<RentalHeader> getToReceiveByIdOwner(int userId) {
		// TODO Auto-generated method stub
		return rentalHeaderDao.getToReceiveByIdOwner(userId);
	}
	
	@Override
	public List<RentalHeader> getCompleteByIdOwner(int userId) {
		// TODO Auto-generated method stub
		return rentalHeaderDao.getCompleteByIdOwner(userId);
	}
	
	@Override
	public RentalHeader setApprovedExam(long rentalHeaderId, String status) {
		
		return rentalHeaderDao.setApprovedExam(rentalHeaderId, status);
	}
	
	@Override
	public RentalHeader setRentalHeader(RentalHeader rentalHeader) {
		return rentalHeaderDao.setRentalHeader(rentalHeader);
	}
	
	@Override
	public RentalHeader checkExist(long userId, long rentalDetailId) {
		return rentalHeaderDao.checkExist(userId, rentalDetailId);
	}

	@Override
	public List<RentalHeader> getRejectedByIdRenter(int userId){
		return rentalHeaderDao.getRejectedByIdRenter(userId);
	}
	
	@Override
	public List<RentalHeader> getRejectedByIdOwner(int userId){
		return rentalHeaderDao.getRejectedByIdOwner(userId);
	}

}
