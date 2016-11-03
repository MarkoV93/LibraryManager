/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.model.Genre;
import java.util.List;

/**
 *
 * @author Marko
 */
public interface GenreDao {
    public boolean saveOrUpdate(Genre genre);
    public boolean delete(Genre genre);
    public Genre get(int id);
    public Genre getByName(String name);
     public List<Genre> getAll();
}
