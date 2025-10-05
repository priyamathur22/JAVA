
import java.util.*;
import java.util.stream.*;

class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Priya", 82),
            new Student("Rahul", 65),
            new Student("Simran", 90),
            new Student("Aman", 74),
            new Student("Karan", 88)
        );

        System.out.println("Students scoring above 75% (sorted by marks):");
        
        students.stream()
                .filter(s -> s.getMarks() > 75)                  // filter marks > 75
                .sorted(Comparator.comparingInt(Student::getMarks)) // sort by marks
                .map(Student::getName)                           // get only names
                .forEach(System.out::println);                   // print names
    }
}
