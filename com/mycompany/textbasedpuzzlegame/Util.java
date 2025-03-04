/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textbasedpuzzlegame;

import com.mycompany.textbasedpuzzlegame.items.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TMacRae2026
 */
public class Util {
    
    public static String formatList(ArrayList<Item> items) {
        if (items == null || items.isEmpty()) {
            return "";
        }

        // Create a list to hold non-null item names
        List<String> nonNullItems = new ArrayList<>();
        
        // Add only non-null item names to the list
        for (Item item : items) {
            if (item != null && item.getName() != null) {
                nonNullItems.add(item.getName());
            }
        }

        // If there are no valid items after filtering, return an empty string
        if (nonNullItems.isEmpty()) {
            return "";
        }

        // If there is only one item, return it as is
        if (nonNullItems.size() == 1) {
            return nonNullItems.get(0);
        }

        // If there are two items, return them with 'and' between them
        if (nonNullItems.size() == 2) {
            return nonNullItems.get(0) + " and " + nonNullItems.get(1);
        }

        // For more than two items, join them with commas and 'and' before the last item with Oxford comma
        StringBuilder listBuilder = new StringBuilder();
        for (int i = 0; i < nonNullItems.size() - 1; i++) {
            listBuilder.append(nonNullItems.get(i));
            if (i < nonNullItems.size() - 2) {  // Add comma if it's not the last item before 'and'
                listBuilder.append(", ");
            }
        }
        listBuilder.append(", and ").append(nonNullItems.get(nonNullItems.size() - 1));

        return listBuilder.toString();
    }

    
}