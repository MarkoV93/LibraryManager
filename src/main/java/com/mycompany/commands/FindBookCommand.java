/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.commands;

import com.mycompany.model.Book;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Marko
 */
//command for finding book by title
public class FindBookCommand extends Command{
     @Override
    public void execute() {
          System.out.println("write purt of book's title");
        Scanner in = new Scanner(System.in);
        String title = in.nextLine();
        if (title.equals("cencel")) {
            return;
        }
        List<Book> books=bookDao.getBooksByCriterias(title, null);
        for(Book b:books){
            System.out.println(b);
        }
    }
    
}