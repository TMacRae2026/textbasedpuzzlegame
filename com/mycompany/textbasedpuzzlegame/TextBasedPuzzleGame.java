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
    public static ArrayList<Item> inventory;
    public static int roomIdx = -1;
    public static Scanner scan;
    public static int energy;
    public static int hp;
    public static boolean alive = true;
    
    //setup method initalizes all static objects
    public static void setup() {
        hp = 3;
        Random rand = new Random();
        energy = rand.nextInt(2, 5);
        rooms = new ArrayList<Room>();
        commandManager = new CommandManager();
        scan = new Scanner(System.in);
        inventory = new ArrayList<>();
    }
    
    static void initRooms() {
        //have a random object that will determine which room goes where
        Random rand = new Random();
        //have a random number of random rooms
        //int numbOfRooms = rand.nextInt(2, 3);
        int numbOfRooms = 4;
        //make a list of random rooms
        ArrayList<Room> randRoomList = new ArrayList<>();
        
        ArrayList<Item> compassRoomItems = new ArrayList<>();
        compassRoomItems.add(new Compass());
        
        ArrayList<Item> badRoomItems = new ArrayList<>();
        badRoomItems.add(new Sword("Old_Wooden"));
        
        randRoomList.add(new Room("""
                                  The room is small and sparsely furnished, with a low wooden table at the center. On the table lies an old, brass compass. 
                                  The compass needle spins wildly for a moment before it suddenly points unwaveringly to the north. 
                                  The walls are adorned with faint markings, possibly a map, but it's hard to decipher in the dim light. The air feels still, as if time itself is uncertain here.""",compassRoomItems
                ,false));
        
        randRoomList.add(new Room("""
                                  The room is cloaked in shadows, with the only light coming from a flickering torch on the wall. The air feels heavy, as if something is wrong. 
                                  Suddenly, you catch movement out of the corner of your eye. A tall, dark figure looms in the far corner of the room. It barely resembles a humanoid creature,
                                  its limbs too long and its shape too unnatural.
                                  
                                  Before you can react, the creature lets out an inhuman hiss and starts running directly toward you, its movements impossibly fast and jerky.""",
        true));
        
        randRoomList.add(new Room("""
                                  The room is the same as the rest of the dirty yellow maze, with the air thick with dust. Against the wall leans an old wooden sword, its blade chipped and weathered from years of neglect. 
                                  The sword's hilt is wrapped in frayed leather, a sign of countless battles fought long ago. The room is otherwise empty, save for the scattered remnants of a broken crate in the corner.""",badRoomItems
                ,false));
        
        randRoomList.add(new Room("""
                                  The air in this room feels unnaturally cold, and the walls are covered with strange, shifting shadows.
                                  A tall, wooden bookshelf stands in the center, filled with old, dusty books that appear to be unreadable.
                                  In the corner, a large, ornate mirror reflects your image\u2014but something seems off. It feels as though the reflection is moving independently, as if it has a life of its own.
                                  You try to step closer, but a sudden chill stops you in your tracks, and the mirror seems to grow darker as you approach.""",
        false));
        
        //make the first 3 rooms always safe but have no items
        rooms.add(new Room("""
                           The room has the same yellow walls and dirty carpet as the rest of the maze. However something is different about this room.
                           There is an picture carved into the wall. It's a picture of a thumbs up.""",
        false));
        rooms.add(new Room("""
                           This room is circular and made of tile. In the center of the room is a pool. The pool seems to be infinitely deep. 
                           
                           You decide that it would be better to not swim in the pool.""",
        false));
        rooms.add(new Room("""
                           The room has dim lighting and the walls are lined with cracked mirrors. A faint, eerie hum echoes through the space. 
                           In the corner, a small table holds a single, unlit candle.
                           You try to pickup the candle to examine it but you find that the candle is superglued to the table.""",
        false));
        //TEST TEST TEST TEST TEST TEST TEST TEST TEST TSET
        rooms.add(new Room("""
                                  The room is small and sparsely furnished, with a low wooden table at the center. On the table lies an old, brass compass. 
                                  The compass needle spins wildly for a moment before it suddenly points unwaveringly to the north. 
                                  The walls are adorned with faint markings, possibly a map, but it's hard to decipher in the dim light. The air feels still, as if time itself is uncertain here.""",compassRoomItems
                ,false));

        
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
        System.out.println("""
                           You wake up lying face down. You open your eyes and find yourself in what seems to be an endless maze of yellow walls and wet carpet.
                           
                           "Hello?" You call out into the maze.
                           
                           no one answers.
                           
                           
                           \t\t(Type 'help' to view what commands you have access to)""");
        
        //game loop
        while(true) {
            //kill the player if they are dead
            if(hp < 1) {
                die();
                break;
            }
            
            if(roomIdx>=rooms.size()) {
                System.out.println("""
                                   You find a door and open it. You are shocked to find that on the other side of the door is New York City.
                                   
                                   You step through the door. You blink, disoriented, as your senses are overwhelmed by the sudden change.
                                   The cold bite of the city air, the distant sound of honking cars, and the bustle of people moving in every
                                   direction hit you all at once.
                                   
                                   You're standing on a crowded sidewalk, skyscrapers towering above you. For a moment, you can't process what's
                                   happening, your mind still caught in the endless maze of corridors and wet carpet. The city feels unreal, like
                                   a dream slipping through your fingers.
                                   
                                   A man with a hurried expression walks past you. As he does, his shoulder bumps into yours, snapping you back to reality.
                                   
                                   "Hey, watch where you're standing!" he mutters, glancing at you with annoyance before continuing on his way.
                                   
                                   You shake your head, trying to clear the fog from your mind. The city is real. You're here. And now, you have no idea 
                                   where to go next.""");
                break;
            }
            
            printEnergyAndhp(energy, hp);
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
                
            }
            
            
        }
        
    }
    
    public static void die() {
        System.out.println("""
                           ___  _ ____  _       ____  _  _____ ____  _ 
                           \\  \\///  _ \\/ \\ /\\  /  _ \\/ \\/  __//  _ \\/ \\
                            \\  / | / \\|| | ||  | | \\|| ||  \\  | | \\|| |
                            / /  | \\_/|| \\_/|  | |_/|| ||  /_ | |_/|\\_/
                           /_/   \\____/\\____/  \\____/\\_/\\____\\\\____/(_)
                                                                       """);
        alive = false;
    }
    
    public static void printEnergyAndhp(int energy, int hp) {
        // Start with a base string for "Energy ["
        StringBuilder energyString = new StringBuilder("Energy [");

        // Add '+' for the number of positive energy levels
        for (int i = 0; i < energy; i++) {
            energyString.append("+");
        }

        // Add '-' for the remaining energy levels (out of 5, for example)
        for (int i = 0; i < (5 - energy); i++) {
            energyString.append("-");
        }

        // Close the energy string with "]"
        energyString.append("]");

        // Print the energy string
        System.out.println(energyString.toString());

        // Start with a base string for "HP ["
        StringBuilder hpString = new StringBuilder("Health [");

        // Add '+' for the number of positive HP levels
        for (int i = 0; i < hp; i++) {
            hpString.append("+");
        }

        // Add '-' for the remaining HP levels (out of 10, for example)
        for (int i = 0; i < (3 - hp); i++) {
            hpString.append("-");
        }

        // Close the HP string with "]"
        hpString.append("]");

        // Print the HP string
        System.out.println(hpString.toString());
    }
    
    
}