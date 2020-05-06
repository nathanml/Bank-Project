import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class LoanFrame extends JFrame implements ActionListener{
	private static JTextField amountText;
	private static JTextField cText;
    private static JButton submit;
    private static JButton back;
    
    protected Customer currentCustomer;
    protected Account currentAccount;
    
    protected JPanel panel;
    
	public LoanFrame(Customer customer, Account a){
		this.currentCustomer= customer;
		this.currentAccount= a;
		setTitle("Loans");
		panel = new JPanel ();
		panel.setLayout(new GridLayout(10,1));
        add(panel);
        setSize( 500, 500 );
        setLocation( 400, 100 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	public void viewLoans()
    {
        //traverse through all loans
        int count=1;
        for(Loan loan:currentCustomer.getLoans()) {
            JLabel loanL= new JLabel("Loan " + count + ". "+ loan.print());
            panel.add(loanL); 
            count++;
        }
        //if no loans
        if (count==1) {
            JLabel loanL= new JLabel("You do not have any loans");
            panel.add(loanL); 
            
        }
            //get index number of account
            JLabel loanlabel= new JLabel("To request a loan, please enter the amount and collateral and click submit");
            panel.add(loanlabel);
            
            JLabel amountlabel= new JLabel("Amount:");
            panel.add(amountlabel);
            amountText = new JTextField();
            panel.add(amountText);
            
            JLabel clabel= new JLabel("Collateral:");
            panel.add(clabel);
            cText = new JTextField();
            panel.add(cText);
            
            //submit answer
            submit = new JButton ("Submit");
            panel.add(submit);

            submit.addActionListener (new ActionListener()
            {
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				//create loan and add to loan array list
    				int amountrnum= Integer.parseInt(amountText.getText());
    				String col= cText.getText();
    				Loan l = null;
					try {
						l = new Loan("loan", amountrnum, currentAccount.getCurrency(), currentAccount.getDateOpened(), col);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    	            currentCustomer.getLoans().add(l);
    	            //return to account interface
    	            AccountInterface go= new AccountInterface(currentCustomer, currentAccount);
    	            go.initialize();
    			}
            });
            
          //back button
            back = new JButton ("back");
            panel.add(back);
            
            back.addActionListener(new AccountInterface(currentCustomer, currentAccount));
        
        setVisible (true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		viewLoans();
		
	}
	
	
	
	
}
