/**
 * Pet
 * Joshua Sells
 * 05/17/2021
 */

public class Pet {

  private String name;
  private int age;

  public Pet(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    String pet = (this.name + " " + this.age);
    return pet;
  }

}