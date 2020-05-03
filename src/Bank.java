public class Bank {

    /*
    * Bank will have bank manager, customers, currencies, and ATM
    * */

    private BankManager bankManager;
    private Clock clock;
    public static Currency USD = new Currency ("US Dollar", 1.0);
    public static Currency Euro = new Currency ("Euro", 0.92);
    public static Currency Pound = new Currency ("Pound", 0.81);
    public static Currency Yen = new Currency ("Yen", 107.9);

    public Bank()
    {
        bankManager = new BankManager ();
        clock = new Clock ();
        Welcome w = new Welcome ();
    }

    public static void main(String[] args)
    {

    }
}
