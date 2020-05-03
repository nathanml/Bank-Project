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

    public boolean removeStock(String stockName) {
    	boolean removed = false;
    	for (int i = 0; i < stocks.size(); i++) {
    		if (stocks.get(i).getName().equalsIgnoreCase(stockName)) {
    			removed = true;
    			stocks.remove(i);
    			break;
    		}
    	}
    	return removed;
    }

    public void addStock(Stock stock) {
    	stocks.add(stock);
    }
    //need to change getSavings in Customer so it return the value in dollars
    public boolean registerObserver(OPObserver customer, int initBalance) {
    	boolean registered = false;
    	if (!observers.contains(customer) && customer.getSavings() > 5000) {
    		observers.add(customer);
    		//create a security account with initBalance (> 1000)
    		registered = true;
    	}
    	return registered;
    }

    public boolean unregisterObserver(OPObserver customer) {
    	return observers.remove(customer);
    }
    /*
    * update the current stock price, customer's realized and unrealized profits etc
    */
    public void notifyObserver() {
    	forEach(OPObserver o : observers) {
    		o.update();
    	}
    }
    //return the trade records of this date 
    public String getLastTrade(int date) {

    }
    public static void main(String[] args)
    {

    }
}
