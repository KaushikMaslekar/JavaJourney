// ============================================
// JAVA IF-ELSE PROGRAMS: BASIC TO ADVANCED
// ============================================

import java.util.Arrays;
import java.util.Scanner;

public class IfElsePrograms {

    // ============================================
    // BASIC LEVEL PROGRAMS
    // ============================================
    // 1. Check if number is positive, negative, or zero
    public static void checkNumber(int num) {
        System.out.println("\n=== Number Check ===");
        if (num > 0) {
            System.out.println(num + " is positive");
        } else if (num < 0) {
            System.out.println(num + " is negative");
        } else {
            System.out.println("Number is zero");
        }
    }

    // 2. Check if number is even or odd
    public static void checkEvenOdd(int num) {
        System.out.println("\n=== Even/Odd Check ===");
        if (num % 2 == 0) {
            System.out.println(num + " is even");
        } else {
            System.out.println(num + " is odd");
        }
    }

    // 3. Find largest of three numbers
    public static void findLargest(int a, int b, int c) {
        System.out.println("\n=== Largest of Three ===");
        int largest;
        if (a >= b && a >= c) {
            largest = a;
        } else if (b >= a && b >= c) {
            largest = b;
        } else {
            largest = c;
        }
        System.out.println("Largest of " + a + ", " + b + ", " + c + " is: " + largest);
    }

