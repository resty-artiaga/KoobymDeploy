package com.koobym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.koobym.model.UserNotification;
import com.koobym.service.UserNotificationService;

@RestController
@RequestMapping(value = "/userNotification")
public class UserNotificationController {

	@Autowired
	private UserNotificationService userNotificationService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<UserNotification> add(@RequestBody UserNotification userNotification) {
		ResponseEntity<UserNotification> ent = null;
		userNotificationService.save(userNotification);
		if (userNotification == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(userNotification);
		}
		return ent;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<UserNotification> update(@RequestBody UserNotification userNotification) {
		ResponseEntity<UserNotification> ent = null;
		userNotificationService.update(userNotification);
		if (userNotification == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(userNotification);
		}
		return ent;
	}

	@RequestMapping(value = "/notificationForUser/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<UserNotification>> getNotificationsForuser(@PathVariable("id") long id) {
		ResponseEntity<List<UserNotification>> flag = ResponseEntity.ok(userNotificationService.list());
		return flag;
	}

	@RequestMapping(value = "/notificationRead/{id}", method = RequestMethod.GET)
	public ResponseEntity<Void> notificationRead(@PathVariable("id") long id) {
		userNotificationService.notificationIsRead(id);
		ResponseEntity<Void> flag = new ResponseEntity<Void>(HttpStatus.OK);
		return flag;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<UserNotification>> getRoles() {
		ResponseEntity<List<UserNotification>> flag = ResponseEntity.ok(userNotificationService.list());
		return flag;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserNotification> getRoles(@PathVariable("id") int id) {
		ResponseEntity<UserNotification> flag = ResponseEntity.ok(userNotificationService.get(new Long(id)));
		return flag;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteUser(@PathVariable("id") int id) {
		userNotificationService.delete(new Long(id));
		ResponseEntity<Integer> flag = ResponseEntity.ok(id);
		return flag;
	}

}