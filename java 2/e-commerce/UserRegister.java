import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class User {
    String name;
    String email;
    String password;
    String address;

    public User(String name, String email, String password, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

}

class UserRepository {

    private static List<User> addUser;

    public UserRepository() {

        addUser = new ArrayList<>();
    }

    public static void register(User user) {
        addUser.add(user);
    }

    public void isEmailTaken() {

    }

}

public class UserRegister {

    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your email address: ");
        String email = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        System.out.print("Enter your shipping address: ");
        String address = sc.nextLine();

        if (name.isEmpty() || email.isEmpty() || name.isEmpty() || password.isEmpty() || address.isEmpty()) {
            System.err.println("fill all fields");
        } else if (!isValidEmail(email)) {
            System.out.println("enter valid email");
        } else {
            User user = new User(name, email, password, address);
            UserRepository.register(user);
            System.out.println("Register Succesfully !!!");
        }

        sc.close();
    }

   private static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
