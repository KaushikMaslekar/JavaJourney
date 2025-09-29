// ============================================
// JAVA ARRAY PROGRAMS: BASIC TO ADVANCED
// ============================================

import java.io.*;
import java.util.*;

public class array {

    // Utility method to repeat a character n times (Java 8 compatible)
    private static String repeatChar(char ch, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }

    // ============================================
    // BASIC LEVEL PROGRAMS - ARRAY BASICS
    // ============================================
    // 1. Basic array creation and traversal
    public static void basicArrayOperations() {
        System.out.println("\n=== Basic Array Operations ===");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the size of the array: ");
            int size;
            try {
                size = scanner.nextInt();
                if (size <= 0) {
                    System.out.println("Size must be positive.");
                    return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                return;
            }

            int[] array = new int[size];
            System.out.println("Enter " + size + " integers:");
            for (int i = 0; i < size; i++) {
                System.out.print("Element " + (i + 1) + ": ");
                try {
                    array[i] = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter an integer.");
                    scanner.nextLine();
                    i--;
                }
            }

            // Display array
            System.out.println("\nArray Contents:");
            System.out.println(Arrays.toString(array));

            // Basic operations
            int sum = 0;
            int max = array[0];
            int min = array[0];
            for (int num : array) {
                sum += num;
                if (num > max) {
                    max = num;
                }
                if (num < min) {
                    min = num;
                }
            }
            System.out.println("Sum: " + sum);
            System.out.println("Average: " + (double) sum / size);
            System.out.println("Maximum: " + max);
            System.out.println("Minimum: " + min);
        }
    }

    // 2. Array initialization techniques
    public static void arrayInitialization() {
        System.out.println("\n=== Array Initialization Techniques ===");
        // Static initialization
        int[] staticArray = {10, 20, 30, 40, 50};
        System.out.println("Statically initialized array: " + Arrays.toString(staticArray));

        // Dynamic initialization
        int[] dynamicArray = new int[5];
        for (int i = 0; i < dynamicArray.length; i++) {
            dynamicArray[i] = i * 10;
        }
        System.out.println("Dynamically initialized array: " + Arrays.toString(dynamicArray));

        // Array with default values
        double[] defaultArray = new double[3];
        System.out.println("Array with default values (doubles): " + Arrays.toString(defaultArray));

        // Using Arrays.fill
        int[] filledArray = new int[4];
        Arrays.fill(filledArray, 42);
        System.out.println("Array filled with 42: " + Arrays.toString(filledArray));

        // Using Arrays.copyOf
        int[] copiedArray = Arrays.copyOf(staticArray, 7);
        System.out.println("Copied and extended array: " + Arrays.toString(copiedArray));
    }

