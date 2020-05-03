import java.sql.SQLException;

public class SecuritiesAccount extends Account {

    public SecuritiesAccount(String name, double balance, Currency c) throws SQLException {
        super (name, balance, c);
        double balanceUSD = currency.convertToDollar (balance);
        double balanceEuro = Bank.Euro.convertFromDollar (balanceUSD);
        double balancePound = Bank.Pound.convertFromDollar (balanceUSD);
        double balanceYen = Bank.Yen.convertFromDollar (balanceUSD);
        String type = "Securities";
        DBConnect.addAccount(accountID, name, owner.getID(),balanceEuro, balancePound, balanceUSD, balanceYen, type);
    }

    public static void main(String[] args)
    {

    }
    public String print()
    {
        return "Account Name: " + name + ", Account Balance: " + balance + ", Account type: Securities Account";
    }
}
