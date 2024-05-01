public class Mobile extends Gadget {
    // Instance variable
    private int callCredit = 0;

    // Constructor
    public Mobile(int callCredit, String model, double price, int weight, String size) {
        // Call the constructor of the superclass (Gadget)
        super(model, price, weight, size);
        // Initialize the call credit
        this.callCredit = callCredit;
    }

    // Method to get the remaining call credit
    public int getCredit() {
        return callCredit;
    }

    // Method to add credit to the mobile
    public void addCredit(int credit) {
        // Check if the credit is positive
        if (credit > 0) {
            // Add credit to the existing call credit
            this.callCredit += credit;
        } else {
            // Print error message for invalid input
            System.out.println("Invalid input: please enter a positive amount");
        }
    }

    // Method to make a call
    public void makeCall(String phoneNumber, int duration) {
        // Check if there's enough call credit for the call
        if (callCredit >= duration) {
            // Print call details
            System.out.println("Make a call to " + phoneNumber + " for " + duration + " minute(s)");
        } else {
            // Print error message for insufficient balance
            System.out.println("Your balance is insufficient, please top up and try again");
        }
    }
}
