
import java.util.*;

public class LinkedList01 {

    public static void main(String[] args) {
        // Creating LinkedList
        LinkedList<String> cities = new LinkedList<>();
        // Adding elements to the LinkedList

        cities.add("New York");
        cities.add("Los Angeles");
        cities.add("Chicago");
        cities.add("Houston");
        cities.add("Phoenix");
        System.out.println("Cities: " + cities);
        System.out.println("");
        // Adding elements at specific positions
        cities.add(1, "Mumbai");
        cities.addFirst("Tokyo");
        cities.addLast("Berlin");
        System.out.println("Cities after additions: " + cities);
        System.out.println("");
        //Displaying cities one by one
        System.out.println("Displaying cities:");
        for (String city : cities) {
            System.out.println("City: " + city);
        }
        System.out.println("");
        // Accessing elements
        System.out.println("First City: " + cities.getFirst());
        System.out.println("Last City: " + cities.getLast());
        System.out.println("City at index 2: " + cities.get(1));
        System.out.println("City at index 4: " + cities.get(4));
        System.out.println("");
        // Removing elements
        cities.remove("Chicago");
        cities.removeFirst();
        cities.removeLast();
        System.out.println("Cities after removals: " + cities);
        System.out.println("");

        //modifying elements
        cities.set(4, "San Francisco");
        System.out.println("Cities after modification: " + cities);
        System.out.println("");

        //Size operation
        System.out.println("Size of the linked list: " + cities.size());
        System.out.println("checking is list is empty?? " + cities.isEmpty());
        System.out.println("");

        // Finding elements
        boolean contains = cities.contains("Tokyo");
        if (contains) {
            System.out.println("Tokyo is in the list.");
        } else {
            System.out.println("Tokyo is not in the list.");
        }

        boolean Mumbai = cities.contains("Mumbai");
        if (Mumbai) {
            System.out.println("Mumbai is in the list.");
        } else {
            System.out.println("Mumbai is not in the list.");
        }
        System.out.println("");

        //finding elements using indexOf
        int index = cities.indexOf("San Francisco");
        if (index != -1) {
            System.out.println("San Francisco is at index: " + index);
        } else {
            System.out.println("San Francisco is not in the list.");
        }

        int index2 = cities.indexOf("Berlin");
        if (index2 != -1) {
            System.out.println("Berlin is at index: " + index2);
        } else {
            System.out.println("Berlin is not in the list.");
        }

    }
}
