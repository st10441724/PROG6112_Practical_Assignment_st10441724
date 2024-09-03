
package Question1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



/**
 * Unit test class for StudentManager.
 * This class tests various operations related to student management,
 * such as saving, searching, and deleting students, and validating student age.
 */
public class StudentManagerTest {
    
    private StudentManager studentManager;

    @BeforeClass
    public static void setUpClass() {
        
    }

    @AfterClass
    public static void tearDownClass() {
        
    }

    @Before
    public void setUp() {
        
        studentManager = new StudentManager();
    }

    @After
    public void tearDown() {
        
    }

    @Test
    public void testSaveStudent() {
        // Test saving a student and then verifying that the student was saved correctly
        studentManager.saveStudent("101", "John Doe", 20, "john.doe@example.com", "Software Development");
        
        // Retrieve the student by ID
        Student student = studentManager.searchStudent("101");
        
        // Assert that the student is not null and the details match what was saved
        Assert.assertNotNull(student);
        Assert.assertEquals("101", student.getId());
        Assert.assertEquals("John Doe", student.getName());
        Assert.assertEquals(20, student.getAge());
        Assert.assertEquals("john.doe@example.com", student.getEmail());
        Assert.assertEquals("Software Development", student.getCourse());
    }

    @Test
    public void testSearchStudent() {
        // Test searching for a student by saving one and retrieving it by ID
        studentManager.saveStudent("102", "Jane Smith", 22, "jane.smith@example.com", "Information Management");
        
        // Search for the student
        Student student = studentManager.searchStudent("102");
        
        // Assert that the student exists and the details are correct
        Assert.assertNotNull(student);
        Assert.assertEquals("102", student.getId());
        Assert.assertEquals("Jane Smith", student.getName());
        Assert.assertEquals(22, student.getAge());
        Assert.assertEquals("jane.smith@example.com", student.getEmail());
        Assert.assertEquals("Information Management", student.getCourse());
    }

    @Test
    public void testSearchStudent_StudentNotFound() {
        // Test searching for a student that does not exist
        Student student = studentManager.searchStudent("999");
        
        // Assert that the result is null (student not found)
        Assert.assertNull(student);
    }

    @Test
    public void testDeleteStudent() {
        // Test deleting a student by saving one, deleting it, and ensuring it was deleted
        studentManager.saveStudent("103", "Alice Johnson", 19, "alice.johnson@example.com", "Mobile App Development");
        
        // Delete the student and verify that the deletion was successful
        boolean isDeleted = studentManager.deleteStudent("103");
        Assert.assertTrue(isDeleted);
        
        // Verify that the student no longer exists
        Student student = studentManager.searchStudent("103");
        Assert.assertNull(student);
    }

    @Test
    public void testDeleteStudent_StudentNotFound() {
        // Test deleting a student that does not exist
        boolean isDeleted = studentManager.deleteStudent("999");
        
        // Assert that the deletion was unsuccessful (returns false)
        Assert.assertFalse(isDeleted);
    }

    @Test
    public void testStudentAge_StudentAgeValid() {
        // Test validating a correct student age (valid age >= 16)
        boolean isValid = studentManager.isAgeValid(18);
        
        // Assert that the age is valid
        Assert.assertTrue(isValid);
    }

    @Test
    public void testStudentAge_StudentAgeInvalid() {
        // Test validating an invalid student age (less than 16)
        boolean isValid = studentManager.isAgeValid(15);
        
        // Assert that the age is invalid
        Assert.assertFalse(isValid);
    }

    @Test
    public void testStudentAge_StudentAgeInvalidCharacter() {
        // Test validating an invalid input (non-integer string)
        boolean isValid = studentManager.isAgeValid("abc");
        
        // Assert that the input is invalid (should return false because "abc" is not a valid integer)
        Assert.assertFalse(isValid);
    }
}



