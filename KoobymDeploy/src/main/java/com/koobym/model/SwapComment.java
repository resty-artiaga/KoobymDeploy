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
@Table(name = "swap_comment")
public class SwapComment {

	@Id
	@Column(name = "swapCommentId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long swapCommentId;

	@Column(name = "swapComment")
	private String swapComment;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;
	
	
	public void setSwapCommentId(long swapCommentId) {
		this.swapCommentId = swapCommentId;
	}	
	
	public long getSwapCommentId() {
		return swapCommentId;
	}
	
	public void setSwapComment(String swapComment) {
		this.swapComment = swapComment;
	}
	
	public String getSwapComment() {
		return swapComment;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
}
