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
    protected double removalfee= 1;

    //Constructor
    public Account(String name, double balance, Currency c) {
        this.name= name;
        this.balance= balance;
        currency = c;
        accountID = java.lang.System.identityHashCode(this);
    }
    //no-arg Constructor
    public Account() {
        name = "Account";
        balance = 0;
        currency = new Dollar(); //make Currency an abstract class and Dollar a subclass
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
    public Currency getCurrency() 
    {
        return currency;
    }
    public String getName()
    {
        return name; 
    } 
    public void setMoney(double money)
    {
        balance= money; 
    } 
    public void setName(String str)
    {
        name= str; 
    } 
    public void setRemovalfee(double money)
    {
        removalfee= money; 
    } 
    public double getRemovalfee()
    {
        return removalfee; 
    } 

    public int getID(){
        return accountID;
    }
    public abstract String print();
}

