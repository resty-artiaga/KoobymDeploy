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
@Table(name = "auction_comment_detail")
public class AuctionCommentDetail {

	@Id
	@Column(name = "auctionCommentDetailId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long auctionCommentDetailId;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "auctionDetailId")
	private AuctionDetail auctionDetail;
	
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="auctionCommentId")
	private AuctionComment auctionComment;

	
	public AuctionComment getAuctionComment() {
		return auctionComment;
	}
	
	public long getAuctionCommentDetailId() {
		return auctionCommentDetailId;
	}
	
	public AuctionDetail getAuctionDetail() {
		return auctionDetail;
	}
	
	public void setAuctionComment(AuctionComment auctionComment) {
		this.auctionComment = auctionComment;
	}
	
	public void setAuctionCommentDetailId(long auctionCommentDetailId) {
		this.auctionCommentDetailId = auctionCommentDetailId;
	}
	
	public void setAuctionDetail(AuctionDetail auctionDetail) {
		this.auctionDetail = auctionDetail;
	}
}
