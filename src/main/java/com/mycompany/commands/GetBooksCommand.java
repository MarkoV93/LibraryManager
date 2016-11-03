/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.commands;

import com.mycompany.model.Book;
import java.util.List;

/**
 *
 * @author Marko
method for returning  list of books
 */
public class GetBooksCommand extends Command{

    @Override
    public void execute() {
        List<Book> books=bookDao.getAll();
        for(Book b:books){
            System.out.println(b);
        }
    }
    
}
