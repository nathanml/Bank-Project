import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ViewSecuritiesAccount extends viewAccounts implements ActionListener {
    
    private static JTextField accountText;
    private static JButton submit;
    private static JButton back;
    
    public ViewSecuritiesAccount(Customer customer) {
        super(customer);
        setTitle ("View Securities Account");
    }
    
    public void viewAccounts()
    {
        //traverse through all checking accounts
        int count=1;
        int y=20;
        for(SecuritiesAccount securitiesAccount:currentCustomer.getSecuritiesAccounts()) {
            JLabel account= new JLabel(count + ". "+ securitiesAccount.print());
            account.setBounds(10, y, 500, 25);
            panel.add(account); 
            count++;
            y= y+30;
        }
        //if no accounts
        if (count==1) {
            JLabel account= new JLabel("You do not have any Securities accounts");
            account.setBounds(10, y, 400, 25);
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
            //add error checking
            submit = new JButton ("Submit");
            submit.setBounds(10, y + 60, 80, 25);
            panel.add(submit);
            
            submit.addActionListener (new ActionListener()
            {
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				int answernum= Integer.parseInt(accountText.getText())-1;
    	            SecuritiesAccount account= currentCustomer.getSecuritiesAccounts ().get(answernum);
    	            AccountInterface go= new AccountInterface(currentCustomer, account);
    	            go.initialize();
    			}
            });
            
        }
        
        setVisible (true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
        viewAccounts();
    }

}
