import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TransactionPortal extends JFrame implements ActionListener {

    private static JButton back;
    
	private Account account;
	private Customer customer;
	public TransactionPortal(Customer customer, Account account) {
		this.customer= customer;
		this.account= account;
		setTitle ("Transactions");
		JPanel panel = new JPanel ();
		panel.setLayout(new GridLayout(10,1));
		add(panel);
        setSize( 500, 500 );
        setLocation( 400, 100 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		//traverse through all checking accounts
        int count=1;
        int y=20;
        for(Transaction t:account.getTransactions()) {
            JLabel tran= new JLabel(count + ". "+ t.toString());
            tran.setBounds(10, y, 500, 25);
            panel.add(tran); 
            count++;
            y= y+30;
        }
        if (count==1) {
        	JLabel an= new JLabel("No transactions");
        	panel.add(an);
        }
        back = new JButton ("back");
        back.setBounds(10, 170, 400, 25);
        panel.add(back);
        
        back.addActionListener(new viewAccounts(customer));
        
        setVisible(true);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
