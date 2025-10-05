```java
import java.io.*;

// Student class implementing Serializable
class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String studentID;
    private String name;
    private String grade;

    public Student(String studentID, String name, String grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StudentID: " + studentID + ", Name: " + name + ", Grade: " + grade;
    }
}

public class StudentSerializationDemo {
    private static final String FILE_NAME = "student.ser";

    public static void main(String[] args) {
        // Create a Student object
        Student student = new Student("S101", "Priya", "A");

        // Serialization: Writing the object to a file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(student);
            System.out.println("Student object serialized successfully!");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }

        // Deserialization: Reading the object from the file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Student deserializedStudent = (Student) ois.readObject();
            System.out.println("Deserialized Student Object:");
            System.out.println(deserializedStudent);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }
    }
}
```
