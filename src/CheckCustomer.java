import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CheckCustomer extends JFrame implements ActionListener {
    private static JLabel name;
    private static JPanel panel;
    private static JTextField nameText;
    private static JButton submit;

    public CheckCustomer()
    {
        setTitle( "Check on a Customer" );
        setSize( 500, 500 );
        setLocation( 400, 100 );

        //create a panel
        panel= new JPanel();
        add(panel);
        panel.setLayout(null);

        //Add welcome text
        name= new JLabel("Check on a Customer");
        name.setBounds(10, 50, 80, 25);
        panel.add(name);

        nameText = new JTextField ();
        nameText.setBounds(100,80,165,25);
        panel.add(nameText);

        submit = new JButton ("Submit");
        submit.setBounds(10, 140, 80, 25);
        panel.add(submit);
        submit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = nameText.getText ();
        Customer c;
        try {
            c = DBConnect.getCustomer (username);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            c = new Customer();
        }
        if(c.getUsername ().equals ("user"))
        {
            panel.add(new JLabel ("That customer does not exist;"));
        }
        else{
            CustomerView cv = null;
            try {
                cv = new CustomerView (c);
            } catch (SQLException ex) {
                ex.printStackTrace ();
            }
            cv.setVisible(true);
        }
    }
}
