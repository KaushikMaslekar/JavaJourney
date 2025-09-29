
import java.util.*;

public class HashSetDetailed {

    public static void main(String[] args) {
        System.out.println("=== HASHSET DETAILED EXAMPLES ===\n");

        basicHashSetOperations();
        hashSetConstructors();
        performanceCharacteristics();
        hashSetWithCustomObjects();
        practicalExamples();
    }

    static void basicHashSetOperations() {
        System.out.println("1. BASIC HASHSET OPERATIONS");
        System.out.println("HashSet: Fast operations, no ordering guarantee\n");

        HashSet<String> colors = new HashSet<>();

        // Adding elements - notice no specific order
        System.out.println("Adding elements:");
        System.out.println("add(\"Red\"): " + colors.add("Red"));
        System.out.println("add(\"Blue\"): " + colors.add("Blue"));
        System.out.println("add(\"Green\"): " + colors.add("Green"));
        System.out.println("add(\"Red\") again: " + colors.add("Red")); // false - duplicate

        System.out.println("HashSet: " + colors);
        System.out.println("Notice: Order is not guaranteed!\n");

        // Fast lookups
        System.out.println("Fast lookup operations:");
        System.out.println("contains(\"Blue\"): " + colors.contains("Blue"));
        System.out.println("contains(\"Yellow\"): " + colors.contains("Yellow"));

        // Fast removal
        System.out.println("\nFast removal:");
        System.out.println("remove(\"Green\"): " + colors.remove("Green"));
        System.out.println("After removal: " + colors);

        System.out.println("Size: " + colors.size());
        System.out.println();
    }

    static void hashSetConstructors() {
        System.out.println("2. HASHSET CONSTRUCTORS");
        System.out.println("Different ways to create HashSet\n");

        // Default constructor
        HashSet<String> set1 = new HashSet<>();
        set1.add("A");
        set1.add("B");
        System.out.println("Default constructor: " + set1);

        // Constructor with initial capacity
        HashSet<String> set2 = new HashSet<>(20);
        set2.add("C");
        set2.add("D");
        System.out.println("With initial capacity (20): " + set2);

        // Constructor with initial capacity and load factor
        HashSet<String> set3 = new HashSet<>(16, 0.75f);
        set3.add("E");
        set3.add("F");
        System.out.println("With capacity (16) and load factor (0.75): " + set3);

        // Constructor from another collection
        List<String> list = Arrays.asList("X", "Y", "Z", "X"); // Note: "X" appears twice
        HashSet<String> set4 = new HashSet<>(list);
        System.out.println("From collection (duplicates removed): " + set4);

        // Using Collections.singleton() for single element set
        Set<String> singletonSet = Collections.singleton("OnlyElement");
        System.out.println("Singleton set: " + singletonSet);
        // singletonSet.add("Another"); // This would throw UnsupportedOperationException

        System.out.println();
    }

    static void performanceCharacteristics() {
        System.out.println("3. PERFORMANCE CHARACTERISTICS");
        System.out.println("HashSet provides O(1) average time complexity\n");

        HashSet<Integer> hashSet = new HashSet<>();
        final int ELEMENTS = 100000;

        // Measure add performance
        System.out.println("Adding " + ELEMENTS + " elements:");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < ELEMENTS; i++) {
            hashSet.add(i);
        }
        long addTime = System.currentTimeMillis() - startTime;
        System.out.println("Add time: " + addTime + " ms");

        // Measure contains performance
        System.out.println("\nChecking existence of " + (ELEMENTS / 10) + " random elements:");
        Random random = new Random(42);
        startTime = System.currentTimeMillis();
        int found = 0;
        for (int i = 0; i < ELEMENTS / 10; i++) {
            if (hashSet.contains(random.nextInt(ELEMENTS))) {
                found++;
            }
        }
        long containsTime = System.currentTimeMillis() - startTime;
        System.out.println("Contains time: " + containsTime + " ms");
        System.out.println("Found: " + found + " elements");

