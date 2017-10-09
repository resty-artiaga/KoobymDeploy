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
	@Column(name = "strDay")
	private String strDay;

	public String getStrDay() {
		return strDay;
	}
	
	public void setStrDay(String strDay) {
		this.strDay = strDay;
	}
}
