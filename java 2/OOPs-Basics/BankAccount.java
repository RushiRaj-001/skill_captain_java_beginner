
// Create a class called BankAccount with the following attributes: account number, account holder name, and account balance?
public class BankAccount {

    int accNumber;
    String accHolderName;
    int accBalance;
    int updatedBalance;

    // Create a constructor for the BankAccount class that initializes the account
    // number, account holder name, and account balance.

    BankAccount(int accNumber, String accHolderName, int accBalance) {
        this.accNumber = accNumber;
        this.accHolderName = accHolderName;
        this.accBalance = accBalance;
    }

    // Create methods to deposit and withdraw money from the account. The methods
    // should update the account balance accordingly.

    void deposit(int add) {
        accBalance += add;
        System.out.println("after deposit " + add + " account balance is : " + accBalance);
    }

    void withdraw(int minus) {
        updatedBalance = accBalance - minus;
        System.out.println("after withdraw " + minus + " account balance is : " + updatedBalance);
    }

    void display() {
        System.out.println("Account number : " + accNumber);
        System.out.println("Account Holder name : " + accHolderName);
        System.out.println("Account balance : " + accBalance);
    }

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount(01, "sham", 2000);

        bankAccount.display(); // diaplay account info

        bankAccount.deposit(100); // account balance after deposit

        bankAccount.withdraw(30); // account balance after withdraw
    }
}
