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
@Table(name = "book_owner_rating")
public class BookOwnerRating {

	@Id
	@Column(name = "book_owner_ratingId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookOwnerRatingId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "book_ownerId")
	private BookOwner bookOwner;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private User user;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "rateId")
	private Rate rate;

	public BookOwner getBookOwner() {
		return bookOwner;
	}

	public long getBookOwnerRatingId() {
		return bookOwnerRatingId;
	}

	public Rate getRate() {
		return rate;
	}

	public User getUser() {
		return user;
	}

	public void setBookOwner(BookOwner bookOwner) {
		this.bookOwner = bookOwner;
	}

	public void setBookOwnerRatingId(long bookOwnerRatingId) {
		this.bookOwnerRatingId = bookOwnerRatingId;
	}

	public void setRate(Rate rate) {
		this.rate = rate;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
