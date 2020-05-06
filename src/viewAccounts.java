import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class viewAccounts extends JFrame implements ActionListener{
	private static JLabel name;
    private static JTextField nameText;
    private static Currency accountCurrency;
    private static JComboBox<Currency> currency;
    private static JLabel balance;
    private static JTextField balanceText;
    private static JButton back;
    private static boolean initialize= true;
    
    protected Customer currentCustomer;
    protected Account currentAccount;
    
    protected JPanel panel;
    
	public viewAccounts(Customer customer){
		this.currentCustomer= customer;
		setTitle("View Accounts");
		panel = new JPanel ();
		panel.setLayout(new GridLayout(10,1));
		add(panel);
        setSize( 500, 500 );
        setLocation( 400, 100 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	public void initialize() {
		JButton checking = new JButton ("View Checking Accounts");
        checking.setBounds(10, 20, 400, 25);
        panel.add(checking);
        ActionListener checkingL = new ViewCheckingAccount (currentCustomer);
        checking.addActionListener (checkingL);

        
        JButton savings = new JButton ("View Savings Accounts");
        savings.setBounds(10, 50, 400, 25);
        panel.add(savings);
        ActionListener savingsL = new ViewSavingsAccount (currentCustomer);
        savings.addActionListener (savingsL);
        
        JButton securities = new JButton ("View Securities Accounts");
        securities.setBounds(10, 80, 400, 25);
        panel.add(securities);
        ActionListener securitiesL = new ViewSecuritiesAccount (currentCustomer);
        securities.addActionListener (securitiesL);
        
        back = new JButton ("back");
        back.setBounds(10, 110, 400, 25);
        panel.add(back);   
        back.addActionListener(new ATM(currentCustomer));
        
        setVisible( true );
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		initialize();
		
	}
	
}
