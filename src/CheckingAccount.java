public class CheckingAccount extends Account {

    //Constructor
    public CheckingAccount(String name, int balance, Currency c)
    {
    super(name, balance, c);

    }

    //deposit money 
    public void deposit(int money)
    {
        balance += money; 
    } 

    //withdrawal
    public void withdrawal(int money)
    {
        balance -= money; 
    } 

    public String print()
    {
        return "Account Name: " + name + ", Account Balance: " + balance +  ", Account type: Checking Account";
    }
}
