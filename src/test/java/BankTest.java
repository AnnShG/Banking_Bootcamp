import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BankTest {
    @Test
    @DisplayName("Test deposit")
    void testDeposit() {
        BankAccount testAccountDeposit = new BankAccount(10, "1");
        Assertions.assertEquals(20, testAccountDeposit.getBalance());
    }

    @Test
    @DisplayName("Test if negative amount deposited")
    void testIfNegativeAmountDeposited() {
        BankAccount testNegativeDeposit = new BankAccount(20.0, "1");
        testNegativeDeposit.deposit(-2.0);
        Assertions.assertEquals(20.0, testNegativeDeposit.getBalance());
    }
    @Test
    @DisplayName("Test if negative amount withdraw")
    void testIfNegativeAmountWithdraw() {
        BankAccount testNegativeWithdrawl = new BankAccount(20.0, "1");
        testNegativeWithdrawl.withdraw(-2.0);
        Assertions.assertEquals(20.0, testNegativeWithdrawl.getBalance());
    }

    @Test
    @DisplayName("Test if transfer sufficient")
    void testIfTransferSufficient() {
        BankAccount targetAccount = new BankAccount(20.0, "1");
        BankAccount sourceAccount = new BankAccount(10.0, "2");
        double transferAmount = 1.0;
        sourceAccount.transferBalance(transferAmount, targetAccount);
        assertAll(() -> assertEquals(21.0, targetAccount.getBalance()),
                () -> assertEquals(10.0, sourceAccount.getBalance()));
    }
    @Test
    @DisplayName("Test if negative amount transfered")
    void testIfNegativeAmountTransfers() {
        BankAccount targetAccount = new BankAccount(20.0, "1");
        BankAccount sourceAccount = new BankAccount(10.0, "2");
        double transferAmount = -1.0;
        sourceAccount.transferBalance(transferAmount, targetAccount);
        assertEquals(20.0, targetAccount.getBalance());
    }
}
