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
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author tyler
 */
public class Take extends Command {
    
    public Take() {
        super("Take", "Take <Item>; pickup an item and take it with you for your journey");
    }
    
    @Override
    public String runCommand(String[] args) {
        if (args.length != 1) {
            return "The 'take' command takes 1 argument of type <item>";
        }
        if(TextBasedPuzzleGame.roomIdx == -1) {
            return "The item, '" + args[0] + "', is not in the room.";
        }
        
        Item item = null;
        List<Item> roomItems = TextBasedPuzzleGame.rooms.get(TextBasedPuzzleGame.roomIdx).getItems();


        // Use an iterator to safely remove elements while iterating
        Iterator<Item> iterator = roomItems.iterator();
        while (iterator.hasNext()) {
            Item i = iterator.next();
            if ((args[0].equalsIgnoreCase("sword") && i instanceof Sword) ||
                (args[0].equalsIgnoreCase("compass") && i instanceof Compass)) {
                iterator.remove(); // Safe way to remove items while iterating
                item = i;
                break; // Exit the loop after finding the first matching item
            }
        }

        if (item != null) {
            TextBasedPuzzleGame.inventory.add(item);
            return "You took the '" + item.getName() + "'";
        }

        return "The item, '" + args[0] + "', is not in the room.";
    }
    
}
