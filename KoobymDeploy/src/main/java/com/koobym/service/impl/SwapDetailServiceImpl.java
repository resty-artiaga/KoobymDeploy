package com.koobym.service.impl;

import java.util.ArrayList;
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
	public List<SwapDetail> getSwapById(int userId) {
		return swapDetailDao.getSwapById(userId);
	}

	@Override
	public List<SwapDetail> getMySwapBookById(int userId) {
		return swapDetailDao.getMySwapBookById(userId);
	}

	@Override
	public List<SwapDetail> getSwapPriceById(int userId, float price) {
		List<SwapDetail> flag = swapDetailDao.getSwapPriceById(userId, price);
		List<SwapDetail> toReturn = new ArrayList<SwapDetail>();

		for (SwapDetail sd : flag) {
			if ("Swap".equals(sd.getBookOwner().getStatus())) {
				toReturn.add(sd);
			}
		}

		return toReturn;
	}

	@Override
	public List<SwapDetail> getAll() {
		return swapDetailDao.getAll();
	}

	@Override
	public SwapDetail getSwapDetail(long bookOwnerId) {
		return swapDetailDao.getSwapDetail(bookOwnerId);
	}

	public SwapDetail setBookOwnerAsSwap(SwapDetail swapDetail) {
		SwapDetail sd = swapDetailDao.getSwapDetail(swapDetail.getBookOwner().getBook_OwnerId());
		if (sd != null) {
			sd.setSwapDescription(swapDetail.getSwapDescription());
			sd.setSwapPrice(swapDetail.getSwapPrice());
			sd.setSwapTimeStamp(swapDetail.getSwapTimeStamp());
			swapDetailDao.update(sd);
			swapDetail.setSwapDetailId(sd.getSwapDetailId());
		} else {
			swapDetailDao.save(swapDetail);
		}
		return swapDetail;
	}

}
