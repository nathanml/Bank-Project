import java.sql.SQLException;

public class CheckingAccount extends Account {

    //Constructor
    public CheckingAccount(String name, int balance, Currency c) throws SQLException {
        super(name, balance, c);
        double balanceUSD = currency.convertToDollar (balance);
        double balanceEuro = Bank.Euro.convertFromDollar (balanceUSD);
        double balancePound = Bank.Pound.convertFromDollar (balanceUSD);
        double balanceYen = Bank.Yen.convertFromDollar (balanceUSD);
        String type = "Checking";
        DBConnect.addAccount(accountID, name, owner.getID(),balanceEuro, balancePound, balanceUSD, balanceYen, type);
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
