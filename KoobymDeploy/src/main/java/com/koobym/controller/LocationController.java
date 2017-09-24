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

import com.koobym.model.Location;
import com.koobym.service.LocationService;

@RestController
@RequestMapping(value = "/location")
public class LocationController {

	@Autowired
	private LocationService locationService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Location> add(@RequestBody Location location) {
		ResponseEntity<Location> ent = null;
		locationService.save(location);
		if (location == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(location);
		}
		return ent;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Location> update(@RequestBody Location location) {
		ResponseEntity<Location> ent = null;
		locationService.update(location);
		if (location == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(location);
		}
		return ent;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Location>> getRoles() {
		ResponseEntity<List<Location>> flag = ResponseEntity.ok(locationService.list());
		return flag;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<Location> getRoles(@PathVariable("id") int id) {
		ResponseEntity<Location> flag = ResponseEntity.ok(locationService.get(new Long(id)));
		return flag;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteUser(@PathVariable("id") int id) {
		locationService.delete(new Long(id));
		ResponseEntity<Integer> flag = ResponseEntity.ok(id);
		return flag;
	}

}