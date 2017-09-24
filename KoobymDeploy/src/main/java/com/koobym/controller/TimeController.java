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

import com.koobym.model.Time;
import com.koobym.service.TimeService;

@RestController
@RequestMapping(value = "/time")
public class TimeController {

	@Autowired
	private TimeService timeService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Time> add(@RequestBody Time time) {
		ResponseEntity<Time> ent = null;
		timeService.save(time);
		if (time == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(time);
		}
		return ent;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Time> update(@RequestBody Time time) {
		ResponseEntity<Time> ent = null;
		timeService.update(time);
		if (time == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(time);
		}
		return ent;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Time>> getRoles() {
		ResponseEntity<List<Time>> flag = ResponseEntity.ok(timeService.list());
		return flag;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<Time> getRoles(@PathVariable("id") int id) {
		ResponseEntity<Time> flag = ResponseEntity.ok(timeService.get(new Long(id)));
		return flag;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteTime(@PathVariable("id") int id) {
		timeService.delete(new Long(id));
		ResponseEntity<Integer> flag = ResponseEntity.ok(id);
		return flag;
	}

}