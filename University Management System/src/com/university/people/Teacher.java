package com.university.people;

public class Teacher extends BasePerson {
    private final int employeeId;
    private String education;
    private String department;
    private static int idCounter = 5000;

    public Teacher(String name, String dateOfBirth, String address, String emailId, 
                   String education, String department) {
        super(name, dateOfBirth, address, emailId);
        this.employeeId = ++idCounter;
        this.education = education;
        this.department = department;
    }

    public int getEmployeeId() { return employeeId; }
    public String getEducation() { return education; }
    public void setEducation(String education) { this.education = education; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public String getRole() { return "Teacher"; }

    @Override
    public String getDetails() {
        return "Employee ID: " + employeeId + "\n" + super.getDetails() + 
               "\nEducation: " + education + "\nDepartment: " + department + "\n";
    }
}