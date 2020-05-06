import java.sql.SQLException;

public class CheckingAccount extends Account {

    //Constructor
    public CheckingAccount(String name, int b, Currency c) throws SQLException {
        super (name, b, c);
        double balanceUSD = c.convertToDollar(b);
        
        //For Database Connection
        double balanceEuro = Bank.getEuro().convertFromDollar (balanceUSD);
        double balancePound = Bank.getPound().convertFromDollar (balanceUSD);
        double balanceYen = Bank.getYen().convertFromDollar (balanceUSD);
        String type = "Checking";
        DBConnect.addAccount(accountID, name, owner.getID(),balanceEuro, balancePound, balanceUSD, balanceYen, type);
    }

    public CheckingAccount(int id, String n, double b, Clock opened, Customer own)
    {
        super(id,n,b,opened,own);
    }
    
 
    public String print()
    {
        return "Account Name: " + name + ", Account Balance: " + balance;
    }
}
