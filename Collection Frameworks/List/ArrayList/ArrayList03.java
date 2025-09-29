
import java.util.ArrayList;

public class ArrayList03 {

    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("banana");
        fruits.add("Cherry");
        fruits.add("Orange");
        System.out.println("Fruits list" + fruits);
        System.out.println("Fruit Size : " + fruits.size());

        System.out.println("First fruit :" + fruits.get(0));
        System.out.println("Second fruit : " + fruits.get(1));

        if (fruits.contains("banana")) {
            System.out.println("Banana is in fruit list");
        }

        //remove an element
        fruits.remove("banana");
        System.out.println("After removing the banana : " + fruits);

        //Add element to the specific position
        fruits.add(1, "Mango");
        System.out.println("After adding mango at specific position : " + fruits);

        //loop through the arraylist 
        System.out.println("All fruits");
        for (String fruit : fruits) { //
            System.out.println("- " + fruit);
        }

        System.out.println("Checking List is empty or not :" + fruits.isEmpty());

        //clear all elements
        fruits.clear();
        System.out.println("After clearing all elements : " + fruits);
        System.out.println("Checking List is empty or not :" + fruits.isEmpty());

    }
}
