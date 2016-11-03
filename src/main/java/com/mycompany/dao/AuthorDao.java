/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.model.Author;
import com.mycompany.model.Genre;
import java.util.List;

/**
 *
 * @author Marko
 */
public interface AuthorDao {
      public boolean saveOrUpdate(Author author);
    public boolean delete(Author author);
    public Author get(int id);
     public List<Author> getAll();
     public Author getBySurname(String surName);
}
