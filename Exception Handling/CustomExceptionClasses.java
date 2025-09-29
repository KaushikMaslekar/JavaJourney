/*
 * Java Exception Handling - Part 6: Custom Exception Classes
 * 
 * Creating custom exceptions allows you to:
 * 1. Provide domain-specific error handling
 * 2. Add custom fields and methods
 * 3. Make error handling more readable and maintainable
 * 4. Group related exceptions under a common hierarchy
 * 
 * Types of Custom Exceptions:
 * - Checked: Extend Exception class
 * - Unchecked: Extend RuntimeException class
 */

import java.time.LocalDate;

public class CustomExceptionClasses {
    
    public static void main(String[] args) {
        System.out.println("=== Custom Exception Classes Demo ===\n");
        
        // 1. Basic custom exceptions
        demonstrateBasicCustomExceptions();
        System.out.println();
        
        // 2. Custom exceptions with additional fields
        demonstrateEnhancedCustomExceptions();
        System.out.println();
        
        // 3. Exception hierarchy
        demonstrateExceptionHierarchy();
        System.out.println();
        
        // 4. Real-world banking system example
        demonstrateBankingSystem();
        System.out.println();
        
        // 5. Best practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates basic custom exceptions
     */
    public static void demonstrateBasicCustomExceptions() {
        System.out.println("--- Basic Custom Exceptions ---");
        
        // Testing custom checked exception
        try {
            validateEmail("invalid-email");
        } catch (InvalidEmailException e) {
            System.out.println("1. Checked custom exception: " + e.getMessage());
        }
        
        // Testing custom unchecked exception
        try {
            processAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("2. Unchecked custom exception: " + e.getMessage());
        }
    }
    
    public static void validateEmail(String email) throws InvalidEmailException {
        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new InvalidEmailException("Invalid email format: " + email);
        }
        System.out.println("Email validation passed: " + email);
    }
    
