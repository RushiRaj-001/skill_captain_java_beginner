import java.util.Scanner;

public class Conditions {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number : ");
        int num1 = sc.nextInt();

        System.out.print("Enter Second number : ");
        int num2 = sc.nextInt();

        if (num1 > num2) {
            System.out.println("The larger number is : " + num1); // if num1 is larger then print this line
        } else if (num1 < num2) {
            System.out.println("The larger number is : " + num2); // if num2 is larger then this line print
        } else {
            System.out.println("The numbers are equal"); // else both are equal
        }

        sc.close();
    }
}
