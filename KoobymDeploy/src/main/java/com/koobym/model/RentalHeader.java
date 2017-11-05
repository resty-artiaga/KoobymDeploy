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

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="rental_header")
public class RentalHeader {
	
	@Id
	@Column(name = "rentalHeaderId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long rentalHeaderId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	@JsonProperty(value="user")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rentalDetailId")
	private RentalDetail rentalDetail;
		
	@Column(name="rentalTimeStamp")
	private String rentalTimeStamp;

	@Column(name="dateApproved")
	private String dateApproved;
	
	@Column(name="totalPrice")
	private float totalPrice; 
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "locationId")
	private Location location;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "meet_upId")
	private MeetUp meetUp;

	@Column(name="status")
	private String status;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_day_timeId")
	private UserDayTime userDayTime; 
	
	public void setMeetUp(MeetUp meetUp){
		this.meetUp = meetUp;
	}
	
	public MeetUp getMeetUp(){
		return meetUp;
	}
	
	public void setDateApproved(String dateApproved){
		this.dateApproved = dateApproved;
	}
	
	public String getDateApproved(){
		return dateApproved;
	}
	
	public void setUserDayTime(UserDayTime userDayTime){
		this.userDayTime = userDayTime;
	}
	
	public UserDayTime getUserDayTime(){
		return userDayTime;
	}
	
	public void setRentalDetail(RentalDetail rentalDetail) {
		this.rentalDetail = rentalDetail;
	}
	
	public RentalDetail getRentalDetail() {
		return rentalDetail;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setRentalHeaderId(long rentalHeaderId) {
		this.rentalHeaderId = rentalHeaderId;
	}
	
	public long getRentalHeaderId() {
		return rentalHeaderId;
	}
	
	public void setUserId(User user){
		this.user = user;
	}
	
	public User getUserId() {
		return user;
	}
	
	public void setRentalTimeStamp(String rentalTimeStamp) {
		this.rentalTimeStamp = rentalTimeStamp;
	}
	
	public String getRentalTimeStamp() {
		return rentalTimeStamp;
	}
	
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public float getTotalPrice() {
		return totalPrice;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public Location getLocation() {
		return location;
	}
	
	

}
