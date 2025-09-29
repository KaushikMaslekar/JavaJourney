/*
 * Java Exception Handling - Part 2: Try-Catch Fundamentals
 * 
 * The try-catch block is the fundamental mechanism for handling exceptions in Java.
 * 
 * Syntax:
 * try {
 *     // Code that might throw an exception
 * } catch (ExceptionType e) {
 *     // Code to handle the exception
 * }
 */

import java.util.Scanner;

public class TryCatchFundamentals {
    
    public static void main(String[] args) {
        System.out.println("=== Try-Catch Fundamentals Demo ===\n");
        
        // 1. Basic try-catch example
        basicTryCatch();
        System.out.println();
        
        // 2. Multiple operations in try block
        multipleTryOperations();
        System.out.println();
        
        // 3. Different ways to handle exceptions
        differentHandlingMethods();
        System.out.println();
        
        // 4. Interactive example
        interactiveExample();
        System.out.println();
        
        // 5. Nested try-catch
        nestedTryCatch();
    }
    
    /**
     * Basic try-catch example with detailed explanation
     */
    public static void basicTryCatch() {
        System.out.println("--- Basic Try-Catch Example ---");
        
        // Without exception handling (would crash the program)
        System.out.println("1. Without exception handling:");
        // int result = 10 / 0;  // This would terminate the program
        
        // With exception handling
        System.out.println("2. With exception handling:");
        try {
            int numerator = 10;
            int denominator = 0;
            int result = numerator / denominator;  // This will throw ArithmeticException
            System.out.println("Result: " + result);  // This line won't execute
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: Cannot divide by zero!");
            System.out.println("Exception message: " + e.getMessage());
        }
        
        System.out.println("Program continues after exception handling...");
    }
    
    /**
     * Demonstrates multiple operations in try block
     */
    public static void multipleTryOperations() {
        System.out.println("--- Multiple Operations in Try Block ---");
        
        try {
            // Multiple operations that could throw exceptions
            System.out.println("Step 1: Creating array");
            int[] numbers = {1, 2, 3, 4, 5};
            
            System.out.println("Step 2: Accessing valid index");
            System.out.println("numbers[2] = " + numbers[2]);
            
            System.out.println("Step 3: Performing division");
            int result = numbers[0] / numbers[1];
            System.out.println("Division result: " + result);
            
            System.out.println("Step 4: Accessing invalid index");
            System.out.println("numbers[10] = " + numbers[10]);  // This will throw exception
            
            System.out.println("This line won't execute due to exception");
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index error: " + e.getMessage());
            System.out.println("Only steps 1-3 completed successfully");
        }
    }
    
    /**
     * Different ways to handle exceptions
     */
    public static void differentHandlingMethods() {
        System.out.println("--- Different Exception Handling Methods ---");
        
        // Method 1: Simple error message
        try {
            String str = null;
            int length = str.length();
        } catch (NullPointerException e) {
            System.out.println("1. Simple handling: Null string encountered");
        }
        
        // Method 2: Detailed error information
        try {
            Integer.parseInt("not-a-number");
        } catch (NumberFormatException e) {
            System.out.println("2. Detailed handling:");
            System.out.println("   Error: " + e.getClass().getSimpleName());
            System.out.println("   Message: " + e.getMessage());
            System.out.println("   Cause: Invalid number format");
        }
        
        // Method 3: Logging and recovery
        try {
            int[] array = new int[3];
            array[5] = 100;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("3. Logging and recovery:");
            System.out.println("   Logged: Array access violation at index 5");
            System.out.println("   Recovery: Using default value instead");
            int defaultValue = 0;
            System.out.println("   Default value used: " + defaultValue);
        }
    }
    
    /**
     * Interactive example with user input
     */
    public static void interactiveExample() {
        System.out.println("--- Interactive Exception Handling ---");
        Scanner scanner = new Scanner(System.in);
        
        // Division calculator with exception handling
        try {
            System.out.print("Enter first number: ");
            int num1 = 10; // Using fixed values for demo, scanner.nextInt();
            
            System.out.print("Enter second number: ");
            int num2 = 0;  // Using 0 to demonstrate exception, scanner.nextInt();
            
            System.out.println("Calculating " + num1 + " / " + num2 + "...");
            int result = num1 / num2;
            System.out.println("Result: " + result);
            
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed!");
            System.out.println("Please enter a non-zero second number");
        }
        // Note: Scanner is not closed here for demo purposes
        // In real applications, use try-with-resources or close in finally block
    }
    
    /**
     * Demonstrates nested try-catch blocks
     */
    public static void nestedTryCatch() {
        System.out.println("--- Nested Try-Catch Example ---");
        
        try {
            System.out.println("Outer try block started");
            
            // First operation
            int[] numbers = {1, 2, 3};
            System.out.println("Array created: " + numbers.length + " elements");
            
            try {
                System.out.println("Inner try block started");
                
                // This will throw an exception
                int value = numbers[5];  // Index out of bounds
                System.out.println("Value: " + value);
                
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inner catch: Array index error - " + e.getMessage());
                
                // Another operation that might throw exception
                int result = 10 / 0;  // This will throw ArithmeticException
            }
            
            System.out.println("Outer try block continuing...");
            
        } catch (ArithmeticException e) {
            System.out.println("Outer catch: Arithmetic error - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Outer catch: General error - " + e.getClass().getSimpleName());
        }
        
        System.out.println("Method completed");
    }
}

/*
 * Key Points about Try-Catch:
 * 
 * 1. EXECUTION FLOW:
 *    - If no exception occurs: try block executes completely, catch block is skipped
 *    - If exception occurs: execution jumps to appropriate catch block immediately
 *    - Code after the exception line in try block won't execute
 * 
 * 2. CATCH BLOCK RULES:
 *    - Must specify the exception type to catch
 *    - Can access exception object for information (message, stack trace, etc.)
 *    - Only one catch block executes per exception
 * 
 * 3. BEST PRACTICES:
 *    - Catch specific exceptions rather than general Exception
 *    - Provide meaningful error messages
 *    - Don't ignore exceptions (empty catch blocks)
 *    - Log exceptions for debugging
 * 
 * 4. COMMON METHODS:
 *    - e.getMessage(): Returns exception message
 *    - e.printStackTrace(): Prints stack trace
 *    - e.getClass(): Returns exception class
 *    - e.toString(): Returns string representation
 */