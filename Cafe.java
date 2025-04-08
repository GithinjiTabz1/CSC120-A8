/**
 * Represents a Cafe building which is a type of Building.
 * Implements the CafeRequirements interface to manage coffee sales and inventory.
 */
public class Cafe extends Building {

    // Attributes for the cafe
    private int nCoffeeOunces;  // Amount of coffee available in ounces
    private int nSugarPackets;  // Number of sugar packets available
    private int nCreams;        // Number of cream packets available
    private int nCups;          // Number of cups available

    /**
     * Constructor to initialize a Cafe object with its specific attributes.
     *
     * @param name           Name of the cafe
     * @param address        Address of the cafe
     * @param nFloors        Number of floors in the cafe
     * @param nCoffeeOunces  Amount of coffee available in ounces
     * @param nSugarPackets  Number of sugar packets available
     * @param nCreams        Number of cream packets available
     * @param nCups          Number of cups available
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    /**
     * Overloaded constructor to initialize a Cafe object with default inventory values.
     *
     * @param name      Name of the cafe
     * @param address   Address of the cafe
     * @param nFloors   Number of floors in the cafe
     */
    public Cafe(String name, String address, int nFloors) {
        this(name, address, nFloors, 500, 100, 100, 50); // Default stock values
    }

    /**
     * Sells coffee by reducing the inventory and printing the details of the sale.
     *
     * @param size            The size of the coffee in ounces
     * @param nSugarPackets   The number of sugar packets required
     * @param nCreams         The number of cream packets required
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        // Check if there is enough inventory for the sale
        if (nCoffeeOunces >= size && this.nSugarPackets >= nSugarPackets && this.nCreams >= nCreams && nCups > 0) {
            // Reduce the inventory accordingly
            nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            nCups -= 1; // Reduce one cup for each coffee sold

            // Print a message to confirm the sale
            System.out.println("Coffee sold! Size: " + size + " ounces, Sugar: " + nSugarPackets + " packets, Cream: " + nCreams + " packets.");
        } else {
            // If there isn't enough inventory, print a message indicating the problem
            System.out.println("Unable to sell coffee. Not enough inventory.");

            // Check and restock if necessary
            if (nCoffeeOunces < size) {
                System.out.println("Not enough coffee. Restocking...");
                restock(100, 0, 0, 0); // Restock with 100 ounces of coffee
            }

            if (this.nSugarPackets < nSugarPackets) {
                System.out.println("Not enough sugar packets. Restocking...");
                restock(0, 50, 0, 0); // Restock with 50 sugar packets
            }

            if (this.nCreams < nCreams) {
                System.out.println("Not enough cream packets. Restocking...");
                restock(0, 0, 50, 0); // Restock with 50 cream packets
            }

            if (nCups <= 0) {
                System.out.println("Not enough cups. Restocking...");
                restock(0, 0, 0, 30); // Restock with 30 cups
            }

            // After restocking, retry selling
            sellCoffee(size, nSugarPackets, nCreams);
        }
    }

    /**
     * Overloaded method to sell coffee with no sugar or cream (default values).
     *
     * @param size The size of the coffee in ounces
     */
    public void sellCoffee(int size) {
        // Calls the original sellCoffee method but with default values for sugar (0) and cream (0)
        sellCoffee(size, 0, 0); // Default to no sugar or cream
    }

    /**
     * Restocks the inventory of coffee, sugar, cream, and cups.
     *
     * @param nCoffeeOunces  Amount of coffee to add in ounces
     * @param nSugarPackets  Number of sugar packets to add
     * @param nCreams        Number of cream packets to add
     * @param nCups          Number of cups to add
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * Displays available options at the cafe.
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + sellCoffee() \n + restock() \n");
    }

    /**
     * Main method to test the Cafe functionality.
     */
    public static void main(String[] args) {
        // Create a Cafe object
        Cafe myCafe = new Cafe("Cece Cafe", "123 Java St", 1, 500, 100, 100, 50);

        // Print details of the cafe (Assuming a toString method exists)
        System.out.println(myCafe);

        // Try selling coffee
        myCafe.sellCoffee(12, 2, 1);  // Selling a coffee with 12oz, 2 sugar packets, 1 cream

        // Check if restocking works
        myCafe.sellCoffee(600, 5, 3); // This should trigger restocking
        myCafe.showOptions();
    }
}
