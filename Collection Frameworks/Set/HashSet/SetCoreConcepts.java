
import java.util.*;

public class SetCoreConcepts {

    public static void main(String[] args) {
        demonstrateNoDuplicates();
        demonstrateNullHandling();
        demonstrateBasicOperations();
        demonstrateBulkOperations();
        demonstrateIterationMethods();
        demonstrateEqualityAndHashCode();
    }

    static void demonstrateNoDuplicates() {
        // //1. Sets do not allow duplicate elements.
        // System.out.println("===1. Sets do not allow duplicate elements.===");
        // System.out.println("Sets automatically handle duplicates, ensuring each element is unique.");

        // Set<String> color = new HashSet<>();
        // System.out.println("Adding the 'RED' element to the set : " + color.add("RED")); //true
        // System.out.println("Adding the 'BLUE' element to the set : " + color.add("BLUE")); //true
        // System.out.println("Adding the 'RED' element to the set again : " + color.add("RED")); //false
        // System.out.println("Set contains: " + color);
        // System.out.println("Set Size: " + color.size());
        // System.out.println("Even though we tried to add 'RED' again, it was not added because sets do not allow duplicates.");
        // System.out.println("");
    }

    static void demonstrateNullHandling() {
        // System.out.println("===2. NULL handling in sets.===");
        // System.out.println("Set can contain null elements, but only one null is allowed.");
        // Set<String> set = new HashSet<>();
        // set.add("Element1");
        // set.add(null);
        // set.add("Element2");
        // set.add(null); // Adding null again, which is allowed but will not change the set

        // System.out.println("Set after adding null: " + set);
        // System.out.println("Set size after adding null: " + set.size());
        // System.out.println("Set contains Null? " + set.contains(null));
    }

    static void demonstrateBasicOperations() {
        // System.out.println("===3. Basic operations on sets.===");
        // Set<Integer> number = new HashSet<>();
        // //Adding elements
        // System.out.println("---Adding elements to the set:---");
        // System.out.println("Adding element 10: " + number.add(10));
        // System.out.println("Adding element 20: " + number.add(20));
        // System.out.println("Adding element 30: " + number.add(30));
        // System.out.println("Adding element 40: " + number.add(40));
        // System.out.println("Adding element 30 again: " + number.add(30)); // This will return false as 30 is already present
        // System.out.println("Current elements in the set: " + number);

        // //checking existence of an element
        // System.out.println("---Checking existence of an element:---");
        // System.out.println("Does the set contain 20? " + number.contains(20));
        // System.out.println("Does the set contain 50? " + number.contains(50));
        // System.out.println("Does the set contain null? " + number.contains(null));
        // //Size operation
        // System.out.println("---Size of the set:---");
        // System.out.println("Size of the set: " + number.size());
        // System.out.println("checking if the set is empty: " + number.isEmpty());
        // //Removing elements 
        // System.out.println("---Removing elements from the set:---");
        // System.out.println("Removing element 20: " + number.remove(20));
        // System.out.println("Current elements in the set after removal: " + number);
        // System.out.println("Removing element 50 (not present): " + number.remove(50));
        // System.out.println("Does the set contain 20? " + number.contains(20));
        // //converting to an array
        // System.out.println("---Convertion to an array:---");
        // Object[] Array = number.toArray(); // Convert set to array // why Object[]? // Because a Set can contain elements of different types, so toArray() returns an array of Objects.
        // System.out.println("Set converted to array: " + Arrays.toString(Array));
        // Integer[] intArray = number.toArray(new Integer[0]); // Convert set to Integer array
        // System.out.println("Set converted to Integer array: " + Arrays.toString(intArray));
        // System.out.println("Does the array contain 30? " + Arrays.asList(intArray).contains(30));
        // //can i add element to the intArray? 
        // // No, because intArray is a fixed-size array created from the set.
        // System.out.println("");
    }

