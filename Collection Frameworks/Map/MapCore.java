
import java.util.*;

public class MapCore {

    public static void main(String[] args) {
        System.out.println("=== MAP INTERFACE - CORE CONCEPTS ===\n");

        demonstrateKeyValuePairs();
        demonstrateBasicOperations();
        demonstrateKeyUniqueness();
        demonstrateNullHandling();
        demonstrateBulkOperations();
        demonstrateViewCollections();
        demonstrateIterationMethods();
    }

    static void demonstrateKeyValuePairs() {
        System.out.println("1. KEY-VALUE PAIR CONCEPT");
        System.out.println("Map stores associations between keys and values\n");

        Map<String, Integer> studentGrades = new HashMap<>();

        // Putting key-value pairs
        studentGrades.put("Alice", 85);
        studentGrades.put("Bob", 92);
        studentGrades.put("Charlie", 78);

        System.out.println("Map contents: " + studentGrades);
        System.out.println("Key 'Alice' maps to value: " + studentGrades.get("Alice"));
        System.out.println("Key 'Bob' maps to value: " + studentGrades.get("Bob"));
        System.out.println("Non-existent key 'David': " + studentGrades.get("David"));
        System.out.println();
    }

    static void demonstrateBasicOperations() {
        System.out.println("2. BASIC MAP OPERATIONS");
        System.out.println("Core methods for working with maps\n");

        Map<String, String> capitals = new HashMap<>();

        // PUT operations
        System.out.println("=== PUT Operations ===");
        System.out.println("put(\"India\", \"New Delhi\"): " + capitals.put("India", "New Delhi"));
        System.out.println("put(\"USA\", \"Washington DC\"): " + capitals.put("USA", "Washington DC"));
        System.out.println("put(\"France\", \"Paris\"): " + capitals.put("France", "Paris"));
        System.out.println("Current map: " + capitals);

        // Overwriting existing key
        System.out.println("\nOverwriting existing key:");
        String oldValue = capitals.put("India", "Mumbai"); // Wrong capital for demo
        System.out.println("put(\"India\", \"Mumbai\") returned: " + oldValue);
        System.out.println("Current map: " + capitals);

        // Correcting the value
        capitals.put("India", "New Delhi");

        // GET operations
        System.out.println("\n=== GET Operations ===");
        System.out.println("get(\"USA\"): " + capitals.get("USA"));
        System.out.println("get(\"Japan\"): " + capitals.get("Japan")); // null - doesn't exist

        // getOrDefault
        System.out.println("getOrDefault(\"Japan\", \"Unknown\"): "
                + capitals.getOrDefault("Japan", "Unknown"));

        // CONTAINMENT checks
        System.out.println("\n=== Containment Checks ===");
        System.out.println("containsKey(\"France\"): " + capitals.containsKey("France"));
        System.out.println("containsKey(\"Germany\"): " + capitals.containsKey("Germany"));
        System.out.println("containsValue(\"Paris\"): " + capitals.containsValue("Paris"));
        System.out.println("containsValue(\"Berlin\"): " + capitals.containsValue("Berlin"));

        // SIZE operations
        System.out.println("\n=== Size Operations ===");
        System.out.println("size(): " + capitals.size());
        System.out.println("isEmpty(): " + capitals.isEmpty());

        // REMOVE operations
        System.out.println("\n=== Remove Operations ===");
        String removed = capitals.remove("France");
        System.out.println("remove(\"France\"): " + removed);
        System.out.println("After removal: " + capitals);

        // Remove with value check
        boolean removedWithValue = capitals.remove("USA", "New York"); // Wrong value
        System.out.println("remove(\"USA\", \"New York\"): " + removedWithValue);
        removedWithValue = capitals.remove("USA", "Washington DC"); // Correct value
        System.out.println("remove(\"USA\", \"Washington DC\"): " + removedWithValue);
        System.out.println("Final map: " + capitals);
        System.out.println();
    }

    static void demonstrateKeyUniqueness() {
        System.out.println("3. KEY UNIQUENESS");
        System.out.println("Each key can appear only once in a map\n");

        Map<String, String> phoneBook = new HashMap<>();

        phoneBook.put("John", "123-456");
        phoneBook.put("Jane", "789-012");
        phoneBook.put("John", "111-222"); // Overwrites previous John entry

        System.out.println("Phone book: " + phoneBook);
        System.out.println("Size: " + phoneBook.size());
        System.out.println("John's number: " + phoneBook.get("John"));
        System.out.println("Only the latest value for 'John' is kept\n");

        // Multiple keys can have same value
        phoneBook.put("Johnny", "111-222"); // Same number as John
        System.out.println("After adding Johnny with same number: " + phoneBook);
        System.out.println("Multiple keys can have the same value");
        System.out.println();
    }

    static void demonstrateNullHandling() {
        System.out.println("4. NULL HANDLING");
        System.out.println("How different Map implementations handle null keys/values\n");

        Map<String, String> hashMap = new HashMap<>();

        // Null values are allowed
        hashMap.put("key1", "value1");
        hashMap.put("key2", null);
        hashMap.put("key3", "value3");

        System.out.println("HashMap with null value: " + hashMap);
        System.out.println("get(\"key2\"): " + hashMap.get("key2"));

        // Null key is allowed (only one)
        hashMap.put(null, "null-key-value");
        hashMap.put(null, "updated-null-key"); // Overwrites

        System.out.println("HashMap with null key: " + hashMap);
        System.out.println("get(null): " + hashMap.get(null));

        // Checking containment with null
        System.out.println("containsKey(null): " + hashMap.containsKey(null));
        System.out.println("containsValue(null): " + hashMap.containsValue(null));

        System.out.println("Note: TreeMap doesn't allow null keys!");
        System.out.println();
    }

