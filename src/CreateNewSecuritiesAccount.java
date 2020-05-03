import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreateNewSecuritiesAccount extends CreateNewAccount implements ActionListener, ItemListener {
	
    private static JLabel name;
    private static JTextField nameText;
    private static Currency accountCurrency;
    private static JComboBox<Currency> currency;
    private static JLabel balance;
    private static JTextField balanceText;
    private static boolean initialize= true;
    
    public CreateNewSecuritiesAccount(Customer customer) {
        super (customer);
        setTitle ("Create New Securities Account");
    }

    public void initialize() {

        name= new JLabel("Account Name:");
        name.setBounds(10, 20, 200, 25);
        panel.add(name);

        nameText = new JTextField();
        nameText.setBounds(150,20,165,25);
        panel.add(nameText);

        Currency currencies[] = {Bank.Euro, Bank.Pound, Bank.USD, Bank.Yen};
        currency = new JComboBox<> (currencies);

        balance= new JLabel("Enter starting balance:");
        balance.setBounds(10, 50, 200, 25);
        panel.add(balance);

        balanceText = new JTextField();
        balanceText.setBounds(150,50,165,25);
        panel.add(balanceText);

        JButton submit = new JButton ("Submit");
        submit.setBounds(10, 80, 80, 25);
        panel.add(submit);
        submit.addActionListener (this);
        
        setVisible (true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	if (initialize==true){
    		initialize();
    		initialize=false;
    	}else {
	        String name = nameText.getText ();
	        int balance = Integer.parseInt (balanceText.getText());
	        if(accountCurrency != null)
	        {
                SavingsAccount a = null;
                try {
                    a = new SavingsAccount (name, balance, accountCurrency);
                } catch (SQLException ex) {
                    ex.printStackTrace ();
                }
                currentCustomer.addSavingsAccount (a);
	        }
	    }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
    	accountCurrency = (Currency) currency.getSelectedItem ();
    }

    public static void main(String[] args) {

    }
}