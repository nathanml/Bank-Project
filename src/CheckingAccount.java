public class CheckingAccount extends Account {


    //Constructor
    public CheckingAccount(String name, int balance)
    {
    super(name, balance);

    }
    //no args constructor
    public CheckingAccount()
    {
    super();
    }

    //deposit money 
    public void deposit(int money)
    {
        balance += money; 
    } 

    //withdrawl
    public void withdraw(int money)
    {
        balance -= money; 
    } 

    public String print()
    {
        return "Account Name: " + name + "/n Account Balance: " + balance + "/n Account type: Checking Account";
    }
}