    public static void processAge(int age) {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Age must be between 0 and 150. Provided: " + age);
        }
        System.out.println("Age processed: " + age);
    }
    
    /**
     * Demonstrates custom exceptions with additional fields and methods
     */
    public static void demonstrateEnhancedCustomExceptions() {
        System.out.println("--- Enhanced Custom Exceptions ---");
        
        try {
            performDatabaseOperation("DELETE", "admin_table");
        } catch (DatabaseException e) {
            System.out.println("1. Database Error Details:");
            System.out.println("   Operation: " + e.getOperation());
            System.out.println("   Table: " + e.getTableName());
            System.out.println("   Error Code: " + e.getErrorCode());
            System.out.println("   Message: " + e.getMessage());
            System.out.println("   Timestamp: " + e.getTimestamp());
        }
        
        try {
            validateUserPermissions("guest", "ADMIN");
        } catch (SecurityException e) {
            System.out.println("2. Security Error: " + e.getMessage());
            if (e instanceof AuthorizationException) {
                AuthorizationException authEx = (AuthorizationException) e;
                System.out.println("   User Role: " + authEx.getUserRole());
                System.out.println("   Required Role: " + authEx.getRequiredRole());
                System.out.println("   Access Level: " + authEx.getAccessLevel());
            }
        }
    }
    
    public static void performDatabaseOperation(String operation, String tableName) 
            throws DatabaseException {
        
        if ("DELETE".equals(operation) && tableName.startsWith("admin_")) {
            throw new DatabaseException(
                "DELETE operation not allowed on admin tables",
                operation,
                tableName,
                "DB_001"
            );
        }
        
        System.out.println("Database operation completed: " + operation + " on " + tableName);
    }
    
    public static void validateUserPermissions(String userRole, String requiredRole) 
            throws AuthorizationException {
        
        if (!userRole.equals(requiredRole)) {
            throw new AuthorizationException(
                "Insufficient permissions for operation",
                userRole,
                requiredRole,
                "Level-" + (requiredRole.equals("ADMIN") ? "1" : "2")
            );
        }
        
        System.out.println("User permissions validated: " + userRole);
    }
    
    /**
     * Demonstrates exception hierarchy
     */
    public static void demonstrateExceptionHierarchy() {
        System.out.println("--- Exception Hierarchy Demo ---");
        
        // Testing different levels of the hierarchy
        testApplicationException("VALIDATION_ERROR");
        testApplicationException("BUSINESS_ERROR");
        testApplicationException("SYSTEM_ERROR");
    }
    
    public static void testApplicationException(String errorType) {
        try {
            switch (errorType) {
                case "VALIDATION_ERROR":
                    throw new ValidationException("Invalid input data");
                    
                case "BUSINESS_ERROR":
                    throw new BusinessLogicException("Business rule violation");
                    
                case "SYSTEM_ERROR":
                    throw new SystemException("System resource unavailable");
                    
                default:
                    throw new ApplicationException("Generic application error");
            }
            
        } catch (ValidationException e) {
            System.out.println("Specific validation handling: " + e.getMessage());
            
        } catch (BusinessLogicException e) {
            System.out.println("Specific business logic handling: " + e.getMessage());
            
        } catch (ApplicationException e) {
            // This catches SystemException and any other ApplicationException subclasses
            System.out.println("General application error handling: " + 
                             e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
    
    /**
     * Real-world banking system example
     */
    public static void demonstrateBankingSystem() {
        System.out.println("--- Banking System Exception Example ---");
        
        BankAccount account = new BankAccount("12345", 1000.0);
        
        // Test various banking operations
        testBankingOperation(account, "withdraw", 500.0);   // Success
        testBankingOperation(account, "withdraw", 2000.0);  // Insufficient funds
        testBankingOperation(account, "withdraw", -100.0);  // Invalid amount
        testBankingOperation(account, "deposit", 0.0);      // Invalid amount
    }
    
    public static void testBankingOperation(BankAccount account, String operation, double amount) {
        try {
            if ("withdraw".equals(operation)) {
                account.withdraw(amount);
                System.out.println("Withdrawal successful: $" + amount + 
                                 ", Balance: $" + account.getBalance());
            } else if ("deposit".equals(operation)) {
                account.deposit(amount);
                System.out.println("Deposit successful: $" + amount + 
                                 ", Balance: $" + account.getBalance());
            }
            
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed - Insufficient funds:");
            System.out.println("   Requested: $" + e.getRequestedAmount());
            System.out.println("   Available: $" + e.getAvailableBalance());
            System.out.println("   Deficit: $" + e.getDeficit());
            
        } catch (InvalidAmountException e) {
            System.out.println("Transaction failed - Invalid amount: " + e.getMessage());
            System.out.println("   Amount: $" + e.getAmount());
            
        } catch (BankingException e) {
            System.out.println("Banking error: " + e.getMessage());
        }
    }
    
    /**
     * Demonstrates best practices for custom exceptions
     */
    public static void demonstrateBestPractices() {
        System.out.println("--- Custom Exception Best Practices ---");
        
        try {
            // Example of proper exception chaining
            processComplexOperation();
            
        } catch (ProcessingException e) {
            System.out.println("Processing failed: " + e.getMessage());
            System.out.println("Root cause: " + e.getCause().getMessage());
            
            // Print full stack trace
            System.out.println("Full stack trace:");
            e.printStackTrace();
        }
    }
    
    public static void processComplexOperation() throws ProcessingException {
        try {
            // Simulate a low-level operation that fails
            performLowLevelOperation();
            
        } catch (Exception e) {
            // Wrap the low-level exception in a higher-level one
            throw new ProcessingException("Failed to process complex operation", e);
        }
    }
    
    public static void performLowLevelOperation() throws Exception {
        throw new IllegalStateException("Low-level system error occurred");
    }
}

// ============================================================================
// CUSTOM EXCEPTION CLASSES
// ============================================================================

/**
 * Basic custom checked exception
 */
class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
    
    public InvalidEmailException(String message, Throwable cause) {
        super(message, cause);
    }
}

/**
 * Basic custom unchecked exception
 */
class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
    
    public InvalidAgeException(String message, Throwable cause) {
        super(message, cause);
    }
}

/**
 * Enhanced custom exception with additional fields
 */
class DatabaseException extends Exception {
    private final String operation;
    private final String tableName;
    private final String errorCode;
    private final LocalDate timestamp;
    
    public DatabaseException(String message, String operation, String tableName, String errorCode) {
        super(message);
        this.operation = operation;
        this.tableName = tableName;
        this.errorCode = errorCode;
        this.timestamp = LocalDate.now();
    }
    
    // Getters
    public String getOperation() { return operation; }
    public String getTableName() { return tableName; }
    public String getErrorCode() { return errorCode; }
    public LocalDate getTimestamp() { return timestamp; }
}

/**
 * Security exception with role information
 */
class AuthorizationException extends SecurityException {
    private final String userRole;
    private final String requiredRole;
    private final String accessLevel;
    
