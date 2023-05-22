import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DebitCardTest {
    private DebitCard debitCard;

    @Before
    public void setUp() {
        debitCard = new DebitCard("0987654321", "12/26", "321", "9876543210", "123456");
    }

    @Test
    public void testDebitCardCardNumber() {
        assertEquals(debitCard.getCardNumber(), "0987654321");
    }

    @Test
    public void testDebitCardExpiryDate() {
        assertEquals(debitCard.getExpiryDate(), "12/26");
    }

    @Test
    public void testDebitCardSecurityNumber() {
        assertEquals(debitCard.getSecurityNumber(), "321");
    }

    @Test
    public void testDebitCardAccountNumber() {
        assertEquals(debitCard.getAccountNumber(), "9876543210");
    }

    @Test
    public void testDebitCardSortCode() {
        assertEquals(debitCard.getSortCode(), "123456");
    }

    @Test
    public void testDebitCardTransactionLog() {
        List<String> transactionLog = debitCard.getTransactionLog();
        assertEquals(transactionLog.size(), 0);
    }

    @Test
    public void testDebitCardCharge() {
        debitCard.charge(50.0);
        List<String> transactionLog = debitCard.getTransactionLog();
        assertEquals(transactionLog.size(), 1);
        assertEquals(transactionLog.get(0), "Charged 50.0");
    }
}