        // Measure remove performance
        System.out.println("\nRemoving " + (ELEMENTS / 10) + " random elements:");
        random = new Random(42);
        startTime = System.currentTimeMillis();
        int removed = 0;
        for (int i = 0; i < ELEMENTS / 10; i++) {
            if (hashSet.remove(random.nextInt(ELEMENTS))) {
                removed++;
            }
        }
        long removeTime = System.currentTimeMillis() - startTime;
        System.out.println("Remove time: " + removeTime + " ms");
        System.out.println("Removed: " + removed + " elements");
        System.out.println("Final size: " + hashSet.size());
        System.out.println();
    }

    static void hashSetWithCustomObjects() {
        System.out.println("4. HASHSET WITH CUSTOM OBJECTS");
        System.out.println("Importance of proper hashCode() and equals() implementation\n");

        HashSet<Student> students = new HashSet<>();

        // Adding students
        Student s1 = new Student("Alice", 123);
        Student s2 = new Student("Bob", 456);
        Student s3 = new Student("Alice", 123); // Same as s1

        System.out.println("Adding students:");
        System.out.println("add(Alice-123): " + students.add(s1));
        System.out.println("add(Bob-456): " + students.add(s2));
        System.out.println("add(Alice-123 again): " + students.add(s3)); // Should be false

        System.out.println("Students set: " + students);
        System.out.println("Size: " + students.size());

        // Demonstrate lookup
        Student lookupStudent = new Student("Alice", 123);
        System.out.println("\nLooking up new Student(\"Alice\", 123):");
        System.out.println("contains(lookupStudent): " + students.contains(lookupStudent));

        // Show hash codes
        System.out.println("\nHash codes:");
        System.out.println("s1.hashCode(): " + s1.hashCode());
        System.out.println("s3.hashCode(): " + s3.hashCode());
        System.out.println("lookupStudent.hashCode(): " + lookupStudent.hashCode());
        System.out.println("All same? " + (s1.hashCode() == s3.hashCode()
                && s3.hashCode() == lookupStudent.hashCode()));
        System.out.println();
    }

    static void practicalExamples() {
        System.out.println("5. PRACTICAL EXAMPLES");
        System.out.println("Real-world usage scenarios for HashSet\n");

        // Example 1: Remove duplicates from a list
        System.out.println("--- Removing Duplicates ---");
        List<String> listWithDuplicates = Arrays.asList("Apple", "Banana", "Apple", "Orange", "Banana", "Grape");
        System.out.println("Original list: " + listWithDuplicates);

        HashSet<String> uniqueElements = new HashSet<>(listWithDuplicates);
        List<String> uniqueList = new ArrayList<>(uniqueElements);
        System.out.println("After removing duplicates: " + uniqueList);

        // Example 2: Fast membership testing
        System.out.println("\n--- Fast Membership Testing ---");
        HashSet<String> allowedUsers = new HashSet<>(Arrays.asList("admin", "user1", "user2", "guest"));

        String[] loginAttempts = {"admin", "hacker", "user1", "anonymous", "guest"};
        System.out.println("Allowed users: " + allowedUsers);
        System.out.println("Login attempts:");

        for (String user : loginAttempts) {
            if (allowedUsers.contains(user)) {
                System.out.println("✓ " + user + " - Access granted");
            } else {
                System.out.println("✗ " + user + " - Access denied");
            }
        }

        // Example 3: Set operations for data analysis
        System.out.println("\n--- Data Analysis with Sets ---");
        HashSet<String> mondayVisitors = new HashSet<>(Arrays.asList("Alice", "Bob", "Charlie", "David"));
        HashSet<String> tuesdayVisitors = new HashSet<>(Arrays.asList("Bob", "David", "Eve", "Frank"));

        System.out.println("Monday visitors: " + mondayVisitors);
        System.out.println("Tuesday visitors: " + tuesdayVisitors);

        // Who visited both days?
        HashSet<String> bothDays = new HashSet<>(mondayVisitors);
        bothDays.retainAll(tuesdayVisitors);
        System.out.println("Visited both days: " + bothDays);

        // Who visited only Monday?
        HashSet<String> onlyMonday = new HashSet<>(mondayVisitors);
        onlyMonday.removeAll(tuesdayVisitors);
        System.out.println("Only Monday: " + onlyMonday);

        // Total unique visitors
        HashSet<String> allVisitors = new HashSet<>(mondayVisitors);
        allVisitors.addAll(tuesdayVisitors);
        System.out.println("Total unique visitors: " + allVisitors);
        System.out.println("Total count: " + allVisitors.size());
    }
}

// Custom class with proper hashCode and equals implementation
class Student {

    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return name + "-" + id;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