    public AuthorizationException(String message, String userRole, String requiredRole, String accessLevel) {
        super(message);
        this.userRole = userRole;
        this.requiredRole = requiredRole;
        this.accessLevel = accessLevel;
    }
    
    // Getters
    public String getUserRole() { return userRole; }
    public String getRequiredRole() { return requiredRole; }
    public String getAccessLevel() { return accessLevel; }
}

// ============================================================================
// EXCEPTION HIERARCHY EXAMPLE
// ============================================================================

/**
 * Base application exception
 */
class ApplicationException extends Exception {
    public ApplicationException(String message) {
        super(message);
    }
    
    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}

/**
 * Validation-specific exception
 */
class ValidationException extends ApplicationException {
    public ValidationException(String message) {
        super(message);
    }
}

/**
 * Business logic exception
 */
class BusinessLogicException extends ApplicationException {
    public BusinessLogicException(String message) {
        super(message);
    }
}

/**
 * System-level exception
 */
class SystemException extends ApplicationException {
    public SystemException(String message) {
        super(message);
    }
}

// ============================================================================
// BANKING SYSTEM EXCEPTIONS
// ============================================================================

/**
 * Base banking exception
 */
abstract class BankingException extends Exception {
    public BankingException(String message) {
        super(message);
    }
    
    public BankingException(String message, Throwable cause) {
        super(message, cause);
    }
}

/**
 * Insufficient funds exception
 */
class InsufficientFundsException extends BankingException {
    private final double requestedAmount;
    private final double availableBalance;
    
    public InsufficientFundsException(double requestedAmount, double availableBalance) {
        super("Insufficient funds: requested $" + requestedAmount + 
              ", available $" + availableBalance);
        this.requestedAmount = requestedAmount;
        this.availableBalance = availableBalance;
    }
    
    public double getRequestedAmount() { return requestedAmount; }
    public double getAvailableBalance() { return availableBalance; }
    public double getDeficit() { return requestedAmount - availableBalance; }
}

/**
 * Invalid amount exception
 */
class InvalidAmountException extends BankingException {
    private final double amount;
    
    public InvalidAmountException(double amount, String reason) {
        super("Invalid amount $" + amount + ": " + reason);
        this.amount = amount;
    }
    
    public double getAmount() { return amount; }
}

/**
 * Processing exception with cause chaining
 */
class ProcessingException extends Exception {
    public ProcessingException(String message) {
        super(message);
    }
    
    public ProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}

// ============================================================================
// SUPPORTING CLASSES
// ============================================================================

/**
 * Simple bank account class for demonstration
 */
class BankAccount {
    private String accountNumber;
    private double balance;
    
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException(amount, "Amount must be positive");
        }
        
        if (amount > balance) {
            throw new InsufficientFundsException(amount, balance);
        }
        
        balance -= amount;
    }
    
    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException(amount, "Amount must be positive");
        }
        
        balance += amount;
    }
    
    public double getBalance() {
        return balance;
    }
}

/*
 * Key Points about Custom Exceptions:
 * 
 * 1. WHEN TO CREATE CUSTOM EXCEPTIONS:
 *    - Domain-specific errors need special handling
 *    - Additional context information is needed
 *    - Grouping related exceptions under common hierarchy
 *    - Making error handling more readable and maintainable
 * 
 * 2. CHECKED vs UNCHECKED:
 *    - Extend Exception for checked exceptions (must be declared/handled)
 *    - Extend RuntimeException for unchecked exceptions (optional handling)
 *    - Choose based on whether client code should be forced to handle
 * 
 * 3. BEST PRACTICES:
 *    - Provide multiple constructors (message, message+cause)
 *    - Add meaningful fields and getter methods
 *    - Use proper naming convention (Exception suffix)
 *    - Document when and why the exception is thrown
 *    - Consider exception chaining for root cause analysis
 * 
 * 4. EXCEPTION HIERARCHY:
 *    - Create base exceptions for common behavior
 *    - Use inheritance to group related exceptions
 *    - Allow catching at different levels of specificity
 * 
 * 5. ADDITIONAL FIELDS:
 *    - Add context-specific information
 *    - Provide getter methods for accessing fields
 *    - Consider immutability for exception data
 * 
 * 6. EXCEPTION CHAINING:
 *    - Wrap lower-level exceptions in higher-level ones
 *    - Preserve original exception as cause
 *    - Helps in debugging and root cause analysis
 */