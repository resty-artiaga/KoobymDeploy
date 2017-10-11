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
@Table(name = "user_rating")
public class UserRating {

	@Id
	@Column(name = "user_ratingId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userRatingId;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "reviewId")
	private Review review;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "rateId")
	private Rate rate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private User user;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userRaterId")
	private User userRater;

	@Column(name = "comment")
	private String comment;
	
	public User getUserRater() {
		return userRater;
	}
	
	public void setUserRater(User userRater) {
		this.userRater = userRater;
	}

	public String getComment() {
		return comment;
	}

	public Rate getRate() {
		return rate;
	}

	public Review getReview() {
		return review;
	}

	public User getUser() {
		return user;
	}

	public long getUserRatingId() {
		return userRatingId;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setRate(Rate rate) {
		this.rate = rate;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserRatingId(long userRatingId) {
		this.userRatingId = userRatingId;
	}

}
