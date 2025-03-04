/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textbasedpuzzlegame.items.impl;

import com.mycompany.textbasedpuzzlegame.items.Item;

/**
 *
 * @author TMacRae2026
 */
public class Sword extends Item {
    
    String condition;
    
    
    public Sword(String condition) {
        super(condition + "_Sword");
        this.condition = condition;
    }
    
    //Sword does not need to override the use method as it will be used from the fight command
    
}