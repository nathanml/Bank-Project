import java.sql.SQLException;
import java.util.ArrayList;

public class Customer extends User implements OPObserver{
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
    public Customer(String f, String l, String username, String password) throws SQLException {
        super(username, password);
        firstName = f;
        lastName = l;
        customerID = System.identityHashCode (this);
        DBConnect.addCustomer(customerID, firstName, lastName, username, password);
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
    
  //remove account
    public void removeCheckingAccount(CheckingAccount account)
    {
        checkingAccounts.remove (account);
        numberOfaccounts--;
    }

    public void removeSavingsAccount(SavingsAccount account)
    {
        savingsAccounts.remove (account);
        numberOfaccounts--;
    }

    public void removeSecuritiesAccount(SecuritiesAccount account)
    {
        securitiesAccounts.remove (account);
        numberOfaccounts--;
    }

    public void requestLoan(Loan loan)
    {
        loans.add(loan);
    }
    
    /*
    * Return the total savings in dollars
    */
    public int getSavings() {
        int savings = 0;
        if (savingsAccounts.size() > 0) {
            for (int i = 0; i<savingsAccounts.size(); i++) {
                Currency c = savingsAccounts.get(i).getCurrency();
		savings += c.convertToDollar(savingsAccounts.get(i).getMoney());
            }
        }
        return savings;
    }
    


    public int getID() {
        return customerID;
    }
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
