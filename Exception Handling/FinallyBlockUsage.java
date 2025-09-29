/*
 * Java Exception Handling - Part 4: Finally Block
 * 
 * The finally block is used for cleanup operations that must be executed
 * regardless of whether an exception occurs or not.
 * 
 * Key Characteristics:
 * - Always executes (with very few exceptions)
 * - Used for cleanup: closing files, database connections, etc.
 * - Executes even if there's a return statement in try/catch
 * - Executes even if another exception is thrown in catch block
 */

import java.io.*;
import java.util.Scanner;

public class FinallyBlockUsage {
    
    public static void main(String[] args) {
        System.out.println("=== Finally Block Usage Demo ===\n");
        
        // 1. Basic finally block execution
        basicFinallyExample();
        System.out.println();
        
        // 2. Finally with different execution paths
        finallyExecutionPaths();
        System.out.println();
        
        // 3. Finally for resource cleanup
        resourceCleanupExample();
        System.out.println();
        
        // 4. Finally vs return statements
        finallyWithReturn();
        System.out.println();
        
        // 5. When finally doesn't execute
        whenFinallyDoesntExecute();
        System.out.println();
        
        // 6. Try-with-resources vs finally
        tryWithResourcesExample();
    }
    
    /**
     * Basic finally block execution demonstration
     */
    public static void basicFinallyExample() {
        System.out.println("--- Basic Finally Block Example ---");
        
        // Case 1: No exception occurs
        System.out.println("1. No exception scenario:");
        try {
            System.out.println("   Try block: Executing normal code");
            int result = 10 / 2;
            System.out.println("   Try block: Result = " + result);
        } catch (ArithmeticException e) {
            System.out.println("   Catch block: This won't execute");
        } finally {
            System.out.println("   Finally block: Always executes - cleanup code here");
        }
        
        System.out.println();
        
        // Case 2: Exception occurs
        System.out.println("2. Exception scenario:");
        try {
            System.out.println("   Try block: Starting division");
            int result = 10 / 0;  // This will throw ArithmeticException
            System.out.println("   Try block: This line won't execute");
        } catch (ArithmeticException e) {
            System.out.println("   Catch block: Handled ArithmeticException");
        } finally {
            System.out.println("   Finally block: Still executes for cleanup");
        }
    }
    
    /**
     * Demonstrates finally execution with different code paths
     */
    public static void finallyExecutionPaths() {
        System.out.println("--- Finally Execution Paths ---");
        
        // Path 1: Normal execution
        executeWithPath("normal");
        
        // Path 2: Exception handled
        executeWithPath("exception");
        
        // Path 3: Early return
        executeWithPath("return");
        
        // Path 4: Exception in catch block
        executeWithPath("catch-exception");
    }
    
    private static void executeWithPath(String path) {
        System.out.println("\nPath: " + path);
        try {
            System.out.println("   Try: Starting");
            
            switch (path) {
                case "normal":
                    System.out.println("   Try: Normal execution completed");
                    break;
                    
                case "exception":
                    throw new RuntimeException("Intentional exception");
                    
                case "return":
                    System.out.println("   Try: Early return");
                    return;  // Finally still executes!
                    
                case "catch-exception":
                    throw new RuntimeException("Exception for catch block");
            }
            
        } catch (RuntimeException e) {
            System.out.println("   Catch: Handling " + e.getMessage());
            
            if (path.equals("catch-exception")) {
                // This would normally terminate the method, but finally still executes
                throw new IllegalStateException("Exception in catch block");
            }
            
        } finally {
            System.out.println("   Finally: Cleanup executed for path '" + path + "'");
        }
        
        System.out.println("   After try-catch-finally");
    }
    
    /**
     * Resource cleanup example - typical finally usage
     */
    public static void resourceCleanupExample() {
        System.out.println("--- Resource Cleanup Example ---");
        
        FileWriter writer = null;
        Scanner scanner = null;
        
        try {
            System.out.println("Opening resources...");
            
            // Simulate opening file resources
            // writer = new FileWriter("temp.txt");  // Commented out for demo
            // scanner = new Scanner(System.in);     // Commented out for demo
            
            System.out.println("Resources opened successfully");
            
            // Simulate some file operations
            System.out.println("Performing file operations...");
            
            // Simulate an error during operations
            if (Math.random() > 0.5) {
                throw new IOException("Simulated I/O error");
            }
            
            System.out.println("File operations completed");
            
        } catch (IOException e) {
            System.out.println("Error during file operations: " + e.getMessage());
            
        } finally {
            // Cleanup resources - this ALWAYS executes
            System.out.println("Cleanup: Closing resources...");
            
            try {
                if (writer != null) {
                    writer.close();
                    System.out.println("FileWriter closed");
                }
            } catch (IOException e) {
                System.out.println("Error closing FileWriter: " + e.getMessage());
            }
            
            if (scanner != null) {
                scanner.close();
                System.out.println("Scanner closed");
            }
            
            System.out.println("All resources cleaned up");
        }
    }
    
