/**
 * Represents a Cafe, which is a type of Building that manages an amount of coffee,
 * sugar, cream, and cups. Provides methods to sell coffee and restock ingredients.
 */
public class Cafe extends Building {

    private int nCoffeeOunces;
    private int nSugarPackets; 
    private int nCreams; 
    private int nCups; 

    /**
     * Constructs a new Cafe with the speicified name, address, and number of floors.
     * Initializes the stock of coffee, sugar, cream, and cups to default values.
     */

    /**
     * Constructs a new Cafe object with default values.
     * Calls the default constructor of the superclass Building.
     * Initializes the stock of coffee, sugar, cream, and cups to default values.
     * Prints a message confirming the Cafe has been built.
     */ 
    public Cafe() {
        super();
        this.nCoffeeOunces = 100;
        this.nSugarPackets = 100;
        this.nCreams = 100;
        this.nCups = 100;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Constructs a new Cafe with the speicified name and address.
     * Calls the corresponding constructor of the superclass Building.
     * Initializes the stock of coffee, sugar, cream, and cups to default values.
     * Prints a message confirming the Cafe has been built.
     * 
     * @param name the name of the cafe
     * @param address the address of the cafe
     */
    public Cafe(String name, String address) {
        super(name, address);
        this.nCoffeeOunces = 100;
        this.nSugarPackets = 100;
        this.nCreams = 100;
        this.nCups = 100;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Constructs a new Cafe with the speicified name, address, and number of floors.
     * Calls the corresponding constructor of the superclass Building.
     * Initializes the stock of coffee, sugar, cream, and cups to default values.
     * Prints a message confirming the Cafe has been built.
     * 
     * @param name the name of the cafe
     * @param address the address of the cafe
     * @param nFloors the number of floors in the cafe
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 100;
        this.nSugarPackets = 100;
        this.nCreams = 100;
        this.nCups = 100;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Restocks the cafe's ingredients with the specified amounts of coffee, sugar, cream, and cups.
     * @param nCoffeeOunces the new number of ounces of coffee
     * @param nSugarPackets the new number of sugar packets
     * @param nCreams the new number of "splashes" of cream
     * @param nCups the new number of cups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    } 

    /**
     * Sells a coffee of the specified size with the given amount of sugar and cream.
     * Automatically restocks the cafe if there are insufficient ingredients.
     * After selling, updates the stock by subtracting the used ingredients and one cup.
     *
     * @param size the size of the coffee in ounces
     * @param nSugarPackets the number of sugar packets wanted
     * @param nCreams the number of "splashes" of cream wanted
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
            this.restock(100, 100, 100, 100);
        }

        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
    }

    /**
     * Prints the available navigational actions that can be performed in this Cafe.
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    }

    /**
     * Moves the user to the specified floor in the building.
     * Checks whether the user is inside the building, whether the floor number is valid,
     * and whether the user wants to go to a higher floor than 1.
     *
     * @param floorNum the floor number to get to
     * @throws RuntimeException if the user is not inside the building
     * @throws RuntimeException if the floor number is invalid
     * @throws RuntimeException if the user tries to move to a floor above 1
     */
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }

        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }

        if (floorNum > 1) {
            throw new RuntimeException("Cannot access floor, storage only.");
        }

        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

    public static void main(String[] args) {
        Cafe myCafe = new Cafe("The Cafe", "1234 st", 1);
        myCafe.sellCoffee(16, 5, 5);
        System.out.println(myCafe);
    }
    
}
