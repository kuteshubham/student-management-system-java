package main;

import dao.StudentDAO;
import model.Student;
import util.ValidationUtil;


import java.util.List;
import java.util.Scanner;

public class MainApp {

    private static final Scanner sc = new Scanner(System.in);
    private static final StudentDAO dao = new StudentDAO();

    public static void main(String[] args) {

        int choice = 0; //~

        do {
            System.out.println("===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student by ID");
            System.out.println("6. Exit");
            System.out.println();
            System.out.print("Enter choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine(); // Clear new line from buffer
            } catch (Exception e) {
                System.out.println("Please enter a valid number!");
                sc.nextLine(); // clear buffer
                continue;
            }

            switch (choice) {

                case 1 -> addStudent();

                case 2 -> viewAllStudents();

                case 3 -> updateStudent();

                case 4 -> deleteStudent();

                case 5 -> searchStudent();

                case 6 -> System.out.println("Exiting...");

                default -> System.out.println("Invalid choice! Try again.");
            }

            System.out.println();

        } while (choice != 6);

        sc.close();
    }

    // ================= ADD =================
    private static void addStudent() {

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        if (!ValidationUtil.isValidName(name)) {
            System.out.println("Invalid name");
            return;
        }

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        if (!ValidationUtil.isValidAge(age)) {
            System.out.println("Invalid age");
            return;
        }

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        if (!ValidationUtil.isValidEmail(email)) {
            System.out.println("Invalid email");
            return;
        }

        Student st = new Student(name, age, course, email);

        if (dao.addStudent(st)) {
            System.out.println("Student added successfully");
        } else {
            System.out.println("Failed to add student");
        }
    }

    
    // ================= VIEW =================
    private static void viewAllStudents() {
        List<Student> students = dao.viewAllStudents();

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        printHeader();
        for (Student st : students) {
            printRow(st);
        }
    }

    // ================= UPDATE =================
    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        Student existing = dao.searchStudentById(id);
        if (existing == null) {
            System.out.println("Student not found");
            return;
        }

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Course: ");
        String course = sc.nextLine();

        System.out.print("Enter New Email: ");
        String email = sc.nextLine();

        // ✅ ADD THIS (validation block)
        if (!ValidationUtil.isValidName(name)
                || !ValidationUtil.isValidAge(age)
                || !ValidationUtil.isValidEmail(email)) {

                System.out.println("Invalid input");
                return;
        }

        Student updated = new Student(id, name, age, course, email);

        if (dao.updateStudent(updated)) {
            System.out.println("Student updated successfully");
        } else {
            System.out.println("Update failed");
        }
    }

    // ================= DELETE =================
    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (dao.deleteStudent(id)) {
            System.out.println("Student deleted successfully");
        } else {
            System.out.println("Delete failed");
        }
    }

    // ================= SEARCH =================
    private static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();
        sc.nextLine();

        Student st = dao.searchStudentById(id);
        if (st == null) {
            System.out.println("Student not found");
            return;
        }

        printHeader();
        printRow(st);
    }

    // ================= FORMATTING =================
    private static void printHeader() {
        System.out.printf("%-5s %-20s %-5s %-10s %-30s%n",
                "ID", "Name", "Age", "Course", "Email");
        System.out.println("--------------------------------------------------------------------------");
    }

    private static void printRow(Student st) {
        System.out.printf("%-5d %-20s %-5d %-10s %-30s%n",
                st.getId(), st.getName(), st.getAge(), st.getCourse(), st.getEmail());
    }
}
