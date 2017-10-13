package com.koobym.dao;

import java.util.Set;

import com.koobym.model.Author;

public interface AuthorDao extends BaseDao<Author, Long> {
	public Set<Author> getAuthorsFromSet(Set<Author> authors);	
}
