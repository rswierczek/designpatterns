package learning.rasw.designpatterns.command.example2;

public class BankAccountCommand implements Command {


    enum Action{DEPOSIT, WITHDRAW}

    private BankAccount bankAccount;
    private Action action;
    private int amount;
    private boolean succeeded;

    public BankAccountCommand(BankAccount bankAccount, Action action, int amount) {
        this.bankAccount = bankAccount;
        this.action = action;
        this.amount = amount;
    }

    @Override
    public void call() {
        switch (action) {
            case DEPOSIT:
                succeeded = true;
                bankAccount.deposit(amount);
                break;
            case WITHDRAW:
                succeeded = bankAccount.withdraw(amount);
                break;
        }
    }

    @Override
    public void undo() {

        if (isSucceeded()) {
            switch (action) {
                case DEPOSIT:
                    bankAccount.withdraw(amount);
                    break;
                case WITHDRAW:
                    bankAccount.deposit(amount);
                    break;
            }
        }
    }

    @Override
    public void redo() {
        if (isSucceeded()) {
            call();
        }
    }

    public boolean isSucceeded() {
        return succeeded;
    }

    @Override
    public String toString() {
        return "BankAccountCommand{" +
                "bankAccount=" + bankAccount +
                ", action=" + action +
                ", amount=" + amount +
                '}';
    }
}
