import java.util.Scanner;

/**
 * Main
 * Joshua Sells
 * 05/17/2021
 */

public class Main {
    public static void main(String[] args) throws Exception {
        // Strart off of a loop for the main program
        while (true) {
          // Create new scanner object
          Scanner input = new Scanner(System.in);

          PetCollection pets = new PetCollection();
          pets.addPet(new Pet("Simon", 1));
          pets.displayPets();
          break;
        }
    }

    public static void printMenu() {
      System.out.println("yes sir");
    }
}
