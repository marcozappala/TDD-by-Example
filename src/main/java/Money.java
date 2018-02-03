public abstract class Money {
  protected int amount;
  protected String currency;

  public Money(int amount, String currency) {
    this.amount = amount;
    this.currency = currency;
  }

  static Dollar dollar(int amount) {
    return new Dollar(amount, "USD");
  }

  static Franc franc(int amount) {
    return new Franc(amount, "CHF");
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

  public String getCurrency() {
    return currency;
  }
}
