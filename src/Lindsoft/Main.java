package Lindsoft;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {

    public static void main(String[] args) {
        // This game is under production, its thoght to be a adventuregame to better my understanding of sets and maps.

        Inventory gameInventory = new Inventory();
        Map<Integer, Locations> locations = new HashMap<>();
        Scanner userInput = new Scanner(System.in);
        String direction = ""; // direction you want to go
        int location = 10; // current position

        gameInventory.addToItems("CROWBAR");
        gameInventory.addToItems("THE KEY");
        gameInventory.addToItems("GASOLINE");
        gameInventory.addToItems("CARKEYS");

        //       gameInventory.addItemInventory("CROWBAR");
//        gameInventory.addItemInventory("THE KEY");
//        gameInventory.addItemInventory("GASOLINE");
//        gameInventory.addItemInventory("CARKEYS");


//        gameInventory.addItemInventory("THE KEY");

        // BEDROOM
        locations.put(10, new Locations(10, "You are in a bedroom. Theres bed with dirty sheets that you woke up in. There is also a wardrobe\n", false));
        locations.get(10).addExit("S", 20);
        locations.get(10).addExit("E", 50);
        locations.get(10).addExit("WARDROBE", 11);

        locations.put(11, new Locations(11, "You are in front of a wardrobe.\n", false));
        locations.get(11).addExit("BACK", 10);
        locations.get(11).addExit("OPEN", 12);

        locations.put(12, new ItemLocation(12, "You unlocked it.", "GASOLINE", "THE KEY", "The door is locked.\n"));
        locations.get(12).addExit("BACK", 10);

        // KITCHEN
        locations.put(20, new Locations(20, "You are in a kitchen... the theres is old scrapings and dirty dishes everywhere. Theres only one drawer in the kitchen thats closed.\n", false));
        locations.get(20).addExit("DRAWER", 21);
        locations.get(20).addExit("N", 10);
        locations.get(20).addExit("E", 30);

        locations.put(21, new Locations(21, "You are in front of the closed drawer\n", false));
        locations.get(21).addExit("OPEN", 22);
        locations.get(21).addExit("BACK", 20);

        locations.put(22, new ItemLocation(22, "Theres a old key in the drawer\n", "THE KEY", null, null));
        locations.get(22).addExit("BACK", 20);

        // LIVINGROOM
        locations.put(30, new Locations(30, "You are in the 'Livingroom' althought there doesn't seem to be much living here. \n Theres nothing of interest besides a box in here\n", false));
        locations.get(30).addExit("BOX", 31);
        locations.get(30).addExit("NE", 40);
        locations.get(30).addExit("NW", 50);
        locations.get(30).addExit("W", 20);

        locations.put(31, new Locations(31, "You are in front of the box.\n", false));
        locations.get(31).addExit("BACK", 30);
        locations.get(31).addExit("OPEN", 32);

        locations.put(32, new ItemLocation(32, "You cracked it open.", "CARKEYS", "CROWBAR", "Can't open, the lit is stuck\n"));
        locations.get(32).addExit("BACK", 20);

        // OFFICE
        locations.put(40, new Locations(40, "You are in some kind of office. Theres a desk in the room \n", false));
        locations.get(40).addExit("DESK", 41);
        locations.get(40).addExit("E", 50);
        locations.get(40).addExit("S", 30);

        locations.put(41, new Locations(41, "You are in front of the desk, theres a lot of old documents and a bloody crowbar on the desk\n", false));
        locations.get(41).addExit("BACK", 40);
        locations.get(41).addExit("CROWBAR", 42);

        locations.put(42, new ItemLocation(42, null, "CROWBAR", null, null));
        locations.get(42).addExit("BACK", 20);

        //HALLWAY
        locations.put(50, new Locations(50, "You're in the hallway, the way out of the house is north \n", false));
        locations.get(50).addExit("N", 60);
        locations.get(50).addExit("E", 10);
        locations.get(50).addExit("W", 40);
        locations.get(50).addExit("S", 30);

        // OUTSIDE
        locations.put(60, new Locations(60, "You're outside, it's foggy and cold. There's a car on the diveway to the East\n", false));
        locations.get(60).addExit("E", 70);
        locations.get(60).addExit("S", 50);

        // CAR
        locations.put(70, new Locations(70, "You're in the car\n", false));
        locations.get(70).addExit("START CAR", 71);
        locations.get(70).addExit("BACK", 60);

        //ExitCheck
        locations.put(71, new ExitCheck(71, "Trying to start car..", "You started the car and drove away from this horrific house"));
        locations.get(71).addExit("BACK", 70);

        while (true) {
            System.out.println(locations.get(location).getRoomDescription());
            locations.get(location).printExits();

            if (location == 71) {
                if (((ExitCheck) locations.get(71)).canExit(gameInventory.getItemsInInventory())) {
                    break;
                }
            }

            if (location == 0) {
                break;
            }

            direction = userInput.nextLine();
            Map<String, Integer> exits = locations.get(location).getExits();

            if (exits.containsKey(direction)) { // if the given exit is a key in exits
                int oldLocation = location;
                location = exits.get(direction);

                if (locations.get(location).isItemRoom()) {

                    if (locations.get(location).requirementMet(gameInventory.getItemsInInventory())) { // if the requirements are met for the room
                        System.out.println(locations.get(location).getRoomDescription());
                        gameInventory.addItemInventory(locations.get(location).isInRoom(gameInventory.getItemsInInventory())); // Code to put in inventory, returns null if you dont have the required item

                    }
                    location = oldLocation;
                }

            } else {
                System.out.println("You cannot go in that direction");
            }

            if (gameInventory.ItemsToGet() <= 0) {
                System.out.println("You now have all the items required to escape");
            }
        }
    }
}
