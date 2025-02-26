/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textbasedpuzzlegame.commands;

/**
 *
 * @author TMacRae2026
 */
public class Command {
    //Have a command with a name and an array of arguments
    String name;
    String helpMessage;
    public Command(String name, String helpMessage) {
        this.name = name;
        this.helpMessage = helpMessage;
    }
    
    //Make a run command that will be overriden by child classes
    public String runCommand(String[] args){
        return "Error, child command (" + name + ") does not override the runCommand method";
    }
    
    
    
    public String toString() {
        return this.name + ": " + helpMessage;
    }
    
}
