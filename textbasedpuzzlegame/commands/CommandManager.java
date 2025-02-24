/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textbasedpuzzlegame.commands;

import com.mycompany.textbasedpuzzlegame.commands.impl.*; 
import java.util.ArrayList;

/**
 *
 * @author TMacRae2026
 */
public class CommandManager {
    
    ArrayList<Command> commands = new ArrayList<Command>();
    
    public CommandManager() {
        addCommand(new Help());
        addCommand(new Wander());
        addCommand(new Rest());
    }
    
    void addCommand(Command c) {
        commands.add(c);
    }
    
    public Command getCommand(String name) {
        for(Command c: commands){
            if(c.name.equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }
    
    public ArrayList<Command> getCommands() {
        return commands;
    }
    
}
