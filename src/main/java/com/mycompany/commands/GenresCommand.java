/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.commands;

import com.mycompany.model.Book;
import com.mycompany.model.Genre;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Marko
 * command for returning genres of book and then books with same genre
 */
public class GenresCommand extends Command {

    @Override
    public void execute() {
        List<Genre> genres = genreDao.getAll();
        for (int i = 0; i < genres.size(); i++) {
            System.out.println(i + "   " + genres.get(i));
        }
        System.out.println("press number of genre , if you wont to see books, or press cencel");
        boolean f = false;
        while (!f) {//asking user number of genre while he doesn't write correct or 'cancel'
            Scanner in = new Scanner(System.in);
            String genreNumber = in.nextLine();
            if (genreNumber.equals("cencel")) {
                return;
            }
            try {
                List<Book> books = bookDao.getBooksByCriterias(null, genres.get(Integer.parseInt(genreNumber)));
                for (Book b : books) {
                    System.out.println(b);
                }
                f = true;
            } catch (Exception e) {
                System.out.println("write current value or censel");
            }
        }
    }

}
