import java.util.Scanner;
public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount for increasing should be greater than zero");
        } else {
            balance += amount;
        }
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount for decreasing should be greater than zero");
        } else {
            balance -= amount;
        }
    }

    public void printBalance() {
        System.out.println("The current balance: " + balance);
    }

    public void transferBalance(int amount, BankAccount transferBalanceTo) {
    if (amount <= 0) {
        System.out.println("Transfer amount should be greater than zero");
    } else if (balance < amount) {
        System.out.println("Your balance is less than the amount you want to transfer");
    }
    else {
        this.balance -= amount;
        transferBalanceTo.deposit(amount);
        System.out.println("Successfully transferred");
    }
    }
}
