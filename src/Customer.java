import java.util.ArrayList;

public class Customer extends User {
    /*
    * Customer class: Customers have accounts, stocks (if they have enough)
    * */

    ArrayList<Account> accounts= new ArrayList<Account> (); //list of all of the users' accounts. For now, can have at most 3 accounts
    ArrayList<Loan> loans = new ArrayList<Loan> (); //list of customer's loans
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
    public void addAccount(Account account)
    {
        accounts.add (account);
        numberOfaccounts++;
    }
    //display account
    public void displayAccount(Account account)
    {
        for(int i=0; i< accounts.size (); i++)
        {
            if ( accounts.get (i) != null)
            {
                System.out.println(accounts.get (i));
            }
        }

    }

}
