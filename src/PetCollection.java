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

  
  // ------------------------
  // DIPLAY ALL PETS
  // ------------------------
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


  // ------------------------
  // DIPLAY PETS UPON A MATCH WITH A NAME
  // ------------------------
  public void displayPets(String name) {
    // Prints the header
    System.out.printf("\n+----------------------+\n");
    System.out.printf("| ID | %-9s | AGE |\n", "NAME");
    System.out.printf("+----------------------+\n");
    
    // Prints a line for each Pet object in the PetCollection object that matches a certain name
    // Prints the id, name, and age of the pet
    for (int i = 0; i < pets.size(); i++) {

      if (name.compareToIgnoreCase(pets.get(i).getName()) == 0) {
        System.out.printf("| %2d | %-9s | %3d |\n", i, pets.get(i).getName(), pets.get(i).getAge());
      }
    }

    // Prints footer
    System.out.printf("+----------------------+\n");
    System.out.printf("%d rows in set\n\n", pets.size());
  }


  // ------------------------
  // DIPLAY PETS UPON A MATCH WITH AN AGE
  // ------------------------
  public void displayPets(int age) {
    // Prints the header
    System.out.printf("\n+----------------------+\n");
    System.out.printf("| ID | %-9s | AGE |\n", "NAME");
    System.out.printf("+----------------------+\n");
    
    // Prints a line for each Pet object in the PetCollection object that matches a certain age
    // Prints the id, name, and age of the pet
    for (int i = 0; i < pets.size(); i++) {

      if (age == pets.get(i).getAge()) {
        System.out.printf("| %2d | %-9s | %3d |\n", i, pets.get(i).getName(), pets.get(i).getAge());
      }
    }

    // Prints footer
    System.out.printf("+----------------------+\n");
    System.out.printf("%d rows in set\n\n", pets.size());
  }
}