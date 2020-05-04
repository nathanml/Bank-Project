import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ViewCheckingAccount extends viewAccounts implements ActionListener {

    private static JTextField accountText;
    private static JButton submit;
    private static JButton back;
    private static boolean answer=false;
    
    public ViewCheckingAccount(Customer customer) {
        super(customer);
        setTitle ("View Checking Account");
    }
    
    public void viewAccounts()
    {
        //traverse through all checking accounts
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
            
            answer= true;
            submit.addActionListener(this);
        }
        
        setVisible (true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (answer) {
            answer=false;
            int answernum= Integer.parseInt(accountText.getText());
            CheckingAccount account= currentCustomer.getCheckingAccounts().get(answernum);
            AccountInterface go= new AccountInterface(currentCustomer, account);
            go.initialize();
        }else {
        viewAccounts();
        }
    }

}
