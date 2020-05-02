import java.sql.SQLException;

public class Stock {
    protected int stockID;
    protected String name;
    protected Currency currency;
    protected double value;
    protected Customer owner;

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

    public static void main(String[] args)
    {

    }
}
