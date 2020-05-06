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
    //protected Customer owner;
    protected Clock dateOpened;
    protected Customer owner;
    protected Currency currency;

    //Constructor
    public Account(String name, double balance, Currency x) {
        this.name= name;
        this.balance= x.convertToDollar(balance);
        this.currency= x;
        accountID = java.lang.System.identityHashCode(this);
        dateOpened = Bank.getCurrentTime();
        //this.owner = owner;
    }
    //no-arg Constructor
    public Account() {
        name = "Account";
        balance = 0;
        accountID = java.lang.System.identityHashCode(this);
    }

    public Account(int id, String n, double b, Clock opened, Customer own)
    {
        accountID = id;
        name = n;
        balance = b;
        dateOpened = opened;
        owner = own;
    }
    public boolean equals(Account other) {
    	return (accountID == other.getID());
    }
    
    public void deposit(double amount)
    {
        balance += amount;
        
    }
    public void withdraw(double amount)
    {
        balance -= amount;
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
    
    public void setMoney(double money)
    {
    	if (money >= 0) {
    		balance = money;
    	}  
    } 
    
    public String getName()
    {
        return name; 
    } 
    
   
    public void setName(String str)
    {
        name= str; 
    } 

    public int getID(){
        return accountID;
    }
    
    public Currency getCurrency()
    {
        return currency; 
    } 
    
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
    //add transaction
    public void addTransaction(Transaction t)
    {
    	transactions.add(t);
    }
    public abstract String print();
}

