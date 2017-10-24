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

import com.koobym.model.BookOwnerReview;
import com.koobym.model.User;
import com.koobym.service.BookOwnerReviewService;
import com.koobym.service.UserService;

@RestController
@RequestMapping(value = "/bookOwnerReview")
public class BookOwnerReviewController {

	@Autowired
	private BookOwnerReviewService bookOwnerReviewService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<BookOwnerReview> add(@RequestBody BookOwnerReview BookOwnerReview) {
		ResponseEntity<BookOwnerReview> ent = null;
		bookOwnerReviewService.save(BookOwnerReview);
		if (BookOwnerReview == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(BookOwnerReview);
		}
		return ent;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<BookOwnerReview> update(@RequestBody BookOwnerReview BookOwnerReview) {
		ResponseEntity<BookOwnerReview> ent = null;
		bookOwnerReviewService.update(BookOwnerReview);
		if (BookOwnerReview == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(BookOwnerReview);
		}
		return ent;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<BookOwnerReview>> getRoles() {
		ResponseEntity<List<BookOwnerReview>> flag = ResponseEntity.ok(bookOwnerReviewService.list());
		return flag;
	}

	@RequestMapping(value = "/getAllReviewOfBookOwner/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<BookOwnerReview>> getALlReviewOfBookOwner(@PathVariable("id") int id) {
		ResponseEntity<List<BookOwnerReview>> flag = ResponseEntity
				.ok(bookOwnerReviewService.getReviewsOfBookOwner(new Long(id)));
		return flag;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<BookOwnerReview> getRoles(@PathVariable("id") int id) {
		ResponseEntity<BookOwnerReview> flag = ResponseEntity.ok(bookOwnerReviewService.get(new Long(id)));
		return flag;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteUser(@PathVariable("id") int id) {
		bookOwnerReviewService.delete(new Long(id));
		ResponseEntity<Integer> flag = ResponseEntity.ok(id);
		return flag;
	}
	
	@RequestMapping(value = "/getAverageRatingOfBookOwner/{id}", method = RequestMethod.GET)
	public ResponseEntity<Double> averageRatingOfBookOwner(@PathVariable("id") int id) {
		ResponseEntity<Double> flag = ResponseEntity.ok(bookOwnerReviewService.averageRatingOfBookOwner(new Long(id)));
		return flag;
	}

}