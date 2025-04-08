import java.util.ArrayList;

/**
 * Represents a map of buildings on the campus.
 * Provides functionality to add and remove buildings, and to display the map of buildings.
 */
public class CampusMap {

    private ArrayList<Building> buildings;

    /**
     * Default constructor, initializes an empty ArrayList to hold buildings.
     */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map.
     * 
     * @param building the Building to add
     */
    public void addBuilding(Building building) {
        System.out.println("Adding building...");
        buildings.add(building);
        System.out.println("-->Successfully added " + building.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map.
     * 
     * @param building the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building building) {
        System.out.println("Removing building...");
        buildings.remove(building);
        System.out.println("-->Successfully removed " + building.getName() + " from the map.");
        return building;
    }

    /**
     * Returns a string representation of all the buildings in the campus map.
     * 
     * @return a string listing all buildings and their addresses
     */
    @Override
    public String toString() {
        StringBuilder mapString = new StringBuilder("DIRECTORY of BUILDINGS");

        for (int i = 0; i < this.buildings.size(); i++) {
            mapString.append("\n  ").append(i + 1).append(". ").append(this.buildings.get(i).getName())
                     .append(" (").append(this.buildings.get(i).getAddress()).append(")");
        }
        return mapString.toString();
    }

    /**
     * Main method to demonstrate the usage of the CampusMap class and overloaded methods.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        CampusMap campusMap = new CampusMap();

        // Add buildings to the map
        campusMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        campusMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        campusMap.addBuilding(new Building("Neilson Library", "10 Elm St, Northampton, MA", 4));
        campusMap.addBuilding(new Building("Campus Cafe", "123 Campus Road, Northampton, MA", 1));
        campusMap.addBuilding(new Building("Northrop House", "100 Northrop St, Northampton, MA", 3));
        campusMap.addBuilding(new Building("Morrow House", "25 Morrow Lane, Northampton, MA", 2));
        campusMap.addBuilding(new Building("Cutter House", "7 Cutter Road, Northampton, MA", 2));
        campusMap.addBuilding(new Building("Wright Hall", "50 Wright Street, Northampton, MA", 5));
        campusMap.addBuilding(new Building("Seelye Hall", "200 Seelye Ave, Northampton, MA", 3));
        campusMap.addBuilding(new Building("Burton Hall", "3 Burton Road, Northampton, MA", 3));
        campusMap.addBuilding(new Building("Lawrence House", "15 Lawrence Street, Northampton, MA", 3));
        campusMap.addBuilding(new Building("McConnell Hall", "20 McConnell Rd, Northampton, MA", 4));

        // Add House examples with overloaded methods
        House house1 = new House("Ziskind House", "100 Elm St, Northampton, MA", 3, true, true);
        House house2 = new House("Gilette House", "25 College Lane, Northampton, MA", 2, false, false);
        campusMap.addBuilding(house1);
        campusMap.addBuilding(house2);
        house1.moveIn(new Student("Tabz", "S1234", 20));
        house1.moveIn(new Student("Clare", "S1235", 21));
        System.out.println("Residents in Ziskind House: " + house1.getResidentCount());

        // Add Libraries
        Library library1 = new Library("Neilson Library", "10 Elm St, Northampton, MA", 4);
        Library library2 = new Library("Hilyer Art Library", "200 Seelye Ave, Northampton, MA", 3);
        campusMap.addBuilding(library1);
        campusMap.addBuilding(library2);
        library1.addTitle("Wild Toyota");
        library1.addTitle("Modern Dive");
        library1.checkOut("Wild Toyota");
        library1.printCollection();

        // Add Cafes with overloaded sellCoffee method
        Cafe cafe1 = new Cafe("Campus Cafe", "123 Campus Road, Northampton, MA", 1, 500, 100, 100, 50);
        Cafe cafe2 = new Cafe("Java Cafe", "7 College St, Northampton, MA", 1, 300, 80, 60, 40);
        campusMap.addBuilding(cafe1);
        campusMap.addBuilding(cafe2);
        cafe1.sellCoffee(12, 2, 1);  // Selling coffee with sugar and cream
        cafe2.sellCoffee(16);  // Selling coffee without sugar or cream (overloaded method)

        // Print all buildings in the campus map
        System.out.println(campusMap);

        // Remove a building from the map
        campusMap.removeBuilding(house2);

        // Print the updated map after removal
        System.out.println("\nAfter removing a building:");
        System.out.println(campusMap);
    }
}
