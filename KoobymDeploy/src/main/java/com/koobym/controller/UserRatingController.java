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
import com.koobym.model.UserRating;
import com.koobym.service.BookOwnerRatingService;
import com.koobym.service.UserRatingService;
import com.koobym.service.UserService;

@RestController
@RequestMapping(value = "/userRating")
public class UserRatingController {

	@Autowired
	private UserRatingService userRatingService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<UserRating> add(@RequestBody UserRating userRating) {
		ResponseEntity<UserRating> ent = null;
		userRatingService.save(userRating);
		if (userRating == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(userRating);
		}
		return ent;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<UserRating> update(@RequestBody UserRating userRating) {
		ResponseEntity<UserRating> ent = null;
		userRatingService.update(userRating);
		if (userRating == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(userRating);
		}
		return ent;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<UserRating>> getRoles() {
		ResponseEntity<List<UserRating>> flag = ResponseEntity.ok(userRatingService.list());
		return flag;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserRating> getRoles(@PathVariable("id") int id) {
		ResponseEntity<UserRating> flag = ResponseEntity.ok(userRatingService.get(new Long(id)));
		return flag;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteUser(@PathVariable("id") int id) {
		userRatingService.delete(new Long(id));
		ResponseEntity<Integer> flag = ResponseEntity.ok(id);
		return flag;
	}

	@RequestMapping(value = "/getAverageRatingOfUser/{id}", method = RequestMethod.GET)
	public ResponseEntity<Double> averageRatingOfBookOwner(@PathVariable("id") int id) {
		ResponseEntity<Double> flag = ResponseEntity.ok(userRatingService.averageRatingOfUser(new Long(id)));
		return flag;
	}

	@RequestMapping(value = "/getAllUserRatingsOf/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<UserRating>> getAllUserRatingsOf(@PathVariable("id") int id) {
		ResponseEntity<List<UserRating>> flag = ResponseEntity.ok(userRatingService.userRatingsOfUser(new Long(id)));
		return flag;
	}

}