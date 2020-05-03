import java.util.ArrayList;

public class Customer extends User {
    /*
    * Customer class: Customers have accounts, stocks (if they have enough)
    * */

    private String firstName;
    private String lastName;
    private int customerID;
    public ArrayList<CheckingAccount> checkingAccounts= new ArrayList<CheckingAccount> ();
    public ArrayList<SavingsAccount> savingsAccounts = new ArrayList<SavingsAccount> ();
    public ArrayList<SecuritiesAccount> securitiesAccounts = new ArrayList<SecuritiesAccount> ();
    private ArrayList<Loan> loans = new ArrayList<>(); //list of customer's loans
    private ArrayList<Stock> stocks = new ArrayList<> ();
    private int numberOfaccounts=0;
    //need to add stocks

    //Constructor 
    public Customer(String f, String l, String username, String password)
    {
        super(username, password);
        firstName = f;
        lastName = l;
        customerID = System.identityHashCode (this);
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
