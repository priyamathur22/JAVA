
import java.io.*;
import java.util.*;

class Employee {
    private String id;
    private String name;
    private String designation;
    private double salary;

    public Employee(String id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + designation + "," + salary;
    }

    public static Employee fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 4) {
            return new Employee(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]));
        }
        return null;
    }

    public String display() {
        return "ID: " + id + " | Name: " + name + " | Designation: " + designation + " | Salary: " + salary;
    }
}

public class EmployeeManagementSystem {
    private static final String FILE_NAME = "employees.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== Employee Management System ====");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addEmployee(sc);
                    break;
                case 2:
                    displayEmployees();
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);

        sc.close();
    }

    private static void addEmployee(Scanner sc) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            System.out.print("Enter Employee ID: ");
            String id = sc.nextLine();
            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Designation: ");
            String designation = sc.nextLine();
            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            Employee emp = new Employee(id, name, designation, salary);
            writer.write(emp.toString());
            writer.newLine();
            System.out.println("Employee added successfully!");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void displayEmployees() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n--- Employee Records ---");
            while ((line = reader.readLine()) != null) {
                Employee emp = Employee.fromString(line);
                if (emp != null) {
                    System.out.println(emp.display());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No employee records found. Please add employees first.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