    /**
     * Demonstrates finally execution with return statements
     */
    public static void finallyWithReturn() {
        System.out.println("--- Finally with Return Statements ---");
        
        System.out.println("Method 1 result: " + methodWithFinallyAndReturn());
        System.out.println("Method 2 result: " + methodWithFinallyModifyingReturn());
    }
    
    private static String methodWithFinallyAndReturn() {
        try {
            System.out.println("   Try: About to return 'try-value'");
            return "try-value";  // Finally still executes before return!
            
        } catch (Exception e) {
            System.out.println("   Catch: About to return 'catch-value'");
            return "catch-value";
            
        } finally {
            System.out.println("   Finally: Executing before method returns");
            // Note: return statement in finally would override try/catch returns
            // return "finally-value";  // This would be the actual return value
        }
    }
    
    private static int methodWithFinallyModifyingReturn() {
        int value = 10;
        
        try {
            System.out.println("   Try: value = " + value + ", returning");
            return value;  // Returns 10, but finally executes first
            
        } finally {
            value = 20;  // This changes the local variable but doesn't affect return value
            System.out.println("   Finally: Modified value to " + value);
            // The return value is still 10 because primitive values are copied
        }
    }
    
    /**
     * Rare cases when finally doesn't execute
     */
    public static void whenFinallyDoesntExecute() {
        System.out.println("--- When Finally Doesn't Execute ---");
        
        System.out.println("Finally block will NOT execute in these cases:");
        System.out.println("1. System.exit() is called");
        System.out.println("2. JVM crashes");
        System.out.println("3. Fatal errors (OutOfMemoryError, etc.)");
        System.out.println("4. Infinite loop in try/catch blocks");
        System.out.println("5. Thread is killed externally");
        
        // Example: System.exit() prevents finally execution
        demonstrateSystemExit();
    }
    
    private static void demonstrateSystemExit() {
        System.out.println("\nDemonstrating System.exit() (commented out for safety):");
        
        try {
            System.out.println("   Try: Before System.exit()");
            // System.exit(0);  // Commented out - this would terminate JVM
            System.out.println("   Try: After System.exit() (would not execute)");
            
        } finally {
            System.out.println("   Finally: Would not execute if System.exit() was called");
        }
    }
    
    /**
     * Try-with-resources vs traditional finally
     */
    public static void tryWithResourcesExample() {
        System.out.println("--- Try-with-Resources vs Finally ---");
        
        // Traditional approach with finally
        System.out.println("1. Traditional finally approach:");
        traditionalResourceHandling();
        
        System.out.println("\n2. Try-with-resources approach (Java 7+):");
        tryWithResourcesHandling();
    }
    
    private static void traditionalResourceHandling() {
        BufferedReader reader = null;
        
        try {
            // reader = new BufferedReader(new FileReader("example.txt"));
            System.out.println("   Traditional: Resource opened");
            // String line = reader.readLine();
            
        } catch (Exception e) {
            System.out.println("   Traditional: Exception handled");
            
        } finally {
            // Manual cleanup required
            try {
                if (reader != null) {
                    reader.close();
                    System.out.println("   Traditional: Resource closed in finally");
                }
            } catch (IOException e) {
                System.out.println("   Traditional: Error closing resource");
            }
        }
    }
    
    private static void tryWithResourcesHandling() {
        // Try-with-resources automatically handles cleanup
        try (/* BufferedReader reader = new BufferedReader(new FileReader("example.txt")) */) {
            System.out.println("   Try-with-resources: Resource auto-managed");
            // String line = reader.readLine();
            
        } catch (Exception e) {
            System.out.println("   Try-with-resources: Exception handled");
        }
        // No finally needed - resources are automatically closed
        System.out.println("   Try-with-resources: Resource auto-closed");
    }
}

/*
 * Key Points about Finally Block:
 * 
 * 1. EXECUTION GUARANTEE:
 *    - Finally block executes regardless of what happens in try/catch
 *    - Executes even if there's a return statement
 *    - Executes even if another exception is thrown in catch
 * 
 * 2. COMMON USE CASES:
 *    - Closing files, database connections, network connections
 *    - Releasing memory or system resources
 *    - Logging cleanup operations
 *    - Resetting variables or states
 * 
 * 3. EXECUTION ORDER:
 *    - Try block executes
 *    - If exception: appropriate catch block executes
 *    - Finally block ALWAYS executes
 *    - Code after try-catch-finally executes (if no unhandled exception)
 * 
 * 4. RETURN STATEMENTS:
 *    - Finally executes even if try/catch has return statements
 *    - Return in finally overrides returns in try/catch
 *    - Primitive values are copied before finally executes
 * 
 * 5. WHEN FINALLY DOESN'T EXECUTE:
 *    - System.exit() is called
 *    - JVM crashes or is killed
 *    - Fatal errors that terminate JVM
 *    - Infinite loops (blocks execution)
 * 
 * 6. BEST PRACTICES:
 *    - Use for cleanup operations only
 *    - Avoid complex logic in finally
 *    - Don't use return statements in finally (confusing)
 *    - Consider try-with-resources for automatic resource management
 *    - Handle exceptions that might occur in finally block itself
 */