    // 4. Grade calculator
    public static void calculateGrade(int marks) {
        System.out.println("\n=== Grade Calculator ===");
        char grade;
        if (marks >= 90) {
            grade = 'A';
        } else if (marks >= 80) {
            grade = 'B';
        } else if (marks >= 70) {
            grade = 'C';
        } else if (marks >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println("Marks: " + marks + ", Grade: " + grade);
    }

    // 5. Leap year checker
    public static void checkLeapYear(int year) {
        System.out.println("\n=== Leap Year Check ===");
        boolean isLeap;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    isLeap = true;
                } else {
                    isLeap = false;
                }
            } else {
                isLeap = true;
            }
        } else {
            isLeap = false;
        }
        System.out.println(year + (isLeap ? " is a leap year" : " is not a leap year"));
    }

    // ============================================
    // INTERMEDIATE LEVEL PROGRAMS
    // ============================================
    // 6. Age category classifier
    public static void classifyAge(int age) {
        System.out.println("\n=== Age Category ===");
        String category;
        if (age < 0) {
            category = "Invalid age";
        } else if (age <= 2) {
            category = "Infant";
        } else if (age <= 12) {
            category = "Child";
        } else if (age <= 19) {
            category = "Teenager";
        } else if (age <= 59) {
            category = "Adult";
        } else {
            category = "Senior";
        }
        System.out.println("Age " + age + " -> Category: " + category);
    }

    // 7. Triangle type checker
    public static void checkTriangle(int a, int b, int c) {
        System.out.println("\n=== Triangle Type Checker ===");
        if (a + b > c && b + c > a && a + c > b) {
            if (a == b && b == c) {
                System.out.println("Equilateral Triangle");
            } else if (a == b || b == c || a == c) {
                System.out.println("Isosceles Triangle");
            } else {
                System.out.println("Scalene Triangle");
            }
        } else {
            System.out.println("Not a valid triangle");
        }
    }

    // 8. BMI Calculator with categories
    public static void calculateBMI(double weight, double height) {
        System.out.println("\n=== BMI Calculator ===");
        double bmi = weight / (height * height);
        String category;

        if (bmi < 18.5) {
            category = "Underweight";
        } else if (bmi < 25) {
            category = "Normal weight";
        } else if (bmi < 30) {
            category = "Overweight";
        } else {
            category = "Obese";
        }

        System.out.printf("BMI: %.2f - Category: %s\n", bmi, category);
    }

    // 9. Simple calculator
    public static void calculator(double num1, double num2, char operator) {
        System.out.println("\n=== Simple Calculator ===");
        double result;
        boolean validOperation = true;

        if (operator == '+') {
            result = num1 + num2;
        } else if (operator == '-') {
            result = num1 - num2;
        } else if (operator == '*') {
            result = num1 * num2;
        } else if (operator == '/') {
            if (num2 != 0) {
                result = num1 / num2;
            } else {
                System.out.println("Error: Division by zero!");
                validOperation = false;
                result = 0;
            }
        } else {
            System.out.println("Error: Invalid operator!");
            validOperation = false;
            result = 0;
        }

        if (validOperation) {
            System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
        }
    }

    // 10. Password strength checker
    public static void checkPasswordStrength(String password) {
        System.out.println("\n=== Password Strength Checker ===");
        int score = 0;
        String strength;

        if (password.length() >= 8) {
            score++;
        }
        if (password.matches(".*[a-z].*")) {
            score++;
        }
        if (password.matches(".*[A-Z].*")) {
            score++;
        }
        if (password.matches(".*[0-9].*")) {
            score++;
        }
        if (password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            score++;
        }

        if (score == 5) {
            strength = "Very Strong";
        } else if (score >= 4) {
            strength = "Strong";
        } else if (score >= 3) {
            strength = "Medium";
        } else if (score >= 2) {
            strength = "Weak";
        } else {
            strength = "Very Weak";
        }

        System.out.println("Password: " + password);
        System.out.println("Strength: " + strength + " (Score: " + score + "/5)");
    }

    // ============================================
    // ADVANCED LEVEL PROGRAMS
    // ============================================
    // 11. Student management system
    public static void processStudent(String name, int[] marks) {
        System.out.println("\n=== Student Management System ===");
        System.out.println("Student: " + name);

        if (marks == null || marks.length == 0) {
            System.out.println("No marks available");
            return;
        }

        int total = 0;
        int passCount = 0;
        int failCount = 0;

        for (int mark : marks) {
            total += mark;
            if (mark >= 35) {
                passCount++;
            } else {
                failCount++;
            }
        }

        double average = (double) total / marks.length;

        String result;
        char grade;

        if (failCount > 0) {
            result = "FAIL";
            grade = 'F';
        } else {
            result = "PASS";
            if (average >= 90) {
                grade = 'A';
            } else if (average >= 80) {
                grade = 'B';
            } else if (average >= 70) {
                grade = 'C';
            } else if (average >= 60) {
                grade = 'D';
            } else {
                grade = 'E';
            }
        }

        System.out.println("Marks: " + Arrays.toString(marks));
        System.out.printf("Average: %.2f\n", average);
        System.out.println("Result: " + result);
        System.out.println("Grade: " + grade);
        System.out.println("Pass Count: " + passCount + ", Fail Count: " + failCount);
    }

    // 12. Tax calculator with multiple brackets
    public static void calculateTax(double income) {
        System.out.println("\n=== Tax Calculator ===");
        double tax = 0;
        String bracket;

        if (income <= 250000) {
            tax = 0;
            bracket = "No Tax";
        } else if (income <= 500000) {
            tax = (income - 250000) * 0.05;
            bracket = "5% Tax Bracket";
        } else if (income <= 1000000) {
            tax = 250000 * 0.05 + (income - 500000) * 0.20;
            bracket = "20% Tax Bracket";
        } else {
            tax = 250000 * 0.05 + 500000 * 0.20 + (income - 1000000) * 0.30;
            bracket = "30% Tax Bracket";
        }

        double netIncome = income - tax;
        double taxPercentage = (tax / income) * 100;

        System.out.printf("Gross Income: ₹%.2f\n", income);
        System.out.println("Tax Bracket: " + bracket);
        System.out.printf("Tax Amount: ₹%.2f\n", tax);
        System.out.printf("Tax Percentage: %.2f%%\n", taxPercentage);
        System.out.printf("Net Income: ₹%.2f\n", netIncome);
    }

    // 13. Weather recommendation system
    public static void weatherRecommendation(double temperature, int humidity, String condition) {
        System.out.println("\n=== Weather Recommendation System ===");
        System.out.printf("Temperature: %.1f°C, Humidity: %d%%, Condition: %s\n",
                temperature, humidity, condition);

        String clothing, activity, precaution;

        // Clothing recommendation
        if (temperature < 10) {
            clothing = "Heavy winter clothing, coat, gloves";
        } else if (temperature < 20) {
            clothing = "Light jacket, long pants";
        } else if (temperature < 30) {
            clothing = "Light clothing, t-shirt";
        } else {
            clothing = "Minimal clothing, shorts, light fabrics";
        }

        // Activity recommendation
        if (condition.equalsIgnoreCase("rainy") || condition.equalsIgnoreCase("stormy")) {
            activity = "Indoor activities recommended";
        } else if (temperature < 5 || temperature > 40) {
            activity = "Limited outdoor activities";
        } else if (humidity > 80) {
            activity = "Light outdoor activities, stay hydrated";
        } else {
            activity = "Perfect for outdoor activities";
        }

        // Health precautions
        if (temperature > 35 && humidity > 70) {
            precaution = "High heat index - risk of heat exhaustion";
        } else if (temperature < 0) {
            precaution = "Frostbite risk - limit exposure";
        } else if (humidity > 90) {
            precaution = "High humidity - may feel uncomfortable";
        } else {
            precaution = "Weather conditions are comfortable";
        }

        System.out.println("Clothing: " + clothing);
        System.out.println("Activity: " + activity);
        System.out.println("Precaution: " + precaution);
    }

    // 14. Complex loan eligibility checker
    public static void checkLoanEligibility(int age, double income, int creditScore,
            double existingDebt, boolean hasCollateral) {
        System.out.println("\n=== Loan Eligibility Checker ===");

        boolean eligible = false;
        String reason = "";
        double maxLoanAmount = 0;
        double interestRate = 0;

        // Basic eligibility criteria
        if (age < 21 || age > 65) {
            reason = "Age not in eligible range (21-65)";
        } else if (income < 25000) {
            reason = "Minimum income requirement not met (₹25,000)";
        } else if (creditScore < 600) {
            reason = "Credit score too low (minimum 600)";
        } else {
            // Calculate debt-to-income ratio
            double debtToIncomeRatio = (existingDebt / income) * 100;

            if (debtToIncomeRatio > 60) {
                reason = "Debt-to-income ratio too high (" + String.format("%.1f", debtToIncomeRatio) + "%)";
            } else {
                eligible = true;

                // Calculate loan amount and interest rate
                if (creditScore >= 800) {
                    maxLoanAmount = income * 60;
                    interestRate = hasCollateral ? 8.5 : 9.0;
                } else if (creditScore >= 750) {
                    maxLoanAmount = income * 50;
                    interestRate = hasCollateral ? 9.0 : 9.5;
                } else if (creditScore >= 700) {
                    maxLoanAmount = income * 40;
                    interestRate = hasCollateral ? 9.5 : 10.0;
                } else {
                    maxLoanAmount = income * 30;
                    interestRate = hasCollateral ? 10.0 : 11.0;
                }

                // Adjust for collateral
                if (hasCollateral) {
                    maxLoanAmount *= 1.2; // 20% bonus for collateral
                }
            }
        }

        System.out.println("=== Application Details ===");
        System.out.println("Age: " + age + " years");
        System.out.printf("Monthly Income: ₹%.2f\n", income);
        System.out.println("Credit Score: " + creditScore);
        System.out.printf("Existing Debt: ₹%.2f\n", existingDebt);
        System.out.println("Collateral: " + (hasCollateral ? "Yes" : "No"));

        System.out.println("\n=== Eligibility Result ===");
        if (eligible) {
            System.out.println("Status: APPROVED");
            System.out.printf("Maximum Loan Amount: ₹%.2f\n", maxLoanAmount);
            System.out.printf("Interest Rate: %.2f%%\n", interestRate);
        } else {
            System.out.println("Status: REJECTED");
            System.out.println("Reason: " + reason);
        }
    }

    // 15. Advanced menu-driven program
    public static void menuDrivenProgram() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("\n=== Advanced Menu-Driven Program ===");

        while (!exit) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Number Operations");
            System.out.println("2. String Operations");
            System.out.println("3. Array Operations");
            System.out.println("4. Mathematical Operations");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                numberOperationsMenu(scanner);
            } else if (choice == 2) {
                stringOperationsMenu(scanner);
            } else if (choice == 3) {
                arrayOperationsMenu(scanner);
            } else if (choice == 4) {
                mathOperationsMenu(scanner);
            } else if (choice == 5) {
                exit = true;
                System.out.println("Thank you for using the program!");
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Helper methods for menu-driven program
    private static void numberOperationsMenu(Scanner scanner) {
        System.out.println("\n--- NUMBER OPERATIONS ---");
        System.out.println("1. Check Prime");
        System.out.println("2. Check Perfect Number");
        System.out.println("3. Find Factors");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        if (choice == 1) {
            boolean isPrime = (num > 1);
            if (num > 1) {
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            System.out.println(num + (isPrime ? " is prime" : " is not prime"));
        } else if (choice == 2) {
            int sum = 0;
            for (int i = 1; i < num; i++) {
                if (num % i == 0) {
                    sum += i;
                }
            }
            System.out.println(num + (sum == num ? " is perfect" : " is not perfect"));
        } else if (choice == 3) {
            System.out.print("Factors of " + num + ": ");
            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        } else {
            System.out.println("Invalid choice!");
        }
    }

    private static void stringOperationsMenu(Scanner scanner) {
        System.out.println("\n--- STRING OPERATIONS ---");
        System.out.println("1. Check Palindrome");
        System.out.println("2. Count Vowels");
        System.out.println("3. Reverse String");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();

        if (choice == 1) {
            String reversed = new StringBuilder(str.toLowerCase()).reverse().toString();
            boolean isPalindrome = str.toLowerCase().equals(reversed);
            System.out.println("\"" + str + "\"" + (isPalindrome ? " is palindrome" : " is not palindrome"));
        } else if (choice == 2) {
            int vowelCount = 0;
            String vowels = "aeiouAEIOU";
            for (char c : str.toCharArray()) {
                if (vowels.indexOf(c) != -1) {
                    vowelCount++;
                }
            }
            System.out.println("Number of vowels: " + vowelCount);
        } else if (choice == 3) {
            String reversed = new StringBuilder(str).reverse().toString();
            System.out.println("Reversed string: " + reversed);
        } else {
            System.out.println("Invalid choice!");
        }
    }

    private static void arrayOperationsMenu(Scanner scanner) {
        System.out.println("\n--- ARRAY OPERATIONS ---");
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("1. Find Maximum");
        System.out.println("2. Find Minimum");
        System.out.println("3. Calculate Sum");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();

        if (choice == 1) {
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            System.out.println("Maximum element: " + max);
        } else if (choice == 2) {
            int min = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
            System.out.println("Minimum element: " + min);
        } else if (choice == 3) {
            int sum = 0;
            for (int num : arr) {
                sum += num;
            }
            System.out.println("Sum of elements: " + sum);
        } else {
            System.out.println("Invalid choice!");
        }
    }

    private static void mathOperationsMenu(Scanner scanner) {
        System.out.println("\n--- MATHEMATICAL OPERATIONS ---");
        System.out.println("1. Factorial");
        System.out.println("2. Fibonacci Series");
        System.out.println("3. Power Calculation");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter a number: ");
            int num = scanner.nextInt();
            long factorial = 1;
            if (num < 0) {
                System.out.println("Factorial not defined for negative numbers");
            } else {
                for (int i = 1; i <= num; i++) {
                    factorial *= i;
                }
                System.out.println("Factorial of " + num + " = " + factorial);
            }
        } else if (choice == 2) {
            System.out.print("Enter number of terms: ");
            int n = scanner.nextInt();
            System.out.print("Fibonacci series: ");
            if (n >= 1) {
                System.out.print("0 ");
            }
            if (n >= 2) {
                System.out.print("1 ");
            }

            int a = 0, b = 1;
            for (int i = 3; i <= n; i++) {
                int c = a + b;
                System.out.print(c + " ");
                a = b;
                b = c;
            }
            System.out.println();
        } else if (choice == 3) {
            System.out.print("Enter base: ");
            double base = scanner.nextDouble();
            System.out.print("Enter exponent: ");
            int exp = scanner.nextInt();

            double result = 1;
            if (exp >= 0) {
                for (int i = 0; i < exp; i++) {
                    result *= base;
                }
            } else {
                for (int i = 0; i < -exp; i++) {
                    result /= base;
                }
            }
            System.out.println(base + "^" + exp + " = " + result);
        } else {
            System.out.println("Invalid choice!");
        }
    }

    // ============================================
    // MAIN METHOD - TESTING ALL PROGRAMS
    // ============================================
    public static void main(String[] args) {
        System.out.println("JAVA IF-ELSE PROGRAMS: BASIC TO ADVANCED");
        System.out.println("==========================================");

        // Basic Programs
        checkNumber(15);
        checkNumber(-5);
        checkNumber(0);

        checkEvenOdd(24);
        checkEvenOdd(17);

        findLargest(10, 25, 15);

        calculateGrade(85);
        calculateGrade(92);
        calculateGrade(45);

        checkLeapYear(2024);
        checkLeapYear(2023);

        // Intermediate Programs
        classifyAge(25);
        classifyAge(8);
        classifyAge(70);

        checkTriangle(3, 4, 5);
        checkTriangle(5, 5, 5);
        checkTriangle(1, 1, 5);

        calculateBMI(70, 1.75);

        calculator(10, 5, '+');
        calculator(10, 0, '/');
        calculator(10, 3, '%');

        checkPasswordStrength("MyP@ssw0rd123");
        checkPasswordStrength("password");

        // Advanced Programs
        int[] marks1 = {85, 90, 78, 92, 88};
        int[] marks2 = {45, 60, 30, 55, 40};
        processStudent("John Doe", marks1);
        processStudent("Jane Smith", marks2);

        calculateTax(300000);
        calculateTax(750000);
        calculateTax(1200000);

        weatherRecommendation(25.5, 65, "sunny");
        weatherRecommendation(5.0, 80, "rainy");
        weatherRecommendation(38.0, 90, "clear");

        checkLoanEligibility(30, 50000, 750, 15000, true);
        checkLoanEligibility(25, 20000, 650, 5000, false);
        checkLoanEligibility(70, 80000, 800, 10000, true);

        // Uncomment to run interactive menu
        // menuDrivenProgram();
        System.out.println("\n==========================================");
        System.out.println("All programs executed successfully!");
    }
}
