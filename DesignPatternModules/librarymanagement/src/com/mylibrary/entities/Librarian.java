package com.mylibrary.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.mylibrary.interfaces.User;

public class Librarian implements User {

	private static final int maxBookLimitPerUser = 5;

	private String name;

	private int id;

	private int noOfBooks;

	private static AtomicInteger counter = new AtomicInteger( 0 );

	public Library library;

	public Librarian( Library library ) {
		this.id = counter.getAndIncrement();
		this.library = library;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId( int id ) {
		this.id = id;
	}

	public boolean addNewBookToLibrary() {
		return true;
	}

	public boolean releaseIssuedBook( List<Book> books ) {
		return true;
	}

	public List<Book> issueBooks( User user, String[] bookName ) {
		List<Book> books = new ArrayList<Book>();
		if ( checkIfBookCanBeIssued( user, bookName ) ) {
			books = library.getSpecificBookDetails( bookName );
			Date issuedDate = new Date();
			books.stream().forEach( book -> {
				book.setIssuedTo( user.getName() );
				book.setIssuedOn( issuedDate );
			} );

		}
		return books;
	}

	private boolean checkIfBookCanBeIssued( User user, String[] bookName ) {
		if ( user.getNoOfBooks() < maxBookLimitPerUser ) {
			return true;
		}
		System.out.println( "User " + user.getName() + " has already reached the max limit, please release books to library to try for another book" );
		return false;
	}

	@Override
	public List<Book> getAllBooks() {
		return null;
	}

	@Override
	public int getNoOfBooks() {
		return noOfBooks;
	}

	public void setNoOfBooks( int noOfBooks ) {
		this.noOfBooks = noOfBooks;
	}

}
