import java.sql.SQLException;

public class Withdrawal extends Transaction {

    public Withdrawal(Account a, Double x, String s) throws SQLException {
        super (a, x, s);
        double amountUSD = currency.convertToDollar (amount) * -1;
        double amountEuro = Bank.Euro.convertFromDollar (amountUSD);
        double amountPound = Bank.Pound.convertFromDollar (amountUSD);
        double amountYen = Bank.Yen.convertFromDollar (amountUSD);
        DBConnect.addTransaction(transactionID, memo, date, account.getID(), amountEuro, amountPound, amountUSD, amountYen);
    }

    @Override
    public void updateBalance() {
        account.withdrawal (amount);
    }

    public static void main(String[] args)
    {

    }
}
