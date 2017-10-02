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

import com.koobym.model.RentalHeader;
import com.koobym.service.RentalHeaderService;

@RestController
@RequestMapping(value = "/rentalHeader")
public class RentalHeaderController {

	@Autowired
	private RentalHeaderService rentalHeaderService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<RentalHeader> add(@RequestBody RentalHeader rentalHeader) {
		ResponseEntity<RentalHeader> ent = null;
		rentalHeaderService.save(rentalHeader);
		if (rentalHeader == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(rentalHeader);
		}
		return ent;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<RentalHeader> update(@RequestBody RentalHeader rentalHeader) {
		ResponseEntity<RentalHeader> ent = null;
		rentalHeaderService.update(rentalHeader);
		if (rentalHeader == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(rentalHeader);
		}
		return ent;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<RentalHeader>> getRoles() {
		ResponseEntity<List<RentalHeader>> flag = ResponseEntity.ok(rentalHeaderService.list());
		return flag;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<RentalHeader> getRoles(@PathVariable("id") int id) {
		ResponseEntity<RentalHeader> flag = ResponseEntity.ok(rentalHeaderService.get(new Long(id)));
		return flag;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteUser(@PathVariable("id") int id) {
		rentalHeaderService.delete(new Long(id));
		ResponseEntity<Integer> flag = ResponseEntity.ok(id);
		return flag;
	}

}