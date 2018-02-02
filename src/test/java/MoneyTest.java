import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MoneyTest {

  @Test
  public void testDollarMultiplication() {
    Dollar five = new Dollar(5);
    assertEquals(new Dollar(10), five.times(2));
    assertEquals(new Dollar(15), five.times(3));
  }

  @Test
  public void testEquals() {
    assertTrue((new Dollar(5)).equals(new Dollar(5)));
    assertFalse((new Dollar(5)).equals(new Dollar(10)));
    assertTrue((new Franc(5)).equals(new Franc(5)));
    assertFalse((new Franc(5)).equals(new Franc(10)));
  }

  @Test
  public void testFrancMultiplication() {
    Franc five = new Franc(5);
    assertEquals(new Franc(10), five.times(2));
  }

}
