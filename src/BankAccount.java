public interface BankAccount {
	void deposit(double amount);
	boolean withdrawal(double amount);
	double getMoney();
	String getName();
	int getID();
	Clock getDateOpened();
}