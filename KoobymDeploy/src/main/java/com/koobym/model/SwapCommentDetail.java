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
@Table(name = "swap_comment_detail")
public class SwapCommentDetail {

	@Id
	@Column(name = "swapCommentDetailId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long swapCommentDetailId;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "swap_detailId")
	private SwapDetail swapDetail;
	
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="swapCommentId")
	private SwapComment swapComment;

	
	public SwapComment getSwapComment() {
		return swapComment;
	}
	
	public long getSwapCommentDetailId() {
		return swapCommentDetailId;
	}
	
	public SwapDetail getSwapDetail() {
		return swapDetail;
	}
	
	public void setSwapComment(SwapComment swapComment) {
		this.swapComment = swapComment;
	}
	
	public void setSwapCommentDetailId(long swapCommentDetailId) {
		this.swapCommentDetailId = swapCommentDetailId;
	}
	
	public void setSwapDetail(SwapDetail swapDetail) {
		this.swapDetail = swapDetail;
	}
}
