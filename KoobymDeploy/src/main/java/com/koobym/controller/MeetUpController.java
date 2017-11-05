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

import com.koobym.model.MeetUp;
import com.koobym.service.MeetUpService;

@RestController
@RequestMapping(value = "/meetUp")
public class MeetUpController {

	@Autowired
	private MeetUpService meetUpService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<MeetUp> add(@RequestBody MeetUp meetUp) {
		ResponseEntity<MeetUp> ent = null;
		meetUpService.save(meetUp);
		if (meetUp == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(meetUp);
		}
		return ent;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<MeetUp> update(@RequestBody MeetUp mMeetUp) {
		ResponseEntity<MeetUp> ent = null;
		meetUpService.update(mMeetUp);
		if (mMeetUp == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(mMeetUp);
		}
		return ent;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<MeetUp>> getRoles() {
		ResponseEntity<List<MeetUp>> flag = ResponseEntity.ok(meetUpService.list());
		return flag;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<MeetUp> getRoles(@PathVariable("id") int id) {
		ResponseEntity<MeetUp> flag = ResponseEntity.ok(meetUpService.get(new Long(id)));
		return flag;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteUser(@PathVariable("id") int id) {
		meetUpService.delete(new Long(id));
		ResponseEntity<Integer> flag = ResponseEntity.ok(id);
		return flag;
	}

}