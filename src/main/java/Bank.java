import java.util.Hashtable;

public class Bank {
    Hashtable<Pair, Integer> ratesTable = new Hashtable<Pair, Integer>();

    public Expression reduce(Expression expression, String toCurrency) {
        return expression.reduce(this, toCurrency);

    }

    public void addRate(String from, String to, int rate) {
        ratesTable.put(new Pair(from, to), rate);
    }

    public int rate(String from, String to) {
        if (from.equals(to)) return 1;
        int rate = ratesTable.get(new Pair(from, to)).intValue();
        return rate;
    }
}
