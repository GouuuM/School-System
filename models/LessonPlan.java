package models;

public class LessonPlan
{
    private String title;
    private String content;

    public LessonPlan(String title, String content) 
    {
        this.title = title;
        this.content = content;
    }

    public String getTitle() 
    {
        return title;
    }

    public String getContent() 
    {
        return content;
    }

    public void setContent(String content) 
    {
        this.content = content;
    }

    @Override
    public String toString() 
    {
        return "Lesson: " + title + "\nContent: " + content;
    }
}