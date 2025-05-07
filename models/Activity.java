package models;
public class Activity
{
    private String title;
    private String instructions;
    private String answer;
    private String grade;

    public Activity(String title, String instructions)
    {
        this.title = title;
        this.instructions = instructions;
    }

    public String getTitle() { return title; }
    public String getDescription() { return instructions; }
    public void setAnswer(String answer) { this.answer = answer; }
    public void setGrade(String grade) { this.grade = grade; }
    public String getGrade() { return grade; }
}