import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ATM extends JFrame implements ActionListener {
    /*
    *  Customer Interface:
    *
    * Customer's can create accounts, request loans, view transactions and current balances
    *
    * */
    private Customer customer;
    private static JPanel panel;

    public ATM(Customer c)
    {
        customer = c;
        panel = new JPanel ();
        panel.setLayout(null);
        add(panel);
        setTitle ("Bank ATM");
        setSize( 500, 500 );
        setLocation( 400, 100 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
    
    public void initialize() {
        JButton newacct = new JButton ("Open new Account");
        newacct.setBounds(10, 20, 400, 25);
        panel.add(newacct);
        JButton viewacct = new JButton ("View Accounts");
        viewacct.setBounds(10, 50, 400, 25);
        panel.add(viewacct);

        
        ActionListener acctL = new CreateNewAccount(customer);
        newacct.addActionListener(acctL);
        
        ActionListener viewacctL = new viewAccounts(customer);
        viewacct.addActionListener(viewacctL);
        
        setVisible( true );
    }

    class TransactionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class BalanceListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public static void main(String[] args)
    {
        //for testing purposes only
        Customer customer= new Customer();
        //customer.addCheckingAccount(new CheckingAccount("check1", 200, new Currency("USD", 0.12)));
        try {
            customer.addCheckingAccount(new CheckingAccount("check1", 300, new Dollar()));
            customer.addCheckingAccount(new CheckingAccount("check2", 500, new Dollar()));
            customer.addSavingsAccount(new SavingsAccount("check3", 8900, new Dollar()));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("hheyy");
        }
        ATM driver= new ATM(customer);
        driver.initialize();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        initialize();
    }
}
