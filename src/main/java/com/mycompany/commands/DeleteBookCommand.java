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
import com.mycompany.model.Book;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Marko
 method for deleting book from DB
 */
public class DeleteBookCommand extends Command{
      public void execute() {
        System.out.println("write book title");
        Scanner in = new Scanner(System.in);
        String title = in.nextLine();//reading title of book
        if (title.equals("cencel")) {//if user write 'cencel' return to the main menu
            return;
        }
        List<Book> books = bookDao.getBooksByTitle(title);
        if (books.size() == 0) {//if there in no one book bith this title
            System.out.println("there is not book with this title");
        } else if (books.size() == 1) {//if there is one book in DB
            bookDao.delete(books.get(0));//delete book
            genreDao.delete(books.get(0).getGenre());//delete genre of book.If in DB is Books with this genre , genre doesn't delete
            authorDao.delete(books.get(0).getAuthor());//delete author of book.If in DB is Books with this author , author doesn't delete
            System.out.println("book deleted");
        } else {//if there is few books in DB with this title
            Boolean flag = false;
            while (!flag) {
                for (int i = 0; i < books.size(); i++) {//writing all books with nuber
                    System.out.println("Number of book: " + i);
                    System.out.println(books.get(i));
                }
                System.out.println("there are few books woth the same title.Please chouse id of book");

                String bookNumber = in.nextLine();//reading number of book
                if (bookNumber.equals("cencel")) {//if user write 'cencel' return to the main menu
                    return;
                }
                try {
                    flag = bookDao.delete(books.get(Integer.parseInt(bookNumber)));//if number is currect delete book
                    genreDao.delete(books.get(Integer.parseInt(bookNumber)).getGenre());//delete genre of book.If in DB is Books with this genre , genre doesn't delete
                    authorDao.delete(books.get(Integer.parseInt(bookNumber)).getAuthor());//delete author of book.If in DB is Books with this author , author doesn't delete
                } catch (Exception e) {
                    System.out.println("write current value or censel");//asking user number of book while he doesn't write correct or 'cancel'
                }
            }
        }
    }
}
