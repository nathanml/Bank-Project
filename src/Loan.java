import java.sql.SQLException;
import java.util.Date;

public class Loan {
    //basic info
    protected int loanID;
    protected String memo;
    protected double amountUSD;
    protected double interestRate; //interestPerDay 
    //dates
    protected Clock startDate;
    protected Clock dueDate;
    //people
    protected Customer customer;
    protected String collateral;

    public Loan(String name, int a, Currency c, Clock due, Customer customer, String col) throws SQLException {
        loanID = System.identityHashCode (this);
        this.memo = name;
        amountUSD = c.convertToDollar(a); //store value in USD
        interestRate = Bank.getLoanRate();
   
        startDate = Bank.getCurrentTime();
        dueDate = due; 
        this.customer = customer;
        collateral = col;

        //For Database Connection
        double amountEuro = Bank.getEuro().convertFromDollar(amountUSD);
        double amountPound = Bank.getPound().convertFromDollar (amountUSD);
        double amountYen = Bank.getYen().convertFromDollar (amountUSD);
        DBConnect.addLoan(loanID, name, dueDate, collateral, interestRate, customer.getID (), amountEuro, amountPound,
                amountUSD, amountYen);
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

    public double totalInterest(Clock currentTime) {
        double interest = 0;
        if (currentTime.compareTo(startDate) > 0) {
            interest = currentTime.dayDifference(startDate) * interestRate;
        }
        return interest;
    }

    public double getAmount() {
        return amountUSD;
    }

    public static void main(String[] args)
    {

    }
}
