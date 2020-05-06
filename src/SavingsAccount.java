import java.sql.SQLException;

public class SavingsAccount extends Account {


    //Constructor
    public SavingsAccount(String name, Customer o, double b, Currency c) throws SQLException {
        super(name, o, b, c);
        double balanceUSD = c.convertToDollar(b);
        

        //For Database Connection
        double balanceEuro = Bank.getEuro().convertFromDollar (balanceUSD);
        double balancePound = Bank.getPound().convertFromDollar (balanceUSD);
        double balanceYen = Bank.getYen().convertFromDollar (balanceUSD);
        String type = "Savings";
        DBConnect.addAccount(accountID, name, owner.getID(),balanceEuro, balancePound, balanceUSD, balanceYen, type,
                dateOpened.getDate (), dateOpened.getMonth (), dateOpened.getYear ());

    }

    public SavingsAccount(int id, String n, double b, Clock opened, Customer own) throws SQLException {
        super(id,n,b,opened,own);
    }
   

    public double calcInterest() {
        double interest = 0;
        Clock currentTime = Bank.getCurrentTime();
        if ((currentTime.compareTo(dateOpened) > 0) && (getMoney() > Bank.savInterestBenchMark) {
            interest = currentTime.dayDifference(dateOpened) * Bank.getSavingsRate();
            deposit(interest);
        }
        return interest;
    }

    //overrid withdraw method in case the Customer is dealing stock
    //must maintain $2500 in account
    //public boolean withdraw(double amount) {
       
    //}

    public String print()
    {
        return "Account Name: " + name + ", Account Balance: " + balance;
    }
}
