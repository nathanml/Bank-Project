public class Main {

    /*
    * Driver Class
    * */
	public static Bank b;
	public static BankManager bm;
	public static ManagerPortal mp;
	public static Customer customer;
	
    public static void main(String[] args) {
	// write your code here
        b = new Bank();
        bm = new BankManager("username", "password");
    	
    }
}
