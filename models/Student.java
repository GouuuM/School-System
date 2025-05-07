package models;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utility.FileManager;

public class Student extends User
{
    private String name;
    private String id;
    private List<Assignment> assignments;

    public Student(String username, String password)
    {
        super(username, password);
        this.name = "N/A";
        this.id = "N/A";
        this.assignments = new ArrayList<>();
    }

    public Student(String name, String id, String username, String password)
    {
        super(username, password);
        this.name = name;
        this.id = id;
        this.assignments = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getId() { return id; }
    public List<Assignment> getAssignments() { return assignments; }

    public boolean handleChoice(int choice, Scanner scanner)
    {
        try
        {
            switch (choice)
            {
                case 1: FileManager.addEntry("subjects_" + getUsername() + ".txt", scanner, "Enter subject code: "); break;
                case 2: FileManager.addEntry("submitted_assignments_" + getUsername() + ".txt", scanner, "Enter your answer for assignment: "); break;
                case 3: FileManager.removeEntry("submitted_assignments_" + getUsername() + ".txt", scanner, "Enter assignment to remove: "); break;
                case 4: FileManager.viewFile("grades_" + getUsername() + ".txt"); break;
                case 5: FileManager.viewFile("lessonplans.txt"); break;
                case 6: FileManager.viewFile("announcements.txt"); break;
                case 7: FileManager.viewFile("grades_" + getUsername() + ".txt"); break;
                case 0: return false;
                default: System.out.println("Invalid choice."); break;
            }
        }
        catch (IOException e)
        {
            System.out.println("Error handling file: " + e.getMessage());
        }
        return true;
    }
}