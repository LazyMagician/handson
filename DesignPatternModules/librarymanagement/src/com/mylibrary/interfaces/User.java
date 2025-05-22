package com.mylibrary.interfaces;

import java.util.List;

import com.mylibrary.entities.Book;

public interface User {

	public List<Book> getAllBooks();

	public int getNoOfBooks();

	public String getName();
}
