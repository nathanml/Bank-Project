import java.util.Comparator;

public class LoanComparator implements Comparator<Customer> {
	public int compare(Customer x, Customer y) {
		return (int) (x.getLoan(new Dollar()) - y.getLoan(new Dollar()));
	}
}