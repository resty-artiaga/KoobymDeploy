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
@Table(name = "meet_up")
public class MeetUp {

	@Id
	@Column(name = "meet_upId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long meetUpId;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "locationId")
	private Location location;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userDayTimeId")
	private UserDayTime userDayTime;
	
	public void setMeetUpId(long meetUpId){
		this.meetUpId = meetUpId;
	}
	
	public long getMeetUpId(){
		return meetUpId;
	}
	
	public void setLocation(Location location){
		this.location = location;
	}
	
	public Location getLocation(){
		return location;
	}
	
	public void setUserDayTime(UserDayTime userDayTime){
		this.userDayTime = userDayTime;
	}
	
	public UserDayTime getUserDayTime(){
		return userDayTime;
	}
}
