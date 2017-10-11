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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "review")
public class Review {

	@Id
	@Column(name = "reviewId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long reviewId;

	@Column(name = "reviewTimeStamp")
	private String reviewTimeStamp;

	public long getReviewId() {
		return reviewId;
	}

	public String getReviewTimeStamp() {
		return reviewTimeStamp;
	}

	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}

	public void setReviewTimeStamp(String reviewTimeStamp) {
		this.reviewTimeStamp = reviewTimeStamp;
	}

}
