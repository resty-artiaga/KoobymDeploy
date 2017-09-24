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

import com.koobym.model.Day;
import com.koobym.service.DayService;

@RestController
@RequestMapping(value = "/day")
public class DayController {

	@Autowired
	private DayService dayService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Day> add(@RequestBody Day day) {
		ResponseEntity<Day> ent = null;
		dayService.save(day);
		if (day == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(day);
		}
		return ent;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Day> update(@RequestBody Day day) {
		ResponseEntity<Day> ent = null;
		dayService.update(day);
		if (day == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(day);
		}
		return ent;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Day>> getRoles() {
		ResponseEntity<List<Day>> flag = ResponseEntity.ok(dayService.list());
		return flag;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<Day> getRoles(@PathVariable("id") int id) {
		ResponseEntity<Day> flag = ResponseEntity.ok(dayService.get(new Long(id)));
		return flag;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteDay(@PathVariable("id") int id) {
		dayService.delete(new Long(id));
		ResponseEntity<Integer> flag = ResponseEntity.ok(id);
		return flag;
	}

}