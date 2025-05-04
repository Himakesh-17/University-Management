package com.university.management;

import com.university.people.Student;
import com.university.people.Teacher;
import com.university.people.Admin;
import com.university.records.Leave;
import com.university.records.Marks;
import com.university.records.Course;
import com.university.exceptions.InvalidInputException;
import com.university.exceptions.PersonNotFoundException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UniversityManagementSystem extends JFrame {
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Teacher> teachers = new ArrayList<>();
    private static ArrayList<Admin> admins = new ArrayList<>();
    private static ArrayList<Leave> leaves = new ArrayList<>();
    private static ArrayList<Marks> studentMarks = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();
    private static String[] subjects = {"Math", "Physics", "Chemistry", "English", "Programming"};

    public UniversityManagementSystem() {
        // Initialize default data
        initializeDefaultData();

        // Set up the JFrame
        setTitle("University Management System");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Main panel with GridLayout
        JPanel panel = new JPanel(new GridLayout(12, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Buttons for each operation
        JButton addStudentBtn = new JButton("Add Student");
        JButton addTeacherBtn = new JButton("Add Teacher");
        JButton viewStudentBtn = new JButton("View Student Details");
        JButton viewTeacherBtn = new JButton("View Teacher Details");
        JButton updateStudentBtn = new JButton("Update Student Details");
        JButton updateTeacherBtn = new JButton("Update Teacher Details");
        JButton applyLeaveBtn = new JButton("Apply Leave");
        JButton viewLeaveBtn = new JButton("View On-Leave Details");
        JButton enterMarksBtn = new JButton("Enter Marks");
        JButton viewResultsBtn = new JButton("View Results");
        JButton viewCoursesBtn = new JButton("View Courses");
        JButton exitBtn = new JButton("Exit");

        // Add buttons to panel
        panel.add(addStudentBtn);
        panel.add(addTeacherBtn);
        panel.add(viewStudentBtn);
        panel.add(viewTeacherBtn);
        panel.add(updateStudentBtn);
        panel.add(updateTeacherBtn);
        panel.add(applyLeaveBtn);
        panel.add(viewLeaveBtn);
        panel.add(enterMarksBtn);
        panel.add(viewResultsBtn);
        panel.add(viewCoursesBtn);
        panel.add(exitBtn);

        // Add panel to frame
        add(panel);

        // Action Listeners
        addStudentBtn.addActionListener(e -> addStudent());
        addTeacherBtn.addActionListener(e -> addTeacher());
        viewStudentBtn.addActionListener(e -> viewStudentDetails());
        viewTeacherBtn.addActionListener(e -> viewTeacherDetails());
        updateStudentBtn.addActionListener(e -> updateStudentDetails());
        updateTeacherBtn.addActionListener(e -> updateTeacherDetails());
        applyLeaveBtn.addActionListener(e -> applyLeave());
        viewLeaveBtn.addActionListener(e -> viewOnLeaveDetails());
        enterMarksBtn.addActionListener(e -> enterMarks());
        viewResultsBtn.addActionListener(e -> new ReportGenerator(studentMarks, subjects).generateResults());
        viewCoursesBtn.addActionListener(e -> viewCourses());
        exitBtn.addActionListener(e -> System.exit(0));
    }

    private void initializeDefaultData() {
        students.add(new Student("John Doe", "Michael Doe", "15-05-2000", "123 Main St", 
                "john@example.com", 85.5, 90.0, "B.Tech", "CS"));
        students.add(new Student("Jane Smith", "Robert Smith", "20-08-2001", "456 Oak St", 
                "jane@example.com", 88.0, 92.5, "B.Tech", "ECE"));
        students.add(new Student("Alice Brown", "David Brown", "10-03-2002", "789 Pine St", 
                "alice@example.com", 90.0, 87.5, "B.Sc", "Physics"));
        students.add(new Student("Bob Wilson", "James Wilson", "25-12-2000", "321 Elm St", 
                "bob@example.com", 82.0, 85.0, "B.Tech", "ME"));

        teachers.add(new Teacher("Dr. Smith", "01-01-1970", "111 Univ St", "smith@univ.com", 
                "PhD", "CS"));
        teachers.add(new Teacher("Prof. Jones", "15-06-1975", "222 Acad St", "jones@univ.com", 
                "M.Tech", "ECE"));
        teachers.add(new Teacher("Dr. Taylor", "20-09-1965", "333 Learn St", "taylor@univ.com", 
                "PhD", "Physics"));
        teachers.add(new Teacher("Prof. Davis", "10-11-1980", "444 Teach St", "davis@univ.com", 
                "M.Sc", "ME"));

        admins.add(new Admin("Admin One", "01-01-1985", "555 Admin St", "admin1@univ.com", "Registrar"));
        admins.add(new Admin("Admin Two", "02-02-1980", "666 Admin St", "admin2@univ.com", "HR"));

        courses.add(new Course("CS101", "Intro to Programming", 4));
        courses.add(new Course("PHY201", "Classical Mechanics", 3));
    }

    private void addStudent() {
        try {
            JTextField nameField = new JTextField(20);
            JTextField fatherNameField = new JTextField(20);
            JTextField dobField = new JTextField(20);
            JTextField addressField = new JTextField(20);
            JTextField emailField = new JTextField(20);
            JTextField class10Field = new JTextField(5);
            JTextField class12Field = new JTextField(5);
            JTextField courseField = new JTextField(20);
            JTextField branchField = new JTextField(20);

            JPanel panel = new JPanel(new GridLayout(9, 2));
            panel.add(new JLabel("Name:")); panel.add(nameField);
            panel.add(new JLabel("Father's Name:")); panel.add(fatherNameField);
            panel.add(new JLabel("Date of Birth (DD-MM-YYYY):")); panel.add(dobField);
            panel.add(new JLabel("Address:")); panel.add(addressField);
            panel.add(new JLabel("Email ID:")); panel.add(emailField);
            panel.add(new JLabel("Class 10th %:")); panel.add(class10Field);
            panel.add(new JLabel("Class 12th %:")); panel.add(class12Field);
            panel.add(new JLabel("Course:")); panel.add(courseField);
            panel.add(new JLabel("Branch:")); panel.add(branchField);

            int result = JOptionPane.showConfirmDialog(this, panel, "Add Student", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                double class10 = Double.parseDouble(class10Field.getText());
                double class12 = Double.parseDouble(class12Field.getText());
                if (class10 < 0 || class10 > 100 || class12 < 0 || class12 > 100) 
                    throw new InvalidInputException("Percentage must be between 0 and 100.");
                Student s = new Student(nameField.getText(), fatherNameField.getText(), dobField.getText(), 
                        addressField.getText(), emailField.getText(), class10, class12, courseField.getText(), 
                        branchField.getText());
                students.add(s);
                JOptionPane.showMessageDialog(this, "Student added with Roll No: " + s.getRollNo());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addTeacher() {
        try {
            JTextField nameField = new JTextField(20);
            JTextField dobField = new JTextField(20);
            JTextField addressField = new JTextField(20);
            JTextField emailField = new JTextField(20);
            JTextField educationField = new JTextField(20);
            JTextField deptField = new JTextField(20);

            JPanel panel = new JPanel(new GridLayout(6, 2));
            panel.add(new JLabel("Name:")); panel.add(nameField);
            panel.add(new JLabel("Date of Birth (DD-MM-YYYY):")); panel.add(dobField);
            panel.add(new JLabel("Address:")); panel.add(addressField);
            panel.add(new JLabel("Email ID:")); panel.add(emailField);
            panel.add(new JLabel("Education:")); panel.add(educationField);
            panel.add(new JLabel("Department:")); panel.add(deptField);

            int result = JOptionPane.showConfirmDialog(this, panel, "Add Teacher", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                Teacher t = new Teacher(nameField.getText(), dobField.getText(), addressField.getText(), 
                        emailField.getText(), educationField.getText(), deptField.getText());
                teachers.add(t);
                JOptionPane.showMessageDialog(this, "Teacher added with Employee ID: " + t.getEmployeeId());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viewStudentDetails() {
        try {
            if (students.isEmpty()) throw new PersonNotFoundException("No students available.");
            StringBuilder rollNos = new StringBuilder("Available Roll Numbers:\n");
            for (Student s : students) rollNos.append(s.getRollNo()).append("\n");
            String rollNoStr = JOptionPane.showInputDialog(this, rollNos.toString(), "View Student", JOptionPane.PLAIN_MESSAGE);
            if (rollNoStr != null) {
                int rollNo = Integer.parseInt(rollNoStr);
                for (Student s : students) {
                    if (s.getRollNo() == rollNo) {
                        JOptionPane.showMessageDialog(this, s.getDetails(), "Student Details", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                throw new PersonNotFoundException("Student not found.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viewTeacherDetails() {
        try {
            if (teachers.isEmpty()) throw new PersonNotFoundException("No teachers available.");
            StringBuilder empIds = new StringBuilder("Available Employee IDs:\n");
            for (Teacher t : teachers) empIds.append(t.getEmployeeId()).append("\n");
            String empIdStr = JOptionPane.showInputDialog(this, empIds.toString(), "View Teacher", JOptionPane.PLAIN_MESSAGE);
            if (empIdStr != null) {
                int empId = Integer.parseInt(empIdStr);
                for (Teacher t : teachers) {
                    if (t.getEmployeeId() == empId) {
                        JOptionPane.showMessageDialog(this, t.getDetails(), "Teacher Details", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                throw new PersonNotFoundException("Teacher not found.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateStudentDetails() {
        try {
            if (students.isEmpty()) throw new PersonNotFoundException("No students available.");
            StringBuilder rollNos = new StringBuilder("Available Roll Numbers:\n");
            for (Student s : students) rollNos.append(s.getRollNo()).append("\n");
            String rollNoStr = JOptionPane.showInputDialog(this, rollNos.toString(), "Update Student", JOptionPane.PLAIN_MESSAGE);
            if (rollNoStr != null) {
                int rollNo = Integer.parseInt(rollNoStr);
                for (Student s : students) {
                    if (s.getRollNo() == rollNo) {
                        String[] options = {"Name", "Father's Name", "Date of Birth", "Address", "Email", 
                                            "Class 10th %", "Class 12th %", "Course", "Branch"};
                        String prop = (String) JOptionPane.showInputDialog(this, "Select property to update:", 
                                "Update Student", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                        if (prop != null) {
                            String newValue = JOptionPane.showInputDialog(this, "Enter new " + prop + ":");
                            switch (prop) {
                                case "Name": s.setName(newValue); break;
                                case "Father's Name": s.setFatherName(newValue); break;
                                case "Date of Birth": s.setDateOfBirth(newValue); break;
                                case "Address": s.setAddress(newValue); break;
                                case "Email": s.setEmailId(newValue); break;
                                case "Class 10th %": 
                                    double c10 = Double.parseDouble(newValue); 
                                    if (c10 < 0 || c10 > 100) throw new InvalidInputException("Percentage must be 0-100.");
                                    s.setClass10thPercentage(c10); break;
                                case "Class 12th %": 
                                    double c12 = Double.parseDouble(newValue); 
                                    if (c12 < 0 || c12 > 100) throw new InvalidInputException("Percentage must be 0-100.");
                                    s.setClass12thPercentage(c12); break;
                                case "Course": s.setCourse(newValue); break;
                                case "Branch": s.setBranch(newValue); break;
                            }
                            JOptionPane.showMessageDialog(this, "Student updated.");
                        }
                        return;
                    }
                }
                throw new PersonNotFoundException("Student not found.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTeacherDetails() {
        try {
            if (teachers.isEmpty()) throw new PersonNotFoundException("No teachers available.");
            StringBuilder empIds = new StringBuilder("Available Employee IDs:\n");
            for (Teacher t : teachers) empIds.append(t.getEmployeeId()).append("\n");
            String empIdStr = JOptionPane.showInputDialog(this, empIds.toString(), "Update Teacher", JOptionPane.PLAIN_MESSAGE);
            if (empIdStr != null) {
                int empId = Integer.parseInt(empIdStr);
                for (Teacher t : teachers) {
                    if (t.getEmployeeId() == empId) {
                        String[] options = {"Name", "Date of Birth", "Address", "Email", "Education", "Department"};
                        String prop = (String) JOptionPane.showInputDialog(this, "Select property to update:", 
                                "Update Teacher", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                        if (prop != null) {
                            String newValue = JOptionPane.showInputDialog(this, "Enter new " + prop + ":");
                            switch (prop) {
                                case "Name": t.setName(newValue); break;
                                case "Date of Birth": t.setDateOfBirth(newValue); break;
                                case "Address": t.setAddress(newValue); break;
                                case "Email": t.setEmailId(newValue); break;
                                case "Education": t.setEducation(newValue); break;
                                case "Department": t.setDepartment(newValue); break;
                            }
                            JOptionPane.showMessageDialog(this, "Teacher updated.");
                        }
                        return;
                    }
                }
                throw new PersonNotFoundException("Teacher not found.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void applyLeave() {
        try {
            String[] types = {"Student", "Teacher"};
            String type = (String) JOptionPane.showInputDialog(this, "Apply leave for:", "Apply Leave", 
                    JOptionPane.PLAIN_MESSAGE, null, types, types[0]);
            if (type != null) {
                if (type.equals("Student")) {
                    if (students.isEmpty()) throw new PersonNotFoundException("No students available.");
                    StringBuilder rollNos = new StringBuilder("Available Roll Numbers:\n");
                    for (Student s : students) rollNos.append(s.getRollNo()).append("\n");
                    String rollNoStr = JOptionPane.showInputDialog(this, rollNos.toString());
                    if (rollNoStr != null) {
                        int rollNo = Integer.parseInt(rollNoStr);
                        if (!studentExists(rollNo)) throw new PersonNotFoundException("Student not found.");
                        String from = JOptionPane.showInputDialog(this, "Enter From Date (DD-MM-YYYY):");
                        String to = JOptionPane.showInputDialog(this, "Enter To Date (DD-MM-YYYY):");
                        leaves.add(new Leave(rollNo, from, to, true));
                        JOptionPane.showMessageDialog(this, "Leave applied for student.");
                    }
                } else {
                    if (teachers.isEmpty()) throw new PersonNotFoundException("No teachers available.");
                    StringBuilder empIds = new StringBuilder("Available Employee IDs:\n");
                    for (Teacher t : teachers) empIds.append(t.getEmployeeId()).append("\n");
                    String empIdStr = JOptionPane.showInputDialog(this, empIds.toString());
                    if (empIdStr != null) {
                        int empId = Integer.parseInt(empIdStr);
                        if (!teacherExists(empId)) throw new PersonNotFoundException("Teacher not found.");
                        String from = JOptionPane.showInputDialog(this, "Enter From Date (DD-MM-YYYY):");
                        String to = JOptionPane.showInputDialog(this, "Enter To Date (DD-MM-YYYY):");
                        leaves.add(new Leave(empId, from, to, false));
                        JOptionPane.showMessageDialog(this, "Leave applied for teacher.");
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viewOnLeaveDetails() {
        if (leaves.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No one is on leave.");
            return;
        }
        String[] types = {"Students", "Teachers"};
        String type = (String) JOptionPane.showInputDialog(this, "View on-leave details for:", "View Leave", 
                JOptionPane.PLAIN_MESSAGE, null, types, types[0]);
        if (type != null) {
            StringBuilder result = new StringBuilder("On-Leave Details:\n");
            boolean found = false;
            for (Leave leave : leaves) {
                if (type.equals("Students") && leave.isStudent()) {
                    result.append(leave).append("\n");
                    found = true;
                } else if (type.equals("Teachers") && !leave.isStudent()) {
                    result.append(leave).append("\n");
                    found = true;
                }
            }
            if (!found) result.append("No ").append(type.toLowerCase()).append(" are on leave.");
            JOptionPane.showMessageDialog(this, result.toString());
        }
    }

    private void enterMarks() {
        try {
            if (students.isEmpty()) throw new PersonNotFoundException("No students available.");
            StringBuilder rollNos = new StringBuilder("Available Roll Numbers:\n");
            for (Student s : students) rollNos.append(s.getRollNo()).append("\n");
            String rollNoStr = JOptionPane.showInputDialog(this, rollNos.toString(), "Enter Marks", JOptionPane.PLAIN_MESSAGE);
            if (rollNoStr != null) {
                int rollNo = Integer.parseInt(rollNoStr);
                if (!studentExists(rollNo)) throw new PersonNotFoundException("Student not found.");
                int[] marks = new int[subjects.length];
                JPanel panel = new JPanel(new GridLayout(subjects.length, 2));
                JTextField[] markFields = new JTextField[subjects.length];
                for (int i = 0; i < subjects.length; i++) {
                    markFields[i] = new JTextField(5);
                    panel.add(new JLabel(subjects[i] + ":"));
                    panel.add(markFields[i]);
                }
                int result = JOptionPane.showConfirmDialog(this, panel, "Enter Marks for Roll No " + rollNo, 
                        JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    for (int i = 0; i < subjects.length; i++) {
                        marks[i] = Integer.parseInt(markFields[i].getText());
                        if (marks[i] < 0 || marks[i] > 100) 
                            throw new InvalidInputException("Marks must be between 0 and 100.");
                    }
                    studentMarks.add(new Marks(rollNo, marks));
                    JOptionPane.showMessageDialog(this, "Marks entered successfully.");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viewCourses() {
        if (courses.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No courses available.");
            return;
        }
        StringBuilder courseList = new StringBuilder("Available Courses:\n");
        for (Course c : courses) courseList.append(c).append("\n");
        JOptionPane.showMessageDialog(this, courseList.toString());
    }

    private boolean studentExists(int rollNo) {
        for (Student s : students) if (s.getRollNo() == rollNo) return true;
        return false;
    }

    private boolean teacherExists(int empId) {
        for (Teacher t : teachers) if (t.getEmployeeId() == empId) return true;
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UniversityManagementSystem().setVisible(true));
    }
}