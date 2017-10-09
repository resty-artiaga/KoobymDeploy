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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class Review {

	@Id
	@Column(name = "userId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;

	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "location_user", joinColumns = @JoinColumn(name = "userId", referencedColumnName = "userId"), inverseJoinColumns = @JoinColumn(name = "locationId", referencedColumnName = "locationId"))
	private Set<Location> locations;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "genre_user", joinColumns = @JoinColumn(name = "userId", referencedColumnName = "userId"), inverseJoinColumns = @JoinColumn(name = "genreId", referencedColumnName = "genreId"))
	private Set<Genre> genres;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="userId")
	private Set<UserDayTime> userDayTimes;
	
	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "username")
	private String username;

	@Column(name = "userLname")
	private String userLname;

	@Column(name = "userFname")
	private String userFname;

	@Column(name = "phoneNumber")
	private String phoneNumber;

	@Column(name = "address")
	private String address;
	
	@Column(name = "birthdate")
	private String birthdate;
	
	@Column(name = "imageFilename")
	private String imageFilename;
	
	@Column(name="fbUserId")
	private String userFbId;
	
	public void setUserDayTimes(Set<UserDayTime> userDayTimes) {
		this.userDayTimes = userDayTimes;
	}
	
	public Set<UserDayTime> getUserDayTimes(){
		return userDayTimes;
	}
	
	public String getUserFbId() {
		return userFbId;
	}
	
	public void setUserFbId(String userFbId) {
		this.userFbId = userFbId;
	}
	
	public Set<Location> getLocations(){
		return locations;
	}
	
	public void setLocations(Set<Location> locations) {
		this.locations = locations;
	}
	
	public Set<Genre> getGenres() {
		return genres;
	}
	
	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserLname() {
		return userLname;
	}

	public void setUserLname(String userLname) {
		this.userLname = userLname;
	}

	public String getUserFname() {
		return userFname;
	}

	public void setUserFname(String userFname) {
		this.userFname = userFname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getImageFilename() {
		return imageFilename;
	}

	public void setImageFilename(String imageFilename) {
		this.imageFilename = imageFilename;
	}

	
}
