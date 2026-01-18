import java.util.ArrayList;
import java.util.Scanner;

// Student class to store student details
class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

// Main class
public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        // Step 1: Get number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // Step 2: Take student details
        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.next();

            System.out.print("Enter student marks: ");
            int marks = sc.nextInt();

            students.add(new Student(name, marks));
        }

        // Step 3: Calculate total, highest, lowest
        int total = 0;
        int highest = students.get(0).marks;
        int lowest = students.get(0).marks;

        for (Student s : students) {
            total += s.marks;

            if (s.marks > highest) {
                highest = s.marks;
            }

            if (s.marks < lowest) {
                lowest = s.marks;
            }
        }

        double average = total / (double) n;

        // Step 4: Display summary report
        System.out.println("\n----- Student Summary Report -----");
        for (Student s : students) {
            System.out.println("Name: " + s.name + " | Marks: " + s.marks);
        }

        System.out.println("--------------------------------");
        System.out.println("Average Marks: " + average);
        System.out.println("Highest Marks: " + highest);
        System.out.println("Lowest Marks: " + lowest);
    }
}
