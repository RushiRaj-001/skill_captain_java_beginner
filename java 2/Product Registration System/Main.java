
import java.util.HashMap;
import java.util.Map;
import java.util.*;

class Product {
    String productId;
    String productName;
    String description;
    String manufacturer;
    int warrantyPeriod;

    // Constructor
    public Product(String productId, String productName, String description, String manufacturer, int warrantyPeriod) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.manufacturer = manufacturer;
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }
}

class ProductRegistrationSystem {
    private Map<String, Product> productMap = new HashMap<>();

    
    public void registerProduct() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter product details:");

        System.out.print("Product ID: ");
        String productId = sc.nextLine();

        if (productMap.containsKey(productId)) {
            System.out.println("Product with this ID already exists. Registration failed.");
            return;
        }

        System.out.print("Product Name: ");
        String productName = sc.nextLine();

        System.out.print("Description: ");
        String description = sc.nextLine();

        System.out.print("Manufacturer: ");
        String manufacturer = sc.nextLine();

        System.out.print("Warranty Period (in months): ");
        int warrantyPeriod = sc.nextInt();

      
        Product newProduct = new Product(productId, productName, description, manufacturer, warrantyPeriod);

       
        productMap.put(productId, newProduct);

        System.out.println("Product registered successfully.");

        sc.close();
    }


    public void displayAllProducts() {
        System.out.println("All Registered Products:");
        for (Product product : productMap.values()) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Warranty Period: " + product.getWarrantyPeriod() + " months");
            System.out.println("-----------------------");
        }
    }

    
    public void searchProductById() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Product ID to search: ");
        String productId = sc.nextLine();

        if (productMap.containsKey(productId)) {
            Product product = productMap.get(productId);
            System.out.println("Product found:");
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Warranty Period: " + product.getWarrantyPeriod() + " months");
        } else {
            System.out.println("Product not found.");
        }
    }

   
    public void generateReport() {
        int totalProducts = productMap.size();
        int expiredWarrantyCount = 0;

        for (Product product : productMap.values()) {
            if (product.getWarrantyPeriod() <= 0) {
                expiredWarrantyCount++;
            }
        }

        System.out.println("Product Registration Report:");
        System.out.println("Total Products Registered: " + totalProducts);
        System.out.println("Expired Warranty Products: " + expiredWarrantyCount);
        System.out.println("Active Warranty Products: " + (totalProducts - expiredWarrantyCount));
    }
}

public class Main {
    public static void main(String[] args) {
        ProductRegistrationSystem registrationSystem = new ProductRegistrationSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nProduct Registration System");
            System.out.println("1. Register a Product");
            System.out.println("2. Display All Products");
            System.out.println("3. Search for a Product by ID");
            System.out.println("4. Generate Report");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    registrationSystem.registerProduct();
                    break;
                case 2:
                    registrationSystem.displayAllProducts();
                    break;
                case 3:
                    registrationSystem.searchProductById();
                    break;
                case 4:
                    registrationSystem.generateReport();
                    break;
                case 0:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
}
