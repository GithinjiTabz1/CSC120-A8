import java.util.Hashtable;

/**
 * Represents a Library, which is a type of Building.
 * The Library manages a collection of books and allows adding, removing,
 * checking out, and returning books.
 */
public class Library extends Building {

    // Library specific attributes
    private Hashtable<String, Boolean> collection; // Stores book titles and their availability

    /**
     * Constructor to initialize a Library object with its specific attributes.
     *
     * @param name     Name of the library
     * @param address  Address of the library
     * @param nFloors  Number of floors in the library
     */
    public Library(String name, String address, int nFloors) {
        super(name, address, nFloors);
        collection = new Hashtable<>(); // Initialize the book collection
    }

    /**
     * Overloaded Constructor to initialize a Library with 1 floor.
     *
     * @param name     Name of the library
     * @param address  Address of the library
     */
    public Library(String name, String address) {
        super(name, address, 1); // Default to a single-floor library
        collection = new Hashtable<>(); // Initialize the book collection
    }

    /**
     * Adds a title to the library's collection.
     *
     * @param title The title of the book to be added
     */
    public void addTitle(String title) {
        if (!collection.containsKey(title)) {
            collection.put(title, true); // Mark as available
            System.out.println("Title added: " + title);
        } else {
            System.out.println("Title already exists: " + title);
        }
    }

    /**
     * Removes a title from the library's collection.
     *
     * @param title The title of the book to be removed
     * @return The title of the removed book, or a message if not found
     */
    public String removeTitle(String title) {
        if (collection.containsKey(title)) {
            collection.remove(title);
            System.out.println("Title removed: " + title);
            return title;
        } else {
            System.out.println("Title not found: " + title);
            return null; // Returns null if the book isn't found
        }
    }

    /**
     * Checks out a book from the library.
     *
     * @param title The title of the book to be checked out
     */
    public void checkOut(String title) {
        if (collection.containsKey(title) && collection.get(title)) { // Check if book is available
            collection.put(title, false); // Mark as checked out
            System.out.println("Checked out: " + title);
        } else {
            System.out.println("Cannot check out: " + title + " (Not available or doesn't exist)");
        }
    }

    /**
     * Returns a book to the library.
     *
     * @param title The title of the book to be returned
     */
    public void returnBook(String title) {
        if (collection.containsKey(title)) {
            collection.put(title, true); // Mark as available
            System.out.println("Returned: " + title);
        } else {
            System.out.println("Cannot return: " + title + " (Not found in collection)");
        }
    }

    /**
     * Checks if the library contains a specific title.
     *
     * @param title The title of the book to check
     * @return true if the book exists in the library, false otherwise
     */
    public boolean containsTitle(String title) {
        return collection.containsKey(title);
    }

    /**
     * Checks if a specific book is available in the library.
     *
     * @param title The title of the book to check availability
     * @return true if the book is available, false if it is checked out
     */
    public boolean isAvailable(String title) {
        return collection.getOrDefault(title, false); // Returns false if not found
    }

    /**
     * Prints the entire library collection and its status (Available/Checked Out).
     */
    public void printCollection() {
        System.out.println("Library Collection:");
        for (String title : collection.keySet()) {
            System.out.println(title + " - " + (collection.get(title) ? "Available" : "Checked Out"));
        }
    }

    /**
     * Displays available options for interacting with the library.
     */
    public void showOptions() {
        super.showOptions(); // Calls the super class's showOptions method
        System.out.println(" + addTitle() \n + removeTitle() \n + checkOut() \n + returnBook() \n + printCollection()");
    }

    /**
     * Goes to a specific floor in the library.
     *
     * @param floorNum The floor number to go to
     */
    public void goToFloor(int floorNum) {
        super.goToFloor(floorNum); // Calls the superclass method to change floors
    }

    /**
     * Overloaded method to go to the default first floor.
     */
    public void goToFloor() {
        goToFloor(1); // Default to 1st floor
    }

    /**
     * Main method to test the Library functionality.
     */
    public static void main(String[] args) {
        // Creating a sample library
        Library myLibrary = new Library("Smith College Library", "10 Elm St", 3);

        // Testing methods
        myLibrary.addTitle("The Great Gatsby");
        myLibrary.addTitle("1984");
        myLibrary.printCollection();

        myLibrary.checkOut("The Great Gatsby");
        myLibrary.printCollection();

        myLibrary.returnBook("The Great Gatsby");
        myLibrary.printCollection();

        myLibrary.removeTitle("1984");
        myLibrary.printCollection();
        myLibrary.showOptions();
    }
}
