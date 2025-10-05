
import java.util.*;

public class SumUsingAutoboxing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.print("Enter the number of integers: ");
        int n = Integer.parseInt(sc.nextLine()); // parsing string input to int

        for (int i = 0; i < n; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            String input = sc.nextLine();                 // string input
            Integer num = Integer.parseInt(input);       // parse string to int and autobox to Integer
            numbers.add(num);                             // autoboxing happens here
        }

        int sum = 0;
        for (Integer num : numbers) {
            sum += num;                                  // unboxing Integer to int
        }

        System.out.println("Sum of the integers: " + sum);
        sc.close();
    }
}

