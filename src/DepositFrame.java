
	import javax.swing.*;

	import java.awt.GridLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.SQLException;

	public class DepositFrame extends JFrame implements ActionListener {

	    private Customer customer;
	    private static JPanel panel;
	    private static JLabel amount;
	    private static JTextField amountText;
	    private static Account account;
	    private static JButton back;
	    private static Currency depositCurrency;
	    private static JComboBox<Currency> currency;

	    public DepositFrame(Customer c, Account a)
	    {
	        customer = c;
	        account=a;
	        panel = new JPanel ();
	        panel.setLayout(new GridLayout(10,1));
	        add(panel);
	        setTitle ("Deposit");
	        setSize( 500, 500 );
	        setLocation( 400, 100 );
	        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    }
	    
	    public void initialize() {
	    	amount= new JLabel("Deposit Amount:");
	        panel.add(amount);

	        amountText = new JTextField();
	        panel.add(amountText);
	        
	        JLabel curr= new JLabel("Choose a Currency:");
	        panel.add(curr);
	        Currency currencies[] = {new Euro(), new Pound(), new Dollar(), new Yen()};
	        currency = new JComboBox (currencies);
	        panel.add(currency);
	        currency.addActionListener(new ActionListener()
	        {
				@Override
				public void actionPerformed(ActionEvent e) {
					JComboBox cd= (JComboBox)e.getSource();
					depositCurrency= (Currency)cd.getSelectedItem();
				}
	        });
	        
	        JButton submit = new JButton ("Submit");
	        panel.add(submit);
	        
	        submit.addActionListener (new ActionListener()
            {
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				double answernum= Double.parseDouble(amountText.getText());
    				Transaction d= null;
					try {
						d = new Deposit(account, answernum, "withdrawl made", depositCurrency);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    	            d.updateBalance();
    	            account.addTransaction((Transaction)d);
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
