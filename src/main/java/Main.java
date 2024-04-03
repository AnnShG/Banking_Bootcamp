//create a class "BankAccount" with property "balance" (should be decimal number)
//create an empty default constructor for it
//create a constructor with parameter for setting balance.
//create a method "deposit" with one parameter "amount" (decimal number)
//which allows the user to increase the balance.
//create a method "withdraw" with one parameter "amount"(decimal number) which allows the user to decrease the balance.
//create a method "printBalance" which displays the current balance to user
//method for transfer balance from one bank account to another

//** Optionally make the program interactive with user e.g. using Scanner
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

//        Map<String, BankAccount> bankAccounts = loadAccountsFromFile("accounts.txt");
        Map<String, BankAccount> bankAccounts = new HashMap<>();

//        BankAccount one = new BankAccount(150);
//        BankAccount two = new BankAccount(0); // an empty to transfer to

        boolean mainMenu = true;
        while(mainMenu) {
            displayMainMenu();
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    createAccount(bankAccounts);
                    break;
                case 2:
                    deposit(bankAccounts);
                    break;
                case 3:
                    withdraw(bankAccounts);
                    break;
                case 4:
                    transferBalance(bankAccounts);
                    break;
                case 5:
                    printBalance(bankAccounts);
                    break;
                case 6:
                    System.out.println("all");
                    break;
                case 7:
                    mainMenu = false;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
        generateAccountsFileReport(bankAccounts);
        input.close();
    }

    public static void displayMainMenu() {
            System.out.println(" ");
            System.out.println("Choose one of the options: ");
            System.out.println("1 - Create a new account");
            System.out.println("2 - Increase the balance");
            System.out.println("3 - Decrease the balance");
            System.out.println("4 - Transfer the balance from one account to another");
            System.out.println("5 - Print the current balance");
            System.out.println("6 - Show the list of all accounts");
            System.out.println("7 - Exit");
            System.out.print("Your choice -> ");
        }

    public static void createAccount(Map<String, BankAccount> bankAccounts) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter login: ");
        String accountLogin = input.next();
//        System.out.print("Enter password (5 digits): ");
//          int accountPassword = input.nextInt();
        System.out.print("Enter initial balance: ");
        double initialBalance = input.nextDouble();

//        BankAccount account = new BankAccount(initialBalance, accountLogin, accountPassword);
        BankAccount account = new BankAccount(initialBalance, accountLogin);
        bankAccounts.put(accountLogin, account);
        System.out.println("Account was created successfully!");
    }

    public static void deposit(Map<String, BankAccount> bankAccounts) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your login: ");
        String login = input.next();
        BankAccount account = bankAccounts.get(login);

        if (account != null) {
            System.out.print("Enter the amount to increase your balance: ");
            double  increaseBalance = input.nextDouble();
            account.deposit(increaseBalance);
            System.out.println("Deposit successful. Updated balance: " + account.getBalance());
        } else {
            System.out.println("Account not found!");
        }
    }

    public static void withdraw(Map<String, BankAccount> bankAccounts) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your login: ");
        String login = input.next();
        BankAccount account = bankAccounts.get(login);

        if (account != null) {
            System.out.print("Enter the amount to decrease your balance: ");
            double  decreaseBalance = input.nextDouble();
            account.withdraw(decreaseBalance);
            System.out.println("Withdrawal successful. Updated balance: " + account.getBalance());
        } else {
            System.out.println("Account not found!");
        }
    }

    public static void transferBalance(Map<String, BankAccount> bankAccounts) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your login: ");
        String loginFrom = input.next();

        System.out.print("Enter target login: ");
        String loginTo = input.next();

        BankAccount fromAccount = bankAccounts.get(loginFrom);
        BankAccount toAccount = bankAccounts.get(loginTo);

        if (fromAccount == null) {
            System.out.println("Sender's account not found!");
            return;
        }
        if (toAccount == null) {
            System.out.println("Target's account not found!");
            return;
        }

        System.out.print("Enter the amount to transfer: ");
        double amount = input.nextDouble();

        fromAccount.transferBalance(amount, toAccount);
    }

    public static void printBalance(Map<String, BankAccount> bankAccounts) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your login: ");
        String login = input.next();

        BankAccount account = bankAccounts.get(login);
        if (account != null) {
            System.out.println("The current balance: " + account.getBalance());
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void generateAccountsFileReport(Map<String, BankAccount> accounts) {
        try {
            FileWriter writer = new FileWriter("accounts.txt");
            for (Map.Entry<String, BankAccount> entry : accounts.entrySet()) {
                BankAccount account = entry.getValue();
                writer.write("Login: " + account.getLogin() + "\n");
                writer.write("Balance: " + account.getBalance() + "\n");
            }
            writer.close();
            System.out.println("Account report generated successfully!");
        } catch (IOException e) {
            System.out.println("Error writing account report to file.");
            e.printStackTrace();
        }
    }

}