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
@Table(name="user_rental")
public class UserRental {
	
	@Id
	@Column(name = "userRentalId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userRentalId;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "rentalDetailId")
	private RentalDetail rentalDetail;
	
	@Column(name="rentStatus")
	private String rentStatus;

	@Column(name="timeStamp")
	private String timeStamp; 
	

	public void setUserRentalId(long userRentalId) {
		this.userRentalId = userRentalId;
	}
	
	public long getUserRentalId() {
		return userRentalId;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setRentalDetail(RentalDetail rentalDetail) {
		this.rentalDetail = rentalDetail;
	}
	
	public RentalDetail getRentalDetail() {
		return rentalDetail;
	}
	
	public void setRentStatus(String rentStatus) {
		this.rentStatus = rentStatus;
		
	}
	
	public String getRentStatus() {
		return rentStatus;
	}
	
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public String getTimeStamp() {
		return timeStamp;
	}

}
