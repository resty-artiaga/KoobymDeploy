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

import com.koobym.model.RentalDetail;
import com.koobym.model.UserRental;
import com.koobym.service.UserRentalService;

@RestController
@RequestMapping(value = "/userRental")
public class UserRentalController {

	@Autowired
	private UserRentalService userRentalService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<UserRental> add(@RequestBody UserRental userRental) {
		ResponseEntity<UserRental> ent = null;
		userRentalService.save(userRental);
		if (userRental == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(userRental);
		}
		return ent;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<UserRental> update(@RequestBody UserRental userRental) {
		ResponseEntity<UserRental> ent = null;
		userRentalService.update(userRental);
		if (userRental == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(userRental);
		}
		return ent;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<UserRental>> getRoles() {
		ResponseEntity<List<UserRental>> flag = ResponseEntity.ok(userRentalService.list());
		return flag;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserRental> getRoles(@PathVariable("id") int id) {
		ResponseEntity<UserRental> flag = ResponseEntity.ok(userRentalService.get(new Long(id)));
		return flag;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteUser(@PathVariable("id") int id) {
		userRentalService.delete(new Long(id));
		ResponseEntity<Integer> flag = ResponseEntity.ok(id);
		return flag;
	}
	
	@RequestMapping(value = "/rentalById/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<UserRental>> getRentalId(@PathVariable("userId") int userId) {
		ResponseEntity<List<UserRental>> flag = ResponseEntity.ok(userRentalService.getListRentalById(userId));
		return flag;
	}

}