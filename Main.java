package com.yourname.sms;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();
        int choice;

        do {
            System.out.println("\n====== Student Management System ======");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    Student s = new Student();
                    s.setName(name);
                    s.setCourse(course);
                    if (dao.addStudent(s)) System.out.println("Student added successfully!");
                    else System.out.println("Failed to add student.");
                    break;
                case 2:
                    List<Student> students = dao.getAllStudents();
                    if (students.isEmpty()) System.out.println("No students found.");
                    else students.forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Enter Student ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String uname = sc.nextLine();
                    System.out.print("Enter New Course: ");
                    String ucourse = sc.nextLine();
                    Student us = new Student(uid, uname, ucourse);
                    if (dao.updateStudent(us)) System.out.println("Student updated successfully!");
                    else System.out.println("Failed to update student.");
                    break;
                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int did = sc.nextInt();
                    if (dao.deleteStudent(did)) System.out.println("Student deleted successfully!");
                    else System.out.println("Failed to delete student.");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}
