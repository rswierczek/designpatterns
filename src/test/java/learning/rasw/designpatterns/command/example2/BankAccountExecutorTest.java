package learning.rasw.designpatterns.command.example2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BankAccountExecutorTest {


    public static final int DEPOSIT_AMOUNT = 200;
    public static final int OVERDRAFT_LIMIT = -500;
    public static final int WITHDRAW_AMOUNT_MEET_LIMIT = Math.abs(OVERDRAFT_LIMIT) - 300;
    public static final int WITHDRAW_AMOUNT_NOT_MEET_LIMIT = Math.abs(OVERDRAFT_LIMIT) + 300;
    public static final int INIT_BALANCE = 0;

    private BankAccount bankAccount;
    private BankAccountExecutor bankAccountExecutor;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount(INIT_BALANCE, OVERDRAFT_LIMIT);
        bankAccountExecutor = new BankAccountExecutor();
    }

    @Test
    void depositShouldIncrementBalanceByAmount() {
        BankAccountCommand deposit = new BankAccountCommand(bankAccount, BankAccountCommand.Action.DEPOSIT, DEPOSIT_AMOUNT);
        bankAccountExecutor.call(deposit);
        assertThat(bankAccount.getBalance()).isEqualTo(INIT_BALANCE + DEPOSIT_AMOUNT);
    }

    @Test
    void withdrawMeetOverdraftLimit() {
        BankAccountCommand withdraw = new BankAccountCommand(bankAccount, BankAccountCommand.Action.WITHDRAW, WITHDRAW_AMOUNT_MEET_LIMIT);
        bankAccountExecutor.call(withdraw);
        assertThat(bankAccount.getBalance()).isLessThan(INIT_BALANCE);
    }

    @Test
    void withdrawNotMeetOverdraftLimit() {
        BankAccountCommand withdraw = new BankAccountCommand(bankAccount, BankAccountCommand.Action.WITHDRAW, WITHDRAW_AMOUNT_NOT_MEET_LIMIT);
        bankAccountExecutor.call(withdraw);
        assertThat(bankAccount.getBalance()).isEqualTo(INIT_BALANCE);
    }


    @Test
    void undoLastDeposit() {
        BankAccountCommand deposit = new BankAccountCommand(bankAccount, BankAccountCommand.Action.DEPOSIT, DEPOSIT_AMOUNT);
        bankAccountExecutor.call(deposit);

        assertThat(bankAccount.getBalance()).isEqualTo(INIT_BALANCE + DEPOSIT_AMOUNT);

        bankAccountExecutor.undoLastAction();
        assertThat(bankAccount.getBalance()).isEqualTo(INIT_BALANCE);
    }

    @Test
    void undoLastWithdrawMeetOverdraftLimit() {
        BankAccountCommand withdraw = new BankAccountCommand(bankAccount, BankAccountCommand.Action.WITHDRAW, WITHDRAW_AMOUNT_MEET_LIMIT);
        bankAccountExecutor.call(withdraw);
        assertThat(bankAccount.getBalance()).isLessThan(INIT_BALANCE);

        bankAccountExecutor.undoLastAction();
        assertThat(bankAccount.getBalance()).isEqualTo(INIT_BALANCE);
    }

    @Test
    void undoLastWithdrawNotMeetOverdraftLimit() {
        BankAccountCommand withdraw = new BankAccountCommand(bankAccount, BankAccountCommand.Action.WITHDRAW, WITHDRAW_AMOUNT_NOT_MEET_LIMIT);
        bankAccountExecutor.call(withdraw);
        assertThat(bankAccount.getBalance()).isEqualTo(INIT_BALANCE);

        bankAccountExecutor.undoLastAction();
        assertThat(bankAccount.getBalance()).isEqualTo(INIT_BALANCE);
    }


    @Test
    void redoLastDeposit() {
        BankAccountCommand deposit = new BankAccountCommand(bankAccount, BankAccountCommand.Action.DEPOSIT, DEPOSIT_AMOUNT);
        bankAccountExecutor.call(deposit);

        assertThat(bankAccount.getBalance()).isEqualTo(INIT_BALANCE + DEPOSIT_AMOUNT);

        bankAccountExecutor.undoLastAction();
        assertThat(bankAccount.getBalance()).isEqualTo(INIT_BALANCE);

        bankAccountExecutor.redoLastAction();
        assertThat(bankAccount.getBalance()).isEqualTo(INIT_BALANCE + DEPOSIT_AMOUNT);
    }

    @Test
    void redoLastWithdrawMeetOverdraftLimit() {
        BankAccountCommand withdraw = new BankAccountCommand(bankAccount, BankAccountCommand.Action.WITHDRAW, WITHDRAW_AMOUNT_MEET_LIMIT);
        bankAccountExecutor.call(withdraw);
        assertThat(bankAccount.getBalance()).isLessThan(INIT_BALANCE);

        bankAccountExecutor.undoLastAction();
        assertThat(bankAccount.getBalance()).isEqualTo(INIT_BALANCE);

        bankAccountExecutor.redoLastAction();
        assertThat(bankAccount.getBalance()).isLessThan(INIT_BALANCE);
    }

    @Test
    void redoLastWithdrawNotMeetOverdraftLimit() {
        BankAccountCommand withdraw = new BankAccountCommand(bankAccount, BankAccountCommand.Action.WITHDRAW, WITHDRAW_AMOUNT_NOT_MEET_LIMIT);
        bankAccountExecutor.call(withdraw);
        assertThat(bankAccount.getBalance()).isEqualTo(INIT_BALANCE);

        bankAccountExecutor.undoLastAction();
        assertThat(bankAccount.getBalance()).isEqualTo(INIT_BALANCE);

        bankAccountExecutor.redoLastAction();
        assertThat(bankAccount.getBalance()).isEqualTo(INIT_BALANCE);
    }
}