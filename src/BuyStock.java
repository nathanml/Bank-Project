import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;


public class BuyStock extends JFrame implements ActionListener, ItemListener {
    protected SecuritiesAccount security;
    protected Customer customer;
    protected JPanel panel;
    private static JButton back;
    private static JLabel name;
    private static JTextField nameText;
    private static JLabel shares;
    private static JTextField sharesText;

    public BuyStock(Customer customer, SecuritiesAccount sa) {
        this.customer = customer;
        security = sa;
        panel = new JPanel ();
        panel.setLayout(new GridLayout(10,1));
        add(panel);
        setTitle ("StockMarket");
        setSize( 500, 500 );
        setLocation( 400, 100 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
    
    public void initialize() {
        panel.add(new JLabel("Available:"));
        panel.add(new JLabel(customer.getAvailableStock()));
        
        name= new JLabel("Enter Stock Name:");
        name.setBounds(10, 20, 200, 25);
        panel.add(name); 


        nameText = new JTextField();
        nameText.setBounds(150, 20, 165, 25);
        panel.add(nameText);


        shares= new JLabel("Number of shares:");
        shares.setBounds(10, 50, 200, 25);
        panel.add(shares);

        sharesText = new JTextField();
        sharesText.setBounds(150,50,165,25);
        panel.add(sharesText);

        JButton submit = new JButton ("Submit");
        submit.setBounds(10, 80, 80, 25);
        panel.add(submit);
        submit.addActionListener (new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText ();
                int numShares = Integer.parseInt (sharesText.getText());
                security.buy(name, numShares);
                //display the openings 
                JLabel openings= new JLabel("Openings Update:");
                openings.setBounds(10, 20, 200, 25);
                panel.add(openings);
                String[][] display = security.openingsSummary();
                JLabel overview= new JLabel("Stock Name/Number of Share/DOP");
                overview.setBounds(10, 20, 200, 25);
                panel.add(overview);
            
      
                for (int i = 0; i< display.length; i++) {
                    panel.add(new JLabel(display[i][0] + "      " + display[i][1] + "      " + display[i][2]));
                }
                
            }
        });
        JButton back = new JButton ("back");
        panel.add(back);

        back.addActionListener(new AccountInterface(customer, security));

        setVisible (true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        initialize();

    }

    public static void main(String[] args) throws SQLException
    {   
        
   }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        
    }
}
