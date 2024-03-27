public class BankAccount {
    int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount) {


        // add catch & try for catching the exceptions
//        while(true) {
//            try {
//                balance += amount;
//            }
//            catch(IllegalArgumentException e) {
//                System.out.println("Amount for increasing should be greater than zero");
//            }
//        }
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

//    method for transfer balance from one bank account to another
    public void transferBalance(int amount, BankAccount transferBalanceTo) {
    if (amount <= 0) {
        System.out.println("Transfer amount should be greater than zero");
        return;
    }
    if (this.balance < amount) {
        System.out.println("Your balance is less than the amount you want to transfer");
    }

    this.balance -= amount;
        transferBalanceTo.deposit(amount);
    }

}
