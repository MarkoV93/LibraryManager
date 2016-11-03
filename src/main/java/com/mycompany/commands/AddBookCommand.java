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
import com.mycompany.model.Author;
import com.mycompany.model.Book;
import com.mycompany.model.Genre;
import java.util.Scanner;

/**
 *
 * @author Marko
 */
public class AddBookCommand extends Command{

    
    //method for adding book into lobrary
    @Override
    public void execute() {
 
           Book book = new Book();
        Genre genre = new Genre();
        Author author = new Author();
        Scanner in = new Scanner(System.in);
        System.out.println("insert book title");
        String title=in.nextLine();
          if (title.equals("cencel")) { return;  }//if user write 'cencel'
        book.setTitle(title);
        System.out.println("insert genre");
         String genreName=in.nextLine();
          if (genreName.equals("cencel")) { return;  }//if user write 'cencel'
        genre.setName(genreName);
        genreDao.saveOrUpdate(genre);//creating in DB new genre.If there is in DB genre like this new genre doesn't create
        book.setGenre(genreDao.getByName(genre.getName()));
        System.out.println("insert author name"); 
        String authorName=in.nextLine();
        if (authorName.equals("cencel")) { return;  }
        author.setName(authorName);
        System.out.println("insert author surname");
        String authorSurname=in.nextLine();
        if (authorSurname.equals("cencel")) { return;  }
        author.setSurName(authorSurname);
        authorDao.saveOrUpdate(author);//creating in DB new author.If there is in DB author like this, new author doesn't create
        book.setAuthor(authorDao.getBySurname(author.getSurName()));
        bookDao.saveOrUpdate(book);//creating new book
        System.out.println("book:" + book + " added");
    }
    
}
