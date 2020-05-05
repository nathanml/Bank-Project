
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class BankManager extends User {
	/*
	    * Class for the bank manager:
	    *       Can view customers and their accounts and transaction, stocks,
	    *       can charge fees, pay interest, and maintain stock market and
	    *       updating the price of each stock
	    * */

	
    public ArrayList<Customer> allClients;
    private int loanListLength;
    private double moneyEarned;
    
    
    public BankManager(String username, String password) {
        super(username, password);
        allClients = new ArrayList<Customer>();
        loanListLength = 0;
        moneyEarned = 0;
    }

    public boolean setBankTime(int date, int month, int year) {
        return Bank.getCurrentTime().setToFuture(date, month, year);
    }
    
    public void collectMoney(double cash) {
    	moneyEarned += cash;
    }
    
    public double getEarned() {
    	return moneyEarned;
    }
    public void addCustomer(Customer c) {
        allClients.add(c);
    }
    
    public void addLoan() {
    	loanListLength++;
    }
    /*
    * Customer's compareTo method order the largest savings amount
    * in the front. 
    */
    public ArrayList<Customer> inOrderOfSavings() {
         Collections.sort(allClients);
         return allClients;
    }

    public List<Customer> inOrderOfLoans() {
        ArrayList<Customer> orderOfLoan = new ArrayList<Customer>();
        Collections.sort(allClients, new LoanComparator());
        List<Customer> onLoan = new ArrayList<Customer>();
        try {
            onLoan = orderOfLoan.subList(0, loanListLength);
        } catch (IndexOutOfBoundsException e) { 
            System.out.println("Exception thrown : " + e); 
        } catch (IllegalArgumentException e) { 
            System.out.println("Exception thrown : " + e); 
        } 
        return onLoan;
    }


    public static void main(String[] args)
    {

    }
}