/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.textbasedpuzzlegame;

import com.mycompany.textbasedpuzzlegame.commands.Command;
import com.mycompany.textbasedpuzzlegame.commands.CommandManager;
import com.mycompany.textbasedpuzzlegame.items.Item;
import com.mycompany.textbasedpuzzlegame.items.impl.Compass;
import com.mycompany.textbasedpuzzlegame.items.impl.Sword;
import com.mycompany.textbasedpuzzlegame.rooms.Room;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author TMacRae2026
 */
public class TextBasedPuzzleGame {
    
    public static CommandManager commandManager;
    public static ArrayList<Room> rooms;
    public static int roomIdx = -1;
    public static Scanner scan;
    public static int energy;
    
    //setup method initalizes all static objects
    public static void setup() {
        Random rand = new Random();
        energy = rand.nextInt(2, 5);
        rooms = new ArrayList<Room>();
        commandManager = new CommandManager();
        scan = new Scanner(System.in);
    }
    
    static void initRooms() {
        //have a random object that will determine which room goes where
        Random rand = new Random();
        //have a random number of random rooms
        int numbOfRooms = rand.nextInt(2, 3);
        //make a list of random rooms
        ArrayList<Room> randRoomList = new ArrayList<Room>();
        
        ArrayList<Item> compassRoomItems = new ArrayList<Item>();
        compassRoomItems.add(new Compass());
        
        ArrayList<Item> badRoomItems = new ArrayList<Item>();
        badRoomItems.add(new Compass());
        badRoomItems.add(new Sword("Old Wooden"));
        
        randRoomList.add(new Room("The room is small and sparsely furnished, with a low wooden table at the center. On the table lies an old, brass compass. " +
                "\nThe compass needle spins wildly for a moment before it suddenly points unwaveringly to the north. " +
                "\nThe walls are adorned with faint markings, possibly a map, but it's hard to decipher in the dim light. The air feels still, as if time itself is uncertain here."
                ,compassRoomItems
                ,false));
        
        randRoomList.add(new Room("The room is cloaked in shadows, with the only light coming from a flickering torch on the wall. The air feels heavy, as if something is wrong. " +
                "\nSuddenly, you catch movement out of the corner of your eye. A tall, dark figure looms in the far corner of the room. It barely resembles a humanoid creature, its limbs too long and its shape too unnatural.\n Before you can react, the creature lets out an inhuman hiss and starts running directly toward you, its movements impossibly fast and jerky.",
        true));
        
        randRoomList.add(new Room("The room is the same as the rest of the dirty yellow maze, with the air thick with dust. Against the wall leans an old wooden sword, its blade chipped and weathered from years of neglect. " +
                "\nThe sword's hilt is wrapped in frayed leather, a sign of countless battles fought long ago. The room is otherwise empty, save for the scattered remnants of a broken crate in the corner."
                ,badRoomItems
                ,false));
        
        //make the first 3 rooms always safe but have no items
        rooms.add(new Room("The room has the same yellow walls and dirty carpet as the rest of the maze. However something is different about this room." +
                "\nThere is an picture carved into the wall. It's a picture of a thumbs up.",
        false));
        rooms.add(new Room("This room is circular and made of tile. In the center of the room is a pool. The pool seems to be infinitely deep. " +
                "\n\nYou decide that it would be better to not swim in the pool.",
        false));
        rooms.add(new Room("The room has dim lighting and the walls are lined with cracked mirrors. A faint, eerie hum echoes through the space. " +
                "\nIn the corner, a small table holds a single, unlit candle."+
                "\nYou try to pickup the candle to examine it but you find that the candle is superglued to the table.",
        false));
        
        while(numbOfRooms != 0){
            numbOfRooms--;
            int randRoomIdx = rand.nextInt(0, randRoomList.size());
            rooms.add(randRoomList.get(randRoomIdx));
            randRoomList.remove(randRoomIdx);
            
        }
        
    }
    
    public static void main(String[] args) {
        setup();
        initRooms();
        //Introduce the player to the backrooms
        System.out.println("You wake up lying face down. You open your eyes and find yourself in what seems to be an endless maze of yellow walls and wet carpet."+
                "\n\n\"Hello?\" You call out into the maze."+
                "\n\nno one answers."+
                "\n\n\n\t\t(Type 'help' to view what commands you have access to)");
        
        //game loop
        while(true) {
            printEnergy(energy);
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
                System.out.println(command.runCommand(arguments));
            } else{
                System.out.println("Command: '" + scommand + "' does not exist.\nPlease type 'help' to view all commands.");
                continue;
            }
            
            
        }
        
    }
    
    public static void printEnergy(int energy) {
        // Start with a base string of "Energy ["
        StringBuilder energyString = new StringBuilder("Energy [");

        // Add '+' for the number of positive energy levels
        for (int i = 0; i < energy; i++) {
            energyString.append("+");
        }

        // Add '-' for the remaining energy levels (out of 5, for example)
        for (int i = 0; i < (5 - energy); i++) {
            energyString.append("-");
        }

        // Close the string with "]"
        energyString.append("]");

        // Print the resulting energy string
        System.out.println(energyString.toString());
    }
    
    
}

