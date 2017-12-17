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
@Table(name = "auction_comment")
public class AuctionComment {

	@Id
	@Column(name = "auctionCommentId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long auctionCommentId;

	@Column(name = "auctionComment")
	private String auctionComment;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "userId")
	private User user;
	
	
	public void setAuctionCommentId(long auctionCommentId) {
		this.auctionCommentId = auctionCommentId;
	}	
	
	public long getAuctionCommentId() {
		return auctionCommentId;
	}
	
	public void setAuctionComment(String auctionComment) {
		this.auctionComment = auctionComment;
	}
	
	public String getAuctionComment() {
		return auctionComment;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
}
