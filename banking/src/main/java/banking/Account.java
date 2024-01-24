package banking;

/**
 * Abstract bank account.
 */
public abstract class Account implements AccountInterface {
    private AccountHolder accountHolder;
    private Long accountNumber;
    private int pin;
    private double balance;

    protected Account(AccountHolder accountHolder, Long accountNumber, int pin, double startingDeposit) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = getBalance() + startingDeposit;
    }

    public AccountHolder getAccountHolder() {
        return accountHolder;
    }

    public boolean validatePin(int attemptedPin) {
        return attemptedPin != 0 && attemptedPin >= 0 && attemptedPin < 9999;
    }

    public double getBalance() {
        return balance;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void creditAccount(double amount) {
        balance = getBalance() + amount;
    }

    public boolean debitAccount(double amount) {
        if (getBalance() <= 0.0 || amount > getBalance()) {
            return false;
        }

        balance = getBalance() - amount;

        return true;
    }
}
