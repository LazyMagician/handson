package com.mylibrary.entities;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Book {

	private String name;

	private String author;

	private String issuedTo = "-";

	private Date issuedOn;

	private static final AtomicInteger counter = new AtomicInteger( 0 );

	private int uid;

	public Book( String name, String author, String issuedTo, Date issuedOn ) {
		this( name, author );
		this.issuedTo = issuedTo;
		this.issuedOn = issuedOn;
	}

	public Book( String name, String author ) {
		this();
		this.name = name;
		this.author = author;
	}

	public Book() {
		this.uid = counter.incrementAndGet();
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor( String author ) {
		this.author = author;
	}

	public String getIssuedTo() {
		return issuedTo;
	}

	public void setIssuedTo( String issuedTo ) {
		this.issuedTo = issuedTo;
	}

	public int getUid() {
		return uid;
	}

	public void setUid( int uid ) {
		this.uid = uid;
	}

	public Date getIssuedOn() {
		return issuedOn;
	}

	public void setIssuedOn( Date issuedOn ) {
		this.issuedOn = issuedOn;
	}

}
