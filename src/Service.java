public abstract class Service {
	protected String type;
	protected double initialValueUSD;
	protected Clock purchasedDate;

	public Service(double value, Currency cur) {
		initialValueUSD = cur.convertToDollar(value);
		purchasedDate = Bank.getCurrentTime();
	}

	public Service() {
		initialValueUSD = 0;
		purchasedDate = Bank.getCurrentTime();
	}

	public boolean equals(Service other) {
		return ((type.equalsIgnoreCase(other.getType())) && (purchasedDate.equals(other.getPD())) && (initialValueUSD == other.getInitValue())); 
	}
	
	public String getType() {
		return type;
	}
	
	public Clock getPD() {
		return purchasedDate;
	}
	
	public double getInitValue() {
		return initialValueUSD;
	}
	/*
	* cutDown - since this type of Service is dependent on purchasedDate, 
	* it's can only be reduced but not increase (increase would be process
	* as creating a new Service object). 
	*/
	public abstract void diminish(int amount);

	public abstract boolean diminishable(int amount);

	public abstract void close();

	public abstract boolean closeCondition();

	public abstract double interestOnService(int amount);
	

	
}