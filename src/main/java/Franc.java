public class Franc extends Money {

  Franc(int amount) {
    super(amount);
  }

  @Override
  Franc times(int multiplier) {
    return new Franc(amount*multiplier);
  }

  public String currency() {
    return "CHF";
  }
}
