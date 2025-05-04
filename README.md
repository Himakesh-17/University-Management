<h2>University Management System</h2><br>
<h3>Overview</h3><br>
The University Management System is a Java-based desktop application designed to streamline university administration tasks. Built using Java Swing for the graphical user interface (GUI), this project allows users to manage students, teachers, administrators, courses, leave applications, and student marks efficiently. It leverages object-oriented programming (OOP) principles such as abstraction, encapsulation, and inheritance to create a modular and maintainable system.
The system provides a centralized platform to add, update, and view records, apply for leaves, enter marks, generate performance reports, and manage course details—all through an intuitive GUI. Custom exceptions ensure robust error handling, making the application reliable for real-world use.
Features<br>
<br>
Personnel Management: Add, update, and view details for students, teachers, and admins.<br>
Leave Management: Apply for and view leave applications for students and teachers.<br>
Academic Records: Enter and view student marks, calculate totals, and generate ranked results.<br>
Course Management: View available courses with details like course code, name, and credits.<br>
Error Handling: Custom exceptions (InvalidInputException, PersonNotFoundException) for invalid inputs and missing records.<br>
GUI: User-friendly interface with 12 interactive buttons for various operations.<br>
<br>
<h3>Project Structure</h3><br>
The project is organized into packages for modularity:<br>
<br>
com.university.interfaces: Contains the Person interface.<br>
com.university.people: Includes BasePerson, Student, Teacher, and Admin classes.<br>
com.university.records: Houses Marks, Leave, and Course classes.<br>
com.university.exceptions: Defines InvalidInputException and PersonNotFoundException.<br>
com.university.management: Contains the main UniversityManagementSystem class and ReportGenerator.<br>
<br>
Key relationships:<br>
<br>
Inheritance: Student, Teacher, and Admin inherit from BasePerson.<br>
Interface Realization: BasePerson implements the Person interface.<br>
Aggregation: UniversityManagementSystem manages collections of Student, Leave, Marks, etc.<br>
Association: Marks links to Student via rollNo, Leave to Student/Teacher via id.<br>
<br>
Prerequisites<br>
To run this project, ensure you have the following installed:<br>
<br>
Java Development Kit (JDK): Version 8 or higher.<br>
Integrated Development Environment (IDE): Eclipse, IntelliJ IDEA, or any Java-supporting IDE (optional but recommended).<br>
Git: For cloning the repository.<br>
<br>
Open the Project:<br>
Run the application:java com.university.management.UniversityManagementSystem<br>
Alternatively, run via your IDE by executing the UniversityManagementSystem class.<br>
<br>
Interact with Features:<br>
<br>
Add Student: Input details like name, father’s name, percentages, course, and branch. Percentages are validated (0-100).<br>
Enter Marks: Select a student by roll number, input marks for each subject (validated 0-100), and save.<br>
Apply Leave: Enter an ID, dates, and role (student/teacher) to apply for leave.<br>
View Results: Generate a ranked table of student marks using ReportGenerator.<br>
View Courses: Display available courses with their details.<br>
<br>
Error Handling:<br>
<br>
Invalid inputs (e.g., negative marks) trigger error dialogs with clear messages.<br>
Missing records (e.g., non-existent student) are flagged with appropriate errors.<br>
<br>
Code Highlights<br>
<br>
OOP Principles:<br>
Abstraction: Via BasePerson (abstract class) and Person (interface).<br>
Encapsulation: Private attributes with public getters/setters (e.g., Student’s rollNo).<br>
Inheritance: Student, Teacher, and Admin inherit from BasePerson.<br>
<br>
Error Handling:<br>
Custom exceptions ensure robust validation (e.g., throw new InvalidInputException("Marks must be between 0 and 100.");).<br>
GUI: Built with Java Swing (JFrame, JOptionPane) for user interaction.<br>
