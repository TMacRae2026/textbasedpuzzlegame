/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textbasedpuzzlegame.commands.impl;

import com.mycompany.textbasedpuzzlegame.TextBasedPuzzleGame;
import com.mycompany.textbasedpuzzlegame.commands.Command;
import com.mycompany.textbasedpuzzlegame.items.Item;

/**
 *
 * @author tyler
 */
public class Use extends Command {
    
    public Use() {
        super("Use", "Use <Item>; Use an item like a compass to navigate the maze");
    }
    
    @Override
    public String runCommand(String[] args) {
        if(args.length != 1) {
            return "The 'Use' command takes 1 argument";
        }
        
        Item item = null;
        for(Item i:TextBasedPuzzleGame.inventory) {
            if(i.getName().equalsIgnoreCase(args[0])) {
                item = i;
            }
        }
        if(item == null) {
            return "Your inventory does not contain '" + args[0] + ".'";
        }
        
        return item.useItem();
        
    }
    
    
    
}
