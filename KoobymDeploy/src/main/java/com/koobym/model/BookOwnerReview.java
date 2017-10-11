package com.koobym.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book_owner_review")
public class BookOwnerReview {

	@Id
	@Column(name = "book_owner_reviewId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookOwnerReviewId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "book_ownerId")
	private BookOwner bookOwner;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "reviewId")
	private Review review;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private User user;

	@Column(name = "comment")
	private String comment;

	public BookOwner getBookOwner() {
		return bookOwner;
	}

	public long getBookOwnerReviewId() {
		return bookOwnerReviewId;
	}

	public String getComment() {
		return comment;
	}

	public Review getReview() {
		return review;
	}

	public User getUser() {
		return user;
	}

	public void setBookOwner(BookOwner bookOwner) {
		this.bookOwner = bookOwner;
	}

	public void setBookOwnerReviewId(long bookOwnerReviewId) {
		this.bookOwnerReviewId = bookOwnerReviewId;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
