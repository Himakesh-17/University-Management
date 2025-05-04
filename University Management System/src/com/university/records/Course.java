package com.university.records;

public class Course {
    private String courseCode;
    private String courseName;
    private int credits;

    public Course(String courseCode, String courseName, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }

    public String getCourseCode() { return courseCode; }
    public String getCourseName() { return courseName; }
    public int getCredits() { return credits; }

    @Override
    public String toString() {
        return "Code: " + courseCode + ", Name: " + courseName + ", Credits: " + credits;
    }
}