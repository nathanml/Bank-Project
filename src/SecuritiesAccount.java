import java.util.ArrayList;
import java.sql.SQLException;

public class SecuritiesAccount extends Account implements OPObserver{
    private ArrayList<Stock> currentHoldings;
    private double realizedProfit; 
    private double unrealizedProfit;
    private static StockMarket stockMarket = Bank.getStockMarket();
    private ArrayList<Stock> lastSold;

    public SecuritiesAccount(String name, double b, Currency c) throws SQLException {
        super (name, c.convertToDollar(b), Bank.getCurrentTime());
        double balanceUSD = c.convertToDollar(b);
        String type = "Securities";
        realizedProfit = 0;
        currentHoldings = new ArrayList<Stock> ();
        lastSold = new ArrayList<Stock> ();

        //For Database Connection
        double balanceEuro = Bank.getEuro().convertFromDollar (balanceUSD);
        double balancePound = Bank.getPound().convertFromDollar (balanceUSD);
        double balanceYen = Bank.getYen().convertFromDollar (balanceUSD);
        DBConnect.addAccount(accountID, name, owner.getID(),balanceEuro, balancePound, balanceUSD, balanceYen, type);
    }
    /*
     * Assume transfer is already converted to dollars. 
     */
    public static boolean openCondition(Customer customer, double transfer, Currency c) {
        return ((customer.getSavings(new Dollar()) > 5000) && (c.convertToDollar(transfer) > 1000));
    }

    public void update() {
        realizedProfit += stockMarket.calcRealizedProfit(this);
        lastSold = new ArrayList<Stock> (); //empty this list 
        unrealizedProfit = stockMarket.calcUnrealizedProfit(this);

    }
    /*
    * display the stocks this customer hold in the input currency in order of name, id, 
    * purchased price, current price
    */
    public String stockPrices(Currency x) {
        String str = "";
        if (currentHoldings.size() == 0) {
            str = "You currently don't have any Stocks";
        } else {
            for (int i = 0; i < currentHoldings.size(); i++)
            {
                Stock stock = currentHoldings.get(i);
                str = str + stock.getName() + " " + stock.getID() + " " + stock.getPurchasedPrice(x) + " " + stock.getCurrentValue(x) + "\n";
            }
        }
        return str;
    }
    public ArrayList<Stock> getHoldings(){
        return currentHoldings;
    }

    public ArrayList<Stock> getLastSold() {
        return lastSold;
    }
    
    public static void main(String[] args)
    {

    }
    public String print()
    {
        return "Account Name: " + name + ", Account Balance: " + balance + ", Account type: Securities Account";
    }
}
