import java.sql.SQLException;

public class Withdrawal extends Transaction {

    public Withdrawal(Account a, Double x, String s) throws SQLException {
        super (a, x, s);
        double amountUSD = currency.convertToDollar (amount) * -1;
        double amountEuro = Bank.getEuro().convertFromDollar (amountUSD);
        double amountPound = Bank.getPound().convertFromDollar (amountUSD);
        double amountYen = Bank.getYen().convertFromDollar (amountUSD);
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
