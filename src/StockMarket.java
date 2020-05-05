import java.util.ArrayList;
public class StockMarket implements OPSubject{
    private class Node {
        private Stock stock;
        private int shares;
        public Node(Stock stock, int shares) {
            this.stock = stock;
            this.shares = shares;
        }
        private int getShares() {
            return shares;
        }
        private void setShare(int newShares) {
            if (newShares <= 0) {
                shares = 0;
            } else {
                shares = newShares;
            }
        }
    }
    /*
    * Class that maintains the value of all stocks
    * */
    private ArrayList<OPObserver> observers;
    private ArrayList<Node> stocks;
    
    public StockMarket() {
    	observers = new ArrayList<OPObserver>();
        stocks = new ArrayList<Node> ();
        //addStocksForTesting();
    }
    /*
    * removeStock - should be called only after contains return true
    */
    public StockService clientBuyStock(String stockName, int numShares, SecuritiesAccount a) {
        StockService bought = null;
        for (int i = 0; i < stocks.size(); i++) {
            Node s = stocks.get(i); 
            if (s.stock.equals(stockName)) {
                if (numShares > s.shares){
                    numShares = s.shares;
                }
                bought = new StockService(s.stock.getCurrentValue(new Dollar()), new Dollar(), numShares, s.stock, a);
                s.setShare(s.shares - numShares);
                break;
            }
        }
        notifyObserver();
        return bought;
    }

    public void clientSellStock(Stock sell, int shares) {
        for (int i = 0; i < stocks.size(); i++) {
            Node s = stocks.get(i); 
            if (s.stock.equals(sell)) {
                s.setShare(s.getShares() + shares);
                break;
            }
        } 
        notifyObserver();
    }

    //need to change getSavings in Customer so it return the value in dollars
    public boolean registerObserver(OPObserver customer) {
        boolean canRegister = (!observers.contains(customer)); //customer's equals method
        if (canRegister) {
            observers.add(customer);
        }
        return canRegister;
    }

    public boolean unregisterObserver(OPObserver customer) {
        boolean canUnReg = observers.contains(customer);
        if (canUnReg) {
            observers.remove(customer);
            customer.update2(); //remove all securitiesAccount transfter into savings
        }
        return canUnReg;
    }
    /*
    * update the current stock price, customer's realized and unrealized profits etc
    */
    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update1();
        }
    }
    
    public ArrayList<Stock> getStockAvailable() {
        ArrayList<Stock> available = new ArrayList<Stock>();
        for (int i = 0; i < stocks.size(); i++) {
            if (stocks.get(i).getShares() > 0) {
                available.add(stocks.get(i).stock);
            }
        }
        return available;
    }

    public static void main(String[] args)
    {

    }
}
