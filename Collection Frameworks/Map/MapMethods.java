
import java.util.*;

public class MapMethods {

    public static void main(String[] args) {
        System.out.println("=== COMPLETE MAP METHODS REFERENCE ===\n");

        demonstrateBasicMethods();
        demonstrateBulkMethods();
        demonstrateConditionalMethods();
        demonstrateComputeMethods();
        demonstrateViewMethods();
        demonstrateJava8Methods();
    }

    static void demonstrateBasicMethods() {
        System.out.println("=== BASIC MAP METHODS ===\n");

        Map<String, Integer> inventory = new HashMap<>();

        // 1. put(K key, V value) - Associates key with value
        System.out.println("1. put(K key, V value)");
        System.out.println("   Returns previous value or null if no previous mapping");
        System.out.println("   put(\"apples\", 50): " + inventory.put("apples", 50));
        System.out.println("   put(\"bananas\", 30): " + inventory.put("bananas", 30));
        System.out.println("   put(\"apples\", 60): " + inventory.put("apples", 60)); // Overwrites
        System.out.println("   Current inventory: " + inventory);

        // 2. get(Object key) - Gets value for key
        System.out.println("\n2. get(Object key)");
        System.out.println("   Returns value or null if key not found");
        System.out.println("   get(\"apples\"): " + inventory.get("apples"));
        System.out.println("   get(\"oranges\"): " + inventory.get("oranges")); // null

        // 3. getOrDefault(Object key, V defaultValue)
        System.out.println("\n3. getOrDefault(Object key, V defaultValue)");
        System.out.println("   Returns value or default if key not found");
        System.out.println("   getOrDefault(\"oranges\", 0): " + inventory.getOrDefault("oranges", 0));

        // 4. remove(Object key) - Removes key-value pair
        System.out.println("\n4. remove(Object key)");
        System.out.println("   Returns removed value or null");
        System.out.println("   remove(\"bananas\"): " + inventory.remove("bananas"));
        System.out.println("   remove(\"oranges\"): " + inventory.remove("oranges"));
        System.out.println("   After removals: " + inventory);

        // 5. containsKey(Object key) / containsValue(Object value)
        System.out.println("\n5. containsKey / containsValue");
        System.out.println("   containsKey(\"apples\"): " + inventory.containsKey("apples"));
        System.out.println("   containsValue(60): " + inventory.containsValue(60));

        // 6. size() / isEmpty()
        System.out.println("\n6. size() / isEmpty()");
        System.out.println("   size(): " + inventory.size());
        System.out.println("   isEmpty(): " + inventory.isEmpty());

        // 7. clear()
        Map<String, Integer> temp = new HashMap<>(inventory);
        temp.clear();
        System.out.println("\n7. clear()");
        System.out.println("   After clear(), size: " + temp.size());
        System.out.println();
    }

    static void demonstrateBulkMethods() {
        System.out.println("=== BULK OPERATION METHODS ===\n");

        Map<String, String> map1 = new HashMap<>();
        map1.put("a", "apple");
        map1.put("b", "banana");
        map1.put("c", "cherry");

        Map<String, String> map2 = new HashMap<>();
        map2.put("c", "coconut"); // Will overwrite cherry
        map2.put("d", "date");
        map2.put("e", "elderberry");

        System.out.println("Map1: " + map1);
        System.out.println("Map2: " + map2);

        // 1. putAll(Map<? extends K, ? extends V> m)
        System.out.println("\n1. putAll(Map m)");
        Map<String, String> combined = new HashMap<>(map1);
        combined.putAll(map2);
        System.out.println("   After map1.putAll(map2): " + combined);
        System.out.println("   Notice: 'c' was overwritten from 'cherry' to 'coconut'");

        // 2. putIfAbsent(K key, V value)
        System.out.println("\n2. putIfAbsent(K key, V value)");
        String previous = combined.putIfAbsent("f", "fig");
        System.out.println("   putIfAbsent(\"f\", \"fig\"): " + previous); // null - new key
        previous = combined.putIfAbsent("a", "avocado");
        System.out.println("   putIfAbsent(\"a\", \"avocado\"): " + previous); // apple - key exists
        System.out.println("   After putIfAbsent: " + combined);

        // 3. remove(Object key, Object value)
        System.out.println("\n3. remove(Object key, Object value)");
        boolean removed = combined.remove("b", "banana");
        System.out.println("   remove(\"b\", \"banana\"): " + removed); // true - correct key-value
        removed = combined.remove("d", "durian");
        System.out.println("   remove(\"d\", \"durian\"): " + removed); // false - wrong value
        System.out.println("   After conditional removes: " + combined);
        System.out.println();
    }

    static void demonstrateConditionalMethods() {
        System.out.println("=== CONDITIONAL OPERATION METHODS ===\n");

        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 85);
        scores.put("Bob", 90);
        scores.put("Charlie", 75);

        System.out.println("Initial scores: " + scores);

        // 1. replace(K key, V value)
        System.out.println("\n1. replace(K key, V value)");
        Integer oldScore = scores.replace("Alice", 88);
        System.out.println("   replace(\"Alice\", 88): " + oldScore);
        oldScore = scores.replace("David", 95); // Non-existent key
        System.out.println("   replace(\"David\", 95): " + oldScore);
        System.out.println("   After replace: " + scores);

        // 2. replace(K key, V oldValue, V newValue)
        System.out.println("\n2. replace(K key, V oldValue, V newValue)");
        boolean replaced = scores.replace("Bob", 90, 92);
        System.out.println("   replace(\"Bob\", 90, 92): " + replaced); // true - correct old value
        replaced = scores.replace("Charlie", 80, 85); // Wrong old value
        System.out.println("   replace(\"Charlie\", 80, 85): " + replaced); // false
        System.out.println("   After conditional replace: " + scores);

