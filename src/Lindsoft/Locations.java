package Lindsoft;

import java.util.HashMap;
import java.util.Map;

public class Locations {

    private final Map<String, Integer> exits;
    private final int position;
    private final String roomDescription;

    public Locations(int position, String roomDescription) {
        this.position = position;
        this.roomDescription = roomDescription;
        this.exits = new HashMap<>();
        exits.put("QUIT", 0);
    }

    public void addExit(String direction, int position) {
        // Adds exit to the room, direction = command, ex. go North, go West etc. Position = where you end up if you
        // take this direction.
            this.exits.put(direction, position);
    }
}
