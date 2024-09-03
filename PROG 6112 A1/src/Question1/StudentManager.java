
package Question1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

//Code Attribution
//This method was taken from ChatGBT
//https://chatgpt.com/c/99bb3495-8ad9-4044-9d47-2af236d0409c
public class StudentManager {
     private ArrayList<Student> students = new ArrayList<>();

    public void saveStudent(String id, String name, int age, String email, String course) {
        students.add(new Student(id, name, age, email, course));
    }

    public Student searchStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public boolean deleteStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    public void studentReport() {
        StringBuilder report = new StringBuilder();
        if (students.isEmpty()) {
            report.append("No students available.");
        } else {
            int count = 1;
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
      


      // Method to validate student age
      // Overloaded method to validate age from an integer
    public boolean isAgeValid(Object input) {
        if (input instanceof Integer) {
            int age = (Integer) input;
            return age >= 16;  // Assuming 16 is the minimum valid age
        } else if (input instanceof String) {
            try {
                int age = Integer.parseInt((String) input);
                return age >= 16;
            } catch (NumberFormatException e) {
                return false;  // Invalid string input
            }
        }
        return false;  // If the input is neither an Integer nor a String
    }
}




  
    

   

    


    


