package Lindsoft;

public class Main {

    public static void main(String[] args) {
        Inventory gameInventory = new Inventory();

        gameInventory.addToItems("SHOES");
        gameInventory.addToItems("THE KEY");
        gameInventory.addToItems("GASOLINE");
        gameInventory.addToItems("CARKEYS");

        gameInventory.addItemInventory("THE KEY");
        gameInventory.addItemInventory("SHOES");

        Locations hallway = new Locations(10, "You are in a bedroom. Theres bed with dirty sheets that you woke up in. There is also a wardrobe");
        hallway.addExit("S", 21);
        hallway.addExit("W", 51);
        hallway.addExit("BED", 11);
        hallway.addExit("WARDROBE", 11);

        Locations wardrobe = new Locations(11, "You are in front of a wardrobe, the wardrobe is locked");
        wardrobe.addExit("BACK", 10);
        wardrobe.addExit("OPEN", 12);

        ItemLocation inWardrobe = new ItemLocation(12, "You unlocked it, theres not much of interest here...", "GASOLINE", "THE KEY", "The door is locked.");
        inWardrobe.addExit("BACK", 10);

        if(inWardrobe.requirementMet(gameInventory.getItemsInInventory())) {
            gameInventory.addItemInventory(inWardrobe.isInRoom(gameInventory.getItemsInInventory())); // Code to put in inventory, returns null if you dont have the required item
        }

        gameInventory.whatToGet();




    }
}
