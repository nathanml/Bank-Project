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
        double valueUSD = currency.convertToDollar (value);
        double valueEuro = Bank.Euro.convertFromDollar (valueUSD);
        double valuePound = Bank.Pound.convertFromDollar (valueUSD);
        double valueYen = Bank.Yen.convertFromDollar (valueUSD);
        DBConnect.addStock(stockID, name, owner.getID (), valueEuro, valuePound, valueUSD, valueYen);
    }
    public String getName() {
        return name; 
    }

    public int getID() {
        return stockID;
    }

    public double getPurchasedPrice(Currency x) {
        return x.convertTo(priceAtPurchase);
    }

    public double getCurrentValue(Currency x) {
        return x.convertTo(value);
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
