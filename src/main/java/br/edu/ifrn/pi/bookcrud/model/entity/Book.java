package br.edu.ifrn.pi.bookcrud.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Book implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	private String company;
	
	@Temporal(TemporalType.DATE)
	private Date releaseYear;
	
	private int numberOfPages;
	
	@ManyToOne
	private Author author;
	
	public Book() {
		super();
	}
	
	public Book(String title, String company, Date releaseYear, int numberOfPages, Author author) {
		super();
		this.title = title;
		this.company = company;
		this.releaseYear = releaseYear;
		this.numberOfPages = numberOfPages;
		this.author = author;
	}

	public Book(Long id, String title, String company, Date releaseYear, int numberOfPages, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.company = company;
		this.releaseYear = releaseYear;
		this.numberOfPages = numberOfPages;
		this.author = author;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Date getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
}
