import java.util.*;
import java.util.stream.Collectors;
class Student {
    private String name;
    private double marks;
    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
    public String getName() {
        return name;
    }
    public double getMarks() {
        return marks;
    }
}
public class StudentStream {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("A", 82),
            new Student("B", 70),
            new Student("C", 90),
            new Student("D", 76),
            new Student("E", 68)
        );
        List<String> filteredAndSortedNames = students.stream()
            .filter(s -> s.getMarks() > 75)
            .sorted(Comparator.comparingDouble(Student::getMarks))
            .map(Student::getName)
            .collect(Collectors.toList());
        System.out.println("Students scoring above 75% (sorted by marks):");
        filteredAndSortedNames.forEach(System.out::println);
    }
}
