/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.textbasedpuzzlegame;

import com.mycompany.textbasedpuzzlegame.commands.Command;
import com.mycompany.textbasedpuzzlegame.commands.CommandManager;
import com.mycompany.textbasedpuzzlegame.rooms.Room;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author TMacRae2026
 */
public class TextBasedPuzzleGame {
    
    public static CommandManager commandManager;
    public static ArrayList<Room> rooms;
    public static int roomIdx = 0;
    public static Scanner scan;
    
    public static TextBasedPuzzleGame getInstance() {
        return this;
    }
    
    //setup method initalizes all static objects
    public static void setup() {
       
        scan = new Scanner(System.in);
    }
    
    public static void main(String[] args) {
        setup();
        CommandManager commandManager = new CommandManager();
        //Introduce the player to the backrooms
        System.out.println("You wake up lying face down. You open your eyes and find yourself in what seems to be an endless maze of yellow walls."+
                "\n\n \"Hello?\" You call out into the maze."+
                "\n\nno one answers."+
                "\n\n\n\t\t(Type 'help' to view what commands you have access to)");
        
        //game loop
        while(true) {
            // Taking user input
            String userInput = scan.nextLine();

            // Splitting the input into words
            String[] inputParts = userInput.split(" ");

            // Assigning the first word as the command
            String scommand = inputParts[0];

            // Creating an array for the rest of the words
            String[] arguments = new String[inputParts.length - 1];
            System.arraycopy(inputParts, 1, arguments, 0, inputParts.length - 1);

            
            Command command = commandManager.getCommand(scommand);
            if(command != null) {
                command.runCommand(arguments);
            } else{
                System.out.println("Command: '" + scommand + "' does not exist.\nPlease type 'help' to view all commands.");
                continue;
            }
            
            
        }
        
    }
    
    
    
    
}

