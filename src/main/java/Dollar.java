public class Dollar extends Money {

  Dollar(int amount) {
    super(amount);
  }

  @Override
  Dollar times(int multiplier) {
    return new Dollar(amount*multiplier);
  }

  public String currency() {
    return "USD";
  }
}
