package com.university.records;

public class Leave {
    private int id;
    private String fromDate;
    private String toDate;
    private boolean isStudent;

    public Leave(int id, String fromDate, String toDate, boolean isStudent) {
        this.id = id;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.isStudent = isStudent;
    }

    public int getId() { return id; }
    public String getFromDate() { return fromDate; }
    public String getToDate() { return toDate; }
    public boolean isStudent() { return isStudent; }

    @Override
    public String toString() {
        return (isStudent ? "Roll No: " : "Employee ID: ") + id + 
               ", From: " + fromDate + ", To: " + toDate;
    }
}