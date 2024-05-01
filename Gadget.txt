public class Gadget {
    // Instance variables
    private String model;    // Model of the gadget
    private double price;    // Price of the gadget in £
    private int weight;      // Weight of the gadget in grams
    private String size;     // Size of the gadget (e.g., "71mm x 137mm x 9mm")

    // Constructor
    public Gadget(String model, double price, int weight, String size) {
        // Initialize instance variables
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    // Getter method for model
    public String getModel() {
        return model;
    }

    // Getter method for price
    public double getPrice() {
        return price;
    }

    // Getter method for weight
    public int getWeight() {
        return weight;
    }

    // Getter method for size
    public String getSize() {
        return size;
    }

    // Method to display gadget details
    public void display() {
        System.out.println("Model: " + model);
        System.out.println("Price: £" + price);
        System.out.println("Weight: " + weight + " grams");
        System.out.println("Size: " + size);
    }
}
