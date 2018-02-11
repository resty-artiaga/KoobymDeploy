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
@Table(name = "book")
public class Book {

	@Id
	@Column(name = "bookId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookId;

	@Column(name = "bookOriginalPrice")
	private Float bookOriginalPrice;

	@Column(name = "bookTitle", nullable = false)
	private String bookTitle;

	@Column(name = "description")
	private String description;

	@Column(name = "publishedDate")
	private String publishedDate;
	
	@Column(name = "bookFilename")
	private String bookFilename;

	@Column(name = "status")
	private String status;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "bookId", referencedColumnName = "bookId"), inverseJoinColumns = @JoinColumn(name = "authorId", referencedColumnName = "authorId"))
	private Set<Author> authors;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "genre_book", joinColumns = @JoinColumn(name = "bookId", referencedColumnName = "bookId"), inverseJoinColumns = @JoinColumn(name = "genreId", referencedColumnName = "genreId"))
	private Set<Genre> genresBook;
	
	public String getStatus(){
		return this.status;
	}
	
	public void setStatus(String status){
		this.status = status;
	}
	
	public String getBookFilename() {
		return bookFilename;
	}
	
	public void setBookFilename(String bookFilename) {
		this.bookFilename = bookFilename;
	}
	
	public long getBookId() {
		return bookId;
	}
	
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	
	public Set<Author> getAuthors(){
		return authors;
	}
	
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	
	public Set<Genre> getGenres() {
		return genresBook;
	}
	
	public void setGenres(Set<Genre> genresBook) {
		this.genresBook = genresBook;
	}

	public Float getBookOriginalPrice() {
		return bookOriginalPrice;
	}

	public void setBookOriginalPrice(Float bookOriginalPrice) {
		this.bookOriginalPrice = bookOriginalPrice;
	}

	public String getBookTitle() {
		return this.bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPublishedDate() {
		return this.publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

}
