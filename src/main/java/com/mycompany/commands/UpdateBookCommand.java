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
 * method for updating book
 */
public class UpdateBookCommand extends Command {

    @Override
    public void execute() {
        System.out.println("write title of book or cencel");
        Scanner in = new Scanner(System.in);
        String newTitle;
        while (true) {
            String title = in.nextLine();
            if (title.equals("cencel")) {//if user write 'cencel'
                return;
            }
            List<Book> books = bookDao.getBooksByTitle(title);
            if (books.size() == 0) {//if there is no one book with tis title
                System.out.println("there is no one book with this title");
                return;
            } else if (books.size() == 1) {//if there is one book with this title
                System.out.println("write new title");
                newTitle = in.nextLine();
                if (title.equals("cencel")) {
                    return;
                }
                books.get(0).setTitle(newTitle);
                bookDao.saveOrUpdate(books.get(0));
                System.out.println("book updated");
                return;
            } else {//if there is few books with this title
                System.out.println("there is a few books with this title, please choose current: ");
                for (int i = 0; i < books.size(); i++) {
                    System.out.println(i + " " + books.get(i));
                }
                boolean flag = false;
                while (!flag) {
                    String bookNumber = in.nextLine();
                    if (bookNumber.equals("cencel")) {
                        return;
                    }
                    try {
                        Book book = books.get(Integer.parseInt(bookNumber));
                        System.out.println("write new title");
                        newTitle = in.nextLine();
                        book.setTitle(newTitle);
                        bookDao.saveOrUpdate(book);
                         System.out.println("book updated");
                return;
                    } catch (Exception e) {
                        System.out.println("write current value or censel");//asking user number of book while he doesn't write correct or 'cancel'
                    }
                }
            }
        }
    }

}
