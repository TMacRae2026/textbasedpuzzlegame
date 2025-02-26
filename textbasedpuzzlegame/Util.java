/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textbasedpuzzlegame;

/**
 *
 * @author TMacRae2026
 */
public class Util {
    
    public static String makeGoodListFromStrings(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }

        if (strings.length == 1) {
            return strings[0];
        }

        // Create a StringBuilder to build the output
        StringBuilder sb = new StringBuilder();

        // Loop through all but the last item
        for (int i = 0; i < strings.length - 1; i++) {
            sb.append(strings[i]).append(", ");
        }

        // Append the last item with "and"
        sb.append("and ").append(strings[strings.length - 1]);

        return sb.toString();
    }

    
}
