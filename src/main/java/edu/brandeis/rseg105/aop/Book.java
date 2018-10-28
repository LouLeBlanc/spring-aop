/**
 * Written by Louis LeBlanc
 * For Homework Assignment 1
 * Expert Software Development in Java
 * Brandeis University
 * Instructed by Vitaly Yurik
 */

package edu.brandeis.rseg105.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Louis LeBlanc
 *
 */
@Component
public class Book {
	private static Logger	logger	= LoggerFactory.getLogger(Book.class);
	private long			id;
	private String			isbn;
	private String			title;
	private float			price;

	/**
	 * Default Book
	 */
	public Book() {
		this.id = (long) 0;
		this.isbn = "";
		this.title = "";
		this.price = (float) 0.00;
	}

	/**
	 * @param id
	 * @param isbn
	 * @param title
	 * @param price
	 */
	public Book(long id, String isbn, String title, float price) {
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.price = price;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * Read a book
	 */
	public void reading() {
		logger.info("(Reading " + this.title + " book)");
	}

	/**
	 * Throw an exception
	 */
	public void throwException() {
		throw new RuntimeException("Book Bean Exception");
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book - Id: " + this.id + ", ISBN: " + this.isbn + ", Title: " + this.title + ", Price: " + this.price;
	}

}
