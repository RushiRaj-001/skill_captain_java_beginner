
// Create a set of integers, and your task is to perform various operations on this list, simulating a set of unique numbers. Implement a program with the following operations:
import java.util.Scanner;
import java.util.HashSet;

public class Set {

    static HashSet<Integer> numbers = new HashSet<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int select;
        while (true) {
            System.out.println("---------------------------");
            System.out.println("\nSet of Integers :" + numbers);
            System.out.println("\n1. Add integers in the set");
            System.out.println("2. Remove integer from the set");
            System.out.println("3. Checks if the set contains a specific integer");
            System.out.println("4. number of unique integers in the set");
            System.out.println("5. Checks if the set is empty or not");
            System.out.println("6. Exit");

            System.out.print("Enter your choice (1-6): ");
            select = sc.nextInt();
            sc.nextLine();

            switch (select) {
                // 1. add(int num): Adds an integer to the set if it doesn't already exist.
                case 1:
                    addNum(sc);
                    break;

                // 2. remove(int num): Removes an integer from the set if it exists./
                case 2:
                    removeNumber(sc);
                    break;

                // 3. contains(int num): Checks if the set contains a specific integer and
                // returns a boolean value.
                case 3:
                    checkNum(sc);
                    break;

                // 4. size(): Returns the number of unique integers in the set.
                case 4:
                    numSize(sc);
                    break;

                // 5. isEmpty(): Checks if the set is empty and returns a boolean value.
                case 5:
                    checkSet(sc);
                    break;

                case 6:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void addNum(Scanner sc) {
        System.out.print("\nEnter the number to add in set : ");
        int number = sc.nextInt();
        boolean result = numbers.contains(number);
        if (result) {
            System.out.println("the number is already in the set.");
        } else {
            numbers.add(number);
            System.out.println("number add in to the set.");
            System.out.println(numbers);
        }

    }

    public static void removeNumber(Scanner sc) {
        System.out.print("Enter The Number Want to Remove : ");
        int number = sc.nextInt();

        if (numbers.contains(number)) {
            numbers.remove(number);
            System.out.println("Number remove Successfully.");
        } else {
            System.out.println("number is not in set");
        }
    }

    public static void checkNum(Scanner sc) {
        System.out.print("Enter the number to check whether it is in set or not : ");
        int number = sc.nextInt();
        boolean result = numbers.contains(number);

        if (result) {
            System.out.println(number + " is in the set : " + "Result = " + result);
        } else {
            System.out.println(number + " is not in the set : " + "Result = " + result);
        }
    }

    public static void numSize(Scanner sc) {

        int size = numbers.size();
        System.out.println("Size of the set is : " + size);
    }

    public static void checkSet(Scanner sc) {
        boolean check = numbers.isEmpty();

        if (check) {
            System.out.println("the set is empty.");
        } else {
            System.out.println("the set is not empty : " + numbers);
        }
    }
}
