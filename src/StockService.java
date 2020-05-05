//add equals method 
public class StockService extends Service {
	private Stock stock;
	private int numShares; 
	private SecuritiesAccount account;
	public StockService(double value, Currency cur, int numShares, Stock stock, SecuritiesAccount a) {
		super(value, cur);
		this.stock = stock;
		this.numShares = numShares;
		account = a;
	}
	/*
	* unrealizedProfit used to update the current unrealized profit of the 
	* Security Account 
	*/
	public double unrealizedProfit(Currency x) {
		return (stock.getCurrentValue(x) - x.convertFromDollar(initialValueUSD)) * numShares;
	}
	
	/*
	* realizedProfit - check that shares <= numShares before calling, return a USD value
	*/
	public double interestOnService(int shares) {
		return (stock.getCurrentValue(new Dollar()) - initialValueUSD) * shares;
	}
	/*
	* check shares <= numShares before calling cutDown
	*/
	public void diminish(int shares) {
		account.collectInterest(interestOnService(shares));
		numShares -= shares;
		close(); //check if the close condition is met 
	} 

	public boolean diminishable(int shares) {
		return (shares <= numShares);
	}

	public void close() {
		if (closeCondition()) {
			account.getHoldings().remove(this);
		}
	}

	public boolean closeCondition() {
		return (numShares == 0);
	}

	public String getStockName() {
		return stock.getName();
	}

	public Stock getStock() {
		return stock;
	}

	public int getNumShare() {
		return numShares;
	}

	public double[] getSummary(Currency x) {
		double[] summary = new double[4];
		summary[0] = x.convertFromDollar(initialValueUSD);
		summary[1] = stock.getCurrentValue(x);
		summary[2] = numShares;
		summary[3] = unrealizedProfit(x);
		return summary;
	}
	

}