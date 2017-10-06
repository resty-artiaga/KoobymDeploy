package com.koobym.dao.impl;

import org.hibernate.Session;


import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.SwapCommentDao;
import com.koobym.model.SwapComment;

@Repository
public class SwapCommentDAoImpl extends BaseDaoImpl<SwapComment, Long> implements SwapCommentDao {

	public SwapCommentDAoImpl() {
		super(SwapComment.class);
	}

	
}
