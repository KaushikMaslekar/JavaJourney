/*
 * Java Exception Handling - Part 7: Exception Propagation
 * 
 * Exception propagation is the process by which an exception moves up
 * the call stack from the method where it occurred to the method that
 * can handle it.
 * 
 * Key Concepts:
 * - Call Stack: The sequence of method calls
 * - Propagation: How exceptions travel up the call stack
 * - Stack Unwinding: The process of exiting methods when exception occurs
 * - Exception Handling Chain: Where exceptions are caught and handled
 */

public class ExceptionPropagation {
    
    public static void main(String[] args) {
        System.out.println("=== Exception Propagation Demo ===\n");
        
        // 1. Basic propagation example
        demonstrateBasicPropagation();
        System.out.println();
        
        // 2. Propagation through multiple methods
        demonstrateMultiLevelPropagation();
        System.out.println();
        
        // 3. Partial handling and re-propagation
        demonstratePartialHandling();
        System.out.println();
        
        // 4. Call stack analysis
        demonstrateCallStackAnalysis();
        System.out.println();
        
        // 5. Real-world propagation example
        demonstrateRealWorldPropagation();
    }
    
    /**
     * Basic exception propagation example
     */
    public static void demonstrateBasicPropagation() {
        System.out.println("--- Basic Exception Propagation ---");
        
        try {
            System.out.println("1. Main method: Starting operation");
            methodA();
            System.out.println("1. Main method: Operation completed (this won't print)");
            
        } catch (ArithmeticException e) {
            System.out.println("1. Main method: Caught exception from deep in call stack");
            System.out.println("   Exception message: " + e.getMessage());
            System.out.println("   Exception originated from: " + e.getStackTrace()[0].getMethodName());
        }
    }
    
    // Call chain: main -> methodA -> methodB -> methodC
    public static void methodA() {
        System.out.println("2. Method A: Calling method B");
        methodB();  // Exception will propagate back through here
        System.out.println("2. Method A: This line won't execute due to exception");
    }
    
    public static void methodB() {
        System.out.println("3. Method B: Calling method C");
        methodC();  // Exception will propagate back through here
        System.out.println("3. Method B: This line won't execute due to exception");
    }
    
    public static void methodC() {
        System.out.println("4. Method C: About to cause exception");
        int result = 10 / 0;  // ArithmeticException occurs here
        System.out.println("4. Method C: This line won't execute");
    }
    
    /**
     * Multi-level propagation with different exception types
     */
    public static void demonstrateMultiLevelPropagation() {
        System.out.println("--- Multi-Level Propagation ---");
        
        // Test different scenarios
        testPropagationScenario("arithmetic");
        testPropagationScenario("nullpointer");
        testPropagationScenario("arrayindex");
    }
    
    public static void testPropagationScenario(String scenario) {
        try {
            System.out.println("\nScenario: " + scenario);
            level1(scenario);
            
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
            printPropagationPath(e);
            
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
            printPropagationPath(e);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
            printPropagationPath(e);
        }
    }
    
    public static void level1(String scenario) {
        System.out.println("  Level 1: Entering");
        level2(scenario);
        System.out.println("  Level 1: Exiting (won't print if exception occurs)");
    }
    
    public static void level2(String scenario) {
        System.out.println("  Level 2: Entering");
        level3(scenario);
        System.out.println("  Level 2: Exiting (won't print if exception occurs)");
    }
    
    public static void level3(String scenario) {
        System.out.println("  Level 3: Entering, about to cause " + scenario + " exception");
        
        switch (scenario) {
            case "arithmetic":
                int result = 10 / 0;
                break;
                
            case "nullpointer":
                String str = null;
                int length = str.length();
                break;
                
            case "arrayindex":
                int[] array = {1, 2, 3};
                int value = array[10];
                break;
        }
        
        System.out.println("  Level 3: This won't execute");
    }
    
    /**
     * Partial handling and re-propagation
     */
    public static void demonstratePartialHandling() {
        System.out.println("--- Partial Handling and Re-propagation ---");
        
        try {
            System.out.println("Main: Starting operation with partial handling");
            methodWithPartialHandling();
            
        } catch (Exception e) {
            System.out.println("Main: Final exception handler");
            System.out.println("   Exception type: " + e.getClass().getSimpleName());
            System.out.println("   Message: " + e.getMessage());
            
            // Check if this is a wrapped exception
            if (e.getCause() != null) {
                System.out.println("   Original cause: " + e.getCause().getClass().getSimpleName());
                System.out.println("   Original message: " + e.getCause().getMessage());
            }
        }
    }
    
