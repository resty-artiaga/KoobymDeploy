package com.koobym.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rate")
public class Rate {

	@Id
	@Column(name = "rateId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long rateId;

	@Column(name = "rateNumber")
	private float rateNumber;

	@Column(name = "rateTimeStamp")
	private String rateTimeStamp;

	public long getRateId() {
		return rateId;
	}

	public float getRateNumber() {
		return rateNumber;
	}

	public String getRateTimeStamp() {
		return rateTimeStamp;
	}

	public void setRateId(long rateId) {
		this.rateId = rateId;
	}

	public void setRateNumber(float rateNumber) {
		this.rateNumber = rateNumber;
	}

	public void setRateTimeStamp(String rateTimeStamp) {
		this.rateTimeStamp = rateTimeStamp;
	}
}
