
package Question2;


//Code Attribution
//This method was taken from ChatBGT
//https://chatgpt.com/c/f48f39e0-cb1f-4828-b8b0-76537e9dee77

//Code Attribution
//This method was taken from w3schools
//https://www.w3schools.com/java/java_inheritance.asp

public class Groceries extends Product {
    // Additional field for groceries: expiry date
    private String expiryDate;

    // Constructor to initialize groceries product with common attributes and expiry date
    public Groceries(String name, double price, int quantity, String expiryDate) {
        super(name, price, quantity); // Call to the superclass constructor
        this.expiryDate = expiryDate; // Set the expiry date specific to groceries
    }

    // Override the toString method to include expiry date information
    @Override
    public String toString() {
        return super.toString() + ", Expiry Date: " + expiryDate;
    }
}