    public static void methodWithPartialHandling() throws Exception {
        try {
            System.out.println("Partial Handler: Calling risky operation");
            riskyOperation();
            
        } catch (ArithmeticException e) {
            // Log the exception but re-throw as a different type
            System.out.println("Partial Handler: Logging ArithmeticException - " + e.getMessage());
            System.out.println("Partial Handler: Converting to RuntimeException and re-throwing");
            
            // Re-throw as a different exception type with original as cause
            throw new RuntimeException("Operation failed due to arithmetic error", e);
            
        } catch (NullPointerException e) {
            // Handle this exception completely (don't re-throw)
            System.out.println("Partial Handler: Completely handled NullPointerException");
            System.out.println("Partial Handler: Using default value and continuing");
            return;  // Normal method completion
        }
        // Other exceptions propagate unchanged
    }
    
    public static void riskyOperation() {
        // Randomly throw different types of exceptions
        double random = Math.random();
        
        if (random < 0.33) {
            throw new ArithmeticException("Division by zero in risky operation");
        } else if (random < 0.66) {
            throw new NullPointerException("Null reference in risky operation");
        } else {
            throw new IllegalStateException("Invalid state in risky operation");
        }
    }
    
    /**
     * Call stack analysis
     */
    public static void demonstrateCallStackAnalysis() {
        System.out.println("--- Call Stack Analysis ---");
        
        try {
            deepMethod1();
        } catch (Exception e) {
            System.out.println("Exception caught, analyzing call stack:");
            analyzeCallStack(e);
        }
    }
    
    public static void deepMethod1() {
        System.out.println("Deep Method 1");
        deepMethod2();
    }
    
    public static void deepMethod2() {
        System.out.println("Deep Method 2");
        deepMethod3();
    }
    
    public static void deepMethod3() {
        System.out.println("Deep Method 3");
        deepMethod4();
    }
    
    public static void deepMethod4() {
        System.out.println("Deep Method 4 - throwing exception");
        throw new RuntimeException("Exception from the depths!");
    }
    
    /**
     * Real-world propagation example: File processing system
     */
    public static void demonstrateRealWorldPropagation() {
        System.out.println("--- Real-World Propagation Example ---");
        
        try {
            processDocument("important-document.txt");
            
        } catch (DocumentProcessingException e) {
            System.out.println("Document processing failed:");
            System.out.println("  File: " + e.getFileName());
            System.out.println("  Stage: " + e.getProcessingStage());
            System.out.println("  Error: " + e.getMessage());
            
            // Log the full error chain
            Throwable cause = e.getCause();
            int level = 1;
            while (cause != null) {
                System.out.println("  Cause " + level + ": " + cause.getClass().getSimpleName() + 
                                 " - " + cause.getMessage());
                cause = cause.getCause();
                level++;
            }
        }
    }
    
    // Document processing pipeline
    public static void processDocument(String fileName) throws DocumentProcessingException {
        try {
            System.out.println("Starting document processing pipeline for: " + fileName);
            
            // Stage 1: Validation
            validateDocument(fileName);
            
            // Stage 2: Parsing
            parseDocument(fileName);
            
            // Stage 3: Processing
            processContent(fileName);
            
            // Stage 4: Saving
            saveResults(fileName);
            
            System.out.println("Document processing completed successfully");
            
        } catch (Exception e) {
            // Wrap any exception in a domain-specific exception
            throw new DocumentProcessingException(
                "Failed to process document: " + fileName,
                fileName,
                getCurrentStage(e),
                e
            );
        }
    }
    
    public static void validateDocument(String fileName) throws ValidationException {
        System.out.println("  Validating document: " + fileName);
        
        if (fileName.endsWith(".tmp")) {
            throw new ValidationException("Temporary files are not allowed");
        }
        
        if (fileName.length() > 50) {
            throw new ValidationException("File name too long");
        }
    }
    
    public static void parseDocument(String fileName) throws ParsingException {
        System.out.println("  Parsing document: " + fileName);
        
        if (fileName.contains("corrupted")) {
            throw new ParsingException("Document structure is corrupted");
        }
        
        // Simulate random parsing error
        if (Math.random() > 0.7) {
            throw new ParsingException("Unexpected token in document");
        }
    }
    
