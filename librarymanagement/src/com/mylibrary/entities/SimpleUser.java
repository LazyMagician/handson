package com.mylibrary.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.mylibrary.interfaces.User;

public class SimpleUser implements User {

	private int id;

	private String name;

	private int noOfBooks;

	private static final AtomicInteger counter = new AtomicInteger( 0 );

	public SimpleUser() {
		this.id = counter.getAndIncrement();
	}

	public boolean submitNewBookToLibrary( List<Book> books ) {
		return true;
	}

	public boolean removeBooks() {
		return true;
	}

	public List<Book> requestBooks( Librarian librarian, String[] bookNames ) {
		return librarian.issueBooks( this, bookNames );
	}

	public int getId() {
		return id;
	}

	public void setId( int id ) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public int getNoOfBooks() {
		return noOfBooks;
	}

	public void setNoOfBooks( int noOfBooks ) {
		this.noOfBooks = noOfBooks;
	}

	@Override
	public List<Book> getAllBooks() {
		return new ArrayList<Book>();
	}
}
