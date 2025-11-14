import java.util.Hashtable;

/**
 * Represents a Library, which is a type of Building that manages a collection of books.
 * Each book title is stored as a String key in a Hashtable, and its value is a boolean that 
 * indicates whether it is available. Provides methods to add and remove books, check out and 
 * return books, and ask about the possession and availability of a certain title.
 */
public class Library extends Building {

    private Hashtable<String, Boolean> collection;
    private boolean hasElevator;

    /**
     * Constructs a new Library object with default values.
     * Calls the default constructor of the superclass Building.
     * Initializes an empty hashtable of book titles, sets hasElevator to false,
     * and prints a message confirming the Library has been built.
     */
    public Library() {
      super();
      this.collection = new Hashtable<String, Boolean>();
      this.hasElevator = false;
      System.out.println("You have built a library: 📖");
    }

    /**
     * 
     * Constructs a new House object with the specified name and address.
     * Calls the corresponding constructor of the superclass Building.
     * Initializes an empty hashtable of book titles, sets hasElevator to false,
     * and prints a message confirming the Library has been built.
     * 
     * @param name the name of the house
     * @param address the address of the house
     */
    public Library(String name, String address) {
      super(name, address);
      this.collection = new Hashtable<String, Boolean>();
      this.hasElevator = false;
      System.out.println("You have built a library: 📖");
    }

    /**
     * Constructs a new Library object with the specified name, address, number of floors,
     * and whether it has an elevator.
     * Initializes an empty hastable of book titles, and prints a message confirming the Library has been built.
     *
     * @param name the name of the library
     * @param address the address of the library
     * @param nFloors the number of floors in the library
     * @param elevator true if the house has an elevator, false if not
     */
    public Library(String name, String address, int nFloors, boolean elevator) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      this.hasElevator = elevator;
      System.out.println("You have built a library: 📖");
    }

    /**
     * Adds a new title to the library's collection. If the title is not already 
     * in the collection, it will be added and marked as available. 
     * If the title already exists, an exception is thrown.
     *
     * @param title the title to be added to the library collection
     * @throws RuntimeException if the title is already in the collection
     */
    public void addTitle(String title) {
      if (!this.containsTitle(title)) {
        collection.put(title, true);
      } else {
        throw new RuntimeException("This title is already in this library!"); 
      }
    }
    
    /**
     * Removes a book title from the library's collection. If the title exists 
     * in the collection, it will be removed and the removed title will be returned. 
     * Otherwise, an exception is thrown.
     *
     * @param title the title of the book to remove from the collection
     * @return the title that was removed
     * @throws RuntimeException if the title is not found in the collection
     */
    public String removeTitle(String title) {
      if (this.containsTitle(title)) {
        collection.remove(title);
        return title;
      } else {
        throw new RuntimeException("This title is not in this library!"); 
      }
    }

    /**
     * Checks out a book from the library by marking it as unavailable.
     * Throws an exception if the title does not exist in the collection
     * or if the book is already checked out.
     *
     * @param title the title of the book to check out
     * @throws RuntimeException if the title is not in the library or is already checked out
     */

    public void checkOut(String title) {
      if(this.containsTitle(title)) {
        if (!collection.get(title)) {
          throw new RuntimeException("This title is already checked out!");
        }
        else {
          collection.replace(title, true, false);
          System.out.println("You checked out " + title);
        }
      } else {
        throw new RuntimeException("This title is not in this library so it cannot be checked out!"); 
      }
    }

    /**
     * Returns a book to the library, marking it as available.
     *
     * @param title the title of the book being returned
     */
    public void returnBook(String title) {
      collection.replace(title, false, true);
    }

    /**
     * Checks whether a given book title exists in the library's collection.
     *
     * @param title the title to check for
     * @return true if the collection contains the title, false if not
     */
    public boolean containsTitle(String title) {
      return collection.containsKey(title);
    }

    /**
     * Checks whether a given book is currently available for checkout.
     * 
     * @param title the title of the book to check
     * @return true if the book is available, false if it is checked out
     */
    public boolean isAvailable(String title) {
      return collection.get(title);
    }

    /**
     * Prints the entire library collection to the console.
     * Each book title is displayed along with its availability status.
     */
    public void printCollection() {
      System.out.println(collection.toString());
    } 

    /**
     * Prints the available navigational actions that can be performed in this Library.
     */
    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    }

    /**
     * Moves the user to the specified floor in the building.
     * Checks whether the user is inside the building, whether the floor number is valid,
     * and whether non-adjacent floors can be accessed, depdending on the presence of an elevator.
     *
     * @param floorNum the floor number to get to
     * @throws RuntimeException if the user is not inside the building
     * @throws RuntimeException if the floor number is invalid
     * @throws RuntimeException if the user tries to move to a non-adjacent floor in a building without an elevator
     */
    public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
      throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }

    if (floorNum < 1 || floorNum > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }

    if (!this.hasElevator && (floorNum > (activeFloor + 1) || floorNum < (activeFloor - 1))) {
      throw new RuntimeException("Cannot access floor because this library has no elevator");
    }

    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
  }
  
    public static void main(String[] args) {
      Library myLibrary = new Library("The Library", "1234 st", 3, true);
      myLibrary.addTitle("Little Women");
      myLibrary.addTitle("Pride and Prejudice");
      
      myLibrary.checkOut("Pride and Prejudice");
      myLibrary.printCollection();
      
      myLibrary.returnBook("Pride and Prejudice");
      myLibrary.printCollection();
    }
  
  }