import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * PetCollection
 * Joshua Sells
 * 05/17/2021
 */

public class PetCollection {

  private ArrayList<Pet> pets = new ArrayList<>();

  public void addPet(Pet pet) {
    pets.add(pet);
  }

  public ArrayList<Pet> getPets() {
    return pets;
  }

  public void removePet(String index) {
    pets.remove(Integer.parseInt(index));
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

  // ---------------------------
  // LOAD CONTENT FROM A TEXT FILE INTO A PETCOLLECTION OBJECT AND RETURN IT
  // ---------------------------
  public static PetCollection load(String fileName) throws IOException {
    PetCollection petCollection = new PetCollection();
    
    File file = new File(fileName);
    System.out.println(file.exists());
    Scanner input = null;
    try {
      input = new Scanner(file);
    }
    catch (IOException e) {
      return petCollection;
    }

    while (input.hasNextLine()) {
      String line = input.nextLine();
      String[] data = line.split(" ");
      String name = data[0];
      String age = data[1];
      petCollection.addPet(new Pet(name, Integer.parseInt(age)));
    }

    input.close();

    return petCollection;
  }

  // ---------------------------
  // SAVE CONTENT FROM THE PETCOLLECTION OBJECT TO A TEXT FILE
  // ---------------------------
  public void save(String filename) throws FileNotFoundException {
    File file = new File(filename);
    PrintWriter output = new PrintWriter(file);
    for (Pet pet : this.pets) {
      output.println(pet.toString());
    }

    output.close();
  }
}