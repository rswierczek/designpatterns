package learning.rasw.designpatterns.command.example2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BankAccountTest {

    public static final int DEPOSIT_AMOUNT = 200;
    public static final int OVERDRAFT_LIMIT = -500;
    public static final int WITHDRAW_AMOUNT_MEET_LIMIT = Math.abs(OVERDRAFT_LIMIT) - 300;
    public static final int WITHDRAW_AMOUNT_NOT_MEET_LIMIT = Math.abs(OVERDRAFT_LIMIT) + 300;
    public static final int INIT_BALANCE = 0;

    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount(INIT_BALANCE, OVERDRAFT_LIMIT);
    }

    @Test
    void depositShouldIncrementBalanceByAmount() {
        bankAccount.deposit(DEPOSIT_AMOUNT);
        assertThat(bankAccount.getBalance()).isEqualTo(INIT_BALANCE+DEPOSIT_AMOUNT);
    }

    @Test
    void withdrawMeetOverdraftLimit() {
        bankAccount.withdraw(WITHDRAW_AMOUNT_MEET_LIMIT);
        assertThat(bankAccount.getBalance()).isLessThan(INIT_BALANCE);
    }

    @Test
    void withdrawNotMeetOverdraftLimit() {
        bankAccount.withdraw(WITHDRAW_AMOUNT_NOT_MEET_LIMIT);
        assertThat(bankAccount.getBalance()).isEqualTo(INIT_BALANCE);
    }
}