
import java.util.*;

public class LinkedListVsArrayList {

    public static void main(String[] args) {
        System.out.println("===Performance comparison: ArrayList vs LinkedList===");

        final int size = 10000;

        //Adding elements at the beginning
        testBeginningInsertion(size);

        //Adding elements at the end
        testEndInsertion(size);

        //Random Access
        testRandomAccess(size);

        //Sequential Access
        testSequentialAccess(size);

        //Memory Usage
        testMemoryUsage();

        //summary and recommendation
        printRecommendation();

    }

    static void testBeginningInsertion(int size) {
        System.out.println("1. Insertion at Beginning (" + size + " elements)");

        //LinkedList Test 
        LinkedList<Integer> linkedList = new LinkedList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            linkedList.addFirst(i);
        }
        long LinkedTime = System.currentTimeMillis() - startTime;

        //ArrayList Test
        ArrayList<Integer> arrayList = new ArrayList<>();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arrayList.add(0, i);
        }
        long ArrayTime = System.currentTimeMillis() - startTime;

        System.out.println("linkedList time: " + LinkedTime + " ms");
        System.out.println("arrayList time " + ArrayTime + " ms");

        System.out.println(" LinkedList is " + (LinkedTime < ArrayTime ? "faster" : "Slower"));
        System.out.println("Ratio: " + String.format("%.2f", (double) Math.max(LinkedTime, ArrayTime) / Math.min(LinkedTime, ArrayTime)));
        System.out.println();

    }

    static void testEndInsertion(int size) {
        System.out.println("2. Insertion at End (" + size + " elements)");

        //LinkedList test
        LinkedList<Integer> linkedList = new LinkedList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            linkedList.addLast(i);
        }
        long LinkedListTime = System.currentTimeMillis() - startTime;

        //ArrayList test
        ArrayList<Integer> arrayList = new ArrayList<>();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }

        long ArrayListTime = System.currentTimeMillis() - startTime;

        System.out.println("LinkedList time: " + LinkedListTime + " ms");
        System.out.println("ArrayList time: " + ArrayListTime + " ms");
        System.out.println(" LinkedList is " + (LinkedListTime < ArrayListTime ? "faster" : "Slower"));
        System.out.println("Ratio: " + String.format("%.2f", (double) Math.max(LinkedListTime, ArrayListTime) / Math.min(LinkedListTime, ArrayListTime)));

        System.out.println();
    }

    static void testRandomAccess(int size) {
        System.out.println("3. Random Access (" + (size / 10) + " elements)");

        //LinkedList Test
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            linkedList.add(i);
            arrayList.add(i);
        }

        Random random = new Random(42);
        //LinkedList Test
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size / 10; i++) {
            linkedList.get(random.nextInt(size)); // Random access // random.nextInt is used to get a random index
        }
        long LinkedListTime = System.currentTimeMillis() - startTime;

        //ArrayList Test
        startTime = System.currentTimeMillis();
        for (int i = 0; i < size / 10; i++) {
            arrayList.get(random.nextInt(size)); // Random access
        }
        long ArrayListTime = System.currentTimeMillis() - startTime;

        System.out.println("LinkedList time: " + LinkedListTime + " ms");
        System.out.println("ArrayList time : " + ArrayListTime + " ms");
        System.out.println(" LinkedList is " + (LinkedListTime < ArrayListTime ? "faster" : "Slower"));
        System.out.println("Ratio: " + String.format("%.2f", (double) Math.max(LinkedListTime, ArrayListTime) / Math.min(LinkedListTime, ArrayListTime)));
        System.out.println();

    }

    static void testSequentialAccess(int size) {
        System.out.println("4. Sequential Access (" + size + " elements)");

        //Prepare the lists
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        //LinkedList Test with Iterator
        long startTime = System.currentTimeMillis();
        long sum = 0;
        for (Integer num : linkedList) {
            sum += num; // sum is equal to the sum plus the current number
        }
        long LinkedListIteratorTime = System.currentTimeMillis() - startTime;

        //Linkedlist test with index
        startTime = System.currentTimeMillis();
        long sum2 = 0;
        for (int i = 0; i < linkedList.size(); i++) {
            sum2 += linkedList.get(i);
        }
        long LinkedListIndexTime = System.currentTimeMillis() - startTime;

        //ArrayList Test with Iterator
        startTime = System.currentTimeMillis();
        long sum3 = 0;
        for (Integer num : arrayList) {
            sum3 += num; // sum is equal to the sum plus the current number
        }
        long ArrayListIteratorTime = System.currentTimeMillis() - startTime;

        //ArrayList test with index
        startTime = System.currentTimeMillis();
        long sum4 = 0;
        for (int i = 0; i < ArrayListIteratorTime; i++) {
            sum4 += arrayList.get(i);
        }
        long ArrayListIndexTime = System.currentTimeMillis() - startTime;

        System.out.println("LinkedList Iterator time: " + LinkedListIteratorTime + " ms");
        System.out.println("LinkedList Index time: " + LinkedListIndexTime + " ms");
        System.out.println("ArrayList Iterator time; " + ArrayListIteratorTime + " ms");
        System.out.println("ArrayList Index time: " + ArrayListIndexTime + " ms");
        System.out.println(" LinkedList Iterator is " + (LinkedListIteratorTime < ArrayListIteratorTime ? "faster" : "Slower"));
        System.out.println(" LinkedList Index is " + (LinkedListIndexTime < ArrayListIndexTime ? "faster" : "Slower"));
        System.out.println("Ratio (Iterator): " + String.format("%.2f", (double) Math.max(LinkedListIteratorTime, ArrayListIteratorTime) / Math.min(LinkedListIteratorTime, ArrayListIteratorTime)));
        System.out.println("Ratio (Index): " + String.format("%.2f", (double) Math.max(LinkedListIndexTime, ArrayListIndexTime) / Math.min(LinkedListIndexTime, ArrayListIndexTime)));
        System.out.println();

    }

    static void testMemoryUsage() {
        System.out.println("5. MEMORY USAGE COMPARISON");

        final int elements = 1000;

        // Create lists
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < elements; i++) {
            linkedList.add(i);
            arrayList.add(i);
        }

        System.out.println("Elements stored: " + elements);
        System.out.println("ArrayList: Stores only data + some extra capacity");
        System.out.println("LinkedList: Stores data + 2 pointers per node (next, prev)");
        System.out.println("Memory overhead: LinkedList uses ~3x more memory per element");
        System.out.println("ArrayList also has better cache locality (better performance)\n");

    }

    static void printRecommendation() {
        System.out.println("=== RECOMMENDATIONS ===");
        System.out.println();
        System.out.println("Use LinkedList when:");
        System.out.println("Frequent insertions/deletions at beginning or middle");
        System.out.println("You need queue/deque functionality");
        System.out.println("You don't need random access");
        System.out.println("Memory usage is not a primary concern");
        System.out.println();
        System.out.println("Use ArrayList when:");
        System.out.println("You need fast random access (get/set operations)");
        System.out.println("Memory efficiency is important");
        System.out.println("Most additions are at the end");
        System.out.println("You're iterating through the list frequently");
        System.out.println();
        System.out.println("General rule: ArrayList is usually the better choice for most scenarios");
        System.out.println("LinkedList shines in specific use cases involving frequent list manipulation");
    }

}
