import java.util.ArrayList;
import java.util.List;

class DebitCard extends PaymentCard {
    private String accountNumber;
    private String sortCode;
    private List<String> transactionLog;

    public DebitCard(String cardNumber, String expiryDate, String securityNumber, String accountNumber, String sortCode) {
        super(cardNumber, expiryDate, securityNumber);
        this.accountNumber = accountNumber;
        this.sortCode = sortCode;
        this.transactionLog = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getSortCode() {
        return sortCode;
    }

    public List<String> getTransactionLog() {
        return transactionLog;
    }

    @Override
    public void charge(double amount) {
        transactionLog.add("Charged " + amount);
    }
}
