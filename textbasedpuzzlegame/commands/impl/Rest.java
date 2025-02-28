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
public class Rest extends Command{
    
    public Rest() {
        super("Rest", "Rest <No arguments>; Sit and rest for a few minutes. (Regains 3 energy)");
    }
    
    public String runCommand(String[] args) {
        if(args.length > 0) {
            return "The 'rest' command does not take any arguments.";
        }
        if(TextBasedPuzzleGame.energy == 5) {
            return "You are not tired.";
        }
        //prevent a runtime error
        if(TextBasedPuzzleGame.roomIdx != -1) {
            if(TextBasedPuzzleGame.rooms.get(TextBasedPuzzleGame.roomIdx).isHasMonster()){
            return "You get a funny feeling that now wouldn't be a good time.";
            }
        }
        
        TextBasedPuzzleGame.energy+=3;
        if(TextBasedPuzzleGame.energy > 5){
            TextBasedPuzzleGame.energy = 5;
        }
        return "You rest for a few minutes and feel energized!";
    }
    
}