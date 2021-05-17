import java.util.ArrayList;

/**
 * PetCollection
 * Joshua Sells
 * 05/17/2021
 */

public class PetCollection {

  public ArrayList<Pet> pets = new ArrayList<>();

  public void addPet(Pet pet) {
    pets.add(pet);
  }

  public void displayPets() {
    // Prints the header
    System.out.printf("\n+----------------------+\n");
    System.out.printf("| ID | %-9s | AGE |\n", "NAME");
    System.out.printf("+----------------------+\n");
    
    // Prints a line for each Pet object in the PetCollection object
    // Prints the id, name, and age of the pet
    for (int i = 0; i < pets.size(); i++) {
      System.out.printf("| %2d | %-9s | %3d |\n", i, pets.get(i).getName(), pets.get(i).getAge());
    }

    // Prints footer
    System.out.printf("+----------------------+\n");
    System.out.printf("%d rows in set\n\n", pets.size());
  }
}