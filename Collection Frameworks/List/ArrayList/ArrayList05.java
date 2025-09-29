
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class ArrayList05 {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println("original numbers: " + numbers);

        //Iteration method 
        System.out.println("===Iterating using for loop===");
        //1. Tradition for loop
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println(); //new line

        //2. Enhanced for loop
        System.out.println("===Iterating using enhanced for loop===");
        System.out.println("Enhanced for loop:");
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println(); //new line

        //3. Iterator
        System.out.print("===Iterating using Iterator===\n");
        ListIterator<Integer> iterator = numbers.listIterator();
        while (iterator.hasNext()) { //hasNext() checks if there are more elements
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        //4. ListIterator
        System.out.println("===Iterating using ListIterator in reverse order===");
        ListIterator<Integer> listIterator = numbers.listIterator(numbers.size()); // Start from the end
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
        System.out.println(); //new line

        //5. Stream and foreach
        System.out.println("===Iterating using Stream and forEach===");
        numbers.stream().forEach(num -> System.out.print(num + " "));
        System.out.println(); //new line

        //6. Sorting operation
        System.out.println("\n=== Sorting Operations ===");
        ArrayList<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        System.out.println("Sorted ascending: " + sortedNumbers);
        Collections.sort(sortedNumbers, Collections.reverseOrder());
        System.out.println("Sorted descending: " + sortedNumbers);

        //Searching operation
        System.out.println("\n=== Searching Operations ===");
        Collections.sort(numbers);
        int index = Collections.binarySearch(numbers, 5);
        System.out.println("Index of 5 in sorted list: " + index);

        //Filtering operation
        System.out.println("\n=== Filtering Operations ===");
        // Filter even numbers using streams
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);

        List<Integer> numbersGreaterThan5 = numbers.stream()
                .filter(n -> n > 5)
                .collect(Collectors.toList());
        System.out.println("Numbers > 5: " + numbersGreaterThan5);

    }
}
