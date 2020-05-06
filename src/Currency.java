public abstract class Currency {
    protected String name;
    protected double conversionFactor;     //Conversion factor * universal rate = currency rate

    /*
    * Should a name and contain methods for conversion
    * */

    public Currency()
    {
       name = null;
       conversionFactor = 0;
    }

    /*
    * Convert from this currency to Dollar
    */
    public double convertToDollar(double x) {
        return (x /conversionFactor);
    }
    /*
    * Convert from Dollar to this currency
    */
    public double convertFromDollar(double x)
    {
        return (conversionFactor * x);
    }

    public double setConversionFactor() {
        return Bank.getExchangeRate(name);
    }
    public static void main(String[] args)
    {

    }
    public String toString() {
    	return name;
    }
}
