/*
 * Java Exception Handling - Part 5: Throws and Throw Keywords
 * 
 * THROW vs THROWS:
 * 
 * THROW:
 * - Used to explicitly throw an exception from a method or block
 * - Used with an instance of exception class
 * - Can throw only one exception at a time
 * - Used inside method body
 * 
 * THROWS:
 * - Used in method signature to declare that method might throw exceptions
 * - Used with exception class names (not instances)
 * - Can declare multiple exceptions separated by commas
 * - Mandatory for checked exceptions
 */

import java.io.*;
import java.util.Scanner;

public class ThrowsAndThrowKeywords {
    
    public static void main(String[] args) {
        System.out.println("=== Throws and Throw Keywords Demo ===\n");
        
        // 1. Basic throw usage
        demonstrateThrowKeyword();
        System.out.println();
        
        // 2. Basic throws usage
        demonstrateThrowsKeyword();
        System.out.println();
        
        // 3. Checked vs Unchecked exceptions with throws
        demonstrateCheckedVsUnchecked();
        System.out.println();
        
        // 4. Method chaining with exceptions
        demonstrateMethodChaining();
        System.out.println();
        
        // 5. Real-world examples
        realWorldExamples();
    }
    
    /**
     * Demonstrates the 'throw' keyword
     */
    public static void demonstrateThrowKeyword() {
        System.out.println("--- THROW Keyword Demo ---");
        
        // Example 1: Throwing predefined exception
        try {
            validateAge(15);  // Will throw exception
        } catch (IllegalArgumentException e) {
            System.out.println("1. Caught: " + e.getMessage());
        }
        
        // Example 2: Throwing different types of exceptions
        try {
            processGrade(105);  // Will throw exception
        } catch (Exception e) {
            System.out.println("2. Caught: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
        
        // Example 3: Re-throwing an exception
        try {
            demonstrateRethrow();
        } catch (RuntimeException e) {
            System.out.println("3. Final catch: " + e.getMessage());
        }
    }
    
    // Method that uses 'throw' keyword
    public static void validateAge(int age) {
        if (age < 18) {
            // Explicitly throwing an exception
            throw new IllegalArgumentException("Age must be 18 or older. Provided: " + age);
        }
        System.out.println("Age validation passed: " + age);
    }
    
    // Method demonstrating conditional exception throwing
    public static void processGrade(int grade) {
        if (grade < 0) {
            throw new IllegalArgumentException("Grade cannot be negative");
        } else if (grade > 100) {
            throw new IllegalArgumentException("Grade cannot exceed 100");
        } else if (grade < 60) {
            throw new RuntimeException("Failing grade: " + grade);
        }
        System.out.println("Grade processed: " + grade);
    }
    
    // Method demonstrating re-throwing exceptions
    public static void demonstrateRethrow() {
        try {
            int result = 10 / 0;  // This will throw ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("   Caught and logging: " + e.getMessage());
            // Re-throw the same exception
            throw e;
            // Or throw a new exception
            // throw new RuntimeException("Wrapped exception", e);
        }
    }
    
    /**
     * Demonstrates the 'throws' keyword
     */
    public static void demonstrateThrowsKeyword() {
        System.out.println("--- THROWS Keyword Demo ---");
        
        // Calling methods that declare exceptions with 'throws'
        try {
            readFileContent("nonexistent.txt");
        } catch (IOException e) {
            System.out.println("1. IOException caught: " + e.getMessage());
        }
        
        try {
            parseNumber("abc");
        } catch (NumberFormatException e) {
            System.out.println("2. NumberFormatException caught: " + e.getMessage());
        }
        
        try {
            complexOperation(0);
        } catch (IOException | ArithmeticException e) {
            System.out.println("3. Multiple exceptions caught: " + e.getClass().getSimpleName());
        }
    }
    
    // Method declaring checked exception with 'throws'
    public static void readFileContent(String filename) throws IOException {
        // This method declares that it might throw IOException
        // Caller must handle or declare this exception
        
        if (!filename.endsWith(".txt")) {
            throw new IOException("Invalid file format. Expected .txt file");
        }
        
        // Simulating file reading that could throw IOException
        if (filename.equals("nonexistent.txt")) {
            throw new FileNotFoundException("File not found: " + filename);
        }
        
        System.out.println("File content read successfully: " + filename);
    }
    
    // Method declaring unchecked exception (optional but good practice)
    public static int parseNumber(String str) throws NumberFormatException {
        // For unchecked exceptions, 'throws' is optional but documentative
        if (str == null || str.isEmpty()) {
            throw new NumberFormatException("String is null or empty");
        }
        
        return Integer.parseInt(str);  // This can throw NumberFormatException
    }
    
    // Method declaring multiple exceptions
    public static void complexOperation(int value) throws IOException, ArithmeticException {
        // Method can declare multiple exceptions separated by commas
        
        if (value < 0) {
            throw new IOException("Negative values not supported");
        }
        
        if (value == 0) {
            throw new ArithmeticException("Zero value causes division error");
        }
        
        System.out.println("Complex operation completed with value: " + value);
    }
    
    /**
     * Demonstrates checked vs unchecked exceptions with throws
     */
    public static void demonstrateCheckedVsUnchecked() {
        System.out.println("--- Checked vs Unchecked with Throws ---");
        
        // Checked exceptions - MUST be handled or declared
        try {
            methodWithCheckedException();
        } catch (IOException e) {
            System.out.println("1. Checked exception handled: " + e.getMessage());
        }
        
        // Unchecked exceptions - handling is optional
        try {
            methodWithUncheckedException();
        } catch (RuntimeException e) {
            System.out.println("2. Unchecked exception handled: " + e.getMessage());
        }
        
        // Method with both types
        try {
            methodWithBothExceptions(true);
        } catch (IOException e) {
            System.out.println("3. Checked exception from mixed method: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("3. Unchecked exception from mixed method: " + e.getMessage());
        }
    }
    
    // MUST declare checked exceptions
    public static void methodWithCheckedException() throws IOException {
        // Simulating a checked exception
        throw new IOException("This is a checked exception - must be declared");
    }
    
    // Optional to declare unchecked exceptions (but good for documentation)
    public static void methodWithUncheckedException() throws IllegalArgumentException {
        // Unchecked exception - declaration is optional
        throw new IllegalArgumentException("This is an unchecked exception");
    }
    
    // Method with both checked and unchecked exceptions
    public static void methodWithBothExceptions(boolean throwChecked) 
            throws IOException, IllegalArgumentException {
        
        if (throwChecked) {
            throw new IOException("Checked exception thrown");
        } else {
            throw new IllegalArgumentException("Unchecked exception thrown");
        }
    }
    
    /**
     * Demonstrates method chaining with exception propagation
     */
    public static void demonstrateMethodChaining() {
        System.out.println("--- Method Chaining with Exceptions ---");
        
        try {
            level1Method();
        } catch (Exception e) {
            System.out.println("Final handler: " + e.getMessage());
            System.out.println("Exception originated from: " + e.getStackTrace()[0].getMethodName());
        }
    }
    
    public static void level1Method() throws Exception {
        System.out.println("Level 1: Calling level 2");
        level2Method();
    }
    
    public static void level2Method() throws Exception {
        System.out.println("Level 2: Calling level 3");
        level3Method();
    }
    
    public static void level3Method() throws Exception {
        System.out.println("Level 3: Throwing exception");
        throw new Exception("Exception from level 3 method");
    }
    
    /**
     * Real-world examples
     */
    public static void realWorldExamples() {
        System.out.println("--- Real-World Examples ---");
        
        // Example 1: File operations
        try {
            String content = readConfigFile("config.properties");
            System.out.println("1. Config loaded: " + content);
        } catch (IOException e) {
            System.out.println("1. Config loading failed: " + e.getMessage());
        }
        
        // Example 2: Database operations (simulated)
        try {
            connectToDatabase("invalid_url");
        } catch (SQLException e) {
            System.out.println("2. Database connection failed: " + e.getMessage());
        }
        
        // Example 3: User input validation
        try {
            User user = createUser("", -5);
        } catch (IllegalArgumentException e) {
            System.out.println("3. User creation failed: " + e.getMessage());
        }
    }
    
    // File operation example
    public static String readConfigFile(String filename) throws IOException {
        if (filename == null || filename.isEmpty()) {
            throw new IOException("Filename cannot be null or empty");
        }
        
        if (!filename.endsWith(".properties")) {
            throw new IOException("Invalid config file format");
        }
        
        // Simulating file reading
        return "config.loaded=true";
    }
    
    // Database operation example (simulated)
    public static void connectToDatabase(String url) throws SQLException {
        if (url == null || !url.startsWith("jdbc:")) {
            throw new SQLException("Invalid database URL format");
        }
        
        if (url.equals("invalid_url")) {
            throw new SQLException("Cannot connect to database");
        }
        
        System.out.println("Connected to database: " + url);
    }
    
    // User validation example
    public static User createUser(String name, int age) throws IllegalArgumentException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Invalid age: " + age);
        }
        
        return new User(name, age);
    }
    
    // Simple User class for demonstration
    static class User {
        private String name;
        private int age;
        
        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        @Override
        public String toString() {
            return "User{name='" + name + "', age=" + age + "}";
        }
    }
    
    // Custom SQLException for demonstration
    static class SQLException extends Exception {
        public SQLException(String message) {
            super(message);
        }
    }
}

/*
 * Key Points about Throw and Throws:
 * 
 * 1. THROW KEYWORD:
 *    - Used to explicitly throw an exception
 *    - Syntax: throw new ExceptionType("message");
 *    - Must throw an instance of Throwable or its subclasses
 *    - Causes immediate transfer of control to nearest catch block
 *    - Can be used anywhere in method body
 * 
 * 2. THROWS KEYWORD:
 *    - Used in method signature to declare possible exceptions
 *    - Syntax: methodName() throws ExceptionType1, ExceptionType2
 *    - Documents what exceptions a method might throw
 *    - MANDATORY for checked exceptions
 *    - OPTIONAL for unchecked exceptions (but good for documentation)
 * 
 * 3. CHECKED EXCEPTIONS:
 *    - Must be handled (try-catch) or declared (throws)
 *    - Compilation fails if not handled or declared
 *    - Examples: IOException, SQLException, ClassNotFoundException
 * 
 * 4. UNCHECKED EXCEPTIONS:
 *    - Don't need to be declared with throws
 *    - Can be declared for documentation purposes
 *    - Examples: RuntimeException and its subclasses
 * 
 * 5. BEST PRACTICES:
 *    - Use specific exception types
 *    - Provide meaningful error messages
 *    - Document all exceptions a method might throw
 *    - Don't catch and ignore exceptions
 *    - Use throws for checked exceptions, optionally for unchecked
 * 
 * 6. METHOD SIGNATURE RULES:
 *    - Overriding methods cannot declare broader checked exceptions
 *    - Can declare narrower or same exceptions as parent method
 *    - Can declare any unchecked exceptions
 */