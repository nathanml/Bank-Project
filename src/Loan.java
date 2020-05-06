import java.sql.SQLException;
import java.util.Date;

public class Loan extends Service{
    //basic info
    protected int loanID;
    protected String memo;
    protected double interestRate; //interestPerDay 
    protected Clock dueDate;
    protected Clock lastPayDate;
    protected Account associatedAccount;
    //people
    protected Customer customer;
    protected String collateral;

    public Loan(Account acc, String name, int a, Currency c, Clock due, String col) throws SQLException {
        super(a, c);
        associatedAccount = acc;
        loanID = System.identityHashCode (this);
        this.memo = name;
        interestRate = Bank.getLoanRate();
        lastPayDate = purchasedDate;
        dueDate = due;
        collateral = col;
        customer = acc.getOwner();

        //For Database Connection
        double amountUSD = c.convertToDollar(a); //store value in USD
        double amountEuro = Bank.getEuro().convertFromDollar(amountUSD);
        double amountPound = Bank.getPound().convertFromDollar (amountUSD);
        double amountYen = Bank.getYen().convertFromDollar (amountUSD);
        DBConnect.addLoan(loanID, name, collateral, interestRate, customer.getID (), amountEuro, amountPound,
                amountUSD, amountYen, dueDate.getDate (), dueDate.getMonth (), dueDate.getYear (), associatedAccount.getID ());
    }

    public void diminish(int amount) {
    	initialValueUSD -= amount;
        Bank.getBankManager().collectMoney(interestOnService(0));
        lastPayDate = Bank.getCurrentTime(); //update lastPay
        close(); //check if the close condition is met 
    }

    public boolean diminishable(int amount) {
        return (initialValueUSD <= amount);
    }

    public void close() {
        if (closeCondition()) {
            customer.getLoans().remove(this);
        }
    }

    public boolean closeCondition() {
        return (initialValueUSD == 0);
    }

    
    public double interestOnService(int rate) {
        return Bank.getCurrentTime().dayDifference(lastPayDate) * interestRate * initialValueUSD;
    } 
    
    public String print() {
    	return "Amount: " + initialValueUSD + "Collateral: " + collateral;
    }

    /*
    * Return the number of days this loan is overdued, a negative number 
    * if this loan is not overdued. 
    */
    public int overDue(Clock currentTime) {
        int overdue = 0;
        if (currentTime.compareTo(dueDate) > 0) {
            overdue = currentTime.dayDifference(dueDate);
        } else {
            overdue = dueDate.dayDifference(currentTime);
        }
        return overdue;
    }

    public double getMoney() {
        return initialValueUSD;
    }

    public static void main(String[] args)
    {

    }
}
