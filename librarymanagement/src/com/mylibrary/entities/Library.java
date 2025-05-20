package com.mylibrary.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

	private int noOfBooks;

	private List<Book> books = new ArrayList<Book>();

	public int getNoOfBooks() {
		return noOfBooks;
	}

	public void setNoOfBooks( int noOfBooks ) {
		this.noOfBooks = noOfBooks;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks( List<Book> books ) {
		this.books = books;
	}

	public void addNewBook( Book book ) {
		books.add( book );
		noOfBooks++;
	}

	public List<Book> getSpecificBookDetails( String[] names ) {
		List<Book> requiredBooks = new ArrayList<Book>();
		for ( Book book : books ) {
			if ( Arrays.asList( names ).contains( book ) && book.getIssuedTo().equals( "-" ) ) {
				requiredBooks.add( book );
			}
			else {
				System.out.println( "Book " + book.getName() + " is currently issued to :" + book.getIssuedTo() );
			}
		}
		return requiredBooks;
	}

	@Override
	public String toString() {
		String bookInfo = "**********************";
		for ( Book book : books ) {
			bookInfo += "\n Book Name : " + book.getName() + " \n Author Name :" + book.getAuthor() + " \n Book Id :" + book.getUid();
		}
		bookInfo += "\n **********************";
		return bookInfo;
	}

}
