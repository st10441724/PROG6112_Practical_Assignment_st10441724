
package Question2;


//Code Attribution
//This method was taken from ChatBGT
//https://chatgpt.com/c/f48f39e0-cb1f-4828-b8b0-76537e9dee77

//Code Attribution
//This method was taken from w3schools
//https://www.w3schools.com/java/java_inheritance.asp


public class Clothing extends Product {
    // Additional field specific to clothing: size (e.g., S, M, L)
    private String size;

    // Constructor to initialize a clothing product with common attributes and size
    public Clothing(String name, double price, int quantity, String size) {
        super(name, price, quantity); // Call the superclass constructor to initialize common attributes
        this.size = size; // Set the size specific to clothing
    }

    // Override the toString method to include the size
    @Override
    public String toString() {
        return super.toString() + ", Size: " + size;
    }
}

