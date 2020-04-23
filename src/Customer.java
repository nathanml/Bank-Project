public class Customer extends User {
    /*
    * Customer class: Customers have accounts, stocks (if they have enough)
    * */

    Account[] accounts= new Account[3]; //list of all of the users' accounts. For now, can have at most 3 accounts
    int numberOfaccounts=0;
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
        accounts[numberOfaccounts]= account;
        numberOfaccounts++;
    }
    //display account
    public void displayAccount(Account account)
    {
        for(int i=0; i< accounts.length; i++)
        {
            if ( accounts[i] != null)
            {
                System.out.println(accounts[i]);
            }
        }

    }

}
