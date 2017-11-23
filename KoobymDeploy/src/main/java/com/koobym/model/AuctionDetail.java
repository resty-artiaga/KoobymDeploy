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
@Table(name="auction_detail")
public class AuctionDetail {
	
	@Id
	@Column(name = "auctionDetailId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long auctionDetailId;

	@Column(name = "userId")
	private User user;

	@Column(name = "startingPrice")
	private float startingPrice;
		
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="bookOwnerId")
	private BookOwner bookOwner;
	
	@Column(name = "endDate")
	private String endDate;

	@Column(name = "startDate")
	private String startDate;
	
	@Column(name = "auctionDescription")
	private String auctionDescription;
	
	public long getAuctionDetailId(){
		return this.auctionDetailId;
	}
	
	public void setAuctionDetailId(long auctionDetailId){
		this.auctionDetailId=auctionDetailId;
	}
	
	public User getUser(){
		return this.user;
	}
	
	public void setUser(User user){
		this.user = user;
	}
	
	public float getStartingPrice(){
		return this.startingPrice;
	}
	
	public void setStartingPrice(float startingPrice){
		this.startingPrice = startingPrice;
	}

	public BookOwner getBookOwner(){
		return this.bookOwner;
	}
	
	public void setBookOwner(BookOwner bookOwner){
		this.bookOwner = bookOwner;
	}
	
	public String getEndDate(){
		return this.endDate;
	}
	
	public void setEndDate(String endDate){
		this.endDate = endDate;
	}
	
	public String getStartDate(){
		return this.startDate;
	}
	
	public void setStartDate(String startDate){
		this.startDate = startDate;
	}
	
	public String getAuctionDescription(){
		return this.auctionDescription;
	}
	
	public void setAuctionDescription(String auctionDescription){
		this.auctionDescription = auctionDescription;
	}

}
