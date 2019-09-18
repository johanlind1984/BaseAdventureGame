package Lindsoft;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Set;

public class ItemLocation extends Locations {

    String item;
    String itemRequired;
    String reasonNotPossible;


    public ItemLocation(int position, String roomDescription, String itemInRoom, String itemRequired, String reasonNotPossible) {
        super(position, roomDescription);
        this.item = itemInRoom;
        this.itemRequired = itemRequired;
        this.reasonNotPossible = reasonNotPossible;
    }

    public String isInRoom(Set<String> item) {
        // checks if inventory has the required item to enter the location first, returns the item found at location if
        // required item exists in inventory. Returns null otherwise.
        String tempItem = null;

        if(item.contains(itemRequired)) {
            for (String word: item) {
                if(word == itemRequired) {
                    tempItem = word;
                }
            }

            System.out.println("You used " + tempItem);
            System.out.println("You found a " + this.item);
            return this.item.toUpperCase();
        }
        return null;
    }

    public boolean requirementMet(Set<String> item) {
        // checks if you have the required item to enter the location in your inventory, true if true, false if false.
        if(item.contains(itemRequired)){
            return true;
        } else {
            System.out.println(this.reasonNotPossible);
            return false;
        }
    }
}
