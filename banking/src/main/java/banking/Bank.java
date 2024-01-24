package banking;

import java.util.*;

/**
 * The Bank implementation.
 */
public class Bank implements BankInterface {
    private final LinkedHashMap<Long, Account> accounts;
    private Account account;
    private Long accountNumber;

    public Bank() {
        accounts = new LinkedHashMap<>();
    }

    private Account getAccount(Long accountNumber) {
        Optional<Map.Entry<Long,Account>> optionalAccount = accounts.entrySet().stream()
            .filter(account -> Objects.equals(account.getKey(), accountNumber))
            .findFirst();

        return optionalAccount.map(Map.Entry::getValue).orElse(null);
    }

    private Long getAccountNumber() {
        Optional<Map.Entry<Long, Account>> accountNumberOptional = accounts.entrySet().stream()
            .max(Map.Entry.comparingByKey());

        return accountNumberOptional
            .map(key -> key.getValue().getAccountNumber() + 1)
            .orElse(1L);
    }

    private Account createAccount(AccountHolder holder, Long accountNumber, int pin, double startingDeposit) {
        if (holder instanceof Company) {
            account = new CommercialAccount((Company) holder, accountNumber, pin, startingDeposit);
        } else if (holder instanceof Person) {
            account = new ConsumerAccount((Person) holder, accountNumber, pin, startingDeposit);
        }

        return account;
    }

    public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
        accountNumber = getAccountNumber();

        account = createAccount(company, accountNumber, pin, startingDeposit);

        accounts.put(accountNumber, account);

        return accountNumber;
    }

    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
        accountNumber = getAccountNumber();

        account = createAccount(person, accountNumber, pin, startingDeposit);

        accounts.put(accountNumber, account);

        return accountNumber;
    }

    public double getBalance(Long accountNumber) {
        if (checkAccountNumber(accountNumber)) {
            account = getAccount(accountNumber);

            return account.getBalance();
        }

        return -1.0;
    }

    public void credit(Long accountNumber, double amount) {
        if (checkAccountNumber(accountNumber)) {
            account = getAccount(accountNumber);

            account.creditAccount(amount);
        }
    }

    public boolean debit(Long accountNumber, double amount) {
        if (checkAccountNumber(accountNumber)) {
            account = getAccount(accountNumber);

            return account.debitAccount(amount);
        }

        return false;
    }

    public boolean authenticateUser(Long accountNumber, int pin) {
        // TODO: complete the method
        throw new RuntimeException("TODO");
    }

    public void addAuthorizedUser(Long accountNumber, Person authorizedPerson) {
        if (checkAccountNumber(accountNumber)) {
            CommercialAccount commercialAccount = (CommercialAccount) getAccount(accountNumber);
            commercialAccount.addAuthorizedUser(authorizedPerson);
        }
    }

    public boolean checkAuthorizedUser(Long accountNumber, Person authorizedPerson) {
        account = getAccount(accountNumber);
        if (account instanceof ConsumerAccount) {
            return false;
        }

        if (checkAccountNumber(accountNumber)) {
            CommercialAccount commercialAccount = (CommercialAccount) account;
            return commercialAccount.isAuthorizedUser(authorizedPerson);
        }

        return false;
    }

    public boolean checkAccountNumber(Long accountNumber) {
        if (accountNumber == null) {
            return false;
        }
        if (accountNumber == Long.MAX_VALUE) {
            return false;
        }

        return accountNumber != 0;
    }

    public Map<String, Double> getAverageBalanceReport() {
        Map<String, Double> avgBalance = new HashMap<>();
        int consumerCount = 0, commercialCount = 0;
        double consumerBalance = 0.0, commercialBalance = 0.0;

        for (Map.Entry<Long, Account> entry : accounts.entrySet()) {
            if (entry.getValue() instanceof ConsumerAccount) {
                consumerBalance = consumerBalance + entry.getValue().getBalance();
                consumerCount++;
                avgBalance.put("ConsumerAccount", consumerBalance / consumerCount);
            } else {
                commercialBalance = commercialBalance + entry.getValue().getBalance();
                commercialCount++;
                avgBalance.put("CommercialAccount", commercialBalance / commercialCount);
            }
        }

        return avgBalance;
    }
}
