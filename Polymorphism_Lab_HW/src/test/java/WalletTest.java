import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WalletTest {
    private Wallet wallet;
    private CreditCard creditCard;
    private DebitCard debitCard;

    @Before
    public void setUp() {
        wallet = new Wallet();
        creditCard = new CreditCard("1234567890", "12/25", "123", 1000.0);
        debitCard = new DebitCard("0987654321", "12/26", "321", "9876543210", "123456");
    }

    @Test
    public void testWalletAddCreditCard() {
        wallet.addChargeable(creditCard);
        assertEquals(wallet.getChargeables().size(), 1);
    }

    @Test
    public void testWalletAddDebitCard() {
        wallet.addChargeable(debitCard);
        assertEquals(wallet.getChargeables().size(), 1);
    }

    @Test
    public void testWalletSelectCard() {
        wallet.addChargeable(creditCard);
        wallet.addChargeable(debitCard);
        wallet.selectChargeable(1);
        assertEquals(wallet.getSelectedChargeable(), debitCard);
    }

    @Test
    public void testWalletPayWithSelectedCard() {
        wallet.addChargeable(creditCard);
        wallet.selectChargeable(0);
        double amount = 100.0;
        wallet.pay(amount);
        assertEquals(creditCard.getAvailableCredit(), 895.0, 0.001);
    }
}