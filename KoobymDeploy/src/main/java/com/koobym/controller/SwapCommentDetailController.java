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

import com.koobym.model.SwapCommentDetail;
import com.koobym.service.SwapCommentDetailService;
import com.koobym.service.SwapCommentDetailService;

@RestController
@RequestMapping(value = "/swapCommentDetail")
public class SwapCommentDetailController {

	@Autowired
	private SwapCommentDetailService swapCommentDetailService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<SwapCommentDetail> add(@RequestBody SwapCommentDetail SwapCommentDetail) {
		ResponseEntity<SwapCommentDetail> ent = null;
		swapCommentDetailService.save(SwapCommentDetail);
		if (SwapCommentDetail == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(SwapCommentDetail);
		}
		return ent;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<SwapCommentDetail> update(@RequestBody SwapCommentDetail SwapCommentDetail) {
		ResponseEntity<SwapCommentDetail> ent = null;
		swapCommentDetailService.update(SwapCommentDetail);
		if (SwapCommentDetail == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(SwapCommentDetail);
		}
		return ent;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<SwapCommentDetail>> getRoles() {
		ResponseEntity<List<SwapCommentDetail>> flag = ResponseEntity.ok(swapCommentDetailService.list());
		return flag;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<SwapCommentDetail> getRoles(@PathVariable("id") int id) {
		ResponseEntity<SwapCommentDetail> flag = ResponseEntity.ok(swapCommentDetailService.get(new Long(id)));
		return flag;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteUser(@PathVariable("id") int id) {
		swapCommentDetailService.delete(new Long(id));
		ResponseEntity<Integer> flag = ResponseEntity.ok(id);
		return flag;
	}

	@RequestMapping(value = "/getSwapCommentDetailsOfSwapDetail/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<SwapCommentDetail>> deleteUser(@PathVariable("id") long id) {
		ResponseEntity<List<SwapCommentDetail>> flag = ResponseEntity
				.ok(swapCommentDetailService.getSwapCommentDetailOfSwapDetail(id));
		return flag;
	}

}