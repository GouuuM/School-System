package panels;

import models.*;
import java.util.Scanner;

public class TeacherPanel 
{
    public static void run(Teacher teacher, Scanner sc) 
    {
        while (true) {
            System.out.println("\n--- Teacher Panel ---");
            System.out.println("Welcome, " + teacher.getUsername() + "!");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Add Assignment");
            System.out.println("4. Remove Assignment");
            System.out.println("5. Grade Assignment");
            System.out.println("6. Add Lesson Plan");
            System.out.println("7. Remove Lesson Plan");
            System.out.println("8. Grade Student");
            System.out.println("9. Remove Student Grade");
            System.out.println("10. Add Announcement");
            System.out.println("11. Remove Announcement");
            System.out.println("0. Logout");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) 
            {
                case 1 -> 
                {
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter student ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter student username: ");
                    String username = sc.nextLine();
                    System.out.print("Enter student password: ");
                    String password = sc.nextLine();
                    SchoolData.getStudents().add(new Student(name, id, username, password));
                    SchoolData.saveStudents();
                    System.out.println("Student added.");
                }
                case 2 -> 
                {
                    System.out.print("Enter student ID to remove: ");
                    String id = sc.nextLine();
                    SchoolData.getStudents().removeIf(s -> s.getId().equals(id));
                    SchoolData.saveStudents();
                    System.out.println("Student removed.");
                }
                case 3 -> 
                {
                    System.out.print("Enter assignment title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter assignment description: ");
                    String desc = sc.nextLine();
                    SchoolData.getAssignments().add(new Assignment(title, desc));
                    SchoolData.saveAssignments();
                    System.out.println("Assignment added.");
                }
                case 4 -> 
                {
                    System.out.print("Enter title of assignment to remove: ");
                    String title = sc.nextLine();
                    SchoolData.getAssignments().removeIf(a -> a.getTitle().equalsIgnoreCase(title));
                    SchoolData.saveAssignments();
                    System.out.println("Assignment removed.");
                }
                case 5 -> 
                {
                    System.out.print("Enter student ID: ");
                    String studentId = sc.nextLine();
                    System.out.print("Enter assignment title to grade: ");
                    String title = sc.nextLine();
                    System.out.print("Enter grade: ");
                    String grade = sc.nextLine();
                    SchoolData.getGrades().add(new Grade(studentId, title + ": " + grade));
                    SchoolData.saveGrades();
                    System.out.println("Assignment graded.");
                }
                case 6 -> 
                {
                    System.out.print("Enter lesson title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter lesson content: ");
                    String content = sc.nextLine();
                    SchoolData.getLessons().add(new LessonPlan(title, content));
                    SchoolData.saveLessons();
                    System.out.println("Lesson added.");
                }
                case 7 -> 
                {
                    System.out.print("Enter lesson title to remove: ");
                    String title = sc.nextLine();
                    SchoolData.getLessons().removeIf(l -> l.getTitle().equalsIgnoreCase(title));
                    SchoolData.saveLessons();
                    System.out.println("Lesson removed.");
                }
                case 8 -> 
                {
                    System.out.print("Enter student ID to grade: ");
                    String studentIdToGrade = sc.nextLine();
                    System.out.print("Enter grade: ");
                    String finalGrade = sc.nextLine();
                    SchoolData.getGrades().add(new Grade(studentIdToGrade, "Overall: " + finalGrade));
                    SchoolData.saveGrades();
                    System.out.println("Student graded.");
                }
                case 9 -> 
                {
                    System.out.print("Enter student ID to remove grade for: ");
                    String studentIdToRemoveGrade = sc.nextLine();
                    SchoolData.getGrades().removeIf(g -> g.getStudentId().equals(studentIdToRemoveGrade));
                    SchoolData.saveGrades();
                    System.out.println("Student grade removed.");
                }
                case 10 -> 
                {
                    System.out.print("Enter announcement: ");
                    String message = sc.nextLine();
                    SchoolData.getAnnouncements().add(new Announcement(message));
                    SchoolData.saveAnnouncements();
                    System.out.println("Announcement added.");
                }
                case 11 -> 
                {
                    System.out.print("Enter message to remove: ");
                    String message = sc.nextLine();
                    SchoolData.getAnnouncements().removeIf(a -> a.getMessage().equalsIgnoreCase(message));
                    SchoolData.saveAnnouncements();
                    System.out.println("Announcement removed.");
                }
                case 0 -> 
                {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}