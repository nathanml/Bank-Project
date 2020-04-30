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

    public Loan(String n, int a, int r, Currency cur, Date d, Customer c, String col)
    {
        loanID = System.identityHashCode (this);
        name = n;
        amount = a;
        interestRate = r;
        currency = cur;
        dueDate = d;
        customer = c;
        collateral = col;
    }

    public static void main(String[] args)
    {

    }
}
