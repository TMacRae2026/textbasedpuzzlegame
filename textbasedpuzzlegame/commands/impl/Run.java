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
public class Run extends Command{
    
    public Run() {
        super("Run", "Run <no arguments>; run away from danger (Requires 2 energy)");
    }
    
    
    @Override
    public String runCommand(String[] args) {
        if(args.length > 0) {
            return "The 'run' command does not take any arguments.";
        }
        if(!TextBasedPuzzleGame.rooms.get(TextBasedPuzzleGame.roomIdx).isHasMonster()) {
            if(TextBasedPuzzleGame.energy < 2){
                return "You don't have the energy to run.";
            }
            
            TextBasedPuzzleGame.energy = 0;
            return "Lost in the madness of the maze, you run until you find the next room. You lost all of your energy";
        }
        switch (TextBasedPuzzleGame.energy) {
            case 2:
                TextBasedPuzzleGame.roomIdx++;
                TextBasedPuzzleGame.hp -= 1;
                TextBasedPuzzleGame.energy -= 2;
                return "You try to run away but the monster easily catches up. You're knocked to the floor and take 1 health point of damage.\n" +
                       "You manage to escape by ducking into a dark corridor and letting the monster run past.";

            case 1:
                TextBasedPuzzleGame.roomIdx++;
                TextBasedPuzzleGame.energy -= 1;
                TextBasedPuzzleGame.hp -= 2;
                return "You try to run away but the monster easily catches up. You're knocked to the floor and take 2 health points of damage.\n" +
                       "You manage to escape by ducking into a dark corridor and letting the monster run past.";

            case 0:
                TextBasedPuzzleGame.hp = 0;
                return "You try to run away but you're too tired. Your feet feel heavy. The last thing you see is the monster sprinting at you getting" +
                       "\ncloser and closer every second.";

            default:
                TextBasedPuzzleGame.roomIdx++;
                return "Your energy is above 2, so you successfully escape from the monster without taking any damage.";
        }
    }
    
    
}
