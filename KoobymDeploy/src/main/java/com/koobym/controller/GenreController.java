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

import com.koobym.model.Genre;
import com.koobym.service.GenreService;

@RestController
@RequestMapping(value = "/genre")
public class GenreController {

	@Autowired
	private GenreService genreService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Genre> add(@RequestBody Genre genre) {
		ResponseEntity<Genre> ent = null;
		genreService.save(genre);
		if (genre == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(genre);
		}
		return ent;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Genre> update(@RequestBody Genre genre) {
		ResponseEntity<Genre> ent = null;
		genreService.update(genre);
		if (genre == null) {
			ent = ResponseEntity.badRequest().body(null);
		} else {
			ent = ResponseEntity.ok(genre);
		}
		return ent;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Genre>> getRoles() {
		ResponseEntity<List<Genre>> flag = ResponseEntity.ok(genreService.list());
		return flag;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<Genre> getRoles(@PathVariable("id") int id) {
		ResponseEntity<Genre> flag = ResponseEntity.ok(genreService.get(new Long(id)));
		return flag;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteUser(@PathVariable("id") int id) {
		genreService.delete(new Long(id));
		ResponseEntity<Integer> flag = ResponseEntity.ok(id);
		return flag;
	}

}