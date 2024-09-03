
package Question2;



//Code Attribution
//This method was taken from ChatBGT
//https://chatgpt.com/c/f48f39e0-cb1f-4828-b8b0-76537e9dee77

//Code Attribution
//This method was taken from w3schools
//https://www.w3schools.com/java/java_inheritance.asp


public class Electronics extends Product {
    // Additional field specific to electronics: warranty period in years
    private int warrantyPeriod;

    // Constructor to initialize an electronics product with common attributes and warranty period
    public Electronics(String name, double price, int quantity, int warrantyPeriod) {
        super(name, price, quantity); // Call the superclass constructor to initialize common attributes
        this.warrantyPeriod = warrantyPeriod; // Set the warranty period
    }

    // Override the toString method to include the warranty period
    @Override
    public String toString() {
        return super.toString() + ", Warranty Period: " + warrantyPeriod + " years";
    }
}


