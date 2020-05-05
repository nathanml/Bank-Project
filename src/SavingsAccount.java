import java.sql.SQLException;

public class SavingsAccount extends Account {


    //Constructor
    public SavingsAccount(String name, int b, Currency c) throws SQLException {
        super(name, c.convertToDollar(b), Bank.getCurrentTime());
        double balanceUSD = c.convertToDollar(b);
        

        //For Database Connection
        double balanceEuro = Bank.getEuro().convertFromDollar (balanceUSD);
        double balancePound = Bank.getPound().convertFromDollar (balanceUSD);
        double balanceYen = Bank.getYen().convertFromDollar (balanceUSD);
        String type = "Savings";
        DBConnect.addAccount(accountID, name, owner.getID(),balanceEuro, balancePound, balanceUSD, balanceYen, type);

    }
   

    public double calcInterest(Clock currentTime) {
        double interest = 0;
        if (currentTime.compareTo(dateOpened) > 0) {
            interest = currentTime.dayDifference(dateOpened) * Bank.getSavingsRate();
        }
        return interest;
    }

    //overrid withdraw method in case the Customer is dealing stock
    //must maintain $2500 in account
    public boolean withdraw(double amount) {
       return true; //just for it to run
    }

    public String print()
    {
        return "Account Name: " + name + ", Account Balance: " + balance + ", Account type: Savings Account";
    }
}
