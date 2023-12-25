import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the First Number : ");
        int num1 = sc.nextInt();

        System.out.println("Enter The Second Number : ");
        int num2 = sc.nextInt();

        System.out.println("Enter the Opaerator (+, - , * , /)");
        char opaerator = sc.next().charAt(0);

        int Answer = 0;
        switch (opaerator) {

            case '+': // if Enter Addition operator this case execute
                Answer = num1 + num2;
                break;

            case '-': // if Enter substraction operator this case execute
                Answer = num1 - num2;
                break;

            case '*': // if Enter Multiplication operator this case execute
                Answer = num1 * num2;
                break;

            case '/':// if Enter Division operator this case execute
                Answer = num1 / num2;
                break;

            default: // if Invalid Operator enter then this default case execute
                System.out.println("Invalid Operator, Try Again."); // output
                break;
        }
        System.out.println("The Answer is : " + Answer); // output
        sc.close();
    }
}
