package com.university.records;

public class Marks {
    private int rollNo;
    private int[] subjectMarks;
    private int totalMarks;

    public Marks(int rollNo, int[] subjectMarks) {
        this.rollNo = rollNo;
        this.subjectMarks = subjectMarks;
        this.totalMarks = calculateTotal();
    }

    private int calculateTotal() {
        int sum = 0;
        for (int mark : subjectMarks) sum += mark;
        return sum;
    }

    public int getRollNo() { return rollNo; }
    public int[] getSubjectMarks() { return subjectMarks; }
    public int getTotalMarks() { return totalMarks; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Roll No: " + rollNo + " | Marks: ");
        for (int mark : subjectMarks) sb.append(mark + " ");
        sb.append("| Total: " + totalMarks);
        return sb.toString();
    }
}