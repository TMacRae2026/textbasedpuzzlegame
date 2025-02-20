/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textbasedpuzzlegame.commands.impl;

import com.mycompany.textbasedpuzzlegame.TextBasedPuzzleGame;
import static com.mycompany.textbasedpuzzlegame.TextBasedPuzzleGame.commandManager;
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
        String result = "";
        for(Command c: TextBasedPuzzleGame.getInstance().commandManager.getCommands()) {
            result += c;
        }
        return result;
    }
    
}
