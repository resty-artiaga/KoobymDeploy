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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="auction_header")
public class AuctionHeader {
	
	@Id
	@Column(name = "auctionHeaderId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long auctionHeaderId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "auctionDetailId")
	private AuctionDetail auctionDetail;
	
	@Column(name="auctionHeaderDateStamp")
	private String auctionHeaderDateStamp;

	@Column(name="dateDelivered")
	private String dateDelivered;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "meetUpId")
	private MeetUp meetUp;
	
	@Column(name="status")
	private String status;
	
	@Column(name="auctionExtraMessage")
	private String auctionExtraMessage;
	
	public String getAuctionExtraMessage(){
		return this.auctionExtraMessage;
	}
	
	public void setAuctionExtraMessage(String auctionExtraMessage){
		this.auctionExtraMessage = auctionExtraMessage;
	}
	
	public String getDateDelivered(){
		return this.dateDelivered;
	}
	
	public void setDateDelivered(String dateDelivered){
		this.dateDelivered = dateDelivered;
	}

	public long getAuctionHeaderId(){
		return auctionHeaderId;
	}
	
	public void setAuctionHeaderId(long auctionHeaderId){
		this.auctionHeaderId = auctionHeaderId;
	}
	
	public MeetUp getMeetUp() {
		return meetUp;
	}
	
	public void setMeetUp(MeetUp meetUp) {
		this.meetUp = meetUp;
	}

		
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setAuctionDetail(AuctionDetail auctionDetail) {
		this.auctionDetail = auctionDetail;
	}
	
	public AuctionDetail getAuctionDetail() {
		return auctionDetail;
	}
	
	public void setAuctionHeaderDateStamp(String auctionHeaderDateStamp) {
		this.auctionHeaderDateStamp = auctionHeaderDateStamp;
	}
	
	public String getAuctionHeaderDateStamp() {
		return auctionHeaderDateStamp;
	}
		
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}

}
