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

import com.koobym.model.AuctionComment;
import com.koobym.service.AuctionCommentService;

@RestController
@RequestMapping(value = "/auctionComment")
public class AuctionCommentController {

	@Autowired
	private AuctionCommentService auctionCommentService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<AuctionComment> add(@RequestBody AuctionComment auctionComment) {
		ResponseEntity<AuctionComment> ent = null;
		auctionCommentService.save(auctionComment);
		if (auctionComment == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(auctionComment);
		}
		return ent;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<AuctionComment> update(@RequestBody AuctionComment auctionComment) {
		ResponseEntity<AuctionComment> ent = null;
		auctionCommentService.update(auctionComment);
		if (auctionComment == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(auctionComment);
		}
		return ent;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<AuctionComment>> getRoles() {
		ResponseEntity<List<AuctionComment>> flag = ResponseEntity.ok(auctionCommentService.list());
		return flag;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<AuctionComment> getRoles(@PathVariable("id") int id) {
		ResponseEntity<AuctionComment> flag = ResponseEntity.ok(auctionCommentService.get(new Long(id)));
		return flag;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteUser(@PathVariable("id") int id) {
		auctionCommentService.delete(new Long(id));
		ResponseEntity<Integer> flag = ResponseEntity.ok(id);
		return flag;
	}

}