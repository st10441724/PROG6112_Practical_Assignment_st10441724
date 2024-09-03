
package Question2;


//Code Attribution
//This method was taken from ChatBGT
//https://chatgpt.com/c/f48f39e0-cb1f-4828-b8b0-76537e9dee77




public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Method to calculate total value of the product
    public double calculateTotalValue() {
        return price * quantity;
    }

    //Code Attribution
    //This method was taken from w3schools
    //https://www.w3schools.com/jsref/jsref_tostring_string.asp
    // toString method to display product details
    @Override
    public String toString() {
        return "Product Name: " + name + ", Price: " + price + ", Quantity: " + quantity + ", Total Value: " + calculateTotalValue();
    }
}

