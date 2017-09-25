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
@Table(name = "day")
public class Day {

	@Id
	@Column(name = "dayId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long dayId;

	@Column(name = "dayName", nullable = false)
	private String dayName;
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "day_time", joinColumns = @JoinColumn(name = "dayId", referencedColumnName = "dayId"), inverseJoinColumns = @JoinColumn(name = "strTime", referencedColumnName = "strTime"))
	private Set<Time> times;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "day_user", joinColumns = @JoinColumn(name = "dayId", referencedColumnName = "dayId"), inverseJoinColumns = @JoinColumn(name = "userId", referencedColumnName = "userId"))
	private long userId;
		
	public long getDayId() {
		return dayId;
	}

	public void setDayId(long dayId) {
		this.dayId = dayId;
	}

	public String getDayName() {
		return dayName;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}
	
	public Set<Time> getTimes() {
		return times;
	}
	
	public void setTimes(Set<Time> times) {
		this.times = times;
	}
	
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
}
