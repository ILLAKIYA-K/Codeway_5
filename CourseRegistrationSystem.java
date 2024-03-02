import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        // Create courses
        Course javaCourse = new Course("CS101", "Java Programming", "Learn Java programming language", 20, "Mon/Wed/Fri 10:00 AM - 12:00 PM");
        Course pythonCourse = new Course("CS102", "Python Programming", "Learn Python programming language", 15, "Tue/Thu 1:00 PM - 3:00 PM");

        // Create students
        Student student1 = new Student(1, "Alice");
        Student student2 = new Student(2, "Bob");

        // List of available courses
        List<Course> availableCourses = new ArrayList<>();
        availableCourses.add(javaCourse);
        availableCourses.add(pythonCourse);

        // Display available courses
        System.out.println("Available courses:");
        for (int i = 0; i < availableCourses.size(); i++) {
            Course course = availableCourses.get(i);
            System.out.println((i + 1) + ". " + course.getTitle() + " - " + course.getDescription() +
                    " (" + course.getSchedule() + ")");
        }

        // Allow students to register for courses
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n" + student1.getName() + ", enter the number of the course you want to register for (or 0 to exit):");
        int choice = scanner.nextInt();
        while (choice != 0) {
            if (choice > 0 && choice <= availableCourses.size()) {
                Course selectedCourse = availableCourses.get(choice - 1);
                student1.registerCourse(selectedCourse);
            } else {
                System.out.println("Invalid choice. Please enter a valid course number.");
            }
            System.out.println("\nEnter the number of the course you want to register for (or 0 to exit):");
            choice = scanner.nextInt();
        }

        // Display registered courses for the student
        student1.displayRegisteredCourses();
    }
}
