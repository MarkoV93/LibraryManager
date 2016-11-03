/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.commands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Marko
 * method for returning name of actions
 */
public class HelpCommand extends Command{

    @Override
    public void execute() {
        try {
            FileReader fileReader = new FileReader("help.txt");
            String line = null;          
            BufferedReader reader = new BufferedReader(fileReader);
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }
    
}
