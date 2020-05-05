import java.sql.SQLException;

public class CheckingAccount extends Account {

    //Constructor
    public CheckingAccount(String name, int b, Currency c) throws SQLException {
        super (name, c.convertToDollar(b), Bank.getCurrentTime());
        double balanceUSD = c.convertToDollar(b);
        
        //For Database Connection
        double balanceEuro = Bank.getEuro().convertFromDollar (balanceUSD);
        double balancePound = Bank.getPound().convertFromDollar (balanceUSD);
        double balanceYen = Bank.getYen().convertFromDollar (balanceUSD);
        String type = "Checking";
        //removed this line so I can test and run
        //DBConnect.addAccount(accountID, name, owner.getID(),balanceEuro, balancePound, balanceUSD, balanceYen, type);
    }

    public String print()
    {
        return "Account Name: " + name + ", Account Balance: " + balance +  ", Account type: Checking Account";
    }
}
