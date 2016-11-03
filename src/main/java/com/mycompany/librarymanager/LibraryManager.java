/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanager;

import com.mycompany.commands.Command;
import com.mycompany.commands.CommandFactory;
import com.mycompany.dao.BookDao;
import com.mycompany.dao.GenreDao;
import com.mycompany.dao.impl.DaoFactory;
import com.mycompany.model.Author;
import com.mycompany.model.Book;
import com.mycompany.model.Genre;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Marko
 */
public class LibraryManager {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);    
        CommandFactory commandFactory=CommandFactory.getInstance();
        Command command;
        while (true) {
            System.out.println("MAIN MENU     press action or press halp for descrioption");
            String action = in.nextLine();
            command=commandFactory.getCommand(action);
            if(command !=null){
             command.execute();
            } 
        }
    }
}
