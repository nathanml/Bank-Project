import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AccountInterface extends JFrame implements ActionListener{

    private Customer currentCustomer;
    private static JPanel mainpanel;
    private static JPanel removeaccpanel;
    private static JButton back;
    private static Account account;

    
    public AccountInterface(Customer c, Account account){
        this.currentCustomer = c;
        this.account=account;
        mainpanel = new JPanel();
        mainpanel.setLayout(new GridLayout(10,1));
        add(mainpanel);
        setTitle ("Account Interface");
        setSize( 500, 500 );
        setLocation( 400, 100 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
    }
    
    public void initialize() {
        JButton removeAcc = new JButton("Remove Account");
        removeAcc.setBounds(10, 20, 400, 25);
        mainpanel.add(removeAcc);
        removeAcc.addActionListener (new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeaccount();
                ATM driver= new ATM(currentCustomer);
                driver.initialize();   
            }
            
        });
        
        JButton withdraw = new JButton("Withdraw");
        withdraw.setBounds(10, 50, 400, 25);
        mainpanel.add(withdraw);
        withdraw.addActionListener (new WithdrawFrame(currentCustomer, account));
        
        JButton deposit = new JButton("Deposit");
        deposit.setBounds(10, 80, 400, 25);
        mainpanel.add(deposit);
        deposit.addActionListener (new DepositFrame(currentCustomer, account));
        		
        JButton loan = new JButton ("Request Loan");
        loan.setBounds(10, 110, 400, 25);
        mainpanel.add(loan);
        loan.addActionListener (new LoanFrame(currentCustomer, account));
        
        JButton transaction = new JButton ("View Transactions");
        transaction.setBounds(10, 140, 400, 25);
        mainpanel.add(transaction);
        //transaction.addActionListener (new TransactionPortal(currentCustomer, account));
        
        JButton buystock = new JButton ("Buy Stocks");
        buystock.setBounds(10, 140, 400, 25);
        mainpanel.add(buystock);
        //buystock.addActionListener(new BuyStock(currentCustomer, (SecuritiesAccount)account));
        
        back = new JButton ("back");
        back.setBounds(10, 170, 400, 25);
        mainpanel.add(back);
        
        back.addActionListener(new viewAccounts(currentCustomer));
        
        setVisible(true);
    }
    public void removeaccount() {
    	Bank.chargeFee(account);
        
        //remove account
        if (currentCustomer.getCheckingAccounts().contains(account)) {
            currentCustomer.removeCheckingAccount((CheckingAccount) account);
        }else if (currentCustomer.getSavingsAccounts().contains(account)) {
            currentCustomer.removeSavingsAccount((SavingsAccount) account);
        }else if (currentCustomer.getSecuritiesAccounts().contains(account)) {
            currentCustomer.removeSecuritiesAccount((SecuritiesAccount) account);
        }
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        initialize();
        
    }
    
    
}

