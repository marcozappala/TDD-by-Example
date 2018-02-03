public class Dollar extends Money {

    Dollar(int amount, String currency) {
        super(amount, currency);
    }

    @Override
    Dollar times(int multiplier) {
        return Money.dollar(amount * multiplier);
    }

}
