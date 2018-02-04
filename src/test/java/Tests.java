import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class Tests {

    @Test
    public void testMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    public void testEquals() {
        assertTrue((Money.dollar(5)).equals(Money.dollar(5)));
        assertFalse((Money.dollar(5)).equals(Money.dollar(10)));
        assertTrue((Money.franc(5)).equals(Money.franc(5)));
    }

    @Test
    public void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());

    }

    @Test
    public void testSimpleAddition() {
        Bank bank = new Bank();
        Money fiveDollar = Money.dollar(5);
        Expression sum = fiveDollar.plus(fiveDollar);
        Expression reducedExpression = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reducedExpression);
    }

    @Test
    public void testPlusReturnSum() {
        Money fiveDollar = Money.dollar(5);
        Expression result = fiveDollar.plus(fiveDollar);
        Sum sum = (Sum)result;
        assertEquals(fiveDollar, sum.augend);
        assertEquals(fiveDollar, sum.addend);

    }

    @Test
    public void testReduceSum() {
        Bank bank = new Bank();
        Money fiveDollar = Money.dollar(5);
        Expression sum = new Sum(fiveDollar, fiveDollar);
        Expression result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), result);
    }

    @Test
    public void testReduceMoney() {
        Bank bank = new Bank();
        Expression reducedMoney = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), reducedMoney);
    }

    @Test
    public void testReduceMoneyDifferentCurrency() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression tenFrancReducedToDollar = bank.reduce(Money.franc(10), "USD");
        assertEquals(Money.dollar(5), tenFrancReducedToDollar);
    }

    @Test
    public void testIdentityRate() {
        assertEquals(1, new Bank().rate("USD", "USD"));
    }

    @Test
    public void testMixedAddition() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression tenFrancs = Money.franc(10);
        Expression fiveDollars = Money.dollar(5);
        Expression sum = tenFrancs.plus(fiveDollars);
        Expression result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), result);
    }

}
