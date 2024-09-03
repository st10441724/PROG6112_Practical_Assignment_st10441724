
package Question2;


import java.util.Scanner;
import java.util.ArrayList;

public class InventoryManager {
    // List to store products
    private ArrayList<Product> products = new ArrayList<>();
    
    // Scanner object to gather input from the user
    private Scanner scanner = new Scanner(System.in);

    // Method to add a new product based on user input
    public void addProduct() {
        System.out.println("Enter product type (1. Electronics, 2. Clothing, 3. Groceries): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        // Gather common product information
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        
        System.out.println("Enter product price: ");
        double price = scanner.nextDouble();
        
        System.out.println("Enter product quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Product product = null;

        //Code Attribution
        //This method was taken from Youtube
        //https://www.youtube.com/watch?v=wcwWlasmLWs&t=9s
        //Neso Academy 
        // Create a product instance based on the selected type
        switch (choice) {
            case 1: // Electronics
                System.out.println("Enter warranty period (years): ");
                int warrantyPeriod = scanner.nextInt();
                product = new Electronics(name, price, quantity, warrantyPeriod);
                break;
            case 2: // Clothing
                System.out.println("Enter size: ");
                String size = scanner.nextLine();
                product = new Clothing(name, price, quantity, size);
                break;
            case 3: // Groceries
                System.out.println("Enter expiry date (YYYY-MM-DD): ");
                String expiryDate = scanner.nextLine();
                product = new Groceries(name, price, quantity, expiryDate);
                break;
            default:
                System.out.println("Invalid product type selected!");
                return; // Exit if an invalid option is chosen
        }

        // Add the created product to the list
        addProduct(product);
        System.out.println("Product added successfully!");
    }

    // Method to update the quantity of a product
    public void updateProductQuantity() {
        System.out.println("Enter product name to update quantity: ");
        String name = scanner.nextLine();
        
        System.out.println("Enter new quantity: ");
        int quantity = scanner.nextInt();
        
        // Call the helper method to update the quantity
        updateProductQuantity(name, quantity);
    }

    // Method to display all products in the inventory
    public void viewAllProducts() {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    // Method to generate an inventory report
    public void generateReport() {
        System.out.println("Inventory Report:");
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    // Helper method to add a product to the list
    public void addProduct(Product product) {
        products.add(product);
    }

    // Helper method to update the quantity of a specific product
    public void updateProductQuantity(String name, int quantity) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                product.setQuantity(quantity); // Update quantity if the product is found
                return;
            }
        }
        System.out.println("Product not found!"); // Display a message if the product is not found
    }
    
    
    //Code Attribution
    //This method was taken from w3schools
    //https://www.w3schools.com/java/java_arrays.asp
    // Getter method to retrieve the list of products
    public ArrayList<Product> getProducts() {
        return products;
    }

    // Main method to drive the application
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        
        // Display welcome message
        System.out.println("************************************");
        System.out.println("WELCOME TO THE INVENTORY MANAGER APP");
        System.out.println("************************************");
        System.out.println("Manage your products efficiently and effectively.\n");


        // Main loop for the menu-driven system
        while (!exit) {
            System.out.println("1. Add Product");
            System.out.println("2. Update Product Quantity");
            System.out.println("3. View All Products");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            
            
            //Code Attribution
            //This method was taken from Youtube
            //https://www.youtube.com/watch?v=wcwWlasmLWs&t=9s
            //Neso Academy 
            // Handle user input based on selected menu option
            switch (option) {
                case 1:
                    manager.addProduct();
                    break;
                case 2:
                    manager.updateProductQuantity();
                    break;
                case 3:
                    manager.viewAllProducts();
                    break;
                case 4:
                    manager.generateReport();
                    break;
                case 5:
                    exit = true; // Exit the loop and terminate the program
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}

