import javax.swing.*;
import java.awt.Color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

public class CreateNewSavingsAccount extends CreateNewAccount implements ActionListener, ItemListener {
    private static JLabel name;
    private static JTextField nameText;
    private static Currency accountCurrency;
    private static JComboBox<Currency> currency;
    private static JLabel balance;
    private static JTextField balanceText;

    public CreateNewSavingsAccount(Customer customer) {
        super(customer);
        setTitle ("Create New Savings Account");
    }
    public void initialize() {
        name= new JLabel("Account Name:");
        name.setBounds(10, 20, 200, 25);
        panel.add(name);
        

        nameText = new JTextField();
        nameText.setBounds(150, 20, 165, 25);
        panel.add(nameText);

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
				accountCurrency= (Currency)cd.getSelectedItem();
			}
        });

        balance= new JLabel("Enter starting balance:");
        balance.setBounds(10, 50, 200, 25);
        panel.add(balance);

        balanceText = new JTextField();
        balanceText.setBounds(150,50,165,25);
        panel.add(balanceText);

        JButton submit = new JButton ("Submit");
        submit.setBounds(10, 80, 80, 25);
        panel.add(submit);
        submit.addActionListener (new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText ();
                double balance = Double.parseDouble (balanceText.getText ()) - Bank.getRemovalfee ();
                if(accountCurrency != null) {
                    SavingsAccount a = null;
                    try {
                        //create account
                        a = new SavingsAccount (name, currentCustomer, balance, accountCurrency);
                        currentCustomer.addSavingsAccount (a);
                    } catch (SQLException ex) {
                        ex.printStackTrace ();
                    }
                }
	          //return
                ATM driver= new ATM(currentCustomer);
                driver.initialize();
			}
        });
        JButton back = new JButton ("back");
        panel.add(back);
        
        back.addActionListener(new ATM(currentCustomer));
  
        setVisible (true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            initialize();

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        accountCurrency = (Currency) currency.getSelectedItem ();
    }

    public static void main(String[] args)
    {

    }
}
