public class MP3 extends Gadget {
    // Instance variable
    private double memory = 0;

    // Constructor
    public MP3(double memory, String model, double price, int weight, String size) {
        // Call the constructor of the superclass (Gadget)
        super(model, price, weight, size);
        // Initialize the memory
        this.memory = memory;
    }

    // Method to get the memory
    public double getMemory() {
        return memory;
    }

    // Method to download music
    public void downloadingMusic(double needMemory) {
        // Check if the memory needed is positive
        if (needMemory > 0) {
            // Add the needed memory to the existing memory
            memory += needMemory;
        } else {
            // Print error message for negative memory
            System.out.println("Error: The memory is less than the space needed, please add a positive value");
        }
    }

    // Method to display MP3 details including available memory
    public void display() {
        // Call the display method of the superclass (Gadget)
        super.display();
        // Display available memory
        System.out.println("Available memory: " + memory);
    }
}
