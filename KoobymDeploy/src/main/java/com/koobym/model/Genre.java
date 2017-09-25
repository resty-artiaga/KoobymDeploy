package com.koobym.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "day_user", joinColumns = @JoinColumn(name = "dayId", referencedColumnName = "dayId"), inverseJoinColumns = @JoinColumn(name = "userId", referencedColumnName = "userId"))
	private long userId;

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
	
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
}
