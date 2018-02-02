import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MoneyTest {

  @Test
  public void testDollarMultiplication() {
    Dollar five = Money.dollar(5);
    assertEquals(Money.dollar(10), five.times(2));
    assertEquals(Money.dollar(15), five.times(3));
  }

  @Test
  public void testEquals() {
    assertTrue((Money.dollar(5)).equals(Money.dollar(5)));
    assertFalse((Money.dollar(5)).equals(Money.dollar(10)));
    assertTrue((Money.franc(5)).equals(Money.franc(5)));
    assertFalse((Money.franc(5)).equals(Money.franc(10)));
    assertFalse((Money.dollar(5)).equals(Money.franc(5)));
  }

  @Test
  public void testFrancMultiplication() {
    Franc five = Money.franc(5);
    assertEquals(Money.franc(10), five.times(2));
  }

  @Test
  public void testCurrency() {
    assertEquals("USD", Money.dollar(1).currency());
    assertEquals("CHF", Money.franc(1).currency());

  }

}
