import java.sql.SQLException;
import java.util.ArrayList;

public class Customer extends User implements Comparable<Customer>, OPObserver{
    /*
    * Customer class: Customers have accounts, stocks (if they have enough)
    * */
    private String firstName;
    private String lastName;
    private int customerID;
    private ArrayList<CheckingAccount> checkingAccounts= new ArrayList<CheckingAccount> ();
    private ArrayList<SavingsAccount> savingsAccounts = new ArrayList<SavingsAccount> ();
    private ArrayList<SecuritiesAccount> securitiesAccounts = new ArrayList<SecuritiesAccount> ();
    private ArrayList<Loan> loans = new ArrayList<Loan>(); //list of customer's loans
    private int numberOfaccounts=0;
    private String availableStocks; 
    //need to add stocks

    //Constructor 
    public Customer(String f, String l, String username, String password) throws SQLException {
        super(username, password);
        firstName = f;
        lastName = l;
        customerID = System.identityHashCode (this);
        DBConnect.addCustomer(customerID, firstName, lastName, username, password);
    }

    public Customer(int ID, String f, String l, String username, String password) throws SQLException {
        super(username, password);
        firstName = f;
        lastName = l;
        customerID = ID;

        //checkingAccounts = DBConnect.getCheckingAccounts(customerID);
    }

    //no args constructor
    public Customer()
    {
        super();
    }
    //Compares the Amount of savings account because the Manager values his 
    //most wealthy customers
    public int compareTo(Customer other) {
        return (int) (this.getSavings(new Dollar()) - other.getSavings(new Dollar()));
    }

    public boolean equals(Customer other) {
        return (customerID == other.getID());
    }
    
    public ArrayList<CheckingAccount> getCheckingAccounts() {
        return checkingAccounts;
    }
    
    public ArrayList<SavingsAccount> getSavingsAccounts() {
        return savingsAccounts;
    }
    
    public ArrayList<SecuritiesAccount> getSecuritiesAccounts() {
        return securitiesAccounts;
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

    /*
    * update2 - allows the observer to get unregistered from the StockMarket
    */
    public void update2() {
        if (savingsAccounts.size() > 0) {
            savingsAccounts.get(0).deposit(totalSec(new Dollar()));
        } else {
            SavingsAccount newAccount = new SavingsAccount("Deposit from Stocks", totalSec(new Dollar()), new Dollar());
            savingsAccounts.add(newAccount);
        }
    }
    
    public boolean dealingStocks() {
        return (securitiesAccounts.size() > 0);
    }
   
    public void requestLoan(Loan loan)
    {   
        Bank.getBankManager().addLoan();
        loans.add(loan);
    }
    
    public ArrayList<Loan> getLoans() {
    	return loans;
    }

    /*
    * update1 - returns a String of all the stocks currently available 
    */
    public void update1() {
        String str = "";
        if (securitiesAccounts.size() > 0) {
            ArrayList<Stock> stocks = Bank.getStockMarket().getStockAvailable();
            for (int i = 0; i< stocks.size(); i++) {
                str = str + stocks.get(i).toString() + "\n";
            }
        }
        availableStocks = str;
    }

    public String getAvailableStock() {
        String str = "";
        if (dealingStocks()) {
            str= availableStocks;
        } else {
            str = "Access Denied";
        }
        return str;
    }
    
    
    public double getLoan(Currency x) {
        double totalLoans = 0;
        if (loans.size() > 0) {
            for (int i = 0; i<loans.size(); i++) {
                Loan l = loans.get(i);
                totalLoans = totalLoans + l.getMoney();
            }
        }
        return x.convertFromDollar(totalLoans);
    }
    
    
    public double totalSec(Currency x) {
    	double total = 0;
        if (securitiesAccounts.size() > 0) {
            for (int i = 0; i<securitiesAccounts.size(); i++) {
                total += securitiesAccounts.get(i).total();
            }
        }
        return x.convertFromDollar(total);
    	
    }
    
    /*
     * Return the total savings in dollars, change to getSavings (Currency x)
     */
     public double getSavings(Currency x) {
         int savings = 0;
         if (savingsAccounts.size() > 0) {
             for (int i = 0; i<savingsAccounts.size(); i++) {
                 savings += savingsAccounts.get(i).getMoney();
             }
         }
         return x.convertFromDollar(savings);
     }
     
    public double totalAmount(ArrayList<Account> accounts, Currency x) {
    	int total = 0;
    	if (accounts.size() > 0) {
    		for (int i = 0; i<accounts.size(); i++) {
    			total += accounts.get(i).getMoney();
            }
    	}
    	return x.convertFromDollar(total);
    }

    public double[][] savingsAccountInfo(Currency x) {
        int numOfSavings = savingsAccounts.size();
        double[][] summary = new double[numOfSavings][2]; //first col is balance, second col interest
        for (int i = 0; i<numOfSavings; i++) {
            summary[i][0] = x.convertFromDollar(savingsAccounts.get(i).getMoney());
            summary[i][1] = x.convertFromDollar((savingsAccounts.get(i)).calcInterest());
        }
        return summary;
    }

    public double[] checkingAccount (Currency x) {
        double[] summary = new double[checkingAccounts.size()];
        for (int i = 0; i< checkingAccounts.size(); i++) {
            summary[i] = x.convertFromDollar(checkingAccounts.get(i).getMoney());
        }
        return summary;
    }

    public double[][] loanSummary(Currency x) {
        int length = loans.size();
        double[][] summary = new double [length][2]; //first col amount, second interest, third days overdue
        for (int i = 0; i< checkingAccounts.size(); i++) {
            summary[i][0] = x.convertFromDollar(loans.get(i).getMoney());
            summary[i][1] = x.convertFromDollar(loans.get(i).overDue(Bank.getCurrentTime()));
        }
        return summary;
    }

    public int getID() {
        return customerID;
    }
	
	public boolean equals(OPObserver other) {
		return (other.getName().equalsIgnoreCase(this.getName()));
	}
	
	public String getName() {
		return firstName;
	}
    
}
