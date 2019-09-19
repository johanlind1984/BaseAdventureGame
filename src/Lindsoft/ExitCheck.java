package Lindsoft;

import java.util.HashSet;
import java.util.Set;

public class ExitCheck extends Locations {

    private Set<String> itemsToExit;
    private String exitMessage;

    public ExitCheck(int position, String roomDescription, String exitMessage) {
        super(position, roomDescription, false);
        this.itemsToExit = new HashSet<>();
        this.exitMessage = exitMessage;
        itemsToExit.add("CARKEYS");
        itemsToExit.add("GASOLINE");

    }

    public boolean canExit(Set<String> inventory) {
        Set<String> testSet = new HashSet<>(this.itemsToExit);
        testSet.removeAll(inventory);

        if (testSet.size() <= 0) {
            System.out.println(exitMessage);
            return true;
        } else {
            System.out.println("You can't escape yet, you still need: ");
            for (String itemLeft : testSet) {
                System.out.print(itemLeft + ", ");
            }
            System.out.println();
            return false;
        }
    }

    public String getExitMessage() {
        return exitMessage;
    }
}
