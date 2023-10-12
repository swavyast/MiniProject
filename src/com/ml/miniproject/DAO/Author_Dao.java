package com.ml.miniproject.DAO;

import java.util.List;

import com.ml.miniproject.pojo.Author;

public interface Author_Dao {
	public Author fetchAuthor(long aid);
	public List<Author> listAuthors(long aid);
	public void saveAuthor(Author ath);
	public void upateAuthor(Author ath);
	public void deleteAuthor(long aid);
	public void deleteAll();
}
