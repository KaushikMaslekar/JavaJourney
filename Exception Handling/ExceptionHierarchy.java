/*
 * Java Exception Handling - Part 1: Exception Hierarchy
 * 
 * Understanding the Java Exception Hierarchy:
 * 
 * Throwable (Base class for all exceptions and errors)
 * ├── Error (System-level errors, not recoverable)
 * │   ├── OutOfMemoryError
 * │   ├── StackOverflowError
 * │   └── etc.
 * └── Exception (Application-level exceptions)
 *     ├── Checked Exceptions (Must be handled or declared)
 *     │   ├── IOException
 *     │   ├── SQLException  
 *     │   ├── ClassNotFoundException
 *     │   └── etc.
 *     └── RuntimeException (Unchecked Exceptions)
 *         ├── NullPointerException
 *         ├── ArithmeticException
 *         ├── ArrayIndexOutOfBoundsException
 *         └── etc.
 */

public class ExceptionHierarchy {

    public static void main(String[] args) {
        System.out.println("=== Java Exception Hierarchy Demo ===\n");

        // 1. Demonstrate different types of exceptions
        demonstrateRuntimeExceptions();
        System.out.println();

        // 2. Show exception inheritance
        demonstrateExceptionInheritance();
        System.out.println();

        // 3. Show exception information
        demonstrateExceptionInfo();
    }

    /**
     * Demonstrates common Runtime Exceptions (Unchecked) These don't need to be
     * declared in method signature
     */
    public static void demonstrateRuntimeExceptions() {
        System.out.println("--- Runtime Exceptions (Unchecked) ---");

        // 1. ArithmeticException
        try {
            int result = 10 / 0;  // Division by zero
        } catch (ArithmeticException e) {
            System.out.println("1. ArithmeticException caught: " + e.getMessage());
        }

        // 2. NullPointerException
        try {
            String str = null;
            int length = str.length();  // Calling method on null reference
        } catch (NullPointerException e) {
            System.out.println("2. NullPointerException caught: " + e.getMessage());
        }

        // 3. ArrayIndexOutOfBoundsException
        try {
            int[] array = {1, 2, 3};
            int value = array[5];  // Index out of bounds
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("3. ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        }

        // 4. NumberFormatException
        try {
            int number = Integer.parseInt("abc");  // Invalid number format
        } catch (NumberFormatException e) {
            System.out.println("4. NumberFormatException caught: " + e.getMessage());
        }
    }

    /**
     * Demonstrates exception inheritance relationships
     */
    public static void demonstrateExceptionInheritance() {
        System.out.println("--- Exception Inheritance Demo ---");

        try {
            // This will throw a NumberFormatException
            int number = Integer.parseInt("xyz");
        } catch (NumberFormatException e) {
            System.out.println("Caught as NumberFormatException: " + e.getClass().getSimpleName());
        }

        try {
            // Same exception, but caught as its parent class
            int number = Integer.parseInt("xyz");
        } catch (RuntimeException e) {  // Parent class of NumberFormatException
            System.out.println("Caught as RuntimeException: " + e.getClass().getSimpleName());
        }

        try {
            // Same exception, caught as grandparent class
            int number = Integer.parseInt("xyz");
        } catch (Exception e) {  // Grandparent class
            System.out.println("Caught as Exception: " + e.getClass().getSimpleName());
        }
    }

    /**
     * Demonstrates exception information methods
     */
    public static void demonstrateExceptionInfo() {
        System.out.println("--- Exception Information Methods ---");

        try {
            int[] array = new int[3];
            array[10] = 100;  // This will throw ArrayIndexOutOfBoundsException
        } catch (Exception e) {
            System.out.println("Exception Class: " + e.getClass().getName());
            System.out.println("Exception Message: " + e.getMessage());
            System.out.println("Exception toString(): " + e.toString());

            System.out.println("\nStack Trace:");
            e.printStackTrace();  // Prints the full stack trace
        }
    }
}

/*
 * Key Points to Remember:
 * 
 * 1. CHECKED EXCEPTIONS (Compile-time checking):
 *    - Must be handled with try-catch OR declared with 'throws'
 *    - Examples: IOException, SQLException, ClassNotFoundException
 *    - Inherit from Exception class (but not RuntimeException)
 * 
 * 2. UNCHECKED EXCEPTIONS (Runtime checking):
 *    - No compile-time checking required
 *    - Examples: NullPointerException, ArithmeticException, NumberFormatException
 *    - Inherit from RuntimeException class
 * 
 * 3. ERRORS:
 *    - System-level problems, usually not recoverable
 *    - Examples: OutOfMemoryError, StackOverflowError
 *    - Inherit from Error class
 * 
 * 4. INHERITANCE RULE:
 *    - More specific exceptions should be caught before general ones
 *    - Child class exceptions should be handled before parent class exceptions
 */
