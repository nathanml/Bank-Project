public class Currency {
    private String name;
    private double conversionFactor;     //Conversion factor * universal rate = currency rate

    /*
    * Should a name and contain methods for conversion
    * */

    public Currency(String n, double cf)
    {
        name = n;
        conversionFactor = cf;
    }

    public int convertFromDollar(double x)
    {
        return (int) (conversionFactor * x);
    }

    public double convertToDollar(double x)
    {
        return (x / conversionFactor);
    }

    public void setConversionFactor(double x)
    {
        conversionFactor = x;
    }

    public static void main(String[] args)
    {

    }
}
