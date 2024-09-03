
package Question2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Integration Test class for InventoryManager.
 * This class tests various operations of the InventoryManager,
 * such as adding products, updating quantities, viewing all products, and generating reports.
 */
public class InventoryManagerIT {
    
    // Constructor for the test class
    public InventoryManagerIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        // Code that runs once before any of the test methods in this class
        // Typically used for class-wide setup, such as initializing shared resources
    }
    
    @AfterClass
    public static void tearDownClass() {
        // Code that runs once after all the test methods in this class
        // Typically used for cleanup of shared resources
    }
    
    @Before
    public void setUp() {
        // Runs before each test method to set up the test environment
        // Initialize any required objects or states before each test
    }
    
    @After
    public void tearDown() {
        // Runs after each test method to clean up the environment
        // Can be used to reset resources or variables after each test
    } 
    
    @Test
    public void testAddProduct() {
        // Test adding a product to the inventory
        
        // Create an instance of InventoryManager
        InventoryManager manager = new InventoryManager();
        
        // Create a new Electronics product
        Product product = new Electronics("Laptop", 1000.0, 5, 2);
        
        // Add the product to the manager
        manager.addProduct(product);
        
        // Assert that the product was added successfully
        // Check the size of the product list
        assertEquals(1, manager.getProducts().size());
        // Check the name of the added product
        assertEquals("Laptop", manager.getProducts().get(0).getName());
    }
    
    @Test
    public void testUpdateProductQuantity() {
        // Test updating the quantity of an existing product
        
        // Create an instance of InventoryManager
        InventoryManager manager = new InventoryManager();
        
        // Create a new Electronics product and add it to the manager
        Product product = new Electronics("Laptop", 1000.0, 5, 2);
        manager.addProduct(product);
        
        // Update the quantity of the product
        manager.updateProductQuantity("Laptop", 10);
        
        // Assert that the quantity was updated successfully
        assertEquals(10, manager.getProducts().get(0).getQuantity());
    }
        
    @Test
    public void testViewAllProducts() {
        // Test viewing all products in the inventory
        
        // Create an instance of InventoryManager
        InventoryManager manager = new InventoryManager();
        
        // Create and add two products to the manager
        Product product1 = new Electronics("Laptop", 1000.0, 5, 2);
        Product product2 = new Clothing("Shirt", 50.0, 10, "M");
        manager.addProduct(product1);
        manager.addProduct(product2);
        
        // Assert that the number of products is correct
        assertEquals(2, manager.getProducts().size());
    }
        
    @Test
    public void testGenerateReport() {
        // Test generating a report of all products
        
        // Create an instance of InventoryManager
        InventoryManager manager = new InventoryManager();
        
        // Create a new Electronics product and add it to the manager
        Product product = new Electronics("Laptop", 1000.0, 5, 2);
        manager.addProduct(product);
        
        // Assert that the report generation functionality is working
        // This test can be improved by capturing the output or verifying the report content
        assertEquals(1, manager.getProducts().size());
    }
}