        // 3. replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
        System.out.println("\n3. replaceAll(BiFunction function)");
        System.out.println("   Adding 5 bonus points to all scores:");
        scores.replaceAll((name, score) -> score + 5);
        System.out.println("   After replaceAll: " + scores);
        System.out.println();
    }

    static void demonstrateComputeMethods() {
        System.out.println("=== COMPUTE METHODS (Java 8+) ===\n");

        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = {"hello", "world", "hello", "java", "world", "hello"};

        System.out.println("Counting words: " + Arrays.toString(words));

        // 1. compute(K key, BiFunction<? super K, ? super V, ? extends V> function)
        System.out.println("\n1. compute(K key, BiFunction function)");
        for (String word : words) {
            wordCount.compute(word, (k, v) -> v == null ? 1 : v + 1);
            System.out.println("   After processing '" + word + "': " + wordCount);
        }

        // 2. computeIfAbsent(K key, Function<? super K, ? extends V> function)
        System.out.println("\n2. computeIfAbsent(K key, Function function)");
        Map<String, List<String>> groupedWords = new HashMap<>();

        for (String word : Arrays.asList("apple", "banana", "avocado", "blueberry")) {
            String firstLetter = word.substring(0, 1);
            groupedWords.computeIfAbsent(firstLetter, k -> new ArrayList<>()).add(word);
            System.out.println("   After processing '" + word + "': " + groupedWords);
        }

        // 3. computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> function)
        System.out.println("\n3. computeIfPresent(K key, BiFunction function)");
        System.out.println("   Doubling existing word counts:");
        wordCount.computeIfPresent("hello", (k, v) -> v * 2);
        wordCount.computeIfPresent("python", (k, v) -> v * 2); // Non-existent key - no change
        System.out.println("   After computeIfPresent: " + wordCount);

        // 4. merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> function)
        System.out.println("\n4. merge(K key, V value, BiFunction function)");
        Map<String, Integer> newCounts = new HashMap<>();
        newCounts.put("hello", 2);
        newCounts.put("python", 3);

        System.out.println("   Merging " + newCounts + " into " + wordCount);
        newCounts.forEach((word, count)
                -> wordCount.merge(word, count, (oldVal, newVal) -> oldVal + newVal)
        );
        System.out.println("   After merge: " + wordCount);
        System.out.println();
    }

    static void demonstrateViewMethods() {
        System.out.println("=== VIEW COLLECTION METHODS ===\n");

        Map<String, String> countries = new HashMap<>();
        countries.put("IN", "India");
        countries.put("US", "United States");
        countries.put("FR", "France");
        countries.put("JP", "Japan");

        System.out.println("Countries map: " + countries);

        // 1. keySet() - Returns Set view of keys
        System.out.println("\n1. keySet()");
        Set<String> codes = countries.keySet();
        System.out.println("   Key set: " + codes);
        System.out.println("   Type: " + codes.getClass().getSimpleName());

        // 2. values() - Returns Collection view of values
        System.out.println("\n2. values()");
        Collection<String> names = countries.values();
        System.out.println("   Values collection: " + names);
        System.out.println("   Type: " + names.getClass().getSimpleName());

        // 3. entrySet() - Returns Set view of key-value pairs
        System.out.println("\n3. entrySet()");
        Set<Map.Entry<String, String>> entries = countries.entrySet();
        System.out.println("   Entry set: " + entries);
        for (Map.Entry<String, String> entry : entries) {
            System.out.println("   " + entry.getKey() + " = " + entry.getValue());
        }

        // Views are backed by the map
        System.out.println("\n=== Views are Backed by Original Map ===");
        System.out.println("   Removing 'FR' from keySet...");
        codes.remove("FR");
        System.out.println("   Original map after keySet removal: " + countries);
        System.out.println();
    }

    static void demonstrateJava8Methods() {
        System.out.println("=== JAVA 8+ FUNCTIONAL METHODS ===\n");

        Map<String, Integer> prices = new HashMap<>();
        prices.put("Coffee", 5);
        prices.put("Tea", 3);
        prices.put("Juice", 4);
        prices.put("Water", 2);

        System.out.println("Original prices: " + prices);

        // 1. forEach(BiConsumer<? super K, ? super V> action)
        System.out.println("\n1. forEach(BiConsumer action)");
        System.out.println("   Price list:");
        prices.forEach((item, price) -> System.out.println("   " + item + ": $" + price));

        // 2. Stream operations on entrySet
        System.out.println("\n2. Stream operations");
        System.out.println("   Items costing more than $3:");
        prices.entrySet().stream()
                .filter(entry -> entry.getValue() > 3)
                .forEach(entry -> System.out.println("   " + entry.getKey() + ": $" + entry.getValue()));

        // 3. Map transformations
        System.out.println("\n3. Map transformations using streams");
        Map<String, String> priceCategories = prices.entrySet().stream()
                .collect(HashMap::new,
                        (map, entry) -> map.put(entry.getKey(),
                                entry.getValue() > 4 ? "Expensive" : "Affordable"),
                        HashMap::putAll);
        System.out.println("   Price categories: " + priceCategories);

        System.out.println("\n=== METHOD SUMMARY ===");
        System.out.println("Basic: put, get, remove, containsKey/Value, size, isEmpty, clear");
        System.out.println("Bulk: putAll, putIfAbsent, remove(k,v), replace methods");
        System.out.println("Compute: compute, computeIfAbsent, computeIfPresent, merge");
        System.out.println("Views: keySet, values, entrySet");
        System.out.println("Java8+: forEach, stream operations, functional interfaces");
    }
}
