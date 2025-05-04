package com.university.people;

public class Admin extends BasePerson {
    private final int adminId;
    private String role;
    private static int adminCounter = 9000;

    public Admin(String name, String dateOfBirth, String address, String emailId, String role) {
        super(name, dateOfBirth, address, emailId);
        this.adminId = ++adminCounter;
        this.role = role;
    }

    public int getAdminId() { return adminId; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    @Override
    public String getDetails() {
        return "Admin ID: " + adminId + "\n" + super.getDetails() + "\nRole: " + role + "\n";
    }
}