import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
public class Bank {

    /*
    * Bank will have bank manager, customers, currencies, and ATM
    * */
    private static Clock currentTime;
    private static BankManager bankManager;
    private static double loanRate = 1.003; //3% per day
    private static double savingsRate = 1.001; //1% per day 
    private static double savInterestBenchMark = 5000; // $5000 to start collect interest
    private static double acctRemovalFee = 1;  //$1

    private static StockMarket stockMarket;
    //exchange rate used in subclass of Currency;
    private static ArrayList<String> currencies = new ArrayList<String> (Arrays.asList("Dollar, Euro, Pound, Yen"));
    private static ArrayList<Double> exchangeRate = new ArrayList<Double> (Arrays.asList(1.0, 0.92, 0.81, 107.9));
    private static Euro euro = new Euro();
    private static Pound pound = new Pound();
    private static Yen yen = new Yen();

    public Bank()
    {
        bankManager = new BankManager ("username", "password");
        currentTime = new Clock(5, 5, 2020); //hard-coded value to start with 
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
    public static BankManager getBankManager() {
        return bankManager;
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