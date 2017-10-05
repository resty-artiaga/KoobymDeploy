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
@Table(name="swap_header")
public class SwapHeader {
	
	@Id
	@Column(name = "swap_headerId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long swapHeaderId;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "swap_detailId")
	private SwapDetail swapDetail;
		
	@Column(name="dateSwap")
	private String dateTimeStamp;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "userDayTimeId")
	private UserDayTime userDayTime; 
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "locationId")
	private Location location;
	
	@Column(name="status")
	private String status;
	
	public void setSwapHeaderId(long swapHeaderId) {
		this.swapHeaderId = swapHeaderId;
	}
	
	public long getSwapHeaderId() {
		return swapHeaderId;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setSwapDetail(SwapDetail swapDetail) {
		this.swapDetail = swapDetail;
	}
	
	public SwapDetail getSwapDetail() {
		return swapDetail;
	}
	
	public void setDateTimeStamp(String dateTimeStamp) {
		this.dateTimeStamp = dateTimeStamp;
	}
	
	public String getDateTimeStamp() {
		return dateTimeStamp;
	}
	
	public void setUserDayTime(UserDayTime userDayTime) {
		this.userDayTime = userDayTime;
	}
	
	public UserDayTime getUserDayTime() {
		return userDayTime;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}

}
