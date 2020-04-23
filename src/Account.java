public abstract class Account {

    /*
    * Abstract class for various types of accounts. All accounts have a name, balance, and customer
    * */
    String name;
    int balance;
    //I think the customer should have the account. Not the account have the customer. 

    //Constructor
    public Account(String name, int balance)
    {
    this.name= name;
    this.balance= balance;

    }
    //no args constructor
    public Account()
    {
    this.name= "account";
    this.balance= 0;

    }
    //getters and setters
    public int getMoney()
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
   
}
