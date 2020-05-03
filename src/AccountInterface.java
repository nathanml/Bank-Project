import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AccountInterface extends JFrame{

	private Customer customer;
    private static JPanel panel;
    
    public AccountInterface(Customer c){
    	this.customer = c;
        panel = new JPanel();
        panel.setLayout(null);
        add(panel);
        setTitle ("Account Interface");
        setSize( 500, 500 );
        setLocation( 400, 100 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    	
    }
    
    public void initialize() {
    	JButton removeAcc = new JButton("Remove Account");
        removeAcc.setBounds(10, 20, 400, 25);
        panel.add(removeAcc);
        JButton withdraw = new JButton("Withdraw");
        withdraw.setBounds(10, 50, 400, 25);
        panel.add(withdraw);
        JButton deposit = new JButton("Deposit");
        deposit.setBounds(10, 80, 400, 25);
        panel.add(deposit);
        
        JButton loan = new JButton ("Request Loan");
        loan.setBounds(10, 110, 400, 25);
        panel.add(loan);
        
        RequestLoan loanL = new RequestLoan (customer);
        loan.addActionListener (loanL);
        
        JButton transaction = new JButton ("View Transactions");
        transaction.setBounds(10, 140, 400, 25);
        panel.add(transaction);
        
        //TransactionListener transactionL = new TransactionListener ();
        //transaction.addActionListener (transactionL);
        
        JButton balance = new JButton ("View Balances");
        balance.setBounds(10, 110, 80, 25);
        panel.add(balance);
        
        //BalanceListener balanceL = new BalanceListener ();
        //balance.addActionListener (balanceL);
        
        setVisible(true);
    }
	
}
