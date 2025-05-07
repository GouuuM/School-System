package models;

import utility.FileManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SchoolData 
{
    public static List<Activity> activities = new ArrayList<>();
    public static List<Announcement> announcements = new ArrayList<>();
    public static List<Assignment> assignments = new ArrayList<>();
    public static List<Grade> grades = new ArrayList<>();
    public static List<LessonPlan> lessons = new ArrayList<>();
    public static List<Student> students = new ArrayList<>();

    private static final String STUDENTS_FILE = "students_data.txt";
    private static final String ASSIGNMENTS_FILE = "assignments_data.txt";
    private static final String LESSONS_FILE = "lessons_data.txt";
    private static final String ANNOUNCEMENTS_FILE = "announcements_data.txt";
    private static final String GRADES_FILE = "grades_data.txt";

    public static void loadStudents() 
    {
        students.clear();
        try 
        {
            List<String> lines = FileManager.readFile(STUDENTS_FILE);
            for (String line : lines) 
            {
                String[] parts = line.split(",");
                if (parts.length == 4) 
                {
                    students.add(new Student(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim()));
                }
            }
        } 
        catch (IOException e) 
        {
            System.err.println("Error loading students: " + e.getMessage());
        }
    }

    public static void saveStudents() 
    {
        List<String> lines = new ArrayList<>();
        for (Student student : students) 
        {
            lines.add(student.getName() + "," + student.getId() + "," + student.getUsername() + "," + student.getPassword());
        }
        try 
        {
            FileManager.writeFile(STUDENTS_FILE, lines);
        }
        catch (IOException e)
        {
            System.err.println("Error saving students: " + e.getMessage());
        }
    }

    public static void loadAssignments()
    {
        assignments.clear();
        try
        {
            List<String> lines = FileManager.readFile(ASSIGNMENTS_FILE);
            for (String line : lines)
            {
                String[] parts = line.split(",");
                if (parts.length == 2)
                {
                    assignments.add(new Assignment(parts[0].trim(), parts[1].trim()));
                }
            }
        }
        catch (IOException e)
        {
            System.err.println("Error loading assignments: " + e.getMessage());
        }
    }

    public static void saveAssignments()
    {
        List<String> lines = new ArrayList<>();
        for (Assignment assignment : assignments)
        {
            lines.add(assignment.getTitle() + "," + assignment.getDescription());
        }
        try
        {
            FileManager.writeFile(ASSIGNMENTS_FILE, lines);
        }
        catch (IOException e)
        {
            System.err.println("Error saving assignments: " + e.getMessage());
        }
    }

    public static void loadLessons() 
    {
        lessons.clear();
        try 
        {
            List<String> lines = FileManager.readFile(LESSONS_FILE);
            for (String line : lines)
            {
                String[] parts = line.split(",");
                if (parts.length == 2)
                {
                    lessons.add(new LessonPlan(parts[0].trim(), parts[1].trim()));
                }
            }
        }
        catch (IOException e)
        {
            System.err.println("Error loading lessons: " + e.getMessage());
        }
    }

    public static void saveLessons()
    {
        List<String> lines = new ArrayList<>();
        for (LessonPlan lesson : lessons)
        {
            lines.add(lesson.getTitle() + "," + lesson.getContent());
        }
        try 
        {
            FileManager.writeFile(LESSONS_FILE, lines);
        }
        catch (IOException e)
        {
            System.err.println("Error saving lessons: " + e.getMessage());
        }
    }

    public static void loadAnnouncements() 
    {
        announcements.clear();
        try 
        {
            List<String> lines = FileManager.readFile(ANNOUNCEMENTS_FILE);
            for (String line : lines) 
            {
                announcements.add(new Announcement(line.trim()));
            }
        } 
        catch (IOException e) 
        {
            System.err.println("Error loading announcements: " + e.getMessage());
        }
    }

    public static void saveAnnouncements() 
    {
        try 
        {
            List<String> lines = new ArrayList<>();
            for (Announcement announcement : announcements) 
            {
                lines.add(announcement.getMessage());
            }
            FileManager.writeFile(ANNOUNCEMENTS_FILE, lines);
        } 
        catch (IOException e) 
        {
            System.err.println("Error saving announcements: " + e.getMessage());
        }
    }

    public static void loadGrades() 
    {
        grades.clear();
        try 
        {
            List<String> lines = FileManager.readFile(GRADES_FILE);
            for (String line : lines) 
            {
                String[] parts = line.split(",");
                if (parts.length == 2) 
                {
                    grades.add(new Grade(parts[0].trim(), parts[1].trim()));
                }
            }
        } 
        catch (IOException e) 
        {
            System.err.println("Error loading grades: " + e.getMessage());
        }
    }

    // Save grade data
    public static void saveGrades() 
    {
        List<String> lines = new ArrayList<>();
        for (Grade grade : grades) 
        {
            lines.add(grade.getStudentId() + "," + grade.getScore());
        }
        try 
        {
            FileManager.writeFile(GRADES_FILE, lines);
        } 
        catch (IOException e) 
        {
            System.err.println("Error saving grades: " + e.getMessage());
        }
    }

    public static Student findStudentById(String id) 
    {
        for (Student student : students) 
        {
            if (student.getId().equals(id)) 
            {
                return student;
            }
        }
        return null;
    }

    public static List<Student> getStudents() 
    {
        return students;
    }

    public static List<Assignment> getAssignments() 
    {
        return assignments;
    }

    public static List<LessonPlan> getLessons() 
    {
        return lessons;
    }

    public static List<Announcement> getAnnouncements() 
    {
        return announcements;
    }

    public static List<Grade> getGrades() 
    {
        return grades;
    }
}