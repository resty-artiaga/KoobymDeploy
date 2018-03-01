package com.koobym.dao.impl;

import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.koobym.dao.AuthorDao;
import com.koobym.dao.UserDao;
import com.koobym.model.Author;
import com.koobym.model.Genre;
import com.koobym.model.User;

@Repository
public class AuthorDaoImpl extends BaseDaoImpl<Author, Long> implements AuthorDao {

	public AuthorDaoImpl() {
		super(Author.class);
	}

	private Author getAuthorFromName(Author author) {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Author.class);
		criteria = criteria.add(Restrictions.eq("authorFName", author.getAuthorFName()));
		criteria = criteria.add(Restrictions.eq("authorLName", author.getAuthorLName()));
		return (Author) criteria.uniqueResult();
	}

	@Override
	public Set<Author> getAuthorsFromSet(Set<Author> authors) {
		Author auth;
		if (authors != null) {
			for (Author tempAuth : authors) {
				auth = getAuthorFromName(tempAuth);
				if (auth != null) {
					tempAuth.setAuthorId(auth.getAuthorId());
				} else {
					save(tempAuth);
				}
			}
		}

		return authors;
	}
	
}
