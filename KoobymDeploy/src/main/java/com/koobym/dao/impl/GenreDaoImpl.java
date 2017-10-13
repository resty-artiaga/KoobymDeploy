package com.koobym.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
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

	private Genre getGenreFromGenreName(String genreName) {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Genre.class);
		criteria = criteria.add(Restrictions.eq("genreName", genreName));
		return (Genre) criteria.uniqueResult();
	}

	@Override
	public Set<Genre> getGenresFromListString(Set<Genre> genres) {
		Genre gen;
		if (genres != null) {
			for (Genre tempGen : genres) {
				gen = getGenreFromGenreName(tempGen.getGenreName());
				if (gen != null) {
					tempGen.setGenreId(gen.getGenreId());
				} else {
					save(tempGen);
				}
			}
		}
		return genres;
	}
}
