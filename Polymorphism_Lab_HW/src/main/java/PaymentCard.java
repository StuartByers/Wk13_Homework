import java.util.ArrayList;
import java.util.List;

abstract class PaymentCard implements IChargeable {
    private String cardNumber;
    private String expiryDate;
    private String securityNumber;
    private List<String> transactionLog;

    public PaymentCard(String cardNumber, String expiryDate, String securityNumber) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.securityNumber = securityNumber;
        this.transactionLog = new ArrayList<>();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getSecurityNumber() {
        return securityNumber;
    }

    public List<String> getTransactionLog() {
        return transactionLog;
    }

    public void charge(double amount) {
        transactionLog.add("Charged " + amount);
    }
}