/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textbasedpuzzlegame.commands.impl;

import com.mycompany.textbasedpuzzlegame.TextBasedPuzzleGame;
import com.mycompany.textbasedpuzzlegame.Util;
import com.mycompany.textbasedpuzzlegame.commands.Command;
import com.mycompany.textbasedpuzzlegame.items.Item;

/**
 *
 * @author TMacRae2026
 */
public class Inventory extends Command {
    
    public Inventory() {
        super("Inventory", "Inventory <No arguments>; prints your inventory");
    }
    
    @Override
    public String runCommand(String[] args) {
        if(args.length > 0) {
            return "The 'inventory' command does not take any arguments.";
        }
        
        if(TextBasedPuzzleGame.inventory.size() == 0) {
            return "Your inventory is empty";
        }
        
        return Util.formatList(TextBasedPuzzleGame.inventory);
    }
    
}
