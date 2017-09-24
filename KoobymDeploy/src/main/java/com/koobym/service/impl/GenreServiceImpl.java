package com.koobym.service.impl;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.dao.BaseDao;
import com.koobym.model.Genre;
import com.koobym.service.GenreService;

@Service
@Transactional
public class GenreServiceImpl extends BaseServiceImpl<Genre, Long> implements GenreService {

	public GenreServiceImpl(BaseDao<Genre, Long> baseDao) {
		super(baseDao);
		// TODO Auto-generated constructor stub
	}
	

	
}
