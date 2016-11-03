/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.GenreDao;
import com.mycompany.model.Genre;
import java.util.List;

/**
 *
 * @author Marko
 */
public class GenreDaoImpl extends AbstractDao implements GenreDao{

    @Override
    public boolean saveOrUpdate(Genre genre) {
     return  super.saveOrUpdate(genre);
    }

    @Override
    public boolean delete(Genre genre) {
       return  super.delete(genre);
    }

    @Override
    public Genre get(int id) {
        return  (Genre)super.get(Genre.class,id);
    }

    @Override
    public List<Genre> getAll() {
        return super.getAll(Genre.class);
    }

    @Override
    public Genre getByName(String name) {
       return (Genre)super.getByCriteria(Genre.class, "name", name);
    }
    
}
