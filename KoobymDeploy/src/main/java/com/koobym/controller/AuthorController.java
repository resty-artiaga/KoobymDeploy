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

import com.koobym.model.Author;
import com.koobym.model.User;
import com.koobym.service.AuthorService;
import com.koobym.service.UserService;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {

	@Autowired
	private AuthorService authorService;



	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Author> add(@RequestBody Author author) {
		ResponseEntity<Author> ent = null;
		authorService.save(author);
		if (author == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(author);
		}
		return ent;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Author> update(@RequestBody Author author) {
		ResponseEntity<Author> ent = null;
		authorService.update(author);
		if (author == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(author);
		}
		return ent;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Author>> getRoles() {
		ResponseEntity<List<Author>> flag = ResponseEntity.ok(authorService.list());
		return flag;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<Author> getRoles(@PathVariable("id") int id) {
		ResponseEntity<Author> flag = ResponseEntity.ok(authorService.get(Integer.toUnsignedLong(id)));
		return flag;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteUser(@PathVariable("id") int id) {
		authorService.delete(Integer.toUnsignedLong(id));
		ResponseEntity<Integer> flag = ResponseEntity.ok(id);
		return flag;
	}

}