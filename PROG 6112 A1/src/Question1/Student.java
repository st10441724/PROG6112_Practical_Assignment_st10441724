
package Question1;


// Student class to encapsulate student information
public class Student {
    
    // Private fields to store student details
    private String id;       // Unique identifier for the student
    private String name;     // Student's name
    private int age;         // Student's age
    private String email;    // Student's email address
    private String course;   // Course the student is enrolled in

    // Constructor to initialize the Student object with provided details
    public Student(String id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    // Getter methods to retrieve the private fields
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
}

     
   
   

    
    

    
    


