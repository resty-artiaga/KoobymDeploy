package com.koobym.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.koobym.model.AuctionDetail;
import com.koobym.model.RentalDetail;
import com.koobym.service.AuctionDetailService;

@RestController
@RequestMapping(value = "/auctionDetail")
public class AuctionDetailController {

	@Autowired
	private AuctionDetailService auctionDetailService;


	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<AuctionDetail> add(@RequestBody AuctionDetail auctionDetail) {
		ResponseEntity<AuctionDetail> ent = null;
		auctionDetailService.save(auctionDetail);
		if (auctionDetail == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(auctionDetail);
		}
		return ent;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<AuctionDetail> getRoles(@PathVariable("id") int id) {
		ResponseEntity<AuctionDetail> flag = ResponseEntity.ok(auctionDetailService.get(new Long(id)));
		return flag;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<AuctionDetail>> getList() {
		ResponseEntity<List<AuctionDetail>> flag = ResponseEntity.ok(auctionDetailService.list());
		return flag;
	}

	@RequestMapping(value = "/auctionById/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<AuctionDetail>> getAuctionId(@PathVariable("userId") int userId) {
		ResponseEntity<List<AuctionDetail>> flag = ResponseEntity.ok(auctionDetailService.getAuctionById(userId));
		return flag;
	}

	@RequestMapping(value = "/getAuctionDetail/{bookOwnerId}", method = RequestMethod.GET)
	public ResponseEntity<AuctionDetail> getAuctionDetail(@PathVariable("bookOwnerId") long bookOwnerId) {
		ResponseEntity<AuctionDetail> flag = ResponseEntity.ok(auctionDetailService.getAuctionDetail(bookOwnerId));
		return flag;
	}
	
	@RequestMapping(value = "/setBookOwnerAsAuction", method = RequestMethod.POST)
	public ResponseEntity<AuctionDetail> setBookOwnerAsAuction(@RequestBody AuctionDetail auctionDetail) {
		ResponseEntity<AuctionDetail> ent = null;
		auctionDetailService.setBookOwnerAsAuction(auctionDetail);
		if (auctionDetail == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(auctionDetail);
		}
		return ent;
	}
}