    // 3. Array input validation
    public static void arrayInputValidation() {
        System.out.println("\n=== Array Input Validation ===");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the size of the array (1-50): ");
            int size;
            try {
                size = scanner.nextInt();
                if (size < 1 || size > 50) {
                    System.out.println("Size must be between 1 and 50.");
                    return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                return;
            }

            double[] array = new double[size];
            System.out.println("Enter " + size + " positive numbers:");
            for (int i = 0; i < size; i++) {
                System.out.print("Element " + (i + 1) + ": ");
                try {
                    double value = scanner.nextDouble();
                    if (value < 0) {
                        System.out.println("Please enter a positive number.");
                        i--;
                    } else {
                        array[i] = value;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.nextLine();
                    i--;
                }
            }

            System.out.println("\nValidated Array:");
            System.out.println(Arrays.toString(array));
        }
    }

    // ============================================
    // INTERMEDIATE LEVEL PROGRAMS - ARRAY MANIPULATION
    // ============================================
    // 4. Array sorting and searching
    public static void arraySortAndSearch() {
        System.out.println("\n=== Array Sorting and Searching ===");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the size of the array: ");
            int size;
            try {
                size = scanner.nextInt();
                if (size <= 0) {
                    System.out.println("Size must be positive.");
                    return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                return;
            }

            int[] array = new int[size];
            System.out.println("Enter " + size + " integers:");
            for (int i = 0; i < size; i++) {
                System.out.print("Element " + (i + 1) + ": ");
                try {
                    array[i] = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter an integer.");
                    scanner.nextLine();
                    i--;
                }
            }

            // Sorting
            int[] sortedArray = Arrays.copyOf(array, array.length);
            Arrays.sort(sortedArray);
            System.out.println("\nOriginal Array: " + Arrays.toString(array));
            System.out.println("Sorted Array: " + Arrays.toString(sortedArray));

            // Linear search
            System.out.print("\nEnter a number to search (linear): ");
            int target;
            try {
                target = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                return;
            }
            int linearIndex = -1;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == target) {
                    linearIndex = i;
                    break;
                }
            }
            System.out.println("Linear Search: " + (linearIndex >= 0 ? "Found at index " + linearIndex : "Not found"));

            // Binary search (on sorted array)
            System.out.print("Enter a number to search (binary): ");
            try {
                target = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                return;
            }
            int binaryIndex = Arrays.binarySearch(sortedArray, target);
            System.out.println("Binary Search: " + (binaryIndex >= 0 ? "Found at index " + binaryIndex : "Not found"));
        }
    }

    // 5. Multi-dimensional array operations
    public static void multiDimensionalArrays() {
        System.out.println("\n=== Multi-Dimensional Array Operations ===");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of rows (1-10): ");
            int rows;
            try {
                rows = scanner.nextInt();
                if (rows < 1 || rows > 10) {
                    System.out.println("Rows must be between 1 and 10.");
                    return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                return;
            }

            System.out.print("Enter number of columns (1-10): ");
            int cols;
            try {
                cols = scanner.nextInt();
                if (cols < 1 || cols > 10) {
                    System.out.println("Columns must be between 1 and 10.");
                    return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                return;
            }

            int[][] matrix = new int[rows][cols];
            System.out.println("Enter matrix elements (" + rows + "x" + cols + "):");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("Element [" + i + "][" + j + "]: ");
                    try {
                        matrix[i][j] = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter an integer.");
                        scanner.nextLine();
                        j--;
                    }
                }
            }

            // Display matrix
            System.out.println("\nMatrix:");
            for (int[] row : matrix) {
                System.out.println(Arrays.toString(row));
            }

            // Matrix operations
            int sum = 0;
            for (int[] row : matrix) {
                for (int value : row) {
                    sum += value;
                }
            }
            System.out.println("\nSum of all elements: " + sum);
            System.out.println("Average: " + (double) sum / (rows * cols));

            // Transpose matrix
            int[][] transpose = new int[cols][rows];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    transpose[j][i] = matrix[i][j];
                }
            }
            System.out.println("\nTranspose Matrix:");
            for (int[] row : transpose) {
                System.out.println(Arrays.toString(row));
            }
        }
    }

    // 6. Array manipulation (reverse, rotate, remove duplicates)
    public static void arrayManipulation() {
        System.out.println("\n=== Array Manipulation ===");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the size of the array: ");
            int size;
            try {
                size = scanner.nextInt();
                if (size <= 0) {
                    System.out.println("Size must be positive.");
                    return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                return;
            }

            int[] array = new int[size];
            System.out.println("Enter " + size + " integers:");
            for (int i = 0; i < size; i++) {
                System.out.print("Element " + (i + 1) + ": ");
                try {
                    array[i] = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter an integer.");
                    scanner.nextLine();
                    i--;
                }
            }

            // Original array
            System.out.println("\nOriginal Array: " + Arrays.toString(array));

            // Reverse array
            int[] reversed = new int[size];
            for (int i = 0; i < size; i++) {
                reversed[i] = array[size - 1 - i];
            }
            System.out.println("Reversed Array: " + Arrays.toString(reversed));

            // Rotate array left by k positions
            System.out.print("Enter positions to rotate left: ");
            int k;
            try {
                k = scanner.nextInt();
                if (k < 0) {
                    System.out.println("Rotation count must be non-negative.");
                    return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                return;
            }
            k = k % size; // Normalize rotation
            int[] rotated = new int[size];
            for (int i = 0; i < size; i++) {
                rotated[i] = array[(i + k) % size];
            }
            System.out.println("Array rotated left by " + k + ": " + Arrays.toString(rotated));

            // Remove duplicates (assuming sorted array)
            Arrays.sort(array);
            System.out.println("Sorted Array: " + Arrays.toString(array));
            List<Integer> uniqueList = new ArrayList<>();
            uniqueList.add(array[0]);
            for (int i = 1; i < size; i++) {
                if (array[i] != array[i - 1]) {
                    uniqueList.add(array[i]);
                }
            }
            System.out.println("Array without duplicates: " + uniqueList);
        }
    }

    // ============================================
    // ADVANCED LEVEL PROGRAMS
    // ============================================
    // 7. ArrayList operations
    public static void arrayListOperations() {
        System.out.println("\n=== ArrayList Operations ===");
        ArrayList<String> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter names to add to the list (enter 'done' to finish):");
            while (true) {
                System.out.print("Enter name: ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("done")) {
                    break;
                }
                if (!input.isEmpty()) {
                    list.add(input);
                } else {
                    System.out.println("Name cannot be empty.");
                }
            }

            // Display ArrayList
            System.out.println("\nArrayList Contents: " + list);

            // Basic operations
            if (!list.isEmpty()) {
                System.out.println("Size: " + list.size());
                System.out.println("First element: " + list.get(0));
                System.out.println("Last element: " + list.get(list.size() - 1));

                // Sorting
                ArrayList<String> sortedList = new ArrayList<>(list);
                Collections.sort(sortedList);
                System.out.println("Sorted ArrayList: " + sortedList);

                // Search
                System.out.print("Enter a name to search: ");
                String searchName = scanner.nextLine();
                int index = list.indexOf(searchName);
                System.out.println("Search result: " + (index >= 0 ? "Found at index " + index : "Not found"));

                // Remove element
                System.out.print("Enter a name to remove: ");
                String removeName = scanner.nextLine();
                if (list.remove(removeName)) {
                    System.out.println("Removed: " + removeName);
                    System.out.println("Updated ArrayList: " + list);
                } else {
                    System.out.println(removeName + " not found in the list.");
                }
            } else {
                System.out.println("ArrayList is empty.");
            }
        }
    }

    // 8. Array serialization
    public static void arraySerialization() {
        System.out.println("\n=== Array Serialization ===");
        String fileName = "array_data.ser";
        int[] array = {1, 2, 3, 4, 5};

        // Serialize array
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(array);
            System.out.println("Array serialized to " + fileName);
            System.out.println("Serialized Array: " + Arrays.toString(array));
        } catch (IOException e) {
            System.err.println("Error serializing array: " + e.getMessage());
            return;
        }

        // Deserialize array
        File file = new File(fileName);
        if (!file.exists()) {
            System.err.println("File " + fileName + " does not exist.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            int[] deserializedArray = (int[]) ois.readObject();
            System.out.println("Deserialized Array: " + Arrays.toString(deserializedArray));
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing array: " + e.getMessage());
        }
    }

    // 9. Array-based simple data structure (Stack)
    public static void arrayBasedStack() {
        System.out.println("\n=== Array-Based Stack Operations ===");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the stack size (1-50): ");
            int size;
            try {
                size = scanner.nextInt();
                if (size < 1 || size > 50) {
                    System.out.println("Size must be between 1 and 50.");
                    return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                return;
            }

            int[] stack = new int[size];
            int top = -1; // Stack top index

            boolean exit = false;
            while (!exit) {
                System.out.println("\n--- Stack Menu ---");
                System.out.println("1. Push");
                System.out.println("2. Pop");
                System.out.println("3. Peek");
                System.out.println("4. Display Stack");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice;
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.nextLine();
                    continue;
                }

                switch (choice) {
                    case 1: // Push
                        if (top >= size - 1) {
                            System.out.println("Stack Overflow!");
                        } else {
                            System.out.print("Enter value to push: ");
                            try {
                                int value = scanner.nextInt();
                                stack[++top] = value;
                                System.out.println("Pushed: " + value);
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input! Please enter an integer.");
                                scanner.nextLine();
                            }
                        }
                        break;
                    case 2: // Pop
                        if (top < 0) {
                            System.out.println("Stack Underflow!");
                        } else {
                            System.out.println("Popped: " + stack[top--]);
                        }
                        break;
                    case 3: // Peek
                        if (top < 0) {
                            System.out.println("Stack is empty.");
                        } else {
                            System.out.println("Top element: " + stack[top]);
                        }
                        break;
                    case 4: // Display
                        if (top < 0) {
                            System.out.println("Stack is empty.");
                        } else {
                            System.out.print("Stack: ");
                            for (int i = 0; i <= top; i++) {
                                System.out.print(stack[i] + " ");
                            }
                            System.out.println();
                        }
                        break;
                    case 5: // Exit
                        exit = true;
                        System.out.println("Exiting stack operations...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        }
    }

    // ============================================
    // MAIN METHOD
    // ============================================
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;
            while (!exit) {
                System.out.println("\n=====================================");
                System.out.println("JAVA ARRAY PROGRAMS DEMO");
                System.out.println("=====================================");
                System.out.println("1. Basic Array Operations");
                System.out.println("2. Array Initialization Techniques");
                System.out.println("3. Array Input Validation");
                System.out.println("4. Array Sorting and Searching");
                System.out.println("5. Multi-Dimensional Arrays");
                System.out.println("6. Array Manipulation");
                System.out.println("7. ArrayList Operations");
                System.out.println("8. Array Serialization");
                System.out.println("9. Array-Based Stack");
                System.out.println("10. Exit");
                System.out.print("Enter your choice (1-10): ");

                int choice;
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.nextLine();
                    continue;
                }

                switch (choice) {
                    case 1:
                        basicArrayOperations();
                        break;
                    case 2:
                        arrayInitialization();
                        break;
                    case 3:
                        arrayInputValidation();
                        break;
                    case 4:
                        arraySortAndSearch();
                        break;
                    case 5:
                        multiDimensionalArrays();
                        break;
                    case 6:
                        arrayManipulation();
                        break;
                    case 7:
                        arrayListOperations();
                        break;
                    case 8:
                        arraySerialization();
                        break;
                    case 9:
                        arrayBasedStack();
                        break;
                    case 10:
                        exit = true;
                        System.out.println("Exiting program...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please select between 1-10.");
                }

                if (!exit) {
                    System.out.print("\nPress Enter to continue...");
                    scanner.nextLine();
                }
            }
        }
    }
}
