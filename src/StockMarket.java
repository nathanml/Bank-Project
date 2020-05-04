import java.util.ArrayList;
public class StockMarket implements OPSubject{

    /*
    * Class that maintains the value of all stocks
    * */
    private ArrayList<OPObserver> observers;
    private ArrayList<Stock> stocks = new ArrayList<Stock> ();
    public StockMarket() {
        observers = new ArrayList<OPObserver> ();
        stocks = new ArrayList<Stock> ();
    }
    /*
    * removeStock - should be called only after contains return true
    */
    public Stock removeStock(String stockName) {
        Stock removed = null;
        for (int i = 0; i < stocks.size(); i++) {
            Stock s = stocks.get(i);
            if (s.equals(stockName)) {
                removed = s;
                stocks.remove(i);
                break;
            }
        }
        return removed;
    }

    public boolean contains(String stockName) {
        boolean contains = false;
        for (int i = 0; i < stocks.size(); i++) {
            if (stocks.get(i).equals(stockName)) {
                contains = true;
                break;
            }
        }
        return contains; 
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }
    //need to change getSavings in Customer so it return the value in dollars
    public boolean registerObserver(OPObserver securityAccount) {
        boolean registered = false;
        if (!observers.contains(securityAccount)) {
            observers.add(securityAccount);
            //create a security account with initBalance (> 1000)
            registered = true;
        }
        return registered;
    }

    public boolean unregisterObserver(OPObserver securityAccount) {
        return observers.remove(securityAccount);
    }
    /*
    * update the current stock price, customer's realized and unrealized profits etc
    */
    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update();
        }
    }
    
    public double calcRealizedProfit(SecuritiesAccount account) {
        ArrayList<Stock> sold = account.getLastSold();
        double profit = 0; // in dollars
        for (int i = 0; i < sold.size(); i++) {
            profit += sold.get(i).calcProfit();
        }
        return profit;
    }

    public double calcUnrealizedProfit(SecuritiesAccount account) {
        ArrayList<Stock> holdings = account.getHoldings();
        double profit = 0; // in dollars
        for (Stock stock : holdings) {
            profit += stock.calcProfit();
        }
        return profit;
    }
    public static void main(String[] args)
    {

    }
}
