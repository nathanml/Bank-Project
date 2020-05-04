import java.sql.SQLException;

public class Stock {
    protected int stockID;
    protected String name;
    protected Currency currency;
    protected double value;
    protected Customer owner;
    private double priceAtPurchase;

    public Stock(String n, double val, Currency cur) throws SQLException {
        name = n;
        value = val;
        currency = cur;
        stockID = System.identityHashCode (this);
        owner = null;
        double valueUSD = cur.convertToDollar (value);
        double valueEuro = Bank.getEuro().convertFromDollar (valueUSD);
        double valuePound = Bank.getPound().convertFromDollar (valueUSD);
        double valueYen = Bank.getYen().convertFromDollar (valueUSD);
        DBConnect.addStock(stockID, name, owner.getID (), valueEuro, valuePound, valueUSD, valueYen);
    }
    public String getName() {
        return name; 
    }

    public int getID() {
        return stockID;
    }

    public double getPurchasedPrice(Currency x) {
        return x.convertFromDollar(priceAtPurchase);
    }

    public double getCurrentValue(Currency x) {
        return x.convertFromDollar(value);
    }
    /*
    * return the profit in dollars 
    */
    public double calcProfit() {
        return currency.convertToDollar(priceAtPurchase - value);
    }

    public boolean equals(String input) {
        return input.equalsIgnoreCase(name);
    }

    public boolean equals(int id) {
        return (id == stockID);
    }
    public static void main(String[] args)
    {

    }
}
