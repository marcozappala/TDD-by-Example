public class Pair {
    String from;
    String to;

    public Pair(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        Pair otherPair = (Pair) o;
        return from.equals(otherPair.from) && to.equals(otherPair.to);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
