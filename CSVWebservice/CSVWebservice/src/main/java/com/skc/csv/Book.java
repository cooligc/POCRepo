package com.skc.csv;

import java.util.Map;

public class Book{
	private Long id;
	private String bookName;
	private String authorName;
	private String isbn;
	private Map<String, String> content;
	
	public Book(Long id, String bookName, String authorName, String isbn, Map<String, String> content) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.authorName = authorName;
		this.isbn = isbn;
		this.content = content;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}
	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}
	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
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
	 * @return the content
	 */
	public Map<String, String> getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(Map<String, String> content) {
		this.content = content;
	}
	
	
}
