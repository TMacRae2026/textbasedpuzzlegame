/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textbasedpuzzlegame.commands.impl;

import com.mycompany.textbasedpuzzlegame.TextBasedPuzzleGame;
import com.mycompany.textbasedpuzzlegame.commands.Command;

/**
 *
 * @author TMacRae2026
 */
public class Help extends Command {
    
    public Help(){
        super("Help", "Help <no arguments>; Shows this list");
    }
    
    @Override
    public String runCommand(String[] args) {
        if(args.length > 0) {
            return "The 'help' command does not take any arguments.";
        }
        //print all of the commands
        String result = "";
        for(Command c: TextBasedPuzzleGame.commandManager.getCommands()) {
            result += c + "\n";
        }
        return result;
    }
    
}