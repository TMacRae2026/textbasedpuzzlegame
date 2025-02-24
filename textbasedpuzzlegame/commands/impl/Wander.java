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
public class Wander extends Command{
    
    public Wander() {
        super("Wander", "Wander <no arguments>; randomly wanter the maze (takes 1 energy)");
    }
    
    @Override
    public String runCommand(String[] args) {
        if(args.length > 0) {
            return "The wander command does not take any arguments.";
        }
        if(TextBasedPuzzleGame.energy < 1) {
            return "You don't have the energy to wander.";
        }
        TextBasedPuzzleGame.energy--;
        TextBasedPuzzleGame.roomIdx++;
        return "You wander through the maze and find a room.\n\n" + TextBasedPuzzleGame.rooms.get(TextBasedPuzzleGame.roomIdx);
    }
    
}
