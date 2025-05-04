package com.university.people;

import com.university.interfaces.Person;

public abstract class BasePerson implements Person {
    private String name;
    private String dateOfBirth;
    private String address;
    private String emailId;

    public BasePerson(String name, String dateOfBirth, String address, String emailId) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.emailId = emailId;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getEmailId() { return emailId; }
    public void setEmailId(String emailId) { this.emailId = emailId; }

    public abstract String getRole();

    @Override
    public String getDetails() {
        return "Name: " + name + "\nDate of Birth: " + dateOfBirth + 
               "\nAddress: " + address + "\nEmail: " + emailId;
    }
}