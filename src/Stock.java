public class Stock {
    protected int stockID;
    protected String name;
    protected Currency currency;
    protected double value;
    protected Customer owner;

    public Stock(String n, double val, Currency cur)
    {
        name = n;
        value = val;
        currency = cur;
        stockID = System.identityHashCode (this);
        owner = null;
    }

    public static void main(String[] args)
    {

    }
}
