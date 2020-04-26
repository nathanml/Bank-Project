import java.util.ArrayList;

public class Customer extends User {
    /*
    * Customer class: Customers have accounts, stocks (if they have enough)
    * */

    private ArrayList<CheckingAccount> checkingAccounts= new ArrayList<CheckingAccount> ();
    private ArrayList<SavingsAccount> savingsAccounts = new ArrayList<SavingsAccount> ();
    private ArrayList<SecuritiesAccount> securitiesAccounts = new ArrayList<SecuritiesAccount> ();
    private ArrayList<Loan> loans = new ArrayList<Loan> (); //list of customer's loans
    private ArrayList<Stock> stocks = new ArrayList<Stock> ();
    private int numberOfaccounts=0;
    //need to add stocks

    //Constructor 
    public Customer(String username, String password)
    {
        super(username, password);
    }
    //no args constructor
    public Customer()
    {
        super();
    }

    //add account
    public void addCheckingAccount(CheckingAccount account)
    {
        checkingAccounts.add (account);
        numberOfaccounts++;
    }

    public void addSavingsAccount(SavingsAccount account)
    {
        savingsAccounts.add (account);
        numberOfaccounts++;
    }

    public void addSecuritiesAccount(SecuritiesAccount account)
    {
        securitiesAccounts.add (account);
        numberOfaccounts++;
    }

    public void requestLoan(Loan loan)
    {
        loans.add(loan);
    }



}
