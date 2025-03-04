/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textbasedpuzzlegame.items.impl;

import com.mycompany.textbasedpuzzlegame.TextBasedPuzzleGame;
import com.mycompany.textbasedpuzzlegame.items.Item;
import java.util.Random;

/**
 *
 * @author TMacRae2026
 */
public class Compass extends Item {
    
    //compass can only be used two times before it breaks;
    int uses = 2;
    
    public Compass() {
        super("Compass");
    }
    
    @Override
    public String useItem() {
        //Should have a random chance of working. and a random chance of making you accidently do a big circle.
        Random rand = new Random();
        uses--;
        //If the compass has been used up break the compass
        if(uses <= 0) {
            TextBasedPuzzleGame.inventory.remove(this);
            return """
                   You pull the compass from your pocket...
                   The the compasses has gone insane and is spinning in all directions rapidly.
                   
                   You discard the compass as it nolonger works.""";
        }
        int success = rand.nextInt(0, 3);
        if(success == 3) {
            TextBasedPuzzleGame.roomIdx += 2;
            return "You pull the compass from your pocket..." + 
                   
                   "\nYou decide to head west and follow the compass." +
                   "\nyou are brought to a room. An invisible force takes the compass from you and the compass" +
                   "\nfloats away.\n\n" + 
                    TextBasedPuzzleGame.rooms.get(TextBasedPuzzleGame.roomIdx);
        } else {
            return """
                   You pull the compass from your pocket...
                   
                       You decide to head north and follow the compass.
                       somehow you end up in the same room as before.
                       You put the compass back in your pocket.""";
        }
        
    }
    
}