import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PaymentCardTest {
    private PaymentCard paymentCard;

    @Before
    public void setUp() {
        paymentCard = new PaymentCard("9876543210", "12/27", "567") {
            @Override
            public void charge(double amount) {
                super.charge(amount);
            }
        };
    }

    @Test
    public void testPaymentCardCardNumber() {
        assertEquals(paymentCard.getCardNumber(), "9876543210");
    }

    @Test
    public void testPaymentCardExpiryDate() {
        assertEquals(paymentCard.getExpiryDate(), "12/27");
    }

    @Test
    public void testPaymentCardSecurityNumber() {
        assertEquals(paymentCard.getSecurityNumber(), "567");
    }

    @Test
    public void testPaymentCardTransactionLog() {
        List<String> transactionLog = paymentCard.getTransactionLog();
        assertEquals(transactionLog.size(), 0);
    }

    @Test
    public void testPaymentCardCharge() {
        paymentCard.charge(50.0);
        List<String> transactionLog = paymentCard.getTransactionLog();
        assertEquals(transactionLog.size(), 1);
        assertEquals(transactionLog.get(0), "Charged 50.0");
    }
}