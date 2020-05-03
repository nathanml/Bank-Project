import java.sql.SQLException;
import java.util.Date;

public class Loan {
    protected int loanID;
    protected String name;
    protected double amount;
    protected double interestRate;
    protected Currency currency;
    protected Date dueDate;
    protected Customer customer;
    protected String collateral;

    public Loan(String n, int a, int r, Currency cur, Date d, Customer c, String col) throws SQLException {
        loanID = System.identityHashCode (this);
        name = n;
        amount = a;
        interestRate = r;
        currency = cur;
        dueDate = d;
        customer = c;
        collateral = col;
        double amountUSD = currency.convertToDollar (amount);
        double amountEuro = Bank.Euro.convertFromDollar (amountUSD);
        double amountPound = Bank.Pound.convertFromDollar (amountUSD);
        double amountYen = Bank.Yen.convertFromDollar (amountUSD);
        DBConnect.addLoan(loanID, name, dueDate, collateral, interestRate, customer.getID (), amountEuro, amountPound,
                amountUSD, amountYen);
    }

    public static void main(String[] args)
    {

    }
}
