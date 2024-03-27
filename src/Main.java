//create a class "BankAccount" with property "balance" (should be decimal number)
//create an empty default constructor for it
//create a constructor with parameter for setting balance.
//create a method "deposit" with one parameter "amount" (decimal number)
//which allows the user to increase the balance.
//create a method "withdraw" with one parameter "amount"(decimal number) which allows the user to decrease the balance.
//create a method "printBalance" which displays the current balance to user
//method for transfer balance from one bank account to another

//** Optionally make the program interactive with user e.g. using Scanner

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BankAccount one = new BankAccount(150);
        BankAccount two = new BankAccount(0); // an empty to transfer to

        // a menu for the user to decide if he wants to increase, decrease or transfer


        System.out.print("Enter the amount to increase your balance: ");
        int increaseBalance = scanner.nextInt();
        one.deposit(increaseBalance);

        one.printBalance();

        System.out.print("Enter the amount to decrease your balance: ");
        int decreaseBalance = scanner.nextInt();
        one.withdraw(decreaseBalance);

        one.printBalance();

        System.out.print("Enter the amount you want to transfer from one account to another: ");
        int transferAmount = scanner.nextInt();

        one.transferBalance(transferAmount, two);

        one.printBalance();
        two.printBalance();






    }
}