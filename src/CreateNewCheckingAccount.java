import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateNewCheckingAccount extends CreateNewAccount implements ActionListener {
    private static JLabel name;
    private static JTextField nameText;
    private static JCheckBox currency;
    private static JLabel balance;
    private static JTextField balanceText;

    public CreateNewCheckingAccount(Customer customer) {
        super(customer);
        setTitle ("Create New Checking Account");

        name= new JLabel("Account Name:");
        name.setBounds(10, 20, 80, 25);
        panel.add(name);

        nameText = new JTextField();
        nameText.setBounds(100,20,165,25);
        panel.add(nameText);

        currency= new JCheckBox ("Currency");

        balance= new JLabel("Enter starting balance:");
        balance.setBounds(10, 20, 80, 25);
        panel.add(balance);

        balanceText = new JTextField();
        balanceText.setBounds(100,20,165,25);
        panel.add(balanceText);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameText.getText ();
        String currency = currencyText.getText ();
        int balance = Integer.parseInt (balanceText.getText());
        CheckingAccount a = new CheckingAccount (name, balance, currency);
        currentCustomer.addCheckingAccount (a);
        setVisible (true);
    }
}
