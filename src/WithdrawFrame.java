
	import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.SQLException;

	public class WithdrawFrame extends JFrame implements ActionListener {

	    private Customer customer;
	    private static JPanel panel;
	    private static JLabel amount;
	    private static JTextField amountText;
	    private static Account account;
	    private static JButton back;

	    public WithdrawFrame(Customer c, Account a)
	    {
	        customer = c;
	        account=a;
	        panel = new JPanel ();
	        panel.setLayout(new GridLayout(10,1));
	        add(panel);
	        setTitle ("Withdraw");
	        setSize( 500, 500 );
	        setLocation( 400, 100 );
	        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    }
	    
	    public void initialize() {
	    	amount= new JLabel("Withdrawl Amount:");
	        amount.setBounds(10, 20, 200, 25);
	        panel.add(amount);
	        

	        amountText = new JTextField();
	        amountText.setBounds(150, 20, 165, 25);
	        panel.add(amountText);
	        
	        JButton submit = new JButton ("Submit");
	        submit.setBounds(10, 80, 80, 25);
	        panel.add(submit);
	        
	        submit.addActionListener (new ActionListener()
            {
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				int answernum= Integer.parseInt(amountText.getText());
    	            account.withdrawal(answernum);
    	            Bank.chargeFee(account);
    	            AccountInterface go= new AccountInterface(customer, account);
    	            go.initialize();
    			}
            });
	      //back button
            back = new JButton ("back");
            panel.add(back);
            
            back.addActionListener(new AccountInterface(customer, account));
	        
	        setVisible (true);
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        initialize();
	    }
	}
