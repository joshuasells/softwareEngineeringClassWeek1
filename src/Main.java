import java.util.Scanner;

/**
 * Main
 * Joshua Sells
 * 05/17/2021
 */

public class Main {
    public static void main(String[] args) throws Exception {
      // new PetCollection object
      PetCollection pets = new PetCollection();
      
      // loop for the main program
      while (true) {
        // Create new scanner object
        Scanner input = new Scanner(System.in);
        
        printMenu();
        
        String choice = input.nextLine();

        switch (choice) {
          // Display all the pets
          case "1" :
            pets.displayPets();
            break;

          // Add some pets
          case "2" :
            // set counter for tracking how many pets we add
            int counter = 0;
            // loop to add pets until user enters done
            while (true) {
              System.out.print("add pet (name, age): ");
              String petDetails = input.nextLine();
              if (petDetails.equalsIgnoreCase("done")) {
                break;
              }
              String[] newPet = petDetails.split(" ");
              pets.addPet(new Pet(newPet[0], Integer.parseInt(newPet[1])));
              counter++;
            }
            System.out.println(counter + " pets added.");
            break;
          case "3" :
            System.exit(1);
          default :
            System.out.println("Please enter a valid number");
            break;
        }
      }
    }

    public static void printMenu() {
      System.out.print("Pet Database Program\n\n");
      System.out.println("What would you like to do?");
      System.out.println("1) View all pets");
      System.out.println("2) Add more pets");
      System.out.println("3) Exit Program");
      System.out.print("Your choice: ");
    }
}
