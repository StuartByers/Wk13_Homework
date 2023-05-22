import java.util.ArrayList;
import java.util.List;

class CreditCard extends PaymentCard {
    private double availableCredit;
    private List<String> transactionLog;

    public CreditCard(String cardNumber, String expiryDate, String securityNumber, double availableCredit) {
        super(cardNumber, expiryDate, securityNumber);
        this.availableCredit = availableCredit;
        this.transactionLog = new ArrayList<>();
    }

    public double getAvailableCredit() {
        return availableCredit;
    }

    public List<String> getTransactionLog() {
        return transactionLog;
    }

    @Override
    public void charge(double amount) {
        double transactionCost = amount * 1.05;
        availableCredit -= transactionCost;
        transactionLog.add("Charged " + transactionCost);
    }
}