import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Account implements BankAccount {

    /*
    * Abstract class for various types of accounts. All accounts have a name, balance, and customer
    * */
    protected String name;
    protected double balance; //recorded in USD
    protected ArrayList<Transaction> transactions;
    protected int accountID;
    protected Customer owner;
    protected double removalfee= 1;
    protected Clock dateOpened;

    //Constructor
    public Account(String name, double balance, Clock open) {
        this.name= name;
        this.balance= balance;
        accountID = java.lang.System.identityHashCode(this);
        dateOpened = open;
    }
    //no-arg Constructor
    public Account() {
        name = "Account";
        balance = 0;
        accountID = java.lang.System.identityHashCode(this);
    }
    public boolean equals(Account other) {
        boolean equals = false;
        if (accountID == other.getID()) {
            equals = true;
        }
        return equals;
    }
    public void deposit(double amount)
    {
        balance += amount;
    }

    public Clock getDateOpened() {
        return dateOpened;
    }

    public boolean withdrawal(double amount)
    {   
        boolean withdrawed = false;
        if (amount > balance) {
            withdrawed = true;
            balance -= amount;
        }
        return withdrawed;
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
    public void setMoney(double money)
    {
        balance = money; 
    } 
    public void setName(String str)
    {
        name= str; 
    } 

    public int getID(){
        return accountID;
    }
    public abstract String print();
}

