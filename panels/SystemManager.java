package panels;
import java.util.Scanner;
import models.SchoolData;
import models.Student;
import models.Teacher;
import utility.FileManager;

public class SystemManager
{
    private Scanner sc = new Scanner(System.in);
    private Student loggedInStudent = null;
    private Teacher loggedInTeacher = null;

    public SystemManager()
    {
        SchoolData.loadStudents();
        SchoolData.loadAssignments();
        SchoolData.loadLessons();
        SchoolData.loadAnnouncements();
        SchoolData.loadGrades();
    }

    public void run()
    {
        while (true)
        {
            System.out.println("\nWelcome to the School System");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice)
            {
                case 1: register(); break;
                case 2: login(); break;
                case 0:
                    SchoolData.saveStudents();
                    SchoolData.saveAssignments();
                    SchoolData.saveLessons();
                    SchoolData.saveAnnouncements();
                    SchoolData.saveGrades();
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default: System.out.println("Invalid choice.");
            }

            if (loggedInStudent != null || loggedInTeacher != null)
            {
                break;
            }
        }

        if (loggedInStudent != null) 
        {
            StudentPanel.run(loggedInStudent, sc);
        } 
        else if (loggedInTeacher != null) 
        {
            TeacherPanel.run(loggedInTeacher, sc);
        }
    }

    private void register()
    {
        System.out.println("Register as:");
        System.out.println("1. Teacher");
        System.out.println("2. Student");
        System.out.print("Choice: ");
        int role = sc.nextInt();
        sc.nextLine();

        System.out.print("Choose a username: ");
        String username = sc.nextLine();
        System.out.print("Choose a password: ");
        String password = sc.nextLine();

        try
        {
            switch (role) 
            {
                case 1:
                    FileManager.addRawEntry("teachers.txt", username + "," + password);
                    System.out.println("Teacher registered successfully!");
                    break;
                case 2:
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter your student ID: ");
                    String id = sc.nextLine();
                    SchoolData.getStudents().add(new Student(name, id, username, password));
                    SchoolData.saveStudents(); // Save immediately after registration
                    System.out.println("Student registered successfully!");
                    break;
                default:
                    System.out.println("Invalid role.");
                    break;
            }
        }
        catch (Exception e)
        {
            System.out.println("Registration failed: " + e.getMessage());
        }
    }

    private void login()
    {
        System.out.println("Login as:");
        System.out.println("1. Teacher");
        System.out.println("2. Student");
        System.out.print("Choice: ");
        int role = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (role == 1)
        {
            loggedInTeacher = TeacherLogin.login(sc);
        }
        else if (role == 2)
        {
            loggedInStudent = StudentLogin.login(sc);
            if (loggedInStudent != null)
            {
                for (Student s : SchoolData.getStudents())
                {
                    if (s.getUsername().equals(loggedInStudent.getUsername()))
                    {
                        loggedInStudent = s;
                        break;
                    }
                }
            }
        } 
        else 
        {
            System.out.println("Invalid role.");
        }
    }

    private int menuTeacher()
    {
        System.out.println("\nTeacher Menu:");
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
        return sc.nextInt();
    }

    private int menuStudent()
    {
        System.out.println("\nStudent Menu:");
        System.out.println("1. Enroll in Subject");
        System.out.println("2. Answer Assignment");
        System.out.println("3. Remove Assignment");
        System.out.println("4. View Graded Assignments");
        System.out.println("5. View Lesson Plan");
        System.out.println("6. View Announcements");
        System.out.println("7. View Grades");
        System.out.println("0. Logout");
        System.out.print("Choice: ");
        return sc.nextInt();
    }
}