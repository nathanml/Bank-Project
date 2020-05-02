import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Account {

    /*
    * Abstract class for various types of accounts. All accounts have a name, balance, and customer
    * */
    protected String name;
    protected double balance;
    protected Currency currency;
    protected ArrayList<Transaction> transactions;
    protected int accountID;
    protected Customer owner;
    //I think the customer should have the account. Not the account have the customer. 

    //Constructor
    public Account(String name, double balance, Currency c) {
        this.name= name;
        this.balance= balance;
        currency = c;
        accountID = java.lang.System.identityHashCode(this);
    }

    public void deposit(double amount)
    {
        balance += amount;
    }

    public void withdrawal(double amount)
    {
        if(amount > balance)
        {
            System.out.println("You cannot withdrawal more than " + balance + " dollars.");
        }
        else balance -= amount;
    }

    //getters and setters
    public double getMoney()
    {
        return balance; 
    } 
    public String getName()
    {
        return name; 
    } 
    public void setMoney(int money)
    {
        balance= money; 
    } 
    public void setName(String str)
    {
        name= str; 
    } 

    public abstract String print();

    public int getID(){
        return accountID;
    }
}
