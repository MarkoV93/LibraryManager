/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.commands;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import org.apache.log4j.LogManager;

/**
 *
 * @author Marko
 */
public class CommandFactory {
   
    private Map<String, Command> commandMap = null;
    private static CommandFactory instance = null;
    ResourceBundle labels;

    private CommandFactory() {
        commandMap = new HashMap<>();
    }

    //method which crate command by reflactions and put it into Map commandMap
    private Command createNewCommand(String commandName) {
        try {
            if(commandName.equals("exit")){   
            System.exit(0);
            }
            labels = ResourceBundle.getBundle("ComandsClasses", Locale.getDefault());
            Class commandClass = Class.forName(labels.getString(commandName));
            Command command = (Command) commandClass.newInstance();
            commandMap.put(commandName, command);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("write current action");
        }
        return commandMap.get(commandName);
    }

//lazy initialization for CommandFactory 
    public static synchronized CommandFactory getInstance() {
        if (instance == null) {
            instance = new CommandFactory();
        }
        return instance;
    }

//lazy initialization for Commands 
    public Command getCommand(String commandName) {
        if (commandMap.containsKey(commandName)) {
            return commandMap.get(commandName);//return the appropriate command from the map if it contains there
        } else {
            return createNewCommand(commandName);//method which crate command by reflections and put it into Map commandMap
        }

    }
}
