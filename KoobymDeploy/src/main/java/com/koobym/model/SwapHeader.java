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
	@Column(name = "swapHeaderId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long swapHeaderId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "swap_detailId")
	private SwapDetail swapDetail;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "requested_swap_detailId")
	private SwapDetail requestedSwapDetail;
		
	@Column(name="dateSwap")
	private String dateTimeStamp;

	@Column(name="dateRequest")
	private String dateRequest;

	@Column(name="dateApproved")
	private String dateApproved;

	@Column(name="dateRejected")
	private String dateRejected;

	@Column(name="dateConfirmed")
	private String dateConfirmed;

	@Column(name="dateReceived")
	private String dateReceived;
	
	@Column(name="dateDelivered")
	private String dateDelivered;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userDayTimeId")
	private UserDayTime userDayTime; 
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "locationId")
	private Location location;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "meetUpId")
	private MeetUp meetUp;
	
	@Column(name="status")
	private String status;

	public String getDateDelivered(){
		return this.dateDelivered;
	}
	
	public void setDateDelivered(String dateDelivered){
		this.dateDelivered = dateDelivered;
	}
	
	public MeetUp getMeetUp() {
		return meetUp;
	}
	
	public void setMeetUp(MeetUp meetUp) {
		this.meetUp = meetUp;
	}

	public String getDateReceived() {
		return dateReceived;
	}
	
	public void setDatev(String dateReceived) {
		this.dateReceived = dateReceived;
	}
	
	public String getDateConfirmed() {
		return dateConfirmed;
	}
	
	public void setDateConfirmed(String dateConfirmed) {
		this.dateConfirmed = dateConfirmed;
	}
	
	public String getDateRejected() {
		return dateRejected;
	}
	
	public void setDateRejected(String dateRejected) {
		this.dateRejected = dateRejected;
	}
	
	public String getDateApproved() {
		return dateApproved;
	}
	
	public void setDateApproved(String dateApproved) {
		this.dateApproved = dateApproved;
	}
	
	public String getDateRequest() {
		return dateRequest;
	}
	
	public void setDateRequest(String dateRequest) {
		this.dateRequest = dateRequest;
	}

	public SwapDetail getRequestedSwapDetail() {
		return requestedSwapDetail;
	}
	
	public void setRequestedSwapDetail(SwapDetail requestedSwapDetail) {
		this.requestedSwapDetail = requestedSwapDetail;
	}
	
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
