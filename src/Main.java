import java.util.Scanner;

/**
 * Main
 * Joshua Sells
 * 05/17/2021
 */

public class Main {
    public static void main(String[] args) throws Exception {
      // new PetCollection object
      PetCollection pets = PetCollection.load("src/pets.txt");
      
      // loop for the main program
      while (true) {
        // Create new scanner object
        Scanner input = new Scanner(System.in);
        
        printMenu();
        
        String choice = input.nextLine();
        String id;
        String petDetails;

        switch (choice) {
          // Display all the pets
          case "1" :
            pets.displayPets();
            break;

          // Add some pets
          case "2" :
            if (pets.getPets().size() == 5) {
              System.out.println("Error: Database is full.");
              break;
            }
            // set counter for tracking how many pets we add
            int counter = 0;
            // loop to add pets until user enters done
            while (true) {
              System.out.print("add pet (name, age): ");
              petDetails = input.nextLine();
              if (petDetails.equalsIgnoreCase("done")) {
                break;
              }
              String[] newPet = petDetails.split(" ");

              // check for 2 values

              // check to make sure both values are name and age types

              // check to make sure age input is valid
              if (Integer.parseInt(newPet[1]) < 1 || Integer.parseInt(newPet[1]) > 20) {
                System.out.println("Please enter between 1 and 20 for the pet's age.");
                continue;
              }

              pets.addPet(new Pet(newPet[0], Integer.parseInt(newPet[1])));
              counter++;
              if (pets.getPets().size() == 5) {
                System.out.println("Note: The database is now full.");
                break;
              }
            }
            System.out.println(counter + " pets added.");
            break;
          
          case "3" :
            pets.displayPets();
            System.out.print("Enter the pet ID you would like to update: ");
            id = input.nextLine();
            String[] newPet = null;
            
            // check to make sure age input is valid
            while (true) {
              System.out.print("Enter new name and new age:");
              petDetails = input.nextLine();
              newPet = petDetails.split(" ");
              
              if (Integer.parseInt(newPet[1]) < 1 || Integer.parseInt(newPet[1]) > 20) {
                System.out.println("Please enter between 1 and 20 for the pet's age.");
                continue;
              }
              break;
            }

            String oldPetDetails = pets.getPets().get(Integer.parseInt(id)).toString();
            pets.getPets().set(Integer.parseInt(id), new Pet(newPet[0], Integer.parseInt(newPet[1])));
            System.out.println(oldPetDetails + " changed to " + petDetails + ".");
            break;

          case "4" :
            pets.displayPets();
            System.out.print("Enter the pet ID to remove: ");
            id = input.nextLine();
            petDetails = pets.getPets().get(Integer.parseInt(id)).toString();
            pets.removePet(id);
            System.out.println(petDetails + " is removed.");
            break;

          case "5" :
            System.out.print("Enter a name to search: ");
            String name = input.nextLine();
            pets.displayPets(name);
            break;

          case "6" :
            System.out.print("Enter an age to search: ");
            int age = Integer.parseInt(input.nextLine());
            pets.displayPets(age);
            break;
          
          case "7" :
            pets.save("src/pets.txt");
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
      System.out.println("3) Update an existing pet");
      System.out.println("4) Remove an existing pet");
      System.out.println("5) Search pets by name");
      System.out.println("6) Search pets by age");
      System.out.println("7) Exit Program");
      System.out.print("Your choice: ");
    }
}
