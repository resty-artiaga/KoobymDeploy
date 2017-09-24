package com.koobym.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "genre")
public class Genre {

	@Id
	@Column(name = "genreId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long genreId;

	@Column(name = "genreName", nullable = false)
	private String genreName;

	public long getGenreId() {
		return genreId;
	}

	public void setGenreId(long genreId) {
		this.genreId = genreId;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setEmail(String genreName) {
		this.genreName = genreName;
	}
	
}
