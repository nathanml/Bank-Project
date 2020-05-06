import java.sql.SQLException;

public class Stock {
    protected int stockID;
    protected String name;
    protected double valueUSD; //current price
    protected Customer owner;
    

    public Stock(String n, double val, Currency cur) throws SQLException {
        name = n;
        valueUSD = cur.convertToDollar(val);
        stockID = System.identityHashCode (this);
        //owner = null;
        
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

    public double getCurrentValue(Currency x) {
        return x.convertFromDollar(valueUSD);
    }
   

    public boolean equals(String input) {
        return input.equalsIgnoreCase(name);
    }

    public boolean equals(int id) {
        return (id == stockID);
    }

    public String toString() {
        double euro = Bank.getEuro().convertFromDollar (valueUSD);
        double pound = Bank.getPound().convertFromDollar (valueUSD);
        double yen = Bank.getYen().convertFromDollar (valueUSD);
        return "StockID: " + stockID + "; " + "Name: " + name + " " + " Value: (Euro) " + euro + " (Pound) " + pound + " (Yen) " + yen + " USD: " + valueUSD;

    }
    public static void main(String[] args)
    {

    }
}
