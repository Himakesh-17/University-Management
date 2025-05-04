package com.university.management;

import com.university.records.Marks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ReportGenerator {
    private ArrayList<Marks> studentMarks;
    private String[] subjects;

    public ReportGenerator(ArrayList<Marks> studentMarks, String[] subjects) {
        this.studentMarks = studentMarks;
        this.subjects = subjects;
    }

    public void generateResults() {
        if (studentMarks.isEmpty()) {
            System.out.println("No marks available.");
            return;
        }
        Collections.sort(studentMarks, Comparator.comparingInt(Marks::getTotalMarks).reversed());

        System.out.println("\n=== Results ===");
        System.out.printf("%-10s%-10s", "Rank", "Roll No");
        for (String subject : subjects) System.out.printf("%-12s", subject);
        System.out.printf("%-10s%n", "Total");

        int rank = 1;
        for (Marks m : studentMarks) {
            System.out.printf("%-10d%-10d", rank++, m.getRollNo());
            for (int mark : m.getSubjectMarks()) System.out.printf("%-12d", mark);
            System.out.printf("%-10d%n", m.getTotalMarks());
        }
    }
}