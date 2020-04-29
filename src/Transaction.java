import java.time.LocalDate;

public abstract class Transaction {
    protected Account account;
    protected LocalDate date;
    protected double amount;
    protected String memo;
    protected int transactionID;
    protected Currency currency;

    public Transaction(Account a, Double x, String s)
    {
        account = a;
        date = java.time.LocalDate.now();
        amount = x;
        memo = s;
        transactionID = java.lang.System.identityHashCode(this);
    }

    public abstract void updateBalance();

    public static void main(String[] args)
    {

    }
}
