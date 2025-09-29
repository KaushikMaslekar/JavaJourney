
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedList02 {

    public static void main(String[] args) {
        // Create a LinkedList as Queue
        System.out.println("===LinkedList as Queue===" + " \n");
        Queue<String> queue = new LinkedList<>();

        //offer adds elements to the end of the queue
        queue.offer("Customer 1");
        queue.offer("Customer 2");
        queue.offer("Customer 3");
        queue.offer("Customer 4");
        queue.offer("Customer 5");
        System.out.println("Queue: " + queue);
        System.out.println();

        // Process customers in the queue
        while (!queue.isEmpty()) {
            String customer = queue.poll(); // Remove the head of the queue
            System.out.println("Processing " + customer);
            System.out.println("Queue after processing: " + queue);
        }
        System.out.println("All customers have been processed.");
        System.out.println();

        // Create a LinkedList as Deque
        System.out.println("===LinkedList as Deque===" + " \n");
        Deque<String> deque = new LinkedList<>();
        // Add elements to the deque 
        //offerFirst adds to the front, offerLast adds to the end
        deque.offerFirst("Task 1");
        deque.offerLast("Task 2");
        deque.offer("Task 3");
        deque.offerLast("Task 4");
        deque.offerLast("Task 5");
        System.out.println("Deque: " + deque);
        System.out.println();

        //remove elements from both ends of the deque
        System.out.println("Removing the first element from the deque: " + deque.pollFirst());
        System.out.println("Deque the last element from the deque: " + deque.pollLast());
        System.out.println("");
        // Stack operations using Deque
        System.out.println("===Stack Operations using Deque===" + " \n");

        Deque<String> stack = new LinkedList<>();
        Deque<String> stack1 = new LinkedList<>();
        // Push elements onto the stack
        stack.push("Stack Task 1"); // Push adds to the front
        stack.push("Stack Task 2");
        stack.push("Stack Task 3");
        stack.push("Stack Task 4");
        System.out.println("Stack after pushing tasks: " + stack);
        System.out.println("");

        //Push more elements to the stack
        stack1.push("Stack A");
        stack1.push("Stack B");
        stack1.push("Stack C");
        stack1.push("Stack D");
        System.out.println("Stack after pushing more tasks: " + stack1);
        System.out.println("");

        // Pop elements from the stack
        System.out.println("Popping elements from the stack:");
        while (!stack.isEmpty()) {
            String task = stack.pop(); // Pop removes the head of the stack
            System.out.println("Processing " + task);
            System.out.println("Stack after processing: " + stack);
        }
        System.out.println("All stack tasks have been processed.");
        System.out.println("");

        // Pop elements from the second stack
        System.out.println("Popping elements from the second stack:");
        while (!stack1.isEmpty()) {
            String task = stack1.pop(); // Pop removes the head of the stack
            System.out.println("Processing " + task);
            System.out.println("Stack after processing: " + stack1);
        }
        System.out.println("All stack tasks have been processed.");
        System.out.println("");

        // Demonstration of different add/remove methods
        System.out.println("\n=== Method Comparison ===");
        LinkedList<String> demo = new LinkedList<>();

        // Different ways to add
        demo.add("Middle");
        demo.addFirst("First");
        demo.addLast("Last");
        demo.offer("Offered");      // Same as addLast for LinkedList
        demo.push("Pushed");        // Same as addFirst

        System.out.println("After various adds: " + demo);
        System.out.println("");

        // Different ways to remove
        System.out.println("remove(): " + demo.remove());           // Same as removeFirst
        System.out.println("removeFirst(): " + demo.removeFirst());
        System.out.println("removeLast(): " + demo.removeLast());
        System.out.println("poll(): " + demo.poll());               // Same as removeFirst
        System.out.println("pop(): " + demo.pop());                 // Same as removeFirst

        System.out.println("Final demo list: " + demo);
    }
}
