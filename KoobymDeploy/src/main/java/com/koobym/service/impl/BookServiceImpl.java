package com.koobym.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koobym.dao.AuthorDao;
import com.koobym.dao.BookDao;
import com.koobym.dao.GenreDao;
import com.koobym.model.Book;
import com.koobym.service.BookService;

@Service
@Transactional
public class BookServiceImpl extends BaseServiceImpl<Book, Long> implements BookService {

	private BookDao bookDao;
	private GenreDao genreDao;
	private AuthorDao authorDao;

	@Autowired
	public BookServiceImpl(BookDao bookDao, GenreDao genreDao, AuthorDao authorDao) {
		super(bookDao);
		this.bookDao = bookDao;
		this.genreDao = genreDao;
		this.authorDao = authorDao;
	}

	@Override
	public Book addNewBook(Book book) {
		book.setAuthors(authorDao.getAuthorsFromSet(book.getAuthors()));
		book.setGenres(genreDao.getGenresFromListString(book.getGenres()));
		bookDao.save(book);

		return book;
	}

}
