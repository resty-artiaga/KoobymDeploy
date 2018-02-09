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

import com.koobym.model.BookOwner;
import com.koobym.model.RentalHeader;
import com.koobym.model.SwapHeader;
import com.koobym.model.AuctionHeader;
import com.koobym.service.AuctionHeaderService;

@RestController
@RequestMapping(value = "/auctionHeader")
public class AuctionHeaderController {

	@Autowired
	private AuctionHeaderService auctionHeaderService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<AuctionHeader> add(@RequestBody AuctionHeader auctionHeader) {
		ResponseEntity<AuctionHeader> ent = null;
		System.out.println("inside add swap header");
		auctionHeaderService.addNewAuctionHeader(auctionHeader);
		if (auctionHeader == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(auctionHeader);
		}
		return ent;
	}

	@RequestMapping(value = "/toReceiveById/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<AuctionHeader>> getToReceiveById(@PathVariable("userId") int userId) {
		ResponseEntity<List<AuctionHeader>> flag = ResponseEntity.ok(auctionHeaderService.getToReceiveById(userId));
		return flag;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<AuctionHeader> update(@RequestBody AuctionHeader auctionHeader) {
		ResponseEntity<AuctionHeader> ent = null;
		auctionHeaderService.update(auctionHeader);
		if (auctionHeader == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(auctionHeader);
		}
		return ent;
	}
	
	@RequestMapping(value = "/updateStatus/{status}/{auctionHeaderId}/{date}", method = RequestMethod.GET)
	public ResponseEntity<AuctionHeader> setApprovedExam(@PathVariable("auctionHeaderId") int auctionHeaderId,
			@PathVariable("status") String status, @PathVariable("date") String date) {
		ResponseEntity<AuctionHeader> flag = ResponseEntity.ok(auctionHeaderService.setApprovedExam(auctionHeaderId, status, date));
		return flag;
	}

	@RequestMapping(value = "/toDeliverById/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<AuctionHeader>> getToDeliverById(@PathVariable("userId") int userId) {
		ResponseEntity<List<AuctionHeader>> flag = ResponseEntity.ok(auctionHeaderService.getToDeliverById(userId));
		return flag;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<AuctionHeader>> getRoles() {
		ResponseEntity<List<AuctionHeader>> flag = ResponseEntity.ok(auctionHeaderService.list());
		return flag;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<AuctionHeader> getRoles(@PathVariable("id") int id) {
		ResponseEntity<AuctionHeader> flag = ResponseEntity.ok(auctionHeaderService.get(new Long(id)));
		return flag;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteUser(@PathVariable("id") int id) {
		auctionHeaderService.delete(new Long(id));
		ResponseEntity<Integer> flag = ResponseEntity.ok(id);
		return flag;
	}

	@RequestMapping(value = "/getAuctionHeader/{auctionDetailId}/{userId}", method = RequestMethod.GET)
	public ResponseEntity<AuctionHeader> getAuctionHeader(@PathVariable("auctionDetailId") int auctionDetailId, @PathVariable("userId") int userId) {
		ResponseEntity<AuctionHeader> flag = ResponseEntity.ok(auctionHeaderService.getAuctionHeader(auctionDetailId, userId));
		return flag;
	}
}