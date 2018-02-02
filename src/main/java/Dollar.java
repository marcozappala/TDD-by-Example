public class Dollar {
  private int amount;

  Dollar(int amount) {
    this.amount = amount;
  }

  Dollar times(int multiplier) {
    return new Dollar(amount * multiplier);
  }

  @Override
  public boolean equals(Object o) {
    Dollar otherDollar = (Dollar)o;
    return this.amount == otherDollar.amount;
  }
}
