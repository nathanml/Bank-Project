public class Currency {
    private String name;
    private int conversionFactor;     //Conversion factor * universal rate = currency rate

    /*
    * Should a name and contain methods for conversion
    * */

    public Currency(String n, int cf)
    {
        name = n;
        conversionFactor = cf;
    }

    public int convertFromDollar(int x)
    {
        return (conversionFactor * x);
    }

    public int convertToDollar(int x)
    {
        return (x / conversionFactor);
    }

    public void setConversionFactor(int x)
    {
        conversionFactor = x;
    }

    public static void main(String[] args)
    {

    }
}
