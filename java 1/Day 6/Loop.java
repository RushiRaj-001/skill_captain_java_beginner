import java.util.Scanner;

public class Loop {

    public static void main(String[] args) {

        System.out.println("Using For Loop");

        int i = 0;
        for (i = 1; i <= 10; i++) {
            System.out.print(i);
        }

        System.out.println("\n\nUsing While Loop");
        int j = 0;
        while (j < 21) {
            if (j % 2 == 0) {
                System.out.print(j);
            }
            j++;
        }

        System.out.println("\n\nUsing Do-While Loop");

        Scanner sc = new Scanner(System.in);
        int userNumber;
        do {
            System.out.println("Enter a number :");
            userNumber = sc.nextInt();
        } while (userNumber < 1 || userNumber > 10);

        System.out.println("You Enter :" + userNumber);
        sc.close();
    }

}
