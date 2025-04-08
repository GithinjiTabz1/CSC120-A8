import java.util.ArrayList;

/**
 * Represents a House that extends Building and implements HouseRequirements.
 * A House can have multiple residents and contains a dining room.
 */
public class House extends Building {

    // House specific attributes
    private ArrayList<Student> residents; // List to store residents
    private boolean hasDiningRoom;         // Whether the house has a dining room
    private boolean hasElevator;           // Whether the house has an elevator

    /**
     * Overloaded constructor — simpler case where the house does not have a dining room or elevator.
     *
     * @param name    the name of the house
     * @param address the address of the house
     */
    public House(String name, String address) {
        super(name, address, 1); // Calls the superclass constructor for a single-floor house
        this.hasDiningRoom = false; // Default value for dining room
        this.hasElevator = false;   // Default value for elevator
        this.residents = new ArrayList<>(); // Initializes the list of residents
    }

    /**
     * Constructs a new House with the specified details.
     *
     * @param name          the name of the house
     * @param address       the address of the house
     * @param nFloors       the number of floors in the house
     * @param hasDiningRoom indicates whether the house has a dining room
     * @param hasElevator   indicates whether the house has an elevator
     */
    public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
        super(name, address, nFloors); // Calls the superclass constructor
        this.hasDiningRoom = hasDiningRoom;
        this.hasElevator = hasElevator;
        this.residents = new ArrayList<>(); // Initializes the list of residents
    }

    /**
     * Checks if the house has a dining room.
     *
     * @return true if the house has a dining room, false otherwise
     */
    public boolean hasDiningRoom() {
        return this.hasDiningRoom;
    }

    /**
     * Returns the number of residents in the house.
     *
     * @return the number of residents
     */
    public int getResidentCount() {
        return this.residents.size();
    }

    /**
     * Moves a student into the house, if not already a resident.
     *
     * @param s the student to move in
     * @throws RuntimeException if the student is already a resident
     */
    public void moveIn(Student s) {
        if (!residents.contains(s)) { // Check if the student is already in the house
            residents.add(s); // Add the student to the house
            System.out.println(s.getName() + " has moved in.");
        } else {
            throw new RuntimeException("The student is already in this house and cannot move in. Please try another house!");
        }
    }

    /**
     * Overloaded method to move in a student by name (useful for demo/testing).
     *
     * @param name the name of the student to move in
     */
    public void moveIn(String name) {
        Student s = new Student(name, "N/A", 0); // Create a student with dummy data
        moveIn(s); // Call the original moveIn method
    }

    /**
     * Moves a student out of the house.
     *
     * @param s the student to move out
     * @return the student that was moved out
     * @throws RuntimeException if the student is not a resident of the house
     */
    public Student moveOut(Student s) {
        if (residents.contains(s)) {
            residents.remove(s); // Remove the student from the house
            return s;
        } else {
            throw new RuntimeException("The student is not in this house and cannot move out.");
        }
    }

    /**
     * Checks if a student is a resident of the house.
     *
     * @param s the student to check
     * @return true if the student is a resident, false otherwise
     */
    public boolean isResident(Student s) {
        return residents.contains(s);
    }

    /**
     * Displays available options based on the house's features.
     */
    public void showOptions() {
        if (this.hasElevator) {
            super.showOptions(); // Show options from the superclass if the house has an elevator
            System.out.println(" + moveIn() \n + moveOut() \n");
        } else {
            System.out.println("Available options at " + this.name + ": + enter() \n + exit() \n + goUp() \n + goDown() \n + moveIn() \n + moveOut() \n");
        }
    }

    /**
     * Moves the house to a specific floor, but only if the house has an elevator.
     *
     * @param floorNum the floor number to go to
     * @throws RuntimeException if the house doesn't have an elevator
     */
    public void goToFloor(int floorNum) {
        if (!this.hasElevator) {
            throw new RuntimeException("This house doesn't have an elevator. You must use goUp() or goDown() one floor at a time.");
        }
        super.goToFloor(floorNum); // Call the superclass method to change floors
    }

    /**
     * Main method to test the functionality of the House class.
     */
    public static void main(String[] args) {
        // Create a House object
        House myHouse = new House("Green House", "123 Elm Street", 3, true, true);

        // Print house details (make sure to override toString() in House or Building)
        System.out.println("House Created: " + myHouse);

        // Create students
        Student s1 = new Student("Tabz", "12345", 20);
        Student s2 = new Student("Githinji", "67890", 21);

        // Test moving students in
        myHouse.moveIn(s1);
        myHouse.moveIn(s2);

        // Check residents count
        System.out.println("Number of residents: " + myHouse.getResidentCount());

        // Check if a student is a resident
        System.out.println("Is Tabz a resident? " + myHouse.isResident(s1));
        System.out.println("Is Githinji a resident? " + myHouse.isResident(s2));

        // Test moving a student out
        myHouse.moveOut(s1);
        System.out.println("Tabz has moved out.");

        // Check residents count after moving out
        System.out.println("Number of residents after move out: " + myHouse.getResidentCount());

        // Check if Tabz is still a resident
        System.out.println("Is Tabz a resident? " + myHouse.isResident(s1));

        // Show available options for the house
        myHouse.showOptions();
    }
}
