package Lindsoft;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Locations {

    private final Map<String, Integer> exits;
    private final int position;
    private final String roomDescription;
    private final boolean isItemRoom;

    public Locations(int position, String roomDescription, boolean isItemRoom) {
        this.position = position;
        this.roomDescription = roomDescription;
        this.exits = new HashMap<>();
        this.isItemRoom = isItemRoom;
        exits.put("QUIT", 0);
    }

    public void addExit(String direction, int position) {
        // Adds exit to the room, direction = command, ex. go North, go West etc. Position = where you end up if you
        // take this direction.
        this.exits.put(direction, position);
    }

    public boolean requirementMet(Set<String> item) {
        return false;
    }

    public String isInRoom(Set<String> item) {

        return null;
    }

    public int getPosition() {
        return position;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void printExits() {
        System.out.println("Available paths to go: ");

        for (String exit : exits.keySet()) {
            System.out.print(exit + ", ");
        }

        System.out.println();
    }

    public Map<String, Integer> getExits() {
        return exits;

    }

    public boolean isItemRoom() {
        return isItemRoom;
    }
}
