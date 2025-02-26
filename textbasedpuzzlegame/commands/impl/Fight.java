/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textbasedpuzzlegame.commands.impl;

import com.mycompany.textbasedpuzzlegame.TextBasedPuzzleGame;
import com.mycompany.textbasedpuzzlegame.commands.Command;
import com.mycompany.textbasedpuzzlegame.items.Item;
import com.mycompany.textbasedpuzzlegame.items.impl.Compass;
import com.mycompany.textbasedpuzzlegame.items.impl.Sword;
import java.util.Random;

/**
 *
 * @author TMacRae2026
 */
public class Fight extends Command{
    
    public Fight() {
        super("Fight", "Fight <Weapon>");
    }
    
    @Override
    public String runCommand(String[] args) {
        if(args.length != 1) {
            return "The 'fight' command takes 1 argument. (To fight using your fists write 'fight fists')";
        }
        
        
        
        if(args[0].equalsIgnoreCase("fists")) {
            if(!TextBasedPuzzleGame.rooms.get(TextBasedPuzzleGame.roomIdx).isHasMonster()) {
                TextBasedPuzzleGame.hp--;
                return "You try to throw a punch but you find that there is nothing to hit. Frustrated, you punch the wall as hard as you can." +
                        "\nYour hand stings. You took 1 point of damage.";
            }
        }
        
        Item weapon = null;
        for(Item i:TextBasedPuzzleGame.inventory) {
            if(i.getName() == args[0]) {
                weapon = i;
            }
        }
        if(weapon != null){
            Random rand = new Random();
            if(weapon instanceof Compass) {
                TextBasedPuzzleGame.inventory.remove(weapon);
                return "You throw the compass at the monster. The compass hits the monster and bounces off. \n" +
                        "\"Great... now I don't have a compass and this monster is angrier at me\" You think to yourself.";
            }
            if(weapon instanceof Sword) {
                int success = -1;
                switch(weapon.getName()) {
                    case "Old Wooden Sword":
                        success = rand.nextInt(1, 3);
                    case "Strong Steel Sword":
                        success = rand.nextInt(0, 2);
                }
                switch(success) {
                    case 0:
                        TextBasedPuzzleGame.rooms.get(TextBasedPuzzleGame.roomIdx).setHasMonster(false);
                        return "You easily kill the monster with one swipe of the sword";
                    case 1:
                        TextBasedPuzzleGame.rooms.get(TextBasedPuzzleGame.roomIdx).setHasMonster(false);
                        return "After a brutal fight with the monster you end up killing the monster, but you take 1 point of damage";
                    case 2:
                        TextBasedPuzzleGame.rooms.get(TextBasedPuzzleGame.roomIdx).setHasMonster(false);
                        return "After a brutal fight with the monster you end up killing the monster, but you take 2 points of damage";
                    case 3:
                        TextBasedPuzzleGame.hp = 0;
                        return "The old wooden sword fought it's last battle as it breaks into 3 pieces upon your first swipe upon the enemy.\n" +
                                "You are killed by the monster.";
                }
                
            }
        }
        return "Your inventory does not contain '" + args[0] + ".'";
        
    }
    
    
    
}
