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

import com.koobym.model.SwapComment;
import com.koobym.service.SwapCommentService;

@RestController
@RequestMapping(value = "/swapComment")
public class SwapCommentController {

	@Autowired
	private SwapCommentService swapCommentService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<SwapComment> add(@RequestBody SwapComment swapComment) {
		ResponseEntity<SwapComment> ent = null;
		swapCommentService.save(swapComment);
		if (swapComment == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(swapComment);
		}
		return ent;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<SwapComment> update(@RequestBody SwapComment swapComment) {
		ResponseEntity<SwapComment> ent = null;
		swapCommentService.update(swapComment);
		if (swapComment == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(swapComment);
		}
		return ent;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<SwapComment>> getRoles() {
		ResponseEntity<List<SwapComment>> flag = ResponseEntity.ok(swapCommentService.list());
		return flag;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<SwapComment> getRoles(@PathVariable("id") int id) {
		ResponseEntity<SwapComment> flag = ResponseEntity.ok(swapCommentService.get(new Long(id)));
		return flag;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteUser(@PathVariable("id") int id) {
		swapCommentService.delete(new Long(id));
		ResponseEntity<Integer> flag = ResponseEntity.ok(id);
		return flag;
	}

}