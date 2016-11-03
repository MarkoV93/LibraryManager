/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.commands;

import com.mycompany.dao.AuthorDao;
import com.mycompany.dao.BookDao;
import com.mycompany.dao.GenreDao;
import com.mycompany.dao.impl.DaoFactory;

/**
 *
 * @author Marko
 */
public abstract class Command {
    
     DaoFactory daoFactory;
    GenreDao genreDao;
    BookDao bookDao;
    AuthorDao authorDao;
    
    public Command(){
         daoFactory = DaoFactory.getInstance();
        genreDao = daoFactory.getGenreDao();
        bookDao = daoFactory.getBookDao();
        authorDao = daoFactory.getAuthorDao(); 
    }
    public abstract void execute();
}
