package banking;

/**
 * A bank transaction implementation.
 */
public class Transaction implements TransactionInterface {
    private final Long accountNumber;
    private final BankInterface bank;

    /**
     * @param bank          The bank where the account is housed.
     * @param accountNumber The customer's account number.
     * @param attemptedPin  The PIN entered by the customer.
     * @throws Exception Account validation failed.
     */
    public Transaction(BankInterface bank, Long accountNumber, int attemptedPin) throws Exception {
        if (!validateTransaction(bank, accountNumber, attemptedPin)) {
            throw new Exception("Invalid pin");
        }

        this.bank = bank;
        this.accountNumber = accountNumber;
    }

    private boolean validateTransaction(BankInterface bank, Long accountNumber, int attemptedPin) {
        return bank != null && accountNumber > 0 && attemptedPin > 0 && attemptedPin < 9999;
    }

    public double getBalance() {
        return bank.getBalance(accountNumber);
    }

    public void credit(double amount) {
        bank.credit(accountNumber, amount);
    }

    public boolean debit(double amount) {
        return bank.debit(accountNumber, amount);
    }

}
