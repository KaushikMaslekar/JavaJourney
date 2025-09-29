/*
 * Java Exception Handling - Part 3: Multiple Catch Blocks
 * 
 * When a try block can throw different types of exceptions,
 * you can use multiple catch blocks to handle each type differently.
 * 
 * Important Rules:
 * 1. More specific exceptions must be caught before general ones
 * 2. Only one catch block executes per exception
 * 3. Child class exceptions must come before parent class exceptions
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultipleCatchBlocks {
    
    public static void main(String[] args) {
        System.out.println("=== Multiple Catch Blocks Demo ===\n");
        
        // 1. Basic multiple catch blocks
        basicMultipleCatch();
        System.out.println();
        
        // 2. Order matters - specific to general
        demonstrateCatchOrder();
        System.out.println();
        
        // 3. Multi-catch syntax (Java 7+)
        multiCatchSyntax();
        System.out.println();
        
        // 4. Real-world example - Calculator
        calculatorExample();
        System.out.println();
        
        // 5. Array processing with multiple exceptions
        arrayProcessingExample();
    }
    
    /**
     * Basic example with multiple catch blocks
     */
    public static void basicMultipleCatch() {
        System.out.println("--- Basic Multiple Catch Example ---");
        
        String[] data = {"10", "0", "abc", null};
        
        for (int i = 0; i < data.length; i++) {
            try {
                System.out.println("\nProcessing data[" + i + "] = " + data[i]);
                
                // This can throw multiple types of exceptions
                int number = Integer.parseInt(data[i]);  // NumberFormatException or NullPointerException
                int result = 100 / number;               // ArithmeticException
                
                System.out.println("Result: 100 / " + number + " = " + result);
                
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid number format - '" + data[i] + "' is not a valid integer");
                
            } catch (ArithmeticException e) {
                System.out.println("ERROR: Cannot divide by zero");
                
            } catch (NullPointerException e) {
                System.out.println("ERROR: Null value encountered");
                
            } catch (Exception e) {
                // General catch block for any other exceptions
                System.out.println("ERROR: Unexpected exception - " + e.getClass().getSimpleName());
            }
        }
    }
    
    /**
     * Demonstrates the importance of catch block order
     */
    public static void demonstrateCatchOrder() {
        System.out.println("--- Catch Block Order Demo ---");
        
        // CORRECT ORDER: Specific to General
        try {
            String str = "not-a-number";
            int number = Integer.parseInt(str);
            
        } catch (NumberFormatException e) {        // Specific exception first
            System.out.println("Caught NumberFormatException: " + e.getMessage());
            
        } catch (RuntimeException e) {             // Parent class second
            System.out.println("Caught RuntimeException: " + e.getMessage());
            
        } catch (Exception e) {                    // Most general last
            System.out.println("Caught Exception: " + e.getMessage());
        }
        
        // INCORRECT ORDER (would cause compilation error):
        /*
        try {
            String str = "not-a-number";
            int number = Integer.parseInt(str);
        } catch (Exception e) {                    // General exception first - WRONG!
            System.out.println("Caught Exception");
        } catch (NumberFormatException e) {        // Specific exception after general - UNREACHABLE!
            System.out.println("This would never execute");
        }
        */
        
        System.out.println("Correct order: NumberFormatException → RuntimeException → Exception");
    }
    
    /**
     * Multi-catch syntax introduced in Java 7
     */
    public static void multiCatchSyntax() {
        System.out.println("--- Multi-Catch Syntax (Java 7+) ---");
        
        String[] testData = {"abc", null};
        
        for (String data : testData) {
            try {
                System.out.println("\nTesting with: " + data);
                int length = data.length();           // NullPointerException
                int number = Integer.parseInt(data);  // NumberFormatException
                
            } catch (NullPointerException | NumberFormatException e) {
                // Multi-catch: Handle multiple exception types the same way
                System.out.println("Input Error (" + e.getClass().getSimpleName() + "): " + 
                                 (e.getMessage() != null ? e.getMessage() : "null input"));
                
            } catch (Exception e) {
                System.out.println("Other error: " + e.getClass().getSimpleName());
            }
        }
        
        // Note: In multi-catch, the exception parameter is implicitly final
        // You cannot assign a new value to 'e' in the catch block
    }
    
    /**
     * Real-world example: Calculator with comprehensive error handling
     */
    public static void calculatorExample() {
        System.out.println("--- Calculator with Exception Handling ---");
        
        // Simulating calculator operations
        String[][] operations = {
            {"10", "+", "5"},
            {"15", "/", "3"},
            {"20", "/", "0"},      // Division by zero
            {"abc", "+", "5"},     // Invalid number
            {"10", "+", null},     // Null value
            {"10", "%", "3"}       // Unsupported operation
        };
        
        for (String[] operation : operations) {
            try {
                System.out.println("\nCalculating: " + operation[0] + " " + operation[1] + " " + operation[2]);
                
                double num1 = Double.parseDouble(operation[0]);  // NumberFormatException
                double num2 = Double.parseDouble(operation[2]);  // NumberFormatException or NullPointerException
                String operator = operation[1];
                
                double result = performOperation(num1, operator, num2);  // Custom exceptions
                System.out.println("Result: " + result);
                
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid number in expression");
                
            } catch (NullPointerException e) {
                System.out.println("ERROR: Missing operand in expression");
                
            } catch (ArithmeticException e) {
                System.out.println("ERROR: " + e.getMessage());
                
            } catch (UnsupportedOperationException e) {
                System.out.println("ERROR: " + e.getMessage());
                
            } catch (Exception e) {
                System.out.println("ERROR: Unexpected error - " + e.getMessage());
            }
        }
    }
    
    /**
     * Helper method for calculator
     */
    private static double performOperation(double num1, String operator, double num2) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                return num1 / num2;
            default:
                throw new UnsupportedOperationException("Operator '" + operator + "' is not supported");
        }
    }
    
    /**
     * Array processing with multiple potential exceptions
     */
    public static void arrayProcessingExample() {
        System.out.println("--- Array Processing with Multiple Exceptions ---");
        
        try {
            // Create and process an array
            int[] numbers = createNumberArray();          // Could throw various exceptions
            processArray(numbers);                        // Could throw various exceptions
            
        } catch (NegativeArraySizeException e) {
            System.out.println("Array Error: Cannot create array with negative size");
            
        } catch (OutOfMemoryError e) {
            System.out.println("Memory Error: Not enough memory to create array");
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index Error: " + e.getMessage());
            
        } catch (ArithmeticException e) {
            System.out.println("Math Error: " + e.getMessage());
            
        } catch (Exception e) {
            System.out.println("General Error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
    
    private static int[] createNumberArray() {
        // Simulating array creation that might fail
        int size = 5;  // In real scenario, this might come from user input
        return new int[size];  // Could throw NegativeArraySizeException or OutOfMemoryError
    }
    
    private static void processArray(int[] array) {
        // Simulate processing that might throw exceptions
        array[0] = 10;
        array[1] = 0;
        array[2] = array[0] / array[1];  // ArithmeticException: division by zero
        // array[10] = 5;                // ArrayIndexOutOfBoundsException
    }
}

/*
 * Key Points about Multiple Catch Blocks:
 * 
 * 1. CATCH BLOCK ORDER (CRITICAL):
 *    - More specific exceptions MUST come before general ones
 *    - Child class exceptions MUST come before parent class exceptions
 *    - Compilation error occurs if order is wrong
 * 
 * 2. EXECUTION RULES:
 *    - Only ONE catch block executes per exception
 *    - First matching catch block executes (based on exception hierarchy)
 *    - Once a catch block executes, control goes to code after try-catch
 * 
 * 3. MULTI-CATCH SYNTAX (Java 7+):
 *    - Use pipe (|) to catch multiple exception types in one block
 *    - Exception parameter is implicitly final
 *    - Useful when you want to handle different exceptions the same way
 * 
 * 4. BEST PRACTICES:
 *    - Always catch specific exceptions first, general ones last
 *    - Provide specific error messages for different exception types
 *    - Use multi-catch for exceptions that require same handling
 *    - Always include a general Exception catch as the last option
 * 
 * 5. HIERARCHY EXAMPLE:
 *    NumberFormatException extends IllegalArgumentException
 *    IllegalArgumentException extends RuntimeException
 *    RuntimeException extends Exception
 *    Exception extends Throwable
 *    
 *    Correct order: NumberFormatException → IllegalArgumentException → RuntimeException → Exception
 */