package banking;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The Bank implementation.
 */
public class Bank implements BankInterface {
    private LinkedHashMap<Long, Account> accounts;

    public Bank() {
        // TODO: complete the constructor
    }

    private Account getAccount(Long accountNumber) {
        // TODO: complete the method
        throw new RuntimeException("TODO");
    }

    public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
        // TODO: complete the method
        throw new RuntimeException("TODO");
    }

    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
        // TODO: complete the method
        throw new RuntimeException("TODO");
    }

    public double getBalance(Long accountNumber) {
        // TODO: complete the method
        throw new RuntimeException("TODO");
    }

    public void credit(Long accountNumber, double amount) {
        // TODO: complete the method
    }

    public boolean debit(Long accountNumber, double amount) {
        // TODO: complete the method
        throw new RuntimeException("TODO");
    }

    public boolean authenticateUser(Long accountNumber, int pin) {
        // TODO: complete the method
        throw new RuntimeException("TODO");
    }

    public void addAuthorizedUser(Long accountNumber, Person authorizedPerson) {
        // TODO: complete the method
    }

    public boolean checkAuthorizedUser(Long accountNumber, Person authorizedPerson) {
        // TODO: complete the method
        throw new RuntimeException("TODO");
    }

    public Map<String, Double> getAverageBalanceReport() {
        // TODO: complete the method
        throw new RuntimeException("TODO");
    }
}
