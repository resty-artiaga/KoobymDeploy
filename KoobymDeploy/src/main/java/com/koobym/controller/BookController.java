package com.koobym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.koobym.model.Book;
import com.koobym.model.User;
import com.koobym.service.BookService;
import com.koobym.service.UserService;

@RestController
@RequestMapping(value = "/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Book> add(@RequestBody Book book) {
		ResponseEntity<Book> ent = null;
		bookService.save(book);
		if (book == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(book);
		}
		return ent;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Book> update(@RequestBody Book book) {
		ResponseEntity<Book> ent = null;
		bookService.update(book);
		if (book == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(book);
		}
		return ent;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> getRoles() {
		ResponseEntity<List<Book>> flag = ResponseEntity.ok(bookService.list());
		return flag;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<Book> getRoles(@PathVariable("id") int id) {
		ResponseEntity<Book> flag = ResponseEntity.ok(bookService.get(Integer.toUnsignedLong(id)));
		return flag;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteUser(@PathVariable("id") int id) {
		bookService.delete(Integer.toUnsignedLong(id));
		ResponseEntity<Integer> flag = ResponseEntity.ok(id);
		return flag;
	}

}