    public static void processContent(String fileName) throws ProcessingException {
        System.out.println("  Processing content: " + fileName);
        
        if (fileName.contains("large")) {
            throw new ProcessingException("Document too large to process");
        }
    }
    
    public static void saveResults(String fileName) throws SaveException {
        System.out.println("  Saving results: " + fileName);
        
        if (fileName.contains("readonly")) {
            throw new SaveException("Cannot save to read-only location");
        }
    }
    
    // Helper methods
    public static void printPropagationPath(Exception e) {
        System.out.println("Propagation path:");
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (int i = 0; i < Math.min(stackTrace.length, 5); i++) {
            System.out.println("  " + (i + 1) + ". " + stackTrace[i].getMethodName() + 
                             " (line " + stackTrace[i].getLineNumber() + ")");
        }
    }
    
    public static void analyzeCallStack(Exception e) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        
        System.out.println("Call stack depth: " + stackTrace.length);
        System.out.println("Exception origin: " + stackTrace[0].getMethodName() + 
                         " (line " + stackTrace[0].getLineNumber() + ")");
        
        System.out.println("Complete call chain:");
        for (int i = 0; i < stackTrace.length && i < 10; i++) {
            String methodName = stackTrace[i].getMethodName();
            int lineNumber = stackTrace[i].getLineNumber();
            System.out.println("  " + (i + 1) + ". " + methodName + " (line " + lineNumber + ")");
        }
    }
    
    private static String getCurrentStage(Exception e) {
        String className = e.getClass().getSimpleName();
        switch (className) {
            case "ValidationException": return "Validation";
            case "ParsingException": return "Parsing";
            case "ProcessingException": return "Processing";
            case "SaveException": return "Saving";
            default: return "Unknown";
        }
    }
}

// ============================================================================
// CUSTOM EXCEPTIONS FOR REAL-WORLD EXAMPLE
// ============================================================================

class DocumentProcessingException extends Exception {
    private final String fileName;
    private final String processingStage;
    
    public DocumentProcessingException(String message, String fileName, String processingStage, Throwable cause) {
        super(message, cause);
        this.fileName = fileName;
        this.processingStage = processingStage;
    }
    
    public String getFileName() { return fileName; }
    public String getProcessingStage() { return processingStage; }
}

class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}

class ParsingException extends Exception {
    public ParsingException(String message) {
        super(message);
    }
}

class ProcessingException extends Exception {
    public ProcessingException(String message) {
        super(message);
    }
}

class SaveException extends Exception {
    public SaveException(String message) {
        super(message);
    }
}

/*
 * Key Points about Exception Propagation:
 * 
 * 1. PROPAGATION MECHANISM:
 *    - Exceptions automatically propagate up the call stack
 *    - Each method in the call chain gets a chance to handle the exception
 *    - If not handled, exception continues to propagate upward
 *    - Program terminates if exception reaches main() without being handled
 * 
 * 2. CALL STACK UNWINDING:
 *    - When exception occurs, method execution stops immediately
 *    - Control returns to the calling method
 *    - Process continues until exception is caught or program terminates
 *    - Finally blocks execute during unwinding
 * 
 * 3. EXCEPTION HANDLING CHAIN:
 *    - Method can catch, handle completely, and stop propagation
 *    - Method can catch, partially handle, and re-throw
 *    - Method can catch, wrap in different exception, and throw new one
 *    - Method can ignore (not catch) and let exception propagate
 * 
 * 4. STACK TRACE INFORMATION:
 *    - Contains complete propagation path
 *    - Shows method names, line numbers, and class information
 *    - Helps in debugging and understanding exception flow
 *    - First element is where exception originated
 * 
 * 5. BEST PRACTICES:
 *    - Handle exceptions at appropriate level in call stack
 *    - Don't catch exceptions too early (close to occurrence)
 *    - Don't catch exceptions too late (losing context)
 *    - Use exception chaining to preserve original cause
 *    - Log exceptions at appropriate levels
 * 
 * 6. CHECKED vs UNCHECKED PROPAGATION:
 *    - Checked exceptions must be declared in method signature
 *    - Unchecked exceptions propagate automatically
 *    - Compilation fails if checked exceptions are not handled or declared
 * 
 * 7. EXCEPTION TRANSFORMATION:
 *    - Convert low-level exceptions to high-level ones
 *    - Preserve original exception as cause
 *    - Provide domain-specific context
 *    - Maintain abstraction layers
 */