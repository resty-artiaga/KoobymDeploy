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

	@Column(name = "startingPrice")
	private float startingPrice;
		
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="bookOwnerId")
	private BookOwner bookOwner;

	@Column(name = "endTime")
	private String endTime;
	
	@Column(name = "startTime")
	private String startTime;
	
	@Column(name = "endDate")
	private String endDate;

	@Column(name = "startDate")
	private String startDate;
	
	@Column(name = "auctionStatus")
	private String auctionStatus;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "auctionDescription")
	private String auctionDescription;
	
	public String getStatus(){
		return this.status;
	}
	
	public void setStatus(String status){
		this.status = status;
	}

	public String getStartTime(){
		return this.startTime;
	}
	
	public void setStartTime(String startTime){
		this.startTime = startTime;
	}
	
	public String getEndTime(){
		return this.endTime;
	}
	
	public void setEndTime(String endTime){
		this.endTime = endTime;
	}
	
	public String getAuctionStatus(){
		return this.auctionStatus;
	}
	
	public void setAuctionStatus(String auctionStatus){
		this.auctionStatus=auctionStatus;
	}
	
	public long getAuctionDetailId(){
		return this.auctionDetailId;
	}
	
	public void setAuctionDetailId(long auctionDetailId){
		this.auctionDetailId=auctionDetailId;
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
