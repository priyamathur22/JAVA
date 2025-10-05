
import java.util.*;

class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name + " | Age: " + age + " | Salary: " + salary;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Priya", 25, 50000),
            new Employee("Rahul", 30, 60000),
            new Employee("Simran", 28, 55000),
            new Employee("Aman", 22, 40000),
            new Employee("Karan", 35, 70000)
        );

        System.out.println("Sort by Name (Alphabetical):");
        employees.stream()
                 .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                 .forEach(System.out::println);

        System.out.println("\nSort by Age (Ascending):");
        employees.stream()
                 .sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()))
                 .forEach(System.out::println);

        System.out.println("\nSort by Salary (Descending):");
        employees.stream()
                 .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                 .forEach(System.out::println);
    }
}
