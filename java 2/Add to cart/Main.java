import java.util.ArrayList;
import java.util.List;

class Product {
    String productId;
    String productName;
    int price;
    int quantity;

    public Product(String productId, String productName, int price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getproductId() {
        return productId;
    }

    public String getproductName() {
        return productName;
    }

    public int getprice() {
        return price;
    }

    public void setquantity(int quantity) {
        this.quantity = quantity;
    }
    public int getquantity() {
        return quantity;
    }
}

class Cart {
    private List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public void addtoCart(Product product) {
        products.add(product);
    }

    public void removeFromCart(Product product) {
        products.remove(product);
    }

    public void updateQuantity(Product product, int quantity) {
        product.setquantity(quantity);
    }

    public void view(){
        System.out.println("Products in the Cart : ");
        for (Product product : products) {
        System.out.println("Product id : " + product.getproductId());
        System.out.println("Product Name : " + product.getproductName());
        System.out.println("Product Price : " + product.getprice());
        System.out.println("Product Quantity : " + product.getquantity());
       
       }

    }
    public void checkout(){
        
    }

    

}

public class Main {
     public static void main(String[] args) {
        Product product1 = new Product("p1", "abc", 100, 2);
        Product product2 = new Product("p2", "xyz", 150, 1);
        Product product3 = new Product("p3", "pqr", 200, 4);

        Cart cart = new Cart();

        cart.addtoCart(product1);
        cart.addtoCart(product2);
        cart.addtoCart(product3);
        cart.view();
        System.out.println("-------------------------------");
        cart.removeFromCart(product2);
        cart.view();
        System.out.println("-------------------------------");
        cart.updateQuantity(product3, 2);
        cart.view();
        System.out.println("-------------------------------");
        cart.checkout();
    }
}
