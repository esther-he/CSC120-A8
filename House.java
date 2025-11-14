import java.util.ArrayList;

/**
* Represents a House, a type of Building that can have residents and may include a dining room.
* Tracks residents and provides methods to move students in and out, check residency,
* and get the number of residents. 
*/
public class House extends Building {
  private ArrayList<Student> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;


  /**
   * Constructs a new House object with default values.
   * Calls the default constructor of the superclass Building.
   * Initializes an empty list of residents, sets hasDiningRoom and hasElevator to false,
   * and prints a message confirming the house has been built.
   */
  public House() {
    super();
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = false;
    this.hasElevator = false;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * 
   * Constructs a new House object with the specified name and address.
   * Calls the corresponding constructor of the superclass Building.
   * Initializes an empty list of residents, sets hasDiningRoom and hasElevator to false,
   * and prints a message confirming the house has been built.
   * 
   * @param name the name of the house
   * @param address the address of the house
   */
  public House(String name, String address) {
    super(name, address);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = false;
    this.hasElevator = false;
    System.out.println("You have built a house: 🏠");
  }

  /**
  * Constructs a new House object with the specified name, address, number of floors, and whether 
  * it has a dining room and elevator. Initializes an empty list of residents.
  * 
  * @param name the name of the house
  * @param address the address of the house
  * @param nFloors the number of floors in the house
  * @param diningRoom true if the house has a dining room, false if not
  * @param elevator true if the house has an elevator, false if not
  */
  public House(String name, String address, int nFloors, boolean diningRoom, boolean elevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = diningRoom;
    this.hasElevator = elevator;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Returns if this house has a dining room
   *
   * @return  true if the house has a dining room, false if not
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  } 

  /**
   * Returns how many residents are in this house
   *
   * @return the number of residents in the house
   */
  public int nResidents() {
    return residents.size();
  } 

  /**
   * Adds a student to the list of residents in this house.
   * If the student is already a resident, a RuntimeException is thrown.
   *
   * @param s the student moving into the house
   * @throws RuntimeException if the student is already a resident
   */
  public void moveIn(Student s) {
    if (!residents.contains(s)) {
      residents.add(s);
    } else {
      throw new RuntimeException("Student is already a resident in this house!"); 
    }
  }

  /**
   * Removes a student from the list of residents in this house.
   * If the student is not a resident, a RuntimeException is thrown.
   *
   * @param s the student moving out of the house
   * @return the student who moved out
   * @throws RuntimeException if the student is not a resident of the house
   */
  public Student moveOut(Student s) {
    if (residents.contains(s)) {
      residents.remove(s);
      return s;
    } else {
      throw new RuntimeException("Student is not a resident in this house!"); 
    }
  } 
    
  /**
   * Returns whether the student is a resident of this house
   *
   * @param s the student being checked 
   * @return true if the student is a resident, false if not
   */
  public boolean isResident(Student s) {
    return residents.contains(s);
  } 

  /**
   * Prints the available navigational actions that can be performed in this House.
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
      throw new RuntimeException("Cannot access floor because this house has no elevator");
    }

    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
  }

  public static void main(String[] args) {
    House myHouse = new House("The House", "1234 st", 2, true, true);
    System.out.println(myHouse);
  }
}