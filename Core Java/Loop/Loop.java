
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Loop {

    public static void printNumbers(int n) {
        System.out.println("\n=== Print Numbers 1 to " + n + " ===");
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // 2. Print even numbers
    public static void printEvenNumbers(int limit) {
        System.out.println("\n=== Even Numbers up to " + limit + " ===");
        for (int i = 2; i <= limit; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // 3. Multiplication table
    public static void printTable(int num) {
        System.out.println("\n=== Multiplication Table of " + num + " ===");
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " × " + i + " = " + (num * i));
        }
    }

    // 4. Sum of first N natural numbers
    public static void sumOfNumbers(int n) {
        System.out.println("\n=== Sum of First " + n + " Natural Numbers ===");
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("Sum = " + sum);
        System.out.println("Formula verification: " + (n * (n + 1) / 2));
    }

    // 5. Factorial calculation
    public static void calculateFactorial(int n) {
        System.out.println("\n=== Factorial of " + n + " ===");
        long factorial = 1;
        System.out.print(n + "! = ");
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            System.out.print(i);
            if (i < n) {
                System.out.print(" × ");
            }
        }
        System.out.println(" = " + factorial);
    }

    // 6. Reverse a number
    public static void reverseNumber(int num) {
        System.out.println("\n=== Reverse Number ===");
        System.out.println("Original number: " + num);
        int original = num;
        int reversed = 0;

        while (num > 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        System.out.println("Reversed number: " + reversed);
    }

    // 7. Count digits
    public static void countDigits(int num) {
        System.out.println("\n=== Count Digits ===");
        System.out.println("Number: " + num);
        int count = 0;
        int temp = Math.abs(num); // Handle negative numbers

        if (temp == 0) {
            count = 1;
        } else {
            while (temp > 0) {
                temp /= 10;
                count++;
            }
        }
        System.out.println("Number of digits: " + count);
    }

    // 8. Sum of digits
    public static void sumOfDigits(int num) {
        System.out.println("\n=== Sum of Digits ===");
        System.out.println("Number: " + num);
        int sum = 0;
        int temp = Math.abs(num);

        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        System.out.println("Sum of digits: " + sum);
    }

    // 9. Check palindrome
    public static void checkPalindrome(int num) {
        System.out.println("\n=== Palindrome Check ===");
        System.out.println("Number: " + num);
        int original = num;
        int reversed = 0;

        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }

        if (original == reversed) {
            System.out.println(original + " is a palindrome");
        } else {
            System.out.println(original + " is not a palindrome");
        }
    }

    // 10. Number guessing game
    public static void numberGuessingGame() {
        System.out.println("\n=== Number Guessing Game ===");
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1;
        int guess;
        int attempts = 0;

        System.out.println("I'm thinking of a number between 1 and 100!");

        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > targetNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed it in " + attempts + " attempts!");
            }
        } while (guess != targetNumber);
    }

    // 11. Fibonacci series
    public static void fibonacciSeries(int n) {
        System.out.println("\n=== Fibonacci Series (First " + n + " terms) ===");
        int first = 0, second = 1;

        if (n >= 1) {
            System.out.print(first + " ");
        }
        if (n >= 2) {
            System.out.print(second + " ");
        }

        for (int i = 3; i <= n; i++) {
            int next = first + second;
            System.out.print(next + " ");
            first = second;
            second = next;
        }
        System.out.println();
    }

    // 12. Prime number checker and generator
    public static void primeOperations(int limit) {
        System.out.println("\n=== Prime Numbers up to " + limit + " ===");

        for (int num = 2; num <= limit; num++) {
            boolean isPrime = true;

            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    // 13. Armstrong number checker
    public static void checkArmstrong(int num) {
        System.out.println("\n=== Armstrong Number Check ===");
        System.out.println("Number: " + num);

        int original = num;
        int digits = 0;
        int temp = num;

        // Count digits
        while (temp > 0) {
            digits++;
            temp /= 10;
        }

        // Calculate sum of powers
        temp = num;
        int sum = 0;
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp /= 10;
        }

        if (sum == original) {
            System.out.println(original + " is an Armstrong number");
        } else {
            System.out.println(original + " is not an Armstrong number");
        }
    }

    // 14. Perfect number checker
    public static void checkPerfectNumber(int num) {
        System.out.println("\n=== Perfect Number Check ===");
        System.out.println("Number: " + num);

        int sum = 0;
        System.out.print("Factors: ");

        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
                System.out.print(i + " ");
            }
        }

        System.out.println("\nSum of factors: " + sum);
        if (sum == num) {
            System.out.println(num + " is a perfect number");
        } else {
            System.out.println(num + " is not a perfect number");
        }
    }

    // 15. Pattern printing
    public static void printPatterns() {
        System.out.println("\n=== Pattern Printing ===");

        // Pattern 1: Right triangle
        System.out.println("Pattern 1 - Right Triangle:");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Pattern 2: Inverted triangle
        System.out.println("\nPattern 2 - Inverted Triangle:");
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Pattern 3: Pyramid
        System.out.println("\nPattern 3 - Pyramid:");
        for (int i = 1; i <= 5; i++) {
            // Print spaces
            for (int j = 1; j <= 5 - i; j++) {
                System.out.print(" ");
            }
            // Print stars
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Pattern 4: Diamond
        System.out.println("\nPattern 4 - Diamond:");
        // Upper half
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // Lower half
        for (int i = 4; i >= 1; i--) {
            for (int j = 1; j <= 5 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 16. Matrix operations
    public static void matrixOperations() {
        System.out.println("\n=== Matrix Operations ===");

        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        int rows = 3, cols = 3;

        System.out.println("Matrix 1:");
        printMatrix(matrix1);

        System.out.println("Matrix 2:");
        printMatrix(matrix2);

        // Addition
        System.out.println("Matrix Addition:");
        int[][] sum = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        printMatrix(sum);

        // Multiplication
        System.out.println("Matrix Multiplication:");
        int[][] product = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < cols; k++) {
                    product[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        printMatrix(product);

        // Transpose
        System.out.println("Transpose of Matrix 1:");
        int[][] transpose = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix1[i][j];
            }
        }
        printMatrix(transpose);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    // 17. Advanced array operations
    public static void advancedArrayOperations() {
        System.out.println("\n=== Advanced Array Operations ===");

        int[] arr = {64, 34, 25, 12, 22, 11, 90, 88, 76, 50, 42};
        System.out.println("Original Array: " + Arrays.toString(arr));

        // Bubble Sort
        int[] bubbleSort = arr.clone();
        System.out.println("\nBubble Sort Process:");
        for (int i = 0; i < bubbleSort.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < bubbleSort.length - 1 - i; j++) {
                if (bubbleSort[j] > bubbleSort[j + 1]) {
                    // Swap
                    int temp = bubbleSort[j];
                    bubbleSort[j] = bubbleSort[j + 1];
                    bubbleSort[j + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println("After pass " + (i + 1) + ": " + Arrays.toString(bubbleSort));
            if (!swapped) {
                break;
            }
        }

        // Linear Search
        int target = 25;
        System.out.println("\nLinear Search for " + target + ":");
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Checking index " + i + ": " + arr[i]);
            if (arr[i] == target) {
                System.out.println("Found " + target + " at index " + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(target + " not found in array");
        }

        // Binary Search (on sorted array)
        Arrays.sort(bubbleSort);
        System.out.println("\nBinary Search for " + target + " in sorted array:");
        System.out.println("Sorted array: " + Arrays.toString(bubbleSort));

        int left = 0, right = bubbleSort.length - 1;
        found = false;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println("Checking middle element at index " + mid + ": " + bubbleSort[mid]);

            if (bubbleSort[mid] == target) {
                System.out.println("Found " + target + " at index " + mid);
                found = true;
                break;
            } else if (bubbleSort[mid] < target) {
                left = mid + 1;
                System.out.println("Target is greater, searching right half");
            } else {
                right = mid - 1;
                System.out.println("Target is smaller, searching left half");
            }
        }
        if (!found) {
            System.out.println(target + " not found in array");
        }
    }

    // 18. String processing with loops
    public static void stringProcessing() {
        System.out.println("\n=== String Processing with Loops ===");

        String text = "Hello World! This is Java Programming.";
        System.out.println("Original text: " + text);

        // Character frequency count
        System.out.println("\nCharacter Frequency Count:");
        int[] charCount = new int[256]; // ASCII characters

        for (int i = 0; i < text.length(); i++) {
            charCount[text.charAt(i)]++;
        }

        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] > 0) {
                System.out.println("'" + (char) i + "': " + charCount[i]);
            }
        }

        // Word count
        System.out.println("\nWord Analysis:");
        String[] words = text.toLowerCase().replaceAll("[^a-zA-Z\\s]", "").split("\\s+");
        System.out.println("Total words: " + words.length);

        // Find longest word
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        System.out.println("Longest word: " + longestWord + " (length: " + longestWord.length() + ")");

        // Reverse each word
        System.out.println("\nReversed words:");
        for (String word : words) {
            String reversed = "";
            for (int i = word.length() - 1; i >= 0; i--) {
                reversed += word.charAt(i);
            }
            System.out.println(word + " -> " + reversed);
        }
    }

    // 19. Complex nested loops - Pascal's triangle
    public static void pascalTriangle(int rows) {
        System.out.println("\n=== Pascal's Triangle (" + rows + " rows) ===");

        for (int i = 0; i < rows; i++) {
            // Print spaces for formatting
            for (int j = 0; j < rows - i - 1; j++) {
                System.out.print(" ");
            }

            // Calculate and print values
            int value = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(value + " ");
                value = value * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

    // 20. Menu-driven calculator with loops
    public static void advancedCalculator() {
        System.out.println("\n=== Advanced Calculator ===");
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Calculator Menu ---");
            System.out.println("1. Basic Operations (+, -, *, /)");
            System.out.println("2. Power Calculation");
            System.out.println("3. Square Root");
            System.out.println("4. Factorial");
            System.out.println("5. GCD and LCM");
            System.out.println("6. Prime Check");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    performBasicOperations(scanner);
                    break;
                case 2:
                    calculatePower(scanner);
                    break;
                case 3:
                    calculateSquareRoot(scanner);
                    break;
                case 4:
                    calculateFactorialMenu(scanner);
                    break;
                case 5:
                    calculateGcdLcm(scanner);
                    break;
                case 6:
                    checkPrimeMenu(scanner);
                    break;
                case 7:
                    exit = true;
                    System.out.println("Thank you for using the calculator!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Helper methods for calculator
    private static void performBasicOperations(Scanner scanner) {
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter operator (+, -, *, /): ");
        char op = scanner.next().charAt(0);
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        switch (op) {
            case '+':
                System.out.println("Result: " + (num1 + num2));
                break;
            case '-':
                System.out.println("Result: " + (num1 - num2));
                break;
            case '*':
                System.out.println("Result: " + (num1 * num2));
                break;
            case '/':
                if (num2 != 0) {
                    System.out.println("Result: " + (num1 / num2));
                } else {
                    System.out.println("Error: Division by zero!");
                }
                break;
            default:
                System.out.println("Invalid operator!");
        }
    }

    private static void calculatePower(Scanner scanner) {
        System.out.print("Enter base: ");
        double base = scanner.nextDouble();
        System.out.print("Enter exponent: ");
        int exp = scanner.nextInt();

        double result = 1;
        int absExp = Math.abs(exp);

        for (int i = 0; i < absExp; i++) {
            result *= base;
        }

        if (exp < 0) {
            result = 1 / result;
        }

        System.out.println(base + "^" + exp + " = " + result);
    }

    private static void calculateSquareRoot(Scanner scanner) {
        System.out.print("Enter number: ");
        double num = scanner.nextDouble();

        if (num < 0) {
            System.out.println("Square root of negative numbers is not real!");
            return;
        }

        // Newton's method for square root
        double guess = num / 2;
        double precision = 0.000001;

        while (Math.abs(guess * guess - num) > precision) {
            guess = (guess + num / guess) / 2;
        }

        System.out.println("Square root of " + num + " = " + guess);
    }

    private static void calculateFactorialMenu(Scanner scanner) {
        System.out.print("Enter number: ");
        int num = scanner.nextInt();

        if (num < 0) {
            System.out.println("Factorial is not defined for negative numbers!");
            return;
        }

        long factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }

        System.out.println(num + "! = " + factorial);
    }

    private static void calculateGcdLcm(Scanner scanner) {
        System.out.print("Enter first number: ");
        int a = scanner.nextInt();
        System.out.print("Enter second number: ");
        int b = scanner.nextInt();

        int originalA = a, originalB = b;

        // Calculate GCD using Euclidean algorithm
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        int gcd = a;

        // Calculate LCM
        int lcm = (originalA * originalB) / gcd;

        System.out.println("GCD of " + originalA + " and " + originalB + " = " + gcd);
        System.out.println("LCM of " + originalA + " and " + originalB + " = " + lcm);
    }

    private static void checkPrimeMenu(Scanner scanner) {
        System.out.print("Enter number: ");
        int num = scanner.nextInt();

        if (num <= 1) {
            System.out.println(num + " is not a prime number");
            return;
        }

        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                isPrime = false;
                System.out.println(num + " is divisible by " + i);
                break;
            }
        }

        if (isPrime) {
            System.out.println(num + " is a prime number");
        } else {
            System.out.println(num + " is not a prime number");
        }
    }

    public static void main(String[] args) {
        System.out.println("JAVA LOOP PROGRAMS: BASIC TO ADVANCED");
        System.out.println("======================================");

        // Basic For Loop Programs
        printNumbers(10);
        printEvenNumbers(20);
        printTable(7);
        sumOfNumbers(10);
        calculateFactorial(6);

        // Basic While Loop Programs
        reverseNumber(12345);
        countDigits(98765);
        sumOfDigits(12345);
        checkPalindrome(121);
        checkPalindrome(123);

        // Uncomment to play the guessing game
        // numberGuessingGame();
        // Intermediate Programs
        fibonacciSeries(10);
        primeOperations(30);
        checkArmstrong(153);
        checkArmstrong(371);
        checkArmstrong(123);
        checkPerfectNumber(28);
        checkPerfectNumber(6);
        printPatterns();

        // Advanced Programs
        matrixOperations();
        advancedArrayOperations();
        stringProcessing();
        pascalTriangle(6);

        // Uncomment to run interactive calculator
        // advancedCalculator();
        System.out.println("\n======================================");
        System.out.println("All loop programs executed successfully!");
        System.out.println("Uncomment interactive programs in main() to test them.");
    }
}
