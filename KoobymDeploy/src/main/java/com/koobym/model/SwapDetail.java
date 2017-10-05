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
@Table(name="swap_detail")
public class SwapDetail {
	
	@Id
	@Column(name = "swap_detailId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long swap_detailId;

	@Column(name = "swapDescription")
	private String swapDescription;

	@Column(name = "swapTimeStamp")
	private String swapTimeStamp;
		
	@Column(name = "swapPrice")
	private float price;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="bookOwnerId")
	private BookOwner bookOwner;

	public float getSwapPrice() {
		return price;
	}
	
	public void setSwapPrice(float price) {
		this.price = price;
	}

	public long getSwapDetailId() {
		return swap_detailId;
	}
	
	public void setSwapDetailId(long swap_detailId) {
		this.swap_detailId = swap_detailId;
	}
	
	public String getSwapDescription() {
		return swapDescription;
	}
	
	public void setSwapDescription(String swapDescription) {
		this.swapDescription = swapDescription;
	}
	
	public String getSwapTimeStamp() {
		return swapTimeStamp;
	}
	
	public void setSwapTimeStamp(String swapTimeStamp) {
		this.swapTimeStamp = swapTimeStamp;
	}
	
	public BookOwner getBookOwner() {
		return bookOwner;
	}
	
	public void setBookOwner(BookOwner bookOwner) {
		this.bookOwner = bookOwner;
	}

}
