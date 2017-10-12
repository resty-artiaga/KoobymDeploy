package com.koobym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.koobym.model.RentalDetail;
import com.koobym.model.SwapDetail;
import com.koobym.model.User;
import com.koobym.service.RentalDetailService;

@RestController
@RequestMapping(value = "/rentalDetail")
public class RentalDetailController {

	@Autowired
	private RentalDetailService rentalDetailService;

	@RequestMapping(value = "/mostRented", method = RequestMethod.GET)
	public ResponseEntity<List<RentalDetail>> getRoles() {
		ResponseEntity<List<RentalDetail>> flag = ResponseEntity.ok(rentalDetailService.getMostRented());
		return flag;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<RentalDetail> add(@RequestBody RentalDetail rentalDetail) {
		ResponseEntity<RentalDetail> ent = null;
		rentalDetailService.save(rentalDetail);
		if (rentalDetail == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(rentalDetail);
		}
		return ent;
	}


	@RequestMapping(value = "/suggested/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<RentalDetail>> getSuggested(@PathVariable("userId") int userId) {
		ResponseEntity<List<RentalDetail>> flag = ResponseEntity.ok(rentalDetailService.getSuggestedByGenre(userId));
		return flag;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<RentalDetail>> getList() {
		ResponseEntity<List<RentalDetail>> flag = ResponseEntity.ok(rentalDetailService.list());
		return flag;
	}
	
	@RequestMapping(value = "/rentById/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<RentalDetail>> getRentalId(@PathVariable("userId") int userId) {
		ResponseEntity<List<RentalDetail>> flag = ResponseEntity.ok(rentalDetailService.getRentalById(userId));
		return flag;
	}
}