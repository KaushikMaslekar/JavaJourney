
import java.util.*;

public class SetMethodReference {

    public static void main(String[] args) {
        System.out.println("=== COMPLETE SET METHODS REFERENCE ===\n");

        Set<String> exampleSet = new HashSet<>();

        // Initialize with some data for demonstrations
        exampleSet.add("Apple");
        exampleSet.add("Banana");
        exampleSet.add("Cherry");

        System.out.println("Initial set: " + exampleSet + "\n");

        demonstrateBasicMethods(exampleSet);
        demonstrateBulkMethods();
        demonstrateQueryMethods(exampleSet);
        demonstrateConversionMethods(exampleSet);
        demonstrateIterationMethods(exampleSet);
    }

    static void demonstrateBasicMethods(Set<String> set) {
        System.out.println("=== BASIC MODIFICATION METHODS ===\n");

        // add(E e) - Adds element to set
        System.out.println("1. add(E e) - Returns true if element was added (wasn't already present)");
        System.out.println("   add(\"Date\"): " + set.add("Date"));        // true - new element
        System.out.println("   add(\"Apple\"): " + set.add("Apple"));      // false - already exists
        System.out.println("   Current set: " + set);

        // remove(Object o) - Removes element from set
        System.out.println("\n2. remove(Object o) - Returns true if element was present and removed");
        System.out.println("   remove(\"Banana\"): " + set.remove("Banana"));  // true - was present
        System.out.println("   remove(\"Orange\"): " + set.remove("Orange"));  // false - not present
        System.out.println("   Current set: " + set);

        // clear() - Removes all elements
        Set<String> tempSet = new HashSet<>(set);
        System.out.println("\n3. clear() - Removes all elements from set");
        System.out.println("   Before clear: " + tempSet);
        tempSet.clear();
        System.out.println("   After clear: " + tempSet);
        System.out.println("   Size after clear: " + tempSet.size());
        System.out.println();
    }

    static void demonstrateBulkMethods() {
        System.out.println("=== BULK OPERATION METHODS ===\n");

        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
        Set<Integer> set3 = new HashSet<>(Arrays.asList(1, 2));

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Set3: " + set3);

        // addAll(Collection<? extends E> c) - Union operation
        System.out.println("\n1. addAll(Collection c) - UNION operation");
        Set<Integer> unionSet = new HashSet<>(set1);
        boolean changed = unionSet.addAll(set2);
        System.out.println("   set1.addAll(set2): " + changed);
        System.out.println("   Result (Union): " + unionSet);

        // retainAll(Collection<?> c) - Intersection operation
        System.out.println("\n2. retainAll(Collection c) - INTERSECTION operation");
        Set<Integer> intersectionSet = new HashSet<>(set1);
        changed = intersectionSet.retainAll(set2);
        System.out.println("   set1.retainAll(set2): " + changed);
        System.out.println("   Result (Intersection): " + intersectionSet);

        // removeAll(Collection<?> c) - Difference operation
        System.out.println("\n3. removeAll(Collection c) - DIFFERENCE operation");
        Set<Integer> differenceSet = new HashSet<>(set1);
        changed = differenceSet.removeAll(set2);
        System.out.println("   set1.removeAll(set2): " + changed);
        System.out.println("   Result (Difference): " + differenceSet);

        // containsAll(Collection<?> c) - Subset check
        System.out.println("\n4. containsAll(Collection c) - SUBSET check");
        System.out.println("   set1.containsAll(set3): " + set1.containsAll(set3));
        System.out.println("   set1.containsAll(set2): " + set1.containsAll(set2));
        System.out.println();
    }

    static void demonstrateQueryMethods(Set<String> set) {
        System.out.println("=== QUERY METHODS ===\n");

        System.out.println("Current set: " + set);

        // contains(Object o) - Check if element exists
        System.out.println("1. contains(Object o) - Check element existence");
        System.out.println("   contains(\"Apple\"): " + set.contains("Apple"));
        System.out.println("   contains(\"Orange\"): " + set.contains("Orange"));
        System.out.println("   contains(null): " + set.contains(null));

        // size() - Get number of elements
        System.out.println("\n2. size() - Get number of elements");
        System.out.println("   size(): " + set.size());

        // isEmpty() - Check if set is empty
        System.out.println("\n3. isEmpty() - Check if set is empty");
        System.out.println("   isEmpty(): " + set.isEmpty());

        Set<String> emptySet = new HashSet<>();
        System.out.println("   emptySet.isEmpty(): " + emptySet.isEmpty());

        // equals(Object o) - Compare with another set
        System.out.println("\n4. equals(Object o) - Compare sets");
        Set<String> anotherSet = new HashSet<>(Arrays.asList("Apple", "Cherry", "Date"));
        System.out.println("   Another set: " + anotherSet);
        System.out.println("   set.equals(anotherSet): " + set.equals(anotherSet));

        // hashCode() - Get hash code
        System.out.println("\n5. hashCode() - Get hash code of set");
        System.out.println("   set.hashCode(): " + set.hashCode());
        System.out.println("   anotherSet.hashCode(): " + anotherSet.hashCode());
        System.out.println();
    }

    static void demonstrateConversionMethods(Set<String> set) {
        System.out.println("=== CONVERSION METHODS ===\n");

        System.out.println("Current set: " + set);

        // toArray() - Convert to Object array
        System.out.println("1. toArray() - Convert to Object array");
        Object[] objectArray = set.toArray();
        System.out.println("   Object array: " + Arrays.toString(objectArray));

        // toArray(T[] a) - Convert to typed array
        System.out.println("\n2. toArray(T[] a) - Convert to typed array");
        String[] stringArray = set.toArray(new String[0]);
        System.out.println("   String array: " + Arrays.toString(stringArray));

        // Pre-sized array
        String[] preSizedArray = set.toArray(new String[set.size()]);
        System.out.println("   Pre-sized array: " + Arrays.toString(preSizedArray));

        // toString() - String representation
        System.out.println("\n3. toString() - String representation");
        System.out.println("   toString(): " + set.toString());
        System.out.println();
    }

    static void demonstrateIterationMethods(Set<String> set) {
        System.out.println("=== ITERATION METHODS ===\n");

        System.out.println("Current set: " + set);

        // iterator() - Get iterator
        System.out.println("\n1. iterator() - Basic iterator");
        Iterator<String> basicIterator = set.iterator();
        System.out.print("   Elements via iterator: ");
        while (basicIterator.hasNext()) {
            System.out.print(basicIterator.next() + " ");
        }
        System.out.println();

        // iterator() with removal
        System.out.println("\n2. iterator() - With safe removal");
        Set<String> copySet = new HashSet<>(set);
        Iterator<String> removeIterator = copySet.iterator();
        System.out.println("   Before removal: " + copySet);
        while (removeIterator.hasNext()) {
            String element = removeIterator.next();
            if (element.startsWith("A")) {
                removeIterator.remove();
                System.out.println("   Removed: " + element);
            }
        }
        System.out.println("   After removal: " + copySet);

        // forEach (Java 8+)
        System.out.println("\n3. forEach(Consumer) - Java 8+ method");
        System.out.print("   Elements via forEach: ");
        set.forEach(element -> System.out.print(element + " "));
        System.out.println();

        // Stream operations
        System.out.println("\n4. stream() - Stream operations");
        System.out.print("   Filtered stream (length > 5): ");
        set.stream()
                .filter(s -> s.length() > 5)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();

        // Parallel stream
        System.out.println("\n5. parallelStream() - Parallel processing");
        System.out.print("   Parallel stream processing: ");
        set.parallelStream()
                .map(String::toUpperCase)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
    }
}
