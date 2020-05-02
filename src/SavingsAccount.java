import java.sql.SQLException;

public class SavingsAccount extends Account {

    //Constructor
    public SavingsAccount(String name, int balance, Currency c) throws SQLException {
        super(name, balance, c);
        double balanceUSD = currency.convertToDollar (balance);
        double balanceEuro = Bank.Euro.convertFromDollar (balanceUSD);
        double balancePound = Bank.Pound.convertFromDollar (balanceUSD);
        double balanceYen = Bank.Yen.convertFromDollar (balanceUSD);
        String type = "Savings";
        DBConnect.addAccount(accountID, name, owner.getID(),balanceEuro, balancePound, balanceUSD, balanceYen, type);

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
        return "Account Name: " + name + "/n Account Balance: " + balance + "/n Account type: Savings Account";
    }
}
