public class Money implements Expression {
    protected int amount;

    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public Expression plus(Money addend) {
        return new Sum(this, addend);
    }

    @Override
    public Money reduce(String toCurrency) {
        return this;
    }

    @Override
    public String toString() {
        return "Money{" + "amount=" + amount + ", currency='" + currency + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        Money otherMoney = (Money)o;
        return haveEqualsAmounts(otherMoney) && haveEqualsCurrency(otherMoney);
    }
    private boolean haveEqualsCurrency(Money otherMoney) {
        return this.currency == otherMoney.currency;
    }

    private boolean haveEqualsAmounts(Money otherMoney) {
        return this.amount == otherMoney.amount;
    }

    public String currency() {
        return currency;
    }

}
