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
import com.koobym.model.SwapHeader;
import com.koobym.service.SwapHeaderService;

@RestController
@RequestMapping(value = "/swapHeader")
public class SwapHeaderController {

	@Autowired
	private SwapHeaderService swapHeaderService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<SwapHeader> add(@RequestBody SwapHeader swapHeader) {
		ResponseEntity<SwapHeader> ent = null;
		System.out.println("inside add swap header");
		swapHeaderService.save(swapHeader);
		if (swapHeader == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(swapHeader);
		}
		return ent;
	}

	@RequestMapping(value = "/swapRequested", method = RequestMethod.POST)
	public ResponseEntity<SwapHeader> swapRequested(@RequestBody SwapHeader swapHeader) {
		ResponseEntity<SwapHeader> ent = null;
		System.out.println("swapdetailId" + swapHeader.getSwapDetail().getSwapDetailId());
		swapHeaderService.swapRequested(swapHeader);
		if (swapHeader == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(swapHeader);
		}
		return ent;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<SwapHeader> update(@RequestBody SwapHeader swapHeader) {
		ResponseEntity<SwapHeader> ent = null;
		swapHeaderService.update(swapHeader);
		if (swapHeader == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(swapHeader);
		}
		return ent;
	}

	@RequestMapping(value = "/getRequestedSwaps/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<SwapHeader>> getRequestedSwaps(@PathVariable("id") long id) {
		ResponseEntity<List<SwapHeader>> flag = ResponseEntity.ok(swapHeaderService.getRequestedSwaps(id));
		return flag;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<SwapHeader>> getRoles() {
		ResponseEntity<List<SwapHeader>> flag = ResponseEntity.ok(swapHeaderService.list());
		return flag;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<SwapHeader> getRoles(@PathVariable("id") int id) {
		ResponseEntity<SwapHeader> flag = ResponseEntity.ok(swapHeaderService.get(new Long(id)));
		return flag;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteUser(@PathVariable("id") int id) {
		swapHeaderService.delete(new Long(id));
		ResponseEntity<Integer> flag = ResponseEntity.ok(id);
		return flag;
	}

	@RequestMapping(value = "/toDeliverById/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<SwapHeader>> getToDeliverById(@PathVariable("userId") int userId) {
		ResponseEntity<List<SwapHeader>> flag = ResponseEntity.ok(swapHeaderService.getToDeliverById(userId));
		return flag;
	}

	@RequestMapping(value = "/toReceiveById/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<SwapHeader>> getToReceiveByIdRenter(@PathVariable("userId") int userId) {
		ResponseEntity<List<SwapHeader>> flag = ResponseEntity.ok(swapHeaderService.getToReceiveByIdRenter(userId));
		return flag;
	}

	@RequestMapping(value = "/updateStatus/{status}/{swapHeaderId}", method = RequestMethod.GET)
	public ResponseEntity<SwapHeader> setApprovedExam(@PathVariable("swapHeaderId") int swapHeaderId,
			@PathVariable("status") String status) {
		ResponseEntity<SwapHeader> flag = ResponseEntity.ok(swapHeaderService.setApprovedExam(swapHeaderId, status));
		return flag;
	}
	
	@RequestMapping(value = "/toApproveById/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<SwapHeader>> getToApproveSwaps(@PathVariable("userId") int userId) {
		ResponseEntity<List<SwapHeader>> flag = ResponseEntity.ok(swapHeaderService.getToApproveSwaps(userId));
		return flag;
	}
	
	@RequestMapping(value = "/completeById/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<SwapHeader>> getCompleteById(@PathVariable("userId") int userId) {
		ResponseEntity<List<SwapHeader>> flag = ResponseEntity.ok(swapHeaderService.getCompleteById(userId));
		return flag;
	}
	
	@RequestMapping(value = "/approvedById/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<SwapHeader>> getApprovedSwaps(@PathVariable("userId") int userId) {
		ResponseEntity<List<SwapHeader>> flag = ResponseEntity.ok(swapHeaderService.getApprovedSwaps(userId));
		return flag;
	}
	
	@RequestMapping(value = "/rejectedOwner/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<SwapHeader>> getRejectedByIdOwner(@PathVariable("userId") int userId) {
		ResponseEntity<List<SwapHeader>> flag = ResponseEntity.ok(swapHeaderService.getRejectedByIdOwner(userId));
		return flag;
	}
	
	@RequestMapping(value = "/completeAll/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<SwapHeader>> getCompleteAllById(@PathVariable("userId") int userId) {
		ResponseEntity<List<SwapHeader>> flag = ResponseEntity.ok(swapHeaderService.getCompleteAllById(userId));
		return flag;
	}
	
}