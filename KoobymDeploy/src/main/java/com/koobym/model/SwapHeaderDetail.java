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
@Table(name = "swap_header_detail")
public class SwapHeaderDetail {

	@Id
	@Column(name = "swapHeaderDetailId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long swapHeaderDetailId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "swapDetailId")
	private SwapDetail swapDetail;

	@Column(name = "swapHeaderId")
	private long swapHeaderId;

	@Column(name = "swapType")
	private String swapType;

	public String getSwapType() {
		return swapType;
	}

	public void setSwapType(String swapType) {
		this.swapType = swapType;
	}

	public SwapDetail getSwapDetail() {
		return swapDetail;
	}

	public long getSwapHeaderDetailId() {
		return swapHeaderDetailId;
	}

	public long getSwapHeaderId() {
		return swapHeaderId;
	}

	public void setSwapDetail(SwapDetail swapDetail) {
		this.swapDetail = swapDetail;
	}

	public void setSwapHeaderDetailId(long swapHeaderDetailId) {
		this.swapHeaderDetailId = swapHeaderDetailId;
	}

	public void setSwapHeaderId(long swapHeaderId) {
		this.swapHeaderId = swapHeaderId;
	}
}
