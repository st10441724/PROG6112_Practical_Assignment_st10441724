
package Question1;


import java.util.ArrayList;
import javax.swing.JOptionPane;

// This class represents a Student with relevant details
class Student {
    private final String id;  // Unique identifier for the student
    private final String name;  // Name of the student
    private final int age;  // Age of the student
    private final String email;  // Email address of the student
    private final String course;  // Course the student is enrolled in
    private String captureStudentMessage; // (Note: This field isn't used, consider removing it)

    // Constructor to initialize the student object with the provided details
    public Student(String id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    // Getter methods to access the private fields
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    // Override the toString method to provide a string representation of the student
    @Override
    public String toString() {
        return "Student ID: " + id + "\nName: " + name + "\nAge: " + age + "\nEmail: " + email + "\nCourse: " + course;
    }
}

// Main class to manage student records
public class StudentManagement {
    // ArrayList to store the student objects
    private static ArrayList<Student> students = new ArrayList<>();

    // Main method to start the program
    public static void main(String[] args) {
        // Loop to keep showing the start menu
        while (true) {
            String startMessage = "STUDENT MANAGEMENT APPLICATION\n" +
                                  "********************************\n" +
                                  "Enter (1) to launch menu or any other key to exit";
            String userInput = JOptionPane.showInputDialog(startMessage);

            // Exit the application if user doesn't enter '1'
            if (userInput == null || !userInput.equals("1")) {
                JOptionPane.showMessageDialog(null, "Exiting application...");
                return;
            }

            // Loop to keep showing the main menu until user chooses to exit
            while (true) {
                String[] options = {"Capture a new student", "Search for a student", "Delete a student", "Print student report", "Exit Application"};
                int choice = JOptionPane.showOptionDialog(null, "Please select one of the following menu items:", 
                                                          "Main Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
                                                          null, options, options[0]);

                //Code Attribution
                //This method was taken from Youtube
                //https://www.youtube.com/watch?v=wcwWlasmLWs&t=9s
                //Neso Academy  
                // Handle user's choice by calling appropriate methods
                switch (choice) {
                    case 0:
                        captureStudent();  // Capture a new student
                        break;
                    case 1:
                        searchStudent();  // Search for an existing student
                        break;
                    case 2:
                        deleteStudent();  // Delete an existing student
                        break;
                    case 3:
                        viewReport();  // View a report of all students
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Exiting application...");  // Exit the application
                        return;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");  // Handle invalid input
                }
            }
        }
    }

    //Code Attribution
    //This method was taken from Youtube
    //https://www.youtube.com/watch?v=I90_qA7wxYw
    //Bill Barnum
    // Method to capture a new student and add to the list
    private static void captureStudent() {
        String id = JOptionPane.showInputDialog("Enter the student ID:");
        String name = JOptionPane.showInputDialog("Enter the student name:");

        int age = 0;
        // Loop to ensure valid age input (age >= 16)
        while (true) {
            try {
                age = Integer.parseInt(JOptionPane.showInputDialog("Enter the student age:"));
                if (age >= 16) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "You have entered an incorrect student age!!! \nPlease re-enter the student age >>");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
            }
        }

        String email = JOptionPane.showInputDialog("Enter the student email:");
        String course = JOptionPane.showInputDialog("Enter the student course:");

        // Add the new student to the list
        students.add(new Student(id, name, age, email, course));
        JOptionPane.showMessageDialog(null, "Student details have been successfully saved.");
    }

    // Method to search for a student by ID
    private static void searchStudent() {
        String id = JOptionPane.showInputDialog("Enter the student ID to search:");
        
        // Loop through the student list to find the matching ID
        for (Student student : students) {
            if (student.getId().equals(id)) {
                // Build a detailed result string if student is found
                StringBuilder result = new StringBuilder();
                result.append("Enter the student ID to search: ").append(id).append("\n\n")
                      .append("--------------------------------------------------\n")
                      .append("STUDENT ID: ").append(student.getId()).append("\n")
                      .append("STUDENT NAME: ").append(student.getName()).append("\n")
                      .append("STUDENT AGE: ").append(student.getAge()).append("\n")
                      .append("STUDENT EMAIL: ").append(student.getEmail()).append("\n")
                      .append("STUDENT COURSE: ").append(student.getCourse()).append("\n")
                      .append("--------------------------------------------------\n\n")
                      .append("Enter (1) to launch menu or any other key to exit");
                JOptionPane.showMessageDialog(null, result.toString());
                return;  // Exit method once the student is found
            }
        }
        
        
         //Code Attribution
         //This method was taken from StackOverflow
         //https://stackoverflow.com/questions/5082452/string-formatting-vs-format-vs-f-string-literal
         //Karl Knechtel
         // Show a not-found message if no matching student is found
        String notFoundMessage = String.format(
            "----------------------------------\n" +
            "Student with Student Id: %s was not found!\n" +
            "----------------------------------",
            id
        );
        JOptionPane.showMessageDialog(null, notFoundMessage);
    }

    // Method to delete a student by ID
    private static void deleteStudent() {
        String id = JOptionPane.showInputDialog("Enter the student id to delete:");

        // Search for the student by ID
        Student studentToDelete = null;
        for (Student student : students) {
            if (student.getId().equals(id)) {
                studentToDelete = student;
                break;
            }
        }

        if (studentToDelete != null) {
            String confirmation = JOptionPane.showInputDialog("Are you sure you want to delete student " + id + " from the system? Yes (y) to delete.");
            
            if (confirmation != null && confirmation.equalsIgnoreCase("y")) {
                students.remove(studentToDelete);  // Remove the student from the list
                JOptionPane.showMessageDialog(null, 
                    "----------------------------------------------\n" +
                    "Student with Student Id: " + id + " WAS deleted!\n" +
                    "----------------------------------------------\n" +
                    "Enter (1) to launch menu or any other key to exit");
            } else {
                JOptionPane.showMessageDialog(null, "Deletion cancelled.");
            }
        } else {
            JOptionPane.showMessageDialog(null, 
                "----------------------------------------------\n" +
                "Student with Student Id: " + id + " was not found!\n" +
                "----------------------------------------------\n" +
                "Enter (1) to launch menu or any other key to exit");
        }
    }
    
    
    //Code Attribution
    //This method was taken from Netbeans
    //https://chatgpt.com/c/02d5cf4b-4f43-4996-b60d-756259cca036
    // Method to view a report of all students
    private static void viewReport() {
        StringBuilder report = new StringBuilder("STUDENT REPORT\n**************\n");

        // Check if the student list is empty
        if (students.isEmpty()) {
            report.append("No students available.");
        } else {
            int count = 1;
            // Loop through the students and build the report
            for (Student student : students) {
                report.append("STUDENT ").append(count).append("\n")
                      .append("-------------------------\n")
                      .append("STUDENT ID: ").append(student.getId()).append("\n")
                      .append("STUDENT NAME: ").append(student.getName()).append("\n")
                      .append("STUDENT AGE: ").append(student.getAge()).append("\n")
                      .append("STUDENT EMAIL: ").append(student.getEmail()).append("\n")
                      .append("STUDENT COURSE: ").append(student.getCourse()).append("\n\n");
                count++;
            }
        }
        JOptionPane.showMessageDialog(null, report.toString());
    }
}

