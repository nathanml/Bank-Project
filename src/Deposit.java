import java.sql.SQLException;

public class Deposit extends Transaction{

    public Deposit(Account a, Double x, String s) throws SQLException {
        super (a, x, s);
        double amountUSD = currency.convertToDollar (amount);
        double amountEuro = Bank.Euro.convertFromDollar (amountUSD);
        double amountPound = Bank.Pound.convertFromDollar (amountUSD);
        double amountYen = Bank.Yen.convertFromDollar (amountUSD);
        DBConnect.addTransaction(transactionID, memo, date, account.getID(), amountEuro, amountPound, amountUSD, amountYen);
    }

    @Override
    public void updateBalance() {
        account.deposit (amount);
    }

    public static void main(String[] args)
    {

    }
}
