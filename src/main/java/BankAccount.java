public class BankAccount {
    private double balance;
    private final String login;
//    private int password;

    public BankAccount(double balance, String login) {
        this.balance = balance;
        this.login = login;
//        this.password = password;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
    public String getLogin() {
        return login;
    }

//    public int getPassword() {
//        return password;
//    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount for increasing should be greater than zero");
        } else {
            this.balance += amount;

        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount for decreasing should be greater than zero");
        } else {
            this.balance -= amount;
        }
    }

    public void transferBalance(double amount, BankAccount transferBalanceTarget) {
    if (amount <= 0) {
        System.out.println("Transfer amount should be greater than zero");
    } else if (balance < amount) {
        System.out.println("Your balance is less than the amount you want to transfer");
    }
    else {
        this.balance -= amount;
        transferBalanceTarget.deposit(amount);
        System.out.println("Successfully transferred");
    }
    }

}
