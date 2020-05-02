import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATM extends JFrame {
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
        add(panel);
        setTitle ("Bank ATM");
        setSize( 500, 500 );
        setLocation( 400, 100 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        JButton acct = new JButton ("Open Account");
        acct.setBounds(10, 80, 80, 25);
        panel.add(acct);
        JButton removeAcc = new JButton("Remove Account");
        removeAcc.setBounds(10, 80, 80, 25);
        panel.add(removeAcc);
        JButton withdraw = new JButton("Withdraw");
        withdraw.setBounds(10, 80, 80, 25);
        panel.add(withdraw);
        JButton deposit = new JButton("Deposit");
        deposit.setBounds(10, 80, 80, 25);
        panel.add(deposit);
        ActionListener acctL = new CreateNewAccount (customer);
        acct.addActionListener (acctL);
        JButton loan = new JButton ("Request Loan");
        loan.setBounds(10, 90, 80, 25);
        panel.add(loan);
        RequestLoan loanL = new RequestLoan (customer);
        loan.addActionListener (loanL);
        JButton transaction = new JButton ("View Transactions");
        transaction.setBounds(10, 100, 80, 25);
        panel.add(transaction);
        TransactionListener transactionL = new TransactionListener ();
        transaction.addActionListener (transactionL);
        JButton balance = new JButton ("View Balances");
        balance.setBounds(10, 110, 80, 25);
        panel.add(balance);
        BalanceListener balanceL = new BalanceListener ();
        balance.addActionListener (balanceL);
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
        ATM driver= new ATM(customer);
        
    }
}
