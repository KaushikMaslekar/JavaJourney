
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHashSetExample {

    public static void main(String[] args) {
        System.out.println("===LinkedHashSet Detailed Example===");
        basicLinkedHashSetOperation();
        insertionOrderMaintenance();
        performanceComparison();
        practicalExamples();
        linkedHashSetvsHashSet();
    }

    static void basicLinkedHashSetOperation() {
        System.out.println("1. Basic LinkedHashSet Operatiions");
        System.out.println("LinkedHashSet : fast operations and maintains insertions order");

        LinkedHashSet<String> fruits = new LinkedHashSet<>();
        //Adding elements - order is preserved
        System.out.println("Adding elements to LinkedHashSet:");
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Date");
        fruits.add("Apple"); //Duplicate, will not be added
        System.out.println("Fruits: " + fruits);
        System.out.println("Notice : Insertion order is maintained, even with duplicates not added");
        System.out.println("Size of LinkedHashSet: " + fruits.size());
        //Iteration maintains order
        System.out.println("Iterating over LinkedHashSet:");
        int position = 1;
        for (String fruit : fruits) {
            System.out.println("Position " + position + ": " + fruit);
            position++;
        }
        //removing an element
        System.out.println("\nRemoving 'Banana' and adding it back:");
        fruits.remove("Banana");
        System.out.println("After removal: " + fruits);
        fruits.add("Banana");
        System.out.println("After adding back: " + fruits);
        System.out.println("Notice: 'Banana' is now at the end (new insertion)\n");
        //Checking if an element exists
        System.out.println("fruits " + fruits);
    }

    static void insertionOrderMaintenance() {
        System.out.println("2. Insertion Order Maintenance");
        System.out.println("Demonstrating that LinkedHashSet maintains insertion order:");

        LinkedHashSet<Integer> numbers = new LinkedHashSet<>();
        int[] randomNumbers = {5, 3, 8, 1, 2, 5, 3}; // Contains duplicates
        System.out.println("Adding numbers in order :" + Arrays.toString(randomNumbers));
        for (int num : randomNumbers) {
            boolean added = numbers.add(num);
            System.out.println("add(" + num + "):" + added + " --> " + numbers);
        }
    }

    static void performanceComparison() {
        System.out.println("3. Performance Comparison with HashSet");
        System.out.println("LinkedHashSet maintains insertion order, while HashSet does not.");
        final int ELEMENTS = 10000;

        //LinkedHashSet Performance 
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < ELEMENTS; i++) {
            linkedHashSet.add(i);
        }
        long linkedHashAddTime = System.currentTimeMillis() - startTime;
        System.out.println("LinkedHashSet add time for " + ELEMENTS + " elements: " + linkedHashAddTime + " ms");
        //HashSet Performance
        HashSet<Integer> hashSet = new HashSet<>();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < ELEMENTS; i++) {
            hashSet.add(i);
        }
        long hashAddTime = System.currentTimeMillis() - startTime;
        System.out.println("HashSet add time for " + ELEMENTS + " elements: " + hashAddTime + " ms");
        System.out.println("LinkedHashSet is " + (linkedHashAddTime < hashAddTime ? "Faster" : "Slower") + " than HashSet for add operations.");
        System.out.println("Overhead: " + String.format("%.2f", (double) linkedHashAddTime / hashAddTime) + "x\n");
        // Iteration performance
        startTime = System.currentTimeMillis();
        for (Integer num : linkedHashSet) {
            // Just iterate
        }
        long linkedIterTime = System.currentTimeMillis() - startTime;
        startTime = System.currentTimeMillis();
        for (Integer num : hashSet) {
            // Just iterate
        }
        long hashIterTime = System.currentTimeMillis() - startTime;
        System.out.println("Iteration through " + ELEMENTS + " elements:");
        System.out.println("LinkedHashSet: " + linkedIterTime + " ms");
        System.out.println("HashSet: " + hashIterTime + " ms");
        System.out.println("LinkedHashSet iteration is often faster due to linked structure!\n");
    }

    static void practicalExamples() {
        System.out.println("4. Practical Examples of linkedHashSet");
        System.out.println("Real World Scenarios where LinkedHashSet is useful:");

        //Example 1: Preserving  user input order
        System.out.println("== User Input Order Preservation ==");
        LinkedHashSet<String> userChoices = new LinkedHashSet<>();

        //simulate user selecting options 
        String[] selections = {"Pizza", "Burger", "Pasta", "Salad", "Pizza", "Pasta", "Burger", "Sushi"};
        System.out.println("User Selections: " + Arrays.toString(selections));
        for (String choice : selections) {
            if (userChoices.add(choice)) {
                System.out.println("Added: " + choice);
            } else {
                System.out.println("Duplicate ignored: " + choice);
            }
        }
        System.out.println("Final User Choices (in order): " + userChoices);

        //Example 2: Maintaining order of unique visitors
        System.out.println("==Task Processing Order==");
        LinkedHashSet<String> taskQueue = new LinkedHashSet<>();

        //Task arrive in the order 
        taskQueue.add("Initialize Database");
        taskQueue.add("Load Configuration");
        taskQueue.add("Start Application");
        taskQueue.add("Initialize Database"); //Duplicate, will not be added
        taskQueue.add("Load User Data");
        taskQueue.add("Open connection");
        System.out.println("Task Queue (in order): " + taskQueue);

        System.out.println("Processing tasks in order:");
        int taskNumber = 1;
        for (String task : taskQueue) {
            System.out.println(taskNumber + "Processing: " + task);
            taskNumber++;
        }

        //Example 3: form field validation
        System.out.println("== Form Field Validation == ");
        LinkedHashSet<String> errors = new LinkedHashSet<>();

        //validate form fields
        validateField("Username", "JohnDoe", errors);
        validateField("Email", "invalid-email", errors);
        validateField("Password", "", errors);
        validateField("Email", "invalid-email", errors); //Duplicate error, will not be added
        validateField("Phone", "123-456-7890", errors);

        System.out.println("Validation Errors (in order) encountered:");
        int errNumber = 1;
        for (String error : errors) {
            System.out.println(errNumber + ". " + error);
            errNumber++;
        }
        System.out.println();

    }

    static void linkedHashSetvsHashSet() {
        System.out.println("5. LINKEDHASHSET VS HASHSET COMPARISON");
        System.out.println("Side-by-side comparison of behavior\n");

        String[] data = {"Zebra", "Apple", "Mango", "Banana", "Apple", "Zebra"};
        System.out.println("Input data: " + Arrays.toString(data));

        // LinkedHashSet
        LinkedHashSet<String> linkedSet = new LinkedHashSet<>();
        for (String item : data) {
            linkedSet.add(item);
        }

        // HashSet
        HashSet<String> hashSet = new HashSet<>();
        for (String item : data) {
            hashSet.add(item);
        }

        System.out.println("\nLinkedHashSet result: " + linkedSet);
        System.out.println("HashSet result: " + hashSet);

        System.out.println("\nLinkedHashSet maintains insertion order:");
        System.out.println("Expected order: [Zebra, Apple, Mango, Banana]");
        System.out.println("Actual order: " + Arrays.toString(linkedSet.toArray()));

        System.out.println("\nHashSet has arbitrary order:");
        System.out.println("Actual order: " + Arrays.toString(hashSet.toArray()));

        // Memory usage comparison
        System.out.println("\nMemory Usage:");
        System.out.println("HashSet: Uses only hash table");
        System.out.println("LinkedHashSet: Hash table + doubly-linked list");
        System.out.println("LinkedHashSet uses more memory but provides predictable iteration");

        // When to use which
        System.out.println("\nRecommendations:");
        System.out.println("Use LinkedHashSet when:");
        System.out.println(" Order of elements matters for display/processing");
        System.out.println(" You need predictable iteration order");
        System.out.println(" Converting between List and Set while preserving order");
        System.out.println("\nUse HashSet when:");
        System.out.println(" Maximum performance is critical");
        System.out.println(" Order doesn't matter");
        System.out.println(" Memory usage is a concern");
        System.out.println();
    }

    //Helper method for form validation example
    static void validateField(String fieldName, String value, LinkedHashSet<String> errors) {
        if (value == null || value.trim().isEmpty()) {
            errors.add(fieldName + " cannot be empty.");
        } else if (fieldName.equals("email") && !value.contains("@")) {
            errors.add(fieldName + " email must be valid");
        } else if (fieldName.equals("phone") && !value.matches("\\d+")) { // 
            errors.add(fieldName + " must contain only numbers");
        }
    }
}
