package learning.rasw.designpatterns.command.example2;




public class BankAccount {
    private int balance;
    private int overdraftLimit;

    public BankAccount(int balance, int overdraftLimit) {
        this.balance = balance;
        this.overdraftLimit = overdraftLimit;
    }

    public void deposit(int amount){
        balance += amount;
        System.out.println(String.format("Deposit amount %s, Balance is now %s", amount, balance));
    }

    public boolean withdraw(int amount){
        if(balance - amount >= overdraftLimit){
            balance -= amount;
            System.out.println(String.format("Withdraw amount %s, Balance is now %s", amount, balance));
            return true;
        }
        return false;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                '}';
    }
}
