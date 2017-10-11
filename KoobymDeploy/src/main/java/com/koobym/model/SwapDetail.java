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

@Entity
@Table(name="swap_detail")
public class SwapDetail {
	
	@Id
	@Column(name = "swap_detailId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long swapDetailId;

	@Column(name = "swapDescription")
	private String swapDescription;

	@Column(name = "swapTimeStamp")
	private String swapTimeStamp;
		
	@Column(name = "swapPrice")
	private float price;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="bookOwnerId")
	private BookOwner bookOwner;

	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "swap_comment_detail", joinColumns = @JoinColumn(name = "swap_detailId", referencedColumnName = "swap_detailId"), inverseJoinColumns = @JoinColumn(name = "swapCommentId", referencedColumnName = "swapCommentId"))
	private Set<SwapComment> swapComments;
	
	public Set<SwapComment> getSwapComments(){
		return swapComments;
	}
	
	public void setSwapComments(Set<SwapComment> swapComments) {
		this.swapComments = swapComments;
	}
	
	public float getSwapPrice() {
		return price;
	}
	
	public void setSwapPrice(float price) {
		this.price = price;
	}

	public long getSwapDetailId() {
		return swapDetailId;
	}
	
	public void setSwapDetailId(long swapDetailId) {
		this.swapDetailId = swapDetailId;
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
