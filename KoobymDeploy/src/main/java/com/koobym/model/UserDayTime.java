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
@Table(name = "user_day_time")
public class UserDayTime {

	@Id
	@Column(name = "userDayTimeId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userDayTimeId;
	
	@Column(name="userId")
	private long userId;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "strDay")
	private Day days;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "strTime")
	private Time times;
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	@Column(name = "userId")
	public long getUserId() {
		return userId;
	}
	
	@Column(name = "userDayTimeId")
	public long getUserDayTimeId() {
		return userDayTimeId;
	}
	
	public void setUserDayTimeId(long userDayTimeId) {
		this.userDayTimeId = userDayTimeId;
	}

	public Day getDays(){
		return days;
	}
	
	public void setDays(Day days) {
		this.days = days;
	}
	
	public Time getTimes(){
		return times;
	}
	
	public void setTimes(Time times) {
		this.times = times;
	}
	
}
