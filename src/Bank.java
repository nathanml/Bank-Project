import java.util.ArrayList;
import java.util.Arrays;
public class Bank {

    /*
    * Bank will have bank manager, customers, currencies, and ATM
    * */

    private static BankManager bankManager;
    public static Clock currentTime;
    private static double loanRate; //loan rate per day an integer over 1
    private static double savingsRate; //savings interest rate 
    private static double acctRemovalFee; 
    private static StockMarket stockMarket;
    //exchange rate unsed in subclass of Currency;
    private static ArrayList<String> currencies;
    private static ArrayList<Double> exchangeRate;
    private static Euro euro = new Euro();
    private static Pound pound = new Pound();
    private static Yen yen = new Yen();

    public Bank()
    {
        bankManager = new BankManager ("username", "password");
        currencies = new ArrayList<String> (Arrays.asList("Dollar, Euro, Pound, Yen"));
        exchangeRate = new ArrayList<Double> (Arrays.asList(1.0, 0.92, 0.81, 107.9));
        loanRate = 1.003; //3% per day 
        savingsRate = 1.0001; //0.1% per day 
        acctRemovalFee = 1;
        currentTime = bankManager.setTime(); //bank manager sets the current time 
        Welcome w = new Welcome ();
    }

    public static boolean setRemovalfee(double money)
    {   
        boolean set = false;
        if (money >= 0) {
            acctRemovalFee = money; 
            set = true;
        }
        return set;

    } 
   
    public static double getRemovalfee()
    {
        return acctRemovalFee; 
    } 

    public static Clock getCurrentTime() {
        return currentTime;
    }
    
    public static StockMarket getStockMarket() {
        return stockMarket;
    }
    public static BankManager getBankManager() {
        return bankManager;
    }
    /*
    * Return -1 if the input is not in the currencies list. 
    */
    public static double getExchangeRate(String currency) {
        double rate = -1;
        int index = -1;
        if (currencies.contains(currency)) {
            index = currencies.indexOf(currency);
        }
        if (index != -1) {
            rate = exchangeRate.get(index);
        }
        return rate;
    }

    /*
    * used to modify or add an exchange rate
    */
    public static void changeRate(String currency, double rate) {
        Double newRate = new Double(rate);
        if (currencies.contains(currency)) {
            int index = currencies.indexOf(currency);
            currencies.remove(index);
            exchangeRate.remove(index);
            currencies.add(currency);
            exchangeRate.add(newRate);
        } else {
            currencies.add(currency);
            exchangeRate.add(newRate);
        }
    } 
    public static String getRate() {
        String str = "";
        for (int i = 0; i< Math.min(currencies.size(), exchangeRate.size()); i++) {
            str = str + "<" + currencies.get(i) + ">: " + exchangeRate.get(i) + "\n";
        }
        return str;
    }

    public static double getSavingsRate() {
        return savingsRate;
    }

    public static double getLoanRate() {
        return loanRate;
    }

    public static Euro getEuro() {
        return euro;
    }
    public static Pound getPound() {
        return pound;
    }

    public static Yen getYen() {
        return yen;
    }
    public static void main(String[] args)
    {

    }
}
