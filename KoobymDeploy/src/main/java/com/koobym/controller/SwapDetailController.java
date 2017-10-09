package com.koobym.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.koobym.model.RentalDetail;
import com.koobym.model.RentalHeader;
import com.koobym.model.SwapDetail;
import com.koobym.model.User;
import com.koobym.service.SwapDetailService;

@RestController
@RequestMapping(value = "/swapDetail")
public class SwapDetailController {

	@Autowired
	private SwapDetailService swapDetailService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<SwapDetail>> getListAll() {
		ResponseEntity<List<SwapDetail>> flag = ResponseEntity.ok(swapDetailService.list());
		return flag;
	}
	
	@RequestMapping(value = "/swapDetailById/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<SwapDetail>> getRentalId(@PathVariable("userId") int userId) {
		ResponseEntity<List<SwapDetail>> flag = ResponseEntity.ok(swapDetailService.getSwapById(userId));
		return flag;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<SwapDetail> add(@RequestBody SwapDetail swapDetail) {
		ResponseEntity<SwapDetail> ent = null;
		swapDetailService.save(swapDetail);
		if (swapDetail == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(swapDetail);
		}
		return ent;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<SwapDetail> update(@RequestBody SwapDetail swapDetail) {
		ResponseEntity<SwapDetail> ent = null;
		swapDetailService.update(swapDetail);
		if (swapDetail == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(swapDetail);
		}
		return ent;
	}


	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<SwapDetail> getRolesId(@PathVariable("id") int id) {
		ResponseEntity<SwapDetail> flag = ResponseEntity.ok(swapDetailService.get(new Long(id)));
		return flag;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteUser(@PathVariable("id") int id) {
		swapDetailService.delete(new Long(id));
		ResponseEntity<Integer> flag = ResponseEntity.ok(id);
		return flag;
	}
	
	@RequestMapping(value = "/mySwapBooks/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<SwapDetail>> getSwapById(@PathVariable("userId") int userId) {
		ResponseEntity<List<SwapDetail>> flag = ResponseEntity.ok(swapDetailService.getSwapById(userId));
		return flag;
	}
	
	@RequestMapping(value = "/mySwapBooksPrice/{userId}/{price}", method = RequestMethod.GET)
	public ResponseEntity<List<SwapDetail>> getSwapPriceById(@PathVariable("userId") int userId, @PathVariable("price") float price) {
		ResponseEntity<List<SwapDetail>> flag = ResponseEntity.ok(swapDetailService.getSwapPriceById(userId, price));
		return flag;
	}
	
	@RequestMapping(value = "/getAllSwap", method = RequestMethod.GET)
	public ResponseEntity<List<SwapDetail>> getAll() {
		ResponseEntity<List<SwapDetail>> flag = ResponseEntity.ok(swapDetailService.getAll());
		return flag;
	}
	
}