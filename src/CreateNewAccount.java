import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateNewAccount extends JFrame implements ActionListener {
    protected Customer currentCustomer;
    protected JPanel panel;
    private static JButton back;

    public CreateNewAccount(Customer c)
    {
        currentCustomer = c;
        panel = new JPanel ();
        panel.setLayout(new GridLayout(10,1));
        add(panel);
        setTitle ("Create a new Account");
        setSize( 500, 500 );
        setLocation( 400, 100 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //ATM.setVisible( true );
        JButton checking = new JButton ("Create Checking Account");
        checking.setBounds(10, 20, 400, 25);
        panel.add(checking);

        ActionListener checkingL = new CreateNewCheckingAccount (currentCustomer);
        checking.addActionListener(checkingL);

        JButton savings = new JButton ("Create Savings Account");
        savings.setBounds(10, 50, 400, 25);
        panel.add(savings);

        ActionListener savingsL = new CreateNewSavingsAccount (currentCustomer);
        savings.addActionListener (savingsL);

        //JButton securities = new JButton ("Create Securities Account");
        //securities.setBounds(10, 80, 400, 25);
        //panel.add(securities);

        //ActionListener securitiesL = new CreateNewSecuritiesAccount (currentCustomer);
        //securities.addActionListener (securitiesL);

        back = new JButton ("back");
        back.setBounds(10, 110, 400, 25);
        panel.add(back);

        back.addActionListener(new ATM(currentCustomer));

        setVisible( true );

    }


    public static void main(String[] args)
    {

    }
}