package com.koobym.service.impl;

import javax.transaction.Transactional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.dao.SwapCommentDao;
import com.koobym.model.SwapComment;
import com.koobym.service.SwapCommentService;

@Service
@Transactional
public class SwapCommentServiceImpl extends BaseServiceImpl<SwapComment, Long> implements SwapCommentService {

	private SwapCommentDao swapCommentDao;

	@Autowired
	public SwapCommentServiceImpl(SwapCommentDao swapCommentDao) {
		super(swapCommentDao);
		this.swapCommentDao = swapCommentDao;
	}

}
