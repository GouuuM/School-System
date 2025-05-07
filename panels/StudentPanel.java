package panels;

import models.Student;
import java.util.Scanner;
import utility.FileManager;
import models.SchoolData;

public class StudentPanel 
{
    public static void run(Student student, Scanner sc) 
    {
        while (true) 
        {
            System.out.println("\n--- Student Panel ---");
            System.out.println("Welcome, " + student.getUsername() + "!");
            System.out.println("1. Enroll in Subject");
            System.out.println("2. Answer Assignment");
            System.out.println("3. Remove Assignment");
            System.out.println("4. View Graded Assignments");
            System.out.println("5. View Lesson Plan");
            System.out.println("6. View Announcements");
            System.out.println("7. View Grades");
            System.out.println("0. Logout");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            // Need mo tulad sa TeacherPanel have fun :D
        }
    }
}