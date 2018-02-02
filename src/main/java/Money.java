public class Money {
  protected int amount;

  public Money(int amount) {
    this.amount = amount;
  }

  Money times(int multiplier) {
    return new Money(amount * multiplier);
  }

  @Override
  public boolean equals(Object o) {
    Money otherMoney = (Money)o;
    return this.amount == otherMoney.amount;
  }
}
