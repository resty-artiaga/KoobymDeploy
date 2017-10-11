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
import com.koobym.model.BookOwnerRating;
import com.koobym.model.User;
import com.koobym.service.BookOwnerRatingService;
import com.koobym.service.UserService;

@RestController
@RequestMapping(value = "/bookOwnerRating")
public class BookOwnerRatingController {

	@Autowired
	private BookOwnerRatingService bookOwnerRatingService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<BookOwnerRating> add(@RequestBody BookOwnerRating bookOwnerRating) {
		ResponseEntity<BookOwnerRating> ent = null;
		bookOwnerRatingService.save(bookOwnerRating);
		if (bookOwnerRating == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(bookOwnerRating);
		}
		return ent;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<BookOwnerRating> update(@RequestBody BookOwnerRating bookOwnerRating) {
		ResponseEntity<BookOwnerRating> ent = null;
		bookOwnerRatingService.update(bookOwnerRating);
		if (bookOwnerRating == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(bookOwnerRating);
		}
		return ent;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<BookOwnerRating>> getRoles() {
		ResponseEntity<List<BookOwnerRating>> flag = ResponseEntity.ok(bookOwnerRatingService.list());
		return flag;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<BookOwnerRating> getRoles(@PathVariable("id") int id) {
		ResponseEntity<BookOwnerRating> flag = ResponseEntity.ok(bookOwnerRatingService.get(new Long(id)));
		return flag;
	}

	@RequestMapping(value = "/getAverageRatingOfBookOwner/{id}", method = RequestMethod.GET)
	public ResponseEntity<Double> averageRatingOfBookOwner(@PathVariable("id") int id) {
		ResponseEntity<Double> flag = ResponseEntity.ok(bookOwnerRatingService.averageRatingOfBookOwner(new Long(id)));
		return flag;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteUser(@PathVariable("id") int id) {
		bookOwnerRatingService.delete(new Long(id));
		ResponseEntity<Integer> flag = ResponseEntity.ok(id);
		return flag;
	}

}