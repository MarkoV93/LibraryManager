/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.AuthorDao;
import com.mycompany.model.Author;
import com.mycompany.model.Genre;
import java.util.List;


/**
 *
 * @author Marko
 */
public class AuthorDaoImpl extends AbstractDao implements AuthorDao{

    @Override
    public boolean saveOrUpdate(Author author) {
        return  super.saveOrUpdate(author);
    }

    @Override
    public boolean delete(Author author) {
         return  super.delete(author);
    }

    @Override
    public Author get(int id) {
         return  (Author)super.get(Author.class,id);
    }

    @Override
    public List<Author> getAll() {
        return super.getAll(Author.class);
    }

    @Override
    public Author getBySurname(String surName) {
       return (Author)super.getByCriteria(Author.class, "surName", surName);
    }

  
}
