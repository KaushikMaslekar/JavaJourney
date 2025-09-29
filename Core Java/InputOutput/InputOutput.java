
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class InputOutput {

    // Utility method to repeat a character n times (Java 8 compatible)
    private static String repeatChar(char ch, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }

    // BASIC LEVEL PROGRAMS - CONSOLE I/O
    // 1. Basic console input/output
    public static void basicConsoleIO() {
        System.out.println("\n=== Basic Console I/O ===");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            System.out.print("Enter your salary: ");
            double salary = scanner.nextDouble();

            System.out.print("Are you a student? (true/false): ");
            boolean isStudent = scanner.nextBoolean();

            // Output with different formats
            System.out.println("\n--- Output Results ---");
            System.out.println("Name: " + name);
            System.out.println("Age: " + age + " years");
            System.out.printf("Salary: $%.2f%n", salary);
            System.out.println("Student Status: " + (isStudent ? "Yes" : "No"));
        } catch (InputMismatchException e) {
            System.err.println("Invalid input: " + e.getMessage());
        }
    }

    // 2. Formatted output examples
    public static void formattedOutput() {
        System.out.println("\n=== Formatted Output Examples ===");
        String name = "John Doe";
        int age = 25;
        double salary = 45000.50;
        Date currentDate = new Date();

        // Basic printf formatting
        System.out.printf("Employee: %-15s Age: %3d Salary: $%10.2f%n", name, age, salary);

        // Number formatting
        System.out.println("\n--- Number Formatting ---");
        double pi = Math.PI;
        System.out.printf("Pi value: %.2f%n", pi);
        System.out.printf("Pi scientific: %e%n", pi);
        System.out.printf("Pi percentage: %.2f%%%n", pi * 100);

        // Integer formatting
        int number = 42;
        System.out.printf("Decimal: %d%n", number);
        System.out.printf("Octal: %o%n", number);
        System.out.printf("Hexadecimal: %x%n", number);
        System.out.printf("Binary: %s%n", Integer.toBinaryString(number));

        // Date formatting
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.printf("Current Date: %s%n", dateFormat.format(currentDate));

        // String formatting
        System.out.println("\n--- String Formatting ---");
        String text = "Hello";
        System.out.printf("Left aligned: '%-10s'%n", text);
        System.out.printf("Right aligned: '%10s'%n", text);
        System.out.printf("Centered-ish: '%5s%5s'%n", "", text);
    }

    // 3. Scanner input validation
    public static void inputValidation() {
        System.out.println("\n=== Input Validation ===");
        try (Scanner scanner = new Scanner(System.in)) {
            // Integer input validation
            int age = 0;
            boolean validInput = false;

            while (!validInput) {
                System.out.print("Enter your age (1-120): ");
                try {
                    age = scanner.nextInt();
                    if (age >= 1 && age <= 120) {
                        validInput = true;
                    } else {
                        System.out.println("Please enter age between 1 and 120.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.next(); // Clear invalid input
                }
            }

            scanner.nextLine(); // Consume newline

            // Email validation
            String email = "";
            validInput = false;
            while (!validInput) {
                System.out.print("Enter your email: ");
                email = scanner.nextLine();
                if (email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                    validInput = true;
                } else {
                    System.out.println("Please enter a valid email address (e.g., user@domain.com).");
                }
            }

            System.out.println("Valid input received!");
            System.out.println("Age: " + age);
            System.out.println("Email: " + email);
        }
    }

    // 4. Multiple data types input
    public static void multipleDataTypes() {
        System.out.println("\n=== Multiple Data Types Input ===");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a byte value (-128 to 127): ");
            byte byteValue = scanner.nextByte();

            System.out.print("Enter a short value: ");
            short shortValue = scanner.nextShort();

            System.out.print("Enter an int value: ");
            int intValue = scanner.nextInt();

            System.out.print("Enter a long value: ");
            long longValue = scanner.nextLong();

            System.out.print("Enter a float value: ");
            float floatValue = scanner.nextFloat();

            System.out.print("Enter a double value: ");
            double doubleValue = scanner.nextDouble();

            System.out.print("Enter a char value: ");
            char charValue = scanner.next().charAt(0);

            scanner.nextLine(); // Consume newline
            System.out.print("Enter a string value: ");
            String stringValue = scanner.nextLine();

            System.out.println("\n--- Data Types Output ---");
            System.out.println("Byte: " + byteValue + " (Size: " + Byte.BYTES + " bytes)");
            System.out.println("Short: " + shortValue + " (Size: " + Short.BYTES + " bytes)");
            System.out.println("Int: " + intValue + " (Size: " + Integer.BYTES + " bytes)");
            System.out.println("Long: " + longValue + " (Size: " + Long.BYTES + " bytes)");
            System.out.println("Float: " + floatValue + " (Size: " + Float.BYTES + " bytes)");
            System.out.println("Double: " + doubleValue + " (Size: " + Double.BYTES + " bytes)");
            System.out.println("Char: " + charValue + " (Unicode: " + (int) charValue + ")");
            System.out.println("String: " + stringValue + " (Length: " + stringValue.length() + ")");
        } catch (InputMismatchException e) {
            System.err.println("Invalid input: " + e.getMessage());
        }
    }

    public static void basicFileWrite() {
        System.out.println("\n=== Basic File Writing ===");
        String fileName = "sample_output.txt";

        try (FileWriter writer = new FileWriter(fileName); PrintWriter printWriter = new PrintWriter(new FileWriter("formatted_output.txt"))) {
            // Using FileWriter
            writer.write("Hello, File I/O!\n");
            writer.write("This is line 2.\n");
            writer.write("Current time: " + new Date() + "\n");
            System.out.println("Data written to " + fileName + " successfully!");

            // Using PrintWriter for formatted output
            printWriter.printf("Employee: %-15s Salary: $%10.2f%n", "John Doe", 50000.0);
            printWriter.printf("Employee: %-15s Salary: $%10.2f%n", "Jane Smith", 55000.0);
            System.out.println("Formatted data written to formatted_output.txt successfully!");

        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // 6. Basic file reading
    public static void basicFileRead() {
        System.out.println("\n=== Basic File Reading ===");
        String fileName = "sample_output.txt";

        File file = new File(fileName);
        if (!file.exists()) {
            System.err.println("File " + fileName + " does not exist. Please run Basic File Writing first.");
            return;
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName)); Scanner fileScanner = new Scanner(new File(fileName))) {
            // Reading using FileReader and BufferedReader
            String line;
            int lineNumber = 1;

            System.out.println("Contents of " + fileName + ":");
            System.out.println("--------------------------------");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.printf("%2d: %s%n", lineNumber++, line);
            }

            // Reading using Scanner
            System.out.println("\nReading using Scanner:");
            while (fileScanner.hasNextLine()) {
                System.out.println("Scanner: " + fileScanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // 7. File operations with user data
    public static void fileOperationsWithUserData() {
        System.out.println("\n=== File Operations with User Data ===");
        String fileName = "user_data.txt";

        try (Scanner scanner = new Scanner(System.in)) {
            // Writing user data to file
            try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
                System.out.print("How many records do you want to enter? ");
                int count;
                try {
                    count = scanner.nextInt();
                    if (count <= 0) {
                        System.out.println("Please enter a positive number of records.");
                        return;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.nextLine(); // Clear invalid input
                    return;
                }
                scanner.nextLine(); // Consume newline

                for (int i = 1; i <= count; i++) {
                    System.out.println("\nEnter details for person " + i + ":");
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Age: ");
                    int age;
                    try {
                        age = scanner.nextInt();
                        if (age < 0) {
                            System.out.println("Age cannot be negative.");
                            i--;
                            continue;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid age! Please enter a number.");
                        scanner.nextLine();
                        i--;
                        continue;
                    }
                    System.out.print("Salary: ");
                    double salary;
                    try {
                        salary = scanner.nextDouble();
                        if (salary < 0) {
                            System.out.println("Salary cannot be negative.");
                            i--;
                            continue;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid salary! Please enter a number.");
                        scanner.nextLine();
                        i--;
                        continue;
                    }
                    scanner.nextLine(); // Consume newline

                    // Write to file in CSV format, escaping commas in name
                    writer.printf("\"%s\",%d,%.2f%n", name.replace("\"", "\"\""), age, salary);
                }
                System.out.println("\nUser data saved to " + fileName);
            }

            // Reading and displaying the data
            File file = new File(fileName);
            if (!file.exists()) {
                System.err.println("File " + fileName + " does not exist.");
                return;
            }

            try (Scanner fileScanner = new Scanner(file)) {
                System.out.println("\nReading data from file:");
                System.out.println("Name\t\tAge\tSalary");
                System.out.println("--------------------------------");
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] parts = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                    if (parts.length == 3) {
                        String name = parts[0].replaceAll("^\"|\"$", "").replace("\"\"", "\"");
                        System.out.printf("%-15s\t%s\t$%s%n", name, parts[1], parts[2]);
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Error with file operations: " + e.getMessage());
        }
    }

    // 8. Binary file operations
    public static void binaryFileOperations() {
        System.out.println("\n=== Binary File Operations ===");
        String fileName = "binary_data.dat";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            // Writing binary data
            dos.writeInt(42);
            dos.writeDouble(3.14159);
            dos.writeBoolean(true);
            dos.writeUTF("Hello Binary World!");
            dos.writeLong(System.currentTimeMillis());
            System.out.println("Binary data written to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing binary file: " + e.getMessage());
            return;
        }

        File file = new File(fileName);
        if (!file.exists()) {
            System.err.println("File " + fileName + " does not exist.");
            return;
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            // Reading binary data
            int intValue = dis.readInt();
            double doubleValue = dis.readDouble();
            boolean booleanValue = dis.readBoolean();
            String stringValue = dis.readUTF();
            long longValue = dis.readLong();

            System.out.println("Binary data read from file:");
            System.out.println("Integer: " + intValue);
            System.out.println("Double: " + doubleValue);
            System.out.println("Boolean: " + booleanValue);
            System.out.println("String: " + stringValue);
            System.out.println("Long (timestamp): " + new Date(longValue));
        } catch (IOException e) {
            System.err.println("Error reading binary file: " + e.getMessage());
        }
    }

    public static void studentManagementSystem() {
        System.out.println("\n=== Student Management System ===");
        String fileName = "students.txt";
        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;
            while (!exit) {
                System.out.println("\n--- Student Management Menu ---");
                System.out.println("1. Add Student");
                System.out.println("2. Display All Students");
                System.out.println("3. Search Student");
                System.out.println("4. Update Student");
                System.out.println("5. Delete Student");
                System.out.println("6. Statistics");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");

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
                        addStudent(scanner, fileName);
                        break;
                    case 2:
                        displayAllStudents(fileName);
                        break;
                    case 3:
                        searchStudent(scanner, fileName);
                        break;
                    case 4:
                        updateStudent(scanner, fileName);
                        break;
                    case 5:
                        deleteStudent(scanner, fileName);
                        break;
                    case 6:
                        displayStatistics(fileName);
                        break;
                    case 7:
                        exit = true;
                        System.out.println("Exiting Student Management System...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        }
    }

    private static void addStudent(Scanner scanner, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            System.out.print("Enter student ID: ");
            int id;
            try {
                id = scanner.nextInt();
                if (id <= 0) {
                    System.out.println("ID must be positive.");
                    return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid ID! Please enter a number.");
                scanner.nextLine();
                return;
            }
            scanner.nextLine();

            // Check for duplicate ID
            if (isStudentIdExists(id, fileName)) {
                System.out.println("Student ID " + id + " already exists.");
                return;
            }

            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
                return;
            }

            System.out.print("Enter age: ");
            int age;
            try {
                age = scanner.nextInt();
                if (age < 0 || age > 120) {
                    System.out.println("Age must be between 0 and 120.");
                    return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid age! Please enter a number.");
                scanner.nextLine();
                return;
            }

            System.out.print("Enter grade (0-100): ");
            double grade;
            try {
                grade = scanner.nextDouble();
                if (grade < 0 || grade > 100) {
                    System.out.println("Grade must be between 0 and 100.");
                    return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid grade! Please enter a number.");
                scanner.nextLine();
                return;
            }
            scanner.nextLine();

            System.out.print("Enter course: ");
            String course = scanner.nextLine();
            if (course.isEmpty()) {
                System.out.println("Course cannot be empty.");
                return;
            }

            writer.printf("%d|%s|%d|%.2f|%s%n", id, name.replace("|", ""), age, grade, course.replace("|", ""));
            System.out.println("Student added successfully!");

        } catch (IOException e) {
            System.err.println("Error adding student: " + e.getMessage());
        }
    }

    private static boolean isStudentIdExists(int id, String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            return false;
        }
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\\|");
                if (parts.length >= 1 && Integer.parseInt(parts[0]) == id) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error checking student ID: " + e.getMessage());
        }
        return false;
    }

    private static void displayAllStudents(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("No student records found. Please add some students first.");
            return;
        }
        try (Scanner fileScanner = new Scanner(file)) {
            System.out.println("\n--- All Students ---");
            System.out.printf("%-5s %-20s %-5s %-7s %-15s%n", "ID", "Name", "Age", "Grade", "Course");
            System.out.println("--------------------------------------------------------");
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    System.out.printf("%-5s %-20s %-5s %-7s %-15s%n",
                            parts[0], parts[1], parts[2], parts[3], parts[4]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No student records found.");
        }
    }

    private static void searchStudent(Scanner scanner, String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("No student records found.");
            return;
        }
        System.out.print("Enter student ID to search: ");
        int searchId;
        try {
            searchId = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid ID! Please enter a number.");
            scanner.nextLine();
            return;
        }
        boolean found = false;

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\\|");
                if (parts.length == 5 && Integer.parseInt(parts[0]) == searchId) {
                    System.out.println("\n--- Student Found ---");
                    System.out.println("ID: " + parts[0]);
                    System.out.println("Name: " + parts[1]);
                    System.out.println("Age: " + parts[2]);
                    System.out.println("Grade: " + parts[3]);
                    System.out.println("Course: " + parts[4]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Student with ID " + searchId + " not found.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No student records found.");
        }
    }

    private static void updateStudent(Scanner scanner, String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("No student records found.");
            return;
        }
        System.out.print("Enter student ID to update: ");
        int updateId;
        try {
            updateId = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid ID! Please enter a number.");
            scanner.nextLine();
            return;
        }

        try {
            List<String> lines = new ArrayList<>();
            boolean found = false;
            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] parts = line.split("\\|");
                    if (parts.length == 5 && Integer.parseInt(parts[0]) == updateId) {
                        System.out.println("Current data: " + parts[1] + ", Age: " + parts[2]
                                + ", Grade: " + parts[3] + ", Course: " + parts[4]);
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        if (newName.isEmpty()) {
                            System.out.println("Name cannot be empty.");
                            return;
                        }
                        System.out.print("Enter new age: ");
                        int newAge;
                        try {
                            newAge = scanner.nextInt();
                            if (newAge < 0 || newAge > 120) {
                                System.out.println("Age must be between 0 and 120.");
                                return;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid age! Please enter a number.");
                            scanner.nextLine();
                            return;
                        }
                        System.out.print("Enter new grade: ");
                        double newGrade;
                        try {
                            newGrade = scanner.nextDouble();
                            if (newGrade < 0 || newGrade > 100) {
                                System.out.println("Grade must be between 0 and 100.");
                                return;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid grade! Please enter a number.");
                            scanner.nextLine();
                            return;
                        }
                        scanner.nextLine();
                        System.out.print("Enter new course: ");
                        String newCourse = scanner.nextLine();
                        if (newCourse.isEmpty()) {
                            System.out.println("Course cannot be empty.");
                            return;
                        }
                        lines.add(String.format("%d|%s|%d|%.2f|%s", updateId, newName.replace("|", ""), newAge, newGrade, newCourse.replace("|", "")));
                        found = true;
                    } else {
                        lines.add(line);
                    }
                }
            }
            if (found) {
                try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
                    for (String line : lines) {
                        writer.println(line);
                    }
                    System.out.println("Student updated successfully!");
                }
            } else {
                System.out.println("Student with ID " + updateId + " not found.");
            }
        } catch (IOException e) {
            System.err.println("Error updating student: " + e.getMessage());
        }
    }

    private static void deleteStudent(Scanner scanner, String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("No student records found.");
            return;
        }
        System.out.print("Enter student ID to delete: ");
        int deleteId;
        try {
            deleteId = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid ID! Please enter a number.");
            scanner.nextLine();
            return;
        }

        try {
            List<String> lines = new ArrayList<>();
            boolean found = false;
            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] parts = line.split("\\|");
                    if (parts.length == 5 && Integer.parseInt(parts[0]) == deleteId) {
                        found = true;
                        System.out.println("Deleted student: " + parts[1]);
                    } else {
                        lines.add(line);
                    }
                }
            }
            if (found) {
                try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
                    for (String line : lines) {
                        writer.println(line);
                    }
                    System.out.println("Student deleted successfully!");
                }
            } else {
                System.out.println("Student with ID " + deleteId + " not found.");
            }
        } catch (IOException e) {
            System.err.println("Error deleting student: " + e.getMessage());
        }
    }

    private static void displayStatistics(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("No student records found.");
            return;
        }
        try (Scanner fileScanner = new Scanner(file)) {
            int totalStudents = 0;
            double totalGrades = 0;
            double highestGrade = 0;
            double lowestGrade = 100;
            Map<String, Integer> courseCount = new HashMap<>();

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    totalStudents++;
                    double grade;
                    try {
                        grade = Double.parseDouble(parts[3]);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid grade format in file for student ID " + parts[0]);
                        continue;
                    }
                    totalGrades += grade;
                    if (grade > highestGrade) {
                        highestGrade = grade;
                    }
                    if (grade < lowestGrade) {
                        lowestGrade = grade;
                    }
                    String course = parts[4];
                    courseCount.put(course, courseCount.getOrDefault(course, 0) + 1);
                }
            }
            if (totalStudents > 0) {
                System.out.println("\n--- Statistics ---");
                System.out.println("Total Students: " + totalStudents);
                System.out.printf("Average Grade: %.2f%n", totalGrades / totalStudents);
                System.out.printf("Highest Grade: %.2f%n", highestGrade);
                System.out.printf("Lowest Grade: %.2f%n", lowestGrade);
                System.out.println("\nCourse Distribution:");
                for (Map.Entry<String, Integer> entry : courseCount.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue() + " students");
                }
            } else {
                System.out.println("No student records found.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No student records found.");
        }
    }

    // 10. CSV file operations
    public static void csvFileOperations() {
        System.out.println("\n=== CSV File Operations ===");
        String csvFile = "employees.csv";

        try (PrintWriter csvWriter = new PrintWriter(new FileWriter(csvFile))) {
            // Writing CSV data
            csvWriter.println("ID,Name,Department,Salary,Join_Date");
            csvWriter.println("1,\"John Doe\",Engineering,75000,2020-01-15");
            csvWriter.println("2,\"Jane Smith\",Marketing,65000,2019-03-10");
            csvWriter.println("3,\"Bob Johnson\",Sales,55000,2021-07-20");
            csvWriter.println("4,\"Alice Brown\",HR,60000,2018-11-05");
            csvWriter.println("5,\"Charlie Davis\",Engineering,80000,2020-09-12");
            System.out.println("CSV file created successfully!");
        } catch (IOException e) {
            System.err.println("Error writing CSV file: " + e.getMessage());
            return;
        }

        File file = new File(csvFile);
        if (!file.exists()) {
            System.err.println("File " + csvFile + " does not exist.");
            return;
        }

        try (Scanner csvReader = new Scanner(file)) {
            // Reading and processing CSV data
            String header = csvReader.nextLine();
            System.out.println("\nCSV Data:");
            System.out.println(header);
            System.out.println(repeatChar('=', 60));

            double totalSalary = 0;
            int employeeCount = 0;
            Map<String, Integer> departmentCount = new HashMap<>();

            while (csvReader.hasNextLine()) {
                String line = csvReader.nextLine();
                String[] fields = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                if (fields.length >= 4) {
                    System.out.println(line.replaceAll("^\"|\"$", ""));
                    try {
                        totalSalary += Double.parseDouble(fields[3]);
                        employeeCount++;
                        String department = fields[2].replaceAll("^\"|\"$", "");
                        departmentCount.put(department, departmentCount.getOrDefault(department, 0) + 1);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid salary format in CSV: " + fields[3]);
                    }
                }
            }
            if (employeeCount > 0) {
                System.out.println("\n--- CSV Analysis ---");
                System.out.println("Total Employees: " + employeeCount);
                System.out.printf("Average Salary: $%.2f%n", totalSalary / employeeCount);
                System.out.println("\nDepartment Distribution:");
                for (Map.Entry<String, Integer> entry : departmentCount.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue() + " employees");
                }
            } else {
                System.out.println("No employee records found in CSV.");
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    // 11. Log file operations
    public static void logFileOperations() {
        System.out.println("\n=== Log File Operations ===");
        String logFile = "application.log";

        try (PrintWriter logger = new PrintWriter(new FileWriter(logFile))) {
            // Create log entries
            SimpleDateFormat logFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            logger.printf("[%s] INFO - Application started%n", logFormat.format(new Date()));
            logger.printf("[%s] DEBUG - Database connection established%n", logFormat.format(new Date()));
            logger.printf("[%s] WARN - Low memory warning%n", logFormat.format(new Date()));
            logger.printf("[%s] ERROR - Failed to connect to external service%n", logFormat.format(new Date()));
            logger.printf("[%s] INFO - User login successful%n", logFormat.format(new Date()));
            logger.printf("[%s] ERROR - Database query failed%n", logFormat.format(new Date()));
            logger.printf("[%s] INFO - Application shutdown%n", logFormat.format(new Date()));
            System.out.println("Log file created successfully!");
        } catch (IOException e) {
            System.err.println("Error writing log file: " + e.getMessage());
            return;
        }

        File file = new File(logFile);
        if (!file.exists()) {
            System.err.println("File " + logFile + " does not exist.");
            return;
        }

        try (Scanner logReader = new Scanner(file)) {
            // Analyze log file
            int infoCount = 0, debugCount = 0, warnCount = 0, errorCount = 0;
            System.out.println("\nLog File Contents:");
            System.out.println(repeatChar('=', 50));

            while (logReader.hasNextLine()) {
                String line = logReader.nextLine();
                System.out.println(line);
                if (line.contains("INFO")) {
                    infoCount++;
                } else if (line.contains("DEBUG")) {
                    debugCount++;
                } else if (line.contains("WARN")) {
                    warnCount++;
                } else if (line.contains("ERROR")) {
                    errorCount++;
                }
            }
            System.out.println("\n--- Log Analysis ---");
            System.out.println("INFO messages: " + infoCount);
            System.out.println("DEBUG messages: " + debugCount);
            System.out.println("WARN messages: " + warnCount);
            System.out.println("ERROR messages: " + errorCount);
            System.out.println("Total messages: " + (infoCount + debugCount + warnCount + errorCount));
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    // 12. Configuration file operations
    public static void configFileOperations() {
        System.out.println("\n=== Configuration File Operations ===");
        String configFile = "app.properties";

        try (PrintWriter configWriter = new PrintWriter(new FileWriter(configFile))) {
            // Create configuration file
            configWriter.println("# Application Configuration");
            configWriter.println("database.host=localhost");
            configWriter.println("database.port=3306");
            configWriter.println("database.name=myapp");
            configWriter.println("database.username=admin");
            configWriter.println("database.password=secret123");
            configWriter.println("app.version=1.0.0");
            configWriter.println("app.debug=true");
            configWriter.println("max.connections=100");
            configWriter.println("timeout.seconds=30");
            System.out.println("Configuration file created successfully!");
        } catch (IOException e) {
            System.err.println("Error writing configuration file: " + e.getMessage());
            return;
        }

        File file = new File(configFile);
        if (!file.exists()) {
            System.err.println("File " + configFile + " does not exist.");
            return;
        }

        try (Scanner configReader = new Scanner(file)) {
            // Read and parse configuration
            Map<String, String> config = new HashMap<>();
            System.out.println("\nConfiguration Properties:");
            System.out.println(repeatChar('=', 40));

            while (configReader.hasNextLine()) {
                String line = configReader.nextLine().trim();
                if (!line.isEmpty() && !line.startsWith("#")) {
                    String[] parts = line.split("=", 2);
                    if (parts.length == 2) {
                        String key = parts[0].trim();
                        String value = parts[1].trim();
                        config.put(key, value);
                        System.out.printf("%-20s = %s%n", key, value);
                    }
                }
            }
            // Use configuration values
            System.out.println("\n--- Using Configuration ---");
            String dbUrl = String.format("jdbc:mysql://%s:%s/%s",
                    config.getOrDefault("database.host", "localhost"),
                    config.getOrDefault("database.port", "3306"),
                    config.getOrDefault("database.name", "myapp"));
            System.out.println("Database URL: " + dbUrl);
            System.out.println("App Version: " + config.getOrDefault("app.version", "unknown"));
            System.out.println("Debug Mode: " + config.getOrDefault("app.debug", "false"));
            System.out.println("Max Connections: " + config.getOrDefault("max.connections", "0"));
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    // 13. System properties demonstration
    public static void systemProperties() {
        System.out.println("\n=== System Properties ===");
        Properties props = System.getProperties();
        System.out.println("--- Key System Properties ---");
        System.out.printf("%-30s: %s%n", "Java Version", props.getProperty("java.version", "unknown"));
        System.out.printf("%-30s: %s%n", "Java Vendor", props.getProperty("java.vendor", "unknown"));
        System.out.printf("%-30s: %s%n", "OS Name", props.getProperty("os.name", "unknown"));
        System.out.printf("%-30s: %s%n", "OS Architecture", props.getProperty("os.arch", "unknown"));
        System.out.printf("%-30s: %s%n", "User Home Directory", props.getProperty("user.home", "unknown"));
        System.out.printf("%-30s: %s%n", "Current Working Directory", props.getProperty("user.dir", "unknown"));

        // Setting a custom system property
        System.setProperty("myapp.version", "1.2.3");
        System.out.println("\nCustom Property Set:");
        System.out.printf("%-30s: %s%n", "myapp.version", System.getProperty("myapp.version"));

        // Listing all properties (limited to avoid overwhelming output)
        System.out.println("\n--- First 5 System Properties ---");
        props.stringPropertyNames().stream()
                .sorted()
                .limit(5)
                .forEach(key -> System.out.printf("%-30s: %s%n", key, props.getProperty(key)));
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;
            while (!exit) {
                System.out.println("\n=====================================");
                System.out.println("JAVA INPUT/OUTPUT PROGRAMS DEMO");
                System.out.println("=====================================");
                System.out.println("1. Basic Console I/O");
                System.out.println("2. Formatted Output");
                System.out.println("3. Input Validation");
                System.out.println("4. Multiple Data Types");
                System.out.println("5. Basic File Writing");
                System.out.println("6. Basic File Reading");
                System.out.println("7. File Operations with User Data");
                System.out.println("8. Binary File Operations");
                System.out.println("9. Student Management System");
                System.out.println("10. CSV File Operations");
                System.out.println("11. Log File Operations");
                System.out.println("12. Configuration File Operations");
                System.out.println("13. System Properties");
                System.out.println("14. Exit");
                System.out.print("Enter your choice (1-14): ");

                int choice;
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.nextLine(); // Clear invalid input
                    continue;
                }

                switch (choice) {
                    case 1:
                        basicConsoleIO();
                        break;
                    case 2:
                        formattedOutput();
                        break;
                    case 3:
                        inputValidation();
                        break;
                    case 4:
                        multipleDataTypes();
                        break;
                    case 5:
                        basicFileWrite();
                        break;
                    case 6:
                        basicFileRead();
                        break;
                    case 7:
                        fileOperationsWithUserData();
                        break;
                    case 8:
                        binaryFileOperations();
                        break;
                    case 9:
                        studentManagementSystem();
                        break;
                    case 10:
                        csvFileOperations();
                        break;
                    case 11:
                        logFileOperations();
                        break;
                    case 12:
                        configFileOperations();
                        break;
                    case 13:
                        systemProperties();
                        break;
                    case 14:
                        exit = true;
                        System.out.println("Exiting program...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please select between 1-14.");
                }

                if (!exit) {
                    System.out.print("\nPress Enter to continue...");
                    scanner.nextLine();
                }
            }
        }
    }
}
