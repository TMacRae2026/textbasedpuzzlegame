/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textbasedpuzzlegame.commands.impl;

import com.mycompany.textbasedpuzzlegame.TextBasedPuzzleGame;
import com.mycompany.textbasedpuzzlegame.commands.Command;
import java.util.Random;

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
        //make wander not work if the player has no energy
        
        if(TextBasedPuzzleGame.energy < 1) {
            Random rand = new Random();
            int hploss = rand.nextInt(0, 1);
            TextBasedPuzzleGame.hp -= hploss;
            String result = "You start to wander, but feel fatigued. You collapse in the endless maze.";
            if(hploss == 1) {
                result += "\nYou lost 1 Health Point";
            }
            
            return result;
        }
        
        //remove 1 energy and increase the room number
        TextBasedPuzzleGame.energy--;
        TextBasedPuzzleGame.roomIdx++;
        if(TextBasedPuzzleGame.roomIdx >= TextBasedPuzzleGame.rooms.size()) {
            return "";
        }
        
        //print the new room discription
        String result = "You wander through the maze and find a room.\n\n" + TextBasedPuzzleGame.rooms.get(TextBasedPuzzleGame.roomIdx);
        if(TextBasedPuzzleGame.rooms.get(TextBasedPuzzleGame.roomIdx).isHasMonster()) {
            result += "\n\nYou can runaway or try and fight the monster.";
        }
        return result;
    }
    
}