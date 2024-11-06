import java.util.Scanner;

public class StudentManagementSystem {
    private static StudentManager studentManager = new StudentManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. View Student");
            System.out.println("4. List All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    viewStudent();
                    break;
                case 4:
                    listStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter student major: ");
        String major = scanner.nextLine();

        Student student = new Student(id, name, age, major);
        studentManager.addStudent(student);
        System.out.println("Student added successfully.");
    }

    private static void removeStudent() {
        System.out.print("Enter student ID to remove: ");
        String id = scanner.nextLine();
        studentManager.removeStudent(id);
        System.out.println("Student removed successfully.");
    }

    private static void viewStudent() {
        System.out.print("Enter student ID to view: ");
        String id = scanner.nextLine();
        studentManager.getStudent(id).ifPresentOrElse(
            System.out::println,
            () -> System.out.println("Student not found.")
        );
    }

    private static void listStudents() {
        studentManager.listStudents();
    }
}
