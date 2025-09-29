
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class TreeSetDetailed {

    public static void main(String[] args) {
        System.out.println("===TreeSet detailed examples");
        basicTreeOperation();
        sortingBehavior();
        navigableSetMethod();
        customComparator();
        performanceCharacteristics();
        practicalExamples();
    }

    static void basicTreeOperation() {
        System.out.println("1. Basic TreeSet Operations");
        System.out.println("TreeSet: Sorted set implementation based on a red-Black tree.");
        TreeSet<Integer> numbers = new TreeSet<>();

        //Adding elements in random order
        System.out.println("Adding elements random elements"); // Duplicates are ignored
        int[] elements = {5, 3, 8, 1, 4, 7, 2, 6, 3, 8};
        for (int element : elements) {
            boolean added = numbers.add(element);
            System.out.println(" Added " + element + ": " + added + " --> " + numbers);
        }

        System.out.println("");
        System.out.println("Final TreeSet: " + numbers);
        System.out.println("Notice! elements are sorted in ascending order.");
        System.out.println("Size : " + numbers.size() + " Duplicate 20 ignored");
        //Basic operations

        System.out.println("contains(4): " + numbers.contains(4));
        System.err.println("remove(10): " + numbers.remove(10)); // Element not present
        System.out.println("remove(3): " + numbers.remove(3)); // Element present
        System.out.println("Final TreeSet after removals: " + numbers);
        System.out.println("isEmpty(): " + numbers.isEmpty());
        System.out.println("Clearing TreeSet");
        numbers.clear();
        System.out.println("Final TreeSet after clearing: " + numbers);
        System.out.println("isEmpty(): " + numbers.isEmpty());
        System.out.println("=== End of Basic TreeSet Operations ===\n");
    }

    static void sortingBehavior() {
        //2. Sorting Behavior
        System.out.println("2. Sorting Behavior");
        System.out.println("TreeSet sorts elements in natural order");

        //with Strings 
        TreeSet<String> words = new TreeSet<>();
        String[] wordArray = {"banana", "apple", "orange", "kiwi", "grape", "apple"};

        System.out.println("Adding words : " + Arrays.toString(wordArray));
        Collections.addAll(words, wordArray);
        System.out.println("TreeSet result: " + words);
        System.out.println("");

        //with case insensitivity
        TreeSet<String> caseInsensitive = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        Collections.addAll(caseInsensitive, wordArray);
        System.out.println("Case insensitive TreeSet: " + caseInsensitive);
        System.out.println("");

        //TreeSet doesn't allow null elements
        System.out.println("\nNull Handling");
        try {
            words.add(null);
        } catch (NullPointerException e) {
            System.out.println("Adding null to TreeSet throws NullPointerException: " + e.getMessage());
        }

    }

    static void navigableSetMethod() {

    }

    static void customComparator() {

    }

    static void performanceCharacteristics() {

    }

    static void practicalExamples() {

    }

}
