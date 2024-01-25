
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GroceryListManager {
    public static List<String> items = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int select;
        while (true) {
            System.out.println("\n1. Add item in the list");
            System.out.println("2. Remove item in the list");
            System.out.println("3. Print grocery form the list");
            System.out.println("4. Check item existence");
            System.out.println("5. Clear grocery list");
            System.out.println("6. Exit");

            System.out.print("Enter your choice (1-6): ");
            select = sc.nextInt();
            sc.nextLine();

            switch (select) {
                case 1:
                    addItem(sc);
                    break;
                case 2:
                    removeItem(sc);
                    break;
                case 3:
                    printItem();
                    break;
                case 4:
                    checkItem(sc);
                    break;
                case 5:
                    clearList();
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

    public static void addItem(Scanner sc) {
        System.out.println("\nEnter the item to add in the list");
        String item = sc.nextLine();
        items.add(item);
        System.out.println("\titem add");

    }

    public static void removeItem(Scanner sc) {
        System.out.println("Enter the item to remove from the list ");
        String item = sc.nextLine();
        boolean removed = items.remove(item);
        if (removed) {
            System.out.println("Item removed successfully");
        }
    }

    public static void printItem() {
        if (items.isEmpty()) {
            System.out.println("The grocery list is empty.");
        } else {
            System.out.println("Grocery List:");
            System.out.println(items);
        }

    }

    public static void checkItem(Scanner sc) {
        System.out.print("Enter the item to check in list: ");
        String item = sc.nextLine();
        boolean a = items.contains(item);
        if (a) {
            System.out.println("The item is in the list");
        } else {
            System.out.println("The item is not in the list.");
        }

    }

    public static void clearList() {
        items.clear();
        System.out.println("List is cleared.");

    }
}