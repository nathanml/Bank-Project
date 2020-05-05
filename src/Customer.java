import java.sql.SQLException;
import java.util.ArrayList;

public class Customer extends User implements Comparable<Customer>{
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
    //Compares the Amount of savings account because the Manager values his 
    //most wealthy customers
    public int compareTo(Customer other) {
        return (int) (this.getSavings(new Dollar()) - other.getSavings(new Dollar()));
    }

    public boolean equals(Customer other) {
        boolean equal = false;
        if (customerID == other.getID()) {
            equal = true;
        }
        return equal;
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

    public void requestLoan(Loan loan)
    {
        loans.add(loan);
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

    public double[][] savingsAccountInfo(Currency x) {
        int numOfSavings = savingsAccounts.size();
        double[][] summary = new double[numOfSavings][2]; //first col is balance, second col interest
        for (int i = 0; i<numOfSavings; i++) {
            summary[i][0] = x.convertFromDollar(savingsAccounts.get(i).getMoney());
            summary[i][1] = x.convertFromDollar(savingsAccounts.get(i).calcInterest(Bank.getCurrentTime()));
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
        double[][] summary = new double [length][3]; //first col amount, second interest, third days overdue
        for (int i = 0; i< checkingAccounts.size(); i++) {
            summary[i][0] = x.convertFromDollar(loans.get(i).getAmount());
            summary[i][1] = x.convertFromDollar(loans.get(i).totalInterest(Bank.getCurrentTime()));
            summary[i][2] = x.convertFromDollar(loans.get(i).overDue(Bank.getCurrentTime()));
        }
        return summary;
    }

    public int getID() {
        return customerID;
    }
    
}
