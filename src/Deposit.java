import java.sql.SQLException;

public class Deposit extends Transaction{

    public Deposit(Account a, Double x, String s, Currency c) throws SQLException {
        super (a, x, s);
        double amountUSD = amount;
         Euro euro = new Euro();
        Pound pound = new Pound();
        Yen yen = new Yen();
        double amountEuro = euro.convertFromDollar(amountUSD);
        double amountPound = pound.convertFromDollar (amountUSD);
        double amountYen = yen.convertFromDollar (amountUSD);
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
