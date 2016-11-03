/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.AuthorDao;
import com.mycompany.dao.BookDao;
import com.mycompany.dao.GenreDao;

/**
 *
 * @author Marko
 */
public class DaoFactory {
    private static DaoFactory instance=new DaoFactory();
private GenreDao genreDao;
private BookDao bookDao;
private AuthorDao authorDao;
   
    private DaoFactory(){}
    public static DaoFactory getInstance(){
        return DaoFactory.instance;
    }  
 
   

    public GenreDao getGenreDao(){
       if (genreDao==null) genreDao=new GenreDaoImpl();
        return genreDao;
    }
     public BookDao getBookDao(){
        if (bookDao==null) bookDao=new BookDaoImpl();
        return bookDao;
    }
      public AuthorDao getAuthorDao(){
        if (authorDao==null) authorDao=new AuthorDaoImpl();
        return authorDao;
    }
}
