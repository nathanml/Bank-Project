import java.util.Date;

public class Loan {
    protected int loanID;
    protected String name;
    protected double amount;
    protected double interestRate;
    protected Currency currency;
    protected Date dueDate;
    protected Customer customer;

    public Loan(String n, int a, int r, Currency cur, Date d, Customer c)
    {
        loanID = System.identityHashCode (this);
        name = n;
        amount = a;
        interestRate = r;
        currency = cur;
        dueDate = d;
        customer = c;
    }

    public static void main(String[] args)
    {

    }
}
