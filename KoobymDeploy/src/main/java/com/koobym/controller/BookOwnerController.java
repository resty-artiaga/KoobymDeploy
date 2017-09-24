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

import com.koobym.model.BookOwner;
import com.koobym.model.User;
import com.koobym.service.BookOwnerService;
import com.koobym.service.UserService;

@RestController
@RequestMapping(value = "/bookOwner")
public class BookOwnerController {

	@Autowired
	private BookOwnerService bookOwnerService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<BookOwner> add(@RequestBody BookOwner bookOwner) {
		ResponseEntity<BookOwner> ent = null;
		bookOwnerService.save(bookOwner);
		if (bookOwner == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(bookOwner);
		}
		return ent;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<BookOwner> update(@RequestBody BookOwner bookOwner) {
		ResponseEntity<BookOwner> ent = null;
		bookOwnerService.update(bookOwner);
		if (bookOwner == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(bookOwner);
		}
		return ent;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<BookOwner>> getRoles() {
		ResponseEntity<List<BookOwner>> flag = ResponseEntity.ok(bookOwnerService.list());
		return flag;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<BookOwner> getRoles(@PathVariable("id") int id) {
		ResponseEntity<BookOwner> flag = ResponseEntity.ok(bookOwnerService.get(Integer.toUnsignedLong(id)));
		return flag;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteUser(@PathVariable("id") int id) {
		bookOwnerService.delete(Integer.toUnsignedLong(id));
		ResponseEntity<Integer> flag = ResponseEntity.ok(id);
		return flag;
	}

}