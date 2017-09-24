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
@Table(name="rental_detail")
public class RentalDetail {
	
	@Id
	@Column(name = "rental_detailId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long rental_detailId;

	@Column(name = "daysForRent")
	private int daysForRent;

	@Column(name = "calculatedPrice", nullable = false)
	private Double calculatedPrice;
		
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="bookOwnerId")
	private BookOwner bookOwner;

	public long getRental_detailId() {
		return rental_detailId;
	}

	public void setRental_detailId(long rental_detailId) {
		this.rental_detailId = rental_detailId;
	}

	public int getDaysForRent() {
		return daysForRent;
	}

	public void setDaysForRent(int daysForRent) {
		this.daysForRent = daysForRent;
	}

	public Double getCalculatedPrice() {
		return calculatedPrice;
	}

	public void setCalculatedPrice(Double calculatedPrice) {
		this.calculatedPrice = calculatedPrice;
	}

	public BookOwner getBookOwner() {
		return bookOwner;
	}

	public void setBookOwner(BookOwner bookOwner) {
		this.bookOwner = bookOwner;
	}
	
	

}
