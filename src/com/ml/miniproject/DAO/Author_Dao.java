package com.ml.miniproject.DAO;

import java.util.List;

import com.ml.miniproject.pojo.Author;

public interface Author_Dao {
	public Author getAuthorById(long aid);
	public List<Author> listAuthors();
	public void saveAuthor();
	public void upateAuthor();
	public void deleteAuthor();
}
