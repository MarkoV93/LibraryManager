/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.model.Author;
import com.mycompany.model.Book;
import com.mycompany.model.Genre;
import java.util.List;

/**
 *
 * @author Marko
 */
public interface  BookDao {
     public boolean saveOrUpdate(Book book);
    public boolean delete(Book book);
    public Book get(int id);
     public List<Book> getAll();
     public List<Book> getBooksByTitle(String title);
      public List<Book> getBooksByCriterias(String title,Genre genre);
     
}
