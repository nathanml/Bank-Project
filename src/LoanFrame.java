import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class LoanFrame extends JFrame implements ActionListener{
	private static JTextField accountText;
    private static JButton submit;
    private static JButton back;
    
    protected Customer currentCustomer;
    protected Account currentAccount;
    
    protected JPanel panel;
    
	public LoanFrame(Customer customer){
		this.currentCustomer= customer;
		setTitle("View Accounts");
		panel = new JPanel ();
		panel.setLayout(null);
        add(panel);
        setSize( 500, 500 );
        setLocation( 400, 100 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	public void viewLoans()
    {
        //traverse through all loans
        int count=0;
        int y=20;
        for(CheckingAccount checkingAccount:currentCustomer.getCheckingAccounts()) {
            JLabel account= new JLabel(count + ". "+ checkingAccount.print());
            account.setBounds(10, y, 500, 25);
            panel.add(account); 
            count++;
            y= y+30;
        }
        //if no accounts
        if (count==0) {
            JLabel account= new JLabel("You do not have any checking accounts");
            account.setBounds(10, y, 80, 25);
            panel.add(account); 
            
            back = new JButton ("back");
            back.setBounds(10, y + 30, 80, 25);
            panel.add(back);
            
            back.addActionListener(new viewAccounts(currentCustomer));
            
        }else {
            //get index number of account
            JLabel account= new JLabel("Please enter the number of the account and submit");
            account.setBounds(10, y, 500, 25);
            panel.add(account);
            
            accountText = new JTextField();
            accountText.setBounds(10, y + 30, 165, 25);
            panel.add(accountText);
            
            //submit answer
            submit = new JButton ("Submit");
            submit.setBounds(10, y + 60, 80, 25);
            panel.add(submit);

            submit.addActionListener (new ActionListener()
            {
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				int answernum= Integer.parseInt(accountText.getText());
    	            CheckingAccount account= currentCustomer.getCheckingAccounts().get(answernum);
    	            AccountInterface go= new AccountInterface(currentCustomer, account);
    	            go.initialize();
    			}
            });
            
        }
        
        setVisible (true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		viewLoans();
		
	}
	
	
	
	
}
