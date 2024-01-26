// Create a class called Person that represents a person, with properties for
// their name and age. The Person class should have a constructor that takes two
// parameters: a String for the person's name and an int for their age. The
// constructor should set the initial values of the name and age properties
// based on the passed-in values.
// Once you have created the Person class and its constructor, create two Person
// objects: one representing a person named "Alice" who is 25 years old, and
// another representing a person named "Bob" who is 30 years old. Then print out
// the name and age properties of each Person object.

public class Person {

    String name;
    int age;

    Person(String Person_name, int Person_age) {
        this.name = Person_name;
        this.age = Person_age;
    }

    void display() {
        System.out.println("person name is : " + name);
        System.out.println("person age is : " + age);
        System.out.println("----------------------");
    }

    public static void main(String[] args) {
        Person p1 = new Person("alice", 25);
        Person p2 = new Person("bob", 30);

        p1.display();
        p2.display();
    }
}