package com.koobym.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.koobym.model.BookOwner;
import com.koobym.model.User;

public class BookActivityObject implements Comparable<BookActivityObject> {

	private User user;

	private BookOwner bookOwner;

	private String status;

	private String bookStatus;

	private String dateRequest;

	private long bookActivityId;

	public long getBookActivityId() {
		return bookActivityId;
	}

	public void setBookActivityId(long bookActivityId) {
		this.bookActivityId = bookActivityId;
	}

	public BookOwner getBookOwner() {
		return bookOwner;
	}

	public String getDateRequest() {
		return dateRequest;
	}

	public void setBookOwner(BookOwner bookOwner) {
		this.bookOwner = bookOwner;
	}

	public void setDateRequest(String dateRequest) {
		this.dateRequest = dateRequest;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	@Override
	public int compareTo(BookActivityObject o) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		int flag = 0;
		try {
			Date date1 = format.parse(getDateRequest());
			Date date2 = format.parse(o.getDateRequest());
			flag = date2.compareTo(date1);
		} catch (ParseException e) {
			flag = 0;
		}
		return flag;
	}

}
