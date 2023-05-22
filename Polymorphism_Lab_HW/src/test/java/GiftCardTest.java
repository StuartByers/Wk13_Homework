import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GiftCardTest {
    private GiftCard giftCard;

    @Before
    public void setUp() {
        giftCard = new GiftCard(500.0);
    }

    @Test
    public void testGiftCardBalance() {
        assertEquals(giftCard.getBalance(), 500.0, 0.001);
    }

    @Test
    public void testGiftCardCharge() {
        giftCard.charge(50.0);
        assertEquals(giftCard.getBalance(), 450.0, 0.001);
    }
}