package Lindsoft;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Set;

public class ItemLocation extends Locations {
    // A special location that holds a item but also requires a item in inventory.

    private final String item; // item the location holds
    private final String itemRequired; // item that needs to be in inventory
    public final String reasonNotPossible; // a string why you cant reach the item, for ex. if its a locked door enter value " the door is locked"


    public ItemLocation(int position, String roomDescription, String itemInRoom, String itemRequired, String reasonNotPossible) {
        super(position, roomDescription, true);
        this.item = itemInRoom;
        this.itemRequired = itemRequired;
        this.reasonNotPossible = reasonNotPossible;
    }

    @Override
    public String isInRoom(Set<String> item) {
        // checks if inventory has the required item to enter the location first, returns the item found at location if
        // required item exists in inventory. Returns null otherwise.
        if (!item.contains(this.item)) {
            String tempItem = null;

            if (item.contains(itemRequired)) {
                for (String word : item) {
                    if (word == itemRequired) {
                        tempItem = word;
                    }
                }

                if (itemRequired != null) {
                    System.out.println("You used " + tempItem);
                }
                System.out.println("You found a " + this.item);
                return this.item.toUpperCase();
            }
        }

        return null;
    }

    @Override
    public boolean requirementMet(Set<String> item) {
        // checks if you have the required item to enter the location in your inventory, true if true, false if false.
        if (item.contains(itemRequired)) {
            return true;
        } else {
            System.out.println(this.reasonNotPossible);
            return false;
        }
    }


}