    static void demonstrateBulkOperations() {
        System.out.println("5. BULK OPERATIONS");
        System.out.println("Working with multiple key-value pairs at once\n");

        Map<String, Integer> scores1 = new HashMap<>();
        scores1.put("Alice", 85);
        scores1.put("Bob", 90);
        scores1.put("Charlie", 75);

        Map<String, Integer> scores2 = new HashMap<>();
        scores2.put("Diana", 95);
        scores2.put("Eve", 88);
        scores2.put("Bob", 92); // Will overwrite Bob's score

        System.out.println("Scores1: " + scores1);
        System.out.println("Scores2: " + scores2);

        // putAll - merge maps
        System.out.println("\n=== putAll Operation ===");
        Map<String, Integer> allScores = new HashMap<>(scores1);
        allScores.putAll(scores2);
        System.out.println("After putAll: " + allScores);
        System.out.println("Notice: Bob's score was overwritten");

        // putIfAbsent - only put if key doesn't exist
        System.out.println("\n=== putIfAbsent Operation ===");
        Integer previousValue = allScores.putIfAbsent("Frank", 80);
        System.out.println("putIfAbsent(\"Frank\", 80): " + previousValue);

        previousValue = allScores.putIfAbsent("Alice", 100); // Alice already exists
        System.out.println("putIfAbsent(\"Alice\", 100): " + previousValue);
        System.out.println("Map after putIfAbsent: " + allScores);

        // replace operations
        System.out.println("\n=== Replace Operations ===");
        Integer oldValue = allScores.replace("Charlie", 80);
        System.out.println("replace(\"Charlie\", 80): " + oldValue);

        boolean replaced = allScores.replace("Diana", 95, 97); // old value, new value
        System.out.println("replace(\"Diana\", 95, 97): " + replaced);

        replaced = allScores.replace("Diana", 95, 98); // Wrong old value
        System.out.println("replace(\"Diana\", 95, 98): " + replaced);

        System.out.println("Final scores: " + allScores);
        System.out.println();
    }

    static void demonstrateViewCollections() {
        System.out.println("6. VIEW COLLECTIONS");
        System.out.println("Maps provide views of keys, values, and entries\n");

        Map<String, String> colors = new HashMap<>();
        colors.put("R", "Red");
        colors.put("G", "Green");
        colors.put("B", "Blue");
        colors.put("Y", "Yellow");

        System.out.println("Original map: " + colors);

        // keySet() - view of all keys
        System.out.println("\n=== keySet() ===");
        Set<String> keys = colors.keySet();
        System.out.println("Keys: " + keys);
        System.out.println("Keys type: " + keys.getClass().getSimpleName());

        // values() - view of all values
        System.out.println("\n=== values() ===");
        Collection<String> values = colors.values();
        System.out.println("Values: " + values);
        System.out.println("Values type: " + values.getClass().getSimpleName());

        // entrySet() - view of key-value pairs
        System.out.println("\n=== entrySet() ===");
        Set<Map.Entry<String, String>> entries = colors.entrySet();
        System.out.println("Entries: " + entries);

        for (Map.Entry<String, String> entry : entries) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // These views are backed by the original map
        System.out.println("\n=== Views are Backed by Original Map ===");
        keys.remove("Y"); // Removes from original map too
        System.out.println("After removing 'Y' from keySet: " + colors);

        // Trying to modify through values view
        try {
            values.remove("Blue");
            System.out.println("After removing 'Blue' from values: " + colors);
        } catch (Exception e) {
            System.out.println("Some operations might not be supported on views");
        }
        System.out.println();
    }

    static void demonstrateIterationMethods() {
        System.out.println("7. ITERATION METHODS");
        System.out.println("Different ways to iterate through maps\n");

        Map<String, Integer> ages = new HashMap<>();
        ages.put("Alice", 25);
        ages.put("Bob", 30);
        ages.put("Charlie", 35);
        ages.put("Diana", 28);

        System.out.println("Map to iterate: " + ages);

        // Method 1: Using keySet()
        System.out.println("\n=== Iteration using keySet() ===");
        for (String name : ages.keySet()) {
            System.out.println(name + " is " + ages.get(name) + " years old");
        }

        // Method 2: Using entrySet() (more efficient)
        System.out.println("\n=== Iteration using entrySet() ===");
        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            System.out.println(entry.getKey() + " is " + entry.getValue() + " years old");
        }

        // Method 3: Using values() (when you don't need keys)
        System.out.println("\n=== Iteration using values() ===");
        System.out.print("All ages: ");
        for (Integer age : ages.values()) {
            System.out.print(age + " ");
        }
        System.out.println();

        // Method 4: Using forEach (Java 8+)
        System.out.println("\n=== Using forEach (Java 8+) ===");
        ages.forEach((name, age) -> System.out.println(name + " -> " + age));

        // Method 5: Using streams
        System.out.println("\n=== Using Streams ===");
        ages.entrySet().stream()
                .filter(entry -> entry.getValue() > 30)
                .forEach(entry -> System.out.println(entry.getKey() + " is over 30"));

        // Iterator for safe removal during iteration
        System.out.println("\n=== Safe Removal using Iterator ===");
        Map<String, Integer> copyAges = new HashMap<>(ages);
        Iterator<Map.Entry<String, Integer>> iterator = copyAges.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() < 30) {
                System.out.println("Removing " + entry.getKey() + " (age " + entry.getValue() + ")");
                iterator.remove();
            }
        }
        System.out.println("After removal: " + copyAges);
    }
}
