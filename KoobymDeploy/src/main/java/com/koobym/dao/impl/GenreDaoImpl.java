package com.koobym.dao.impl;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.GenreDao;
import com.koobym.model.Genre;

@Repository
public class GenreDaoImpl extends BaseDaoImpl<Genre, Long> implements GenreDao {

	public GenreDaoImpl() {
		super(Genre.class);
	}

}
