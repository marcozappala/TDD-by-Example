public abstract class Money {
  protected int amount;

  public Money(int amount) {
    this.amount = amount;
  }

  static Dollar dollar(int amount) {
    return new Dollar(amount);
  }

  static Franc franc(int amount) {
    return new Franc(amount);
  }

  abstract Money times(int multiplier);

  @Override
  public boolean equals(Object o) {
    Money otherMoney = (Money)o;
    return haveEqualsAmounts(otherMoney) && haveEqualClasses(otherMoney);
  }

  private boolean haveEqualClasses(Money otherMoney) {
    return this.getClass().equals(otherMoney.getClass());
  }

  private boolean haveEqualsAmounts(Money otherMoney) {
    return this.amount == otherMoney.amount;
  }

  abstract String currency();
}