    static void demonstrateBulkOperations() {
        // System.out.println("===4. Bulk Operations on sets.===");
        // System.out.println("Mathematical set operations like union, intersection, and difference can be performed using sets.");
        // Set<String> set1 = new HashSet<>(Arrays.asList("A", "B", "C"));
        // Set<String> set2 = new HashSet<>(Arrays.asList("B", "C", "D", "E"));
        // Set<String> set3 = new HashSet<>(Arrays.asList("A", "B"));

        // //Union Operation  (addAll)
        // System.out.println("===Union of set1 and set2:===");
        // Set<String> unionSet = new HashSet<>(set1);
        // unionSet.addAll(set2);
        // System.out.println("Set1 U Set2: " + unionSet);
        // //Intersection Operation (retainAll)
        // System.out.println("===Intersection of set1 and set2:===");
        // Set<String> intersectionSet = new HashSet<>(set1);
        // intersectionSet.retainAll(set2);
        // System.out.println("Set1 ∩ Set2: " + intersectionSet);
        // //Difference Operation (removeAll)
        // System.out.println("===Difference between set1 and set2:===");
        // Set<String> differenceSet = new HashSet<>(set1);
        // differenceSet.removeAll(set2);
        // System.out.println("Set1 - Set2: " + differenceSet);
        // //Subset Operation (containsAll)
        // System.out.println("===Checking if set3 is a subset of set1: ===");
        // System.out.println("Set3 ⊆ Set1: " + set1.containsAll(set3));
        // System.out.println("Set3 ⊆ Set2: " + set2.containsAll(set3));
        // //Disjoint Operation (no common elements)
        // System.out.println("===Checking if set1 and set2 are disjoint: ===");
        // Set<String> set4 = new HashSet<>(Arrays.asList("F", "G"));
        // System.out.println("Set4 :" + set4);
        // Set<String> tempIntersection = new HashSet<>(set1);
        // tempIntersection.retainAll(set4);
        // System.out.println("Are Set1 and Set4 disjoint? " + tempIntersection.isEmpty());
        // System.out.println();
    }

    static void demonstrateIterationMethods() {
        // System.out.println("===5. Iteration methods in sets.===");
        // Set<String> languages = new HashSet<>(Arrays.asList("Java", "Python", "C++", "JavaScript"));
        // System.out.println("Set of languages: " + languages);

        // //Enhanced for loop
        // System.out.println("===Using Enhanced for loop:===");
        // for (String language : languages) {
        //     System.out.println("Language: " + language);
        // }
        // //Iterator
        // System.out.println("===Using Iterator:===");
        // Iterator<String> iterator = languages.iterator();
        // while (iterator.hasNext()) { // Check if there are more elements
        //     String language = iterator.next();
        //     System.out.println("Language: " + language);
        //     //You can also remove elements while iterating
        //     if (language.equals("C++")) {
        //         iterator.remove(); // This will remove "C++" from the set
        //         System.out.println("Removed 'C++' from the set.");
        //     }
        // }
        // System.out.println("After iterator removal, set contains: " + languages);
        // //Stream API java 8+ 
        // System.out.println("===Using Stream API:===");
        // languages.stream()
        //         .filter(lang -> lang.length() > 4) // Filter languages with more than 4 characters
        //         .forEach(lang -> System.out.println("Language with more than 4 characters: " + lang));
        // //ForEach Method (java 8+)
        // System.out.println("===Using forEach Method:===");
        // languages.forEach(lang -> System.out.println("Language: " + lang));
        // System.out.println("");
    }

    static void demonstrateEqualityAndHashCode() {
        System.out.println("===6. Equality and HashCode in sets.===");
        System.out.println("Sets use the hashCode() and equals() methods to determine uniqueness of elements.");

        //For String objects (immutable)
        Set<String> stringSet = new HashSet<>();
        stringSet.add("Hello");
        stringSet.add(new String("Hello, World!"));
        System.out.println("String Set: " + stringSet);
        System.out.println("String Size: " + stringSet.size());

        //For custom objects - need proper equals() and hashCode()
        Set<Person> personSet = new HashSet<>();
        personSet.add(new Person("John", 34));
        personSet.add(new Person("Kaushik", 21));
        personSet.add(new Person("Mayur", 22));
        personSet.add(new Person("John", 34));

        System.out.println("Person set: " + personSet);
        System.out.println("Person Size: " + personSet.size());

        //Demonstrating why equals() and HashCode() matter
        Person p1 = new Person("Bob", 35);
        Person p2 = new Person("Bob", 35);
        System.out.println("\n1.Equals(p2)" + p1.equals(p2));
        System.out.println("\np1.hashcode(): " + p1.hashCode());
        System.out.println("\np2.hashcode(): " + p2.hashCode());
        System.out.println("Same HashCode? " + (p1.hashCode() == p2.hashCode()));
    }
}
