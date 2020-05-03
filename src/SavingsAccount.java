public class SavingsAccount extends Account {

    //Constructor
    public SavingsAccount(String name, int balance, Currency c)
    {
    super(name, balance, c);

    }
    //no args constructor
    public SavingsAccount(String name, double balance, Currency c)
    {
        super(name, balance, c);
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
        return "Account Name: " + name + ", Account Balance: " + balance + ", Account type: Savings Account";
    }
}
