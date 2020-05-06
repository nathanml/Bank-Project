import java.util.ArrayList;
import java.sql.SQLException;

public class SecuritiesAccount extends Account{
    private ArrayList<StockService> currentHoldings;
    private double realizedProfit; 
    private double unrealizedProfit;
    private static StockMarket stockMarket = Bank.getStockMarket();
    

    public SecuritiesAccount(String name, double b, Currency c) throws SQLException {
        super (name, b, c);
        
        
        realizedProfit = 0; //need to Store 
        currentHoldings = new ArrayList<StockService> ();

        //For Database Connection
        String type = "Securities";
        double balanceUSD = c.convertToDollar(b);
        double balanceEuro = Bank.getEuro().convertFromDollar (balanceUSD);
        double balancePound = Bank.getPound().convertFromDollar (balanceUSD);
        double balanceYen = Bank.getYen().convertFromDollar (balanceUSD);
        DBConnect.addAccount(accountID, name, owner.getID(),balanceEuro, balancePound, balanceUSD, balanceYen, type);
    }

    public SecuritiesAccount(int id, String n, double b, Clock opened, Customer own) throws SQLException {
        super(id,n,b,opened,own);
    }
    /*
     * Assume transfer is already converted to dollars. 
     */
    public static boolean openCondition(Customer customer, double transfer, Currency c) {
        return ((customer.getSavings(new Dollar()) > 5000) && (c.convertToDollar(transfer) > 1000));
    }
    
    public double total() {
    	return (realizedProfit+unrealizedProfit);
    }
    public ArrayList<StockService> getHoldings(){
        return currentHoldings;
    }
    
    public void collectInterest(double x) {
    	realizedProfit += x;
    }
    public void buy(String stockName, int numShares) {
        StockService bought = Bank.getStockMarket().clientBuyStock(stockName, numShares, this);
        currentHoldings.add(bought);
    }

    public boolean sell(int i, int numShares) {
        boolean sold = false;
        if (currentHoldings.get(i).diminishable(numShares)) {
            sold = true;
            currentHoldings.get(i).diminish(numShares);
            Bank.getStockMarket().clientSellStock(currentHoldings.get(i).getStock(), numShares);
        }
        return sold;
    }

   // public void update() {
        //update the unrealized profit;
        //unrealizedProfit = stockMarket.calcUnrealizedProfit(this);

    //}
    /*
    * number of openings = number of rows, 1st col = name of stock, 
    * 2nd col = number of Shares, 3rd col = dates of purchase 
    */
    public String[][] openingsSummary() {
        ArrayList<String> open = openPositions();
        String[][] summary = new String[open.size()][3];
        int[] shares = new int[open.size()];
        if (currentHoldings.size() > 0) {
              for (int i = 0; i < open.size(); i++) {
                summary[i][0] = open.get(i);
                for (int j = 0; j < currentHoldings.size(); j++) {
                    if (currentHoldings.get(j).getStockName().equalsIgnoreCase(open.get(i))) {
                        shares[i] += currentHoldings.get(j).getNumShare();
                        summary[i][2] =  summary[i][2] + currentHoldings.get(j).getPD().toString() + "; ";
                    }
                }
             }
        }
        for (int i = 0; i < open.size(); i++) {
            summary[i][1] = shares[i] + "";
        }
        return summary;
    }
    //helper method to openingsSummary
    private ArrayList<String> openPositions() {
        ArrayList<String> count = new ArrayList<String>();
        for (int i = 0; i<currentHoldings.size(); i++) {
            String name = currentHoldings.get(i).getStockName();
            if (!count.contains(name)) {
                count.add(name);
            }
        }
        return count;
    }

    //value bought, current value, num of shares, unrealized profit
    public double[][] profitSummary(Currency x) {
        double[][] summary = new double[currentHoldings.size()][];
        for (int i = 0; i<currentHoldings.size(); i++) {
            summary[i] = currentHoldings.get(i).getSummary(x);
        }
        return summary;
    }
    
    

    public static void main(String[] args)
    {

    }
    public String print()
    {
        return "Account Name: " + name + ", Account Balance: " + balance ;
    }
}
