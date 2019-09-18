package Lindsoft;

import java.util.HashSet;
import java.util.Set;

public class Inventory {

    private Set<String> items;
    private Set<String> itemsInInventory;

    public Inventory() {
        this.itemsInInventory = new HashSet<>();
        this.items = new HashSet<>();
    }

    public void addToItems (String item) {
        if(items.contains(item)) {
            System.out.println("That " + item + " was already in the list so i overwrote it with the new item");
        } else {
            this.items.add(item.toUpperCase());
        }

    }

    public boolean addItemInventory(String item) {

        if(itemsInInventory.contains(item)) {
            System.out.println("This is where you found the " + item + " there's nothing more useful here");
            return false;

        } else if(items.contains(item)) {
            System.out.println("Found a " + item + ", this could be useful. I'll save this for later.");
            System.out.println("====You placed " + item + " in your inventory==========");
            itemsInInventory.add(item);
            return true;

        } else {
            System.out.println("Item does not exist in this game");
            return false;
        }
    }

    public void whatToGet() {
        Set<String> itemsToGet = new HashSet<>(items);
        itemsToGet.removeAll(itemsInInventory);

        System.out.print("You still need to find: ");
        for (String item: itemsToGet) {
            System.out.print(item + ", ");
        }
        System.out.println("");
    }

    public Set<String> getItemsInInventory() {
        HashSet<String> returnItems = new HashSet<>(itemsInInventory);
        return returnItems;
    }
}
