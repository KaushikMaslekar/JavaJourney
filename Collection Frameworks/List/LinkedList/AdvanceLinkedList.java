
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class AdvanceLinkedList {

    public static void main(String[] args) {

        //performance demonstration of LinkedList
        System.out.println("Performance Characteristics");
        PerformanceDemo();

        //Iterator usage with linked list
        System.out.println("\nIterator Usage");
        IteratorUsage();

        //Bulk Operations
        System.out.println("\nBulk Operations");
        BulkOperations();

    }

    static void PerformanceDemo() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        // Adding elements at beginning - LinkedList wins
        System.out.println("Adding 1000 elements at beginning:");

        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.addFirst(i);
        }
        long linkedTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(0, i);  // Insert at beginning
        }
        long arrayTime = System.nanoTime() - startTime;

        System.out.println("LinkedList time: " + linkedTime + " ns");
        System.out.println("ArrayList time: " + arrayTime + " ns");
        System.out.println("LinkedList is " + (arrayTime / linkedTime) + "x faster for front insertion");

        // Random access - ArrayList wins
        System.out.println("\nRandom access (get operations):");

        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            linkedList.get(i * 10 % linkedList.size());
        }
        linkedTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            arrayList.get(i * 10 % arrayList.size());
        }
        arrayTime = System.nanoTime() - startTime;

        System.out.println("LinkedList time: " + linkedTime + " ns");
        System.out.println("ArrayList time: " + arrayTime + " ns");
        System.out.println("ArrayList is " + (linkedTime / arrayTime) + "x faster for random access");
    }

    static void IteratorUsage() {
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        System.out.println("Original LinkedList: " + linkedList);

        //ListIterator - bidirectional iteration 
        System.out.println("Using ListIterator:");
        ListIterator<String> listIterator = linkedList.listIterator();
        System.out.print("Forward iteration: ");
        while (listIterator.hasNext()) {
            String element = listIterator.next();
            System.out.println("\n" + element + " ");

            System.out.println();
            //add element after current position
            if (element.equals("B")) {
                listIterator.add("B2"); // Adding B2 after B
            }

            //remove element after current position
            if (element.equals("D")) {
                listIterator.remove(); // Removing D
            }
        }
        System.out.println("\nList after forward iteration: " + linkedList);
        System.out.println("");
        System.out.print("Backward iteration: ");
        while (listIterator.hasPrevious()) {
            String element = listIterator.previous();
            System.out.println("\n" + element + " ");
        }
        System.out.println("");

        // Descending iterator
        System.out.println("Descending iterator:");
        Iterator<String> descIter = linkedList.descendingIterator();
        while (descIter.hasNext()) {
            System.out.print(descIter.next() + " ");
        }
        System.out.println();
    }

    static void BulkOperations() {
        LinkedList<Integer> list1 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        LinkedList<Integer> list2 = new LinkedList<>(Arrays.asList(6, 7, 8));
        LinkedList<Integer> list3 = new LinkedList<>(Arrays.asList(2, 4, 6));

        System.out.println("List1: " + list1);
        System.out.println("List2: " + list2);
        System.out.println("List3: " + list3);

        // Add all elements from list2 to list1
        list1.addAll(list2);
        System.out.println("After addAll(list2): " + list1);

        // Add all at specific index
        list1.addAll(3, Arrays.asList(10, 11, 12));
        System.out.println("After addAll at index 3: " + list1);

        // Remove all elements that exist in list3
        list1.removeAll(list3);
        System.out.println("After removeAll(list3): " + list1);

        // Retain only elements that exist in another collection
        LinkedList<Integer> retainList = new LinkedList<>(Arrays.asList(1, 3, 5, 7, 8, 9));
        list1.retainAll(retainList);
        System.out.println("After retainAll: " + list1);

        // Check if contains all
        boolean containsAll = list1.containsAll(Arrays.asList(1, 3, 5));
        System.out.println("Contains 1, 3, 5? " + containsAll);
    }
}
