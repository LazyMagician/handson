package com.mylibrary.manager;

import com.mylibrary.entities.Book;
import com.mylibrary.entities.Librarian;
import com.mylibrary.entities.Library;
import com.mylibrary.entities.SimpleUser;
import com.mylibrary.interfaces.User;

public class LibraryManagementMain {

	public static void main( String args[] ) {

		//		Creating sample dummy data for library books
		Library library = new Library();
		library.addNewBook( createNewBook( "48 Laws of Power", "Robert Greene" ) );
		library.addNewBook( createNewBook( "Atomic Habits", "James Clear" ) );
		library.addNewBook( createNewBook( "The Alchemist", "Paulo Coelho" ) );
		library.addNewBook( createNewBook( "Deep Work", "Cal Newport" ) );
		library.addNewBook( createNewBook( "Sapiens", "Yuval Noah Harari" ) );
		library.addNewBook( createNewBook( "Can't Hurt Me", "David Goggins" ) );
		library.addNewBook( createNewBook( "The Subtle Art of Not Giving a F*ck", "Mark Manson" ) );
		library.addNewBook( createNewBook( "Thinking, Fast and Slow", "Daniel Kahneman" ) );
		library.addNewBook( createNewBook( "Rich Dad Poor Dad", "Robert T. Kiyosaki" ) );
		library.addNewBook( createNewBook( "Start With Why", "Simon Sinek" ) );
		System.out.println( "**** Added " + library.getNoOfBooks() + " books ****" );
		System.out.println( "** BOOK INFO **\n" + library );

		SimpleUser student1 = new SimpleUser();
		SimpleUser student2 = new SimpleUser();
		SimpleUser student3 = new SimpleUser();
		SimpleUser student4 = new SimpleUser();

		Librarian librarian = new Librarian( library );
		//		get a book from library
		student1.requestBooks( librarian, new String[] { "48 Laws of Power", "The Alchemist" } );

	}

	private static Book createNewBook( String name, String author ) {
		return new Book( name, author );

	}

}
