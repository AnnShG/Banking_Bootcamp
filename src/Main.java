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
        Scanner input = new Scanner(System.in);

        BankAccount one = new BankAccount(150);
        BankAccount two = new BankAccount(0); // an empty to transfer to

        boolean loop = true;
        while(loop) {
            displayMenu();
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to increase your balance: ");
                    int increaseBalance = input.nextInt();
                    one.deposit(increaseBalance);
                    break;
                case 2:
                    System.out.print("Enter the amount to decrease your balance: ");
                    int decreaseBalance = input.nextInt();
                    one.withdraw(decreaseBalance);
                    break;
                case 3:
                    System.out.print("Enter the amount you want to transfer from one account to another: ");
                    int transferAmount = input.nextInt();

                    one.transferBalance(transferAmount, two);
                    break;
                case 4:
                    one.printBalance();
                    two.printBalance();
                    break;
                case 5:
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
        input.close();
    }
    public static void displayMenu() {
        System.out.println(" ");
        System.out.println("1 - Increase the balance");
        System.out.println("2 - Decrease the balance");
        System.out.println("3 - Transfer the balance from one account to another");
        System.out.println("4 - Print the current balance");
        System.out.println("5 - Exit");
        System.out.print("Enter one of the options: ");
    }
}