package com.koobym.dao;

import java.util.Set;

import com.koobym.model.Genre;

public interface GenreDao extends BaseDao<Genre, Long> {
	public Set<Genre> getGenresFromListString(Set<Genre> genres);
}
