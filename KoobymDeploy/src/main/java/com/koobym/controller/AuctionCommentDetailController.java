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

import com.koobym.model.AuctionCommentDetail;
import com.koobym.service.AuctionCommentDetailService;

@RestController
@RequestMapping(value = "/auctionCommentDetail")
public class AuctionCommentDetailController {

	@Autowired
	private AuctionCommentDetailService auctionCommentDetailService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<AuctionCommentDetail> add(@RequestBody AuctionCommentDetail AuctionCommentDetail) {
		ResponseEntity<AuctionCommentDetail> ent = null;
		auctionCommentDetailService.save(AuctionCommentDetail);
		if (AuctionCommentDetail == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(AuctionCommentDetail);
		}
		return ent;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<AuctionCommentDetail> update(@RequestBody AuctionCommentDetail auctionCommentDetail) {
		ResponseEntity<AuctionCommentDetail> ent = null;
		auctionCommentDetailService.update(auctionCommentDetail);
		if (auctionCommentDetail == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(auctionCommentDetail);
		}
		return ent;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<AuctionCommentDetail>> getRoles() {
		ResponseEntity<List<AuctionCommentDetail>> flag = ResponseEntity.ok(auctionCommentDetailService.list());
		return flag;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<AuctionCommentDetail> getRoles(@PathVariable("id") int id) {
		ResponseEntity<AuctionCommentDetail> flag = ResponseEntity.ok(auctionCommentDetailService.get(new Long(id)));
		return flag;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteUser(@PathVariable("id") int id) {
		auctionCommentDetailService.delete(new Long(id));
		ResponseEntity<Integer> flag = ResponseEntity.ok(id);
		return flag;
	}

	@RequestMapping(value = "/getSwapCommentDetailsOfSwapDetail/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<AuctionCommentDetail>> deleteUser(@PathVariable("id") long id) {
		ResponseEntity<List<AuctionCommentDetail>> flag = ResponseEntity
				.ok(auctionCommentDetailService.getAuctionCommentDetailOfAuctionDetail(id));
		return flag;
	}

}