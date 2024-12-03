import java.util.Hashtable;
import java.util.Scanner;

public class GradeManager {
    public static void main(String[] args) {
        Hashtable<String, Integer> grades = new Hashtable<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nSimple Grade Manager");
            System.out.println("1. Add Student and Grade");
            System.out.println("2. Search for a Student's Grade");
            System.out.println("3. Display All Students and Grades");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            // Validate input
            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Grade: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Please enter a valid grade (0-100): ");
                        scanner.next();
                    }
                    int grade = scanner.nextInt();
                    grades.put(name, grade);
                    System.out.println("Student and grade added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Student Name to Search: ");
                    String searchName = scanner.nextLine();
                    if (grades.containsKey(searchName)) {
                        System.out.println("Grade of " + searchName + ": " + grades.get(searchName));
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    if (grades.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        System.out.println("All Students and Grades:");
                        for (String student : grades.keySet()) {
                            System.out.println("Name: " + student + ", Grade: " + grades.get(student));
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}