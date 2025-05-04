package com.university.people;

public class Student extends BasePerson {
    private final int rollNo;
    private String fatherName;
    private double class10thPercentage;
    private double class12thPercentage;
    private String course;
    private String branch;
    private static int rollCounter = 1000;

    public Student(String name, String fatherName, String dateOfBirth, String address, 
                   String emailId, double class10thPercentage, double class12thPercentage, 
                   String course, String branch) {
        super(name, dateOfBirth, address, emailId);
        this.rollNo = ++rollCounter;
        this.fatherName = fatherName;
        this.class10thPercentage = class10thPercentage;
        this.class12thPercentage = class12thPercentage;
        this.course = course;
        this.branch = branch;
    }

    public int getRollNo() { return rollNo; }
    public String getFatherName() { return fatherName; }
    public void setFatherName(String fatherName) { this.fatherName = fatherName; }
    public double getClass10thPercentage() { return class10thPercentage; }
    public void setClass10thPercentage(double class10thPercentage) { this.class10thPercentage = class10thPercentage; }
    public double getClass12thPercentage() { return class12thPercentage; }
    public void setClass12thPercentage(double class12thPercentage) { this.class12thPercentage = class12thPercentage; }
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }

    @Override
    public String getRole() { return "Student"; }

    @Override
    public String getDetails() {
        return "Roll No: " + rollNo + "\n" + super.getDetails() + 
               "\nFather's Name: " + fatherName + "\nClass 10th %: " + class10thPercentage + 
               "\nClass 12th %: " + class12thPercentage + "\nCourse: " + course + 
               "\nBranch: " + branch + "\n";
    }
}