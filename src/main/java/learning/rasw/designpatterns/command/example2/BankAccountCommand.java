package learning.rasw.designpatterns.command.example2;

public class BankAccountCommand implements Command {
    enum Action{DEPOSIT, WITHDRAW}

    private BankAccount bankAccount;
    private Action action;
    private int amount;

    public BankAccountCommand(BankAccount bankAccount, Action action, int amount) {
        this.bankAccount = bankAccount;
        this.action = action;
        this.amount = amount;
    }

    @Override
    public void call() {
        switch (action) {
            case DEPOSIT:
                bankAccount.deposit(amount);
                break;
            case WITHDRAW:
                bankAccount.withdraw(amount);
                break;
        }
    }


}
