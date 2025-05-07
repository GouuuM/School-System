package panels;
import java.util.Scanner;
import models.Teacher;
import utility.FileManager;

public class TeacherLogin
{
    public static Teacher login(Scanner sc)
    {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        try
        {
            if (FileManager.validateCredentials("teachers.txt", username, password))
            {
                return new Teacher(username, password);
            }
            else
            {
                System.out.println("Invalid credentials.");
                return null;
            }
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}