/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textbasedpuzzlegame.rooms;

import com.mycompany.textbasedpuzzlegame.Util;
import com.mycompany.textbasedpuzzlegame.items.Item;
import java.util.ArrayList;

/**
 *
 * @author TMacRae2026
 */
public class Room {
    
    String disc;
    ArrayList<Item> items;
    boolean hasMonster;
    public Room(String disc, ArrayList<Item> items, boolean hasMonster) {
        this.disc = disc;
        this.items = items;
        this.hasMonster = hasMonster;
    }
    
    public Room(String disc, boolean hasMonster) {
        this.disc = disc;
        this.items = new ArrayList<Item>();
        this.hasMonster = hasMonster;
    }
    
    public String toString(){
        String[] temp = new String[5];
        int count = 0;
        for(Item i: items) {
            temp[count] = i.getName();
            count++;
        }
        
        return disc;
    }
}
