import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CreditCardTest {
    private CreditCard creditCard;

    @Before
    public void setUp() {
        creditCard = new CreditCard("1234567890", "12/25", "123", 1000.0);
    }

    @Test
    public void testCreditCardCardNumber() {
        assertEquals(creditCard.getCardNumber(), "1234567890");
    }

    @Test
    public void testCreditCardExpiryDate() {
        assertEquals(creditCard.getExpiryDate(), "12/25");
    }

    @Test
    public void testCreditCardSecurityNumber() {
        assertEquals(creditCard.getSecurityNumber(), "123");
    }

    @Test
    public void testCreditCardAvailableCredit() {
        assertEquals(creditCard.getAvailableCredit(), 1000.0, 0.001);
    }

    @Test
    public void testCreditCardTransactionLog() {
        List<String> transactionLog = creditCard.getTransactionLog();
        assertEquals(transactionLog.size(), 0);
    }

    @Test
    public void testCreditCardCharge() {
        creditCard.charge(50.0);
        assertEquals(creditCard.getAvailableCredit(), 947.5, 0.001);
        List<String> transactionLog = creditCard.getTransactionLog();
        assertEquals(transactionLog.size(), 1);
        assertEquals(transactionLog.get(0), "Charged 52.5");
    }
}