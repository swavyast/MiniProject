package com.ml.miniproject.DAO;

import java.util.List;

import com.ml.miniproject.pojo.Book;

public interface Book_Dao {
	public void saveBook(Book b);
	public void updateBook(Book b);
	public Book fetchBook(long bookId);
	public List<Book> fetchAll();
	public void deleteBook(long bookId);
}
